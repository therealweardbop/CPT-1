package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Obstacle {
	boolean xkey = false;
	boolean ykey = false;
	int x;
	int y;
	int width;
	int height;
	int speedX = 0;
	int speedY = 0;
	String src = "Red.png";
	int counter = 0;
	String lastDir = "up";

	public Obstacle(int x, int y, int width, int height, String src) {
		this.src = src;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void setSource(String source) {
		src = source;
	}

	public void move() {
		if (true) {
			x += speedX;
		}
		if (true) {
			y += speedY;
		}
	}

	public void animate() {

	}

	public void update() {
		if (xkey == false) {
			speedX = 0;
		}
		if (ykey == false) {
			speedY = 0;
		}
		animate();
		if ((speedX == 0 && speedY == 0) || (counter == 22)) {
			counter = 0;
		} else {
			counter++;
		}
		//if (this.src == "wall.png") {
			if (Game.tora.x + Game.Camera.x < this.x + this.width - 3
					&& Game.tora.x + Game.tora.width + Game.Camera.x > this.x + 3) {
				if (Game.tora.y + Game.Camera.y <= this.y + this.height - 2
						&& Game.tora.y + Game.tora.height + Game.Camera.y >= this.y + 10) {
					if (this.src == "wall.png") {
						Game.tora.y += 2;
						Game.tora.up = false;
						Game.tora.loseHealth(1,100);
					}
				}
				if (Game.tora.y + Game.Camera.y <= this.y + this.height - 10
						&& Game.tora.y + Game.Camera.y + Game.tora.height >= this.y + 2) {
					if (this.src == "wall.png") {
						Game.tora.y -= 2;
						Game.tora.down = false;
						Game.tora.loseHealth(1,100);
					}
				}
			}
			if (Game.tora.y + Game.Camera.y < this.y + this.height - 3
					&& Game.tora.y + Game.tora.height + Game.Camera.y > this.y + 3) {
				if (Game.tora.x + Game.Camera.x <= this.x + this.width - 2
						&& Game.tora.x + Game.Camera.x + Game.tora.width >= this.x + 10) {
					if (this.src == "wall.png") {
						Game.tora.x += 2;
						Game.tora.left = false;
						Game.tora.loseHealth(1,100);
					}
				}
				if (Game.tora.x + Game.Camera.x <= this.x + this.width - 10
						&& Game.tora.x + Game.Camera.x + Game.tora.width >= this.x + 2) {
					if (this.src == "wall.png") {
						Game.tora.x -= 2;
						Game.tora.right = false;
						Game.tora.loseHealth(1,100);
					}
				}
	//		}
		}
	}

	public void paint(Graphics2D g) {
		ImageIcon picture = new ImageIcon(src);
		Image MyCharacter = picture.getImage();
		g.drawImage(MyCharacter, x, y, width, height, null);
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xkey = false;
		} else {
			ykey = false;

		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			xkey = true;
			speedX = 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xkey = true;
			speedX = -1;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			ykey = true;
			speedY = 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			ykey = true;
			speedY = -1;
		}
	}
}
