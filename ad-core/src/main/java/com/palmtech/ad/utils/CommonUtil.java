package com.palmtech.ad.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;



import org.springframework.util.StringUtils;

public class CommonUtil {
	private static MessageDigest digest = null;
	
	public CommonUtil() {
		
	}
	
	public static String ConvertNullStr(String str){
		if(str==null || str.trim().equals("")){
			return null;
		}
		
		return str;
	}
	
	public static String ConvertNullObj(Object str){
		if(str==null){
			return null;
		}
		
		return str.toString();
	}
	
	public static Integer ConvertZero(Integer data){
		if(data==null){
			return 0;
		}
		
		return data;
	}
	
	
	public static String ConvertEmptyStr(String str){
		if(str==null || str.trim().equals("")){
			return "";
		}		
		return str;
	}
	
	public static Object ConvertEmptyObject(Object srcObj){
		if(srcObj==null){
			return "";
		}		
		
		return srcObj;
	}
	
	public static String ConvertObjectToStr(Object srcObj){
		if(srcObj==null){
			return null;
		}		
		
		return srcObj.toString();
	}
	
	
	public static String[] splitString(String s, String separator){
		ArrayList list = new ArrayList();
		parseString(list, s, separator);
		String[] ret = new String[list.size()];
		for (int i = 0; i < ret.length; i++)
			ret[i] = ((String) list.get(i)).replaceAll(" ", "");
		return ret;
	}	

	public static void parseString(ArrayList list, String src, String key)
	{
		if (src==null || src.equals(""))
			return;
		
		if(src.length() < key.length()){
			list.add(src);
			return ;
		}

		if (src.substring(src.length() - key.length(), src.length()).compareTo(key) != 0)
			src += key;
		String sTemp = src;
		int pos = sTemp.indexOf(key);
		String item = null;
		while (pos != -1)
		{
			item = sTemp.substring(0, pos);
			sTemp = sTemp.substring(pos + key.length());
			pos = sTemp.indexOf(key);
			if (item != null)
				list.add(item);
		}
	}
	
    public static String convertUnicodeCharset(String c){
        if(c==null || c.trim().length()==0)
            return c;
        
        byte[] b=new byte[c.length()];
        for(int i=0;i<b.length;i++)
          b[i]=(byte)c.charAt(i);
        return new String(b);
   }
    
	public static Timestamp getDateTimeEnd(String date) {
        if(date==null || date.trim().length()==0)
        	return null;
        
		String[] dates = date.split("-");
		if(dates.length == 0)
			return null;
		String year = null;
		String month = null;
		String day = null;
		StringBuffer temp = new StringBuffer();
		if(dates.length == 1){
			year = dates[0];
			month = "01";
			day = "01";
		}
		else if(dates.length == 2){
			year = dates[0];
			month = dates[1];
			day = "01";
		}
		else{
			year = dates[0];
			month = dates[1];
			day = dates[2];
		}

		temp.append(year).append("-");
		if (month.length() == 1) {
			temp.append("0");
		}	
		temp.append(month).append("-");
		if (day.length() == 1) {
			temp.append("0").append(day).append(" 23:59:59");
		}
		else if(day.length() == 2){
			temp.append(day).append(" 23:59:59");
		}
		else{
			temp.append(day);
		}

		return Timestamp.valueOf(temp.toString());
	}
	
	public static Timestamp getDateTime(String date) {
        if(date==null || date.trim().length()==0)
        	return null;
        
		String[] dates = date.split("-");
		if(dates.length == 0)
			return null;
		String year = null;
		String month = null;
		String day = null;
		StringBuffer temp = new StringBuffer();
		if(dates.length == 1){
			year = dates[0];
			month = "01";
			day = "01";
		}
		else if(dates.length == 2){
			year = dates[0];
			month = dates[1];
			day = "01";
		}
		else{
			year = dates[0];
			month = dates[1];
			day = dates[2];
		}

		temp.append(year).append("-");
		if (month.length() == 1) {
			temp.append("0");
		}	
		temp.append(month).append("-");
		if (day.length() == 1) {
			temp.append("0").append(day).append(" 00:00:00");
		}
		else if(day.length() == 2){
			temp.append(day).append(" 00:00:00");
		}
		else{
			temp.append(day);
		}

		return Timestamp.valueOf(temp.toString());
	}
	
	public static Timestamp get14DateTime(String date) {
        if(date==null || date.trim().length()!=14)
        	return null;
        
		String year = date.substring(0, 4);
		String month = date.substring(4, 6);
		String day = date.substring(6, 8);
		StringBuffer temp = new StringBuffer();

		temp.append(year).append("-");
		temp.append(month).append("-");
		temp.append(day).append(" ").append(date.substring(8, 10));
		temp.append(":").append(date.substring(10, 12)).append(":").append(date.substring(12, 14));

		return Timestamp.valueOf(temp.toString());
	}
	
	public static String getDateStr(String date) {
        if(date==null || date.trim().length()==0)
        	return "";
        
		String[] dates = date.split("-");
		if(dates.length == 0)
			return null;
		String year = null;
		String month = null;
		String day = null;
		StringBuffer temp = new StringBuffer();
		if(dates.length == 1){
			year = dates[0];
			month = "01";
			day = "01";
		}
		else if(dates.length == 2){
			year = dates[0];
			month = dates[1];
			day = "01";
		}
		else{
			year = dates[0];
			month = dates[1];
			day = dates[2];
		}

		temp.append(year).append("-");
		if (month.length() == 1) {
			temp.append("0");
		}	
		temp.append(month).append("-");
		if (day.length() == 1) {
			temp.append("0").append(day);
		}
		else if(day.length() == 2){
			temp.append(day);
		}
		else{
			temp.append(day.substring(0,2));
		}

		return temp.toString();
	}
	
	public static String getDateTimeStr(String date) {
        if(date==null || date.trim().length()==0)
        	return "";
        
		String[] dates = date.split("-");
		if(dates.length == 0)
			return null;
		String year = null;
		String month = null;
		String day = null;
		StringBuffer temp = new StringBuffer();
		if(dates.length == 1){
			year = dates[0];
			month = "01";
			day = "01";
		}
		else if(dates.length == 2){
			year = dates[0];
			month = dates[1];
			day = "01";
		}
		else{
			year = dates[0];
			month = dates[1];
			day = dates[2];
		}

		temp.append(year).append("-");
		if (month.length() == 1) {
			temp.append("0");
		}	
		temp.append(month).append("-");
		if (day.length() == 1) {
			temp.append("0").append(day);
		}
		else if(day.length() == 2){
			temp.append(day);
		}
		else{
			if(day.indexOf('.')>=0)
			   temp.append(day.substring(0, day.indexOf('.')));
			else
			   temp.append(day);
		}

		return temp.toString();
	}
	
	public static String getMonthStartTime(String date) {
        if(date==null || date.trim().length()==0)
        	return "";
        
		String[] dates = date.split("-");
		if(dates.length == 0)
			return null;
		String year = null;
		String month = null;
		String day = "01";
		StringBuffer temp = new StringBuffer();
		if(dates.length == 1){
			year = dates[0];
			month = "01";
		}
		else if(dates.length == 2){
			year = dates[0];
			month = dates[1];
		}
		else{
			year = dates[0];
			month = dates[1];
		}

		temp.append(year).append("-");
		if (month.length() == 1) {
			temp.append("0");
		}	
		temp.append(month).append("-");
		if (day.length() == 1) {
			temp.append("0").append(day);
		}
		else if(day.length() == 2){
			temp.append(day);
		}
		else{
			if(day.indexOf('.')>=0)
			   temp.append(day.substring(0, day.indexOf('.')));
			else
			   temp.append(day);
		}

		return temp.toString();
	}
	
	public static String getMonthEndTime(String date) {
        if(date==null || date.trim().length()==0)
        	return "";
        
		String[] dates = date.split("-");
		if(dates.length == 0)
			return null;
		String year = null;
		String month = null;
		String day = null;
		StringBuffer temp = new StringBuffer();
		if(dates.length == 1){
			year = dates[0];
			month = "01";
		}
		else if(dates.length == 2){
			year = dates[0];
			month = dates[1];
		}
		else{
			year = dates[0];
			month = dates[1];
		}
		
		Calendar cal = Calendar.getInstance(); 
		cal.set(Integer.parseInt(year), Integer.parseInt(month)-1, 1); 
		day = String.valueOf(cal.getActualMaximum(Calendar.DAY_OF_MONTH));

		temp.append(year).append("-");
		if (month.length() == 1) {
			temp.append("0");
		}	
		temp.append(month).append("-");
		if (day.length() == 1) {
			temp.append("0").append(day);
		}
		else if(day.length() == 2){
			temp.append(day);
		}
		else{
			if(day.indexOf('.')>=0)
			   temp.append(day.substring(0, day.indexOf('.')));
			else
			   temp.append(day);
		}

		return temp.toString();
	}
	
	public static String getMonthEnd(Date date) {
        if(date==null)
        	return "";

        Calendar cal = Calendar.getInstance(); 
		cal.setTime(date);
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		String day = String.valueOf(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		StringBuffer temp = new StringBuffer();

		temp.append(year).append("-");
		if (month.length() == 1) {
			temp.append("0");
		}	
		temp.append(month).append("-");
		if (day.length() == 1) {
			temp.append("0").append(day);
		}
		else if(day.length() == 2){
			temp.append(day);
		}
		else{
			if(day.indexOf('.')>=0)
			   temp.append(day.substring(0, day.indexOf('.')));
			else
			   temp.append(day);
		}

		return temp.toString();
	}
	
	public static String getDayStart() {
		Calendar currTime = Calendar.getInstance();
		String year = String.valueOf(currTime.get(Calendar.YEAR));
		String month = String.valueOf(currTime.get(Calendar.MONTH) + 1);
		String day = String.valueOf(currTime.get(Calendar.DATE));
		StringBuffer temp = new StringBuffer();

		temp.append(year).append("-");
		if (month.length() == 1)
			temp.append("0");
		temp.append(month).append("-");
		if (day.length() == 1) {
			temp.append("0");
		}
		temp.append(day).append(" 00:00:00");

		return temp.toString();
	}

	public static String getDayStart(Date date) {
		if(date==null)
        	return "";
		
		Calendar currTime = Calendar.getInstance();
		currTime.setTime(date);
		String year = String.valueOf(currTime.get(Calendar.YEAR));
		String month = String.valueOf(currTime.get(Calendar.MONTH) + 1);
		String day = String.valueOf(currTime.get(Calendar.DATE));
		StringBuffer temp = new StringBuffer();

		temp.append(year).append("-");
		if (month.length() == 1)
			temp.append("0");
		temp.append(month).append("-");
		if (day.length() == 1) {
			temp.append("0");
		}
		temp.append(day).append(" 00:00:00");

		return temp.toString();
	}
	
	public static Date getDayEnd(Date date) {
		if(date==null)
        	return null;
		Calendar currTime = Calendar.getInstance();
		currTime.setTime(date);
		currTime.set(Calendar.HOUR_OF_DAY, 23);
		//currTime.set(Calendar.HOUR, 23);
		currTime.set(Calendar.MINUTE, 59);
		currTime.set(Calendar.SECOND, 59);		

		return currTime.getTime();
	}
	
	public static String getMonthStart() {
		Calendar currTime = Calendar.getInstance();
		String year = String.valueOf(currTime.get(Calendar.YEAR));
		String month = String.valueOf(currTime.get(Calendar.MONTH) + 1);
		StringBuffer temp = new StringBuffer();

		temp.append(year).append("-");
		if (month.length() == 1)
			temp.append("0");
	    temp.append(month).append("-01 00:00:00");

		return temp.toString();
	}
	
	public static String getMonthStart(Date date) {
		Calendar currTime = Calendar.getInstance();
		currTime.setTime(date);
		String year = String.valueOf(currTime.get(Calendar.YEAR));
		String month = String.valueOf(currTime.get(Calendar.MONTH) + 1);
		StringBuffer temp = new StringBuffer();

		temp.append(year).append("-");
		if (month.length() == 1)
			temp.append("0");
	    temp.append(month).append("-01 00:00:00");

		return temp.toString();
	}
	

	
	public static String getYearStart() {
		Calendar currTime = Calendar.getInstance();
		String year = String.valueOf(currTime.get(Calendar.YEAR));
		StringBuffer temp = new StringBuffer();

		temp.append(year).append("-01-01 00:00:00");

		return temp.toString();
	}
	
	
	public static Timestamp getCurrentDateTime() {
		Calendar currTime = Calendar.getInstance();
		String year = String.valueOf(currTime.get(Calendar.YEAR));
		String month = String.valueOf(currTime.get(Calendar.MONTH) + 1);
		String day = String.valueOf(currTime.get(Calendar.DATE));
		String hour = String.valueOf(currTime.get(Calendar.HOUR_OF_DAY));
		String minute = String.valueOf(currTime.get(Calendar.MINUTE));
		String second = String.valueOf(currTime.get(Calendar.SECOND));
		StringBuffer temp = new StringBuffer();

		temp.append(year).append("-");
		if (month.length() == 1)
			temp.append("0");
	    temp.append(month).append("-");
		if (day.length() == 1) {
			temp.append("0");
		}
		temp.append(day).append(" ");
		if (hour.length() == 1) {
			temp.append("0");
		}
		temp.append(hour).append(":");
		if (minute.length() == 1) {
			temp.append("0");
		}
		temp.append(minute).append(":");
		if (second.length() == 1) {
			temp.append("0");
		}
		temp.append(second).append("");

		return Timestamp.valueOf(temp.toString());
	}
	
	public static String getCurrentDateTimeStr() {
		Calendar currTime = Calendar.getInstance();
		String year = String.valueOf(currTime.get(Calendar.YEAR));
		String month = String.valueOf(currTime.get(Calendar.MONTH) + 1);
		String day = String.valueOf(currTime.get(Calendar.DATE));
		String hour = String.valueOf(currTime.get(Calendar.HOUR_OF_DAY));
		String minute = String.valueOf(currTime.get(Calendar.MINUTE));
		String second = String.valueOf(currTime.get(Calendar.SECOND));
		StringBuffer temp = new StringBuffer();

		temp.append(year).append("-");
		if (month.length() == 1)
			temp.append("0");
	    temp.append(month).append("-");
		if (day.length() == 1) {
			temp.append("0");
		}
		temp.append(day).append(" ");
		if (hour.length() == 1) {
			temp.append("0");
		}
		temp.append(hour).append(":");
		if (minute.length() == 1) {
			temp.append("0");
		}
		temp.append(minute).append(":");
		if (second.length() == 1) {
			temp.append("0");
		}
		temp.append(second).append("");

		return temp.toString();
	}
	
	/**
	 * 获取完整的当前时间，格式为yyyyMMddHHmmssms
	 * @return
	 */
	public static String getFullCurrentDateTimeStr(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssms");
		String timeStr = df.format(new Date());
		return timeStr;
	}
	
	public static String get14CurrentDateTimeStr() {
		Calendar currTime = Calendar.getInstance();
		String year = String.valueOf(currTime.get(Calendar.YEAR));
		String month = String.valueOf(currTime.get(Calendar.MONTH) + 1);
		String day = String.valueOf(currTime.get(Calendar.DATE));
		String hour = String.valueOf(currTime.get(Calendar.HOUR_OF_DAY));
		String minute = String.valueOf(currTime.get(Calendar.MINUTE));
		String second = String.valueOf(currTime.get(Calendar.SECOND));
		StringBuffer temp = new StringBuffer();

		temp.append(year);
		if (month.length() == 1)
			temp.append("0");
	    temp.append(month);
		if (day.length() == 1) {
			temp.append("0");
		}
		temp.append(day);
		if (hour.length() == 1) {
			temp.append("0");
		}
		temp.append(hour);
		if (minute.length() == 1) {
			temp.append("0");
		}
		temp.append(minute);
		if (second.length() == 1) {
			temp.append("0");
		}
		temp.append(second);

		return temp.toString();
	}
	
	public static String getCurrentDateStr() {
		Calendar currTime = Calendar.getInstance();
		String year = String.valueOf(currTime.get(Calendar.YEAR));
		String month = String.valueOf(currTime.get(Calendar.MONTH) + 1);
		String day = String.valueOf(currTime.get(Calendar.DATE));
		StringBuffer temp = new StringBuffer();

		temp.append(year).append("/");
		if (month.length() == 1)
			temp.append("0");
	    temp.append(month).append("/");
		if (day.length() == 1) {
			temp.append("0");
		}
		temp.append(day);

		return temp.toString();
	}
	
	public static String getCurrentDateStr1() {
		Calendar currTime = Calendar.getInstance();
		String year = String.valueOf(currTime.get(Calendar.YEAR));
		String month = String.valueOf(currTime.get(Calendar.MONTH) + 1);
		String day = String.valueOf(currTime.get(Calendar.DATE));
		StringBuffer temp = new StringBuffer();

		temp.append(year).append("-");
		if (month.length() == 1)
			temp.append("0");
	    temp.append(month).append("-");
		if (day.length() == 1) {
			temp.append("0");
		}
		temp.append(day);

		return temp.toString();
	}
	
	public static String getCurrentWeekDay() {
		Calendar currTime = Calendar.getInstance();
		return String.valueOf(currTime.get(Calendar.DAY_OF_WEEK)-1);
	}
	
	
	public static String get2YearStr() {
		Calendar currTime = Calendar.getInstance();
		String year = String.valueOf(currTime.get(Calendar.YEAR));

		return year.substring(2);
	}
	
	public static String get4YearStr() {
		Calendar currTime = Calendar.getInstance();
		String year = String.valueOf(currTime.get(Calendar.YEAR));

		return year;
	}
	
    public static String fillString(String str,int len,char c,boolean fillleft){
        if(str==null) str="";
        if(str.length()>len)
            return str.substring(0,len);
        else{
            int len1 = len - str.length();
            if(len1>0){
                byte[] b=new byte[len1];
                for(int i=0;i<len1;i++) b[i]=(byte)c;
                if(fillleft)
                    str=new String(b)+str;
                else
                    str += new String(b);
            }
            return str;
        }
    }
    
    public static long getLongTime(String datetime){
        if(datetime==null || datetime.trim().length()==0)
        	return 0;
        
		long ret = 0;

		SimpleDateFormat dateFormat = null;
		
		try {
			datetime = getDateTimeStr(datetime);
			if(datetime.indexOf(' ')>0 && datetime.indexOf(':')>0)
				dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    else 
			    dateFormat = new SimpleDateFormat("yyyy-MM-dd");	
			Date date = dateFormat.parse(datetime);
			ret = date.getTime();
		} catch (ParseException e) {
			
			//e.printStackTrace();
		}
		
    	return ret;

    }
    
    public static String formatTime(Date datetime){
        if(datetime==null)
        	return null;
        
		String ret = null;
		SimpleDateFormat dateFormat = null;		
		try {
			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ret = dateFormat.format(datetime);
		} catch (Exception e) {
			
			//e.printStackTrace();
		}		
    	return ret;

    }
    
    public static String formatTime1(Date datetime){
        if(datetime==null)
        	return null;
        
		String ret = null;
		SimpleDateFormat dateFormat = null;		
		try {
			dateFormat = new SimpleDateFormat("HH:mm:ss");
			ret = dateFormat.format(datetime);
		} catch (Exception e) {
			
			//e.printStackTrace();
		}		
    	return ret;

    }
    
    public static String formatDate(Date datetime){
        if(datetime==null)
        	return null;
        
		String ret = null;
		SimpleDateFormat dateFormat = null;		
		try {
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			ret = dateFormat.format(datetime);
		} catch (Exception e) {
			
			//e.printStackTrace();
		}		
    	return ret;

    }
    
    public static String formatDateYYMM(Date datetime){
        if(datetime==null)
        	return null;
        
		String ret = null;
		SimpleDateFormat dateFormat = null;		
		try {
			dateFormat = new SimpleDateFormat("yyyy-MM");
			ret = dateFormat.format(datetime);
		} catch (Exception e) {
			
			//e.printStackTrace();
		}		
    	return ret;

    }
    
    public static String formatDateTime(Date datetime){
        if(datetime==null)
        	return null;
        
		String ret = null;
		SimpleDateFormat dateFormat = null;		
		try {
			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ret = dateFormat.format(datetime);
		} catch (Exception e) {
			
			//e.printStackTrace();
		}		
    	return ret;

    }

    
    public static Date addDate(Date date, String type, int addNum){
    	if(date==null)
    		return null;    	
    	
    	if(type==null || type.trim().equals(""))
    		return null;
    	
        Calendar calendar=Calendar.getInstance();      
        calendar.setTime(date);
        if(type.equals("1")){
        	calendar.set(Calendar.YEAR,calendar.get(Calendar.YEAR)+addNum);
        }
        else if(type.equals("2")){
        	calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)+addNum);
        }
        else if(type.equals("3")){
        	calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+addNum);
        }
        else if(type.equals("4")){
        	calendar.set(Calendar.HOUR,calendar.get(Calendar.HOUR_OF_DAY)+addNum);
        }
        else if(type.equals("5")){
        	calendar.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE)+addNum);
        }
        
        return calendar.getTime();
    }
    
    public static int compareDay(Date date1, Date date2){
    	if(date1==null || date2==null)
    		return 0;
	    
    	Calendar d1 = Calendar.getInstance();
	    d1.setTime(date1); 
	    Calendar d2 = Calendar.getInstance();         	
	    d2.setTime(date2);
        if (d1.after(d2)) {
    	   java.util.Calendar swap = d1;
    	   d1 = d2;
    	   d2 = swap;
    	  }
    	  int days = d2.get(java.util.Calendar.DAY_OF_YEAR) - d1.get(java.util.Calendar.DAY_OF_YEAR);
    	  int y2 = d2.get(java.util.Calendar.YEAR);
    	  if (d1.get(java.util.Calendar.YEAR) != y2) {
    	   d1 = (java.util.Calendar) d1.clone();
    	   do {
    	    days += d1.getActualMaximum(java.util.Calendar.DAY_OF_YEAR);
    	    d1.add(java.util.Calendar.YEAR, 1);
    	   } while (d1.get(java.util.Calendar.YEAR) != y2);
    	  }
    	  return days;

    }
    
    public static int compareMonth(Date date1, Date date2){ 
    	if(date1==null || date2==null)
    		return 0;
    	
        int iMonth = 0;      
        int flag = 0;      
        try{      
            Calendar objCalendarDate1 = Calendar.getInstance();      
            objCalendarDate1.setTime(date1);      
      
            Calendar objCalendarDate2 = Calendar.getInstance();      
            objCalendarDate2.setTime(date2);      
      
            if (objCalendarDate2.equals(objCalendarDate1))      
                return 0;      
            if (objCalendarDate1.after(objCalendarDate2)){      
                Calendar temp = objCalendarDate1;      
                objCalendarDate1 = objCalendarDate2;      
                objCalendarDate2 = temp;      
            }      
//            if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1.get(Calendar.DAY_OF_MONTH))      
//                flag = 1;      
      
            if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1.get(Calendar.YEAR))      
                iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1.get(Calendar.YEAR))      
                        * 12 + objCalendarDate2.get(Calendar.MONTH) - flag)      
                        - objCalendarDate1.get(Calendar.MONTH);      
            else     
                iMonth = objCalendarDate2.get(Calendar.MONTH)      
                        - objCalendarDate1.get(Calendar.MONTH) - flag;      
      
        } catch (Exception e){      
           e.printStackTrace();      
        }      
        return iMonth;      
    }  
    
    public static long compareTime(Date date1, Date date2){
    	if(date1==null || date2==null)
    		return 0;
    	
	    Calendar c = Calendar.getInstance(); 
	
	    c.setTime(date1); 
	    long l1 = c.getTimeInMillis(); 
	
	    c.setTime(date2);
	    long l2 = c.getTimeInMillis(); 
	    
	    return (l2 - l1) / 1000;
    }
    
	public static boolean calTaskDay(Date startTime, Date endTime, Date checkTime, StringBuffer taskDay){
	    if(checkTime==null || startTime==null || endTime==null || taskDay==null)
	    	return false;

	    //StringBuffer retDay = new StringBuffer();
	    //if(taskDay != null)
	    //	retDay.append(taskDay);
	    DateFormat formatMonth = new SimpleDateFormat("MM");
	    DateFormat formatDay = new SimpleDateFormat("dd");
	    String checkMonth = formatMonth.format(checkTime);
	    String startMonth = formatMonth.format(checkTime);
	    String endMonth = formatMonth.format(endTime);
	    if(checkTime.after(startTime) && checkTime.before(endTime)){
	    	int endDays = compareDay(endTime, checkTime);
	    	if(endDays>-31 && checkMonth.equals(endMonth)){
	    		int endDay = Integer.parseInt(formatDay.format(endTime));
	    		for(int i=0; i<endDay; i++){
	    			if(taskDay.indexOf("["+(i+1)+"]") < 0)
	    				taskDay.append("[").append(i+1).append("]");
	    		}
	    	}
	    	else{
	    		taskDay.append("[").append("all").append("]");
	    	}
	    }
	    else if(startTime.compareTo(checkTime)>=0 && endTime.compareTo(checkTime)>=0 && endTime.compareTo(startTime)>=0 && compareDay(startTime, checkTime)>-31 && checkMonth.equals(startMonth)){
	    	//int startDays = compareDay(startTime, checkTime);
	    	int endDays = compareDay(endTime, checkTime);
	    	int startDay = Integer.parseInt(formatDay.format(startTime));
	    	int endDay = 31;
	    	if(endDays>-31 && checkMonth.equals(endMonth)){
	    		endDay = Integer.parseInt(formatDay.format(endTime));
	    	}
	    	for(int i=startDay; i<=endDay; i++){
	    		if(taskDay.indexOf("["+i+"]") < 0)
	    			taskDay.append("[").append(i).append("]");
	    	}	
	    }
	    
	    return true;
	}
    
    public static String fillString1(String str,int len,char c,boolean fillleft){
        if(str==null) str="";
        if(str.length()>len)
            return str;
        else{
            int len1 = len - str.length();
            if(len1>0){
                byte[] b=new byte[len1];
                for(int i=0;i<len1;i++) b[i]=(byte)c;
                if(fillleft)
                    str=new String(b)+str;
                else
                    str += new String(b);
            }
            return str;
        }
    }

	
    public static String convertFixedDecimalLenStr(String src,int dots,int afterDots){
        if(src == null || src.length() == 0)
            return fillString("0.",afterDots+2,'0',false);
        int dotPos = src.indexOf(".");
        if(dotPos > 0){
            int decimalLen = src.length()-dotPos-1;
            if(decimalLen >= dots)
                src = src.substring(0,dotPos+dots+1);
            else
                src = fillString(src,src.length()+dots-decimalLen,'0',false);
            if(afterDots >= dots)
                src = fillString(src,src.length()+afterDots-dots,'0',false);
            else
                src = src.substring(0,dotPos+afterDots+1);
        }
        else{
            src = fillString(src+".",src.length()+afterDots+1,'0',false);
        }
        return src;
    }
    
    public static String trimDate(String srcDate){
    	if(srcDate==null || srcDate.trim().equals(""))
    		return "";
    	
    	int timePos = srcDate.trim().indexOf(' ');
    	if(timePos > 0){
    		boolean hasTime = false;
    		String[] times = srcDate.substring(timePos+1).split(":");
    		if(Integer.parseInt(times[0]) > 0)
    			hasTime = true;
    		if(Integer.parseInt(times[1]) > 0)
    			hasTime = true;
    		if(times[2].indexOf(".")>=0)
    			times[2] = times[2].substring(0,times[2].indexOf("."));
    		if(Integer.parseInt(times[2]) > 0)
    			hasTime = true;
    		if(hasTime){
    			if(srcDate.indexOf("23:59:59")>=0)
    				hasTime = false;
    		}
    		if(hasTime){
    			int dotPos = srcDate.trim().indexOf('.');
    			if(dotPos >= 0){
    				return srcDate.substring(0, dotPos);    		    
    			}    			
    			return srcDate;
    		}
    		else
    			return srcDate.substring(0, timePos);
    	}
    	else
    		return srcDate;
    }
    
	public static boolean isNumber(String data) {
		
		boolean result = true;
		
		if (data == null || !Pattern.matches("[-]{0,1}\\d{1,50}([\\.]?)\\d{0,50}", data)) {
			result = false;
		}
		
		return result;
		
	}
	
	
	public synchronized static final String hash(String data) {
		if(data==null || data.equals(""))
			return null;
		
		if (digest == null) {
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException nsae) {
				nsae.printStackTrace();
			}
		}
		// Now, compute hash.
		digest.update(data.getBytes());
		return encodeHex(digest.digest());
	}
	
	public synchronized static final String hash1(byte[] data) {
		if(data==null || data.length<=0)
			return null;
		
		if (digest == null) {
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException nsae) {
				nsae.printStackTrace();
			}
		}
		// Now, compute hash.
		digest.update(data);
		return encodeHex(digest.digest());
	}
	
	public static final String encodeHex(byte[] bytes) {
		StringBuffer buf = new StringBuffer(bytes.length * 2);
		int i;

		for (i = 0; i < bytes.length; i++) {
			if (((int) bytes[i] & 0xff) < 0x10) {
				buf.append("0");
			}
			buf.append(Long.toString((int) bytes[i] & 0xff, 16));
		}
		return buf.toString();
	}
	
	public static boolean saveToFile(byte[] dataBuf, String filePath){
		if(dataBuf==null || filePath==null)
			return false;
		
		boolean ret = false;
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(filePath);
			out.write(dataBuf);
			ret = true;
		}
		catch (Exception e){
			
		}
		finally{
			if (out != null){
				try {
					out.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				out = null;
			}
		}
		
		return ret;

	}
	
	
	public static boolean saveToFileEx(byte[] dataBuf, String filePath, boolean append){
		if(dataBuf==null || filePath==null)
			return false;
		
		boolean ret = false;
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(filePath, append);
			out.write(dataBuf);
			ret = true;
		}
		catch (Exception e){
			
		}
		finally{
			if (out != null){
				try {
					out.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				out = null;
			}
		}
		
		return ret;

	}
	
	public static boolean downloadFile(String urlPath, String localPath) {
		if(urlPath==null || urlPath.equals(""))
			return false;

		HttpURLConnection conn = null;
		InputStream in = null;
		OutputStream out = null;
		byte[] rcvBuf = null;
		try {		
			URL url = new URL(urlPath);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setDefaultUseCaches(false);
			conn.setRequestProperty("Content-type", "application/octet-stream");
			out = conn.getOutputStream();

			out.flush();
			out.close();

			String message = conn.getResponseMessage();
//			System.out.println("ResponseCode : " + conn.getResponseCode());
//			System.out.println("Message : " + message);

			in = conn.getInputStream();
            
			int len = conn.getContentLength(); 
	        if (len > 0) { 
                int actual = 0; 
                int bytesRead = 0 ; 
                rcvBuf = new byte[len]; 
                while ((bytesRead < len) && (actual != -1)) { 
                   actual = in.read(rcvBuf, bytesRead, len - bytesRead); 
                   bytesRead += actual;
                }  
	        }
	        saveToFile(rcvBuf, localPath);

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    finally{
			   if(out != null){
					   try {
						   out.close();
						} catch (IOException e) {
							
							e.printStackTrace();
						}
					   out = null;
			    }		    	
			   if(in != null){
				   try {
					   in.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				   in = null;
			   }
			   
			   if(conn != null){
			       conn.disconnect();
				   conn = null;
			   }
			   
		}
        return true;
	}
	
	
	public static boolean unzipFile(String zipFile, String zipToPath){
		if(zipFile==null || zipFile.equals(""))
			return false;
		
		boolean bRet = true;
		ZipInputStream zipIn = null;
		try {
			File file = new File(zipFile);
			if(!file.exists())
				return false;
			
			File path=new File(zipToPath);
			if(!path.exists())
			   path.mkdir();
			
			zipIn = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)));
			
			ZipEntry zipentry = null;
			while((zipentry=zipIn.getNextEntry()) != null){			   
			   if (zipentry.isDirectory()){
					String name=zipentry.getName();
					name=name.substring(0,name.length()-1);
					File f=new File(zipToPath+File.separator+name);
					f.mkdir();
			   }
			   else{
					String name=zipentry.getName();
					if(name.lastIndexOf('\\') >= 0)
						name = name.substring(name.lastIndexOf('\\'));
					else if(name.lastIndexOf('/') >= 0)
						name = name.substring(name.lastIndexOf('/'));
					
				    File f=new File(zipToPath+"/"+name);
					f.createNewFile();
					FileOutputStream out=new FileOutputStream(f);
					int b;
					while ((b=zipIn.read()) != -1)
						out.write(b);
					out.close();
				}

			}
		}catch(Exception ex){
			bRet = false;
			ex.printStackTrace();
		}finally{
			if(zipIn != null){
				try {
					zipIn.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				zipIn = null;
			}
		}
		
		return bRet;
	}
	
	public static byte[] readFile(String file) { 
		FileInputStream fis = null; 
		ByteArrayOutputStream bos = null; 
		try { 
			fis = new FileInputStream(file); 
			bos = new ByteArrayOutputStream(); 
			int bytesRead; 
			byte buffer[] = new byte[1024 * 1024]; 
			while ((bytesRead = fis.read(buffer)) != -1) { 
			   bos.write(buffer, 0, bytesRead); 
			   Arrays.fill(buffer, (byte) 0); 
			} 
		} catch (IOException e1) { 
		    e1.printStackTrace(); 
		} finally { 
			try { 
				if (bos != null) 
				   bos.close(); 
			} catch (IOException e) { 
			    e.printStackTrace(); 
			} 
		} 
		return bos.toByteArray(); 
	}
	
	public static boolean isValidMobile(String mobile) {
		
		boolean result = true;
		
		if (mobile == null || !Pattern.matches("[\\+]?[8,6]{0,2}1\\d{1,40}", mobile)) {
			result = false;
		}
		
		return result;
		
	}
	

	public static boolean isValidMail(String mail) {	
		if(mail==null || mail.trim().equals(""))
			return false;
		
		String reg = "[\\w\\-]+([\\.][\\w\\-]+)*[@][\\w\\-]+([\\.][\\w\\-]+)+";
		boolean result = true;
		
		if (mail != null && !mail.trim().equals("") ) {
			if (!Pattern.matches(reg, mail)) {
				result = false;
			} 
		}
		
		return result;
		
	}
	
	
    public static String getOperateUrl(String urlPath, String operateName){
    	if(urlPath==null || urlPath.trim().equals(""))
    		return urlPath;
    	
    	if(operateName==null || operateName.trim().equals(""))
    		return urlPath;

    	StringBuffer pageUrl = new StringBuffer(urlPath);
	    if(urlPath.indexOf("operateType=") < 0){
	  	  if(urlPath.indexOf("?") > 0)
	  		 pageUrl.append("&operateType=").append(operateName);
	  	  else
	  		pageUrl.append("?operateType=").append(operateName);
	    }
    
        return pageUrl.toString();    	
    }
    
    
	public static byte[] convertHexStrToByteArray(String srcHex){
		byte[] retByteArray = new byte[srcHex.length() / 2];
		byte tmpByte;
		String sDecode;
		for (int i = 0; i < srcHex.length() / 2; i++)
		{
			sDecode = "0x" + srcHex.substring(2 * i, 2 * i + 2);
			tmpByte = Integer.decode(sDecode).byteValue();
			retByteArray[i] = tmpByte;
		}
		return retByteArray;
	}


	public static String convertByteArrayToHexStr(byte[] srcByteArray){
		String sTemp = null;
		StringBuffer sOutLine = new StringBuffer();
		byte[] inByte = srcByteArray;
		for (int iSerie = 0; iSerie < inByte.length; iSerie++)
		{
			if (inByte[iSerie] < 0)
			{
				sTemp = Integer.toHexString(256 + inByte[iSerie]);
			}
			else
			{
				sTemp = Integer.toHexString(inByte[iSerie]);
			}
			if (sTemp.length() < 2)
			{
				sTemp = "0" + sTemp;
			}
			sTemp = sTemp.toUpperCase();
			sOutLine = sOutLine.append(sTemp);
		}
		return sOutLine.toString();
	}
	
	public static String generateUUID(){
		UUID uuid = UUID.randomUUID(); 
		String uuidStr = uuid.toString();
		return uuidStr.replaceAll("-", "").toUpperCase();
	}
	
	
	public static String replaceString(String src, String dest, String r){
		if (src == null || src.length() == 0)
			return "";
		int index = src.indexOf(dest);
		int pos = 0;
		StringBuffer ret = new StringBuffer();
		while (index >= 0)
		{
			ret.append(src.substring(pos, index)).append(r);
			pos = index + dest.length();
			index = src.indexOf(dest, index + dest.length());
		}
		if (pos < src.length())
		{
			ret.append(src.substring(pos));
		}
		return ret.toString();
	}
	
	public static String convertPrecisionDouble(Double srcData, int dotNum){
		if(srcData == null)
			return "";
		BigDecimal bigDecimal = new BigDecimal(Double.toString(srcData));
        return bigDecimal.setScale(dotNum, BigDecimal.ROUND_HALF_UP).toString();
	}
	
	
	public static String getUrlFileContent(String urlPath) {
		if(urlPath==null || urlPath.equals(""))
			return null;

		HttpURLConnection conn = null;
		InputStream in = null;
		OutputStream out = null;
		byte[] rcvBuf = null;
		try {		
			URL url = new URL(urlPath);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setDefaultUseCaches(false);
			conn.setRequestProperty("Content-type", "application/octet-stream");
			out = conn.getOutputStream();

			out.flush();
			out.close();

			//String message = conn.getResponseMessage();
			in = conn.getInputStream();
            
			int len = conn.getContentLength(); 
	        if (len > 0) { 
                int actual = 0; 
                int bytesRead = 0 ; 
                rcvBuf = new byte[len]; 
                while ((bytesRead < len) && (actual != -1)) { 
                   actual = in.read(rcvBuf, bytesRead, len - bytesRead); 
                   bytesRead += actual;
                }  
	        }

			in.close();
		} catch (Exception e) {
			rcvBuf = null;
			e.printStackTrace();
		}
	    finally{
			   if(out != null){
					   try {
						   out.close();
						} catch (IOException e) {
							
							e.printStackTrace();
						}
					   out = null;
			    }		    	
			   if(in != null){
				   try {
					   in.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				   in = null;
			   }
			   
			   if(conn != null){
			       conn.disconnect();
				   conn = null;
			   }
			   
		}
	    
	    if(rcvBuf != null)
	    	return new String(rcvBuf);
	    else
            return null;
	}
	
	public static String getRandomPwd(int len){
		StringBuffer ret = new StringBuffer();
		String uuid = CommonUtil.generateUUID();
		uuid = CommonUtil.hash(uuid);
		int count = 0;
		for(int i=0; i<uuid.length(); i++){
			if(uuid.charAt(i)>='0' && uuid.charAt(i)<='9'){
				ret.append(uuid.charAt(i));
				count++;
				if(count>=len)
					break;
			}			
		}
		if(count < len){
			Random rand = new Random();
		    for(int i=0; i<len-count; i++){		    	
		    	ret.append(String.valueOf(rand.nextInt(9)));
		    }
		}
		return ret.toString();
	}
	
	
	
	public static String getString(byte[] b, int offset, int len,
			String encoding) {
		try {
			return new String(b, offset, len, encoding);
		} catch (UnsupportedEncodingException e) {
			return new String(b, offset, len);
		}
	}

	public static String getIpStringFromBytes(byte[] ip) {
		StringBuilder sb = new StringBuilder();
		sb.delete(0, sb.length());
		sb.append(ip[0] & 0xFF);
		sb.append('.');
		sb.append(ip[1] & 0xFF);
		sb.append('.');
		sb.append(ip[2] & 0xFF);
		sb.append('.');
		sb.append(ip[3] & 0xFF);
		return sb.toString();
	}

	public static byte[] getIpByteArrayFromString(String ip) {
		byte[] ret = new byte[4];
		StringTokenizer st = new StringTokenizer(ip, ".");
		try {
			ret[0] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
			ret[1] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
			ret[2] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
			ret[3] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	
}
