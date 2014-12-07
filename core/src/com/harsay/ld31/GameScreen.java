package com.harsay.ld31;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {
	
	protected MyGame game;
	
	protected SpriteBatch spriteBatch;
	protected ShapeRenderer shapeRenderer;
	protected OrthographicCamera camera;
	protected Viewport viewport;
	
	protected Color clearColor; 
	protected Color backgroundColor; 
	protected Color foregroundColor;
		
	public GameScreen(MyGame game) {
		this.game = game;
		
		spriteBatch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		camera = new OrthographicCamera();
		viewport = new FitViewport(MyGame.WIDTH, MyGame.HEIGHT, camera);
		camera.setToOrtho(false, MyGame.WIDTH, MyGame.HEIGHT);		
		
		clearColor = new Color(0, 0, 0, 1);
		backgroundColor = new Color(1, 1, 1, 1);
		foregroundColor = new Color(0, 0, 0, 0);
	}
	
	public void update(float delta) {
		if(Gdx.input.isKeyJustPressed(GameKeys.TOGGLEFULLSCREEN)) {
			if(Gdx.graphics.isFullscreen()) {
				Gdx.graphics.setDisplayMode(1920/2, 1080/2, false);
			} else {
				Gdx.graphics.setDisplayMode(Gdx.graphics.getDesktopDisplayMode().width, Gdx.graphics.getDesktopDisplayMode().height, true);
			}
		}
		
		if(Gdx.input.isKeyJustPressed(GameKeys.TOGGLEMUSIC)) {
			if(game.assets.music.getVolume() != 0) {
				game.assets.music.setVolume(0);
			}
			else {
				game.assets.music.setVolume(0.1f);
			}
		}
	}
	
	public void draw(float delta) {

	}

	@Override
	public void render(float delta) {
		update(delta);
		camera.update();
		Gdx.gl.glClearColor(clearColor.r, clearColor.g, clearColor.b, clearColor.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.setProjectionMatrix(camera.combined);
		shapeRenderer.setProjectionMatrix(camera.combined);
		
		renderColoredRectangle(backgroundColor);
		draw(delta);
		renderColoredRectangle(foregroundColor);
	}
	
	protected void renderColoredRectangle(Color color) {
		Gdx.gl.glEnable(GL20.GL_BLEND);
	    Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(color);
		shapeRenderer.rect(0, 0, MyGame.WIDTH, MyGame.HEIGHT); // TODO: width and height from world
		shapeRenderer.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}

	@Override
	public void show() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		//foregroundColor.set(0, 0, 0, 0.8f);
		
	}

	@Override
	public void resume() {
		//foregroundColor.set(0, 0, 0, 0);		
	}

	@Override
	public void dispose() {
		System.out.println("Dispose");
		
	}

}
