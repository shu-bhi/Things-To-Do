package com.example.thingstodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class activity_2 extends AppCompatActivity {
    ImageView imageView;
    Animation logo_anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        imageView=findViewById(R.id.imageView2);

        logo_anim= AnimationUtils.loadAnimation(this,R.anim.animm);
        imageView.setAnimation(logo_anim) ;
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Anonymous object
                startActivity(new Intent(activity_2.this,MainActivity.class));
                finish();
            }
        },3000);
    }
}