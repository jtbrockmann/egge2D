// egge2D >> Display2D (LWJGL Display) \\

package egge2D;

// import internal functions
import egge2D.EGGE2D_DisplaySettings;

// import LWJGL classes
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

// import OpenGL classes
import static org.lwjgl.opengl.GL11.*;

// creates a LWJGL display
public class EGGE2D_Display {
	
	// constant display settings
	int winx;
	int winy;
	int oglx;
	int ogly;
	int zidx;
	String title;
	
	public EGGE2D_Display(EGGE2D_DisplaySettings Settings) {
		// get settings
		winx = Settings.winx;
		winy = Settings.winy;
		oglx = Settings.oglx;
		ogly = Settings.ogly;
		zidx = Settings.zidx;
		title = Settings.title;

		// create window with title
		try {
			Display.setDisplayMode(new DisplayMode(winx, winy));
			Display.setTitle(title);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		// initialize OpenGL
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glViewport(0, 0, winx, winy);
		glOrtho(0 ,oglx ,0 ,ogly ,0 ,zidx);
	}

	// function draw a frame
	public void updateFrame() {
		
		// clear OpenGL buffer
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		// draw frame
		/* !!! TODO !!!
		 * EGGE2D_Scene -> update()
		 * EGGE2D_GameObject -> update */

		// update the display
		Display.update();
	}

	// requests whether the window is open
	public boolean isOpen() {
		return !Display.isCloseRequested();
	}

	// destroys the LWJGL display
	public void destroy() {
		Display.destroy();
	}

}
