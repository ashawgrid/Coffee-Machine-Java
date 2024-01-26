import java.util.Scanner;

public class Main {
    // Declare the method 'countCharacters'
    public static void countCharacters(String inputString) {
        // Your code here
        int c=inputString.length();
        System.out.println(c);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        // Call 'countCharacters' method with the input string
        countCharacters(inputString);

        scanner.close();
    }
}