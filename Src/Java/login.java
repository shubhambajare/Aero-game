package com.example.clash.aero_game;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class login extends AppCompatActivity {
 EditText name;
 TextView save;
 MediaPlayer mediaPlayer;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_login);
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
 mediaPlayer = MediaPlayer.create(this,
R.raw.mainplaybackground);
 mediaPlayer.setLooping(true);
 if(music.mute==true) {
 mediaPlayer.start();
 }
 name=(EditText)findViewById(R.id.username);
 save=(TextView)findViewById(R.id.save);
 save.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View view) {
 String uname=name.getText().toString();
if(uname.matches("")){
 name.setError("Enter valid name");
 }
 else{SharedPreferences
sharedPreferences=getSharedPreferences("score",
Context.MODE_PRIVATE);
 SharedPreferences.Editor
editor=sharedPreferences.edit();
 editor.putString("username",uname);
 editor.apply();
 finish();
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
 }
 super.onResume();
 }
 @Override
 protected void onDestroy() {
 mediaPlayer.pause();
 super.onDestroy();
 }
 @Override
 public void onBackPressed() {
 }
}
