package com.harsay.ld31;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class GameAssets {
	
	Sound warnSound;
	Sound startSound;
	Sound lostSound;
	Sound introSound;
	Sound rektSound;
	Sound wonSound;
	
	TextureAtlas atlas;
	
	TextureRegion image;
	
	BitmapFont big;
	BitmapFont medium;
	BitmapFont small;
	
	public GameAssets() {
		//atlas = new TextureAtlas(loadFile("game.atlas"));
		
		//image = loadTexture("badlogic");
		
		// Font
 		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("visitor1.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 200;
		big = generator.generateFont(parameter); 
		parameter.size = 72;
		medium = generator.generateFont(parameter);
		parameter.size = 36;
		small = generator.generateFont(parameter);
		generator.dispose();
		
		warnSound = Gdx.audio.newSound(loadFile("warn.wav"));
		startSound = Gdx.audio.newSound(loadFile("start.wav"));
		lostSound = Gdx.audio.newSound(loadFile("lost.wav"));
		introSound = Gdx.audio.newSound(loadFile("intro.ogg"));
		rektSound = Gdx.audio.newSound(loadFile("rekt.ogg"));
		wonSound = Gdx.audio.newSound(loadFile("won.ogg"));

	}
	
	public FileHandle loadFile(String str) {
		return Gdx.files.internal(str);
	}
	
	public AtlasRegion loadTexture(String str) {
		return atlas.findRegion(str);
	}

}
