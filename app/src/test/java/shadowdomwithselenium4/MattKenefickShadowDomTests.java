package shadowdomwithselenium4;

import io.github.bonigarcia.seljup.BrowserBuilder;
import io.github.bonigarcia.seljup.BrowsersTemplate.Browser;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import shadowdomwithselenium4.pages.mattkenefick.SampleShadowDomPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testing https://mattkenefick.github.io/sample-shadow-dom/
 * by Matt Kenefick, which is explained in his articlee
 * https://medium.com/@mattkenefick/revisiting-shadow-dom-nested-items-dynamic-templates-shadowroot-ea5f50d72c23
 */
public class MattKenefickShadowDomTests {

    @RegisterExtension
    static SeleniumJupiter seleniumJupiter = new SeleniumJupiter();

    @BeforeAll
    static void setup() {
        Browser chrome = BrowserBuilder.chrome().build();
        seleniumJupiter.addBrowsers(chrome);
        //Browser firefox = BrowserBuilder.firefox().build();
        //seleniumJupiter.addBrowsers(firefox);
    }

    @TestTemplate
    void testGetHeaderText(WebDriver driver) {
        driver.get("https://mattkenefick.github.io/sample-shadow-dom/");
        SampleShadowDomPage page = new SampleShadowDomPage();
        String actual = page.getHeaderText(driver);
        assertEquals("Header lorem ipsum", actual);
    }

    @TestTemplate
    void testGetHeaderTextUsingJSExecutor(WebDriver driver) {
        driver.get("https://mattkenefick.github.io/sample-shadow-dom/");
        SampleShadowDomPage page = new SampleShadowDomPage();
        String actual = page.getHeaderTextUsingJSExecutor(driver);
        assertEquals("Header lorem ipsum", actual);
    }

    @TestTemplate
    void testGetNestedHeaderText(WebDriver driver) {
        driver.get("https://mattkenefick.github.io/sample-shadow-dom/");
        SampleShadowDomPage page = new SampleShadowDomPage();
        String actual = page.getHeaderText(driver);
        assertEquals("Header lorem ipsum", actual);
    }

}
