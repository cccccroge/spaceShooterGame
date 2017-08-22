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
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gameScreen = new GameScreen(this);
		menuScreen = new menuScreen(this, gameScreen);
		
		setScreen(menuScreen);
	}

	@Override
	public void render () {
		super.render();
		
	}
}
