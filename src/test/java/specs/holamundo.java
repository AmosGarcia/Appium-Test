package specs;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import scenarios.androidSetup;

import java.io.File;
import java.net.URL;

public class holamundo extends androidSetup {

    public void helloTest()
    {

        File appDir = new File("//home//user5//Android//Compile");
        File app = new File(appDir, "app1.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");
        //mandatory capabilities
        capabilities.setCapability("deviceName","Galaxy S5");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","5.0");
        capabilities.setCapability("appPackage","com.whatsapp");
        capabilities.setCapability("appActivity","com.whatsapp.Main");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
//        driver =  new AndroidDriver(new URL("http://10.9.11.192:4723/wd/hub"), capabilities);




//        String app_package_name = "com.treexor.user5.appiumproject2";
//        /*By userId = By.id(app_package_name + "amos_id");
//        By password = By.id(app_package_name + "user_password");
//        By showPassword = By.id(app_package_name + "show_password");*/
//        By login_Button = By.id(app_package_name + "button");
//
//        /*driver.findElement(userId).sendKeys("someone@testvagrant.com");
//        driver.findElement(password).sendKeys("testvagrant123");
//        driver.findElement(showPassword).click();*/
//        driver.findElement(login_Button).click();
    }

}
