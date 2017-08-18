package com.bigbirddy.mygame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bigbirddy.mygame.screens.menuScreen;

public class myGame extends Game {
	
	public SpriteBatch batch;
	//window screen size
	public static final int window_width = 480;
	public static final int window_height = 720;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		menuScreen menuScreen = new menuScreen(this);
		setScreen(menuScreen);
	}

	@Override
	public void render () {
		super.render();
		
	}
}
