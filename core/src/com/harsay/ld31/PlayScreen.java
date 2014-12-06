package com.harsay.ld31;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class PlayScreen extends GameScreen {
	
	Player player;
	public ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

	public PlayScreen(MyGame game) {
		super(game);
		float c = (float) 32 / (float) 255;
		backgroundColor.set(c, c, c, 1);
		player = new Player(game, MyGame.WIDTH/2, MyGame.HEIGHT/2, 30);
		obstacles.add(new Obstacle(game, 600, 0, 300, 400));
	}
	
	public void update(float delta) {
		super.update(delta);
		player.update(delta);
		if(player.alive) {
			for(int i=0; i < obstacles.size(); i++) {
				Obstacle o = obstacles.get(i);
				o.update(delta);
				if(player.collision(player.circle, o.rectangle)) {
					endGame();
				}
			}
		}
	}
	
	public void draw(float delta) {
		shapeRenderer.begin(ShapeType.Filled);
		{
			player.draw(shapeRenderer, spriteBatch);
			for(int i=0; i < obstacles.size(); i++) {
				Obstacle o = obstacles.get(i);
				o.draw(shapeRenderer, spriteBatch);
			}
		}
		shapeRenderer.end();
		
		
		spriteBatch.begin();
		{
			// HUD AND STUFF
			//game.assets.big.setColor(1, 1, 1, 1);
			game.assets.medium.draw(spriteBatch, "00:13:37", 20, MyGame.HEIGHT-20);
		}
		spriteBatch.end();
	}
	
	public void endGame() {
		player.kill();
		// TODO: end sequence
	}

}
