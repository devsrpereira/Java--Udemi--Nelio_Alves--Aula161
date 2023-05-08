package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i+1) + " data:");
            System.out.print("Outsource (y/n)? ");
            char outsource = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            Integer hour = sc.nextInt();
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();

            if (outsource == 'y'){
                System.out.print("Additional charge: ");
                Double additionalCharge = sc.nextDouble();
                employeeList.add(new OutsourcedEmployee(name, hour,valuePerHour, additionalCharge));
            }
            if (outsource == 'n') {
                employeeList.add(new Employee(name, hour, valuePerHour));
            }

        }

        System.out.println();
        System.out.println("PAYMENTS:");
        for (Employee x : employeeList) {
            System.out.println(x.getName() + " - $ " + String.format("%.2f",x.payment()));
        }

        sc.close();
    }
}
