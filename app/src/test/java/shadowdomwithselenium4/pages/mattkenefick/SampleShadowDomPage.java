package shadowdomwithselenium4.pages.mattkenefick;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * "Revisiting Shadow DOM: Nested items, dynamic templates, shadowRoot", Matt Kenefick
 * The page URL: https://mattkenefick.github.io/sample-shadow-dom/
 *
 * https://medium.com/@mattkenefick/revisiting-shadow-dom-nested-items-dynamic-templates-shadowroot-ea5f50d72c23
 *
 * https://github.com/mattkenefick/sample-shadow-dom
 */
public class SampleShadowDomPage {

    public String getHeaderText(WebDriver driver) {
        WebElement h3 = driver.findElement(By.cssSelector("main > my-input"))
                .getShadowRoot()
                .findElement(By.cssSelector("label > h3"));
        return h3.getText();
    }

    public String getHeaderTextUsingJSExecutor(WebDriver driver) {
        WebElement shadowHost = driver.findElement(By.cssSelector("main > my-input"));
        SearchContext shadowRoot1 = expandRootElement(driver, shadowHost);
        WebElement h3 = shadowRoot1.findElement(By.cssSelector("label > h3"));
        return h3.getText();
    }

    public SearchContext expandRootElement (WebDriver driver, final WebElement element) {
        JavascriptExecutor je = (JavascriptExecutor)driver;
        Object result = je.executeScript ("return arguments[0].shadowRoot", element);
        return (SearchContext)result;
    }

    public String getNestedHeaderText(WebDriver driver) {
        WebElement h3 = driver.findElement(By.cssSelector("main > my-form"))
                .getShadowRoot()
                .findElement(By.cssSelector("my-input"))
                .getShadowRoot()
                .findElement(By.cssSelector("label > h3"));
        return h3.getText();
    }
}
