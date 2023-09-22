package shadowdomwithselenium4.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static setup.DriverManager.getDriver;

public class DownloadPage {

    public SearchContext expandRootElement (WebDriver driver, WebElement element) {
        JavascriptExecutor je = (JavascriptExecutor)driver;
        Object result = je.executeScript("return arguments[0].shadowRoot", element);
        SearchContext shadowRoot = (SearchContext)result;
        return shadowRoot;
    }

    public String pageHeaderTextUsingJScripExecutor (WebDriver driver) {
        WebElement downloadsManagerTag = driver.findElement(By.tagName("downloads-manager"));
        SearchContext shadowRoot1 = expandRootElement(driver, downloadsManagerTag);
        WebElement toolbar = shadowRoot1.findElement (By.id("toolbar"));
        SearchContext shadowRoot2 = expandRootElement(driver, toolbar);
        WebElement crToolbar = shadowRoot2.findElement(By.cssSelector("cr-toolbar"));
        SearchContext shadowRoot3 = expandRootElement(driver, crToolbar);
        return shadowRoot3.findElement (By.cssSelector("#leftSpacer > h1")).getText ();
    }

    public String downloadPageHeaderText (WebDriver driver) {
        WebElement downloadsManager = driver.findElement(By.tagName("downloads-manager"));
        SearchContext shadowRoot1 = downloadsManager.getShadowRoot();
        WebElement toolbar = shadowRoot1.findElement(By.id("toolbar"));
        SearchContext shadowRoot2 = toolbar.getShadowRoot ();
        WebElement crToolbar = shadowRoot2.findElement(By.cssSelector ("cr-toolbar"));
        SearchContext shadowRoot3 = crToolbar.getShadowRoot ();
        WebElement downloadsHeader = shadowRoot3.findElement(By.cssSelector ("#leftSpacer > h1"));
        return downloadsHeader.getText ();
    }

    public String googleDownloadPageHeaderText (WebDriver driver) {
        WebElement pageHeader = driver.findElement (By.tagName ("downloads-manager"))
                .getShadowRoot()
                .findElement(By.id("toolbar"))
                .getShadowRoot()
                .findElement(By.cssSelector("cr-toolbar"))
                .getShadowRoot()
                .findElement(By.cssSelector("#leftSpacer > h1"));
        return pageHeader.getText ();
    }

}
