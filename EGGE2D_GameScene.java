package egge2D;

import egge2D.EGGE2D_GameObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.lwjgl.input.*;

public class EGGE2D_GameScene {
	// save the game object list in a hash map
	public static Map<String, EGGE2D_GameObject> objects = new HashMap<String, EGGE2D_GameObject>();
	
	public void draw() {
		for(String key: objects.keySet()) {
			objects.get(key).draw();
		}
	}
	
	public void update(int width, int height) {
		// should be overwritten by extending class
		drawLogo(width, height);
	}
	
	public static void addObject(String u_name, EGGE2D_GameObject obj) {
		objects.put(u_name, obj);
	}
	
	public EGGE2D_GameObject getObject(String name) {
		return objects.get(name);
	}
	
	public static void delObject(String name) {
		objects.remove(name);
	}
	
	private void drawLogo(int width, int height) {
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
			addObject("_default", new EGGE2D_GameObject());
			getObject("_default").absPosition(width/2, height/2-8*size*2);
			
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			getObject("_default").relPosition(0, 2);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			getObject("_default").relPosition(0, -2);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			getObject("_default").relPosition(-2, 0);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			getObject("_default").relPosition(2, 0);
		}
	}

}
