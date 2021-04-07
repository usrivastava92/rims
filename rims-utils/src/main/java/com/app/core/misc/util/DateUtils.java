package com.app.core.misc.util;

import com.app.core.exceptions.InvalidDataException;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.time.FastDateFormat;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtils {
    public static String ALTERNATE_TIME_FORMAT = "hh:mm a";
    public static String DEFAULT_TIME_FORMAT = "hh:mm:ss a";

    public static Date businessDate = null;

    private static final Map<String, FastDateFormat> FORMATTER_CACHE = new LinkedHashMap();

    public static String formatDate(String format, Date date) {
        if (date == null) {
            return null;
        }
        return getFormatter(format).format(date);
    }

    public static String formatDate(String format, Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        return getFormatter(format).format(calendar.getTime());
    }

    public static DateTime getCurrentUTCTime() {
        return getCurrentForTimeZone(DateTimeZone.UTC);
    }

    public static DateTime getCurrentForTimeZone(DateTimeZone timeZone) {
        return new DateTime(timeZone);
    }

    private static FastDateFormat getFormatter(String pattern) {
        if (!FORMATTER_CACHE.containsKey(pattern)) {
            FORMATTER_CACHE.put(pattern, FastDateFormat.getInstance(pattern));
        }
        return (FastDateFormat) FORMATTER_CACHE.get(pattern);
    }

    public static String getFormattedDate(DateTime dateTime, String dateFormat) {
        DateTimeFormatter format = DateTimeFormat.forPattern(dateFormat);
        return format.print(dateTime);
    }

    public static String getFormattedDate(String dateTime, String dateFormat) {
        DateTimeFormatter format = DateTimeFormat.forPattern(dateFormat);
        DateTime date = format.parseDateTime(dateTime);
        return format.print(date);
    }

    public static DateTime convertToUtcTime(DateTime dateTime) {
        return dateTime.withZone(DateTimeZone.UTC);
    }

    public static DateTime parse(String dateTime, String dateFormat) {
        return DateTimeFormat.forPattern(dateFormat).parseDateTime(dateTime);
    }

    public static Date getBusinessDate() {
        if (businessDate != null) {
            return businessDate;
        }

        return getCurrentForTimeZone(DateTimeZone.UTC).toDate();
    }

    public static Map<String, Integer> getDifferenceBetweenTwoDates(DateTime startDate, DateTime endDate) {
        int yearsBetween = 0;
        int monthsBetween = 0;
        int daysBetween = 0;
        Map<String, Integer> dateDifferenceMap = new HashMap<String, Integer>();
        int[] monthDay = { 31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int increment = 0;

        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        if (startDate != null) {
            try {
                if (startDate.isAfter(endDate)) {
                    throw new InvalidDataException("Invalid Data : Start Date greater than End Date");
                }
            } catch (InvalidDataException e) {
                System.out.println("Invalid Data : Start Date greater than End Date" + e);
                resultMap.put("result", Integer.valueOf(-1));
                return resultMap;
            }
            GregorianCalendar cal = new GregorianCalendar();

            if (startDate.getDayOfMonth() > endDate.getDayOfMonth()) {
                increment = monthDay[startDate.getMonthOfYear() - 1];
            }

            if (increment == -1) {
                if (cal.isLeapYear(startDate.getYear())) {
                    increment = 29;
                } else {
                    increment = 28;
                }
            }

            if (increment != 0) {
                daysBetween = endDate.getDayOfMonth() + increment - startDate.getDayOfMonth();
                increment = 1;
            } else {
                daysBetween = endDate.getDayOfMonth() - startDate.getDayOfMonth();
            }

            if (startDate.getMonthOfYear() + increment > endDate.getMonthOfYear()) {
                monthsBetween = endDate.getMonthOfYear() + 12 - startDate.getMonthOfYear() + increment;
                increment = 1;
            } else {
                monthsBetween = endDate.getMonthOfYear() - startDate.getMonthOfYear() + increment;
                increment = 0;
            }

            yearsBetween = endDate.getYear() - startDate.getYear() + increment;

            daysBetween++;

            if (monthDay[endDate.getMonthOfYear() - 1] == -1) {
                if (cal.isLeapYear(endDate.getYear())) {
                    monthDay[endDate.getMonthOfYear() - 1] = 29;
                } else {
                    monthDay[endDate.getMonthOfYear() - 1] = 28;
                }
            }
            if (daysBetween >= monthDay[endDate.getMonthOfYear() - 1]) {
                monthsBetween += daysBetween / monthDay[endDate.getMonthOfYear() - 1];
                daysBetween -= daysBetween / monthDay[endDate.getMonthOfYear() - 1]
                        * monthDay[endDate.getMonthOfYear() - 1];
                if (monthsBetween >= 12) {
                    yearsBetween += monthsBetween / 12;
                    monthsBetween -= monthsBetween / 12 * 12;
                }
            }
        }

        dateDifferenceMap.put("daysBetween", Integer.valueOf(daysBetween));
        dateDifferenceMap.put("monthsBetween", Integer.valueOf(monthsBetween));
        dateDifferenceMap.put("yearsBetween", Integer.valueOf(yearsBetween));

        return dateDifferenceMap;
    }
}
