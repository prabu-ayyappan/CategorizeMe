package com.example.categorizeme;

import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //    TextView textview;
    ImageView randomImageView;
    ImageView statusimage;
    ImageView vegetablesView;
    ImageView animalImageView;
    ImageView fruitsView;
    ImageView bodypartImageView;
    String backgroundImageName;

    HashMap <Integer, String> catHash = new HashMap<Integer, String>() {{
        put(R.drawable.animals_elephant,"animals_elephant");
        put(R.drawable.animals_cat,"animals_cat");
        put(R.drawable.animals_dog,"animals_dog");
        put(R.drawable.animals_goat,"animals_goat");
        put(R.drawable.animals_horse,"animals_horse");

        put(R.drawable.animals_camel,"animals_camel");
        put(R.drawable.animals_cow,"animals_cow");
        put(R.drawable.animals_girafee,"animals_girafee");
        put(R.drawable.animals_lion,"animals_lion");
        put(R.drawable.animals_monkey,"animals_monkey");
        put(R.drawable.animals_rabbit,"animals_rabbit");
        put(R.drawable.animals_sheep,"animals_sheep");
        put(R.drawable.animals_tiger,"animals_tiger");
        put(R.drawable.animals_zeebra,"animals_zeebra");

        put(R.drawable.fruits_apple,"fruits_apple");
        put(R.drawable.fruits_banana,"fruits_banana");
        put(R.drawable.fruits_pomegranate,"fruits_pomegranate");
        put(R.drawable.fruits_watermelon,"fruits_watermelon");
        put(R.drawable.fruits_dates,"fruits_dates");
        put(R.drawable.fruits_kiwi,"fruits_kiwi");
        put(R.drawable.fruits_fig,"fruits_fig");
        put(R.drawable.fruits_orange,"fruits_orange");
        put(R.drawable.fruits_guava,"fruits_guava");
        put(R.drawable.fruits_grapes,"fruits_grapes");
        put(R.drawable.fruits_papaya,"fruits_papaya");
        put(R.drawable.fruits_strawberry,"fruits_strawberry");
        put(R.drawable.fruits_pineapple,"fruits_pineapple");

        put(R.drawable.vegetables_carrot,"vegetables_carrot");
        put(R.drawable.vegetables_beetroot,"vegetables_beetroot");
        put(R.drawable.vegetables_onion,"vegetables_onion");
        put(R.drawable.vegetables_bitterguard,"vegetables_bitterguard");
        put(R.drawable.vegetables_beans,"vegetables_beans");
        put(R.drawable.vegetables_brinjal,"vegetables_brinjal");
        put(R.drawable.vegetables_cauliflower,"vegetables_cauliflower");
        put(R.drawable.vegetables_cucumber,"vegetables_cucumber");
        put(R.drawable.vegetables_radish,"vegetables_radish");
        put(R.drawable.vegetables_drumstick,"vegetables_drumstick");
        put(R.drawable.vegetables_ladiesfinger,"vegetables_ladiesfinger");
        put(R.drawable.vegetables_potato,"vegetables_potato");
        put(R.drawable.vegetables_greenpeas,"vegetables_greenpeas");
        put(R.drawable.vegetables_tomato,"vegetables_tomato");

        put(R.drawable.pb_arm,"pb_arm");
        put(R.drawable.pb_chin,"pb_chin");
        put(R.drawable.pb_eyes,"pb_eyes");
        put(R.drawable.pb_ears,"pb_ears");
        put(R.drawable.pb_face,"pb_face");
        put(R.drawable.pb_foot,"pb_foot");
        put(R.drawable.pb_hand,"pb_hand");
        put(R.drawable.pb_head,"pb_head");
        put(R.drawable.pb_knees,"pb_knees");
        put(R.drawable.pb_leg,"pb_leg");
        put(R.drawable.pb_lips,"pb_lips");
        put(R.drawable.pb_mouth,"pb_mouth");
        put(R.drawable.pb_neck,"pb_neck");
        put(R.drawable.pb_nose,"pb_nose");
        put(R.drawable.pb_teeth,"pb_teeth");
        put(R.drawable.pb_shoulders,"pb_shoulders");
        put(R.drawable.pb_toes,"pb_toes");
        put(R.drawable.pb_tounge,"pb_tounge");

    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_tab_landscape);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Configuration config = getResources().getConfiguration();
        if (config.smallestScreenWidthDp >= 600) {
            setContentView(R.layout.activity_main_tab_landscape);
        } else {
            setContentView(R.layout.activity_main_mobile_landscape);
        }

        statusimage = (ImageView)findViewById(R.id.status);
        randomImageView = (ImageView)findViewById(R.id.randomImage);

        vegetablesView = (ImageView)findViewById(R.id.vegetables);
        animalImageView = (ImageView)findViewById(R.id.animalImage);
        fruitsView = (ImageView)findViewById(R.id.fruits);
        bodypartImageView = (ImageView)findViewById(R.id.bodypartImage);

        Random       random    = new Random();
        List<Integer> keys      = new ArrayList<Integer>(catHash.keySet());
        Integer       randomKey = keys.get( random.nextInt(keys.size()) );



        randomImageView.setImageResource(randomKey);
        randomImageView.setTag(catHash.get(randomKey));
        backgroundImageName = String.valueOf(randomImageView.getTag());
    }
    public void validate(View view){
        final MediaPlayer mpw = MediaPlayer.create(this, R.raw.wrong);
        final MediaPlayer mpc = MediaPlayer.create(this, R.raw.correct);
        if(view.getId()==R.id.vegetables && backgroundImageName.matches("vegetables_.*")){
            statusimage.setBackgroundResource(R.drawable.check_mark);
            mpc.start();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            }, 3000);
        }else if(view.getId()==R.id.fruits && backgroundImageName.matches("fruits_.*")){
            statusimage.setBackgroundResource(R.drawable.check_mark);

            mpc.start();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            }, 3000);
        }else if(view.getId()==R.id.animalImage && backgroundImageName.matches("animals_.*")){
            statusimage.setBackgroundResource(R.drawable.check_mark);
            mpc.start();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            }, 3000);
        }else if(view.getId()==R.id.bodypartImage && backgroundImageName.matches("pb.*")){
            statusimage.setBackgroundResource(R.drawable.check_mark);
            mpc.start();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            }, 3000);
        }else{
            statusimage.setBackgroundResource(R.drawable.wrong_mark);
            mpw.start();
        }
    }

}
