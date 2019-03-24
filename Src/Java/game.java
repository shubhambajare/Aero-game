package com.example.clash.aero_game;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
public class game extends AppCompatActivity {
 ImageView i,fire1,fire2,fire3,pause;
 MediaPlayer mediaPlayer;
 TextView score,tvlevel,count;
 int x,Swidth,Sheight,decide=0,lengthA=80;
 float y1=0,y2=0,y3=0,SCORE=0;
 float aspeed,bspeed,cspeed;
 CountDownTimer c;
 int af,bf,cf,level=0;
 Random random=new Random();
 Boolean a11,b11,c11,pp;
 TextView so;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_game);
this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PO
RTRAIT);
 this.getWindow().getDecorView()
 .setSystemUiVisibility(
View.SYSTEM_UI_FLAG_FULLSCREEN |
View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
View.SYSTEM_UI_FLAG_LAYOUT_STABLE
 );
 so=(TextView)findViewById(R.id.so);
 mediaPlayer = MediaPlayer.create(this,
R.raw.mainplaybackground);mediaPlayer.setLooping(true);
 if(music.mute==true) {
 mediaPlayer.start();
 so.setVisibility(View.INVISIBLE);
 }else
 so.setVisibility(View.VISIBLE);
 Swidth =
getWindowManager().getDefaultDisplay().getWidth();
 Sheight =
getWindowManager().getDefaultDisplay().getHeight();
 tvlevel = (TextView) findViewById(R.id.tvLevel);
 score = (TextView) findViewById(R.id.tvScore);
 count = (TextView) findViewById(R.id.textView);
 ImageView sound=(ImageView)findViewById(R.id.ivsound);
 x = Swidth / 2 - lengthA;
 a11 = b11 = true;
 c11 = false;
 level = 0;
 pp = true;
 switch (random.nextInt(3)){
 case 0: af =1;
 bf = 1;
 cf = 0;
 break;
 case 1: af =1;
 bf = 0;
 cf = 1;
 break;
 case 2: af =0;
 bf = 1;
 cf = 1;
 break;
 case 3: af =1;
 bf = 1;
cf = 0;
 break;
 }
 i = (ImageView) findViewById(R.id.aero);
 pause = (ImageView) findViewById(R.id.pause);
 fire1 = (ImageView) findViewById(R.id.fire1);
 fire2 = (ImageView) findViewById(R.id.fire2);
 fire3 = (ImageView) findViewById(R.id.fire3);
 fire1.setY(0);
 fire2.setY(0);
 fire3.setY(0);
 i.setX(Swidth / 2 - lengthA);
 i.setY(Sheight - 200);
 x = (int) i.getX();
 aspeed=random.nextInt(5);
 bspeed=random.nextInt(5);
 cspeed=random.nextInt(5);
 c = new CountDownTimer(100000, 5) {
 @Override
