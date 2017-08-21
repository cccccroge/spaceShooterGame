package com.bigbirddy.mygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class bullet {
	
	/***********/
	/*variables*/
	/***********/
	
	//bullet property
	float bullet_x;
	float bullet_y;
	float bullet_speed;
	Texture bullt_texture;
	
	
	/***********/
	/*methods*/
	/***********/
	
	//constructor
	public bullet (float x) {
		bullet_x = x;
		bullet_y = 40;
		bullet_speed = 500;
		bullt_texture = new Texture("bullet.png");


		
	}
	
	//update the state of bullet (move event/collision event...)
	public void update (float delta_time) {
		//moves up continuously
		bullet_y += bullet_speed * delta_time;
		//if the bullet is out of border
		if (bullet_y > Gdx.graphics.getHeight()) {
			//bullt_texture = null;
			//stem.gc();
		}
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(bullt_texture, bullet_x, bullet_y);
	}
	
	
	
}
