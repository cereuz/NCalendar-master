package necer.ncalendardemo.utils;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    //获取系统时间。
    @SuppressLint("SimpleDateFormat")
    public static String getSystemTimeMore(int i) {
        SimpleDateFormat mFormat = null;
        Date date = new Date(System.currentTimeMillis());//获取当前时间
        switch (i) {
            case 1:
                mFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒SS毫秒 EEEE");
                //2018年07月24日 15时16分27秒 星期二
                Log.e("CurTime", "time1=" + mFormat.format(date));
                break;

            case 2:
                mFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH);
                Log.e("CurTime", "time2=" + mFormat.format(date));
                break;
            case 3:
                mFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Log.e("CurTime", "time2=" + mFormat.format(date));
                break;
            case 4:
                mFormat = new SimpleDateFormat("yyyy/MM/dd");
                Log.e("CurTime", "time3=" + mFormat.format(date));
                break;
            case 5:
                mFormat = new SimpleDateFormat("HH-mm-ss");
                Log.e("CurTime", "time4=" + mFormat.format(date));
                break;
            case 6:
                mFormat = new SimpleDateFormat("EEEE");
                Log.e("CurTime", "time5=" + mFormat.format(date));
                break;
            case 7:
                mFormat = new SimpleDateFormat("E");
                Log.e("CurTime", "time6=" + mFormat.format(date));
                break;

            case 8:
                mFormat = new SimpleDateFormat("yyyy年MM月dd日 ，EEEE ");
                break;

            case 9:
                SimpleDateFormat sdf2 = new SimpleDateFormat("MM dd, yyyy HH:mm:ss",
                        Locale.ENGLISH);
                break;
        }

        //	SimpleDateFormat    formatter    =   new    SimpleDateFormat    ("yyyy年MM月dd日 HH:mm:ss ");
//        SimpleDateFormat formatter    =   new    SimpleDateFormat    ("yyyy年MM月dd日 , EEEE ");
        String str = mFormat.format(date);
        return str;
    }

    //时间转换
    public static String tranTime(String time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        Date curDate = new Date(Long.valueOf(time));//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }


    /**
     * 获取当前时间
     */
    public static String initCurDate() {
        String date = DateUtil.getSystemTimeMore(1);
        String year = date.split("年")[0];
        String month = date.split("年")[1].split("月")[0];
        Log.i("ZAO",date + "\n" + year + "\n" + month);
        return year + "&" + month;
    }
}
