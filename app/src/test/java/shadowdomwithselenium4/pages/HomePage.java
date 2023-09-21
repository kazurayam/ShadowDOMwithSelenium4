package shadowdomwithselenium4.pages;

import static setup.DriverManager.getDriver;
import org.openqa.selenium.By;

public class HomePage {

    public String getSomeText() {
        return getDriver().findElement(By.cssSelector("#shadow_content > span")).getText();
    }
}
