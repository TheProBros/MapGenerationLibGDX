package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen {

	OrthographicCamera cam;
	SpriteBatch batch;
	BitmapFont font;
	
	MyGdxGame game;
	
	private Texture background;
	
	Player p;
	Map map;
	
	Bot bot;
	
	public GameScreen(MyGdxGame myGdxGame) {
		game = myGdxGame;
		
		background = new Texture("background.png");
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false);
		batch = new SpriteBatch();
		font = new BitmapFont();
		
		map = new Map();
		p = new Player(map, cam);
		bot = new Bot(map.tileSize, p.position.x, p.position.y);
		cam.position.set(p.position.x*map.tileSize, p.position.y*map.tileSize, 0);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0.2f, 0.2f, 1);
	    Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
	    batch.setProjectionMatrix(cam.combined);
	    cam.update();
	      
	    p.update();
	    
		batch.begin();
		batch.draw(background, 0, 0, map.getMapWidth()*map.tileSize, map.getMapHeight()*map.tileSize);
		map.render(batch);
		bot.render(batch);
		p.render(batch);
		
		font.draw(batch, "" + Gdx.graphics.getFramesPerSecond(), p.position.x*map.tileSize - 250, p.position.y*map.tileSize-250);
		batch.end();
		
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
