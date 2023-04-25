package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utilities;

import java.time.Duration;

public class LoginTest extends Utilities {
    //browser setup
    @Before
    public void setUp() {
        openBrowser("Chrome");
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //implicitly wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //enter username in the username field
        sendTextToElement(By.id("user-name"), "standard_user");

        //password in the password field
        sendTextToElement(By.id("password"), "secret_sauce");

        //finding the click button element
        clickOnElement(By.xpath("//input[@class='submit-button btn_action']"));

        //expected elemement text
        String expectedElement = "Products";
        //actual element
        String actualElement = getTextFromElement(By.xpath("//span[@class='title']"));
        Assert.assertEquals("Products", expectedElement, actualElement);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //enter username in the username field
        sendTextToElement(By.id("user-name"), "standard_user");

        //password in the password field
        sendTextToElement(By.id("password"), "secret_sauce");
        //finding the click button element
        clickOnElement(By.xpath("//input[@class='submit-button btn_action']"));

        //expected elemement text
        String expectedElement = "Products";
        //actual element
        String actualElement = getTextFromElement(By.xpath("//span[@class='title']"));
        Assert.assertEquals("Products", expectedElement, actualElement);

        //expected list size
        int expectedListSize = 6;
        int itemlist = driver.findElements(By.xpath("//div[@class='inventory_item']")).size();
        Assert.assertEquals("size of the product list is 6 ", expectedListSize, itemlist);


    }

    @After
    public void closeBrowser23() {
        closeBrowser();


    }

}
