package components;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComponentObject;
import java.util.ArrayList;
import static org.testng.Assert.assertEquals;

public class EditComponentNameTest extends BaseTests {


    //  Edit component name: Storage surcharge

    @Test
    public void editComponentName() {

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

        //  Hover row
        homePage.hoverOverComponent("Storage surcharge");

        //  Click on ‘Pencil’ icon
        homePage.clickEditPencilIcon("Storage surcharge");

        //  Enter new label: ‘T’
        homePage.editLabel(new ComponentObject("T", "0.3"));

        //  Verify expected results: Label input validation
        //  Labels have to contain at least 2 characters
        assertEquals(homePage.getWarningText(), "This label is too short!");

        //  Click on ‘Check’ icon
        homePage.clickEditCheckIcon();

        //  If input is invalid, restore last valid state
        Assert.assertTrue(componentsList.get(4).getComponentName().matches(originalName), ">>>Different name<<<");
    }
}

