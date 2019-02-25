package rt.lewis.utils.date;


import rt.lewis.utils.string.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String DEFAULT_SIMPLE_DATE_FORMAT = "yyyyMMdd";
    public static final String DEFAULT_SIMPLE_TIME_FORMAT = "HHmmss";
    public static final String DEFAULT_SIMPLE_DATETIME_FORMAT = "yyyyMMddHHmmss";
    public static final String DEFAULT_SIMPLE_DATETIME_DETAIL_FORMAT = "yyyyMMddHHmmssSSS";
    public static final String DEFAULT_SIMPLE_TIME_HOURS_MINUTES_FORMAT = "HHmm";
    public static final String DEFAULT_SIMPLE_YEAR_MONTH_FORMAT = "yyyyMM";

    public static final String DEFAULT_YEAR_FORMAT = "yyyy";
    public static final String DEFAULT_YEAR_SHORT_FORMAT = "yy";
    public static final String DEFAULT_MONTH_LAST_FORMAT = "MM";
    public static final String DEFAULT_DAY_LAST_FORMAT = "dd";

    public static final String DEFAULT_DATETIME_DETAIL_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DEFAULT_DATE_FORMAT= "yyyy-MM-dd";
    public static final String DEFAULT_TIME_HOURS_MINUTES_FORMAT = "HH:mm";
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";


    public static final String DEFAULT_MAX_DATE = "2099-12-31";

    public static final String DEFAULET_S = "s";

    public static final String DEFAULET_MINUTE = "minute";

    public static final String DEFAULET_HOUR = "hour";

    public static final String DEFAULET_DAY = "day";

    private static final String JAN = "01", DEC = "12";

    private static final String ERROR_INFO="Errors occured during date converting! ";

    private static final String START_TIME_OF_DAY=" 00:00:00 000";
    private static final String END_TIME_OF_DAY=" 23:59:59 999";
    /**
     * 一天的毫秒数
     */
    public static final Long  ONE_DAY_MILL=0x5265c00L;

    /**
     * 获取当前时间戳
     * @return
     */
    public static Timestamp getCurrentTimestamp() {
    	return new Timestamp(System.currentTimeMillis());
	}
    
    /**
     * 获取当前日期
     * @return
     */
    public static Date getCurrentDate() {
    	return new Date(System.currentTimeMillis());
	}
    
    /**
     * 时间格式化
     *
     * @param date 时间对象
     * @param format 选填参数，指定格式
     * @return
     */
    public static String formatDate2Str(Date date, String format) {
        if(date==null){
            return null;
        }
        if (StringUtils.isBlank(format)) {
            format = DEFAULT_DATETIME_FORMAT;
        }
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * 日期转换
     *
     * @param date
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date formatStr2Date(String date, String format) throws ParseException {
        if(StringUtils.isBlank(date))
            return null;
        format=StringUtils.isBlank(format)?DEFAULT_DATETIME_FORMAT:format;
        DateFormat df = new SimpleDateFormat(format);
        return df.parse(date);

    }

    /**
     * 获取当前时间的前N天
     * @param index
     * @return
     */
    public static Date getPreDate(int index){
     return getDateOffset(new Date(), index);
    }

    /**
     * 获取当前时间的之后N天
     * @param index
     * @return
     */
    public static Date getAfterDate(int index){
        return getDateOffset(new Date(), -index);
    }


    /**
     * 获取时间偏移天数
    *
     * @param date 基础日期
     * @param index 偏移天数，大于0往后，小于0往前
     * @return
     */
    public static Date getDateOffset(Date date,int index){
       if(date==null){
           date=new Date();
       }
        return  new Date(date.getTime()-index*ONE_DAY_MILL);
    }

    /**
     * 获取前几个或后几个月的时间
     *
     * @param index 为负数表示前几个月，为正数表示未来时间
     * @return
     */
    public static Date getMonthOffset(Date date, int index) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.MILLISECOND,0);
        calendar.set(Calendar.SECOND,0);
        calendar.add(Calendar.MONTH, index);
        return calendar.getTime();
    }

}
