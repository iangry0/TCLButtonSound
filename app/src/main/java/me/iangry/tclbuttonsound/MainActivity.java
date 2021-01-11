package me.iangry.tclbuttonsound;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class MainActivity extends Activity {
    private Button buttonSum;

    private Button buttonSum2;

    private Button buttonSum3;

    private Button buttonSum4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();

        addListenerOnButton2();

        Method2Button1();

        Method2Button2();
    }

    public void addListenerOnButton() {
        buttonSum = (Button) findViewById(R.id.button);

        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast=Toast.makeText(getApplicationContext(),"Turned off button move sound effects",Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
                String commandToRun = "adb shell settings put system sound_effects_enabled 0";
                try {
                    Runtime.getRuntime().exec(commandToRun);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void addListenerOnButton2() {
        buttonSum2 = (Button) findViewById(R.id.button2);

        buttonSum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast=Toast.makeText(getApplicationContext(),"Turned on button move sound effects",Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
                String commandToRun = "adb shell settings put system sound_effects_enabled 1";
                try {
                    Runtime.getRuntime().exec(commandToRun);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void Method2Button1() {
        buttonSum3 = (Button) findViewById(R.id.button3);

        buttonSum3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Turned off button move sound effects", Toast.LENGTH_SHORT);
                toast.setMargin(50, 50);
                toast.show();
                AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
                audioManager.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_LOWER, 0 /*or: AudioManager.FLAG_SHOW_UI*/);
            }
        });
    }
    public void Method2Button2() {
        buttonSum4 = (Button) findViewById(R.id.button4);

        buttonSum4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
                audioManager.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_RAISE, 1 /*or: AudioManager.FLAG_SHOW_UI*/);
            }
        });
    }
}