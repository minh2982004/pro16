package menu;



import menu.MenuModel;
import java.util.Scanner;

public class MenuView {
    private MenuModel model;
    private Scanner scanner;

    public MenuView(MenuModel model) {
        this.model = model;
        this.scanner = new Scanner(System.in);
    }

    public void Menu() {
        String[] menuItems = model.getMenuItems();

        
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + ". " + menuItems[i]);
        }
    }

   public int UserChoice() {
        int choice = -1;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter your choice: ");
                String input = scanner.next();
                if (input.matches("\\d+")) {
                    choice = Integer.parseInt(input);
                    validInput = true;
                } else {
                    System.err.println("Invalid input. Please enter a number.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a number.");
            }
        }
        return choice;
    }
}
