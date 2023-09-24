package shadowdomwithselenium4;

import io.github.bonigarcia.seljup.BrowserBuilder;
import io.github.bonigarcia.seljup.BrowsersTemplate.Browser;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import shadowdomwithselenium4.pages.theinternet.ShadowDom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShadowDOMTests {

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
    void templateTest(WebDriver driver) {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java");
        assertThat(driver.getTitle().contains("Selenium WebDriver"));
    }

    @TestTemplate
    public void testShadowDom(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/shadowdom");
        final ShadowDom shadowDom = new ShadowDom ();
        assertEquals("Let's have some different text!", shadowDom.shadowTextOne(driver));
        System.out.println (shadowDom.shadowTextTwo(driver));
    }
}
