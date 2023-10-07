package menu;

public class MenuModel {
    private String[] menuItems = {
        "Add doctor",
        "Update doctor",
        "Delete doctor",
        "Search doctor",
        "Exit"
    };

    private int selectedMenuItem;

    public String[] getMenuItems() {
        return menuItems;
    }

    public void setSelectedMenuItem(int selectedMenuItem) {
        this.selectedMenuItem = selectedMenuItem;
    }

    public int getSelectedMenuItem() {
        return selectedMenuItem;
    }
}
