package shadowdomwithselenium4.pages.mattkenefick;

import org.openqa.selenium.By;
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
}
