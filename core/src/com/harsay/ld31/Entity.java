package com.harsay.ld31;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class Entity {
	
	protected MyGame game;
	
	public float x;
	public float y;
	public float speed;
		
	public Entity(MyGame game, float x, float y) {
		this.game = game;
		this.x = x;
		this.y = y;
	}

	
	public void update(float delta) {
		
	}
	
	public void draw(ShapeRenderer sr, SpriteBatch sb) {
		
	}
	
	public boolean collidesWith(Entity otherEntity) {
		return false;
	}


	public boolean collision(Rectangle rect, Rectangle rect2) {
		return Intersector.overlaps(rect, rect2);
	}
	
	public boolean collision(Circle circle, Rectangle rect) {
		return Intersector.overlaps(circle, rect);
	}
	
	public boolean collision(Circle circle, Circle circle2) {
		return Intersector.overlaps(circle, circle2);
	}
}
