import by.gsu.pms.Employee;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader file = new FileReader("src/in.txt");
        Scanner scanner = new Scanner(file);

        double dailyRate = Double.parseDouble(scanner.nextLine().split("=")[1]);
        int[] indices = Arrays.stream(scanner.nextLine().split("=")[1].split(";")).mapToInt(Integer::parseInt).toArray();

        Employee[] employees = new Employee[indices.length];

        for (int i = 0; i < indices.length; i++) {
            String account = scanner.nextLine().split("=")[1];
            int transport = Integer.parseInt(scanner.nextLine().split("=")[1]);
            int days = Integer.parseInt(scanner.nextLine().split("=")[1]);

            employees[i] = new Employee(account, transport, days);
        }
        //2. Sort the array by the total cost decreasing.
        Arrays.sort(employees, Comparator.comparing(employee -> employee == null ? 0 : employee.getTotal()));
        System.out.println("Sorted arrays by the total cost decreasing:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("\n");
        //3. Print the array content to the console (one element per line)
        for (Employee employee : employees) {
            employee.show();
        }
    }
}