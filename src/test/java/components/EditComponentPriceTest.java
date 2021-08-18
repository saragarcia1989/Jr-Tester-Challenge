package components;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComponentObject;

import java.util.ArrayList;

public class EditComponentPriceTest extends BaseTests {


//    Edit price component: Scrap surcharge

    @Test
    public void editPriceTest() {
        ArrayList<ComponentObject> componentList = new ArrayList<>();

        String originalPrice = "3.14";

        componentList.add(new ComponentObject("Alloy surcharge", "2.15"));
        componentList.add(new ComponentObject("Scrap surcharge", originalPrice));
        componentList.add(new ComponentObject("Internal surcharge", "0.7658"));
        componentList.add(new ComponentObject("External surcharge", "1"));
        componentList.add(new ComponentObject("Storage surcharge", "0.3"));

        for (ComponentObject componentObject : componentList) {
            homePage.enterNewLabel(componentObject);
        }

        //  Hover row
        homePage.hoverOverComponent("Scrap surcharge");

        //  Click on ‘Pencil’ icon
        homePage.clickEditPencilIcon("Scrap surcharge");

        //  Enter new value: -2.15
        homePage.editPrice(new ComponentObject("Scrap surcharge", "-2.15"));

        //  Verify expected results: Value input validation
        //  Values cannot be negative
        Assert.assertEquals(homePage.getWarningText(), "Cannot be negative!");

        // Click on ‘Check’ icon
        homePage.clickEditCheckIcon();

        // If input is invalid, restore last valid state
        Assert.assertTrue(componentList.get(1).getComponentPrice().matches(originalPrice), ">>>Different price<<<");
    }
}
