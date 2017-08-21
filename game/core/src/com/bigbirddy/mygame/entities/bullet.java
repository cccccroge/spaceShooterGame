package com.bigbirddy.mygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bigbirddy.mygame.tools.collisionRect;

public class bullet {
	
	/***********/
	/*variables*/
	/***********/
	
	//bullet property
	public float bullet_x;
	public float bullet_y;
	float bullet_speed;
	Texture bullt_texture;
	public boolean alive;
	public collisionRect bullet_rect;
	float bullet_rect_width;
	float bullet_rect_height;
	
	
	/***********/
	/*methods*/
	/***********/
	
	//constructor
	public bullet (float x) {
		bullet_x = x;
		bullet_y = 40;
		bullet_speed = 500;
		bullt_texture = new Texture("bullet.png");
		alive = true;
		bullet_rect_width = 3;
		bullet_rect_height = 12;
		bullet_rect = new collisionRect(bullet_x, bullet_y, bullet_rect_width, bullet_rect_height);
		
	}
	
	//update the state of bullet (move event/collision event...)
	public void update (float delta_time) {
		//moves up continuously
		bullet_y += bullet_speed * delta_time;
		//if the bullet is out of border
		if (bullet_y > Gdx.graphics.getHeight()) {
			alive  = false;
		}
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(bullt_texture, bullet_x, bullet_y);
	}
	
	
	
}
