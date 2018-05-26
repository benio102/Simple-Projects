package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.helpers.GameInfo;

public class DesktopLauncher {
	public static void main (String[] arg) {
	    disableWarning();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = GameInfo.HEIGHT;
		config.width = GameInfo.WIDTH;
		config.useGL30 = true;
		new LwjglApplication(new MyGdxGame(), config);
	}

	public static void disableWarning() {
		System.err.close();
		System.setErr(System.out);
	}
}
