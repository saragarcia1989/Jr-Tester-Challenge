package components;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComponentObject;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AddPriceComponentsTest extends BaseTests {

//    Add all price components from Testdata:
//    Testdata
//    Price components
//    Alloy surcharge: 2.15
//    Scrap surcharge: 3.14
//    Internal surcharge: 0.7658
//    External surcharge: 1
//    Storage surcharge: 0.3

//    Click on label input (left)
//    Enter new label
//    Click on value input (right)
//    Enter new value
//    Click on ‘Check’ icon
//    Expected Results:
//      - Displayed values of price components are rounded correctly
//      - Values always show 1 or 2 decimal digits
//      - If value has no decimal digits, show a 0 as decimal digit
//      - If value has more than 2 decimal digits, round to 2 decimal digits

    @Test
    public void addComponentsTest() {

        ArrayList<ComponentObject> listOfComponents = new ArrayList<>();

        listOfComponents.add(new ComponentObject("Alloy surcharge", "2.15"));
        listOfComponents.add(new ComponentObject("Scrap surcharge", "3.14"));
        listOfComponents.add(new ComponentObject("Internal surcharge", "0.7658"));
        listOfComponents.add(new ComponentObject("External surcharge", "1"));
        listOfComponents.add(new ComponentObject("Storage surcharge", "0.3"));

        for (ComponentObject componentObject : listOfComponents) {
            homePage.enterNewLabel(componentObject);
        }

        for (Double amount : homePage.getPrices()) {

            boolean pass = (BigDecimal.valueOf(amount).scale() <= 2);

            Assert.assertTrue(pass, "Valid value");
        }
    }


    @Test
    public void addComponentsTest2() {

        ArrayList<ComponentObject> listOfComponents = new ArrayList<>();

        listOfComponents.add(new ComponentObject("Alloy surcharge", "2"));
        listOfComponents.add(new ComponentObject("Scrap surcharge", "3"));
        listOfComponents.add(new ComponentObject("Internal surcharge", "1"));
        listOfComponents.add(new ComponentObject("External surcharge", "1"));
        listOfComponents.add(new ComponentObject("Storage surcharge", "4"));

        for (ComponentObject componentObject : listOfComponents) {
            homePage.enterNewLabel(componentObject);
        }

        for (String amount : homePage.getPricesString()) {

            String leftOver = amount.substring(amount.length() - 2);
            Assert.assertEquals(leftOver, ".0", "given number doesn't end with '.0'");
        }
    }

    @Test
    public void addComponentsTest3() {

        ArrayList<ComponentObject> listOfComponents = new ArrayList<>();

        listOfComponents.add(new ComponentObject("Alloy surcharge", "2.15"));
        listOfComponents.add(new ComponentObject("Scrap surcharge", "3.14"));
        listOfComponents.add(new ComponentObject("Internal surcharge", "0.7658"));
        listOfComponents.add(new ComponentObject("External surcharge", "1"));
        listOfComponents.add(new ComponentObject("Storage surcharge", "0.3"));

        for (ComponentObject componentObject : listOfComponents) {
            homePage.enterNewLabel(componentObject);
        }

        for (int i = 0; i >= homePage.getPricesString().size(); i++) {
            String amount = homePage.getPricesString().get(i);

            if (i == 3) {
                String leftOver = amount.substring(amount.length() - 2);
                Assert.assertEquals(leftOver, ".0", "given number doesn't end with '.0'");
            } else {
                boolean pass = (BigDecimal.valueOf(Long.parseLong(amount)).scale() <= 2);
                Assert.assertTrue(pass);
            }
        }
    }
}


