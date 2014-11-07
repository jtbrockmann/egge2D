package egge2D;

import static org.lwjgl.opengl.GL11.*;
import egge2D.EGGE2D_Texture;

public class EGGE2D_GameObject {
	EGGE2D_Texture texture;
	int posx = 0;
	int posy = 0;
	int sclx = 16;
	int scly = 16;
	int zidx = 0;
	
	public EGGE2D_GameObject(EGGE2D_Texture t) {
		texture = t;
	}
	
	public void draw() {
		texture.update();
		texture.startDrawing();
		glBegin(GL_QUADS);
			texture.getCoord(0); glVertex3f(posx-sclx, posy-scly, -zidx);
			texture.getCoord(1); glVertex3f(posx+sclx, posy-scly, -zidx);
			texture.getCoord(2); glVertex3f(posx+sclx, posy+scly, -zidx);
			texture.getCoord(3); glVertex3f(posx-sclx, posy+scly, -zidx);
		glEnd();
		texture.endDrawing();
	}
	
	// absolute position
	public void absPosition(int x, int y) {
		posx = x; posy = y;
	}
	// absolute scale
	public void absScale(int x, int y) {
		sclx = x/2; scly = y/2;
	}
	// relative position
	public void relPosition(int x, int y) {
		posx = posx + x; posy = posy + y;
	}
	// relative scale
	public void relScale(int x, int y) {
		sclx = sclx + x/2; scly = scly + y/2;
	}
	// get position
	public int getPositionX() {
		return posx;
	}
	public int getPositionY() {
		return posy;
	}
	// get scale
	public int getScaleX() {
		return sclx*2;
	}
	public int getScaleY() {
		return scly*2;
	}
	// set z index
	public void setZIndex(int z) {
		zidx = z;
	}

}
