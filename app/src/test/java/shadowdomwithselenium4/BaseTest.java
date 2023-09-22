package shadowdomwithselenium4;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static setup.DriverManager.createDriver;
import static setup.DriverManager.quitDriver;

public class BaseTest {

    @BeforeAll
    //@Parameters({"browser"})
    public void setupTest (final String browser) {
        createDriver(browser);
    }

    @AfterAll
    public void tearDown () {
        quitDriver ();
    }

}