package components;

import base.BaseTests;

import org.testng.Assert;

import org.testng.annotations.Test;

import pages.ComponentObject;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class EditComponentTest extends BaseTests {

    @Test
    public void editComponent() {

        String originalName = "Storage surcharge";

        ArrayList<ComponentObject> componentsList = new ArrayList<>();

        componentsList.add(new ComponentObject("Alloy surcharge", "2.15"));
        componentsList.add(new ComponentObject("Scrap surcharge", "3.14"));
        componentsList.add(new ComponentObject("Internal surcharge", "0.7658"));
        componentsList.add(new ComponentObject("External surcharge", "1"));
        componentsList.add(new ComponentObject(originalName, "0.3"));

        for (ComponentObject componentObject : componentsList) {
            homePage.enterNewLabel(componentObject);
        }

        homePage.hoverOverComponent("Storage surcharge");
        homePage.clickEditPencilIcon("Storage surcharge");
        homePage.editLabel(new ComponentObject("T", "0.3"));
        assertEquals(homePage.getWarningText(), "This label is too short!");
        homePage.clickEditCheckIcon();
        Assert.assertTrue(componentsList.get(4).getComponentName().matches(originalName), ">>>Different name<<<");
    }
}

