package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
	      cfg.title = "my-gdx-game";
	      cfg.useGL30 = false;
	      cfg.width = 1280;
	      cfg.height = 720;

	      new LwjglApplication(new MyGdxGame(), cfg);
	}
}
