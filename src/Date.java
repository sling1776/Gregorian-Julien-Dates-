/**
 * Assignment 6 for CS 1410. Date Class.
 * This Class will calculate the date.
 *
 * @author Spencer Lingwall
 * */
public class Date {

    /**
     * Default Constructor: -> Public method
     *             Will set the year, month and day to the current time
     *             these values to be stored in a private instance
     **/
    public int day;
    public int month;
    public int year;

    public Date(){
        this.day = java.time.MonthDay.now().getDayOfMonth();
        this.month = java.time.MonthDay.now().getMonthValue();
        this.year = java.time.Year.now().getValue();
    }

    /**
     * Overloaded Constructor: -> public
     *         if a date is given, then it will use that date to initialize the
     *         object.
     *         these values are to be stored in a private instance
     **/
    public Date(int year, int month, int day){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * addDays: -> public
     *     returns void. Parameters: int days
     *     will add the said number of days to the date.
     **/
    public void addDays(int days){
        for( int i = 0; i < days; i++){
            this.day++;
            if (this.day > getNumberOfDaysInMonth(this.year, this.month)){
                this.day = 1;
                this.month++;
                if (this.month > 12){
                    this.month = 1;
                    this.year++;
                }
            }
        }
    }

    /**
     * subtractDays: -> public
     *     returns void. Parameters: int days
     *     will subtract the said number of days from the date.
     **/
    public void subtractDays (int days){
        for(int i = 0; i < days; i++){
            this.day--;
            if (this.day == 0){
                this.month--;
                if (this.month == 0){
                    this.month = 12;
                    this.year--;
                }
                this.day = getNumberOfDaysInMonth(this.year, this.month);

            }
        }
    }

    /**
     *getNumberOfDaysInMonth -> private
     *     returns int. Parameters: int year, int month
     *     will return the number of days in a month given the year and month
     **/
    private int getNumberOfDaysInMonth(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;

            case 2: if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }

            default:
                return 0;
        }
    }

    /**
     * isLeapYear: -> public
     *     returns boolean.
     *     will return true or false if year is a leap year or not.
     **/
    public boolean isLeapYear(){
        return getYear() % 4 == 0;
    }

    /**
     * overload isLeapYear -> private
     *     returns boolean. Parameters: int year
     *     will take a given year and determine if it is a leap year.
     **/
    public boolean isLeapYear(int year){
        return year % 4 == 0;
    }

    public int getYear(){
        return this.year;
    }
    public int getMonth(){
        return this.month;
    }

    public int getDayOfMonth(){
        return this.day;
    }

    /**
     * getNumberOfDaysInYear -> private
     *      returns int. Parameters: int year
     *      will return the number of days in a year.
     **/
    private int getNumberOfDaysInYear(int year){
        if(isLeapYear(year)){
            return 366;
        }else return 365;
    }

    /**
     * printLongDate -> public
     *      returns void
     *      will print out the date without a carriage return in the format:
     *      Monthname dd, yyyy
     **/
    public void printLongDate(){
        System.out.print(getMonthName() + " " + this.day +", " + this.year);
    }

    /**
     *      printShortDate -> public
     *      returns void.
     *      will print out the date without a carriage return in the format:
     *      mm/dd/yyyy
     **/
    public void printShortDate(){
        System.out.print(this.month + "/" + this.day +"/" + this.year);
    }

    /**
     * Class Getter Methods
     **/
    public String getMonthName(){
        switch (this.month){
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Error: Month number not found.";
        }
    }



    /**
     * overload getMonthName -> private
     *      returns string. parameters int month
     *      will return a string of the month name from the given month.
     **/
    private String getMonthName(int month){
        switch (month){
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Error: Month number not found.";
        }
    }
}

