package com.bigbirddy.mygame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.bigbirddy.mygame.myGame;

public class GameScreen implements Screen{
	
    /***********/
	/*variables*/
	/***********/
	
	//to get myGame's object
	myGame game;
	
	//ship properties
	float x;
	float y;
	float ship_speed;
	int ship_unit_width;
	int ship_unit_height;
	int ship_actual_width;
	int ship_actual_height;
	
	//ship animations
	Animation[] rolls;
	int roll;
	TextureRegion[][] rollSpriteSheet;
    float frame_speed;
    float state_time;
    float rolling_state_time;
    float rolling_check_time;

	
	/***********/
	/*methods*/
	/***********/
	
	//constructor
	public GameScreen(myGame game) {
		y = 15;
		x = game.window_width / 2 - ship_unit_width / 2;
		this.game = game;
		ship_speed = 350;
		ship_unit_width = 17;
		ship_unit_height = 32;
		ship_actual_width = ship_unit_width * 3;
		ship_actual_height = ship_unit_width * 3;
				
		roll = 2;
		rolls = new Animation[5];
		frame_speed = 0.5f;
		rollSpriteSheet = TextureRegion.split(new Texture("ship.png"), ship_unit_width, ship_unit_height);
		//0~4 goes from left to right texture
		rolls[0] = new Animation(frame_speed, rollSpriteSheet[2]);
		rolls[1] = new Animation(frame_speed, rollSpriteSheet[1]);
		rolls[2] = new Animation(frame_speed, rollSpriteSheet[0]);
		rolls[3] = new Animation(frame_speed, rollSpriteSheet[3]);
		rolls[4] = new Animation(frame_speed, rollSpriteSheet[4]);
		rolling_check_time = 0.15f;
		
		
		
	}
	
	@Override
	public void show() {

	}

	
	@Override
	public void render(float delta) {

		//if the left-arrow key is pressed
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			
			//moves left
			x -= ship_speed * Gdx.graphics.getDeltaTime();
			//check if it is out of left border
			if (x < 5) {
				x = 5;
			}
			//change the animation if the state_time changed
			rolling_state_time += Gdx.graphics.getDeltaTime();
			if (Math.abs(rolling_state_time) > rolling_check_time) {
				if(roll >= 1) roll--;
				rolling_state_time = 0;
			}
			
		}
		
		//if the right-arrow key is pressed
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			//moves right
			x += ship_speed * Gdx.graphics.getDeltaTime();
			//check if it is out of right border
			if (x > Gdx.graphics.getWidth() - ship_actual_width - 5) {
				x = Gdx.graphics.getWidth() - ship_actual_width - 5;
			}
			//change the animation if the timer changed
			rolling_state_time += Gdx.graphics.getDeltaTime();
			if (Math.abs(rolling_state_time) > rolling_check_time) {
				if(roll <= 3) roll++;
				rolling_state_time = 0;
			}
			
		}
		
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		state_time += delta;
		game.batch.begin();
		//makes the ship trembled
		game.batch.draw(rolls[roll].getKeyFrame(state_time, true), x, y, ship_actual_width, ship_actual_height);
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
