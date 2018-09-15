package necer.ncalendardemo.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.necer.ncalendar.calendar.NCalendar;
import com.necer.ncalendar.listener.OnCalendarChangedListener;
import com.necer.ncalendar.utils.LunarCalendarUtils;
import com.necer.ncalendar.utils.MyLog;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import necer.ncalendardemo.R;
import necer.ncalendardemo.adapter.AAAdapter;
import necer.ncalendardemo.database.DailyNotesDao;
import necer.ncalendardemo.utils.ConstantValue;
import necer.ncalendardemo.utils.ZaoUtils;

/**
 * Created by necer on 2017/9/27.
 * QQ群:127278900
 */

public class NCalendarActivity extends AppCompatActivity implements OnCalendarChangedListener {


    private NCalendar ncalendar;
    private RecyclerView recyclerView;
    private TextView tv_month;
    private TextView tv_date;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_ncalendar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }

        ncalendar = (NCalendar) findViewById(R.id.ncalendarrrr);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        tv_month = (TextView) findViewById(R.id.tv_month);
        tv_date = (TextView) findViewById(R.id.tv_date);


     //   ncalendar.setDateInterval("2017-04-02","2018-01-01");



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AAAdapter aaAdapter = new AAAdapter(this);
        recyclerView.setAdapter(aaAdapter);
        ncalendar.setOnCalendarChangedListener(this);

        ncalendar.post(new Runnable() {
            @Override
            public void run() {

                List<String> list = new ArrayList<>();
                list.add("2018-09-21");
                list.add("2018-10-21");
                list.add("2018-10-1");
                list.add("2018-10-15");
                list.add("2018-10-18");
                list.add("2018-10-26");
                list.add("2018-11-21");

                ncalendar.setPoint(list);
            }
        });
    }


    @Override
    public void onCalendarChanged(LocalDate date) {
        tv_month.setText(date.getMonthOfYear() + "月");
        LunarCalendarUtils.Lunar lunar = LunarCalendarUtils.solarToLunar(new LunarCalendarUtils.Solar(date.getYear(), date.getMonthOfYear(), date.getDayOfMonth()));
        String lunarDayString = LunarCalendarUtils.getLunarDayString(date.getYear(), date.getMonthOfYear(), date.getDayOfMonth(), lunar.lunarYear, lunar.lunarMonth, lunar.lunarDay, lunar.isLeap);
        tv_date.setText(date.getYear() + "年" + date.getMonthOfYear() + "月" + date.getDayOfMonth() + "日" + "  " + lunarDayString);

        MyLog.d("dateTime::" + date.toString("yyyy-MM-dd"));


    }


    public void setDate(View view) {
        ncalendar.setDate("2099-06-23");
        addData();
    }


    public void toMonth(View view) {
        ncalendar.toMonth();
    }

    public void toWeek(View view) {
        ncalendar.toWeek();
    }

    public void toToday(View view) {
        ncalendar.toToday();
    }

    public void toNextPager(View view) {
        ncalendar.toNextPager();
    }

    public void toLastPager(View view) {
        ncalendar.toLastPager();
    }


    public void setPoint(View view) {
        List<String> list = new ArrayList<>();
        list.add("2017-09-21");
        list.add("2017-10-21");
        list.add("2017-10-1");
        list.add("2017-10-15");
        list.add("2017-10-18");
        list.add("2017-10-26");
        list.add("2017-11-21");

        ncalendar.setPoint(list);
    }

    /**
     * 添加测试数据
     */
    private void addData() {
        Toast.makeText(getApplicationContext(),"自动添加数据",Toast.LENGTH_SHORT).show();
        new Thread(){
            @Override
            public void run() {
                super.run();
                //批量添加数据
                addNotesData();
            }
        }.start();
    }

    /**
     * 添加测试数据
     */
    private void addNotesData() {
        {
            DailyNotesDao dao = DailyNotesDao.getInstance(this);
            for(int i = 0 ; i < 100 ; i++){
                String title;
                String author ;
                String content;
                String picpath;
                String email ;
                String time;
                if(i < 10){
                    title = "1328238000" + i;
                    author = "蜗牛" + i;
                   content = ZaoUtils.getSystemTimeMore(1);
                    picpath = "https://img3.doubanio.com/view/status/m/public/3c0f4bfec96a30e.webp";
                    email = "sune"+ i +"do@qq.com" ;
                    time = ZaoUtils.getSystemTimeMore(1);
                    //往数据库插入数据
                    dao.insert(title, author,content,picpath,email,time);
                    ZaoUtils.sleep(20);
                }  else if(i < 100){
                    title = "132823800" + i;
                    author = "蜗牛" + i;
                    content = ZaoUtils.getSystemTimeMore(1);
                    picpath = "https://img3.doubanio.com/view/status/m/public/3c0f4bfec96a30e.webp";
                    email = "sune"+ i +"do@qq.com" ;
                    time = ZaoUtils.getSystemTimeMore(1);
                    //往数据库插入数据
                    dao.insert(title, author,content,picpath,email,time);
                    //睡眠，
                    ZaoUtils.sleep(20);
                }  else if (i < 1000){
                    title = "132823800" + i;
                    author = "蜗牛" + i;
                    content = ZaoUtils.getSystemTimeMore(1);
                    picpath = "https://img3.doubanio.com/view/status/m/public/3c0f4bfec96a30e.webp";
                    email = "sune"+ i +"do@qq.com" ;
                    time = ZaoUtils.getSystemTimeMore(1);
                    //往数据库插入数据
                    dao.insert(title, author,content,picpath,email,time);
                    ZaoUtils.sleep(10);
                }
            }

            //黑名单的数据库
            ZaoUtils.copyDBtoSD(getApplicationContext());
        }
    }
}
