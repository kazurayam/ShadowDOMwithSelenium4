package shadowdomwithselenium4;


import io.github.bonigarcia.seljup.BrowserBuilder;
import io.github.bonigarcia.seljup.BrowsersTemplate.Browser;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import shadowdomwithselenium4.pages.googlechrome.DownloadPage;
import shadowdomwithselenium4.pages.theinternet.ShadowDom;
import shadowdomwithselenium4.pages.watir.HomePage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleChromeDownloadPageTests {


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
    public void testShadowDomRootOnChromeDownloadPage(WebDriver driver) {
        driver.get("chrome://downloads/");
        final DownloadPage downloadPage = new DownloadPage ();
        assertEquals("ダウンロード", downloadPage.downloadPageHeaderText(driver));
        assertEquals("ダウンロード", downloadPage.googleDownloadPageHeaderText(driver));
        assertEquals("ダウンロード", downloadPage.pageHeaderTextUsingJScripExecutor(driver));
    }

}
