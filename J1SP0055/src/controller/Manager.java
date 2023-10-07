package controller;

import model.Doctor;
import menu.MenuModel;
import menu.MenuView;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Manager {

    private Validate validator = new Validate();
    private HashMap<String, Doctor> doctorsMap = new HashMap<>();
    private MenuModel model;
    private MenuView view;

    public Manager(MenuModel model, MenuView view) {
        this.model = model;
        this.view = view;
    }

    public void startMenu() {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, Doctor> doctorsMap = new HashMap<>();
        while (true) {
            view.Menu();
            int choice = view.UserChoice();

            switch (choice) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    updateDoctor();
                    break;
                case 3:
                    deleteDoctor();
                    break;
                case 4:
                    searchDoctor();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void addDoctor() {
        System.out.print("Enter code: ");
        String code = validator.checkInputString();

        if (validator.checkCodeExist(doctorsMap, code)) {
            System.err.println("Doctor with this code already exists.");
            return;
        }

        System.out.print("Enter name: ");
        String name = validator.checkInputString();

        System.out.print("Enter specialization: ");
        String specialization = validator.checkInputString();

        System.out.print("Enter availability: ");
        int availability = validator.checkInputInt();

        Doctor newDoctor = new Doctor(code, name, specialization, availability);
        doctorsMap.put(code, newDoctor);

        System.err.println("Add successful.");
    }

    public void updateDoctor() {
        System.out.print("Enter code: ");
        String code = validator.checkInputString();

        if (!validator.checkCodeExist(doctorsMap, code)) {
            System.err.println("Doctor not found.");
            return;
        }

        Doctor doctor = validator.getDoctorByCode(doctorsMap, code);

        System.out.print("Enter new code: ");
        String newCode = validator.checkInputString();

        System.out.print("Enter new name: ");
        String name = validator.checkInputString();

        System.out.print("Enter new specialization: ");
        String specialization = validator.checkInputString();

        System.out.print("Enter new availability: ");
        int availability = validator.checkInputInt();

        if (!validator.checkChangeInfo(doctor, newCode, name, specialization, availability)) {
            System.err.println("No change.");
            return;
        }

        doctorsMap.remove(code);

        Doctor updatedDoctor = new Doctor(newCode, name, specialization, availability);
        doctorsMap.put(newCode, updatedDoctor);

        System.err.println("Update successful.");
    }

    public void deleteDoctor() {
        System.out.print("Enter code: ");
        String code = validator.checkInputString();

        if (!validator.checkCodeExist(doctorsMap, code)) {
            System.err.println("Doctor not found.");
            return;
        }

        doctorsMap.remove(code);
        System.err.println("Delete successful.");
    }

    public void searchDoctor() {
        System.out.print("Enter name: ");
        String nameSearch = validator.checkInputString();

        Map<String, Doctor> searchResults = validator.searchDoctorByName(doctorsMap, nameSearch);

        if (searchResults.isEmpty()) {
            System.err.println("No doctors found with the given name.");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Map.Entry<String, Doctor> entry : searchResults.entrySet()) {
                Doctor doctor = entry.getValue();
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(), doctor.getName(),
                        doctor.getSpecialization(), doctor.getAvailability());
            }
        }
    }
}
