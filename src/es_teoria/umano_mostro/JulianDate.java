package es_teoria.umano_mostro;

import java.util.Calendar;

public class JulianDate {
    public static int JGREG = 15 + 31 * (10 + 12 * 1582);

    public static double toJulian(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);

        int julianYear = year;
        if (year < 0) julianYear++;
        int julianMonth = month;
        if (month > 2) {
            julianMonth++;
        } else {
            julianYear--;
            julianMonth += 13;
        }

        double julian = (Math.floor(365.25 * julianYear) + Math.floor(30.6001 * julianMonth) + day + 1720995.0);

        if (day + 31 * (month + 12 * year) >= JGREG) {
            int ja = (int) (0.01 * julianYear);
            julian += 2 - ja + (0.25 * ja);
        }

        return Math.floor(julian);
    }
}