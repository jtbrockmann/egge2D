package egge2D;

import egge2D.EGGE2D_GameObject;

import java.util.HashMap;
import java.util.Map;

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

}
