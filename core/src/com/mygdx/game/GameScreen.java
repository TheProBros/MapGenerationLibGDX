package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen {

	SpriteBatch batch;
	BitmapFont font;
	
	MyGdxGame game;
	
	Player p;
	Map map;
	
	public GameScreen(MyGdxGame myGdxGame) {
		game = myGdxGame;
		
		batch = new SpriteBatch();
		font = new BitmapFont();
		
		p = new Player(1, 1);
		map = new Map();
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		batch.begin();
		map.render(batch);
		font.draw(batch, "" + Gdx.graphics.getFramesPerSecond(), 100, 100);
		System.out.println("lol");
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
