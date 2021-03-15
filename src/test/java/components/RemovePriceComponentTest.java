package components;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class RemovePriceComponentTest extends BaseTests {

    @Test
    public void removePriceComponent() {

        ArrayList<String[]> list = new ArrayList<>();
        list.add(new String[]{"Alloy surcharge", "2.15"});
        list.add(new String[]{"Scrap surcharge", "3.14"});
        list.add(new String[]{"Internal surcharge", "0.7658"});
        list.add(new String[]{"External surcharge", "1"});
        list.add(new String[]{"Storage surcharge", "0.3"});


        for (String[] entryArray : list) {
            homePage.enterNewLabel(entryArray);
        }

        homePage.hoverOverComponent("Internal surcharge");

        homePage.clickTrashIcon("Internal surcharge");
    }
}
