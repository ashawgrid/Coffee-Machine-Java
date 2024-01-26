import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean valuesAreNotOccurNearEachOther = false;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == n || array[i] == m) {
                if (array[i + 1] == m) {
                    valuesAreNotOccurNearEachOther = true;
                }
                if (array[i + 1] == n) {
                    valuesAreNotOccurNearEachOther = true;
                }
            }
        }

        System.out.println(valuesAreNotOccurNearEachOther);
    }
}
