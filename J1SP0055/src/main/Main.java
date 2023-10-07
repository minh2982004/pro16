package main;

import controller.Manager;
import model.Doctor;
import menu.MenuModel;
import menu.MenuView;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    } 

    public void run() {
        MenuModel model = new MenuModel();
        MenuView view = new MenuView(model);
        Manager manager = new Manager(model, view);
        manager.startMenu();
        }
    }

