import java.util.Scanner;

public class Main {
    static boolean isLeap(long year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    static int daysInMonth(long year, int month) {
        int[] days = {0, 31, isLeap(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return days[month];
    }

    static int dayOfWeek(long year, int month) {
        long days = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
        for (int m = 1; m < month; m++) {
            days += daysInMonth(year, m);
        }
        return (int) (days % 7);
    }

    static int countSundays(long startYear, int startMonth, long endYear, int endMonth) {
        int count = 0;
        long offset = dayOfWeek(startYear, startMonth);
        int year = (int) startYear;
        int month = startMonth;
        
        while (year < endYear || (year == endYear && month <= endMonth)) {
            if (offset % 7 == 6) {
                count++;
            }
            offset = (offset + daysInMonth(year, month)) % 7;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long startYear = scanner.nextLong();
            int startDay = scanner.nextInt();
            int startMonth = scanner.nextInt();
            long endYear = scanner.nextLong();
            int endDay = scanner.nextInt();
            int endMonth = scanner.nextInt();

            if (startDay != 1) {
                startMonth++;
                if (startMonth > 12) {
                    startMonth = 1;
                    startYear++;
                }
            }
            int sundaysCount = countSundays(startYear, startMonth, endYear, endMonth);
            System.out.println(sundaysCount);
        }
        scanner.close();
    }
}
