package controller;

import model.Doctor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Validate {

    private final Scanner in = new Scanner(System.in);

    public String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Input cannot be empty.");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input an integer.");
                System.out.print("Enter again: ");
            }
        }
    }

    public boolean checkCodeExist(HashMap<String, Doctor> doctorsMap, String code) {
        return doctorsMap.containsKey(code);
    }

    public boolean checkChangeInfo(Doctor doctor, String newCode, String name, String specialization, int availability) {
        return !(doctor.getCode().equalsIgnoreCase(newCode)
                && doctor.getName().equalsIgnoreCase(name)
                && doctor.getSpecialization().equalsIgnoreCase(specialization)
                && doctor.getAvailability() == availability);
    }

    public Map<String, Doctor> searchDoctorByName(HashMap<String, Doctor> doctorsMap, String name) {
        Map<String, Doctor> result = new HashMap<>();
        for (Map.Entry<String, Doctor> entry : doctorsMap.entrySet()) {
            Doctor doctor = entry.getValue();
            if (doctor.getName().contains(name)) {
                result.put(doctor.getCode(), doctor);
            }
        }
        return result;
    }

    public Doctor getDoctorByCode(HashMap<String, Doctor> doctorsMap, String code) {
        return doctorsMap.get(code);
    }
}
