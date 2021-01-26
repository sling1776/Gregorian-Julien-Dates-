/**
 * Assignment 6 for CS 1410. Julian Date Class.
 * This Class will calculate the Julian date.
 * It has a Super Class: Date that contains many of the methods needed.
 *
 * @author Spencer Lingwall
 * */

public class JulianDate extends Date {
    /**
     * Default Constructor: -> Public method
     * Will set the year, month and day to the current time
     * these values to be stored in a private instance
     **/

    public JulianDate() {
        super.day = 1;
        super.month = 1;
        super.year = 1;
        int MILLI_IN_DAY = 86400000;
        long offSetTime = java.util.TimeZone.getDefault().getRawOffset();
        long time = System.currentTimeMillis();
        long actualTime = time + offSetTime;
        addDays(719164);
        double numDaysFrom1970 = actualTime / MILLI_IN_DAY;
        addDays((int)numDaysFrom1970);

    }

    /**
     * Overloaded Constructor: -> public
     * if a date is given, then it will use that date to initialize the
     * object.
     * these values are to be stored in a private instance
     **/
    public JulianDate(int year, int month, int day) {
        super.day = day;
        super.month = month;
        super.year = year;
    }
}