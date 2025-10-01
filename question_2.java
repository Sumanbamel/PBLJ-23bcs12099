import java.util.ArrayList;
import java.util.Scanner;

public class question_2 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter numbers (type 'done' to finish):");

        while (true) {
            String input = sc.next();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int num = Integer.parseInt(input);
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input, please enter a valid integer.");
            }
        }

        try {
            if (numbers.size() == 0) {
                sc.close();
                throw new ArithmeticException("List is empty, cannot calculate average.");
            }
            double sum = 0;
            for (int num : numbers) {
                sum += num;
            }
            double average = sum / numbers.size();
            System.out.println("Average: " + average);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
