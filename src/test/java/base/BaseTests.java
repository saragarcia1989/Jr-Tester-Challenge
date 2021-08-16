package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");

        homePage = new HomePage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
