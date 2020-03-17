package com.example.magic_8_ball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


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

    }

    public void ask(View view) {
        Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
       // answerTv.startAnimation(animFadeOut);
        int a;
        Random r = new Random();
        a = r.nextInt((19) + 1);
        answerTv.setText(list.get(a));
        answerTv.startAnimation(animFadeIn);
    }

    public void reset(View view) {
        Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
      //  answerTv.startAnimation(animFadeOut);
        answerTv.setText("Magic 8 Ball");
        answerTv.startAnimation(animFadeIn);

    }
}
