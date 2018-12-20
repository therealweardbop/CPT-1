package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import java.util.LinkedList;

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
	boolean leftpressed = false;
	boolean rightpressed = false;
	boolean uppressed = false;
	boolean downpressed = false;
	boolean moving = true;
	boolean attack = false;
	String attackDir = "";
	int width;
	int height;
	int speedX = 0;
	int speedY = 0;
	String src = "Red.png";
	String type = "blank";
	int counter = 0;
	int attackcounter = 0;
	String lastDir = "up";
	boolean bigTreasure = false;
	int health = 10;
	int invincible = 0;
	int attackposition = 1;

	LinkedList<String> directionqueue = new LinkedList<String>();
	LinkedList<String> verticalqueue = new LinkedList<String>();
	LinkedList<String> horizontalqueue = new LinkedList<String>();

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
			} else if (Game.weapon.attack == true) {
				if (attackDir == "up") {
					if (Game.animationcounter <= 10) {
						this.src = "toraupattack1.png";
					} else if (Game.animationcounter <= 20) {
						this.src = "toraupattack2.png";
					}
				} else if (attackDir == "down") {
					if (Game.animationcounter <= 10) {
						this.src = "toradownattack1.png";
					} else if (Game.animationcounter <= 20) {
						this.src = "toradownattack2.png";
					}
				} else if (attackDir == "left") {
					if (Game.animationcounter <= 10) {
						this.src = "toraleftattack1.png";
					} else if (Game.animationcounter <= 20) {
						this.src = "toraleftattack2.png";
					}
				} else if (attackDir == "right") {
					if (Game.animationcounter <= 10) {
						this.src = "torarightattack1.png";
					} else if (Game.animationcounter <= 20) {
						this.src = "torarightattack2.png";
					}
				}
			} else if (!directionqueue.isEmpty()) {
				if (directionqueue.get(0) == "up") {
					if (Game.animationcounter <= 10) {
						this.src = "toraup1.png";
					} else if (Game.animationcounter <= 20) {
						this.src = "toraup2.png";
					}
				} else if (directionqueue.get(0) == "down") {
					if (Game.animationcounter <= 10) {
						this.src = "toradown1.png";
					} else if (Game.animationcounter <= 20) {
						this.src = "toradown2.png";
					}
				} else if (directionqueue.get(0) == "left") {
					if (Game.animationcounter <= 10) {
						this.src = "toraleft1.png";
					} else if (Game.animationcounter <= 20) {
						this.src = "toraleft2.png";
					}
				} else if (directionqueue.get(0) == "right") {
					if (Game.animationcounter <= 10) {
						this.src = "toraright1.png";
					} else if (Game.animationcounter <= 20) {
						this.src = "toraright2.png";
					}
				}
			} else {
				if (lastDir == "up") {
					if (Game.animationcounter <= 10) {
						this.src = "toraup1.png";
					} else if (Game.animationcounter <= 20) {
						this.src = "toraup2.png";
					}
				} else if (lastDir == "down") {
					if (Game.animationcounter <= 10) {
						this.src = "toradown1.png";
					} else if (Game.animationcounter <= 20) {
						this.src = "toradown2.png";
					}
				} else if (lastDir == "left") {
					if (Game.animationcounter <= 10) {
						this.src = "toraleft1.png";
					} else if (Game.animationcounter <= 20) {
						this.src = "toraleft2.png";
					}
				} else if (lastDir == "right") {
					if (Game.animationcounter <= 10) {
						this.src = "toraright1.png";
					} else if (Game.animationcounter <= 20) {
						this.src = "toraright2.png";
					}
				}
			}
		}
	}

	public void loseHealth(int healthAmount, int invincibleAmount) {
		if (this.invincible == 0) {
			this.health -= healthAmount;
			this.invincible += invincibleAmount;
			if (!Game.collectedTreasure.isEmpty()) {
				Game.collectedTreasure.remove(Game.collectedTreasure.size() - 1);
				Game.collectedTreasures--;
			} else if (Game.tora.bigTreasure == true) {
				Game.bigChest.src = "";
			}
		}
	}

	public void update() {

		if (this.invincible > 0) {
			this.invincible--;
		}
		if (Game.weapon.attack == true) {
			attackcounter += attackposition;
			if (attackcounter == 15) {
				attackposition = -1;
			}
			if (attackDir == "up") {
				Game.weapon.y = Game.tora.y - attackcounter * 10;
				Game.weapon.x = Game.tora.x + Game.tora.width / 2 - Game.weapon.width / 2;
			}
			if (attackDir == "down") {
				Game.weapon.y = Game.tora.y + attackcounter * 10;
				Game.weapon.x = Game.tora.x + Game.tora.width / 2 - Game.weapon.width / 2;
			}
			if (attackDir == "left") {
				Game.weapon.x = Game.tora.x - attackcounter * 10;
				Game.weapon.y = Game.tora.y + Game.tora.height / 2 - Game.weapon.height / 2;
			}
			if (attackDir == "right") {
				Game.weapon.x = Game.tora.x + attackcounter * 10;
				Game.weapon.y = Game.tora.y + Game.tora.height / 2 - Game.weapon.height / 2;
			}
			if (((attackDir == "up" || attackDir == "down") && Game.weapon.y == Game.tora.y)
					|| ((attackDir == "left" || attackDir == "right") && Game.weapon.x == Game.tora.x)) {
				Game.weapon.attack = false;
				attackcounter = 0;
				attackposition = 1;
				Game.weapon.src = "";
			}

		} else {
			Game.weapon.y = Game.tora.y;
			Game.weapon.x = Game.tora.x;
		}

		if (this.y + this.height > Game.frameheight) {
			this.y = Game.frameheight - this.height;
		}
		if (this.y < 0 && moving == true) {
			this.y = 0;
		}
		if (horizontalqueue.isEmpty()) {
			speedX = 0;
		} else if (horizontalqueue.get(0) == "left") {
			speedX = -3;
		} else if (horizontalqueue.get(0) == "right") {
			speedX = 3;
		}

		if (verticalqueue.isEmpty()) {
			speedY = 0;
		} else if (verticalqueue.get(0) == "up") {
			speedY = -3;
		} else if (verticalqueue.get(0) == "down") {
			speedY = 3;
		}

		animate();

		if ((speedX == 0 && speedY == 0) || (counter == 22)) {
			counter = 0;
		} else {
			counter++;
		}

		// System.out.println(horizontalqueue);
		// System.out.println(verticalqueue);
		// System.out.println(directionqueue);
	}

	public void paint(Graphics2D g) {
		ImageIcon picture = new ImageIcon(src);
		Image MyCharacter = picture.getImage();
		g.drawImage(MyCharacter, x, y, width, height, null);
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			xkey = false;
			directionqueue.remove("left");
			horizontalqueue.remove("left");
			leftpressed = false;
			lastDir = "left";
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xkey = false;
			directionqueue.remove("right");
			horizontalqueue.remove("right");
			rightpressed = false;
			lastDir = "right";
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			ykey = false;
			directionqueue.remove("up");
			verticalqueue.remove("up");
			uppressed = false;
			lastDir = "up";
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			ykey = false;
			directionqueue.remove("down");
			verticalqueue.remove("down");
			downpressed = false;
			lastDir = "down";
		}
	}

	public void keyPressed(KeyEvent e) {
		if (this.moving == true) {
			// Game.animationcounter = -1;
			if (e.getKeyCode() == KeyEvent.VK_LEFT && left == true && leftpressed == false) {
				directionqueue.addFirst("left");
				xkey = true;
				horizontalqueue.addFirst("left");
				xdir = "left";
				leftpressed = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT && right == true && rightpressed == false) {
				directionqueue.addFirst("right");
				horizontalqueue.addFirst("right");
				xkey = true;
				xdir = "right";
				rightpressed = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_UP && up == true && uppressed == false) {
				directionqueue.addFirst("up");
				verticalqueue.addFirst("up");
				ykey = true;
				ydir = "up";
				uppressed = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN && down == true && downpressed == false) {
				directionqueue.addFirst("down");
				verticalqueue.addFirst("down");
				ykey = true;
				ydir = "down";
				downpressed = true;
			}
			if (Game.Camera.movement == "down" && e.getKeyCode() == KeyEvent.VK_SPACE && Game.weapon.attack == false) {
				Game.weapon.attack = true;
				if (!directionqueue.isEmpty()) {
					attackDir = directionqueue.get(0);
				} else {
					attackDir = lastDir;
				}
				Game.playSound("attack.wav", "attack");
				if(attackDir == "up") {
					Game.weapon.src = "upattack.png";
				}else if(attackDir == "down") {
					Game.weapon.src = "downattack.png";
				}else if(attackDir == "left") {
					Game.weapon.src = "leftattack.png";
				}else if(attackDir == "right") {
					Game.weapon.src = "rightattack.png";
				}
				
			}
		}
	}
}
