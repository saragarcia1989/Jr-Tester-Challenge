package basePrice;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeBasePriceTest extends BaseTests {

    @Test
    public void testChangeBasePriceValue() {

        homePage.hoverOverBasePrice();
        homePage.clickPencilIcon();
        homePage.inputBasePriceValue("5");
        homePage.clickCheckIcon();
        Assert.assertEquals(homePage.getTotal(), "5.00");
    }
}
