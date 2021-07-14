package components;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComponentObject;

import java.util.ArrayList;

public class RemovePriceComponentTest extends BaseTests {

    @Test
    public void removePriceComponent() {

        ArrayList<ComponentObject> arraylist = new ArrayList<>();

        arraylist.add(new ComponentObject("Alloy surcharge", "2.15"));
        arraylist.add(new ComponentObject("Scrap surcharge", "3.14"));
        arraylist.add(new ComponentObject("Internal surcharge", "0.7658"));
        arraylist.add(new ComponentObject("External surcharge", "1"));
        arraylist.add(new ComponentObject("Storage surcharge", "0.3"));

        for (ComponentObject componentObject : arraylist) {
            homePage.enterNewLabel(componentObject);
        }

        homePage.hoverOverComponent("Internal surcharge");

        homePage.clickTrashIcon("Internal surcharge");

        Assert.assertEquals(homePage.sumPrices(homePage.getPrices()), homePage.getTotal());
    }
}

