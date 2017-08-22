package com.bigbirddy.mygame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.bigbirddy.mygame.myGame;

public class menuScreen implements Screen {
	
    /***********/
	/*variables*/
	/***********/
	
	//to get myGame's object
	myGame game;
	//to get gameScreen
	GameScreen gameScreen;
	
	//create button textures
	Texture exitButtonActive;
	Texture exitButtonInactive;
	Texture playButtonActive;
	Texture playButtonInactive;
	
	//button properties for exit
	final float exit_button_width = 300;
	final float exit_button_height = 150;
	final float exit_button_x = 80;
	final float exit_button_y = 200;
	//button properties for play
	final float play_button_width = 300;
	final float play_button_height = 150;
	final float play_button_x = 80;
	final float play_button_y = 350;
	
	
    /***********/
	/*methods*/
	/***********/
	
	//constructor
	public menuScreen(myGame game, GameScreen gameScreen) {
		this.game = game;
		this.gameScreen = gameScreen;
		exitButtonActive = new Texture("exit_button_active.png");
		exitButtonInactive = new Texture("exit_button_inactive.png");
		playButtonActive = new Texture("play_button_active.png");
		playButtonInactive = new Texture("play_button_inactive.png");
		
	}
	
	@Override
	public void show() {
		
	}

	//render the menu
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.begin();
		
		//effect of button moveOn
		float input_x = Gdx.input.getX();
		float input_y = Gdx.input.getY();
		if (input_x > exit_button_x && input_x < exit_button_x + exit_button_width &&
			input_y > myGame.window_height - exit_button_y - exit_button_height && input_y < myGame.window_height - exit_button_y) {
			game.batch.draw(exitButtonActive, exit_button_x, exit_button_y, exit_button_width, exit_button_height);
			
			if (Gdx.input.isTouched()) {
				Gdx.app.exit();
			}
			
		} else {
			game.batch.draw(exitButtonInactive, exit_button_x, exit_button_y, exit_button_width, exit_button_height);
		}
		
		if (input_x > play_button_x && input_x < play_button_x + play_button_width &&
				input_y > myGame.window_height - play_button_y - play_button_height && input_y < myGame.window_height - play_button_y) {
				game.batch.draw(playButtonActive, play_button_x, play_button_y, play_button_width, play_button_height);
				
				if (Gdx.input.isTouched()) {
					game.setScreen(gameScreen);
					this.dispose();
				}
				
			} else {
				game.batch.draw(playButtonInactive, play_button_x, play_button_y, play_button_width, play_button_height);
			}
		
		
		game.batch.end();
		
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
		
	}

	

}
