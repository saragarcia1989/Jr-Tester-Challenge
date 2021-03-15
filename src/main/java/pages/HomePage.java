package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class HomePage {

    private WebDriver driver;
    private By basePriceBox = By.id("BasePrice");
    private By pencilIcon = By.id("base-edit-icon");
    private By baseValueInput = By.id("base-value-input");
    private By basePriceCheckIcon = By.id("base-check-icon");
    private By totalPrice = By.xpath("//span[contains(@class,'font-bold')]");
    private By labelBox = By.id("ghost-label-input");
    private By labelValueInput = By.id("ghost-value-input");
    private By labelCheckIcon = By.id("ghost-check-icon");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void hoverOverBasePrice() {
        WebElement basePriceBox = driver.findElement(this.basePriceBox);

        Actions actions = new Actions(driver);
        actions.moveToElement(basePriceBox).perform();
    }

    public void clickPencilIcon() {
        driver.findElement(pencilIcon).click();

    }

    public void inputBasePriceValue(String value) {
        driver.findElement(baseValueInput).clear();
        driver.findElement(baseValueInput).sendKeys(value);

    }

    public void clickCheckIcon() {
        driver.findElement(basePriceCheckIcon).click();

    }

    public String getTotal() {
        return driver.findElement(totalPrice).getText();
    }

    public void enterNewLabel(String[] components) {

        driver.findElement(labelBox).click();
        driver.findElement(labelBox).clear();
        driver.findElement(labelBox).sendKeys(components[0]);
        driver.findElement(labelValueInput).clear();
        driver.findElement(labelValueInput).sendKeys(components[1]);
        driver.findElement(labelCheckIcon).click();

    }

    public void hoverOverComponent(String componentName) {

        WebElement component = driver.findElement(By.xpath("//*[text()[contains(.,'" + componentName + "')]]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(component).perform();
    }

    public void clickTrashIcon(String componentName) {

        List<WebElement> trashButtons = driver.findElements(By.xpath("//span[contains(@id,'thrash-icon')]"));

        WebElement component = driver.findElement(By.xpath("//*[text()[contains(.,'" + componentName + "')]]"));

        for (WebElement button : trashButtons) {
            if (button.isDisplayed() && component.isEnabled()) {
                button.click();
                break;
            }
        }
    }
}
