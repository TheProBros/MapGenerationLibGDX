package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen {

	SpriteBatch batch;
	BitmapFont font;
	
	MyGdxGame game;
	
	private Texture background;
	
	Player p;
	Map map;
	
	public GameScreen(MyGdxGame myGdxGame) {
		game = myGdxGame;
		
		background = new Texture("background.png");
		
		batch = new SpriteBatch();
		font = new BitmapFont();
		
		map = new Map();
		p = new Player(map);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0.2f, 0.2f, 1);
	    Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
	      
	      
		batch.begin();
		batch.draw(background, 0, 0);
		map.render(batch);
		p.render(batch);
		
		font.draw(batch, "" + Gdx.graphics.getFramesPerSecond(), 100, 100);
		batch.end();
		
		p.update();
		
		if(Gdx.input.justTouched()) {
			map.generate();
			p.searchSpawnPoint();
		}
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
