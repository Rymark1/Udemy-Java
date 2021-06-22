import java.util.Scanner;

public class SortedArray {

    public static int[] getIntegers(int nbr){
        int[] list = new int[nbr];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < list.length;i++){
            list[i] = scan.nextInt();
        }
        return list;
    }

    public static void printArray(int[] list){
        for(int i = 0; i < list.length;i++){
            System.out.println("Element " + i + " contents " + list[i]);
        }
    }

    public static int[] sortIntegers(int[] temp){
        boolean continueFlag = true;
        while(continueFlag) {
            continueFlag = false;
            for (int i = 0; i < temp.length - 1; i++) {
                int holdNbr;
                if (temp[i] < temp[i + 1]) {
                    holdNbr = temp[i];
                    temp[i] = temp[i + 1];
                    temp[i + 1] = holdNbr;
                    continueFlag = true;
                }
            }
        }
        return temp;
    }
}