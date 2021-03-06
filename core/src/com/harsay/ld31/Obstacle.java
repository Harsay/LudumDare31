package com.harsay.ld31;

import java.util.Arrays;
import java.util.List;

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
	public boolean killed = false;
	
	public float spawnFlashTime = 0.3f;
	public float spawnFlashTimeElapsed = 0;
	public float spawnFlashes = 0;
	
	public float timeToStartSpawning;
	public float timeBeforeSpawnElapsed = 0;
	
	public float timeAlive;
	public float timeAliveElapsed = 0;
	
	public List<Goal> goalsList;
	public Goal presentGoal = null;
	public int goalID = 0;
	
	public Obstacle(MyGame game, float x, float y, float width, float height, float timeToStartSpawning, float timeAlive) {
		super(game, x, y);
		this.width = width;
		this.height = height;
		this.timeToStartSpawning = timeToStartSpawning;
		this.timeAlive = timeAlive;
		
		rectangle = new Rectangle();
		updateRectangle();
	}
	
	public Obstacle(MyGame game, float x, float y, float width, float height, float timeToStartSpawning, Goal[] goals ) {
		this(game, x, y, width, height, timeToStartSpawning, 0);
		
		goalsList = Arrays.asList(goals);
		presentGoal = goalsList.get(goalID);
		presentGoal.setObstacle(this);
		
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
				if(spawnFlashes == 3)  {
					spawning = false;
					spawnFlashes = 0;
					spawnFlashTimeElapsed = 0;
					if(killed)  game.obstacles.remove(this);
				}
			}
			return;
		}
		
		///
		
		if(timeAlive > 0) {
			timeAliveElapsed += delta;
			if(timeAliveElapsed >= timeAlive) kill();
		}
		
		if(presentGoal != null) {
			presentGoal.update(this, delta);
			if(presentGoal.reached) {
				if(++goalID+1 > goalsList.size()) {
					kill();
				} else {
					presentGoal = goalsList.get(goalID);
					presentGoal.setObstacle(this);
				}
			}
		}
		
		updateRectangle();
	}
	
	@Override
	public void draw(ShapeRenderer sr, SpriteBatch sb) {
		float c = (float) 15 / (float) 255;
		if(show) {
			//if(spawning) sr.setColor(0, 0, 0, 1);
			sr.setColor(c, c, c, 1);
			sr.rect(x, y, width, height);
		}
	}
	
	public void updateRectangle() {
		rectangle.x = x;
		rectangle.y = y;
		rectangle.width = width;
		rectangle.height = height;
	}
	
	public void kill() {
		killed = true;
		spawning = true;
	}

}
