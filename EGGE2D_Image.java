package egge2D;

import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class EGGE2D_Image {
	Texture texture;
	
	public EGGE2D_Image(String name) {
		try {
			InputStream resource = ResourceLoader.getResourceAsStream("res/"+name+".png");
			texture = TextureLoader.getTexture("PNG", resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getID() {
		return texture.getTextureID();
	}
}