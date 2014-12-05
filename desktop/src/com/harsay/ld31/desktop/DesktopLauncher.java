package com.harsay.ld31.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;
import com.harsay.ld31.MyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Ludum Dare 31";
		config.width = 1920/2;
		config.height = 1080/2;
		
        Settings settings = new Settings();
        settings.maxWidth = 512;
        settings.maxHeight = 512;
        TexturePacker.process(settings, "../core/assets/textures/", "../core/assets/", "game");
        
		new LwjglApplication(new MyGame(), config);
	}
}
