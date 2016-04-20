package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class testButtonLike extends androidSetup{


    private WebDriver web;
    private AndroidDriver<WebElement> android;

    @BeforeClass
    protected void setUp() throws MalformedURLException {
        super.setUp();
    }

    @Test
    public void testCall() throws Exception {

        Thread.sleep(4000);
        for (int i = 0; i < 50 ; i++) {
            buttonLike();buttonLike();buttonLike();buttonLike();buttonLike();buttonLike();buttonLike();buttonLike();buttonLike();
        }

    }

    @AfterClass //cierra automaticamente la sesión cuando acaba el test
    public void teardown(){
        //close the app
        android.quit();
    }
}
