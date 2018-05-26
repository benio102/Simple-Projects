package com.mygdx.game.scenes;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.background.BackGround;
import com.mygdx.game.helpers.GameInfo;
import com.mygdx.game.player.Ball;
import com.mygdx.game.player.Player;

public class MainGame implements Screen {

    MyGdxGame game;
    BackGround backGround;
    Player player;
    Ball ball;
    Music song;


    public MainGame(MyGdxGame game){
        this.game = game;
        song = Gdx.audio.newMusic(Gdx.files.internal("core/assets/Rise of spirit.mp3"));
        backGround = new BackGround("core/assets/space2.png");
        player = new Player("core/assets/56-Breakout-Tiles.png", GameInfo.WIDTH/2, GameInfo.HEIGHT/12, 100,50);
        ball = new Ball("core/assets/58-Breakout-Tiles.png", GameInfo.WIDTH/2, GameInfo.HEIGHT/3,20,20);
        song.play();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0 ,0 ,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
            game.getBatch().draw(backGround, 0,0,GameInfo.WIDTH,GameInfo.HEIGHT);
            game.getBatch().draw(player, player.getxPos(), player.getyPos(), player.getxSize(), player.getySize());
            game.getBatch().draw(ball, ball.getxPos(), ball.getyPos(), ball.getxSize(), ball.getySize());
        game.getBatch().end();
        player.playerLogic();
        ball.ballLogic(player.getxPos(), player.getyPos(), player.getxSize(), player.getySize());

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        song.dispose();
    }
}
