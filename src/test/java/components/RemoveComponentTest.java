package components;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComponentObject;

import java.util.ArrayList;

public class RemoveComponentTest extends BaseTests {


//    Remove component: Internal surcharge

    @Test
    public void removeComponentTest() {

        // Add list of the components
        ArrayList<ComponentObject> arraylist = new ArrayList<>();

        arraylist.add(new ComponentObject("Alloy surcharge", "2.15"));
        arraylist.add(new ComponentObject("Scrap surcharge", "3.14"));
        arraylist.add(new ComponentObject("Internal surcharge", "0.7658"));
        arraylist.add(new ComponentObject("External surcharge", "1"));
        arraylist.add(new ComponentObject("Storage surcharge", "0.3"));

        for (ComponentObject componentObject : arraylist) {
            homePage.enterNewLabel(componentObject);
        }

        // Hover row
        homePage.hoverOverComponent("Internal surcharge");

        // Click on ‘Trash’ icon
        homePage.clickTrashIcon("Internal surcharge");

        // Displayed sum shows correct sum
        Assert.assertEquals(homePage.sumPrices(homePage.getPrices()), homePage.getTotal());
    }
}

