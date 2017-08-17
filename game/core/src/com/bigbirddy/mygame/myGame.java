package com.bigbirddy.mygame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bigbirddy.mygame.screens.GameScreen;

public class myGame extends Game {
	
	public SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		GameScreen gs = new GameScreen(this);
		setScreen(gs);
	}

	@Override
	public void render () {
		super.render();
		
	}
}
