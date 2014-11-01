// egge2D >> Display2D (LWJGL Display) \\

package egge2D;

// import LWJGL classes
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

// import OpenGL classes
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

// creates a LWJGL display
public class EGGE2D_Display {
	public EGGE2D_Display(String title) {

		// create window with title
		try {
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setTitle(title);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		// initialize OpenGL
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective((float) 30, 640f / 480f, 0.0001f, 100);
		glMatrixMode(GL_MODELVIEW);
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
