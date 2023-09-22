package shadowdomwithselenium4.pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShadowDom {

    public String shadowTextOne(WebDriver driver) {
        return driver.findElement(By.cssSelector(
                "#content > my-paragraph:nth-child(4) > span")).getText();
    }

    public String shadowTextTwo(WebDriver driver) {
        return driver.findElement(By.cssSelector(
                "#content > my-paragraph:nth-child(5) > ul:nth-child(1) > li")).getText();
    }
}