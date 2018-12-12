package game;

import java.awt.event.KeyEvent;

public class camera {
	boolean xkey = false;
	boolean ykey = false;
	int x = 0;
	int y = 0;
	int counter = 0;
	int speedX = 0;
	int speedY = 0;
	String movement = "down";

	public camera(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void update() {
		if (xkey == false) {
			speedX = 0;
		}
		if (ykey == false) {
			speedY = 0;
		}
		if (Game.background.height - Game.frameheight > this.y) {
			if (movement == "down") {
				speedY += 1;
			}
		}
		if (Game.tora.bigTreasure == true && counter < 100) {
			movement = "up";
			counter++;
		}
		if (movement == "up" && counter == 100) {
			speedY -= 2;
		}
		if (this.y <= 0 && Game.tora.bigTreasure) {
			movement = "stop";
		}
		if (movement == "stop") {
			Game.tora.y -= 4;
			Game.tora.speedX = 0;
			Game.tora.speedY = 0;
			Game.tora.moving = false;
		}

		x += speedX;
		y += speedY;
	}
}
