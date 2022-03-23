package es_teoria.umano_mostro;

import java.util.Calendar;

public class MoonPhase {
    public static final double MY_PI = 3.14159265358979323846;
    public static final double EPOCH = 2444238.5;    /* 1980 January 0.0. */
    public static final double SUN_ELONG_EPOCH = 278.833540;   /* Ecliptic longitude of the Sun at epoch 1980.0. */
    public static final double SUN_ELONG_PERIGEE = 282.596403;   /* Ecliptic longitude of the Sun at perigee. */
    public static final double ECCENT_EARTH_ORBIT = 0.016718;     /* Eccentricity of Earth's orbit. */
    public static final double MOON_MEAN_LONGITUDE_EPOCH = 64.975464;    /* Moon's mean lonigitude at the epoch. */
    public static final double MOON_MEAN_LONGITUDE_PERIGREE = 349.383063;   /* Mean longitude of the perigee at the epoch. */
    public static final double KEPLER_EPSILON = 1E-6;         /* Accurancy of the Kepler equation. */


    private static double FIXANGLE(double a) {
        return (a) - 360.0 * (Math.floor((a) / 360.0));
    }

    private static double TORAD(double d) {
        return (d) * (MY_PI / 180.0);
    }

    private static double TODEG(double r) {
        return (r) * (180.0 / MY_PI);
    }

    private static double kepler(double m) {
        double e;
        double delta;
        e = m = TORAD(m);
        do {
            delta = e - ECCENT_EARTH_ORBIT * Math.sin(e) - m;
            e -= delta / (1.0 - ECCENT_EARTH_ORBIT * Math.cos(e));
        } while (Math.abs(delta) - KEPLER_EPSILON > 0.0);

        return (e);
    }


    public static double phase(Calendar date) {
        double julian_date = JulianDate.toJulian(date);

        double date_within_epoch;
        double sun_eccent;
        double sun_mean_anomaly;
        double sun_perigree_co_ordinates_to_epoch;
        double sun_geocentric_elong;
        double moon_evection;
        double moon_variation;
        double moon_mean_anomaly;
        double moon_mean_longitude;
        double moon_annual_equation;
        double moon_correction_term1;
        double moon_correction_term2;
        double moon_correction_equation_of_center;
        double moon_corrected_anomaly;
        double moon_corrected_longitude;
        double moon_present_age;
        double moon_present_phase;
        double moon_present_longitude;

        /*
           Calculation of the Sun's position.
        */
        date_within_epoch = julian_date - EPOCH;
        sun_mean_anomaly = FIXANGLE((360.0 / 365.2422) * date_within_epoch);
        sun_perigree_co_ordinates_to_epoch = FIXANGLE(sun_mean_anomaly + SUN_ELONG_EPOCH - SUN_ELONG_PERIGEE);
        sun_eccent = kepler(sun_perigree_co_ordinates_to_epoch);
        sun_eccent = Math.sqrt((1.0 + ECCENT_EARTH_ORBIT) / (1.0 - ECCENT_EARTH_ORBIT)) * Math.tan(sun_eccent / 2.0);
        sun_eccent = 2.0 * TODEG(atan(sun_eccent));
        sun_geocentric_elong = FIXANGLE(sun_eccent + SUN_ELONG_PERIGEE);
        /*
           Calculation of the Moon's position.
        */
        moon_mean_longitude = FIXANGLE(13.1763966 * date_within_epoch + MOON_MEAN_LONGITUDE_EPOCH);
        moon_mean_anomaly = FIXANGLE(moon_mean_longitude - 0.1114041 * date_within_epoch - MOON_MEAN_LONGITUDE_PERIGREE);
        moon_evection = 1.2739 * Math.sin(TORAD(2.0 * (moon_mean_longitude - sun_geocentric_elong) - moon_mean_anomaly));
        moon_annual_equation = 0.1858 * Math.sin(TORAD(sun_perigree_co_ordinates_to_epoch));
        moon_correction_term1 = 0.37 * Math.sin(TORAD(sun_perigree_co_ordinates_to_epoch));
        moon_corrected_anomaly = moon_mean_anomaly + moon_evection - moon_annual_equation - moon_correction_term1;
        moon_correction_equation_of_center = 6.2886 * Math.sin(TORAD(moon_corrected_anomaly));
        moon_correction_term2 = 0.214 * Math.sin(TORAD(2.0 * moon_corrected_anomaly));
        moon_corrected_longitude = moon_mean_longitude + moon_evection + moon_correction_equation_of_center - moon_annual_equation + moon_correction_term2;
        moon_variation = 0.6583 * Math.sin(TORAD(2.0 * (moon_corrected_longitude - sun_geocentric_elong)));

        // true longitude
        moon_present_longitude = moon_corrected_longitude + moon_variation;
        moon_present_age = moon_present_longitude - sun_geocentric_elong;
        moon_present_phase = 100.0 * ((1.0 - Math.cos(TORAD(moon_present_age))) / 2.0);

        if (0.0 < FIXANGLE(moon_present_age) - 180.0) {
            moon_present_phase = -moon_present_phase;
        }

        return moon_present_phase;
    }

    private static double atan(double x) {
        double SQRT3 = 1.732050807568877294;
        boolean signChange = false;
        boolean Invert = false;
        int sp = 0;
        double x2, a;
        // check up the sign change
        if (x < 0.) {
            x = -x;
            signChange = true;
        }
        // check up the invertation
        if (x > 1.) {
            x = 1 / x;
            Invert = true;
        }
        // process shrinking the domain until x<PI/12
        while (x > Math.PI / 12) {
            sp++;
            a = x + SQRT3;
            a = 1 / a;
            x = x * SQRT3;
            x = x - 1;
            x = x * a;
        }
        // calculation core
        x2 = x * x;
        a = x2 + 1.4087812;
        a = 0.55913709 / a;
        a = a + 0.60310579;
        a = a - (x2 * 0.05160454);
        a = a * x;
        // process until sp=0
        while (sp > 0) {
            a = a + Math.PI / 6;
            sp--;
        }
        // invertation took place
        if (Invert) a = Math.PI / 2 - a;
        // sign change took place
        if (signChange) a = -a;
        //
        return a;
    }
}
