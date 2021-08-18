package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class HomePage {

    private WebDriver driver;
    private By basePriceBox = By.id("BasePrice");
    private By BasePricePencilIcon = By.id("base-edit-icon");
    private By baseValueInput = By.id("base-value-input");
    private By basePriceCheckIcon = By.id("base-check-icon");
    private By totalPrice = By.xpath("//span[contains(@class,'font-bold')]");
    private By labelBox = By.id("ghost-label-input");
    private By editLabelBox = By.xpath("//*[contains(@id, 'label-input')][not(contains(@id, 'ghost-label-input'))]");
    private By labelValueInput = By.id("ghost-value-input");
    private By labelCheckIcon = By.id("ghost-check-icon");
    private By componentPrice = By.xpath("//ul/div/div/div[contains(@class, 'text-right')]");
    private By trashIcon = By.xpath("//span[contains(@id,'thrash-icon')]");
    private By editPencilIcon = By.xpath("//span[contains(@id, 'edit-icon')]");
    private By editCheckIcon = By.xpath("//span[contains(@id, 'check-icon')]");
    private By warningMessage = By.tagName("p");
    private By priceBox = By.cssSelector("input[type='number']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void hoverOverBasePrice() {
        WebElement basePriceBox = driver.findElement(this.basePriceBox);

        Actions actions = new Actions(driver);
        actions.moveToElement(basePriceBox).perform();
    }

    public void clickBasePricePencilIcon() {
        driver.findElement(BasePricePencilIcon).click();

    }

    public void inputBasePriceValue(String value) {
        driver.findElement(baseValueInput).clear();
        driver.findElement(baseValueInput).sendKeys(value);

    }

    public void clickCheckIcon() {
        driver.findElement(basePriceCheckIcon).click();

    }

    public void clickEditCheckIcon() {

        List<WebElement> checkButton = driver.findElements(editCheckIcon);
        for (WebElement button : checkButton) {
            if (button.isDisplayed()) {
                button.click();
                break;
            }
        }
    }

    public double getTotal() {

        String amount = driver.findElement(totalPrice).getText();
        double total = Double.parseDouble(amount);
        System.out.println(total);
        return total;
    }

    /**
     * This method rounds the price of each component and returns the sum of them.
     *
     * @return
     */
    public double sumOfComponents() {

        double total = 0.0;
        List<WebElement> prices = driver.findElements(componentPrice);

        for (WebElement price : prices) {
            String text = price.getText();
            double d = Double.parseDouble(text);

            total += d;

        }
        BigDecimal bd = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);

        double val2 = bd.doubleValue();

        return val2;
    }

    public List<Double> getPrices() {

        List<Double> list = new ArrayList<>();
        double priceDouble;
        List<WebElement> prices = driver.findElements(componentPrice);

        for (WebElement price : prices) {
            String text = price.getText();
            priceDouble = Double.parseDouble(text);
            list.add(priceDouble);
        }
        return list;
    }

    public List<String> getPricesString() {

        List<String> list = new ArrayList<>();
        List<WebElement> prices = driver.findElements(componentPrice);

        for (WebElement price : prices) {
            String priceText = price.getText();
            list.add(priceText);
        }
        return list;
    }


    public double sumPrices(List<Double> list) {

        double sum = list.stream().mapToDouble(Double::doubleValue).sum();

        return sum;

    }

    public void enterNewLabel(ComponentObject componentObject) {

        //    Click on label input (left)
        driver.findElement(labelBox).click();
        driver.findElement(labelBox).clear();
        //    Enter new label
        driver.findElement(labelBox).sendKeys(componentObject.getComponentName());
        //    Click on value input (right)
        driver.findElement(labelValueInput).clear();
        //    Enter new value
        driver.findElement(labelValueInput).sendKeys(componentObject.getComponentPrice());
        //    Click on ‘Check’ icon
        driver.findElement(labelCheckIcon).click();

    }

    public void editLabel(ComponentObject componentObject) {
        driver.findElement(editLabelBox).click();
        driver.findElement(editLabelBox).clear();
        driver.findElement(editLabelBox).sendKeys(componentObject.getComponentName());
    }

    public void editPrice(ComponentObject componentObject) {

        driver.findElement(priceBox).click();
        driver.findElement(priceBox).clear();
        driver.findElement(priceBox).sendKeys(componentObject.getComponentPrice());
    }

    public void hoverOverComponent(String componentName) {

        WebElement component = driver.findElement(By.xpath("//*[text()[contains(.,'" + componentName + "')]]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(component).perform();
    }

    public void clickTrashIcon(String componentName) {

        List<WebElement> trashButtons = driver.findElements(trashIcon);

        WebElement component = driver.findElement(By.xpath("//*[text()[contains(.,'" + componentName + "')]]"));

        for (WebElement button : trashButtons) {
            if (button.isDisplayed() && component.isEnabled()) {
                button.click();
                break;
            }
        }
    }

    public void clickEditPencilIcon(String componentName) {

        List<WebElement> pencilButtons = driver.findElements(editPencilIcon);

        WebElement component = driver.findElement(By.xpath("//*[text()[contains(.,'" + componentName + "')]]"));

        for (WebElement button : pencilButtons) {
            if (button.isDisplayed() && component.isEnabled()) {
                button.click();
                break;
            }
        }
    }

    public String getWarningText() {

        return driver.findElement(warningMessage).getText();
    }
}
