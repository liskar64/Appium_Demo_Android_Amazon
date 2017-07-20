/**
 * Created by Ibermatica on 05/05/2017.
 */


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class appiumDemoTest {

    private AppiumDriver<WebElement> driver;
    public WebDriverWait wait ;


    @Before

    public void setup() throws MalformedURLException{


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","Xperia M2");
        capabilities.setCapability("platformVersion","5.1.1");
        capabilities.setCapability("browser_Name","Android");
     //   capabilities.setCapability("app","/Appium_Demo_Android_Amazon/src/apk/AppiumDemo.apk");
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        wait=new WebDriverWait(driver,60);
    };



    @Test

    public void login_no_ok() {


    String user = "";
    String pass = "";
    int vueltas = -1;

    do {
        vueltas++;
        if(vueltas < 4){
          driver.findElement(By.id("user")).clear();
          driver.findElement(By.id("pass")).clear();
          driver.findElements(By.id("alertMessage")).clear();
        }

        if (vueltas == 0) {
            user = "pepepotamo";
            pass = "pepepotamo";
        } else if (vueltas == 1){
            user = "";
            pass = "pepepotamo";
        } else if (vueltas == 2){
            user = "pepepotamo";
            pass = "";
        } else if (vueltas == 3){
            user = "";
            pass = "";
        }

        if(vueltas < 4){

            driver.findElement(By.id("user")).sendKeys(user);
            driver.findElement(By.id("pass")).sendKeys(pass);

            driver.findElement(By.id("btnLogin")).click();
            Assert.assertTrue(isElementPresent(By.id("alertMessage")));
        };


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

    } while (vueltas < 4);

     };
/*
    @After
    public void tearDown() throws Exception{
        driver.quit();
    }
*/
    public boolean isElementPresent(By by){
        try {
            driver.findElement(by);
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }


}
