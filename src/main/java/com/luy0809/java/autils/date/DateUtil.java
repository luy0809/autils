package com.luy0809.java.autils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by luyu on 16-12-1.
 */
public class DateUtil {


    private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 获取当日零点时间戳
     * @return
     */
    public static long getCurrentDayZeroTime(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (long) (cal.getTimeInMillis()/1000);
    }

    /**
     * 获取下一日零点时间戳
     * @return
     */
    public static long getNexDayZeroTime(){
        Calendar cal = Calendar.getInstance();
        cal.add(cal.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (long) (cal.getTimeInMillis()/1000);
    }

    /**
     * 获取当日日期
     * @return
     */
    public static String getCurrentDayTime(){
        return format.format(new Date());
    }

    /**
     * 获取明天日期
     * @param
     */
    public static String getNextDayTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(calendar.getTime());
        return dateString;
    }

    /**
     * Unix时间戳转换为小时，分
     * @param
     */
    public static long[] covertTimeFromTimestamp(long time){
        long[] result = new long[2];
        long hour=time/3600;
        long minutes=time%3600/60;
        result[0]=hour;
        result[1]=minutes;
        return result ;
    }

    /**
     * 获得时间零点时间
     * @param date
     * @return
     */
    public static long getDayZeroTime(String date){
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (long) (cal.getTimeInMillis()/1000);
    }

    /**
     * 计算两个日期之间相差的天数
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate,Date bdate) throws ParseException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }


    /**
     * 字符串的日期格式的计算
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(String smdate,String bdate) {
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(smdate));
            long time1 = cal.getTimeInMillis();
            cal.setTime(sdf.parse(bdate));
            long time2 = cal.getTimeInMillis();
            long between_days=(time2-time1)/(1000*3600*24);
            return Integer.parseInt(String.valueOf(between_days));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static String TimeStamp2Date(Long timestampString, String formats){
        if("".equals(formats)||formats==null){
            formats = "yyyyMMdd";
        }
        Long timestamp = timestampString*1000;
        String date = new java.text.SimpleDateFormat(formats).format(new java.util.Date(timestamp));
        return date;
    }

    /**
     * @param date 指定日期
     * @param days 正数为之后ｎ天，负数为之前ｎ天
     * @return
     */
    public static Long  dateUnixTimeDays(String date,int days){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date_ = sdf.parse(date);
            Calendar cal = new GregorianCalendar();
            cal.setTime(date_);
            cal.add(Calendar.DATE, days);
            long timestamp = cal.getTimeInMillis();
            return timestamp/1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param days 正数为之后ｎ天，负数为之前ｎ天
     * @return
     */
    public static String  unixTimeDays(int days){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, days);
        Date monday = c.getTime();
        c.setTime(monday);
        long timestamp = c.getTimeInMillis()/1000;
        String datetime = sdf.format(new java.util.Date(timestamp));
        return datetime;
    }




}
