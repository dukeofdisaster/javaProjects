// TAKEN FROM SOLUTION SET!!!!!!!!!!!!!!!!!!!!!!!
package main;

/**
 *
 * @author joshortiz
 */
public class Time {

    int hour;
    int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public Time() {
        this.hour = 12;
        this.minute = 0;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public void addHours(int hoursToAdd) {
        this.hour = ((this.hour + hoursToAdd % 24) + 24) % 24;
    }

    public void addMinutes(int minutesToAdd) {
        this.minute += minutesToAdd;
        this.minute = ((this.minute % (24 * 60)) + (24 * 60)) % (24 * 60);
        this.addHours((int) Math.floor(((double) this.minute) / (60.0)));
        this.minute = this.minute % 60;
    }

    public void addTime(Time timeToAdd) {
        this.addHours(timeToAdd.hour);
        this.addMinutes(timeToAdd.minute);

    }

    public Time getCopy() {
        return new Time(this.hour, this.minute);
    }

    public boolean isEarlierThan(Time timeToCompare) {
        if (hour < timeToCompare.getHour()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSameTime(Time timeToCompare) {
        if ((this.hour == timeToCompare.hour) && (this.minute == timeToCompare.minute)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLaterThan(Time timeToCompare) {
        if (hour > timeToCompare.getHour()) {
            return true;
        } else {
            return false;
        }
    }

    private String formatDigits(int i) {
        boolean negative = false;
        if (i < 0) {
            negative = true;
        }
        int positiveMinutes = Math.abs(i);
        int hours = (int) Math.floor(((double) positiveMinutes) / (60.0));
        int minutes = positiveMinutes % 60;
        String hourMinuteString = hours + "h:" + minutes + "m";
        if (negative) {
            hourMinuteString = "-(" + hourMinuteString + ")";
        }
        return hourMinuteString;
    }

    @Override
    public String toString() {
        int twelveHour = ((this.hour - 1) % 12 + 12) % 12 + 1;
        String minuteString = String.format("%02d", this.minute);
        String meridiem;
        if (this.hour <= 11) {
            meridiem = "AM";
        } else {
            meridiem = "PM";
        }
        return twelveHour + ":" + minuteString + meridiem;
    }
}
