/**
 * Assignment 6 for CS 1410. Gregorian Date Class.
 * This Class will calculate the Gregorian date.
 * It has a Super Class: Date that contains many of the methods needed.
 *
 * @author Spencer Lingwall
* */
public class GregorianDate extends Date {
    /**
     * Default Constructor: -> Public method
     * Will set the year, month and day to the current time
     * these values to be stored in a private instance
     **/
    public GregorianDate() {
        super.day = 1;
        super.month = 1;
        super.year = 1970;
        int MILLI_IN_DAY = 86_400_000;
        long offSetTime = java.util.TimeZone.getDefault().getRawOffset();
        long time = System.currentTimeMillis();
        long actualTime = time + offSetTime;
        double daysFrom1970 = actualTime / MILLI_IN_DAY;
        addDays((int) daysFrom1970);
    }

    /**
     * Overloaded Constructor: -> public
     * if a date is given, then it will use that date to initialize the
     * object.
     * these values are to be stored in a private instance
     **/
    public GregorianDate(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * OverRide: isLeapYear: -> public
     * returns boolean.
     * will return true or false if year is a leap year or not.
     **/
    @Override
    public boolean isLeapYear() {
        if (getYear() % 4 == 0) {
            if (getYear() % 100 == 0)
                return getYear() % 400 == 0;
            else return true;
        } else return false;
    }

    /**
     * OverRide of Overload isLeapYear -> Public
     * returns boolean. Parameters: int year
     * will take a given year and determine if it is a leap year.
     **/
    @Override
    public boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0)
                return year % 400 == 0;
            else return true;
        } else return false;
    }
}