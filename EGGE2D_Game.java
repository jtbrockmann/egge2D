// egge2D >> Game2D (game loop) \\

package egge2D;

// import the Display2D class
import egge2D.EGGE2D_Display;

// this handles the game loop
public class EGGE2D_Game {
	EGGE2D_Display display;
	
	public EGGE2D_Game(String title) {
		// create the display
		display = new EGGE2D_Display(title);
		
		// this is the game loop
		while(display.isOpen()) {
			
			// this functions draws the frame
			display.updateFrame();
		}
		
		// close the display in the end
		display.destroy();
	}
}
