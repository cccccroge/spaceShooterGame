package com.bigbirddy.mygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class healthBar {
	
	public float healtRate;
	float offset;
	Texture texture;
	
	float x;
	float y;
	float width;
	float height;
	
	//constructor
	public healthBar() {
		healtRate = 1;
		offset = 10;
		texture = new Texture("blank.png");
		
		x = offset;
		y = offset;
		width = (Gdx.graphics.getWidth() - offset * 2) * healtRate;
		height = 8;
	}
	
	//render depends on health
	public void render(SpriteBatch batch) {
		width = (Gdx.graphics.getWidth() - offset * 2) * healtRate;
		if(healtRate > 0.7f) {
			batch.setColor(Color.OLIVE);
			batch.draw(texture, x, y, width, height);
			batch.setColor(Color.WHITE);
		} else if(healtRate > 0.25f) {
			batch.setColor(Color.YELLOW);
			batch.draw(texture, x, y, width, height);
			batch.setColor(Color.WHITE);
		} else if(healtRate > 0){
			batch.setColor(Color.MAGENTA);
			batch.draw(texture, x, y, width, height);
			batch.setColor(Color.WHITE);
		} else {
			
		}
		
	}

}

