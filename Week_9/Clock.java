public class Clock {
    private int hr, min;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        int hr = h;
        int min = m;
        if (hr < 0 || hr >= 24)
            throw new IllegalArgumentException();
        if (min < 0 || min >= 60)
            throw new IllegalArgumentException();
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
        public Clock(String s) {
        if (s.length() > 5) throw new IllegalArgumentException("Invalid time format");
        if (s.charAt(2) != ':') throw new IllegalArgumentException("Invalid time format");
        String[] time = s.split(":");
        int hour = Integer.parseInt(time[0]);
        if(hour < 0 || hour >= 24) throw new IllegalArgumentException("Input hour out of range!");
        hr = hour;
        int minute = Integer.parseInt(time[1]);
        if(minute < 0 || minute >= 60) throw new IllegalArgumentException("Input minute out of range!");
        min = minute;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String h = "";
        String m = "";
        //apend a 0 to the hour if is less than 10
        if (hr < 10)
            h = "0" + hr;
        else
            //apend a 0 to the min if is less than 10
            h += hr;
        if (min < 10)
            m = "0" + min;
        else
            m += min;
        return h + ":" + m;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (hr < that.hr)
            return true;
        if (hr > that.hr)
            return false;
        return (min < that.min);
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        //if hour is less or equal than 23  and min less than 59 then increase minute   
        if (hr <= 23 && min < 59) {
            min++;
            return;
        }
        //if hour is 23 and min 59 then increase hour          
        if (hr < 23 && min == 59) {
            hr++;
            min = 00;
            return;
        }
        //if min is 23 and min 59, then reset clock to 0:0
        if (hr == 23 && min == 59) {
            hr = 0;
            min = 00;
            return;
        }

    }
    // Add Δ minutes to the current time. For example, 60 minutes after 12:34 is 13:34. Throw an IllegalArgumentException if Δ is negative.
    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException("delta must be posite");
        min += delta;
        int deltaa = min / 60;
        int reminder = min % 60;

        if (deltaa > 0) {
            hr += deltaa;
            min = reminder;

            hr = hr % 24;
        }
    }

    // Test client (see below).
    public static void main(String[] args) {
        // Checking the constructor behaviour
        Clock a = new Clock(9, 56);
        Clock b = new Clock(5, 59);
        // Ordering is 00:00 to 23:59
        StdOut.println("Is " + a + " earlier than " + b + "? " + a.isEarlierThan(b));

        a.toString();
        StdOut.println(a.toString());
        a.tic();
        StdOut.println("a tic: " + a);
        b.toc(100);
        StdOut.printf("b: %s\n", b);
    }
}