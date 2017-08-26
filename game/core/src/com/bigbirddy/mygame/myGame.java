package com.bigbirddy.mygame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bigbirddy.mygame.screens.GameScreen;
import com.bigbirddy.mygame.screens.gameOverScreen;
import com.bigbirddy.mygame.screens.menuScreen;

public class myGame extends Game {
	
	public SpriteBatch batch;
	//window screen size
	public static final int window_width = 480;
	public static final int window_height = 720;
	public menuScreen menuScreen;
	public GameScreen gameScreen;
<<<<<<< HEAD
	public gameOverScreen gameoverScreen;
=======
>>>>>>> 098e684e88d56348d3fefc5e0e48124a4436b928
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gameScreen = new GameScreen(this);
<<<<<<< HEAD
		menuScreen = new menuScreen(this);
=======
		menuScreen = new menuScreen(this, gameScreen);
>>>>>>> 098e684e88d56348d3fefc5e0e48124a4436b928
		
		setScreen(menuScreen);
	}

	@Override
	public void render () {
		super.render();
		
	}
}
