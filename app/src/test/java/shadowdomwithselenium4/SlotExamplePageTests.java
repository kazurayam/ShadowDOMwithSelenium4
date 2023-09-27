package shadowdomwithselenium4;

import io.github.bonigarcia.seljup.BrowserBuilder;
import io.github.bonigarcia.seljup.BrowsersTemplate;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import shadowdomwithselenium4.pages.slotexample.SlotExamplePage;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlotExamplePageTests {

    private static Path htmlPath;

    @RegisterExtension
    static SeleniumJupiter seleniumJupiter = new SeleniumJupiter();

    @BeforeAll
    static void setup() {
        String[] args = {"--headless"};
        BrowsersTemplate.Browser chrome = BrowserBuilder.chrome().arguments(args).build();
        seleniumJupiter.addBrowsers(chrome);
        //Browser firefox = BrowserBuilder.firefox().build();
        //seleniumJupiter.addBrowsers(firefox);

        htmlPath = Paths.get(".").resolve("src/test/fixtures/view/slot-example.html");
    }

    @TestTemplate
    void testGetH1(WebDriver driver) throws Exception {
        String url = htmlPath.toFile().toURI().toURL().toExternalForm();
        driver.get(url);
        SlotExamplePage sep = new SlotExamplePage();
        String actual = sep.getH1(driver);
        assertEquals("HTML Slot Element Example", actual);
    }
}
