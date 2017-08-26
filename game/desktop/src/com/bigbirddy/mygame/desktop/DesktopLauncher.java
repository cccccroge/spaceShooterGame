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
<<<<<<< HEAD
		config.resizable = true;
=======
		config.resizable = false;
>>>>>>> 098e684e88d56348d3fefc5e0e48124a4436b928
		new LwjglApplication(new myGame(), config);
	}
}
