package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Tile.Type;

public class Player {

	Vector2 position;
	float speed = .5f;
	
	final int tileSize;
	
	private Texture texture;
	
	int width, height;
	
	float destinationX, destinationY;
	
	Map map;
	Tile tileMap[][];
	
	public Player(Map map) {
		this.map = map;
		tileSize = map.tileSize;
		this.tileMap = map.getMap();
		position = new Vector2();
		texture = new Texture("player.png");
		width = texture.getWidth();
		height = texture.getHeight();
		
		destinationX = position.x + 0.1f;
		destinationY = position.y + 0.1f;
		
		searchSpawnPoint();
	}

	public void searchSpawnPoint() {
		position.x = map.getMapWidth()/2;
		position.y = map.getMapHeight()/2;
		while(tileMap[(int) position.x][(int) position.y].getType() == Type.WALL) {
			
			if(tileMap[(int) position.x][(int) position.y].getType() == Type.WALL)
				position.x++;
			
			if(tileMap[(int) position.x][(int) position.y].getType() == Type.WALL)
				position.y++;
			
			System.out.println("done");
		}
	}
	
	public boolean collision(char key) {
		int x = (int)position.x;
		int y = (int)position.y;
		
		
		if(key == 'w' && y+1 == map.getMapHeight() || key == 'w' && tileMap[x][y+1].getType() == Type.WALL)
			return true;
		if(key == 's' && y-1 == -1 || key == 's' && tileMap[x][y-1].getType() == Type.WALL)
			return true;
		if(key == 'a' && x-1 == -1 || key == 'a' && tileMap[x-1][y].getType() == Type.WALL)
			return true;
		if(key == 'd' && x+1 == map.getMapWidth() || key == 'd' && tileMap[x+1][y].getType() == Type.WALL)
			return true;
		
		return false;
	}

	public void render(SpriteBatch batch) {
		batch.draw(texture, position.x*tileSize, position.y*tileSize, tileSize, tileSize);
	}
	
	public void update() {
//		if(Gdx.input.isTouched()) {
//			destinationX = (Gdx.input.getX() - width/2)/tileSize;
//			destinationY = (Gdx.graphics.getHeight() - Gdx.input.getY() - height/2)/tileSize; 
//		}
//			
//		position.x += (destinationX - position.x)*(speed/Math.sqrt(((destinationX - position.x)*(destinationX - position.x))+((destinationY - position.y)*(destinationY - position.y))));
//		position.y += (destinationY - position.y)*(speed/Math.sqrt(((destinationX - position.x)*(destinationX - position.x))+((destinationY - position.y)*(destinationY - position.y))));	
//		
//		System.out.println("X:" + destinationX + " || Y:" + destinationY);
		
		Gdx.input.setInputProcessor(new InputAdapter () {
			   public boolean keyTyped(char key) {
				   if(!collision(key)) {
					   if(key == 'w')
						   position.y++;
					   
					   else if(key == 's')
						   position.y--;
					   
					   else if(key == 'd')
						   position.x++;
					   
					   else if(key == 'a')
						   position.x--;
				   }
				   
				   return true;
			   }
			});
	}
}
