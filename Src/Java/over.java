package com.example.clash.aero_game;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class gameover extends AppCompatActivity {
 TextView t,result,high;
 MediaPlayer mediaPlayer;
 ImageView p;
 int highscore=0,currentscore=0;
 String s,username;
 TextView so;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_gameover);
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
 Bundle bundle=getIntent().getExtras();
 s=bundle.getString("s");
 currentscore=Integer.parseInt(s);
 get();
 so=(TextView)findViewById(R.id.so);
 mediaPlayer=
MediaPlayer.create(this,R.raw.mainplaybackground);mediaPlayer.setLooping(true);
 if(music.mute==true) {
 mediaPlayer.start();
 so.setVisibility(View.INVISIBLE);
 }else
 so.setVisibility(View.VISIBLE);
 result=(TextView)findViewById(R.id.result);
 high=(TextView)findViewById(R.id.high);
 p=(ImageView)findViewById(R.id.p) ;
 t=(TextView)findViewById(R.id.textView);
 t.setTextColor(Color.WHITE);
 if(currentscore>highscore){
 OkHttpClient client = new OkHttpClient();
 String url =
"http://trskncoe.000webhostapp.com/writescore.php?data="+userna
me+" "+currentscore;
 final Request request = new Request.Builder()
 .url(url)
.build();
 client.newCall(request).enqueue(new Callback() {
 @Override
 public void onFailure(Call call, IOException e)
{
 e.printStackTrace();
 }
 @Override
 public void onResponse(Call call, Response
response) throws IOException {
 if (response.isSuccessful()) {
 final String myResponce =
response.body().string();
 gameover.this.runOnUiThread(new
Runnable() {
 @Override
public void run() {
}
 });
 }
 }
 });
 highscore=currentscore;
 set();
 result.setText("HIGH SCORE");
 }
 else result.setText("GAME OVER");
 high.setText("HIGH SCORE: "+highscore);
 t.setText(s);
 p.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View view) {
 Intent i=new Intent(gameover.this,game.class);
 startActivity(i);
 }});
 ImageView sound=(ImageView)findViewById(R.id.ivsound);
 sound.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View view) {
 if(music.mute==true){
 music.mute=false;
mediaPlayer.pause();
so.setVisibility(View.VISIBLE);
 }else {
 music.mute=true;
mediaPlayer.start();
so.setVisibility(View.INVISIBLE);
 }
 }
 });
 }
 @Override
 public void onBackPressed() {
 Intent i=new Intent(gameover.this,playOption.class);
 startActivity(i);
 }
 void get(){
 SharedPreferences
sharedPreferences=getSharedPreferences("score",
Context.MODE_PRIVATE);
 String
temp=sharedPreferences.getString("highscore","");
 username=sharedPreferences.getString("username","");
 if(temp.matches(""))
 highscore=0;
 else
 highscore=Integer.parseInt(temp);
 }
 void set(){
 SharedPreferences
sharedPreferences=getSharedPreferences("score",
Context.MODE_PRIVATE);
 SharedPreferences.Editor
editor=sharedPreferences.edit();
 editor.putString("highscore",s);
 editor.apply();
 }
 @Override
 protected void onPause() {
 mediaPlayer.pause();
 super.onPause();
 }
 @Override
 protected void onResume() {
 if(music.mute==true) {
 mediaPlayer.start();so.setVisibility(View.INVISIBLE);
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
