package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	Ball b;
	
	Map map;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		map = new Map();
		b = new Ball(100, 100);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//b.update();
		if(Gdx.input.justTouched())
			map.generate();
		
		batch.begin();
		
		map.render(batch);
		//b.draw(batch);
		
		batch.end();
		
	}
}
