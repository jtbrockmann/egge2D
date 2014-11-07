package egge2D;

import egge2D.EGGE2D_Texture;
import static org.lwjgl.opengl.GL11.*;

public class EGGE2D_SolidColor extends EGGE2D_Texture {
	float rv; float gv; float bv; float av;
	
	EGGE2D_SolidColor(float r, float g, float b, float a) {
		super(0,1,1,0);
		rv = r; gv = g; bv = b; av = a;
	}
	
	public void update() {
		// do nothing (overwrite)
	}
	
	public void getCoord(int n) {
		// do nothing (overwrite)
	}
	
	public void startDrawing() {
		glDisable(GL_TEXTURE_2D);
		glColor4f(rv,gv,bv,av);
	}
	
	public void endDrawing() {
		glEnable(GL_TEXTURE_2D);
	}
	
	public void setFrame(int n) {
		// do nothing (overwrite)
	}
}
