package com.example.clash.aero_game;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
public class about extends AppCompatActivity {
 MediaPlayer mediaPlayer;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_about);
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
 mediaPlayer = MediaPlayer.create(this,
R.raw.mainplaybackground);
 mediaPlayer.setLooping(true);
 if(music.mute==true) {
 mediaPlayer.start();
 }
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
 }super.onResume();
 }
 @Override
 protected void onDestroy() {
 mediaPlayer.pause();
 super.onDestroy();
 }
}
