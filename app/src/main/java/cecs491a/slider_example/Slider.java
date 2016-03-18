package cecs491a.slider_example;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.*;
import android.widget.TextView;
import android.content.Intent;
import android.widget.SeekBar;
import java.lang.Integer;
import android.widget.Button;
import android.util.Log;
import android.content.SharedPreferences;

public class Slider extends AppCompatActivity {//public class HomePage()

    //EditText Username;
    //EditText Name;
    //EditText Birthdate;

    SeekBar HomePGender, HomePExpress, HomePOrient,
            HomeSeekGender, HomeSeekExpress, HomeSeekOrient,
            HomeSeekGenderMin, HomeSeekExpressMin, HomeSeekOrientMin;


    TextView PGenderData, PExpressionData, POrientationData, SGenderData, SExpressionData,
            SOrientationData, SGenderDataMin, SExpressionDataMin, SOrientationDataMin;

    Button EditSliders, EditInfoButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        //Username = (EditText) findViewById(R.id.username);
        //Name = (EditText) findViewById(R.id.name);
        //Birthdate = (EditText findViewById(R.id.birthday));

        EditSliders = (Button) findViewById(R.id.editSliders);
        EditInfoButton = (Button) findViewById(R.id.editProfileButton);

        PGenderData = (TextView) findViewById(R.id.pGenderData);
        PExpressionData = (TextView) findViewById(R.id.pExpressionData);
        POrientationData = (TextView) findViewById(R.id.pOrientationData);
        SGenderData = (TextView) findViewById(R.id.sGenderData);
        SExpressionData = (TextView) findViewById(R.id.sExpressionData);
        SOrientationData = (TextView) findViewById(R.id.sOrientationData);
        SGenderDataMin = (TextView) findViewById(R.id.sGenderDataMin);
        SExpressionDataMin = (TextView) findViewById(R.id.sExpressionDataMin);
        SOrientationDataMin = (TextView) findViewById(R.id.sOrientationDataMin);

        HomePGender = (SeekBar) findViewById(R.id.homePGender);
        HomePExpress = (SeekBar) findViewById(R.id.homePExpress);
        HomePOrient = (SeekBar) findViewById(R.id.homePOrient);
        HomeSeekGender = (SeekBar) findViewById(R.id.homeSeekGender);
        HomeSeekExpress = (SeekBar) findViewById(R.id.homeSeekExpress);
        HomeSeekOrient = (SeekBar) findViewById(R.id.homeSeekOrient);
        HomeSeekGenderMin = (SeekBar) findViewById(R.id.homeSeekGenderMin);
        HomeSeekExpressMin = (SeekBar) findViewById(R.id.homeSeekExpressMin);
        HomeSeekOrientMin = (SeekBar) findViewById(R.id.homeSeekOrientMin);

        HomePGender.setMax(19);
        HomePExpress.setMax(19);
        HomePOrient.setMax(19);
        HomeSeekGender.setMax(19);
        HomeSeekExpress.setMax(19);
        HomeSeekOrient.setMax(19);
        HomeSeekGenderMin.setMax(19);
        HomeSeekExpressMin.setMax(19);
        HomeSeekOrientMin.setMax(19);

        Intent intent1 = getIntent();
        String value1 = intent1.getStringExtra("personalSlider1");
        int val1 = Integer.parseInt(value1);
        PGenderData.setText(value1);

        String value2 = intent1.getStringExtra("personalSlider2");
        int val2 = Integer.parseInt(value2);
        PExpressionData.setText(value2);

        String value3 = intent1.getStringExtra("personalSlider3");
        int val3 = Integer.parseInt(value3);
        POrientationData.setText(value3);

        String value4 = intent1.getStringExtra("seekingSlider1a");
        int val4 = Integer.parseInt(value4);
        SGenderData.setText(value4);

        String value5 = intent1.getStringExtra("seekingSlider1b");
        int val5 = Integer.parseInt(value5);
        SExpressionData.setText(value5);

        String value6 = intent1.getStringExtra("seekingSlider2a");
        int val6 = Integer.parseInt(value6);
        SOrientationData.setText(value6);

        String value7 = intent1.getStringExtra("seekingSlider2b");
        int val7 = Integer.parseInt(value7);
        SGenderDataMin.setText(value7);

        String value8 = intent1.getStringExtra("seekingSlider3a");
        int val8 = Integer.parseInt(value8);
        SExpressionDataMin.setText(value8);

        String value9 = intent1.getStringExtra("seekingSlider3b");
        int val9 = Integer.parseInt(value9);
        SOrientationDataMin.setText(value9);

        HomePGender.setProgress(val1);
        HomePExpress.setProgress(val2);
        HomePOrient.setProgress(val3);
        HomeSeekGender.setProgress(val4);
        HomeSeekExpress.setProgress(val5);
        HomeSeekOrient.setProgress(val6);
        HomeSeekGenderMin.setProgress(val7);
        HomeSeekExpressMin.setProgress(val8);
        HomeSeekOrientMin.setProgress(val9);
        HomePage();

        EditSliders.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //switch(v.getId()){
                //case R.id.editProfileButton:
                //case R.id.editSliders:

                Intent intentSliders = new Intent(getApplicationContext(), SliderUpdate.class);
                String value1 = PGenderData.getText().toString();
                intentSliders.putExtra("personalUpSlider1", value1);

                String value2 = PExpressionData.getText().toString();
                intentSliders.putExtra("personalUpSlider2", value2);

                String value3 = POrientationData.getText().toString();
                intentSliders.putExtra("personalUpSlider3", value3);

                String value4 = SGenderData.getText().toString();
                intentSliders.putExtra("seekingUpSlider1a", value4);

                String value5 = SExpressionData.getText().toString();
                intentSliders.putExtra("seekingUpSlider1b", value5);

                String value6 = SOrientationData.getText().toString();
                intentSliders.putExtra("seekingUpSlider2a", value6);

                String value7 = SGenderDataMin.getText().toString();
                intentSliders.putExtra("seekingUpSlider2b", value7);

                String value8 = SExpressionDataMin.getText().toString();
                intentSliders.putExtra("seekingUpSlider3a", value8);

                String value9 = SOrientationDataMin.getText().toString();
                intentSliders.putExtra("seekingUpSlider3b", value9);
                startActivity(intentSliders);
            }
        });
    }
        //switch for buttons


    public void HomePage() {

        HomePGender.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub

                value = progress;
                PGenderData.setText(String.valueOf(progress + 1));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }
        });

        HomePExpress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                value = progress;
                PExpressionData.setText(String.valueOf(progress + 1));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }
        });

        HomePOrient.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                value = progress;
                POrientationData.setText(String.valueOf(progress + 1));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        ///////The following methods contribute to the Seeker Values.////////
        //Seek gender Value.
        HomeSeekGender.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                value = progress;
                SGenderData.setText(String.valueOf(progress + 1));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });


        HomeSeekExpress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                value = progress;
                SExpressionData.setText(String.valueOf(progress + 1));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }
        });

        HomeSeekOrient.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                value = progress;
                SOrientationData.setText(String.valueOf(progress + 1));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        HomeSeekGenderMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                value = progress;
                SGenderDataMin.setText(String.valueOf(progress + 1));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }
        });


        HomeSeekExpressMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                value = progress;
                SExpressionDataMin.setText(String.valueOf(progress + 1));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }
        });

        HomeSeekOrientMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                value = progress;
                SOrientationDataMin.setText(String.valueOf(progress + 1));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });
    }
}