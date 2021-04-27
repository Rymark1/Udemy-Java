public class MinutesToYearsDaysCalculator {
    public static void printYearsAndDays(long minutes){
        /*if (minutes <0)
            System.out.println("Invalid Value");
        else {
            System.out.println(minutes + " min = " + minutes / 525600 +
                    " y and " + minutes % 525600 / 1440 + " d");
        }
*/
        System.out.println(minutes < 0 ? "Invalid Value" : minutes + " min = " + minutes / 525600 +
                " y and " + minutes % 525600 / 1440 + " d");
    }

    public static void main(String[] args) {
        printYearsAndDays(1000000);
        printYearsAndDays(-50);
        printYearsAndDays(1236589562);
    }
}