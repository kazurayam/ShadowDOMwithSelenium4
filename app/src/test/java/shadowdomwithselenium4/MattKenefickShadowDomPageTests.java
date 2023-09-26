package shadowdomwithselenium4;

import io.github.bonigarcia.seljup.BrowserBuilder;
import io.github.bonigarcia.seljup.BrowsersTemplate.Browser;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import shadowdomwithselenium4.pages.mattkenefick.SampleShadowDomPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testing https://mattkenefick.github.io/sample-shadow-dom/
 * by Matt Kenefick, which is explained in his articlee
 * https://medium.com/@mattkenefick/revisiting-shadow-dom-nested-items-dynamic-templates-shadowroot-ea5f50d72c23
 */
public class MattKenefickShadowDomPageTests {

    @RegisterExtension
    static SeleniumJupiter seleniumJupiter = new SeleniumJupiter();

    @BeforeAll
    static void setup() {
        String[] args = {"--headless"};
        Browser chrome = BrowserBuilder.chrome().arguments(args).build();
        seleniumJupiter.addBrowsers(chrome);
        //Browser firefox = BrowserBuilder.firefox().build();
        //seleniumJupiter.addBrowsers(firefox);
    }

    @TestTemplate
    void testGetHeader(WebDriver driver) {
        driver.get("https://mattkenefick.github.io/sample-shadow-dom/");
        SampleShadowDomPage page = new SampleShadowDomPage();
        String actual = page.getHeader(driver);
        assertEquals("Header lorem ipsum", actual);
    }

    @TestTemplate
    void testGetHeaderUsingJSExecutor(WebDriver driver) {
        driver.get("https://mattkenefick.github.io/sample-shadow-dom/");
        SampleShadowDomPage page = new SampleShadowDomPage();
        String actual = page.getHeaderUsingJSExecutor(driver);
        assertEquals("Header lorem ipsum", actual);
    }

    @TestTemplate
    void testGetFormLegend(WebDriver driver) {
        driver.get("https://mattkenefick.github.io/sample-shadow-dom/");
        SampleShadowDomPage page = new SampleShadowDomPage();
        String actual = page.getFormLegend(driver);
        assertEquals("MY FORM ELEMENT", actual);
    }

    @TestTemplate
    void testGetNestedHeader(WebDriver driver) throws InterruptedException {
        driver.get("https://mattkenefick.github.io/sample-shadow-dom/");
        SampleShadowDomPage page = new SampleShadowDomPage();
        String actual = page.getNestedHeader(driver);
        assertEquals("Header lorem ipsum", actual);
    }

    @TestTemplate
    void testGetNestedHeaderUsingJSExecutor(WebDriver driver) {
        driver.get("https://mattkenefick.github.io/sample-shadow-dom/");
        SampleShadowDomPage page = new SampleShadowDomPage();
        String actual = page.getNestedHeaderUsingJSExecutor(driver);
        assertEquals("Header lorem ipsum", actual);
    }

}
