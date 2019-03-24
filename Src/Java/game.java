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
public void onTick(long l) {
 if (af == 1) {
 fire1.setVisibility(View.VISIBLE);
y1 = y1 + 6 + aspeed + 3 * level;
fire1.setY(y1);
if (y1 > Sheight) {
 y1 = 0;
af = 0;
fire1.setVisibility(View.INVISIBLE);
a11 = true;
SCORE+=1;
 }
if (y1 > (3 * Sheight / 4) && a11 == true)
{
 if (bf == 0) {
 bf = 1;
bspeed = random.nextInt(5);
 } else {
 cf = 1;
cspeed = random.nextInt(5);
 }
a11 = false;
 }
 }
 if (bf == 1) {
 fire2.setVisibility(View.VISIBLE);
y2 = y2 + 6 + bspeed + 3 * level;
 fire2.setY(y2);
 if (y2 > Sheight) {
 y2 = 0;
bf = 0;
fire2.setVisibility(View.INVISIBLE);
b11 = true;
SCORE+=1;
 }
if (y2 > (3 * Sheight / 4) && b11 == true)
{
 b11 = false;
if (af == 0) {
 af = 1;
aspeed = random.nextInt(5);
 } else {
 cf = 1;
cspeed = random.nextInt(5);
 }
 }
 }
 if (cf == 1) {
 fire3.setVisibility(View.VISIBLE);
y3 = y3 + 6 + cspeed + 3 * level;
fire3.setY(y3);
if (y3 > Sheight) {
 y3 = 0;cf = 0;
fire3.setVisibility(View.INVISIBLE);
c11 = true;
SCORE+=1;
 }
if (y3 > (3 * Sheight / 4) && c11 == true)
{
 if (bf == 0) {
 bf = 1;
 bspeed = random.nextInt(5);
 } else {
 af = 1;
aspeed = random.nextInt(5);
 }
c11 = false;
 }
 }
 if ((af == 0 && bf == 0) || (af == 0 && cf ==
0) || (cf == 0 && bf == 0)) {
 if (af == 0)
 af = 1;
 else if (bf == 0)
 bf = 1;
 else
 cf = 1;
 }
 if (decide == 2) {
 if (x < Swidth - 2 * lengthA)
 x =x+(6+2*(level+1));
 i.setX(x);
 } else if (decide == 1) {
 if (x > 5)
 x =x-(6+2*(level+1));
 i.setX(x);
 }
 if (((Math.abs(i.getX() - fire1.getX()) < 100
&& Math.abs(i.getY() - fire1.getY()) < 80)
 || (Math.abs(i.getX() - fire2.getX()) <
100 && Math.abs(i.getY() - fire2.getY()) < 80)
 || (Math.abs(i.getX() - fire3.getX()) <
100 && Math.abs(i.getY() - fire3.getY()) < 80))) {
 cancel();
 finish();
 Intent intent = new Intent(game.this,
gameover.class);
 intent.putExtra("s", "" + (int) SCORE );
startActivity(intent);
 }
 score.setText("SCORE: " + (int) SCORE);
 if ((int)SCORE%11==10) {
 SCORE+=1;
y1 = y2 = y3 = 0;
cf = af = 1;bf = 0;
a11 = b11 = true;
c11 = false;
level++;
tvlevel.setText("Level: " + (level + 1));
cancel();
fire1.setVisibility(View.INVISIBLE);
fire2.setVisibility(View.INVISIBLE);
fire3.setVisibility(View.INVISIBLE);
Intent i = new Intent(game.this,
levelup.class);
 i.putExtra("level", "" + level);
startActivity(i);
 }
 }
 @Override
 public void onFinish() {
 start();
 }
 };
 pause.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View view) {
 playpause();
 }
 });
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
 public boolean onTouchEvent(MotionEvent event) {
 int x1=(int)event.getX();
 switch (event.getAction()){
 case MotionEvent.ACTION_DOWN:
 if(x1>Swidth/2)
 decide=2;
 else
 decide=1;
 break;case MotionEvent.ACTION_MOVE:
 if(x1>Swidth/2)
 decide=2;
 else
 decide=1;
 break;
 case MotionEvent.ACTION_UP:
 decide =0;
 break;
 }
 return true;
 }
 @Override
 public void onBackPressed() {
 c.cancel();
 Intent intent=new Intent(game.this,gameover.class);
 intent.putExtra("s",""+((int)SCORE +(level*50)));
 startActivity(intent);
 }
 @Override
 protected void onPause() {
 mediaPlayer.pause();
 super.onPause();
 }
 @Override
 protected void onResume() {
 this.getWindow().getDecorView()
 .setSystemUiVisibility(
View.SYSTEM_UI_FLAG_FULLSCREEN |
View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
View.SYSTEM_UI_FLAG_LAYOUT_STABLE
 );
 c.start();
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
 void playpause(){
 if(pp==true) {
 pp=false;
 pause.setImageResource(R.drawable.p);
 c.cancel();}
 else {
 pp=true;
 pause.setImageResource(R.drawable.pause);
 c.start();
 }
}
}
