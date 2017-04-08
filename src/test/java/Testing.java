import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Bhavana on 06.04.17.
 */
public class Testing {

    AppiumDriver driver;

    @Before
    public void setup() throws MalformedURLException {

        DesiredCapabilities capabilities=new DesiredCapabilities();

        //capabilities.setCapability("deviceName", "LG_Nexus_5X_real");
        capabilities.setCapability("testobject_device", "LG_Nexus_5X_real");
        capabilities.setCapability("testobject_api_key", "<<api-key>>");
        capabilities.setCapability(CapabilityType.PLATFORM,"Android");
        capabilities.setCapability("platformVersion","5");

        File file = new File("/home/balu/Desktop","ShopList_1.7.0.5.apk");
        capabilities.setCapability("app", file.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://appium.testobject.com/wd/hub"), capabilities);
        //driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void teardown()
    {

        driver.quit();

    }

    @Test
    public void main_test()
    {
        // writing item 1 and adding to list
        MobileElement item1= (MobileElement) (new WebDriverWait(driver,2)).until(ExpectedConditions.presenceOfElementLocated(By.id("org.openintents.shopping:id/autocomplete_add_item")));
        item1.sendKeys("item1");

        MobileElement add1 = (MobileElement) driver.findElement(By.id("org.openintents.shopping:id/button_add_item"));
        add1.click();


        //click on item1 to edit the item quantity
        MobileElement edit_item1 = (MobileElement) driver.findElement(By.id("org.openintents.shopping:id/name"));
        edit_item1.click();

        //edit quantity

        MobileElement qt_item1= (MobileElement) (new WebDriverWait(driver,2)).until(ExpectedConditions.presenceOfElementLocated(By.id("org.openintents.shopping:id/editquantity")));
        qt_item1.sendKeys("5");

        //edit units

        MobileElement unit_item1= (MobileElement) (new WebDriverWait(driver,2)).until(ExpectedConditions.presenceOfElementLocated(By.id("org.openintents.shopping:id/editunits")));
        unit_item1.sendKeys("1");


        //edit price

        MobileElement price_item1= (MobileElement) (new WebDriverWait(driver,2)).until(ExpectedConditions.presenceOfElementLocated(By.id("org.openintents.shopping:id/editprice")));
        price_item1.sendKeys("20");

        //click on OK

        MobileElement ok_button = (MobileElement) driver.findElement(By.id("android:id/button1"));
        ok_button.click();


        // writing item 2 and adding to list
        MobileElement item2= (MobileElement) (new WebDriverWait(driver,2)).until(ExpectedConditions.presenceOfElementLocated(By.id("org.openintents.shopping:id/autocomplete_add_item")));
        item2.sendKeys("item2");

        MobileElement add2 = (MobileElement) driver.findElement(By.id("org.openintents.shopping:id/button_add_item"));
        add2.click();


        //end


    }

}
