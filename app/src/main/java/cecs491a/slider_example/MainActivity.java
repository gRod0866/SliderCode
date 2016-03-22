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

public class MainActivity extends AppCompatActivity {//public class RegisterSliders()
    //EditText Username;
    //EditText Name;
    //EditText Birthdate;

    SeekBar pGender, pExpression, pOrientation;
    SeekBar sGenderMax, sExpressionMax, sOrientationMax;
    SeekBar sGenderMin, sExpressionMin, sOrientationMin;

    Button button;
    TextView text1, text2, text3, text4, text5, text6, text7, text8, text9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pGender = (SeekBar) findViewById(R.id.pGender);
        pExpression = (SeekBar) findViewById(R.id.pExpression);
        pOrientation = (SeekBar) findViewById(R.id.pOrientation);
        sGenderMax = (SeekBar) findViewById(R.id.sGenderMax);
        sExpressionMax = (SeekBar) findViewById(R.id.sExpressionMax);
        sOrientationMax = (SeekBar) findViewById(R.id.sOrientationMax);
        sGenderMin = (SeekBar) findViewById(R.id.sGenderMin);
        sExpressionMin = (SeekBar) findViewById(R.id.sExpressionMin);
        sOrientationMin = (SeekBar) findViewById(R.id.sOrientationMin);

        text1 = (TextView) findViewById(R.id.textPGender);
        text2 = (TextView) findViewById(R.id.textPExpress);
        text3 = (TextView) findViewById(R.id.textPOrient);
        text4 = (TextView) findViewById(R.id.textSGenderMax);
        text5 = (TextView) findViewById(R.id.textSExpressMax);
        text6 = (TextView) findViewById(R.id.textSOrientMax);
        text7 = (TextView) findViewById(R.id.textSGenderMin);
        text8 = (TextView) findViewById(R.id.textSExpressMin);
        text9 = (TextView) findViewById(R.id.textSOrientMin);

        button = (Button) findViewById(R.id.bSaveRegister);
        pGender.setMax(19);
        pExpression.setMax(19);
        pOrientation.setMax(19);
        sGenderMax.setMax(19);
        sExpressionMax.setMax(19);
        sOrientationMax.setMax(19);
        sGenderMin.setMax(19);
        sExpressionMin.setMax(19);
        sOrientationMin.setMax(19);
        main();

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //For sharedPreferences, we do this:

                //String sGenderValue = text1.getText.toString();
                //SharedPreferences pGenderShared = getSharedPrefernces(PREFS, 0);
                //Editor editor = pGenderShared.edit();
                //edit.putString("personalslider1", sGenderValue);
                //edit.commit();

                //String sExpressionValue = text2.getText.toString();
                //SharedPreferences pExpressionShared = getSharedPrefernces(PREFS, 0);
                //Editor editor = pExpressionShared.edit();
                //edit.putString("personalslider2", sExpressionValue);
                //edit.commit();

                //String sOrientationValue = text3.getText.toString();
                //SharedPreferences pOrientationShared = getSharedPrefernces(PREFS, 0);
                //Editor editor = pOrientationShared.edit();
                //edit.putString("personalslider3", sOrientationValue);
                //edit.commit();

                //String sGenderMaxValue = text4.getText.toString();
                //SharedPreferences sGenderMaxShared = getSharedPrefernces(PREFS, 0);
                //Editor editor = sGenderMaxShared.edit();
                //edit.putString("seekingSlider1a", sGenderMaxValue);
                //edit.commit();

                //String sGenderMinValue = text5.getText.toString();
                //SharedPreferences sGenderMinShared = getSharedPrefernces(PREFS, 0);
                //Editor editor = sGenderMinShared.edit();
                //edit.putString("seekingSlider1b", sGenderMinValue);
                //edit.commit();

                //String sExpressionMaxValue = text6.getText.toString();
                //SharedPreferences sExpressionMaxShared = getSharedPrefernces(PREFS, 0);
                //Editor editor = sExpressionMaxShared.edit();
                //edit.putString("seekingSlider2a", sExpressionMaxValue);
                //edit.commit();

                //String sExpressionMinValue = text7.getText.toString();
                //SharedPreferences sExpressionMinShared = getSharedPrefernces(PREFS, 0);
                //Editor editor = sExpressionMinShared.edit();
                //edit.putString("seekingSlider2b", sExpressionMinValue);
                //edit.commit();

                //String sOrientationMaxValue = text8.getText.toString();
                //SharedPreferences sOrientationMaxShared = getSharedPrefernces(PREFS, 0);
                //Editor editor = sOrientationMaxShared.edit();
                //edit.putString("seekingSlider3a", sOrientationMaxValue);
                //edit.commit();

                //String sOrientationMinValue = text9.getText.toString();
                //SharedPreferences sOrientationMinShared = getSharedPrefernces(PREFS, 0);
                //Editor editor = sOrientationMinShared.edit();
                //edit.putString("seekingSlider3b", sOrientationMinValue);
                //edit.commit();

                //Validator:
                /*
                if(text1.getText().length == 0){
                    text1.setError("Please drag your slider.");
                } else if(text4 < text7){
                    text4.setError("Max number can't be less than the min");
                } else if(text5 < text8) {
                    text5.setError("Max number can't be less than the min");
                } else if(text6 < text9){
                    text6.setError("Max number can't be less than the min");
                }
                */
                //Intent object to pass values.

                Intent intent = new Intent(getApplicationContext(), Slider.class);
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

                new sendPSliders().execute();
                new sendSSliders().execute();

            }
        });
    }

    //Main Class for registering sliders.
    public void main(){
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

    class sendPSliders extends AsyncTask<Void,Void,Void> {
        String gperson = text1.getText().toString();
        String eperson = text2.getText().toString();
        String operson = text3.getText().toString();

        PrintWriter out;
        BufferedReader in;

        protected Void doInBackground(Void... args) {
            try {
                //host = InetAddress.getLocalHost();
                Socket sock = new Socket("10.0.2.2", 4910);
                out = new PrintWriter(sock.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

                String command = "setPSlider, " + "Aguysname" + ", " + gperson + ", " + eperson
                        + ", " + operson;

                out.println(command);//Sends command to the server.
                Log.i("Register Command, ", command);

                String temp;
                while ((temp = in.readLine()) != null) {
                    if(temp == "true"){
                        Log.i("true", command);
                    } else {
                        Log.i("Error", temp);
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

    class sendSSliders extends AsyncTask<Void,Void,Void> {
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

                String command = "setSSlider, " + "Aguysname" + ", " + gmax + ", " + gmin + ", " +
                        emax + ", " + emin + ", " + omax + ", " + omin;

                out.println(command);
                Log.i("Register Command", command);
                String temp;
                while ((temp = in.readLine()) != null) {
                    if(temp == "true"){
                        Log.d("true", command);
                    } else {
                        Log.d("Error", temp);
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