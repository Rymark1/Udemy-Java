import java.util.Arrays;

public class ReverseChallenge {

    private static void reverse(int[] list){
        System.out.println("Array = " + Arrays.toString(list));
        for(int i = 0; i < list.length/2;i++){
            int holdNbr = list[i];
            list[i] = list[list.length-1 - i];
            list[list.length-1 - i] = holdNbr;
        }
        System.out.println("Reversed array = " + Arrays.toString(list));
    }

    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 3, 4, 5};
        reverse(list);
    }
}