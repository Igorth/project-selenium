package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoBlazePage {

    WebDriver driver;

    By titleDemoBlaze = By.id("nava");

    public DemoBlazePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleDemonBlaze() {
        return driver.findElement(titleDemoBlaze).getText();
    }
}
