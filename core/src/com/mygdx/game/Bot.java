package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bot {

	Vector2 position;
	Texture texture;
	int tileSize;
	
	public Bot(int tileSize, float x, float y) {
		this.tileSize = tileSize;
		texture = new Texture("npc.png");
		position = new Vector2(x, y);
	}

	public void render(SpriteBatch batch) {
		batch.draw(texture, position.x*tileSize, position.y*tileSize, tileSize, tileSize);
	}
}
