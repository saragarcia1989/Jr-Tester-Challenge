package pages;

public class ComponentObject {

    private String componentName;
    private String componentPrice;

    public String getComponentPrice() {
        return componentPrice;
    }

    public void setComponentPrice(String componentPrice) {
        this.componentPrice = componentPrice;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public ComponentObject(String componentName, String componentPrice) {

        setComponentName(componentName);
        setComponentPrice(componentPrice);
    }
}
