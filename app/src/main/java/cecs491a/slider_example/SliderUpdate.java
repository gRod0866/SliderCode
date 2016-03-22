package cecs491a.slider_example;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Button;
import android.content.*;
import android.widget.Toast;
import java.lang.Integer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
public class SliderUpdate extends AppCompatActivity {//The Sliders
    SeekBar pGender, pExpression, pOrientation;
    SeekBar sGenderMax, sExpressionMax, sOrientationMax, sGenderMin, sExpressionMin, sOrientationMin;
    Button UpdateButton;
    TextView text1, text2, text3, text4, text5, text6, text7, text8, text9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_update);
        pGender = (SeekBar) findViewById(R.id.pUpdateGender);
        pExpression = (SeekBar) findViewById(R.id.pUpdateExpression);
        pOrientation = (SeekBar) findViewById(R.id.pUpdateOrientation);
        sGenderMax = (SeekBar) findViewById(R.id.sUpdateGender);
        sExpressionMax = (SeekBar) findViewById(R.id.sUpdateExpression);
        sOrientationMax = (SeekBar) findViewById(R.id.sUpdateOrientation);
        sGenderMin = (SeekBar) findViewById(R.id.sUpdateGenderMin);
        sExpressionMin = (SeekBar) findViewById(R.id.sUpdateExpressionMin);
        sOrientationMin = (SeekBar) findViewById(R.id.sUpdateOrientationMin);

        text1 = (TextView) findViewById(R.id.textUpdatePGender);
        text2 = (TextView) findViewById(R.id.textUpdatePExpress);
        text3 = (TextView) findViewById(R.id.textUpdatePOrient);
        text4 = (TextView) findViewById(R.id.textUpdateSGender);
        text5 = (TextView) findViewById(R.id.textUpdateSExpress);
        text6 = (TextView) findViewById(R.id.textUpdateSOrient);
        text7 = (TextView) findViewById(R.id.textUpdateSGenderMin);
        text8 = (TextView) findViewById(R.id.textUpdateSExpressMin);
        text9 = (TextView) findViewById(R.id.textUpdateSOrientMin);

        UpdateButton = (Button) findViewById(R.id.bUpdateButton);
        pGender.setMax(19);
        pExpression.setMax(19);
        pOrientation.setMax(19);
        sGenderMax.setMax(19);
        sExpressionMax.setMax(19);
        sOrientationMax.setMax(19);
        sGenderMin.setMax(19);
        sExpressionMin.setMax(19);
        sOrientationMin.setMax(19);

        Intent intent1 = getIntent();
        String value1 = intent1.getStringExtra("personalUpSlider1");
        int val1 = Integer.parseInt(value1);
        text1.setText(value1);

        String value2 = intent1.getStringExtra("personalUpSlider2");
        int val2 = Integer.parseInt(value2);
        text2.setText(value2);

        String value3 = intent1.getStringExtra("personalUpSlider3");
        int val3 = Integer.parseInt(value3);
        text3.setText(value3);

        String value4 = intent1.getStringExtra("seekingUpSlider1a");
        int val4 = Integer.parseInt(value4);
        text4.setText(value4);

        String value5 = intent1.getStringExtra("seekingUpSlider1b");
        int val5 = Integer.parseInt(value5);
        text5.setText(value5);

        String value6 = intent1.getStringExtra("seekingUpSlider2a");
        int val6 = Integer.parseInt(value6);
        text6.setText(value6);

        String value7 = intent1.getStringExtra("seekingUpSlider2b");
        int val7 = Integer.parseInt(value7);
        text7.setText(value7);

        String value8 = intent1.getStringExtra("seekingUpSlider3a");
        int val8 = Integer.parseInt(value8);
        text8.setText(value8);

        String value9 = intent1.getStringExtra("seekingUpSlider3b");
        int val9 = Integer.parseInt(value9);
        text9.setText(value9);

        pGender.setProgress(val1);
        pExpression.setProgress(val2);
        pOrientation.setProgress(val3);
        sGenderMax.setProgress(val4);
        sExpressionMax.setProgress(val5);
        sOrientationMax.setProgress(val6);
        sGenderMin.setProgress(val7);
        sExpressionMin.setProgress(val8);
        sOrientationMin.setProgress(val9);
        updateSliders();

        UpdateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                new sendUpdatePSliders().execute();
                new sendUpdateSSliders().execute();
                //Intent object to pass values.
                Intent intent = new Intent(getApplicationContext(), Slider.class);//Homepage.class

                String value1 = text1.getText().toString();
                intent.putExtra("personalSlider1", value1);

                String value2 = text2.getText().toString();
                intent.putExtra("personalSlider2", value2);

                String value3 = text3.getText().toString();
                intent.putExtra("personalSlider3", value3);

                String value4 = text4.getText().toString();
                intent.putExtra("seekingSlider1a", value4);

                String value5 = text5.getText().toString();
                intent.putExtra("seekingSlider1b", value5);

                String value6 = text6.getText().toString();
                intent.putExtra("seekingSlider2a", value6);

                String value7 = text7.getText().toString();
                intent.putExtra("seekingSlider2b", value7);

                String value8 = text8.getText().toString();
                intent.putExtra("seekingSlider3a", value8);

                String value9 = text9.getText().toString();
                intent.putExtra("seekingSlider3b", value9);

                startActivity(intent);
            }
        });
    }

    public void updateSliders(){//Main Class for Updating Sliders
        pGender.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                value = progress;
                text1.setText(String.valueOf(progress + 1));
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

        pExpression.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                value = progress;
                text2.setText(String.valueOf(progress + 1));
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

        pOrientation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                value = progress;
                text3.setText(String.valueOf(progress + 1));
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

        sGenderMax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                value = progress;
                text4.setText(String.valueOf(progress + 1));
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

        sExpressionMax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                value = progress;
                text5.setText(String.valueOf(progress + 1));
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

        sOrientationMax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                value = progress;
                text6.setText(String.valueOf(progress + 1));
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

        sGenderMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                value = progress;
                text7.setText(String.valueOf(progress + 1));
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

        sExpressionMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                value = progress;
                text8.setText(String.valueOf(progress + 1));
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

        sOrientationMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                value = progress;
                text9.setText(String.valueOf(progress + 1));
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

    class sendUpdatePSliders extends AsyncTask<Void,Void,Void> {
        String gperson = text1.getText().toString();
        String eperson = text2.getText().toString();
        String operson = text3.getText().toString();

        PrintWriter out;
        BufferedReader in;

        protected Void doInBackground(Void... args) {
            try {
                Socket sock = new Socket("10.0.2.2", 4910);
                out = new PrintWriter(sock.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

                String command = "updatePSlider, " + "BPizzle" + ", " + gperson + ", " + eperson
                        + ", " + operson;

                out.println(command);
                Log.i("Register Command", command);
                String temp;
                while ((temp = in.readLine()) != null) {
                    if(temp == "true"){
                        System.out.println(temp);
                    } else {
                        Log.d("Error", command);
                    }
                    Log.d("Register Command, ", temp);
                    System.out.println(temp);
                }
                sock.close();
            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }
    }

    class sendUpdateSSliders extends AsyncTask<Void,Void,Void> {
        String gmax = text4.getText().toString();
        String emax = text5.getText().toString();
        String omax = text6.getText().toString();
        String gmin = text7.getText().toString();
        String emin = text8.getText().toString();
        String omin = text9.getText().toString();

        PrintWriter out;
        BufferedReader in;

        protected Void doInBackground(Void... args) {
            try {
                //host = InetAddress.getLocalHost();
                Socket sock = new Socket("10.0.2.2", 4910);
                out = new PrintWriter(sock.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

                //username = username of whatever was passed.
                String command = "updateSSlider, " + "BPizzle" + ", " + gmax + ", " + gmin + ", " +
                        emax + ", " + emin + ", " + omax + ", " + omin;

                out.println(command);
                Log.i("Register Command", command);
                String temp;
                while ((temp = in.readLine()) != null) {
                    if(temp == "true"){
                        System.out.println(temp);
                    } else {
                        Log.d("Error", command);
                    }
                    Log.d("Register Command, ", temp);
                    System.out.println(temp);
                }
                sock.close();
            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }
    }

}