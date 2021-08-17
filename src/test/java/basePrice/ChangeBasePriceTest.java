package basePrice;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeBasePriceTest extends BaseTests {

    //Change Base Price value to 5
    @Test
    public void testChangeBasePriceValue() {

        //Hover row
        homePage.hoverOverBasePrice();

        //Click on ‘Pencil’ icon
        homePage.clickBasePricePencilIcon();

        //Click on value input (right) and enter new value
        homePage.inputBasePriceValue("5");

        //Click on ‘Check’ icon
        homePage.clickCheckIcon();

        //Expected results: Displayed sum shows correct sum
        Assert.assertEquals(homePage.sumPrices(homePage.getPrices()), homePage.getTotal());
    }
}
