package scenarios;


import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import sun.rmi.runtime.Log;


public class androidSetup {

    private String appPackage = "com.wumoo.byviruzz";
    private String appMainActivity = "com.wumoo.customyoutuber.activity.MainActivity";
    Dimension size;
    private AndroidDriver<WebElement> android;
    private String texto = "";
    private String scroll = "com.wumoo.byviruzz:id/event_txtEventDescription";

    @BeforeClass  //Detecta el dispositivo antes de lanzar
    protected void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("deviceName", "Galaxy S5");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "5.0");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appMainActivity);
        android = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);


    }

    @Test  //Lazar Test
    public void testCall() throws Exception {


        Thread.sleep(4000);
        android.findElement(By.id("com.wumoo.byviruzz:id/event_footer_commentButton")).click();
        Thread.sleep(4000);
        sendText(texto);
        goBack();
        addLike();
        swipe();

    }


    //Metodos del Test
    protected void sendText(String text) {
        android.findElement(By.id("com.wumoo.byviruzz:id/event_view_comment_input")).sendKeys(text);
        android.findElement(By.id("com.wumoo.byviruzz:id/event_view_send_button")).click();

    }

    protected void swipe() {

        size = android.manage().window().getSize();
        int startx = (int) (size.width * 0.70);
        int endx = (int) (size.width * 0.30);
        int starty = size.height / 2;
        System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);
        android.swipe(startx, starty, endx, starty, 3000);
    }

    protected void goBack() {

        android.findElement(By.id("com.wumoo.byviruzz:id/toolbar_goBackButton")).click();
    }

    protected void buttonLike() {

        android.findElement(By.id("com.wumoo.byviruzz:id/event_footer_likeHeartButton")).click();
    }

    protected void eventImage() {

        android.findElement(By.id("com.wumoo.byviruzz:id/event_image")).click();
    }

    protected void goToYoutube() {

        android.startActivity(appPackage, "com.wumoo.customyoutuber.activity.YoutubePlayerActivity");

    }

    protected void goToHome() {

        android.startActivity("com.wumoo.byviruzz", "com.wumoo.customyoutuber.activity.TimelinerActivity");

    }

    protected void goToPhoto() {

        android.startActivity("com.wumoo.byviruzz", "com.wumoo.customyoutuber.activity.YoutuberMessageActivity");

    }

    protected void removeAds() {

//        android.findElement(By.id("com.wumoo.byviruzz:id/fbAdCloseLink")).click();
        android.tap(1, 1020, 1782, 1000);
    } // NO FUNCIONA

    protected void addLike() {

        android.findElement(By.id("com.wumoo.byviruzz:id/event_footer_likeHeartButton")).click();
    }

    protected void scrollTo(String scroll) {

        android.scrollTo(scroll);
    }

    @AfterClass //cierra automaticamente la sesión cuando acaba el test
    public void teardown() {
        //close the app
        android.quit();
    }
}

