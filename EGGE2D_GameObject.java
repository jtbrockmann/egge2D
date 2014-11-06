package egge2D;

import static org.lwjgl.opengl.GL11.*;

public class EGGE2D_GameObject {
	int posx = 0;
	int posy = 0;
	int sclx = 16;
	int scly = 16;
	
	public void draw() {
		glBegin(GL_QUADS);
			glVertex3f(posx-sclx, posy-scly, 0);
			glVertex3f(posx+sclx, posy-scly, 0);
			glVertex3f(posx+sclx, posy+scly, 0);
			glVertex3f(posx-sclx, posy+scly, 0);
		glEnd();
	}

}
