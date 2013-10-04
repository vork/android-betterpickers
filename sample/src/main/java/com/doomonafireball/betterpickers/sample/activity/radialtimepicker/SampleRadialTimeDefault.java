package com.doomonafireball.betterpickers.sample.activity.radialtimepicker;

import com.doomonafireball.betterpickers.radialtimepicker.RadialPickerLayout;
import com.doomonafireball.betterpickers.radialtimepicker.RadialTimePickerDialog;
import com.doomonafireball.betterpickers.sample.R;
import com.doomonafireball.betterpickers.sample.activity.BaseSampleActivity;

import org.joda.time.DateTime;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * User: derek Date: 3/17/13 Time: 3:59 PM
 */
public class SampleRadialTimeDefault extends BaseSampleActivity
        implements RadialTimePickerDialog.OnTimeSetListener {

    private TextView text;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_and_button);

        text = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);

        text.setText("--");
        button.setText("Set Time");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                DateTime now = DateTime.now();
                RadialTimePickerDialog timePickerDialog = RadialTimePickerDialog
                        .newInstance(SampleRadialTimeDefault.this, now.getHourOfDay(), now.getMinuteOfHour(),
                                DateFormat.is24HourFormat(SampleRadialTimeDefault.this));
                timePickerDialog.show(fm, "fragment_time_picker_name");
            }
        });
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {
        text.setText("" + hourOfDay + ":" + minute);
    }
}
