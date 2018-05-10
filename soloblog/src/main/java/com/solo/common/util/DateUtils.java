package com.solo.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 日期工具类               MockUtil.java
 * @Filename: DateUtil.java
 * @Version: 1.0
 *
 */
public class DateUtils {
	
	
    /**
     * 把日期转化为普通字符串
     *
     * @param date
     * @param format 传入转换格式
     * @return
     */
     public static String convertToString(Date date, String format){
          SimpleDateFormat f = new SimpleDateFormat(format);
          return f.format(date);
     }

	/**
	 * 格式化时间戳
	 * 格式yyyy-MM-dd HH:mm:ss
	 * @param timestamp
	 * @return
	 */
	public static String formatTimestamp(long timestamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(timestamp);
		return sdf.format(date);
	}
	
	/**
	 *
	 * 将日期格式yyyyMMddHHmmss转换为yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String formatDateTime2(String dateStr) {
		SimpleDateFormat sSdf = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat tSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result = "";
		try {
			Date date = sSdf.parse(dateStr);
			result = tSdf.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 将日期格式yyyyMMddHHmmss转换为yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String formatDateTime2(Date dateStr) {
		SimpleDateFormat tSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result = "";
		result = tSdf.format(dateStr);
		return result;
	}
	/**
	 * 判断当前时间是否大于传入时间
	 * 传入格式2014-1-24 19:00:45
	 * @param dbDateStr
	 * @return
	 */
	public static boolean isCurrentDateGreaterthanDbDate(String dbDateStr) {
		Date dbDate = new Date();
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			dbDate = sdf.parse(dbDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return currentDate.compareTo(dbDate) > 0;
	}
	
	
	/**
	 * 判断当前时间是否大于等于传入时间
	 * 传入格式2014-1-24 19:00:45
	 * @param dbDateStr
	 * @return
	 */
	public static boolean isCurrentDateGreaterEqualthanDbDate(String dbDateStr) {
		Date dbDate = new Date();
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			dbDate = sdf.parse(dbDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return currentDate.compareTo(dbDate) >= 0;
	}
	/**
	 * 判断当前日期是否大于传入日期（yyyy-MM-dd）gaojian
	 * @return
	 * @throws ParseException
	 */
	public static boolean isCurrentDateGreaterThanDbDate(Date date) throws ParseException{
	    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
	    return sdfDate.parse(sdfDate.format(now)).compareTo(sdfDate.parse(sdfDate.format(date))) > 0;
	}
	
	/**
     * 判断当前日期是否小于传入日期（yyyy-MM-dd）gaojian
     * @return
     * @throws ParseException
     */
    public static boolean isCurrentDateSmallerThanDbDate(Date date) throws ParseException{
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        return sdfDate.parse(sdfDate.format(now)).compareTo(sdfDate.parse(sdfDate.format(date))) < 0;
    }
	
	/**
	 * 判断当前时间是否大于传入时间（HH:mm:ss）  gaojian
	 * @return
	 * @throws ParseException
	 */
	public static boolean isCurrentTimeGreaterThanDbTime(Date date) throws ParseException{
	    SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
	    Date now = new Date();
	    return sdfTime.parse(sdfTime.format(now)).compareTo(sdfTime.parse(sdfTime.format(date))) > 0;
	}
	
	/**
     * 判断当前时间是否小于传入时间（HH:mm:ss）  gaojian
     * @return
     * @throws ParseException
     */
    public static boolean isCurrentTimeSmallerThanDbTime(Date date) throws ParseException{
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        return sdfTime.parse(sdfTime.format(now)).compareTo(sdfTime.parse(sdfTime.format(date))) < 0;
    }
	
	
	/**
	 * 返回两个时间的秒数
	 * @param sStrDate
	 * @param tStrDate
	 * @return
	 */
	public static long getSecondsFromTwoDate(String sStrDate, String tStrDate) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long diffTime = 0;
		try {
			Date sDate = df.parse(sStrDate);
			Date tDate = df.parse(tStrDate);
			diffTime = sDate.getTime() - tDate.getTime();
			diffTime /= 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return diffTime;
	}
	
	/**
	 * 判断当前时间是否大于传入时间
	 * 传入格式2014-1-24 19:00:45
	 * @param dbDateStr
	 * @return
	 */
	public static boolean isCurrentDateGreaterthanDbDate(Date dbDateStr) {
		Date now = new Date();
		return now.compareTo(dbDateStr) > 0;
	}
	
	/**
	 * 格式化当前时间
	 * @return
	 */
	public static String getCurrentDateWithFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	
	/**
	 * 格式化当前时间
	 * @return
	 */
	public static String getCurrentDateWithFormat(String formatStr) {
		SimpleDateFormat sdf = null;
		if(!"".equals(formatStr)){
			sdf = new SimpleDateFormat(formatStr);
		}else{
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		
		return sdf.format(new Date());
	}
	
	
	
	/**
	 * 判断日期1是否大于日期2
	 * @param firstDateStr
	 * @param secondDateStr
	 * @return
	 */
	public static boolean isFirstDateGreaterThanSecondDate(String firstDateStr, String secondDateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		boolean result = false;
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = sdf.parse(firstDateStr);
			date2 = sdf.parse(secondDateStr);
			result = date1.compareTo(date2) > 0;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 在当前日期基础上增删秒数
	 * @param date yyyy-MM-dd HH:mm:ss
	 * @param second
	 * @return
	 */
	public static String calcDateBySecond(String dateStr, int second) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String stringReturn = "";
		try {
			cal.setTime(df.parse(dateStr));
			int i = cal.get(Calendar.SECOND);
			cal.set(Calendar.SECOND, i + second);
			stringReturn = df.format(cal.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return stringReturn;
	}
	
	/**
	 * 将日期格式yyyy-MM-dd HH:mm:ss转换为yyyyMMddHHmmss
	 * @param dateStr
	 * @return
	 */
	public static String formatDateTime(String dateStr) {
		SimpleDateFormat sSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat tSdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String result = "";
		try {
			Date date = sSdf.parse(dateStr);
			result = tSdf.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 格式化时间戳
	 * @param timestamp
	 * @param formatString
	 * @return
	 */
	public static String formatTimestamp(long timestamp, String formatString) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatString);
		Date date = new Date(timestamp);
		return sdf.format(date);
	}
	
	/**
	 * 当前时间
	 * @return
	 */
	public static Date getCurrentDate() {
		Date now = new Date();
		return now;
	}
	
	/**
     * 把普通字符串转化为日期
     *
     * @param dateStr
     * @param format 传入转换格式
     * @return
     */
     public static Date convertToDate(String dateStr, String format){
    	 DateFormat dateFormat = new SimpleDateFormat(format); 
    	 Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
    	 return date;
     }
 	
 	/**
 	 * 计算俩个时间差
 	 * @return
 	 * @throws ParseException 
 	 */
 	public static int getDiffDate(String date) throws ParseException {
 		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 		Date d1 = df.parse(getCurrentDateWithFormat());	
 		Date d2 = df.parse(date);
        long diff = d2.getTime() - d1.getTime();
        long days = diff / 1000;
        return Integer.valueOf(String.valueOf(days));
 	}
 	
 	/**
     * 将 date 类型的时间转换为 String 类型   yyyy/MM/dd HH:mm:ss
     * @param date
     * @return
     */
    public static String changeDateToString(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateString = df.format(date);
        return dateString;
    }

    /**
     * 计算日期与当前日期间隔秒数,返回long
     * @param date
     * @return
     * @throws ParseException
     */
    public static long getDiffDateReturnLong(String date) throws ParseException{
    	 DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Date d1 = new Date();
         Date d2 = df.parse(date);
         long diff = d2.getTime() - d1.getTime();
         long days = diff / 1000;
         return Long.valueOf(String.valueOf(days));
    }
}
