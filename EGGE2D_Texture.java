package egge2D;

import static org.lwjgl.opengl.GL11.*;

public class EGGE2D_Texture {
	float[][] coordinates = {{1,1},{0,1},{0,0},{1,0}};
	int id;
	int x_tiles;
	int y_tiles;
	int current = 0;
	int interval = 0;
	int intcount = interval;
	
	public EGGE2D_Texture(int i, int xtiles, int ytiles, int steps) {
		id = i;
		x_tiles = xtiles;
		y_tiles = ytiles;
		interval = steps;
	}
	
	public void update() {
		if(x_tiles*y_tiles>1){
			if(intcount>=interval) {
				setFrame(current);
				current = current + 1;
				if(current>(x_tiles*y_tiles)-1) {
					current = 0;
				}
				intcount = 0;
			}
			intcount = intcount+1;
		}
	}
	
	public void getCoord(int n) {
		glTexCoord2f(coordinates[n][0],coordinates[n][1]);
	}
	
	public void startDrawing() {
		//glEnable(GL_TEXTURE_2D);
		glBindTexture(GL_TEXTURE_2D,id);
	}
	
	public void endDrawing() {
		
		//glDisable(GL_TEXTURE_2D);
	}
	
	public void setFrame(int n) {
		// relative size of a single tile
		float x_tile_size = 1/(float)x_tiles;
		float y_tile_size = 1/(float)y_tiles;
		
		int y = 0;
		int count = 0;
		while(count<y_tiles) {
			if(count*x_tiles<=n && n<(count+1)*x_tiles ){
				y = count;
			}
			count = count + 1;
		}
		int x = n-y*x_tiles;
		
		// set up the coordinates
		coordinates[0][0] = x*x_tile_size + x_tile_size;
		coordinates[0][1] = y*y_tile_size + y_tile_size;
		coordinates[1][0] = x*x_tile_size;
		coordinates[1][1] = y*y_tile_size + y_tile_size;
		coordinates[2][0] = x*x_tile_size;
		coordinates[2][1] = y*y_tile_size;
		coordinates[3][0] = x*x_tile_size + x_tile_size;
		coordinates[3][1] = y*y_tile_size;
	}

}
