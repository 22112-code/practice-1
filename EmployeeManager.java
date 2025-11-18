// File Name: EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {

    // ---------------------------
    // Method for reading employee file
    // ---------------------------
    public static String[] readEmployees() throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("employees.txt")
                )
        );
        String fileLine = reader.readLine();
        reader.close();
        return fileLine.split(",");
    }

    // ---------------------------
    // Method for writing employee file
    // ---------------------------
    public static void writeEmployees(String[] employees) throws Exception {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter("employees.txt")
        );
        writer.write(String.join(",", employees));
        writer.close();
    }

    public static void main(String[] args) {

        // Argument Count Check
        if (args.length != 1) {
            System.out.println("Error: Exactly one argument is required.");
            System.out.println("Usage:");
            System.out.println("   l          → list employees");
            System.out.println("   s          → show random employee");
            System.out.println("   +name      → add new employee");
            System.out.println("   ?name      → search employee");
            System.out.println("   c          → count words");
            System.out.println("   uname      → update employee");
            System.out.println("   dname      → delete employee");
            return;
        }

        String command = args[0];

        // ---------------------------
        // List employees
        // ---------------------------
        if (command.equals("l")) {

            System.out.println("Loading data ...");

            try {
                String[] employeeList = readEmployees();

                for (String employee : employeeList) {
                    System.out.println(employee);
                }

            } catch (Exception e) { }

            System.out.println("Data Loaded.");

        }

        // ---------------------------
        // Show random employee
        // ---------------------------
        else if (command.equals("s")) {

            System.out.println("Loading data ...");

            try {
                String[] employeeList = readEmployees();

                Random random = new Random();
                int randomIndex = random.nextInt(employeeList.length);
                System.out.println(employeeList[randomIndex]);

            } catch (Exception e) { }

            System.out.println("Data Loaded.");

        }

        // ---------------------------
        // Add employee
        // ---------------------------
        else if (command.contains("+")) {

            System.out.println("Loading data ...");

            try {
                String newName = command.substring(1);

                String[] employees = readEmployees();
                List<String> updated = new ArrayList<>(Arrays.asList(employees));

                updated.add(newName);

                writeEmployees(updated.toArray(new String[0]));

            } catch (Exception e) { }

            System.out.println("Data Loaded.");

        }

        // ---------------------------
        // Search employee
        // ---------------------------
        else if (command.contains("?")) {

            System.out.println("Loading data ...");

            try {
                String[] employees = readEmployees();
                String nameToSearch = command.substring(1);

                boolean found = false;

                for (String emp : employees) {
                    if (emp.trim().equals(nameToSearch)) {
                        found = true;
                        break;
                    }
                }

                if (found)
                    System.out.println("Employee found!");
                else
                    System.out.println("Employee not found!");

            } catch (Exception e) { }

            System.out.println("Data Loaded.");

        }

        // ---------------------------
        // Count words
        // ---------------------------
        else if (command.contains("c")) {

            System.out.println("Loading data ...");

            try {
                String[] employees = readEmployees();

                int wordCount = employees.length;

                System.out.println(wordCount + " word(s) found.");

            } catch (Exception e) { }

            System.out.println("Data Loaded.");

        }

        // ---------------------------
        // Update employee
        // ---------------------------
        else if (command.contains("u")) {

            System.out.println("Loading data ...");

            try {
                String[] employees = readEmployees();
                String nameToUpdate = command.substring(1);

                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].trim().equals(nameToUpdate)) {
                        employees[i] = "Updated";
                    }
                }

                writeEmployees(employees);

            } catch (Exception e) { }

            System.out.println("Data Updated.");

        }

        // ---------------------------
        // Delete employee
        // ---------------------------
        else if (command.contains("d")) {

            System.out.println("Loading data ...");

            try {
                String[] employees = readEmployees();
                String nameToDelete = command.substring(1);

                List<String> updated = new ArrayList<>(Arrays.asList(employees));
                updated.remove(nameToDelete);

                writeEmployees(updated.toArray(new String[0]));

            } catch (Exception e) { }

            System.out.println("Data Deleted.");

        }
    }
}
