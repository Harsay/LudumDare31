package com.harsay.ld31;

import java.util.ArrayList;
import java.util.Arrays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class PlayScreen extends GameScreen {
	
	Player player;
	
	public float time = 0;
	
	public boolean gameLive = false;
	
	public GameSequence sequences;

	public int seqID = 0;
	
	public boolean stop = false;
	
	
	public PlayScreen(MyGame game) {
		super(game);
		float c = (float) 32 / (float) 255;
		backgroundColor.set(c, c, c, 1);
		player = new Player(game, MyGame.WIDTH/2, MyGame.HEIGHT/2, 30);
		sequences = new GameSequence(game);
		game.obstacles = getSequence(seqID);
		game.assets.introSound.play();
		game.assets.music.stop();
	}
	
	public ArrayList<Obstacle> getSequence(int id) {
		return new ArrayList<Obstacle>(Arrays.asList(sequences.getSequence(id)));
	}
	
	public void flashScreen() {
		foregroundColor.set(1, 1, 1, 1);
		Timer.schedule(new Task() {

			@Override
			public void run() {
				foregroundColor.set(0,0,0,0);
			}
			
		}, 0.05f);
	}
	
	public void update(float delta) {
		super.update(delta);
		
		if(stop) return;
		
		if(!gameLive) {
			if(Gdx.input.isKeyJustPressed(GameKeys.UP) || Gdx.input.isKeyJustPressed(GameKeys.DOWN) || Gdx.input.isKeyJustPressed(GameKeys.LEFT) || Gdx.input.isKeyJustPressed(GameKeys.RIGHT)) {
				gameLive = true;
				Stopwatch.restart();
				Stopwatch.start();
				flashScreen();
				game.assets.startSound.play();
				game.assets.music.play();
			} else {
				return;
			}
		}
		
		if(sequences.finished) {
			seqID++;
			sequences.finished = false;
			if(seqID+1 <= sequences.sequences.size()) game.obstacles = getSequence(seqID);
			else {
				foregroundColor.set(1, 1, 1, 1);
				Stopwatch.stop();
				stop = true;
				Timer.schedule(new Task() {
					@Override
					public void run() {
						foregroundColor.set(1,1,1,0);
						game.setScreen(new WinScreen(game));
					}
				}, 0.1f);
			}
		}
		sequences.update();
		Stopwatch.update(delta);
		player.update(delta);
		if(player.alive) {
			for(int i=0; i < game.obstacles.size(); i++) {
				Obstacle o = game.obstacles.get(i);
				o.update(delta);
				if(!o.spawning && !o.killed && player.collision(player.circle, o.rectangle)) {
					endGame();
				}
			}
		}
	}
	
	public void draw(float delta) {
		Gdx.gl.glEnable(GL20.GL_BLEND);
	    Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		shapeRenderer.begin(ShapeType.Filled);
		{
			player.draw(shapeRenderer, spriteBatch);
			for(int i=0; i < game.obstacles.size(); i++) {
				Obstacle o = game.obstacles.get(i);
				o.draw(shapeRenderer, spriteBatch);
			}
		}
		shapeRenderer.end();		
		
		spriteBatch.begin();
		{
			// HUD AND STUFF
			if(!gameLive) {
				game.assets.big.setColor(1, 1, 1, 1);
				game.assets.big.drawMultiLine(spriteBatch, "ULTRA REKTAGON", 130, 800);
				game.assets.medium.draw(spriteBatch, "Press arrows to move.", 500, 400);
				game.assets.small.draw(spriteBatch, "Game made by Harsay for Ludum Dare 31 compo. Press F11 to toggle fullscreen mode.", 100, 36);
			}
			game.assets.medium.draw(spriteBatch, Stopwatch.getString(), 20, MyGame.HEIGHT-20);
		}
		spriteBatch.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
	}
	
	public void endGame() {
		flashScreen();
		player.kill();
		Stopwatch.stop();
		Timer.schedule(new Task() {
			@Override
			public void run() {
				game.obstacles.clear();
				game.setScreen(new PlayScreen(game));
			}
		}, 1.5f);
	}
	
	public void addObstacle(float x, float y,float width, float height, float tts, float ta) {
		game.obstacles.add(new Obstacle(game, x, y, width, height, tts, ta));
	}
	
	public void addObstacle(float x, float y,float width, float height, float tts, Goal[] goals) {
		game.obstacles.add(new Obstacle(game, x, y, width, height, tts, goals));
	}

}
