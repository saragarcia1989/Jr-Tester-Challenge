package components;

import base.BaseTests;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.ComponentObject;

import java.util.ArrayList;

public class EditComponentPriceTest extends BaseTests {

    @Test
    public void editPrice() {
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

        homePage.hoverOverComponent("Scrap surcharge");
        homePage.clickEditPencilIcon("Scrap surcharge");
        homePage.editPrice(new ComponentObject("Scrap surcharge", "-2.15"));
        Assert.assertEquals(homePage.getWarningText(), "Cannot be negative!");
        homePage.clickEditCheckIcon();
        Assert.assertTrue(componentList.get(1).getComponentPrice().matches(originalPrice), ">>>Different price<<<");
    }
}
