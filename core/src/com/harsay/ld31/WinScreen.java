package com.harsay.ld31;

import com.badlogic.gdx.Gdx;

public class WinScreen extends GameScreen {

	public WinScreen(MyGame game) {
		super(game);
		float c = (float) 32 / (float) 255;
		backgroundColor.set(c, c, c, 1);
		game.assets.wonSound.play();
	}
	
	public void update(float delta) {
		super.update(delta);
		if(Gdx.input.isKeyJustPressed(GameKeys.UP) || Gdx.input.isKeyJustPressed(GameKeys.DOWN) || Gdx.input.isKeyJustPressed(GameKeys.LEFT) || Gdx.input.isKeyJustPressed(GameKeys.RIGHT)) {
			game.setScreen(new PlayScreen(game));
		}
	}
	
	public void draw(float delta) {
		super.draw(delta);
		spriteBatch.begin();
		{
			game.assets.big.setColor(1, 1, 1, 1);
			game.assets.big.drawMultiLine(spriteBatch, "YOU WON!", 500, 800);
			game.assets.medium.draw(spriteBatch, "Thanks for playing! Press arrows to continue.", 50, 400);
			game.assets.small.draw(spriteBatch, "Game made by Harsay for Ludum Dare 31 compo. Press F11 to toggle fullscreen mode.", 100, 36);
		}
		spriteBatch.end();
	}

}
