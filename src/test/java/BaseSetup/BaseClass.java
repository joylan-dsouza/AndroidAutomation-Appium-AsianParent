package BaseSetup;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static AndroidDriver<AndroidElement> driver;




    @BeforeSuite
    public void setup() {
        try {

            /*
            Setting capabilities for appium to recognize device & launch app
            PreRequiste : Install Asianparent Android app on device from playstore
             */
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "fe30e3f3");
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
            caps.setCapability("appPackage", "com.tickledmedia.ParentTown");
            caps.setCapability("appActivity", "com.theasianparent.app.MainActivity");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");

            driver = new AndroidDriver<AndroidElement>(url, caps);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Thread.sleep(5000);


        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }


/*
 quitting the driver session after test suite completion
 */
    @AfterSuite
    public void teardown() {
        // driver.close();
         driver.quit();
    }

}
