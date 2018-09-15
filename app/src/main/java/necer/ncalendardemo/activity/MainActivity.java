package necer.ncalendardemo.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import cn.aigestudio.datepicker.cons.DPMode;
import cn.aigestudio.datepicker.views.DatePicker;
import necer.ncalendardemo.R;
import necer.ncalendardemo.datepicker.DatePickerActivity;
import necer.ncalendardemo.utils.DateUtil;

public class MainActivity extends AppCompatActivity {

    String year;
    String month;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvVersion = (TextView) findViewById(R.id.tv_version);
        tvVersion.setText("版本：" + Utils.getCurrentVersion(this));

    }

    public void toMiui(View v) {
        startActivity(new Intent(this, NCalendarActivity.class));
    }


    public void defaultSelect(View v) {
        startActivity(new Intent(this, MonthSelectActivity.class));
    }

    public void notDefaultSelect(View v) {
        startActivity(new Intent(this, MonthNotSelectActivity.class));
    }

    public void week(View v) {
        startActivity(new Intent(this, WeekActivity.class));
    }

    public void fragment(View v) {
        startActivity(new Intent(this, TestFragmentActivity.class));
    }


    /**
     * DataPicker
     * @param view
     */
    public void datePicker(View view) {
        startActivity(new Intent(getApplicationContext(), DatePickerActivity.class));
    }


    /**
     * 弹出时间选择器弹框
     */
    private void showDialog() {
        final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
        dialog.show();
        DatePicker picker = new DatePicker(MainActivity.this);
        picker.setDate(Integer.parseInt(DateUtil.initCurDate().split("&")[0]), Integer.parseInt(DateUtil.initCurDate().split("&")[1]));
        picker.setMode(DPMode.SINGLE);
        picker.setOnDatePickedListener(new DatePicker.OnDatePickedListener() {
            @Override
            public void onDatePicked(String date) {
                Toast.makeText(MainActivity.this, date, Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setContentView(picker, params);
        dialog.getWindow().setGravity(Gravity.CENTER);
    }
}