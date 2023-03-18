package br.com.raffathamires.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver() {
        if(driver == null) {
            createDriver();
        }
        return driver;
    }

    private static void createDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:appPackage", "com.ctappium");
        desiredCapabilities.setCapability("appium:appActivity", "com.ctappium.MainActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\raffa\\Documents\\Cursos\\CursoAppium\\src\\main\\resources\\CTAppium_2_0.apk");

        try{
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void killDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
