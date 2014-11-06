// settings for LWJGL display creation \\

package egge2D;

public class EGGE2D_DisplaySettings {
	
	// main settings
	public int winx = 640;
	public int winy = 360;
	
	public int oglx = 640;
	public int ogly = 360;
	public int zidx = 128;
	
	public String title = "egge2D - Extendgears Game Engine";
	
	// functions to set up settings
	public void setWindowSize(int x, int y) {
		winx = x; winy = y;
	}
	
	public void setOpenGLSize(int x, int y) {
		oglx = x; ogly = y;
	}
	
	public void setZIndex(int z) {
		zidx = z;
	}
	
	public void setTitle(String t) {
		title = t;
	}

}
