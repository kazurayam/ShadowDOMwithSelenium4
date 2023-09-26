package shadowdomwithselenium4;

import io.github.bonigarcia.seljup.BrowserBuilder;
import io.github.bonigarcia.seljup.BrowsersTemplate.Browser;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import shadowdomwithselenium4.pages.googlechrome.DownloadPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleChromeDownloadPageTests {


    @RegisterExtension
    static SeleniumJupiter seleniumJupiter = new SeleniumJupiter();

    @BeforeAll
    static void setup() {
        Browser chrome = BrowserBuilder.chrome().build();
        seleniumJupiter.addBrowsers(chrome);
    }

    @TestTemplate
    public void testGetHeaderText(WebDriver driver) {
        driver.get("chrome://downloads/");
        DownloadPage downloadPage = new DownloadPage ();
        String actual = downloadPage.getPageHeaderText(driver);
        assertEquals("ダウンロード", actual);
    }

    @TestTemplate
    public void testGetHeaderTextUsingJScriptExecutor(WebDriver driver) {
        driver.get("chrome://downloads/");
        DownloadPage downloadPage = new DownloadPage ();
        String actual = downloadPage.getPageHeaderTextUsingJScriptExecutor(driver);
        assertEquals("ダウンロード", actual);
    }

}
