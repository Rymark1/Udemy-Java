import java.util.Scanner;

public class MinimumElement {

    private static int readInteger() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    private static int[] readElements(int elements) {
        Scanner scan = new Scanner(System.in);
        int[] list = new int[elements];
        for (int i = 0; i < list.length; i++) {
            list[i] = scan.nextInt();
        }
        return list;
    }

    private static int findMin(int[] list) {
        int minNbr = Integer.MAX_VALUE;
        for (int i = 0; i < list.length; i++) {
            if (list[i] < minNbr)
                minNbr = list[i];
        }
        return minNbr;
    }
}