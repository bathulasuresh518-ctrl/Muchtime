package mobileAutomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MobileTests {

    AndroidDriver driver;

    @SuppressWarnings("deprecation")
	@Test
    public void launchApp() throws MalformedURLException {
        
    	AppiumDriverLocalService server= new AppiumServiceBuilder()
    			.withAppiumJS(new File("C:\\Users\\Suresh Bathula\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")) // path to Appium JS
    	        .withIPAddress("127.0.0.1")
    	        .usingPort(4723)
    	        .build();

    	server.start();
    	
    	
    	UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
               // .setDeviceName("emulator-5554")
                .setUdid("d6290b7f")
                .setAutomationName("UiAutomator2")
                .setAppPackage("package:in.amazon.mShop.android.shopping");
                //.setApp("C:\\Users\\Suresh Bathula\\Downloads\\mda-androidTest-2.2.0-25.apk\"")
                //.setApp("C:\\Users\\Suresh Bathula\\eclipse-workspace\\artifact\\resources\\ApiDemos-debug.apk"); // Uncomment this if testing a specific app

                // You can add .setAppPackage("com.example") and .setAppActivity(".MainActivity") for installed apps

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        
        
        
        Activity activity=new Activity("com.instagram.android", "com.instagram.mainactivity.InstagramMainActivity");
        driver.startActivity(activity);

        // Now your mobile app / emulator should launch!

        // Quit driver after test
        driver.quit();
    }
}
