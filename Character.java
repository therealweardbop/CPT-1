package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Character {
	boolean xkey = false;
	boolean ykey = false;
	String xdir;
	String ydir;
	int x;
	int y;
	boolean up = true;
	boolean down = true;
	boolean left = true;
	boolean right = true;
	boolean moving = true;
	int width;
	int height;
	int speedX = 0;
	int speedY = 0;
	String src = "Red.png";
	String type = "blank";
	int counter = 0;
	String lastDir = "up";
	boolean bigTreasure = false;
	int health = 10;
	int invincible = 0;

	public Character(int x, int y, int width, int height, String src, String type) {
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

	public void move() {
		if ((this.x - 2 >= 0 && speedX < 0) || (this.x + this.width + 2 <= 512 && speedX > 0)) {
			if ((left == true && xdir == "left") || (right == true && xdir == "right")) {
				x += speedX;
			}
		}
		if ((this.y - 2 >= 0 && speedY < 0) || (this.y + this.height + 2 <= Game.frameheight && speedY > 0)) {
			if ((up == true && ydir == "up") || (down == true && ydir == "down")) {
				y += speedY;
			}
		}
	}

	public void animate() {
		if (this.type == "character") {
			if (this.invincible % 10 > 7) {
				this.src = "yellow.png";
			} else {
				this.src = "tora1.png";
			}
		}
	}

	public void loseHealth(int healthAmount, int invincibleAmount) {
		if (this.invincible == 0) {
			this.health -= healthAmount;
			this.invincible += invincibleAmount;
		}
	}

	public void update() {
		if (this.invincible > 0) {
			this.invincible--;
		}
		if (this.y + this.height > Game.frameheight) {
			this.y = Game.frameheight - this.height;
		}
		if (this.y < 0 && moving == true) {
			this.y = 0;
		}
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
	}

	public void paint(Graphics2D g) {
		ImageIcon picture = new ImageIcon(src);
		Image MyCharacter = picture.getImage();
		g.drawImage(MyCharacter, x, y, width, height, null);
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT && xdir == "left") {
			xkey = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && xdir == "right") {
			xkey = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP && ydir == "up") {
			ykey = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN && ydir == "down") {
			ykey = false;
		}
	}

	public void keyPressed(KeyEvent e) {
		if (this.moving == true) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT && left == true) {
				xkey = true;
				xdir = "left";
				speedX = -3;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT && right == true) {
				xkey = true;
				xdir = "right";
				speedX = 3;
			}
			if (e.getKeyCode() == KeyEvent.VK_UP && up == true) {
				ykey = true;
				ydir = "up";
				speedY = -3;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN && down == true) {
				ykey = true;
				ydir = "down";
				speedY = 3;
			}
		}
	}
}
