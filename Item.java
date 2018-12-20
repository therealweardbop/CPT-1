package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Item {
	int x;
	int y;
	int width;
	int height;
	String type;
	String src = "Red.png";

	public Item(int x, int y, int width, int height, String type, String src) {
		this.src = src;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.type = type;
	}

	public void setSource(String source) {
		src = source;
	}

	public void update() {
		if (Game.tora.x + Game.tora.width >= this.x && Game.tora.x <= this.x + this.width
				&& Game.tora.y + Game.tora.height + Game.Camera.y >= this.y
				&& Game.tora.y + Game.Camera.y <= this.y + this.height) {
			if (this.type == "bigTreasure") {
				Game.tora.bigTreasure = true;
				Game.treasures.remove(this);
				Game.bigChest.src = "yellow.png";
				return;
			}
			if (this.type == "smallTreasure") {
				Game.treasures.remove(this);
				Game.collectedTreasure.add(new Character((Game.collectedTreasures % 2) * 34 + 599,
						(Game.collectedTreasures - Game.collectedTreasures % 2) * 17 + 266, 32, 32, "yellow.png","blank"));
				Game.collectedTreasures++;
				System.out.println("item!");
			}
		}

	}

	public void paint(Graphics2D g) {
		ImageIcon picture = new ImageIcon(src);
		Image MyCharacter = picture.getImage();
		g.drawImage(MyCharacter, x, y, width, height, null);
	}
}
