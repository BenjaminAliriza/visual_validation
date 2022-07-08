package tests;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.SearchPage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {

    protected static WebDriver driver;
    protected static SearchPage page;
    protected static Eyes eyes;

    @BeforeClass
    public static void setUp(){
        Properties props = System.getProperties();
        try{
            props.load(new FileInputStream(new File("resources/test.properties")));
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
        
        driver = new ChromeDriver();
        initiateEyes();
        driver.get("C://Users//baliriza//Documents//Projects//visual_validation//resources//chromedriver.exe");
        page = new SearchPage(driver);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    private static void initiateEyes(){
        eyes=new Eyes();
        eyes.setApiKey(System.getProperty("applitools.api.key"));
    }

}
