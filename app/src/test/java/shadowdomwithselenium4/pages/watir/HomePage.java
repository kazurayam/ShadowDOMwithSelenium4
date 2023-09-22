package shadowdomwithselenium4.pages.watir;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static setup.DriverManager.getDriver;

/**
 * @author Faisal Khatri
 * @since 8/19/2022
 * @revisedby kazurayam
 **/
public class HomePage {

    public SearchContext expandRootElement (WebDriver driver, final WebElement element) {
        JavascriptExecutor je = (JavascriptExecutor)driver;
        Object result = je.executeScript ("return arguments[0].shadowRoot", element);
        return (SearchContext)result;
    }

    public String getSomeText (WebDriver driver) {
        return driver.findElement(By.cssSelector("#shadow_content > span")).getText ();
    }

    public String getShadowDomText (WebDriver driver) {
        WebElement shadowHost = driver.findElement(By.id("shadow_host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        return shadowRoot.findElement(By.cssSelector("#shadow_content > span")).getText();
    }

    public String getNestedShadowText (WebDriver driver) {
        WebElement shadowHost = driver.findElement(By.id("shadow_host"));
        SearchContext shadowRoot1 = shadowHost.getShadowRoot ();
        WebElement shadowContent = shadowRoot1.findElement (By.cssSelector ("#nested_shadow_host"));
        SearchContext shadowRoot2 = shadowContent.getShadowRoot();
        return shadowRoot2.findElement(By.cssSelector("#nested_shadow_content > div")).getText ();
    }

    public String getNestedText (WebDriver driver) {
        final WebElement nestedText = driver.findElement(By.id("shadow_host"))
                .getShadowRoot()
                .findElement(By.cssSelector("#nested_shadow_host"))
                .getShadowRoot()
                .findElement(By.cssSelector("#nested_shadow_content > div"));
        return nestedText.getText();
    }

    public String getNestedTextUsingJSExecutor (WebDriver driver) {
        WebElement shadowHost = driver.findElement(By.id("shadow_host"));
        SearchContext shadowRootOne = expandRootElement(driver, shadowHost);
        WebElement nestedShadowHost = shadowRootOne.findElement(By.cssSelector ("#nested_shadow_host"));
        SearchContext shadowRootTwo = expandRootElement(driver, nestedShadowHost);
        return shadowRootTwo.findElement(By.cssSelector ("#nested_shadow_content > div"))
                .getText ();
    }
}