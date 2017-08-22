package com.bigbirddy.mygame.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class explosion {
	
	//explosion settings
	float x;
	float y;
	int width;
	int height;
	int offset;
	
	//explosion animation
	Texture texture;					/*single pic(consist of multiple frames)*/
	TextureRegion textureRegion[][];	/*two-dimen array, need pic & unit size to cut*/
	Animation animation;				/*animation, need frame rate & one-dimen array*/
	float animation_speed;
	float state_time;
	public boolean finished;
	
	
	
	//constructor
	public explosion(float x, float y) {
		this.x = x;
		this.y = y;
		width = 32;
		height = 32;
		
		offset = 8;
		state_time = 0;
		
		texture = new Texture("explosion.png");
		textureRegion = TextureRegion.split(texture, width, height);
		animation_speed = 0.125f;
		animation = new Animation(animation_speed, textureRegion[0]);
		
		finished = false;
		
	}
	
	public void update(float delta) {
		state_time += delta;
		if(animation.isAnimationFinished(state_time))
			finished = true;
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(animation.getKeyFrame(state_time, false), x - offset, y - offset);
	}

}
