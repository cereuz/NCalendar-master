package necer.ncalendardemo.datepicker;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import cn.aigestudio.datepicker.cons.DPMode;
import cn.aigestudio.datepicker.views.DatePicker;
import necer.ncalendardemo.R;
import necer.ncalendardemo.utils.DateUtil;

public class DatePickerActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_ncalendar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }

        showCalendar();
    }

    /**
     * 加载日历
     */
    private void showCalendar() {
        DatePicker picker = new DatePicker(getApplicationContext());
        picker.setDate(Integer.parseInt(DateUtil.initCurDate().split("&")[0]), Integer.parseInt(DateUtil.initCurDate().split("&")[1]));
        picker.setMode(DPMode.SINGLE);
        picker.setOnDatePickedListener(new DatePicker.OnDatePickedListener() {
            @Override
            public void onDatePicked(String date) {
                Toast.makeText(getApplicationContext(), date, Toast.LENGTH_LONG).show();
            }
        });
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.getWindow().setContentView(picker, params);
        this.getWindow().setGravity(Gravity.CENTER);
    }
}
