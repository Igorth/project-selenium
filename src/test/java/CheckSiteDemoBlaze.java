import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.DemoBlazePage;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CheckSiteDemoBlaze {

    private final String baseURL = "https://www.demoblaze.com/index.html";
    private final String driverPath = "src/test/resources/chromedriver";

    private WebDriver driver;

    private DemoBlazePage mainPage;

    @BeforeAll
    public void setup() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public void tearDown() {
        driver.close();
    }

    @Test
    @DisplayName("When opening Demo Blaze page, then find the title 'PRODUCT STORE' of the present page.")
    public void checkHomePage() {
        driver.get(baseURL);
        String titleExpected = "PRODUCT STORE";
        String titleFound = "";

        mainPage = new DemoBlazePage(driver);
        titleFound = mainPage.getTitleDemonBlaze();

        System.out.println(titleFound);

        assertThat(titleFound, containsString(titleExpected));

    }
}
