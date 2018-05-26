package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.helpers.GameInfo;

public class Player extends Sprite {

    private float ySize;
    private float xSize;
    private float xPos;
    private float yPos;

    public Player(String name, int x, int y, int xSize, int ySize){
        super(new Texture(name));
        this.xPos=x-xSize/2;
        this.yPos=y-ySize/2;
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public void updatePosition(float x, float y){
        this.xPos = x - this.xSize/2;
        this.yPos = y - this.ySize/2;
    }

    public void playerLogic(){
        this.xPos=Gdx.input.getX()-xSize/2;
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

}
