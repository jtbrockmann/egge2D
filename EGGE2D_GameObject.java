package egge2D;

import static org.lwjgl.opengl.GL11.*;

public class EGGE2D_GameObject {
	int posx = 0;
	int posy = 0;
	int sclx = 16;
	int scly = 16;
	int zidx = 0;
	
	public void draw() {
		glBegin(GL_QUADS);
			glVertex3f(posx-sclx, posy-scly, 0);
			glVertex3f(posx+sclx, posy-scly, 0);
			glVertex3f(posx+sclx, posy+scly, 0);
			glVertex3f(posx-sclx, posy+scly, 0);
		glEnd();
	}
	
	// absolute position
	public void absPosition(int x, int y) {
		posx = x; posy = y;
	}
	// absolute scale
	public void absScale(int x, int y) {
		sclx = x; scly = y;
	}
	// relative position
	public void relPosition(int x, int y) {
		posx = posx + x; posy = posy + y;
	}
	// relative scale
	public void relScale(int x, int y) {
		sclx = sclx + x; scly = scly + y;
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
		return sclx;
	}
	public int getScaleY() {
		return scly;
	}
	// set z index
	public void setZIndex(int z) {
		zidx = z;
	}

}
