import java.io.*;
import java.util.Scanner;

public class PayrollFileWriter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter employee file name: ");
            String inputFile = scanner.nextLine();

            System.out.print("Enter payroll file name to create: ");
            String outputFile = scanner.nextLine();

            BufferedReader reader = new BufferedReader(
                    new FileReader("src/main/resources/" + inputFile)
            );

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/resources/" + outputFile)
            );

            String line;

            // write header
            writer.write("id|name|gross pay");
            writer.newLine();

            // skip header
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double hoursWorked = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);

                Employee emp = new Employee(id, name, hoursWorked, payRate);

                writer.write(id + "|" +
                        emp.getName() + "|" +
                        String.format("%.2f", emp.getGrossPay()));
                writer.newLine();
            }

            reader.close();
            writer.close();
            scanner.close();

            System.out.println("Payroll file created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
