package com.harsay.ld31;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class GameAssets {
	
	TextureAtlas atlas;
	
	TextureRegion image;
	
	BitmapFont big;
	BitmapFont medium;
	BitmapFont small;
	
	public GameAssets() {
		atlas = new TextureAtlas(loadFile("game.atlas"));
		
		image = loadTexture("badlogic");
		
		// Font
 		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("visitor1.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 200;
		big = generator.generateFont(parameter); 
		parameter.size = 36;
		medium = generator.generateFont(parameter);
		parameter.size = 18;
		small = generator.generateFont(parameter);
		generator.dispose();
	}
	
	public FileHandle loadFile(String str) {
		return Gdx.files.internal(str);
	}
	
	public AtlasRegion loadTexture(String str) {
		return atlas.findRegion(str);
	}

}
