package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Tile.Type;

public class Map {

	int tileSize = 16;
	
	private int mapWidth = (int) Math.ceil((double) Gdx.graphics.getWidth()/(double) tileSize);
	private int mapHeight = (int) Math.ceil((double) Gdx.graphics.getHeight()/(double) tileSize);
	
	private Tile map[][] = new Tile[mapWidth][mapHeight];
	
	float wallChance;
	
	public Map() {
		generate();
		
		System.out.println(mapHeight);
	}

	public void render(SpriteBatch batch) {
		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapHeight; j++) {
				map[i][j].render(batch);
			}
		}
	}
	
	//Map Generation methods
	public void generate() {
		wallChance = .4f;
		
		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapHeight; j++) {
				map[i][j] = new Tile(i, j, this);
				map[i][j].setType(Math.random() < wallChance ? Type.WALL : Type.FLOOR);
			}
		}
		smoothen();
		smoothen();
	}
	
	public void smoothen() {
		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapHeight; j++) {
				map[i][j].initialize();
			}
		}
	}
	
	public void clean() {
		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapHeight; j++) {
				map[i][j].cleanup();
			}
		}
	}
	
	//Get Neighbor Methods
	public int getAllNeighborWallCount(float xPos, float yPos) {
		int x = (int)xPos;
		int y = (int)yPos;
		
		int neighborWalls = 0;
		
		 for( int row = x - 1; row <= x + 1; row++) {
	            for(int col =  y -1;  col <= y + 1; col++) {
	                if( !(x == row &&  y == col) && row >= 0 && col >= 0 && row < mapWidth && col < mapHeight) {
	                    if(map[row][col].getType() == Type.WALL)
	                    	neighborWalls++;
	                }
	            }
	        }
		
		return neighborWalls;
	}
	
	public int getDirectNeighborWallCount(float xPos, float yPos) {
		int x = (int)xPos;
		int y = (int)yPos;
		
		int neighborWalls = 0;
		
		 for( int row = x - 1; row <= x + 1; row++) {
	            for(int col =  y -1;  col <= y + 1; col++) {
	                if(!(x == row &&  y == col) && !(x == row-1 &&  y == col-1) && !(x == row-1 &&  y == col+1) && !(x == row+1 &&  y == col-1) && !(x == row-1 &&  y == col+1) &&
	                		row >= 0 && col >= 0 && row < mapWidth && col < mapHeight) {
	                    if(map[row][col].getType() == Type.WALL)
	                    	neighborWalls++;
	                }
	            }
	        }
		
		return neighborWalls;
	}
	//-----------------------------------------------
	
	
	public int getMapWidth() {
		return mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}

}
