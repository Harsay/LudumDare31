package com.harsay.ld31;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

public class Player extends Entity {

	public float radius;
	public float yAccel;
	public float xAccel;
	public float maxAccel = 20;
	public float friction = 120; // 120?
	
	public Circle circle;
	
	public boolean animateKill = false;
	public boolean alive = true;
	
	public Player(MyGame game, float x, float y, float radius) {
		super(game, x, y);
		this.speed = 100;
		this.radius = radius;
		circle = new Circle();
		updateCircle();
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
		
		if(!alive) {
			if(animateKill) {
				//radius += 800*delta;
				//if (radius > 80)  {
				//	radius = 80;
					animateKill = false;
				//}
			} 
		} else {
			checkInput(delta);
			checkMovementConstraints();
		}
		updateCircle();
	}
	
	@Override
	public void draw(ShapeRenderer sr, SpriteBatch sb) {
		if(alive) sr.setColor(1,1,1,1);
		else sr.setColor(1, 0, 0, 1);
		sr.circle(circle.x, circle.y, circle.radius);
	}
	
	public void updateCircle() {
		circle.x = x;
		circle.y = y;
		circle.radius = radius;
	}
	
	public void checkInput(float delta) {
		if(Gdx.input.isKeyPressed(GameKeys.UP)) {
			yAccel += speed*delta;
		}
		else if(Gdx.input.isKeyPressed(GameKeys.DOWN)) {
			yAccel -= speed*delta;
		}
		else if(yAccel > 0) {
			yAccel -= friction*delta;
			if(yAccel < 0) yAccel = 0; // Avoid float magic
		}
		else if(yAccel < 0) {
			yAccel += friction*delta;
			if(yAccel > 0) yAccel = 0; // Avoid float magic
		}
		
		if(Gdx.input.isKeyPressed(GameKeys.RIGHT)) {
			xAccel += speed*delta;
		}
		else if(Gdx.input.isKeyPressed(GameKeys.LEFT)) {
			xAccel -= speed*delta;
		}
		else if(xAccel > 0) {
			xAccel -= friction*delta;
			if(xAccel < 0) xAccel = 0; // Avoid float magic
		}
		else if(xAccel < 0) {
			xAccel += friction*delta;
			if(xAccel > 0) xAccel = 0; // Avoid float magic
		}
		
		if(xAccel > maxAccel) xAccel = maxAccel;
		else if(xAccel < -maxAccel) xAccel = -maxAccel;
	
		if(yAccel > maxAccel) yAccel = maxAccel;
		else if(yAccel < -maxAccel) yAccel = -maxAccel;
		
		x += xAccel;
		y += yAccel;
	}
	
	public void checkMovementConstraints() {
		if(x < radius) {
			x = radius;
			xAccel = 0;
		}
		else if(x+radius > MyGame.WIDTH) {
			x = MyGame.WIDTH-radius;
			xAccel = 0;
		}
		
		if(y < radius)  {
			y = radius;
			yAccel = 0;
		}
		else if(y+radius > MyGame.HEIGHT) {
			y = MyGame.HEIGHT-radius;
			yAccel = 0;
		}
	}
	
	public void kill() {
		game.assets.rektSound.play();
		game.assets.lostSound.play();
		alive = false;
		animateKill = true;
	}
}
