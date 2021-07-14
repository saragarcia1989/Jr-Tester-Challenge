package basePrice;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

//Change Base Price value to 5

public class ChangeBasePriceTest extends BaseTests {

    @Test
    public void testChangeBasePriceValue() {

        homePage.hoverOverBasePrice();
        homePage.clickBasePricePencilIcon();
        homePage.inputBasePriceValue("5");
        homePage.clickCheckIcon();
        Assert.assertEquals(homePage.sumPrices(homePage.getPrices()), homePage.getTotal());
    }
}
