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
	String type = "blank";
	int counter = 0;
	String lastDir = "up";
	int direction = 2;
	String movetype;

	public Obstacle(int x, int y, int width, int height, String src, String movetype, String type) {
		this.src = src;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.type = type;
		this.movetype = movetype;
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
		if (this.movetype == "movingenemy") {
			this.x += direction;
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
		if (Game.tora.x + Game.Camera.x < this.x + this.width - 3
				&& Game.tora.x + Game.tora.width + Game.Camera.x > this.x + 3) {
			if (Game.tora.y + Game.Camera.y <= this.y + this.height - 2
					&& Game.tora.y + Game.tora.height + Game.Camera.y >= this.y + 10) {
				if (this.type == "wall") {
					Game.tora.y += 3;
					Game.tora.up = false;
					Game.tora.loseHealth(2, 100);
				}
				if (this.type == "urchon") {
					Game.tora.loseHealth(10, 100);
				}
				if (this.type == "aligo") {
					Game.tora.loseHealth(4, 100);
				}
				if (this.type == "turtle") {
					Game.tora.loseHealth(3, 100);
				}
			}
			if (Game.tora.y + Game.Camera.y <= this.y + this.height - 10
					&& Game.tora.y + Game.Camera.y + Game.tora.height >= this.y + 2) {
				if (this.type == "wall") {
					Game.tora.y -= 3;
					Game.tora.down = false;
					Game.tora.loseHealth(1, 100);
				}
				if (this.type == "urchon") {
					Game.tora.loseHealth(10, 100);
				}
				if (this.type == "aligo") {
					Game.tora.loseHealth(3, 100);
				}
				if (this.type == "turtle") {
					Game.tora.loseHealth(3, 100);
				}
			}
		}
		if (Game.tora.y + Game.Camera.y < this.y + this.height - 3
				&& Game.tora.y + Game.tora.height + Game.Camera.y > this.y + 3) {
			if (Game.tora.x + Game.Camera.x <= this.x + this.width - 2
					&& Game.tora.x + Game.Camera.x + Game.tora.width >= this.x + 10) {
				if (this.type == "wall") {
					Game.tora.x += 3;
					Game.tora.left = false;
					Game.tora.loseHealth(1, 100);
				}
				if (this.type == "urchon") {
					Game.tora.loseHealth(10, 100);
				}
				if (this.type == "aligo") {
					Game.tora.loseHealth(3, 100);
				}
				if (this.type == "turtle") {
					Game.tora.loseHealth(3, 100);
				}
			}
			if (Game.tora.x + Game.Camera.x <= this.x + this.width - 10
					&& Game.tora.x + Game.Camera.x + Game.tora.width >= this.x + 2) {
				if (this.type == "wall") {
					Game.tora.x -= 3;
					Game.tora.right = false;
					Game.tora.loseHealth(1, 100);
				}
				if (this.type == "urchon") {
					Game.tora.loseHealth(10, 100);
				}
				if (this.type == "aligo") {
					Game.tora.loseHealth(3, 100);
				}
				if (this.type == "turtle") {
					Game.tora.loseHealth(3, 100);
				}
			}
		}
		if (this.movetype == "movingenemy") {
			if (Game.weapon.attack == true && Game.weapon.x <= this.x + this.width
					&& Game.weapon.x + Game.weapon.width >= this.x
					&& Game.weapon.y + Game.Camera.y <= this.y + this.width
					&& Game.weapon.y + Game.weapon.height + Game.Camera.y >= this.y) {
				if (this.type == "aligo") {
					System.out.println("hit");
					Game.obstacles.remove(this);
				} else if (this.type == "turtle" && Game.tora.attackDir == "up") {
					System.out.println("hit");
					Game.obstacles.remove(this);
				}
			}
			if ((direction > 0 && (this.x + this.width + 10 > 512)) || (direction < 0 && this.x - 10 < 0)) {
				direction *= -1;
			}
			for (int i = 0; i < Game.obstacles.size(); i++) {
				if (Game.obstacles.get(i).type == "wall") {
					if (this.y < Game.obstacles.get(i).y + Game.obstacles.get(i).height
							&& this.y + this.width > Game.obstacles.get(i).y) {
						if (direction > 0 && this.x + this.width + 10 > Game.obstacles.get(i).x
								&& this.x + this.width + 10 < Game.obstacles.get(i).x + Game.obstacles.get(i).width) {
							direction *= -1;
							break;
						}
						if (direction < 0 && this.x - 10 > Game.obstacles.get(i).x
								&& this.x - 10 < Game.obstacles.get(i).x + Game.obstacles.get(i).width) {
							direction *= -1;
							break;
						}
					}
				}
			}
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
