public class dateCalculator {

    //initialize vars for first date
    static int day1;
    static int month1;
    static int year1;

    //initialize vars for second date
    static int day2;
    static int month2;
    static int year2;

    //total days
    static int days1;
    static int days2;

    //print date vars
    static String monthFinal;
    static String dayFinal;
    static String monthFinalCompared;
    static String dayFinalCompared;

    public static void main(String[] args) throws Exception {
        //user input
        System.out.println("\nWhat's the current day (dd)?");
        day1 = readInt();
        System.out.println("\nWhat's the current month (mm)?");
        month1 = readInt();
        System.out.println("\nWhat's the current year (yyyy)?");
        year1 = readInt();

        //compared date
        System.out.println("\nFor your comparing date, what is the day (dd)?");
        day2 = readInt();
        System.out.println("\nWhat's the month (mm)?");
        month2 = readInt();
        System.out.println("\nWhat's the year (yyyy)?");
        year2 = readInt();

        //calculate the difference in days between the two dates
        days1 = day1 + daysInYears(year1) + daysInMonths(month1, year1);
        days2 = day2 + daysInYears(year2) + daysInMonths(month2, year2);
        int diff = Math.abs(days1 - days2);

        //output the result
        System.out.println("\nThe difference in days between the two dates is: " + diff);

        //ouput dates
        currentDate();
        comparedDate();
    }

    //read an integer from the console
    private static int readInt() throws Exception {
        int num = 0;
        char c;
        while ((c = (char) System.in.read()) != '\n') {
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            }
        }
        return num;
    }

    //calculate the number of days in the given year, taking leap years into consideration
    private static int daysInYears(int year) {
        int days = (year - 1) * 365 + leapYearsBefore(year);
        return days;
    }

    //calculate the number of leap years before the given year
    private static int leapYearsBefore(int year) {
        int numLeapYears = (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
        return numLeapYears;
    }

    //calculate the number of days in the given month, taking leap years into consideration
    private static int daysInMonths(int month, int year) {
        int[] daysInMonth = {31, febDays(year), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;
        for (int i = 0; i < month - 1; i++) {
            days += daysInMonth[i];
        }
        return days;
    }

    //calculate the number of days in February of the given year, taking leap years into consideration
    private static int febDays(int year) {
        if (year % 4 != 0) {
            return 28;
        } else if (year % 100 != 0) {
            return 29;
        } else if (year % 400 != 0) {
            return 28;
        } else {
            return 29;
        }
    }

    //user's current date
    public static void currentDate() {
        
        //date 1 or current date
        if (day1 >= 1 && day1 <= 9) {
            dayFinal = "0" + day1;
        } else {
            dayFinal = "" + day1;
        }

        if (month1 >= 1 && month1 <= 9) {
            monthFinal = "0" + month1;
        } else {
            monthFinal = "" + month1;
        }

        System.out.println("\nThe current date is: " + monthFinal + "/" + dayFinal + "/" + year1);
    }

    //user's compared date
    public static void comparedDate() {
        
        //date 2 or current date
        if (day2 >= 1 && day2 <= 9) {
            dayFinalCompared = "0" + day2;
        } else {
            dayFinalCompared = "" + day2;
        }

        if (month2 >= 1 && month2 <= 9) {
            monthFinalCompared = "0" + month2;
        } else {
            monthFinalCompared = "" + month2;
        }

        System.out.println("The compared date is: " + monthFinalCompared + "/" + dayFinalCompared + "/" + year2 + "\n");
    }
}
