package com.example.clash.aero_game;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class playOption extends AppCompatActivity {
 ImageButton play;
 ImageView p,info;
 MediaPlayer mediaPlayer;Boolean flag=true;
 TextView so;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_play_option);
 Boolean
c=getSharedPreferences("P",MODE_PRIVATE).getBoolean("check",tru
e);
 if(c){
 Intent intent=new
Intent(playOption.this,login.class);
 startActivity(intent);

getSharedPreferences("P",MODE_PRIVATE).edit().putBoolean("check
",false).commit();
 }
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
 so.setVisibility(View.VISIBLE);
 info=(ImageView)findViewById(R.id.info);
 p=(ImageView)findViewById(R.id.p);
 p.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View view) {
 Intent i=new
Intent(playOption.this,game.class);
 startActivity(i); }
 });
 final ImageView
sound=(ImageView)findViewById(R.id.ivsound);
 sound.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View view) {
 if(music.mute==true){
 music.mute=false;mediaPlayer.pause();
 so.setVisibility(View.VISIBLE);
 }else {
 music.mute=true;
so.setVisibility(View.INVISIBLE);
mediaPlayer.start();
 }
 }
 });
 info.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View view) {
 Intent intent=new
Intent(playOption.this,about.class);
 startActivity(intent);
 }
 });
 }
 @Override
 public void onBackPressed() {
 if (flag==false) {
 finish();
 moveTaskToBack(true);
 }
 else {
 flag=!flag;
 Toast.makeText(playOption.this,"Press again to
Exit",Toast.LENGTH_SHORT).show();
 }
 }
 @Override
 protected void onPause() {
 mediaPlayer.pause();
 super.onPause();
 }
 @Override
 protected void onResume() {

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
 if(music.mute==true) {
 mediaPlayer.start();
 so.setVisibility(View.INVISIBLE);
 }elseso.setVisibility(View.VISIBLE);
 super.onResume();
 }
 @Override
 protected void onDestroy() {
 mediaPlayer.pause();
 super.onDestroy();
 }
}
