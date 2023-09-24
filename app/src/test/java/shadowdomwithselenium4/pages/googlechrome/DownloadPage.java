package shadowdomwithselenium4.pages.googlechrome;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DownloadPage {

    public String getPageHeaderText(WebDriver driver) {
        WebElement downloadsHeader = driver
                .findElement(By.tagName("downloads-manager"))
                .getShadowRoot()
                .findElement(By.id("toolbar"))
                .getShadowRoot()
                .findElement(By.cssSelector("cr-toolbar"))
                .getShadowRoot()
                .findElement(By.cssSelector("#leftSpacer > h1"));
        return downloadsHeader.getText ();
    }

    public String getPageHeaderTextUsingJScriptExecutor(WebDriver driver) {
        WebElement downloadsManagerTag = driver.findElement(By.tagName("downloads-manager"));
        SearchContext shadowRoot1 = expandRootElement(driver, downloadsManagerTag);
        WebElement toolbar = shadowRoot1.findElement (By.id("toolbar"));
        SearchContext shadowRoot2 = expandRootElement(driver, toolbar);
        WebElement crToolbar = shadowRoot2.findElement(By.cssSelector("cr-toolbar"));
        SearchContext shadowRoot3 = expandRootElement(driver, crToolbar);
        WebElement h1 = shadowRoot3.findElement (By.cssSelector("#leftSpacer > h1"));
        return h1.getText ();
    }

    public SearchContext expandRootElement (WebDriver driver, WebElement element) {
        JavascriptExecutor je = (JavascriptExecutor)driver;
        Object result = je.executeScript("return arguments[0].shadowRoot", element);
        SearchContext shadowRoot = (SearchContext)result;
        return shadowRoot;
    }
}
