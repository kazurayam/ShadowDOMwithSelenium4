package shadowdomwithselenium4;

import io.github.bonigarcia.seljup.BrowserBuilder;
import io.github.bonigarcia.seljup.BrowsersTemplate.Browser;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import shadowdomwithselenium4.pages.google.DownloadPage;
import shadowdomwithselenium4.pages.theinternet.ShadowDom;
import shadowdomwithselenium4.pages.watir.HomePage;

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

    @TestTemplate
    public void testShadowDomRootOnChromeDownloadPage(WebDriver driver) {
        driver.get("chrome://downloads/");
        final DownloadPage downloadPage = new DownloadPage ();
        assertEquals("ダウンロード", downloadPage.downloadPageHeaderText(driver));
        assertEquals("ダウンロード", downloadPage.googleDownloadPageHeaderText(driver));
        assertEquals("ダウンロード", downloadPage.pageHeaderTextUsingJScripExecutor(driver));
    }

    @TestTemplate
    public void testShadowDomWatir(WebDriver driver) {
        driver.get("http://watir.com/examples/shadow_dom.html");
        HomePage homePage = new HomePage();
        // assertEquals ("some text", homePage.getSomeText());
        assertEquals("some text", homePage.getShadowDomText(driver));
        assertEquals("nested text", homePage.getNestedShadowText(driver));
        assertEquals("nested text", homePage.getNestedText(driver));
        assertEquals("nested text", homePage.getNestedTextUsingJSExecutor(driver));
    }
}
