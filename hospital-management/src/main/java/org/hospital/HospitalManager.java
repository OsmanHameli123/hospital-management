package org.hospital;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HospitalManager {

    private static String[][] patients = new String[50][7];
    private static int count = 0;
    private static final String FILE_NAME = "hospital.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== HOSPITAL MANAGEMENT SYSTEM ===");
            System.out.println("1. Add patient");
            System.out.println("2. Show all patients");
            System.out.println("3. Change patient status");
            System.out.println("4. Show statistics");
            System.out.println("5. Remove patient");
            System.out.println("6. Save to file");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            choice = safeInt(sc);

            switch (choice) {
                case 1 -> addPatient(sc);
                case 2 -> showPatients();
                case 3 -> changeStatus(sc);
                case 4 -> statistics();
                case 5 -> removePatient(sc);
                case 6 -> saveToFile();
                case 7 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option");
            }
        } while (choice != 7);
    }

    private static void addPatient(Scanner sc) {
        sc.nextLine();

        System.out.print("Patient name: ");
        patients[count][0] = sc.nextLine();

        System.out.print("Urgency level (1-5): ");
        patients[count][1] = String.valueOf(safeInt(sc));

        sc.nextLine();
        System.out.print("Doctor name: ");
        patients[count][3] = sc.nextLine();

        System.out.print("Nurse name: ");
        patients[count][4] = sc.nextLine();

        System.out.print("Room: ");
        patients[count][5] = sc.nextLine();

        System.out.print("Emergency (true/false): ");
        patients[count][6] = sc.nextLine();

        patients[count][2] = "Waiting";

        count++;
        System.out.println("Patient added successfully");
    }

    private static void showPatients() {
        if (count == 0) {
            System.out.println("No patients available");
            return;
        }

        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.printf("%-4s %-15s %-9s %-8s %-13s %-15s %-15s%n",
                "No", "Patient", "Urgency", "Room", "Status", "Doctor", "Nurse");
        System.out.println("-----------------------------------------------------------------------------------------------");

        for (int i = 0; i < count; i++) {
            System.out.printf("%-4d %-15s %-9s %-8s %-13s %-15s %-15s%n",
                    i + 1,
                    patients[i][0],
                    patients[i][1],
                    patients[i][5],
                    patients[i][2],
                    patients[i][3],
                    patients[i][4]);
        }

        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    private static void changeStatus(Scanner sc) {
        showPatients();
        System.out.print("Select patient number: ");
        int index = safeInt(sc) - 1;

        if (index < 0 || index >= count) {
            System.out.println("Invalid patient number");
            return;
        }

        sc.nextLine();
        System.out.print("New status (Waiting/Diagnosing/Treatment/Recovery): ");
        patients[index][2] = sc.nextLine();

        System.out.println("Status updated");
    }

    private static void statistics() {
        int emergencyCount = 0;

        for (int i = 0; i < count; i++) {
            if (patients[i][6].equalsIgnoreCase("true")) {
                emergencyCount++;
            }
        }

        System.out.println("\n=== STATISTICS ===");
        System.out.println("Total patients   : " + count);
        System.out.println("Emergency cases  : " + emergencyCount);
        System.out.println("Normal cases     : " + (count - emergencyCount));
    }

    private static void removePatient(Scanner sc) {
        showPatients();
        System.out.print("Patient number to remove: ");
        int index = safeInt(sc) - 1;

        if (index < 0 || index >= count) {
            System.out.println("Invalid patient number");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            patients[i] = patients[i + 1];
        }

        count--;
        System.out.println("Patient removed");
    }

    private static void saveToFile() {
        try (FileWriter fw = new FileWriter(FILE_NAME)) {

            fw.write("-----------------------------------------------------------------------------------------------\n");
            fw.write(String.format("%-4s %-15s %-9s %-8s %-13s %-15s %-15s%n",
                    "No", "Patient", "Urgency", "Room", "Status", "Doctor", "Nurse"));
            fw.write("-----------------------------------------------------------------------------------------------\n");

            for (int i = 0; i < count; i++) {
                fw.write(String.format("%-4d %-15s %-9s %-8s %-13s %-15s %-15s%n",
                        i + 1,
                        patients[i][0],
                        patients[i][1],
                        patients[i][5],
                        patients[i][2],
                        patients[i][3],
                        patients[i][4]));
            }

            fw.write("-----------------------------------------------------------------------------------------------\n");
            System.out.println("Data saved to hospital.txt");

        } catch (IOException e) {
            System.out.println("File error");
        }
    }

    private static int safeInt(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.print("Enter a valid number: ");
            }
        }
    }
}
