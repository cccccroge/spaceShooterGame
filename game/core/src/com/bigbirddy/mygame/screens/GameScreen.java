package com.bigbirddy.mygame.screens;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.bigbirddy.mygame.myGame;
import com.bigbirddy.mygame.entities.bullet;
import com.bigbirddy.mygame.entities.rock;

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
    float rolling_state_time = 0;
    float rolling_check_time;
    float idle_state_time = 0;
    float idle_check_time;
    
    //entities container
    ArrayList<bullet> bullet_arrayList;
    ArrayList<rock> rock_arrayList;
    
    //bullet burst limitation
    float shoot_state_time = 0;
    float shoot_check_time;
    
    //rock time settings
    float random_generateRock_timer;
    float MIN_generateRock_time;
    float MAX_generateRock_time;
    Random random;

	
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
		idle_check_time = 0.06f;
		shoot_check_time = 0.2f;
		
		bullet_arrayList = new ArrayList<bullet>();

		MAX_generateRock_time = 0.6f;
		MIN_generateRock_time = 0.3f;
		
		random = new Random();
		random_generateRock_timer = MIN_generateRock_time + random.nextFloat() * (MAX_generateRock_time - MIN_generateRock_time);
		rock_arrayList = new ArrayList<rock>();
	}
	
	@Override
	public void show() {

	}

	
	@Override
	public void render(float delta) {

		//left-arrow key
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
		
		
		//right-arrow key
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
		
		//balance the ship if tilted 
		if(!Gdx.input.isKeyPressed(Keys.LEFT) && !Gdx.input.isKeyPressed(Keys.RIGHT)) {
			idle_state_time += Gdx.graphics.getDeltaTime();
			if (Math.abs(idle_state_time) > idle_check_time) {
				//if tilted right, balance toward left
				if(roll > 2) roll--;
				if(roll < 2) roll++;
				idle_state_time = 0;
			}
		}
		
		//spacebar : create the bullets
		//also add a limitation to prevent burst
		shoot_state_time += delta;
		if(Gdx.input.isKeyPressed(Keys.SPACE) && shoot_state_time >= shoot_check_time) {
			//depends on different rolls, shoot at different position
			int offset = 4;
			if(roll == 3 || roll == 1) offset = 8;
			if(roll == 4 || roll == 0) offset = 16;
			bullet_arrayList.add(new bullet(x + offset));
			bullet_arrayList.add(new bullet(x - offset + ship_actual_width));
			
			shoot_state_time = 0;
		}
		
		//update the bullet status and remove deads
		ArrayList<bullet> bulletToRemove_arrayList = new ArrayList<bullet>();
		for (bullet b : bullet_arrayList) {
			if (!b.alive) {
				bulletToRemove_arrayList.add(b);
			}
			b.update(delta);
			b.bullet_rect.move(b.bullet_x, b.bullet_y);
		}
		

		//run the rock generate timer, if it set to 0, create a rock
		random_generateRock_timer -= delta;
		if(random_generateRock_timer <= 0) {
			Random random = new Random();
			rock_arrayList.add(new rock(random.nextInt(Gdx.graphics.getWidth() - ship_actual_width)));
			random_generateRock_timer = MIN_generateRock_time + random.nextFloat() * (MAX_generateRock_time - MIN_generateRock_time);
		}
		//update rock status
		for (rock r : rock_arrayList) {
			r.update(delta);
			r.rock_rect.move(r.rock_x, r.rock_y);
		}
		
		//collision event
		//1.bullet hit rock, remove both
		ArrayList<rock> rockToRemove_arrayList = new ArrayList<rock>();
		for (bullet b : bullet_arrayList) {
			for (rock r : rock_arrayList) {
				if(b.bullet_rect.collideWith(r.rock_rect)) {
					bulletToRemove_arrayList.add(b);
					rockToRemove_arrayList.add(r);
				}
			}
		}
		bullet_arrayList.removeAll(bulletToRemove_arrayList);
		rock_arrayList.removeAll(rockToRemove_arrayList);
		
		//render the entities
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.begin();
		for (bullet b : bullet_arrayList) {
			b.render(game.batch);
		}
		for (rock r : rock_arrayList) {
			r.render(game.batch);
		}
		
		//makes the ship trembled
		state_time += delta;
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
