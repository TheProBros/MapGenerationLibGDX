package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Tile {

	public enum Type {
		WALL, FLOOR
	}
	//Variable initalization
	private static Texture wall = new Texture("wall.png");
	private static Texture floor = new Texture("floor.png");
	
	private Texture texture;
	
	public Vector2 position;
	
	public final int tileSize;
	private Type type;
	
	Map map;
	
	//Constructor
	public Tile(int x, int y, Map map) {
		tileSize = map.tileSize;
		this.map = map;
		
		position = new Vector2(x, y);
	}

	//Methods
	public void render(SpriteBatch batch) {
		batch.draw(texture, position.x*tileSize, position.y*tileSize, tileSize, tileSize);
	}
	
	public void initialize() {
		if(type == Type.WALL) {
			if(map.getAllNeighborWallCount(position.x, position.y) < 3) {
				setType(Type.FLOOR);
			}
		} else if(type == Type.FLOOR) {
			if(map.getAllNeighborWallCount(position.x, position.y) > 4) {
				setType(Type.WALL);
			}
		}
	}
	
	public void cleanup() {
		if(type == Type.FLOOR && map.getDirectNeighborWallCount(position.x, position.y) == 4) {
			setType(Type.WALL);
		}
	}

	//Getters Setters
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
		
		if(type==Type.WALL)
			texture = wall;
		else
			texture = floor;
	}
}
