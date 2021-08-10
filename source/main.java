import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

import java.awt.*;

public class main extends PApplet {

TopMenueBar topBar = new TopMenueBar();
Game game = new Game();
Menue menue = new Menue();
Login login = new Login();
IGMenue iGM = new IGMenue();
Settings set = new Settings();
DeathScreen ds = new DeathScreen();
HighscoreScreen hs = new HighscoreScreen();
AccountMenue am = new AccountMenue();
ChangePwScreen cp = new ChangePwScreen();
DeleteAcScreen da = new DeleteAcScreen();
CustomKeys ck = new CustomKeys();
WarningScreen ws = new WarningScreen();
int mode, codeerror, graphix = 0, windowX, windowY;
float img1Shift=0, img2Shift=235, img3Shift=470, img4Shift=-235;
PImage screenShot, bg, bgMov1, bgMov2, bgMov3, bgMov4, greenInvader;
ArrayList <Integer> modeHistory = new ArrayList <Integer> ();

public void setup()
{
  frameRate(30);

  windowX = displayWidth/2-350;
  windowY = displayHeight/2-350;

  surface.setSize(700,720);
  surface.setLocation(windowX,windowY);
  surface.setTitle("Space Invaders");
  surface.setIcon(loadImage("InvaderGreen.png"));
  //surface.setUndecorated();

  bg = loadImage("bg2.png");
  bgMov1 = loadImage("bgMov1.png");
  bgMov2 = loadImage("bgMov2.png");
  bgMov3 = loadImage("bgMov3.png");
  bgMov4 = loadImage("bgMov4.png");

  greenInvader = loadImage("InvaderGreen.png");

  mode = 0;
  topBar.setup();
  game.setup();
  menue.setup();
  login.setup();
  iGM.setup();
  set.setup();
  ds.setup();
  hs.setup();
  am.setup();
  cp.setup();
  da.setup();
  ck.setup();
  ws.setup();
}

public void draw()
{
  background(0);

  switch(mode)
  {
    case 0: login.draw();      break; //Login-Fenster
    case 1: menue.draw();      break; //Main menue
    case 2: game.draw();       break; //Game
    case 3: iGM.draw();        break; //in game Menue
    case 4: set.draw();        break; //Einstellungen
    case 5: ds.draw();         break; //Deathscreen
    case 6: hs.draw();         break; //Highscore screen
    case 7: am.draw();         break; //Acount settings
    case 8: cp.draw();         break; //Change password screen
    case 9: da.draw();         break; //Delete account screen
    case 10: ck.draw();        break; //Custom keys screen
    case 11: ws.draw();        break; //Screen to war you before you leve a runing game
  }

  topBar.draw();
}

public void backgroundMove(float speed)
{
  if(graphix == 0)
  {
    image(bgMov1, 0, img1Shift);
    image(bgMov2, 0, img2Shift);
    image(bgMov3, 0, img3Shift);
    image(bgMov4, 0, img4Shift);

    img1Shift+=speed;
    if(img1Shift>=700)
    { img1Shift=-235; }

    img2Shift+=speed;
    if(img2Shift>=700)
    { img2Shift=-235; }

    img3Shift+=speed;
    if(img3Shift>=700)
    { img3Shift=-235; }

    img4Shift+=speed;
    if(img4Shift>=700)
    { img4Shift=-235; }
  }
  if(graphix != 2)
  {image(bg, 0, 20);}
}

public void displayHeadline(String Text, int size)
{
  fill(color(255,0,162));
  textAlign(CENTER,CENTER);
  textSize(size);
  text(Text,width/2,120);
}
public void displayHeadline(String Text, int size, float height)
{
  fill(color(255,0,162));
  textAlign(CENTER,CENTER);
  textSize(size);
  text(Text,width/2,height+20);
}

public void keyPressed() {
  switch(mode)
  {
    case 0: login.keyPressed();      break;
    case 1: menue.keyPressed();      break;
    case 2: game.keyPressed();       break;
    case 3: iGM.keyPressed();        break;
    case 4: set.keyPressed();        break;
    case 5: ds.keyPressed();         break;
    case 6: hs.keyPressed();         break;
    case 7: am.keyPressed();         break;
    case 8: cp.keyPressed();         break;
    case 9: da.keyPressed();         break;
    case 10: ck.keyPressed();        break;
    case 11: ws.keyPressed();        break;
  }
}

public void keyReleased() {
  switch(mode)
  {
    case 0: login.keyReleased();      break;
    case 1: menue.keyReleased();      break;
    case 2: game.keyReleased();       break;
    case 3: iGM.keyReleased();        break;
    case 4: set.keyReleased();        break;
    case 5: ds.keyReleased();         break;
    case 6: hs.keyReleased();         break;
    case 7: am.keyReleased();         break;
    case 8: cp.keyReleased();         break;
    case 9: da.keyReleased();         break;
    case 10: ck.keyReleased();        break;
    case 11: ws.keyReleased();        break;
  }
}

public void mousePressed()
{
  if(mouseY <= topBar.getH())
  {
    topBar.mousePressed();
  }

  switch(mode)
  {
    case 0: login.mousePressed();      break;
    case 1: menue.mousePressed();      break;
    case 2: game.mousePressed();       break;
    case 3: iGM.mousePressed();        break;
    case 4: set.mousePressed();        break;
    case 5: ds.mousePressed();         break;
    case 6: hs.mousePressed();         break;
    case 7: am.mousePressed();         break;
    case 8: cp.mousePressed();         break;
    case 9: da.mousePressed();         break;
    case 10: ck.mousePressed();        break;
    case 11: ws.mousePressed();        break;
  }
}

public void mouseReleased()
{
  topBar.mouseReleased();

  switch(mode)
  {
    case 0: login.mouseReleased();      break;
    case 1: menue.mouseReleased();      break;
    case 2: game.mouseReleased();       break;
    case 3: iGM.mouseReleased();        break;
    case 4: set.mouseReleased();        break;
    case 5: ds.mouseReleased();         break;
    case 6: hs.mouseReleased();         break;
    case 7: am.mouseReleased();         break;
    case 8: cp.mouseReleased();         break;
    case 9: da.mouseReleased();         break;
    case 10: ck.mouseReleased();        break;
    case 11: ws.mouseReleased();        break;
  }
}


interface Mode
{
  public void setup();
  public void draw();
  public void keyPressed();
  public void keyReleased();
  public void mousePressed();
  public void mouseReleased();
}


class TopMenueBar
{
  ImageButton quitButton, backButton, menueButton;
  int h = 20;
  boolean mouseWasPressed;
  int difX, difY;

  public void setup()
  {
    quitButton = new ImageButton(loadImage("data/quitButton.png"),680,0,this.h,this.h,true);
    backButton = new ImageButton(loadImage("data/backButton.png"),0,0,this.h,this.h,false);
    menueButton = new ImageButton(loadImage("data/menueButton.png"),this.h,0,this.h,this.h,false);
  }

  public void draw()
  {
    if(mousePressed && mouseWasPressed)
    {
      PointerInfo a = MouseInfo.getPointerInfo();
      Point b = a.getLocation();
      windowX = (int) b.getX();
      windowY = (int) b.getY();

      surface.setLocation(windowX-difX,windowY-difY);
    }

    fill(250,0,162);
    noStroke();
    rect(0,0,700,20);

    quitButton.draw();
    if(mode != 0) //if you are in login you could dodge the login with the menue/back button
    {
      if(modeHistory.size() > 0)
      { backButton.draw(); }

      menueButton.draw();
    }
  }

  public void mousePressed()
  {
    difX = mouseX;
    difY = mouseY;
    this.mouseWasPressed = true;

    if(mode == 2) //if you are in game you dont just want to leave because you cold loose your highscore
    {
      if((backButton.mouseIsOver() && modeHistory.size() > 0) || menueButton.mouseIsOver())
      {
        ws.quitAfter = false;
        screenShot = get();
        mode = 11;
      }
      else if(quitButton.mouseIsOver())
      {
        ws.quitAfter = true;
        screenShot = get();
        mode = 11;
      }
    }
    else if(quitButton.mouseIsOver())
    { exit(); }
    else if(backButton.mouseIsOver() && mode != 0 && modeHistory.size() > 0)
    {
      mode = modeHistory.get(modeHistory.size()-1);
      modeHistory.remove(modeHistory.size()-1);
    }
    else if(menueButton.mouseIsOver() && mode != 0 && mode != 11)
    {
      modeHistory.add(mode);
      mode = 1;
    }
  }

  public int getH()
  { return this.h; }

  public void mouseReleased()
  { this.mouseWasPressed = false; }
}


class WarningScreen implements Mode
{
  boolean quitAfter;

  Button passButton, saveScoreButton, backButton;

  public void setup()
  {
    passButton = new Button("Don't save",100,400,500,80);
    saveScoreButton = new Button("Save",100,495,500,80);
    backButton = new Button("Cancel",100,590,500,80);
  }

  public void draw()
  {
    background(screenShot);
    fill(255,0,162,50);
    rect(0,0,width,height);

    fill(255);
    textAlign(CENTER);
    textSize(50);
    text("Your current score",350,200);
    text("will be lost!",350,300);

    passButton.draw();
    saveScoreButton.draw();
    backButton.draw();
  }

  public void mousePressed()
  {
    if(passButton.mouseIsOver())
    {
      modeHistory.clear();
      if(this.quitAfter)
      { exit(); }
      else
      { mode = 1; }
    }
    else if(saveScoreButton.mouseIsOver())
    {
      modeHistory.clear();
      SQL.createRun(game.player.score);
      if(this.quitAfter)
      { exit(); }
      else
      { mode = 1; }
    }
    else if(backButton.mouseIsOver())
    { mode = 2; }
  }

  public void keyPressed(){}
  public void keyReleased(){}
  public void mouseReleased(){}
}


class Animation
{
  int x,y,index,lifetime,maxlifetime;
  PImage[] pictures; //Aktuelles Bild
  boolean dead;

  Animation(int x, int y, int lifetime , PImage[] pictures)
  {
    this.x = x;
    this.y = y;
    this.maxlifetime = lifetime;
    this.pictures = pictures;
    this.index = 0;
    this.lifetime = 0;
    this.dead = false;
  }

  public void draw()
  {
    if(this.lifetime >= this.maxlifetime)
    { this.dead = true; }
    else if((float)(this.index+1)/this.pictures.length < (float)this.lifetime/this.maxlifetime)
    { changePicture(); }

    image(pictures[this.index],this.x,this.y);
    this.lifetime++;
  }


  public void changePicture()
  { this.index++; }

  public boolean isDead()
  { return this.dead; }
}


class Button
{
  String label;
  float x, y, w, h, textSize;
  int borderwith = 12;
  boolean mouseOn, state;

  Button(String labelB, float xpos, float ypos, float widthB, float heightB)
  {
    label = labelB;
    x = xpos;
    y = ypos;
    w = widthB;
    h = heightB;
    this.textSize = h/2;
  }

  public void draw() {
    this.hover();

    noStroke();
    if(this.mouseOn || this.state)
    { fill(color(255,0,162,150)); }
    else
    { fill(color(255,0,162,50)); }

    rect(x,y,w,h,10);

    noFill();
    strokeWeight(borderwith);
    stroke(color(255,0,162));
    rect(x,y,w,h,10);

    textAlign(CENTER, CENTER);
    fill(255);
    textSize(this.textSize);
    text(label, x + (w / 2), y + (h / 2)-(h/16));
  }

  public boolean mouseIsOver()
  { return (mouseX > x && mouseX < (x + w) && mouseY > y && mouseY < (y + h)); }

  public void hover()
  {
    if (this.mouseIsOver())
    { this.mouseOn = true; }
    else
    { this.mouseOn = false; }
  }

  public float getX()
  { return this.x; }

  public float getY()
  { return this.y; }

  public void setTextSize(float textSize)
  { this.textSize = textSize; }

  public void changeLabel(String label)
  { this.label = label; }

  public void mark(boolean state)
  { this.state = state; }

  public boolean getState()
  { return this.state; }
}


class ImageButton
{
  PImage img;
  boolean isRed;
  float x, y, w, h;
  boolean mouseOn, state;

  ImageButton(PImage img, float x, float y, float w, float h, boolean isRed)
  {
    this.img = img;
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.isRed = isRed;
  }

  public void draw() {
    this.hover();

    noStroke();
    if(this.mouseOn || this.state)
    {
      if(this.isRed)
      { fill(233,37,57); }
      else
      { fill(255,112,194); }
    }
    else
    { noFill(); }

    rect(x,y,w,h);

    image(this.img,x,y,w,h);
  }

  public boolean mouseIsOver()
  { return (mouseX > x && mouseX < (x + w) && mouseY > y && mouseY < (y + h)); }

  public void hover()
  {
    if (this.mouseIsOver())
    { this.mouseOn = true; }
    else
    { this.mouseOn = false; }
  }

  public float getX()
  { return this.x; }

  public float getY()
  { return this.y; }

  public void mark(boolean state)
  { this.state = state; }

  public boolean getState()
  { return this.state; }
}


class Login
{
  TextBox inputUsername,inputPassword;
  Button loginButton,createAccButton,clearButton;
  float fade = 255;

  public void setup()
  {
    inputUsername = new TextBox("Username",100,300,500,60,false);
    inputPassword = new TextBox("Password",100,400,500,60,false);
    loginButton = new Button("Login",400,500,200,60);
    createAccButton = new Button("Create Account",100,500,250,60);

    clearButton = new Button("Clear",520,240,80,40);
    clearButton.borderwith = 7;
  }

  public void draw()
  {
    backgroundMove(1);

    inputUsername.draw();
    inputPassword.draw();

    if(inputUsername.Text != "" || inputPassword.Text != "")
    { clearButton.draw(); }

    loginButton.draw();
    createAccButton.draw();

    displayHeadline("Login", 106 , 125);

    switch (codeerror)
    {
      case 1:
        fill(255,0,0,this.fade);
        textAlign(LEFT,UP);
        textSize(16);
        text("Login Failed.", 100 , 585);
        break;
      case 2:
        fill(255,0,0,this.fade);
        textAlign(LEFT,UP);
        textSize(16);
        text("Username Already Taken.", 100 , 585);
        break;
      case 3:
        fill(255,0,0,this.fade);
        textAlign(LEFT,UP);
        textSize(16);
        text("Username and Password need at least 3 characters each.", 100 , 585);
        break;
      case 4:
        fill(255,0,0,this.fade);
        textAlign(LEFT,UP);
        textSize(16);
        text("Unknown error while creating a session.", 100 , 585);
        break;
    }
    if(this.fade >= 0)
    { this.fade -= 2; }
  }

  public void keyPressed()
  {
    inputUsername.keyPressed(key,(int)keyCode);
    inputPassword.keyPressed(key,(int)keyCode);
  }

  public void mousePressed()
  {
    inputUsername.mousePressed();
    inputPassword.mousePressed();

    if(loginButton.mouseIsOver())
    {
      submit(inputUsername.Text,inputPassword.Text);
      inputPassword.clearText();
    }
    else if(createAccButton.mouseIsOver())
    {
      createAccount(inputUsername.Text,inputPassword.Text);
      inputPassword.clearText();
    }
    else if(clearButton.mouseIsOver())
    {
      inputUsername.clearText();
      inputPassword.clearText();
    }
  }

  public void submit(String username, String password)
  {
    if(username.length() == 0 || password.length() <= 2)
    {
      this.fade = 255;
      codeerror = 1;
    }
    else
    {
      if(SQL.submit(username, password))
      {
        if(SQL.createSession(CurrentData.getUsername()))
        {
          ck.updateKeys();
          modeHistory.add(mode);
          mode = 1;
        }
        else
        {
          this.fade = 255;
          codeerror = 4;
        }
      }
      else
      {
        this.fade = 255;
        codeerror = 1;
      }
    }
  }

  public void createAccount(String username, String password)
  {
    if(username.length() <= 2 || password.length() <= 2)
    {
      this.fade = 255;
      codeerror = 3;
    }
    else
    {
      if(SQL.createAccount(username, password))
      {
        if(SQL.createSession(CurrentData.getUsername()))
        {
          modeHistory.add(mode);
          mode = 1;
        }
        else
        {
          this.fade = 255;
          codeerror = 4;
        }
      }
      else
      {
        this.fade = 255;
        codeerror=2;
      }
    }
  }

  public void keyReleased(){}
  public void mouseReleased(){}
}


public class TextBox
{
  public int x, y, h, w, textLim = 16,strokeWeight;
  public int bg = color(255,0,162,50), bgselect = color(255,0,162,150), col = color(255,0,162);

  public String Text = "", spaceHolder = "";

  public boolean selected = false, singleLetter = false;

   public int index=0; //for KeyChoose

   TextBox(String spaceHolder, int x, int y, int w, int h, boolean single)
   {
     this.spaceHolder = spaceHolder;
     this.x = x;
     this.y = y;
     this.w = w;
     this.h = h;
     this.singleLetter = single;
     this.strokeWeight = (int)h/5;
   }

   public void draw()
   {
      if (selected)
      { fill(bgselect); }
      else
      { fill(bg); }

      strokeWeight(strokeWeight);
      stroke(col);
      rect(x-5,y-5,w+10,h+10,20);

      noFill();
      noStroke();
      rect(x,y,w,h,10);

      textAlign(LEFT,CENTER);
      textSize(h/2);
      if(this.Text == "")
      {
        fill(col);
        text(spaceHolder, x+10, y+(h/2)-(h/16));
      }
      else
      {
        fill(255);
        if(this.singleLetter)
        { text(Text, x+w/2-h/8, y+(h/2)-(h/16)); }
        else
        { text(Text, x+10, y+(h/2)-(h/16)); }
      }
   }

   public void keyPressed(char KEY, int KEYCODE)
   {
      if(selected)
      {
        if(this.singleLetter)
        { this.removeText(); }
         if(KEYCODE == (int)BACKSPACE)
         { removeText(); }
         else if(KEYCODE == 37)
         { addText('<'); }
         else if(KEYCODE == 38)
         { addText('^'); }
         else if(KEYCODE == 39)
         { addText('>'); }
         else
         {
           boolean isKeyCapitalLetter = (KEY >= 'A' && KEY <= 'Z'); // CHECK IF THE KEY IS A LETTER OR A NUMBER
           boolean isKeySmallLetter = (KEY >= 'a' && KEY <= 'z');
           boolean isKeyNumber = (KEY >= '0' && KEY <= '9');

           if (isKeyCapitalLetter || isKeySmallLetter || isKeyNumber)
           { addText(KEY); }
         }

      	 if(this.singleLetter)
      	 {
           CurrentData.changeKey(this.index,this.Text);
           SQL.setKeys();
      	 }
      }
   }

   private void addText(char text)
   {
      if (Text.length() < textLim) //IF THE TEXT WIDHT IS IN BOUNDARIES OF THE TEXTBOX
      { this.Text += text; }
   }

   private void removeText()
   {
      if (Text.length() >= 1)
      { Text = Text.substring(0, Text.length() - 1); }
   }

   public void clearText()
   { this.Text = ""; }

   public void mousePressed()
   {
      if (mouseX >= this.x && mouseX <= this.x+this.w && mouseY >= this.y && mouseY <= this.y+this.h)
      { this.selected = true; }
      else
      { this.selected = false; }
   }
}


class ScoreTable
{
  float x=100, y=200, w=500;
  boolean state = true;
  String [][] content = new String[10][2];

  ScoreTable(String [][] Array)
  { this.content = Array; }

  void draw()
  {
     if (state)
     {
       stroke(255);
       strokeWeight(10);
       line(this.x,this.y+15,this.x+this.w,this.y+15);

       fill(255);
       textSize(30);
       textAlign(LEFT);
       text("Username",this.x,this.y);
       textAlign(RIGHT);
       text("Score",this.x+this.w,this.y);

       for(int i=0; i<content.length; i++)
       {
         if(content[i][0] == null)
         {
           content[i][0] = "-----";
           content[i][1] = "-----";
         }
         textAlign(LEFT);
         text(content[i][0],this.x,this.y+60+i*40);
         textAlign(RIGHT);
         text(content[i][1],this.x+this.w,this.y+60+i*40);
       }
     }
  }

  public void show(boolean state)
  { this.state = state; }
}


class Menue implements Mode
{
  Button playButton,highscoreButton,settingsButton;

  public void setup()
  {
    playButton = new Button("Play",100,190,500,80);
    highscoreButton = new Button("Highscore",100,310,500,80);
    settingsButton = new Button("Settings",100,430,500,80);
  }

  public void draw()
  {
    backgroundMove(1);

    displayHeadline("Menue", 78);

    playButton.draw();
    highscoreButton.draw();
    settingsButton.draw();
  }

  public void mousePressed()
  {
    if(playButton.mouseIsOver())
    {
      game.restart();
      modeHistory.add(mode);
      mode = 2;
    }
    else if(highscoreButton.mouseIsOver())
    {
      hs.checkHighscoreTables();
      modeHistory.add(mode);
      mode = 6;
    }
    else if(settingsButton.mouseIsOver())
    {
      modeHistory.add(mode);
      mode = 4;
    }
  }

  public void keyPressed(){}
  public void keyReleased(){}
  public void mouseReleased(){}
}


class AccountMenue implements Mode
{
  Button signOutButton,changePwButton,deleteButton;

  public void setup()
  {

    changePwButton = new Button("Change Password",100,190,500,80);
    deleteButton = new Button("Delete Account",100,310,500,80);
    signOutButton = new Button("Sign out",100,430,500,80);
  }

  public void draw()
  {
    backgroundMove(1);

    displayHeadline("My account", 78);

    signOutButton.draw();
    changePwButton.draw();
    deleteButton.draw();
  }

  public void mousePressed()
  {
    if(signOutButton.mouseIsOver())
    {
      modeHistory.add(mode);
      mode = 0;
    }
    else if(changePwButton.mouseIsOver())
    {
      modeHistory.add(mode);
      mode = 8;
    }
    else if(deleteButton.mouseIsOver())
    {
      modeHistory.add(mode);
      mode = 9;
    }
  }

  public void keyPressed(){}
  public void keyReleased(){}
  public void mouseReleased(){}
}


class DeleteAcScreen implements Mode
{
  Button deleteButton, clearButton;
  TextBox password;
  int fade = 255, codeerror = 0;

  public void setup()
  {
    password = new TextBox("Enter password", 100,250,500,60,false);
    deleteButton = new Button("Delete",225,350,250,80);

    clearButton = new Button("Clear",520,190,80,40);
    clearButton.borderwith = 7;
  }

  public void draw()
  {
    backgroundMove(1);

    displayHeadline("Delete account", 65);

    password.draw();
    deleteButton.draw();
    if(password.Text != "")
    { clearButton.draw(); }

    switch (codeerror)
    {
      case 1:
        fill(255,0,0,this.fade);
        textAlign(LEFT,UP);
        textSize(16);
        text("Invalid password.", 100 , 585);
        break;
    }
    if(this.fade >= 0)
    { this.fade -= 2; }
  }

  public void keyPressed()
  {
    password.keyPressed(key,(int)keyCode);
  }

  public void mousePressed()
  {
    password.mousePressed();

    if(deleteButton.mouseIsOver())
    { deleteAccount(password.Text); }
    else if(clearButton.mouseIsOver())
    { password.clearText(); }
  }

  public void deleteAccount(String password)
  {
    if(SQL.deleteAccount(password))
    {
      modeHistory.add(mode);
      mode = 0;
      this.password.clearText();
    }
    else
    { this.fade = 255; codeerror = 1; }
  }

  public void keyReleased(){}
  public void mouseReleased(){}
}


class ChangePwScreen implements Mode
{
  Button aplyButton, clearButton;
  TextBox oldPassword, newPassword;
  int fade = 255, codeerror = 0;

  public void setup()
  {
    oldPassword = new TextBox("Old password", 100,250,500,60,false);
    newPassword = new TextBox("New Password", 100,350,500,60,false);
    aplyButton = new Button("Apply",250,450,200,60);

    clearButton = new Button("Clear",520,190,80,40);

    clearButton.borderwith = 7;
  }

  public void draw()
  {
    backgroundMove(1);

    displayHeadline("Change password", 65);

    oldPassword.draw();
    newPassword.draw();
    aplyButton.draw();
    if(oldPassword.Text != "" || newPassword.Text != "")
    { clearButton.draw(); }

    switch (codeerror)
    {
      case 1:
        fill(255,0,0,this.fade);
        textAlign(LEFT,UP);
        textSize(16);
        text("The new password needs at least 3 characters.", 100 , 585);
        break;
      case 2:
        fill(255,0,0,this.fade);
        textAlign(LEFT,UP);
        textSize(16);
        text("Error in data base.", 100 , 585);
        break;
    }
    if(this.fade >= 0)
    { this.fade -= 2; }
  }

  public void keyPressed()
  {
    oldPassword.keyPressed(key,(int)keyCode);
    newPassword.keyPressed(key,(int)keyCode);
  }

  public void mousePressed()
  {
    oldPassword.mousePressed();
    newPassword.mousePressed();

    if(aplyButton.mouseIsOver())
    { changePassword(oldPassword.Text, newPassword.Text); }
    else if(clearButton.mouseIsOver())
    {
      oldPassword.clearText();
      newPassword.clearText();
    }
  }

  public void changePassword(String oldPw, String newPw)
  {
    if(newPw.length() >= 3)
    {
      if(SQL.setPassword(oldPw, newPw))
      {
        modeHistory.add(mode);
        mode = 7;
        oldPassword.clearText(); newPassword.clearText();
      }
      else
      { this.fade = 255; codeerror = 2; }
    }
    else
    { this.fade = 255; codeerror = 1; }
  }

  public void keyReleased(){}
  public void mouseReleased(){}
}


class HighscoreScreen implements Mode
{
  int drawHighscores = 1; //0 == global Highscores, 1 == personal Highscores
  Button globalButton, personalButton;
  ScoreTable globalTable, personalTable;

  public void setup()
  {
    globalButton = new Button("All Highscores",360,50,230,80);
    personalButton = new Button("My Highscores",100,50,230,80); //leads to the personal Highscores insteat of the global Highscores or back

    personalButton.mark(true);
    globalButton.borderwith = 12;
    personalButton.borderwith = 12;
    globalButton.setTextSize(30);
    personalButton.setTextSize(30);
  }

  public void draw()
  {
    backgroundMove(1);

    globalButton.draw();
    personalButton.draw();
    globalTable.draw();
    personalTable.draw();
  }

  public void checkHighscoreTables()
  {
    globalTable   = new ScoreTable(SQL.getGlobalTable());
    personalTable = new ScoreTable(SQL.getPersonalTable(CurrentData.getUsername()));
    globalButton.mark(false);
    personalButton.mark(true);
    globalTable.show(false);
    personalTable.show(true);
  }

  public void mousePressed()
  {
    if(personalButton.mouseIsOver())
    {
      this.drawHighscores = 1;
      globalButton.mark(false);
      personalButton.mark(true);
      globalTable.show(false);
      personalTable.show(true);
    }
    else if(globalButton.mouseIsOver())
    {
      this.drawHighscores = 0;
      globalButton.mark(true);
      personalButton.mark(false);
      globalTable.show(true);
      personalTable.show(false);
    }
  }

  public void keyPressed(){}
  public void keyReleased(){}
  public void mouseReleased(){}
}


class Settings implements Mode
{
  int lastGraphix;
  Button graphicsButton, csdmKeysButton, accountButton;

  public void setup()
  {
    graphicsButton = new Button("graphics: High",100,190,500,80);
    csdmKeysButton = new Button("Custom keybinds",100,310,500,80);
    accountButton = new Button("My Account",100,430,500,80);
  }

  public void draw()
  {
    backgroundMove(1);

    displayHeadline("Settings", 78);

    graphicsButton.draw();
    csdmKeysButton.draw();
    accountButton.draw();
  }

  public void mousePressed()
  {
    if(graphicsButton.mouseIsOver())
    {
      if(graphix == 0 || graphix == 2)
      {
        this.lastGraphix = graphix;
        graphix = 1;
        graphicsButton.changeLabel("graphics: Middle");
      }
      else if(graphix == 1 && this.lastGraphix == 0)
      {
        graphix = 2;
        graphicsButton.changeLabel("graphics: Low");
      }
      else if(graphix == 1 && this.lastGraphix == 2)
      {
        graphix = 0;
        graphicsButton.changeLabel("graphics: High");
      }
    }
    else if(csdmKeysButton.mouseIsOver())
    {
      modeHistory.add(mode);
      mode = 10;
    }
    else if(accountButton.mouseIsOver())
    {
      modeHistory.add(mode);
      mode = 7;
    }
  }

  public void keyPressed(){}
  public void keyReleased(){}
  public void mouseReleased(){}
}


class CustomKeys implements Mode
{
  Button aplyButton;
  TextBox shootKey, rightKey, leftKey;

  public void setup()
  {
    aplyButton = new Button("Apply",280,465,140,80);

    leftKey  = new TextBox("<",515,195,80,46,true);
    rightKey = new TextBox(">",515,285,80,46,true);
    shootKey = new TextBox("^",515,375,80,46,true);

    leftKey.index = 0;
    rightKey.index = 1;
    shootKey.index = 2;

    updateKeys();

    rightKey.textLim = 1;
    leftKey.textLim = 1;
    shootKey.textLim = 1;

    rightKey.strokeWeight = 10;
    leftKey.strokeWeight = 10;
    shootKey.strokeWeight = 10;
  }

  public void draw()
  {
    backgroundMove(1);

    displayHeadline("Custom Keys", 70);

    aplyButton.draw();

    rightKey.draw();
    leftKey.draw();
    shootKey.draw();

    fill(255); //Drawing the text
    textSize(28);
    textAlign(LEFT,CENTER);
    text("Move left",110,215);
    text("Move right",110,305);
    text("Shoot",110,395);

    noFill();
    strokeWeight(10);
    stroke(color(255,0,162));
    rect(100,190,500,56,10);
    rect(100,280,500,56,10);
    rect(100,370,500,56,10);
  }

  public void mousePressed()
  {
    rightKey.mousePressed();
    leftKey.mousePressed();
    shootKey.mousePressed();

    //if(aplyButton.mouseIsOver())
  //{ /*todo*/ }
  }

  public void keyPressed()
  {
    rightKey.keyPressed(key,(int)keyCode);
    leftKey.keyPressed(key,(int)keyCode);
    shootKey.keyPressed(key,(int)keyCode);
  }

  public void keyReleased(){}
  public void mouseReleased(){}

  public void updateKeys()
  {
    leftKey.removeText();
    rightKey.removeText();
    shootKey.removeText();
    leftKey.addText(CurrentData.getKeys()[0]);
    rightKey.addText(CurrentData.getKeys()[1]);
    shootKey.addText(CurrentData.getKeys()[2]);
  }
}


class Game implements Mode
{
  ArrayList<Invader> allInvaders;
  ArrayList<Shot> invaderShots;
  ArrayList<Animation> animations;
  PImage[] deathAnimation, crashAnimationP, crashAnimationG;
  PImage heart;
  PImage shuttleStandart, friendlyShipRight, friendlyShipLeft, blueInvader1, blueInvader2, redInvader, greenInvader, yellowInvader, yellowRedInvader, purpleInvader;
  PImage death1, death2, death3, crashG, crashP;
  int spawnCooldown;
  float spawnRate, bgMoveSpeed;
  boolean[] keys = new boolean[4];
  Button bu;
  Invader inv;
  Player player;
  Shot s, ss;
  Animation a;

  public void setup()
  {
    bu = new Button("||", width-40, 30, 30, 30);
    bu.borderwith = 5;

    allInvaders = new ArrayList <Invader>();
    invaderShots = new ArrayList <Shot>();
    animations = new ArrayList <Animation>();

    redInvader = loadImage("Invader.png");
    greenInvader = loadImage("InvaderGreen.png");
    yellowInvader = loadImage("invaderYellow.png");
    blueInvader1 = loadImage("invaderBlue1.png");
    blueInvader2 = loadImage("invaderBlue2.png");
    yellowRedInvader = loadImage("invaderRed.png");
    purpleInvader = loadImage("purpleInvader.png");
    friendlyShipRight = loadImage("friendlyRight.png");
    friendlyShipLeft = loadImage("friendlyLeft.png");
    shuttleStandart = loadImage("shuttleStandart.png");
    death1 = loadImage("death1.png");
    death2 = loadImage("death2.png");
    death3 = loadImage("death3.png");
    crashG = loadImage("collideShotsGreen.png");
    crashP = loadImage("collideShotsPurple.png");

    deathAnimation = new PImage[3]; //when an invader dies
    deathAnimation[0]= death1;
    deathAnimation[1]= death2;
    deathAnimation[2]= death3;

    crashAnimationG = new PImage[1]; //when a player shot and a green invader shot colide
    crashAnimationG[0] = crashG;

    crashAnimationP = new PImage[1]; //when a player shot and a purple invader shot colide
    crashAnimationP[0] = crashP;

    restart();
  }

  public void restart()
  {
    bgMoveSpeed = 1;
    allInvaders.clear();
    invaderShots.clear();
    animations.clear();
    player = new Player(320, 650, 40, shuttleStandart);
    spawnCooldown = 0;
    spawnRate = 50;
    spawnEnemies(5);

    for (int i = 0; i< 4; i++)
    { keys[i] = false; }
  }

  public void draw()
  {
    backgroundMove(bgMoveSpeed);
    if(bgMoveSpeed < 6)
    {bgMoveSpeed *= 1.00009955;}

    if(spawnCooldown >= spawnRate)
    {
      spawnEnemies(1);
      spawnCooldown = 0;
    }
    spawnCooldown ++;
    if(spawnRate>22)
    {spawnRate *= 0.9999615;}

    player.draw(); //Player draw and playerShots draw
    for(int i = player.playerShots.size() -1; i >= 0; i--)
    {
      s = player.playerShots.get(i);

      for(int j = allInvaders.size() -1; j >= 0; j--)
      {
        inv = allInvaders.get(j);

        if(inv.touch(s))
        {
          inv.onDie();
          player.playerShots.remove(s);
        }
      }
      for(int j = invaderShots.size() -1; j >= 0; j--)
      {
        ss = invaderShots.get(j);

        if(s.y <= ss.y && s.y+s.h >= ss.y && s.x <= ss.x && s.x+s.w >= ss.x)
        {
          player.score++;
          invaderShots.remove(ss);
          player.playerShots.remove(s);
          if(ss.col == 0xffFF00FF)
          {animations.add(new Animation(ss.x-12,ss.y,8,crashAnimationP));}
          else
          {animations.add(new Animation(ss.x-12,ss.y,8,crashAnimationG));}
        }
      }

      s.draw();
      if(s.y <= (0-s.h))
      { player.playerShots.remove(s); }
    }

    //invaderShots draw
    for(int i = invaderShots.size() -1; i >= 0; i--)
    {
      s = invaderShots.get(i);

      if(player.touch(s))
      {
        player.looseLive(1);
        invaderShots.remove(s);
      }

      s.draw();
      if(s.y <= (0-s.h))
      { this.invaderShots.remove(s); }
    }

    for(int i = allInvaders.size() -1; i >= 0; i--)
    {
      inv = allInvaders.get(i);
      inv.draw();

      if(inv.isDead())
      {
        animations.add(new Animation(inv.getX(),inv.getY(),8,deathAnimation));
        allInvaders.remove(inv);
      }
    }

    //animations draw
    if(graphix == 0)
    {
      for(int i = animations.size() -1; i >= 0; i--)
      {
        a = animations.get(i);
        a.draw();
        if (a.isDead())
        { animations.remove(a); }
      }
    }

    bu.draw(); //pauseButton draw

    if(keyPressed) //KeyPressed handling
    {
      if(keys[0])
      { player.move(-5); }
      if(keys[1])
      { player.move(5); }
      if(keys[2])
      { player.shoot(); }
    }

    if(player.lives <= 0)
    {
      screenShot = get();
      SQL.createRun(player.score);
      modeHistory.add(mode);
      mode = 5;
    }
  }

  public void spawnEnemies(int anz)
  {
    for(int i = 0; i < anz; i++)
    {
      int xNew = 20+100*i;

      int r = PApplet.parseInt(random(100));
      if(r >= 0 && r <= 9)
      { allInvaders.add(new greenInvader(xNew, 90, 25, 2, this.greenInvader,this)); }
      else if(r >= 10 && r <= 19)
      { allInvaders.add(new yellowInvader(xNew, 90, 25, 2, this.yellowInvader,this)); }
      else if(r >= 20 && r <= 21)
      { allInvaders.add(new friendlyShip(xNew, 90, 25, 2, this.friendlyShipRight,this)); }
      else if(r >= 22 && r <= 24)
      { allInvaders.add(new blueInvader(xNew, 90, 25, 2, this.blueInvader1,this)); }
      else if(r >= 25 && r <= 27)
      { allInvaders.add(new purpleInvader(xNew, 90, 25, 2, this.purpleInvader,this)); }
      else
      { allInvaders.add(new redInvader(xNew, 90, 25, 2, this.redInvader,this)); }
    }
  }

  public void keyPressed()
  {
    if((CurrentData.getKeys()[0] == '<' && (keyCode == LEFT)) || (CurrentData.getKeys()[0] == '>' && (keyCode == RIGHT)) || (CurrentData.getKeys()[0] == '^' && (keyCode == UP)) || (CurrentData.getKeys()[0] == key)) //leftKey
    { keys[0] = true; }
    else if((CurrentData.getKeys()[1] == '<' && (keyCode == LEFT)) || (CurrentData.getKeys()[1] == '>' && (keyCode == RIGHT)) || (CurrentData.getKeys()[1] == '^' && (keyCode == UP)) || (CurrentData.getKeys()[1] == key)) //rightKey
    { keys[1] = true; }
    else if((CurrentData.getKeys()[2] == '<' && (keyCode == LEFT)) || (CurrentData.getKeys()[2] == '>' && (keyCode == RIGHT)) || (CurrentData.getKeys()[2] == '^' && (keyCode == UP)) || (CurrentData.getKeys()[2] == key)) //upKey
    { keys[2] = true; }
  }

  public void keyReleased()
  {
    if((CurrentData.getKeys()[0] == '<' && (keyCode == LEFT)) || (CurrentData.getKeys()[0] == '>' && (keyCode == RIGHT)) || (CurrentData.getKeys()[0] == '^' && (keyCode == UP)) || (CurrentData.getKeys()[0] == key)) //leftKey
    { keys[0] = false; }
    else if((CurrentData.getKeys()[1] == '<' && (keyCode == LEFT)) || (CurrentData.getKeys()[1] == '>' && (keyCode == RIGHT)) || (CurrentData.getKeys()[1] == '^' && (keyCode == UP)) || (CurrentData.getKeys()[1] == key)) //rightKey
    { keys[1] = false; }
    else if((CurrentData.getKeys()[2] == '<' && (keyCode == LEFT)) || (CurrentData.getKeys()[2] == '>' && (keyCode == RIGHT)) || (CurrentData.getKeys()[2] == '^' && (keyCode == UP)) || (CurrentData.getKeys()[2] == key)) //upKey
    { keys[2] = false; }
  }


  public void mousePressed()
  {
    if(bu.mouseIsOver())
    {
      screenShot = get();
      modeHistory.add(mode);
      mode = 3;
    }
  }

  public void mouseReleased(){}
}


interface Invader
{
  public void draw();
  public boolean touch(Shot s);
  public void move(int x, int y);
  public int getX();
  public int getY();
  public void onDie();
  public boolean isDead();
  public void onTouch(); //when the invader or friendly ship gets to the bottom of the screen
}


class IGMenue implements Mode
{
  Button continueButton, restartButton, settingsButton, mainMenueButton;
  PImage bg;

  public void setup()
  {
    continueButton = new Button("Continue",100,120,500,80);
    restartButton = new Button("Restart",100,240,500,80);
    settingsButton = new Button("Settings",100,360,500,80);
    mainMenueButton = new Button("Main Menue",100,480,500,80);
  }

  public void draw()
  {
    background(screenShot);
    fill(0, 0, 0, 100);
    rect(0, 0, width, height);
    continueButton.draw();
    restartButton.draw();
    settingsButton.draw();
    mainMenueButton.draw();
  }

  public void mousePressed()
  {
    if(continueButton.mouseIsOver())
    {
      modeHistory.add(mode);
      mode = 2;
    }
    else if(restartButton.mouseIsOver())
    {
      game.restart();
      modeHistory.add(mode);
      mode = 2;
    }
    else if(settingsButton.mouseIsOver())
    {
      modeHistory.add(mode);
      mode = 4;
    }
    else if(mainMenueButton.mouseIsOver())
    {
      modeHistory.add(mode);
      mode = 1;
    }
  }

  public void keyPressed(){}
  public void keyReleased(){}
  public void mouseReleased(){}
}


class DeathScreen implements Mode
{
  Button restartButton, mainMenueButton;
  PImage bg;

  public void setup()
  {
    bg = screenShot;
    restartButton = new Button("Restart",100,240,500,80);
    mainMenueButton = new Button("Main Menue",100,360,500,80);
  }

  public void draw()
  {
    background(screenShot);
    fill(0, 0, 0, 100);
    rect(0, 0, width, height);
    fill(255);
    textSize(height/5);
    text(game.player.score, width/2, 120);
    restartButton.draw();
    mainMenueButton.draw();
  }

  public void mousePressed()
  {
    if(restartButton.mouseIsOver())
    {
      game.restart();
      modeHistory.add(mode);
      mode = 2;
    }
    else if(mainMenueButton.mouseIsOver())
    {
      modeHistory.add(mode);
      mode = 1;
    }
  }

  public void keyPressed(){}
  public void keyReleased(){}
  public void mouseReleased(){}
}


class Player
{
  int x, y, size, lives, score, cooldown;
  float rate = 34, pointMult = 1;
  PImage img;
  PImage heart = loadImage("heart.png");
  ArrayList<Shot> playerShots = new ArrayList <Shot>();

  Player(int x, int y, int size, PImage img)
  {
    this.x = x;
    this.y = y;
    this.lives = 3;
    this.score = 0;
    this.size = size;
    this.img = img;
  }

  public void draw()
  {
    if(pointMult < 5)
    {pointMult *= 1.000089417;}

    fill(0xffFFFFFF);
    textSize(32);
    textAlign(RIGHT);
    text(this.score, width-50, 58);

    for(int i = 0; i<this.lives; i++)
    {
      if(graphix == 2)
      {
        stroke(255,0,0);
        fill(255,0,0);
        circle(25+40*i, 55, 30);
      }
      else
      { image(this.heart, 10+40*i, 30, 30, 30); }
    }

    if(graphix == 2)
    {
      stroke(0,0,255);
      fill(255);
      circle(this.x+this.size/2, this.y+this.size/2, this.size);
    }
    else
    { image(this.img,this.x,this.y,this.size,this.size); }

    this.cooldown++;
    if(this.rate>17)
    {this.rate *= 0.9999615f;}
  }

  public void move(int xMov)
  {
    if(this.x+xMov >= 0 && this.x+xMov <= (width - this.size))
    { this.x += xMov; }
  }

  public void shoot()
  {
    if(this.cooldown >= this.rate)
    {
      this.playerShots.add(new Shot(this.x+this.size/2-1, this.y, 2, 10, -7, color(0xffFF0000)));
      this.cooldown = 0;
    }
  }

  public void addPoints(int points)
  { this.score += Math.round(points* this.pointMult); }

  public void looseLive(int lives)
  { this.lives -= lives; }

  public void addLive()
  {
    if(this.lives<=4)
    { this.lives ++; }
    else
    { this.score += 10; }
  }

  public boolean touch(Shot e)
  {
    return (this.y < e.y && e.y < this.y+this.size && this.x < e.x && e.x < this.x+this.size);
  }
}


class Shot
{
  int x, y, v, h, w;
  int col;

  Shot(int x, int y, int w, int h, int v, int col)
  {
    this.x = x;
    this.y = y;
    this.h = h;
    this.w = w;
    this.v = v;
    this.col = col;
  }

  public void draw()
  {
    this.y += this.v;
    noStroke();
    fill(this.col);
    rect(this.x, this.y, this. w, this.h);
  }
}


class invaderCl implements Invader
{
  int x, y, v, size;
  int points;
  PImage img;
  boolean dead = false;
  int spawn = 3; //for the spawning animation
  Game game;

  invaderCl(int x, int y, int size, int v, PImage img,Game game)
  {
    this.x = x;
    this.y = y;
    this.v = v;
    this.size = size - this.spawn*5;
    this.img = img;
    this.game = game;
  }

  public void draw()
  {
    if(this.y >= 650) //if the invader is at the bottom
    { this.onTouch(); }

    this.x += this.v;

    if(this.x >= width-this.size) //if the invader goes out of the screen on the right
    {
      this.y += 50;
      this.v = this.v *(-1) -1;
    }
    else if(this.x <= 0) //if the invader goes out of the screen on the left
    {
      this.y += 50;
      this.v = this.v *(-1) +1;
    }

    if(this.spawn > 0)
    {
      this.spawn --;
      this.size += 5;
    }

    if(graphix == 2)
    {
      stroke(255,0,0);
      fill(255,0,0);
      circle(this.x+this.size/2, this.y+this.size/2,this.size);
    }
    else
    { image(this.img,this.x,this.y,this.size,this.size); }
  }

  public void move(int x, int y)
  {
    this.x += x;
    this.y += y;
  }

  public int getX()
  { return this.x; }

  public int getY()
  { return this.y; }

  public void setPos(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  public boolean touch(Shot e)
  { return (this.y < e.y && e.y < this.y+this.size && this.x < e.x && e.x < this.x+this.size); }

  public void onTouch()
  {
    game.player.looseLive(1);
    this.dead = true;
  }

  public void onDie()
  {
    game.player.addPoints(this.points);
    this.dead = true;
  }

  public boolean isDead()
  { return this.dead; }
}


class blueInvader extends invaderCl implements Invader
{
  blueInvader(int x, int y, int size, int v, PImage img, Game game)
  {
    super(x, y, size, v, img, game);
    this.points = 5;
  }

  public void onTouch()
  {
    game.player.looseLive(1);
    this.dead = true;
    this.onDie();
  }

  public void onDie()
  {
    game.player.addPoints(this.points);
    this.dead = true;
    game.allInvaders.add(new greenInvader(this.x, this.y, this.size, this.v, game.blueInvader2,game));
  }
}


class friendlyShip extends invaderCl implements Invader
{
  friendlyShip(int x, int y, int size, int v, PImage img, Game game)
  {
    super(x, y, size, v, img, game);
    this.points = 100;
  }

  public void draw()
  {
    if(this.x >= width-this.size) //if the ship goes out of the screen on the right
    { this.img = game.friendlyShipLeft; }
    else if(this.x <= 0) //if the ship goes out of the screen on the left
    { this.img = game.friendlyShipRight; }

    super.draw();
  }

  public void onTouch()
  {
    game.player.addLive();
    this.dead = true;
  }

  public void onDie()
  {
    this.dead = true;
    game.player.looseLive(1);
  }
}


class greenInvader extends invaderCl implements Invader
{
  int cooldown = 0;
  greenInvader(int x, int y, int size, int v, PImage img,Game game)
  {
    super(x, y, size, v, img, game);
    this.points = 10;
  }

  public void draw()
  {
    if(this.cooldown >= random(44,66))
    { this.shoot(); }
    this.cooldown ++;

    super.draw();
  }

  public void shoot()
  {
    game.invaderShots.add(new Shot(this.x+this.size/2 +5, this.y, 2, 10, 5, 0xff00FF00));
    this.cooldown = 0;
  }
}


class purpleInvader extends invaderCl implements Invader
{
  int cooldown=0;
  purpleInvader(int x, int y, int size, int v, PImage img,Game game)
  {
    super(x, y, size, v, img, game);
    this.points = 20;
  }

  public void draw()
  {
    if(this.cooldown >= random(15,30) && game.player.x+(game.player.size/2)-10 <= this.x && game.player.x+(game.player.size/2)+10 >= this.x)
    { this.shoot(); }
    this.cooldown ++;

    super.draw();
  }

  public void shoot()
  {
    game.invaderShots.add(new Shot(this.x+this.size/2 +5, this.y, 2, 10, 10, 0xffFF00FF));
    this.cooldown = 0;
  }
}


class redInvader extends invaderCl implements Invader
{
  redInvader(int x, int y, int size, int v, PImage img,Game game)
  {
    super(x, y, size, v, img, game);
    this.points = 5;
  }
}


class yellowInvader extends invaderCl implements Invader
{
  yellowInvader(int x, int y, int size, int v, PImage img,Game game)
  {
    super(x, y, size, v, img, game);
    this.points = 5;
  }

  public void onTouch()
  {
    game.player.looseLive(1);
    this.dead = true;
    this.onDie();
  }

  public void onDie()
  {
    game.player.addPoints(this.points);
    this.dead = true;
    game.allInvaders.add(new redInvader(this.x, this.y, this.size, this.v, game.yellowRedInvader,game));
  }
}



public void settings()
{ fullScreen(); }

static public void main(String[] passedArgs)
{
  Connections.initConnections();
  String[] appletArgs = new String[]
  { "main" };
  if (passedArgs != null)
  { PApplet.main(concat(appletArgs, passedArgs)); }
  else
  { PApplet.main(appletArgs); }
}
}
