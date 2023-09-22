package shadowdomwithselenium4;

import org.junit.jupiter.api.Test;
import shadowdomwithselenium4.pages.google.DownloadPage;
import shadowdomwithselenium4.pages.theinternet.ShadowDom;
import shadowdomwithselenium4.pages.watir.HomePage;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static setup.DriverManager.getDriver;

public class ShadowDomTests extends BaseTest {

    @Test
    public void testShadowDom () {
        WebDriver driver = getDriver();
        driver.get ("https://the-internet.herokuapp.com/shadowdom");
        final ShadowDom shadowDom = new ShadowDom ();
        assertEquals (shadowDom.shadowTextOne(driver), "Let's have some different text!");
        System.out.println (shadowDom.shadowTextTwo(driver));
    }

    @Test
    public void testShadowDomRootOnChromeDownloadPage () {
        WebDriver driver = getDriver();
        driver.get ("chrome://downloads/");
        final DownloadPage downloadPage = new DownloadPage ();
        assertEquals (downloadPage.downloadPageHeaderText(driver), "Downloads");
        assertEquals (downloadPage.googleDownloadPageHeaderText(driver), "Downloads");
        assertEquals (downloadPage.pageHeaderTextUsingJScripExecutor(driver), "Downloads");
    }

    @Test
    public void testShadowDomWatir () {
        WebDriver driver = getDriver();
        driver.get ("http://watir.com/examples/shadow_dom.html");
        final HomePage homePage = new HomePage();
        // assertEquals ("some text", homePage.getSomeText());
        assertEquals("some text", homePage.getShadowDomText(driver));
        assertEquals("nested text", homePage.getNestedShadowText(driver));
        assertEquals("nested text", homePage.getNestedText(driver));
        assertEquals("nested text", homePage.getNestedTextUsingJSExecutor(driver));
    }
}