package com.example.clash.aero_game;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
public class levelup extends AppCompatActivity {
 TextView level;
 ImageView play;
 int LEVEL;
 MediaPlayer mediaPlayer;
 TextView so;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_levelup);
this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PO
RTRAIT);
 this.getWindow().getDecorView()
 .setSystemUiVisibility(
View.SYSTEM_UI_FLAG_FULLSCREEN|
View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|
View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
View.SYSTEM_UI_FLAG_LAYOUT_STABLE
 );
 so=(TextView)findViewById(R.id.so);
 mediaPlayer = MediaPlayer.create(this,
R.raw.mainplaybackground);
 mediaPlayer.setLooping(true);
 if(music.mute==true) {
 mediaPlayer.start();
 so.setVisibility(View.INVISIBLE);
 }else
 so.setVisibility(View.VISIBLE);Bundle bundle=getIntent().getExtras();
 String l=bundle.getString("level");
 LEVEL=Integer.parseInt(l);
 level=(TextView)findViewById(R.id.level);
 play=(ImageView)findViewById(R.id.play);
 LEVEL=LEVEL+1;
 level.setText("LEVEL "+LEVEL);
 play.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View view) {
 finish();
 Intent intent=new
Intent(levelup.this,waiting.class);
 startActivity(intent);
 }
 });
 ImageView sound=(ImageView)findViewById(R.id.ivsound);
 sound.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View view) {
 if(music.mute==true){
 music.mute=false;
 mediaPlayer.pause();
 so.setVisibility(View.VISIBLE);
 }else {
 so.setVisibility(View.INVISIBLE);
music.mute=true;
mediaPlayer.start();
 }
 }
 });
 }
 @Override
 protected void onPause() {
 mediaPlayer.pause();
 super.onPause();
 }
 @Override
 protected void onResume() {
 if(music.mute==true) {
 mediaPlayer.start();
 so.setVisibility(View.INVISIBLE);
 }else
 so.setVisibility(View.VISIBLE);
 super.onResume();
 }
 @Override
 protected void onDestroy() {
 mediaPlayer.pause();
 super.onDestroy();
 }
}
