package com.bigbirddy.mygame.tools;

public class collisionRect {
	float x;
	float y;
	float width;
	float height;
	collisionRect rect;
	
	//constructor
	public collisionRect(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	//update the hitbox position
	public void move(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	//test if the object collide with another
	public boolean collideWith(collisionRect rect) {
		boolean horizon_condition = (x > rect.x && x < rect.x + rect.width) || 
				(x+width > rect.x && x+width < rect.x + rect.width);
		boolean vertical_condition = (y > rect.y && y < rect.y + rect.height) || 
				(y+height > rect.y && y+height < rect.y + rect.height);
		return horizon_condition && vertical_condition;
	}

}
