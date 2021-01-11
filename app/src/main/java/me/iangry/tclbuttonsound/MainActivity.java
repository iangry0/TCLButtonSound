package me.iangry.tclbuttonsound;

import android.app.Activity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();

        addListenerOnButton2();

        ExitButton();
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
    public void ExitButton() {
        buttonSum3 = (Button) findViewById(R.id.button3);

        buttonSum3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}