package com.example.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateUtils {
    private static int weeks = 0;
    private static int MaxDate;
    private static int MaxYear;
    public static String sdfl = "yyyy-MM-dd HH:mm:sss";

    public DateUtils() {
    }

    public static Date getData() {
        return new Date();
    }

    public static String getTwoDay(String sj1, String sj2) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        long day = 0L;

        try {
            Date date = myFormatter.parse(sj1);
            Date mydate = myFormatter.parse(sj2);
            day = (date.getTime() - mydate.getTime()) / 86400000L;
        } catch (Exception var7) {
            return "";
        }

        return day + "";
    }

    public static long getTwoDay_long(String sj1, String sj2) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        long day = 0L;

        try {
            Date date = myFormatter.parse(sj1);
            Date mydate = myFormatter.parse(sj2);
            day = (date.getTime() - mydate.getTime()) / 86400000L;
            return day;
        } catch (Exception var7) {
            return 0L;
        }
    }

    public static long getTwoDay_long(Date date, Date mydate) {
        new SimpleDateFormat("yyyy-MM-dd");
        long day = 0L;

        try {
            day = (date.getTime() - mydate.getTime()) / 86400000L;
            return day;
        } catch (Exception var6) {
            return 0L;
        }
    }

    public static int parseYear(String value) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(formatter.parse(value));
            return calendar.get(1);
        } catch (Exception var3) {
            return -1;
        }
    }

    public static int parseMonth(String value) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(formatter.parse(value));
            return calendar.get(2) + 1;
        } catch (Exception var3) {
            return -1;
        }
    }

    public static int parseYear_one(String value) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(formatter.parse(value));
            return calendar.get(1);
        } catch (Exception var3) {
            return -1;
        }
    }

    public static int parseMonth_one(String value) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(formatter.parse(value));
            return calendar.get(2) + 1;
        } catch (Exception var3) {
            return -1;
        }
    }

    public static int getMonth(String value) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(formatter.parse(value));
            return calendar.get(2) + 1;
        } catch (Exception var3) {
            return -1;
        }
    }

    public static String getWeek(String sdate) {
        Date date = strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return (new SimpleDateFormat("EEEE")).format(c.getTime());
    }

    public static int getWeek2(String sdate) {
        Date date = strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int hour = c.get(7);
        return hour;
    }

    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    public static Date strToDate(String strDate, String fmt) {
        SimpleDateFormat formatter = new SimpleDateFormat(fmt);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(sdfl);

        try {
            return formatter.parse(strDate);
        } catch (ParseException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static long getDays(String date1, String date2) {
        if(date1 != null && !date1.equals("")) {
            if(date2 != null && !date2.equals("")) {
                SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                Date mydate = null;

                try {
                    date = myFormatter.parse(date1);
                    mydate = myFormatter.parse(date2);
                } catch (Exception var7) {
                    ;
                }

                long day = (date.getTime() - mydate.getTime()) / 86400000L;
                return day;
            } else {
                return 0L;
            }
        } else {
            return 0L;
        }
    }

    public static String getLastDayOfMonth() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(5, 1);
        lastDate.add(2, 1);
        lastDate.add(5, -1);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    public static String getPreviousMonthFirst() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(5, 1);
        lastDate.add(2, -1);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    public static String getPreviousMonthEnd() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.add(2, -1);
        lastDate.set(5, 1);
        lastDate.roll(5, -1);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    public static String getNewDatetimeLastMonth(int pr) {
        Calendar lastDate = Calendar.getInstance();
        lastDate.add(2, pr);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        return simpleDateFormat.format(lastDate.getTime());
    }

    public static String getPreviousMonthFirst(String date) {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();

        try {
            lastDate.setTime(sdf.parse(date));
            lastDate.set(5, 1);
            lastDate.add(2, -1);
            str = sdf.format(lastDate.getTime());
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        return str;
    }

    public static String getPreviousMonthEnd(String date) {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();

        try {
            lastDate.setTime(sdf.parse(date));
            lastDate.add(2, -1);
            lastDate.set(5, 1);
            lastDate.roll(5, -1);
            str = sdf.format(lastDate.getTime());
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        return str;
    }

    public static String getFirstDayOfMonth() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(5, 1);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    public static String firstDayOfMonth(Date date, int amount) {
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, amount);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return yyyyMMdd.format(calendar.getTime());
    }

    public static String getCurrentWeekday() {
        weeks = 0;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, mondayPlus + 6);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    public String getNowTime(String dateformat) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);
        String hehe = dateFormat.format(now);
        return hehe;
    }

    public static String date2String(Date date, String dateFomat) {
        if(null == date) {
            return null;
        } else if(null == dateFomat) {
            return null;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat(dateFomat);
            return dateFormat.format(date);
        }
    }

    public static String date2String() {
        return date2String(new Date(), sdfl);
    }

    public static String date2String(Date date) {
        return date2String(date, sdfl);
    }

    private static int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        int dayOfWeek = cd.get(7) - 1;
        return dayOfWeek == 1?0:1 - dayOfWeek;
    }

    public static String getMondayOFWeek() {
        weeks = 0;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, mondayPlus);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    public static String getSaturday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, mondayPlus + 7 * weeks + 6);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    public static String getPreviousWeekSunday() {
        weeks = 0;
        --weeks;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, mondayPlus + weeks);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    public static String getPreviousWeekday() {
        --weeks;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, mondayPlus + 7 * weeks);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    public static String getNextMonday() {
        ++weeks;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, mondayPlus + 7);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    public static String getNextSunday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, mondayPlus + 7 + 6);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    private static int getMonthPlus() {
        Calendar cd = Calendar.getInstance();
        int monthOfNumber = cd.get(5);
        cd.set(5, 1);
        cd.roll(5, -1);
        MaxDate = cd.get(5);
        return monthOfNumber == 1?-MaxDate:1 - monthOfNumber;
    }

    public static String getNextMonthFirst() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.add(2, 1);
        lastDate.set(5, 1);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    public static String getNextMonthEnd() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.add(2, 1);
        lastDate.set(5, 1);
        lastDate.roll(5, -1);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    public static String getNextYearEnd() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.add(1, 1);
        lastDate.set(6, 1);
        lastDate.roll(6, -1);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    public static String getNextYearFirst() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.add(1, 1);
        lastDate.set(6, 1);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    private static int getMaxYear() {
        Calendar cd = Calendar.getInstance();
        cd.set(6, 1);
        cd.roll(6, -1);
        int MaxYear = cd.get(6);
        return MaxYear;
    }

    private static int getYearPlus() {
        Calendar cd = Calendar.getInstance();
        int yearOfNumber = cd.get(6);
        cd.set(6, 1);
        cd.roll(6, -1);
        int MaxYear = cd.get(6);
        return yearOfNumber == 1?-MaxYear:1 - yearOfNumber;
    }

    public static String getCurrentYearFirst() {
        int yearPlus = getYearPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, yearPlus);
        Date yearDay = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preYearDay = df.format(yearDay);
        return preYearDay;
    }

    public static String getCurrentYearEnd() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String years = dateFormat.format(date);
        return years + "-12-31";
    }

    public static String getPreviousYearFirst() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String years = dateFormat.format(date);
        int years_value = Integer.parseInt(years);
        --years_value;
        return years_value + "-1-1";
    }

    public static String getPreviousYearEnd() {
        --weeks;
        int yearPlus = getYearPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, yearPlus + MaxYear * weeks + (MaxYear - 1));
        Date yearDay = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preYearDay = df.format(yearDay);
        getThisSeasonTime(11);
        return preYearDay;
    }

    public static String getThisSeasonTime(int month) {
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int season = 1;
        if(month >= 1 && month <= 3) {
            season = 1;
        }

        if(month >= 4 && month <= 6) {
            season = 2;
        }

        if(month >= 7 && month <= 9) {
            season = 3;
        }

        if(month >= 10 && month <= 12) {
            season = 4;
        }

        int start_month = array[season - 1][0];
        int end_month = array[season - 1][2];
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String years = dateFormat.format(date);
        int years_value = Integer.parseInt(years);
        int start_days = 1;
        int end_days = getLastDayOfMonth(years_value, end_month);
        String seasonDate = years_value + "-" + start_month + "-" + start_days + ";" + years_value + "-" + end_month + "-" + end_days;
        return seasonDate;
    }

    public static int getLastDayOfMonth(int year, int month) {
        return month != 1 && month != 3 && month != 5 && month != 7 && month != 8 && month != 10 && month != 12?(month != 4 && month != 6 && month != 9 && month != 11?(month == 2?(isLeapYear(year)?29:28):0):30):31;
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static String timestampToString(Timestamp s) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String str = df.format(s);
        return str;
    }

    public static String increaseYear(String date, int years) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        try {
            cal.setTime(dateFormat.parse(date));
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        cal.add(1, years);
        String sdate = dateFormat.format(cal.getTime());
        return sdate;
    }

    public static boolean isValidDateStr(String date) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException var2) {
            return false;
        } catch (IllegalArgumentException var3) {
            return false;
        }
    }

    public static boolean isNotValidDateStr(String date) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(false);
            df.parse(date);
            return false;
        } catch (ParseException var2) {
            return true;
        } catch (IllegalArgumentException var3) {
            return true;
        }
    }

    public static Timestamp stringToTimestamp(String timestampStr, String format) {
        if(timestampStr != null && !timestampStr.trim().equals(" ")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);

            try {
                Date date = dateFormat.parse(timestampStr);
                return new Timestamp(date.getTime());
            } catch (Exception var4) {
                System.out.println(var4.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }

    public static String getNewYear() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }

    public static String getNewdate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }

    public static String getDataQWithyyyyMMddHHmmss() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }

    public static String getNewdate_one() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }

    public static String getTimeByFormat(String fromat) {
        SimpleDateFormat formatter = new SimpleDateFormat(fromat);
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }

    public static String getTimeByFormat(Date date, String fromat) {
        SimpleDateFormat formatter = new SimpleDateFormat(fromat);
        return formatter.format(date);
    }

    public static Long getTimeLong() {
        return Long.valueOf(System.currentTimeMillis());
    }

    public static String getNowtime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }

    public static String getNewdateBygs(String famt) {
        SimpleDateFormat formatter = new SimpleDateFormat(famt);
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }

    public static double jisuan(String date1, String date2) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
        Date start = sdf.parse(date1);
        Date end = sdf.parse(date2);
        long cha = end.getTime() - start.getTime();
        double result = (double)cha * 1.0D / 3600000.0D;
        return result;
    }

    public static String getDayBeforeBynumber(int nu, String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -nu);
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    private static String dateToString(String date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");

        try {
            Date time = formatDate.parse(date);
            return formatDate.format(time);
        } catch (ParseException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static Date datejisuan(String date1, int un) throws Exception {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(12, 270);
        return c.getTime();
    }

    public static String datejisuan_str(String date1, int un) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = formatter.parse(date1);
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.add(12, un);
        String str = formatter.format(c.getTime());
        return str;
    }

    public static Date TimeStamp2Data(Long s) {
        Date date = new Date(s.longValue());
        return date;
    }

    public static String jisuanString(String date1, String date2) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
        Date start = sdf.parse(date1);
        Date end = sdf.parse(date2);
        long cha = end.getTime() - start.getTime();
        String result = String.valueOf((double)cha * 1.0D / 3600000.0D);
        String her = result.substring(0, result.indexOf("."));
        String feng = String.valueOf(Double.valueOf(result.substring(result.indexOf("."))).doubleValue() * 60.0D);
        return her + ":" + feng.substring(0, feng.indexOf("."));
    }

    public static String getTime(String datetime, boolean disSecond) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = null;

        try {
            Date date = sdf.parse(datetime);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            String minute = c.get(12) + "";
            String second = c.get(13) + "";
            String hour = c.get(11) + "";
            if(c.get(11) < 10) {
                hour = "0" + c.get(11);
            }

            if(c.get(12) < 10) {
                minute = "0" + c.get(12);
            }

            if(c.get(13) < 10) {
                second = "0" + c.get(13);
            }

            if(disSecond) {
                time = hour + ":" + minute + ":" + second;
            } else {
                time = hour + ":" + minute;
            }
        } catch (ParseException var9) {
            var9.printStackTrace();
        }

        return time;
    }

    public static Integer getMinutes(String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Integer minutes = Integer.valueOf(0);

        try {
            Date dedate = sdf.parse(date1);
            Date arrdate = sdf.parse(date2);
            minutes = Integer.valueOf(Integer.parseInt((arrdate.getTime() - dedate.getTime()) / 60L / 1000L + ""));
        } catch (ParseException var6) {
            var6.printStackTrace();
        }

        return minutes;
    }

    public static Date getDateAddNuber(int day, String foramt) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(foramt);
        Date date = null;

        try {
            date = simpleDateFormat.parse(getDayBeforeBynumber(day, foramt));
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        return date;
    }

    public static Date getTodayStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTime();
    }

    public static Date getDateBeginTime(Date date) {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(date);
        startCal.set(Calendar.HOUR_OF_DAY, 0);
        startCal.set(Calendar.MINUTE, 0);
        startCal.set(Calendar.SECOND, 0);
        return startCal.getTime();
    }

    public static Date getDateEndTime(Date date) {
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(date);
        endCal.set(Calendar.HOUR_OF_DAY, 23);
        endCal.set(Calendar.MINUTE, 59);
        endCal.set(Calendar.SECOND, 59);
        return endCal.getTime();
    }

    public static void main(String[] args) throws Exception {
        String me = getNewdate();
        System.out.println(getTimeByFormat("HH"));
        Date now = new Date();
        String validDay = date2String(now, "yyyy-MM-dd");
        System.out.println(validDay);
    }
}