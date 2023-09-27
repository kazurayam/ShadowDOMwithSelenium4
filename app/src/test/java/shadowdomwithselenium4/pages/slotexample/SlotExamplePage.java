package shadowdomwithselenium4.pages.slotexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object class for the sample code presented in a Stackoverflow discussion:
 * https://stackoverflow.com/questions/67068455/how-can-i-access-the-unamed-slot-content-in-web-components
 */
public class SlotExamplePage {

    public String getH1(WebDriver driver) {
        WebElement h1 = driver.findElement(By.cssSelector("h1"));
        return h1.getText();
    }
}
