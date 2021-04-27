import java.util.Scanner;

public class ArraysChallenge {

    private int[] myArray;

    public ArraysChallenge(){
        myArray = new int[10];
    }

    public void getIntegers(){
        Scanner scan = new Scanner(System.in);

        for (int cnt = 0; cnt < myArray.length;cnt++){
            System.out.print("Enter integer " +  (cnt+1) + ": ");
            myArray[cnt] = scan.nextInt();
        }
    }

    public void printArray(){
        for (int cnt = 0; cnt < myArray.length;cnt++){
            System.out.println("Index " + cnt + ": " + myArray[cnt]);
        }
    }

    public void sortIntegers(){
        for (int cnt = 0; cnt < myArray.length;cnt++){
            for (int cnt1 = cnt+1; cnt1 < myArray.length;cnt1++){
                if (myArray[cnt] <= myArray[cnt1]){
                    int idx = myArray[cnt];
                    myArray[cnt] = myArray[cnt1];
                    myArray[cnt1] = idx;
                }
            }
        }
    }

    public static void main(String[] args) {
        ArraysChallenge ay = new ArraysChallenge();
        ay.getIntegers();
        ay.printArray();
        ay.sortIntegers();
        ay.printArray();
    }
}