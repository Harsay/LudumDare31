package com.harsay.ld31;

import com.badlogic.gdx.Game;

public class MyGame extends Game {
	
	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1080;
	
	
	@Override
	public void create() {
		setScreen(new GameScreen(this));
	}
	
}
