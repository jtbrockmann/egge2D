package egge2D;

import java.util.Arrays;
import egge2D.EGGE2D_Texture;
import egge2D.EGGE2D_Image;
import egge2D.EGGE2D_SolidColor;
import org.lwjgl.input.Keyboard;
import egge2D.EGGE2D_GameScene;

public class DefaultScene extends EGGE2D_GameScene{
	
	public void update(int width, int height) {
		if(init()) {
			EGGE2D_Image smiley = new EGGE2D_Image("smiley");
			EGGE2D_Image anim = new EGGE2D_Image("animated");
			EGGE2D_Texture smiley_tex = new EGGE2D_Texture(smiley.getID(), 1, 1, 0);
			EGGE2D_Texture anim_tex = new EGGE2D_Texture(anim.getID(), 4, 4, 5);
			EGGE2D_SolidColor font = new EGGE2D_SolidColor(1,1,1,1);
			
			int size = 8;
			int x = width/2;
			int y = height/2;
			int[][] lines = {
					{0,1,2,3,4,7,8,10,13,14,16,18,19,20,21,22,28,29,30,31,33,34,35,36},
					{0,6,9,10,12,15,16,18,29,33,37},
					{0,1,2,6,12,18,19,20,30,33,37},
					{0,6,10,12,16,18,28,31,33,37},
					{0,1,2,3,4,7,8,9,13,14,15,18,19,20,21,22,29,30,33,34,35,36}};
			for(int[] q: lines) {
				int qint = Arrays.asList(lines).indexOf(q);
				for(int p: q) {
					addObject("_"+p+"_"+qint, new EGGE2D_GameObject(font));
					getObject("_"+p+"_"+qint).absPosition(p*size+x-18*size, qint*size+y-2*4);
					getObject("_"+p+"_"+qint).absScale(size, size);
					getObject("_"+p+"_"+qint).setZIndex(1);
				}
			}
			addObject("cursor", new EGGE2D_GameObject(anim_tex));
			getObject("cursor").absPosition(width/2, height/2-8*size*2);
			getObject("cursor").absScale(128, 128);	
			getObject("cursor").setZIndex(0);
			
			addObject("hans", new EGGE2D_GameObject(smiley_tex));
			getObject("hans").absPosition(width/2+56, height/2-8*size*2);
			getObject("hans").absScale(128, 128);	
			getObject("hans").setZIndex(2);
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			getObject("cursor").relPosition(0,1);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			getObject("cursor").relPosition(0,-1);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			getObject("cursor").relPosition(-1,0);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			getObject("cursor").relPosition(1,0);
		}
		
		
		
	}
}
