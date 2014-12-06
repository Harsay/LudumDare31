package com.harsay.ld31;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Obstacle extends Entity {
	
	public Rectangle rectangle;
	public float width;
	public float height;

	public boolean spawning = true;
	public boolean show = false;
	public boolean alive = false;
	
	public float spawnFlashTime = 0.3f;
	public float spawnFlashTimeElapsed = 0;
	public float spawnFlashes = 0;
	
	public float timeToStartSpawning;
	public float timeBeforeSpawnElapsed = 0;
	
	public Obstacle(MyGame game, float x, float y, float width, float height, float timeToStartSpawning) {
		super(game, x, y);
		this.width = width;
		this.height = height;
		this.timeToStartSpawning = timeToStartSpawning;
		
		rectangle = new Rectangle();
		updateRectangle();
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
		
		if(!alive) {
			timeBeforeSpawnElapsed += delta;
			if(timeBeforeSpawnElapsed >= timeToStartSpawning) alive = true;
			return;
		}
		
		if(spawning) {
			spawnFlashTimeElapsed += delta;
			if(spawnFlashTimeElapsed >= spawnFlashTime) {
				spawnFlashTimeElapsed = 0;
				spawnFlashes++;
				show = !show;
				game.assets.warnSound.play();
				if(spawnFlashes == 5) spawning = false;
			}
		}
		
		updateRectangle();
	}
	
	@Override
	public void draw(ShapeRenderer sr, SpriteBatch sb) {
		float c = (float) 15 / (float) 255;
		if(show) {
			if(spawning) sr.setColor(1, 1, 1, 0.1f);
			else sr.setColor(c, c, c, 1);
			sr.rect(x, y, width, height);
		}
	}
	
	public void updateRectangle() {
		rectangle.x = x;
		rectangle.y = y;
		rectangle.width = width;
		rectangle.height = height;
	}

}
