package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Ball {

	Vector2 position;
	float speed = 5;
	
	private Texture texture;
	
	int width, height;
	
	float destinationX, destinationY;
	
	
	public Ball(int x, int y) {
		position = new Vector2(x, y);
		texture = new Texture("player.png");
		width = texture.getWidth();
		height = texture.getHeight();
		
		destinationX = position.x + 0.1f;
		destinationY = position.y + 0.1f;
	}

	public void draw(SpriteBatch batch) {
		batch.draw(texture, position.x, position.y, 16, 16);
	}
	
	public void update() {
		if(Gdx.input.isTouched()) {
			destinationX = Gdx.input.getX() - width/2;
			destinationY = Gdx.graphics.getHeight() - Gdx.input.getY() - height/2; 
		}
			
		position.x += (destinationX - position.x)*(speed/Math.sqrt(((destinationX - position.x)*(destinationX - position.x))+((destinationY - position.y)*(destinationY - position.y))));
		position.y += (destinationY - position.y)*(speed/Math.sqrt(((destinationX - position.x)*(destinationX - position.x))+((destinationY - position.y)*(destinationY - position.y))));	
		
		System.out.println("X:" + destinationX + " || Y:" + destinationY);
	}
}