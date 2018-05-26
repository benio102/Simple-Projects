package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.background.BackGround;
import com.mygdx.game.helpers.GameInfo;

public class Ball extends Sprite {

    //Statistics
    private float points = 1;

    //Ball
    private float xMove = 1;
    private float yMove = 1;
    private float ySize;
    private float xSize;
    private float xPos;
    private float yPos;
    public Ball(String name, int x, int y, int xSize, int ySize){
        super(new Texture(name));
        this.xPos=x-xSize/2;
        this.yPos=y-ySize/2;
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public void moveBall(int x, int y){
        this.xPos = x - xSize/2;
        this.yPos = y -ySize/2;
    }

    public void ballLogic(float playerX, float playerY, float playerXSize, float playerYSize){

       xPos = xPos + xMove*points;
       yPos = yPos + yMove*points;



       //Screen
       if(xPos > GameInfo.WIDTH-xSize){
            xMove = -1;
       }
       if(xPos < 0){
           xMove = 1;
       }
       if(yPos < 0){
           yMove = 1;
       }
       if(yPos > GameInfo.HEIGHT-ySize){
           yMove = -1;
       }

       //Player
        if ((xPos > playerX && xPos < playerX+playerXSize) && (yPos == playerY+2*ySize) ){
           yMove = 1;
           points = points + 1;
           System.out.println("HIT!");
        }

        //Gameover
        if(yPos < playerY){
            Gdx.gl.glClearColor(1, 0,0,1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        }

    }

    public float getySize() {
        return ySize;
    }

    public void setySize(float ySize) {
        this.ySize = ySize;
    }

    public float getxSize() {
        return xSize;
    }

    public void setxSize(float xSize) {
        this.xSize = xSize;
    }

    public float getxPos() {
        return xPos;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }
}
