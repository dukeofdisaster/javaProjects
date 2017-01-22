/**
 *
 * Description: Time class for manipulating the time. The most difficult part of
 * the program was the addMinutes() method which had to account for user input
 * over 60
 *
 * Completion time: approximately 4 hours
 *
 *
 *
 * @author Joshua Ortiz
 *
 * @version 1.0
 *
 */
package main;

public class Time {

    private int hour;
    private int minute;

    //1. Default Constructor
    public Time() {
        hour = 0;
        minute = 0;

    }

    // 2. Constructor with given hr/min
    public Time(int HH, int MM) {
        if (HH >= 0 && HH <= 23) {
            hour = HH;
        } else {
            System.out.println("Invalid hour");
        }
        if (MM >= 0 && MM <= 59) {
            minute = MM;
        } else {
            System.out.println("Invalid Minutes");
        }

    }

    //3. Accessor for hour value
    public int getHour() {
        return hour;
    }

    // 4. Accessor for minute value
    public int getMinute() {
        return minute;
    }

    // 5. mutator for hour value. Modulo is used to roll over values to the next
    //    24hr period; I could have allowed the method to only add values that
    //    would be less then 24 when added to the hour; this method is less
    //    restrictive.
    public void addHours(int x) {
        int sum = hour + x;
        hour = sum % 24;
    }

    // 6. mutator for minute value; only allows values from 0-60 that when
    //    added to the minutes, aren't over 60.
    public void addMinutes(int y) {
        double x = y;
        double overSixty;
        double leftOverMinutesFromHourConversion;
        double decimaltoMinutes;
        double roundedMinutes;
        if (x >= 0 && x <= 59 && (x + minute) < 60) {
            minute += (x / 1);
        } else if (x > 59) {
            //returns the decimal value in hours
            overSixty = x / 60;

            //--Uncomment  System.out.println(overSixty);
            // gets the decimal remainder of overSixty
            leftOverMinutesFromHourConversion = overSixty % 1;
            //System.out.println(leftOverMinutes);

            // adds value of minutes > 59 converted to hours to the hour variable
            hour += (overSixty - leftOverMinutesFromHourConversion);

            // Multiplied by 61 because multiplying by 60 wasn't giving the correct
            // conversion and rather than importing math it seemed simpler to just
            // bump the mutliplier up to 61 since that would give the actual time in seconds.
            // whereas multplying by 60 was returning .9999999999965.
            decimaltoMinutes = leftOverMinutesFromHourConversion * 61;
            roundedMinutes = decimaltoMinutes - (decimaltoMinutes % 1);

            //Check if hour will need to be changed again
            if ((minute + roundedMinutes) > 60) {
                //get our total minutes
                double tooManyMinutes = minute + roundedMinutes;
                //divide those minutes by 60 to get the hour value
                double minutesToHour = tooManyMinutes / 60;
                //separate the decimal from the integer
                double minutesLeftOver2 = minutesToHour % 1;
                double hourToAdd = (minutesToHour - minutesLeftOver2);

                //It is important to add
                double minutesToAdd = minutesLeftOver2 * 61;
                hour += hourToAdd;
                minute = (int) minutesToAdd;

            } else if ((minute + roundedMinutes) == 60) {
                hour += 1;
            } else {
                minute += roundedMinutes;
            }
        }
    }

    // 7. mutator to add hour and minute from external Time instance to current
    //    instance.  1/20: Need to debug
    public void addTime(Time x) {
        this.hour = x.getHour() + hour;
        this.minute = x.getMinute() + minute;
    }

    // 8. cloning method
    public Time getCopy() {
        int copiedHour = hour;
        int copiedMinute = minute;
        Time clone = new Time(copiedHour, copiedMinute);
        return clone;
    }

    // 9. Method to compare times of Time objects.
    public Boolean isEarlierThan(Time x) {
        Boolean earlierThan = false;
        if (this.hour > x.getHour()) {
            earlierThan = false;
        } else if (this.hour < x.getHour()) {
            earlierThan = true;
        } else if (this.hour == x.getHour() && this.minute >= x.getMinute()) {
            earlierThan = false;
        } else if (this.hour == x.getHour() && this.minute < x.getMinute()) {
            earlierThan = true;
        }
        return earlierThan;
    }

    // 10. Check for same times
    public Boolean isSameTime(Time x) {
        Boolean sameTime = false;
        if (this.hour == x.getHour() && this.minute == x.getMinute()) {
            sameTime = true;
        }
        return sameTime;
    }

    // 11. see if current Time is later than external Time
    public Boolean isLaterThan(Time x) {
        Boolean laterThan;
        if (this.hour > x.getHour()) {
            laterThan = true;
        } else if (this.hour == x.getHour() && this.minute > x.getMinute()) {
            laterThan = true;
        } else {
            laterThan = false;
        }

        return laterThan;
    }

    @Override
    public String toString() {
        int twelveHourFormat = hour;
        String formattedTime;
        if (hour >= 12) {
            if (hour > 12) {
                twelveHourFormat = hour - 12;
            }
            formattedTime = String.format("%1$02d:%2$02d PM", twelveHourFormat, minute);
        } else if (hour == 0) {
            twelveHourFormat = 12;
            formattedTime = String.format("%1$02d:%2$02d AM", twelveHourFormat, minute);
        } else {
            formattedTime = String.format("%1$02d:%2$02d AM", twelveHourFormat, minute);
        }
        return formattedTime;
    }

}
