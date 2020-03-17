package com.example.sweetjar.ui.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sweetjar.R;
import com.example.sweetjar.ui.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    Thread objThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        startSplash();
    }

    private void startSplash(){
        try {

            Animation objAnimation = AnimationUtils.loadAnimation(
                    this,R.anim.translate
            );

            objAnimation.reset();
            ImageView imageView = findViewById(R.id.splashImage);
            imageView.clearAnimation();
            imageView.startAnimation(objAnimation);

            objThread = new Thread(){

                @Override
                public void run() {
                    int pauseIt=0;
                    while (pauseIt<6000){
                        try {
                            sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        pauseIt+=100;
                    }
                    startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                    SplashScreenActivity.this.finish();
                }
            };
            objThread.start();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }
}
