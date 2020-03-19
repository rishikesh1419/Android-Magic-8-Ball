package com.example.magic_8_ball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private float accel;
    private float accelCurrent;
    private float accelLast;

    TextView answerTv;
    Button askBtn;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerTv = findViewById(R.id.answerTv);
        askBtn = findViewById(R.id.askBtn);

        list = new ArrayList<String>();
        list.add("It is certain.");
        list.add("It is decidedly so.");
        list.add("Without a doubt.");
        list.add("Yes - definitely.");
        list.add("You may rely on it.");
        list.add("As I see it, yes.");
        list.add("Most likely.");
        list.add("Outlook good.");
        list.add("Yes.");
        list.add("Signs point to yes.");
        list.add("Reply hazy, try again.");
        list.add("Ask again later.");
        list.add("Better not tell you now.");
        list.add("Cannot predict now.");
        list.add("Concentrate and ask again.");
        list.add("Don't count on it.");
        list.add("My reply is no.");
        list.add("My sources say no.");
        list.add("Outlook not so good.");
        list.add("Very doubtful.");

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Objects.requireNonNull(sensorManager).registerListener(sensorListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_GAME);
        accel = 10f;
        accelCurrent = SensorManager.GRAVITY_EARTH;
        accelLast = SensorManager.GRAVITY_EARTH;

        Toast.makeText(getApplicationContext(), "Shake the device or click 'ASK!'", Toast.LENGTH_SHORT).show();


    }

    private final SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            accelLast = accelCurrent;
            accelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
            float delta = accelCurrent - accelLast;
            accel = accel * 0.9f + delta;
            if (accel > 12) {
                Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                // answerTv.startAnimation(animFadeOut);
                int a;
                Random r = new Random();
                a = r.nextInt((19) + 1);
                answerTv.setText(list.get(a));
                answerTv.startAnimation(animFadeIn);
            }
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    @Override
    protected void onResume() {
        sensorManager.registerListener(sensorListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
        super.onResume();
    }
    @Override
    protected void onPause() {
        sensorManager.unregisterListener(sensorListener);
        super.onPause();
    }

    public void ask(View view) {
       // Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
       // answerTv.startAnimation(animFadeOut);
        int a;
        Random r = new Random();
        a = r.nextInt((19) + 1);
        answerTv.setText(list.get(a));
        answerTv.startAnimation(animFadeIn);
    }

    public void reset(View view) {
      //  Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
      //  answerTv.startAnimation(animFadeOut);
        answerTv.setText("Magic 8 Ball");
        answerTv.startAnimation(animFadeIn);

    }
}
