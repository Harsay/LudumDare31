package com.harsay.ld31;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Obstacle extends Entity {
	
	public Rectangle rectangle;
	public float width;
	public float height;

	public Obstacle(MyGame game, float x, float y, float width, float height) {
		super(game, x, y);
		this.width = width;
		this.height = height;
		
		rectangle = new Rectangle();
		updateRectangle();
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
		
		updateRectangle();
	}
	
	@Override
	public void draw(ShapeRenderer sr, SpriteBatch sb) {
		float c = (float) 15 / (float) 255;
		sr.setColor(c, c, c, 1);
		sr.rect(x, y, width, height);
	}
	
	public void updateRectangle() {
		rectangle.x = x;
		rectangle.y = y;
		rectangle.width = width;
		rectangle.height = height;
	}

}
