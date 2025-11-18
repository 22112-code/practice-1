// File Name: EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {

    public static void main(String[] args) {

        // ---------------------------
        // Argument Count Check (Task #2)
        // ---------------------------
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
        // ---------------------------

        String command = args[0];

        // List employees
        if (command.equals("l")) {

            System.out.println("Loading data ...");

            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String fileLine = reader.readLine();
                String[] employeeList = fileLine.split(",");

                for (String employee : employeeList) {
                    System.out.println(employee);
                }

            } catch (Exception e) { }

            System.out.println("Data Loaded.");

        }
        // Show random employee
        else if (command.equals("s")) {

            System.out.println("Loading data ...");

            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String fileLine = reader.readLine();
                System.out.println(fileLine);

                String[] employeeList = fileLine.split(",");
                Random random = new Random();

                int randomIndex = random.nextInt(employeeList.length);
                System.out.println(employeeList[randomIndex]);

            } catch (Exception e) { }

            System.out.println("Data Loaded.");

        }
        // Add employee
        else if (command.contains("+")) {

            System.out.println("Loading data ...");

            try {
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt", true)
                );

                String employeeName = command.substring(1);
                writer.write(", " + employeeName);
                writer.close();

            } catch (Exception e) { }

            System.out.println("Data Loaded.");

        }
        // Search employee
        else if (command.contains("?")) {

            System.out.println("Loading data ...");

            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String fileLine = reader.readLine();
                String[] employeeList = fileLine.split(",");

                boolean found = false;
                String nameToSearch = command.substring(1);

                for (int i = 0; i < employeeList.length && !found; i++) {
                    if (employeeList[i].trim().equals(nameToSearch)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }

            } catch (Exception e) { }

            System.out.println("Data Loaded.");

        }
        // Count words
        else if (command.contains("c")) {

            System.out.println("Loading data ...");

            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String fileLine = reader.readLine();
                char[] charArray = fileLine.toCharArray();

                boolean inWord = false;
                int wordCount = 0;

                for (char ch : charArray) {
                    if (ch == ' ') {
                        if (!inWord) {
                            wordCount++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }

                System.out.println(wordCount + " word(s) found " + charArray.length);

            } catch (Exception e) { }

            System.out.println("Data Loaded.");

        }
        // Update employee
        else if (command.contains("u")) {

            System.out.println("Loading data ...");

            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String fileLine = reader.readLine();
                String[] employeeList = fileLine.split(",");

                String employeeName = command.substring(1);

                for (int i = 0; i < employeeList.length; i++) {
                    if (employeeList[i].trim().equals(employeeName)) {
                        employeeList[i] = "Updated";
                    }
                }

                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt")
                );

                writer.write(String.join(",", employeeList));
                writer.close();

            } catch (Exception e) { }

            System.out.println("Data Updated.");

        }
        // Delete employee
        else if (command.contains("d")) {

            System.out.println("Loading data ...");

            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String fileLine = reader.readLine();
                String[] employeeList = fileLine.split(",");

                String employeeName = command.substring(1);

                List<String> updatedList = new ArrayList<>(Arrays.asList(employeeList));
                updatedList.remove(employeeName);

                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt")
                );

                writer.write(String.join(",", updatedList));
                writer.close();

            } catch (Exception e) { }

            System.out.println("Data Deleted.");
        }
    }
}
