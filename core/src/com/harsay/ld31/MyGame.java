package com.harsay.ld31;

import java.util.ArrayList;

import com.badlogic.gdx.Game;

public class MyGame extends Game {
	
	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1080;
	
	public GameAssets assets;
	
	public ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

	
	@Override
	public void create() {
		assets = new GameAssets();
		setScreen(new PlayScreen(this));
	}
	
}
