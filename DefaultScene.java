package egge2D;

import java.util.Arrays;
import org.lwjgl.input.Keyboard;
import egge2D.EGGE2D_GameScene;

public class DefaultScene extends EGGE2D_GameScene{
	public DefaultScene() {
		
	}
	public void update(int width, int height) {
		if(objects.size()==0) {
			int size = 4;
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
					addObject("_"+p+"_"+qint, new EGGE2D_GameObject());
					getObject("_"+p+"_"+qint).absPosition(p*size*2+x-18*2*size, qint*size*2+y-5*4);
					getObject("_"+p+"_"+qint).absScale(size, size);
				}
			}
			addObject("cursor", new EGGE2D_GameObject());
			getObject("cursor").absPosition(width/2, height/2-8*size*2);
			getObject("cursor").absScale(2, 2);			
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
