import java.io.BufferedReader;
import java.io.FileReader;

public class PayrollCalculator2 {

    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("src/main/resources/employees.csv")
            );

            String line;

            // skip header
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double hoursWorked = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);

                Employee emp = new Employee(id, name, hoursWorked, payRate);

                System.out.println(emp.getName() + " earns $" + emp.getGrossPay());
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}