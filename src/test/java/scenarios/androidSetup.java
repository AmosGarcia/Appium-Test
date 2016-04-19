package scenarios;


import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import sun.rmi.runtime.Log;


public class androidSetup {

    private String appPackage ="com.wumoo.byviruzz";
    private String appMainActivity ="com.wumoo.customyoutuber.activity.MainActivity";
    private WebDriver web;
    private AndroidDriver <WebElement> android;
    private String texto = "Uncharted!!!";

    @BeforeClass
    protected void setUp() throws MalformedURLException {
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("deviceName", "Galaxy S5");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "5.0");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appMainActivity);
//        capabilities.setCapability("appPackage", "com.whatsapp");
//        capabilities.setCapability("appActivity","com.whatsapp.Main");
//        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        android = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

    }

    @Test
    public void testCal() throws Exception {

        Thread.sleep(4000);
        System.out.println(android.currentActivity());
        android.findElement(By.id("com.wumoo.byviruzz:id/event_footer_commentButton")).click();
        android.getOrientation();
        sendText(texto);
        goBack();
        android.findElement(By.id("com.wumoo.byviruzz:id/event_footer_likeHeartButton")).click();

    }


    //Metodos del Test
    private void sendText(String text) {
        android.findElement(By.id("com.wumoo.byviruzz:id/event_view_comment_input")).sendKeys(text);
        android.findElement(By.id("com.wumoo.byviruzz:id/event_view_send_button")).click();

    }

    private void goBack(){
        android.findElement(By.id("com.wumoo.byviruzz:id/toolbar_goBackButton")).click();
    }

    protected void buttonLike(){

        android.findElement(By.id("com.wumoo.byviruzz:id/event_footer_likeHeartButton")).click();
    }

    private void eventImage(){

        android.findElement(By.id("com.wumoo.byviruzz:id/event_image")).click();
    }

    private void goToYoutube() {

        android.startActivity(appPackage, "com.wumoo.customyoutuber.activity.YoutubePlayerActivity");

    }

    private void goToHome() {

        android.startActivity("com.wumoo.byviruzz", "com.wumoo.customyoutuber.activity.TimelinerActivity");

    }

    private void goToPhoto() {

        android.startActivity("com.wumoo.byviruzz", "com.wumoo.customyoutuber.activity.YoutuberMessageActivity");

    }

    @AfterClass //cierra automaticamente la sesión cuando acaba el test
    public void teardown(){
        //close the app
        android.quit();
    }
}

