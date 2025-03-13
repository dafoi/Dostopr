package com.example.ghuyo9kli;

import android.app.Dialog;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class DialogActivity extends AppCompatActivity {

    TextView currentDateTime;
    Calendar dateAndTime = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dialog);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        currentDateTime = findViewById(R.id.currentDateTime);
        setInitialDateTime();
        findViewById(R.id.dateButton).setOnClickListener(v -> setDate());
        findViewById(R.id.timeButton).setOnClickListener(v -> setTime());



        Button buttonShowDialog = findViewById(R.id.dialogButton);
        buttonShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }
    public void setDate(){
        new DatePickerDialog(DialogActivity.this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
        .show();
    }
    public void setTime() {
new TimePickerDialog(DialogActivity.this, t,
dateAndTime.get(Calendar.HOUR_OF_DAY),
dateAndTime.get(Calendar.MINUTE), true)
.show();
}
    private void setInitialDateTime() {

        currentDateTime.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                | DateUtils.FORMAT_SHOW_TIME));
}
TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
dateAndTime.set(Calendar.MINUTE, minute);
setInitialDateTime();
}
};
    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
dateAndTime.set(Calendar.YEAR, year);
dateAndTime.set(Calendar.MONTH, monthOfYear);
dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
setInitialDateTime();
}
};

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Диалоговое окно")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setView(R.layout.dialodg)
                .setPositiveButton("OK", null)
                .setNegativeButton("Отмена", null)
                .create();

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}