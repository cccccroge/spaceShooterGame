package com.bigbirddy.mygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bigbirddy.mygame.tools.collisionRect;

public class rock {

	/***********/
	/*variables*/
	/***********/
	
	//rock property
	public float rock_x;
	public float rock_y;
	float rock_speed;
	Texture rock_texture;
	public boolean alive;
	public collisionRect rock_rect;
	float rock_rect_width;
	float rock_rect_height;
	
	
	/***********/
	/*methods*/
	/***********/
	
	//constructor
	public rock (float x) {
		rock_x = x;
		rock_y = Gdx.graphics.getHeight();
		rock_speed = 179;
		rock_texture = new Texture("asteroid.png");
		alive = true;
		rock_rect_width = 16;
		rock_rect_height = 16;
		rock_rect = new collisionRect(rock_x, rock_y, rock_rect_width, rock_rect_height);
		
	}
	
	//update the state of bullet (move event/collision event...)
	public void update (float delta_time) {
		//moves down continuously
		rock_y -= rock_speed * delta_time;
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(rock_texture, rock_x, rock_y);
	}

}
