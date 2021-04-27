public class SecondsAndMinutes {

    private static String getDurationString(long minutes, long seconds){

        if (minutes <0 || seconds <0 || seconds >59)
            return "Invalid value";
        else
            return String.format("%02d", minutes / 60l) + "h " + String.format("%02d", minutes % 60l) + "m " + String.format("%02d", seconds) + "s";
    }

    private static String getDurationString(long seconds){

        long min = seconds / 60l;
        long sec = seconds % 60l;

        if (seconds <0)
            return "Invalid value";
        else
            return getDurationString(min, sec);
    }

    public static void main(String[] args) {
        System.out.println(getDurationString(70l,50l));
        System.out.println(getDurationString(125l));
    }
}
