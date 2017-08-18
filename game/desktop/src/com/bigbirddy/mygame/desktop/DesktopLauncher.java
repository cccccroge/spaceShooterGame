package com.bigbirddy.mygame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bigbirddy.mygame.myGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 144;
		config.width = myGame.window_width;
		config.height = myGame.window_height;
		config.resizable = false;
		new LwjglApplication(new myGame(), config);
	}
}
