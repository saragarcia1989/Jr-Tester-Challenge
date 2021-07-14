package components;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComponentObject;

import java.util.ArrayList;

public class EditComponentPrice2Test extends BaseTests {

    @Test
    public void editPrice2() {

        ArrayList<ComponentObject> arrayList = new ArrayList<>();

        arrayList.add(new ComponentObject("Alloy surcharge", "2.15"));
        arrayList.add(new ComponentObject("Scrap surcharge", "3.14"));
        arrayList.add(new ComponentObject("Internal surcharge", "0.7658"));
        arrayList.add(new ComponentObject("External surcharge", "1"));
        arrayList.add(new ComponentObject("Storage surcharge", "0.3"));

        for (ComponentObject componentObject : arrayList) {
            homePage.enterNewLabel(componentObject);
        }

        homePage.hoverOverComponent("Alloy surcharge");
        homePage.clickEditPencilIcon("Alloy surcharge");
        homePage.editPrice(new ComponentObject("Alloy surcharge", "1.79"));
        homePage.clickEditCheckIcon();

        Assert.assertEquals(homePage.sumPrices(homePage.getPrices()), homePage.getTotal());
    }
}
