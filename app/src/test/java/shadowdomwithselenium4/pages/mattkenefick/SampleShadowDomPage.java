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

    public String getHeader(WebDriver driver) {
        WebElement h3 = driver.findElement(By.cssSelector("main > my-input"))
                .getShadowRoot()
                .findElement(By.cssSelector("label > h3"));
        return h3.getText();
    }

    public String getHeaderUsingJSExecutor(WebDriver driver) {
        WebElement shadowHost1 = driver.findElement(By.cssSelector("main > my-input"));
        SearchContext shadowRoot1 = expandRootElement(driver, shadowHost1);
        WebElement h3 = shadowRoot1.findElement(By.cssSelector("label > h3"));
        return h3.getText();
    }

    public String getFieldsetLegend(WebDriver driver) {
        WebElement legend = driver.findElement(By.cssSelector("main > my-form"))
                .getShadowRoot()
                .findElement(By.cssSelector("form > fieldset > legend"));
        return legend.getText();
    }

    public String getNestedHeader(WebDriver driver) {
        WebElement h3 = driver.findElement(By.cssSelector("main > my-form"))
                .getShadowRoot()
                .findElement(By.cssSelector("form > fieldset > slot > my-input"))
                .getShadowRoot()
                .findElement(By.cssSelector("label > h3"));
        return h3.getText();
    }

    public String getNestedHeaderUsingJSExecutor(WebDriver driver) {
        WebElement shadowHost1 = driver.findElement(By.cssSelector("main > my-form"));
        SearchContext shadowRoot1 = expandRootElement(driver, shadowHost1);
        WebElement shadowHost2 = shadowRoot1.findElement(By.cssSelector("form > fieldset > my-input"));
        SearchContext shadowRoot2 = expandRootElement(driver, shadowHost2);
        WebElement h3 = shadowRoot2.findElement(By.cssSelector("label > h3"));
        return h3.getText();
    }

    public SearchContext expandRootElement (WebDriver driver, final WebElement element) {
        JavascriptExecutor je = (JavascriptExecutor)driver;
        Object result = je.executeScript ("return arguments[0].shadowRoot", element);
        return (SearchContext)result;
    }


}
