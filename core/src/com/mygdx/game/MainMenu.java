package com.mygdx.game;

import com.badlogic.gdx.Screen;

public class MainMenu implements Screen {

	MyGdxGame game;
	
	public MainMenu(MyGdxGame myGdxGame) {
		game = myGdxGame;
	}

	@Override
	public void render(float delta) {
		game.setScreen(new GameScreen(game));
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
