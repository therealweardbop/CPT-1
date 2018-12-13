package game;

import java.util.LinkedList;

public class Map {
	public static void createMap() {
		Game.obstacles.add(new Obstacle(224, 256, 32, 32, "wall.png", "wall"));
		Game.obstacles.add(new Obstacle(256, 256, 32, 32, "wall.png", "wall"));

		Game.obstacles.add(new Obstacle(96, 448, 32, 32, "wall.png", "wall"));
		Game.obstacles.add(new Obstacle(64, 448, 32, 32, "wall.png", "wall"));
		Game.obstacles.add(new Obstacle(96, 480, 32, 32, "wall.png", "wall"));
		Game.obstacles.add(new Obstacle(64, 480, 32, 32, "wall.png", "wall"));

		Game.obstacles.add(new Obstacle(416, 448, 32, 32, "wall.png", "wall"));
		Game.obstacles.add(new Obstacle(384, 448, 32, 32, "wall.png", "wall"));
		Game.obstacles.add(new Obstacle(416, 480, 32, 32, "wall.png", "wall"));
		Game.obstacles.add(new Obstacle(384, 480, 32, 32, "wall.png", "wall"));

		LinkedList<Obstacle>[] layouts = new LinkedList[5];
		Item[] chestlayout = new Item[5];
		Obstacle[] enemies = new Obstacle[5];
		for (int i = 0; i < layouts.length; i++) {
			layouts[i] = new LinkedList<Obstacle>();
		}
		chestlayout[0] = new Item(192, -32, 32, 32, "smallTreasure", "yellow.png");
		layouts[0].add(new Obstacle(192, 0, 32, 32, "wall.png", "wall"));
		layouts[0].add(new Obstacle(192, 32, 32, 32, "wall.png", "wall"));
		layouts[0].add(new Obstacle(224, 0, 32, 32, "wall.png", "wall"));
		layouts[0].add(new Obstacle(224, 32, 32, 32, "wall.png", "wall"));
		enemies[0].add(new Obstacle(150, 30, 40, 20, "red.png", "movingenemy"));

		layouts[0].add(new Obstacle(64, 192, 32, 32, "wall.png", "wall"));
		layouts[0].add(new Obstacle(64, 224, 32, 32, "wall.png", "wall"));
		layouts[0].add(new Obstacle(64, 256, 32, 32, "wall.png", "wall"));
		layouts[0].add(new Obstacle(96, 192, 32, 32, "wall.png", "wall"));
		layouts[0].add(new Obstacle(96, 224, 32, 32, "wall.png", "wall"));
		layouts[0].add(new Obstacle(96, 256, 32, 32, "wall.png", "wall"));

		layouts[0].add(new Obstacle(416, 192, 32, 32, "wall.png", "wall"));
		layouts[0].add(new Obstacle(416, 224, 32, 32, "wall.png", "wall"));
		layouts[0].add(new Obstacle(416, 256, 32, 32, "wall.png", "wall"));
		layouts[0].add(new Obstacle(384, 192, 32, 32, "wall.png", "wall"));
		layouts[0].add(new Obstacle(384, 224, 32, 32, "wall.png", "wall"));
		layouts[0].add(new Obstacle(384, 256, 32, 32, "wall.png", "wall"));

		chestlayout[1] = new Item(32, 160, 32, 32, "smallTreasure", "yellow.png");
		layouts[1].add(new Obstacle(0, 192, 32, 32, "wall.png", "wall"));
		layouts[1].add(new Obstacle(0, 224, 32, 32, "wall.png", "wall"));
		layouts[1].add(new Obstacle(0, 256, 32, 32, "wall.png", "wall"));
		layouts[1].add(new Obstacle(32, 192, 32, 32, "wall.png", "wall"));
		layouts[1].add(new Obstacle(32, 224, 32, 32, "wall.png", "wall"));
		layouts[1].add(new Obstacle(32, 256, 32, 32, "wall.png", "wall"));
		enemies[1].add(new Obstacle(20, 185, 40, 20, "red.png", "movingenemy"));

		layouts[1].add(new Obstacle(480, 192, 32, 32, "wall.png", "wall"));
		layouts[1].add(new Obstacle(480, 224, 32, 32, "wall.png", "wall"));
		layouts[1].add(new Obstacle(480, 256, 32, 32, "wall.png", "wall"));
		layouts[1].add(new Obstacle(448, 192, 32, 32, "wall.png", "wall"));
		layouts[1].add(new Obstacle(448, 224, 32, 32, "wall.png", "wall"));
		layouts[1].add(new Obstacle(448, 256, 32, 32, "wall.png", "wall"));

		chestlayout[2] = new Item(256, 128, 32, 32, "smallTreasure", "yellow.png");
		layouts[2].add(new Obstacle(0, 192, 32, 32, "wall.png", "wall"));
		layouts[2].add(new Obstacle(0, 224, 32, 32, "wall.png", "wall"));
		layouts[2].add(new Obstacle(0, 256, 32, 32, "wall.png", "wall"));
		layouts[2].add(new Obstacle(480, 192, 32, 32, "wall.png", "wall"));
		layouts[2].add(new Obstacle(480, 224, 32, 32, "wall.png", "wall"));
		layouts[2].add(new Obstacle(480, 256, 32, 32, "wall.png", "wall"));
		enemies[2].add(new Obstacle(390, 248, 40, 20, "red.png", "movingenemy"));

		layouts[2].add(new Obstacle(256, 160, 32, 32, "wall.png", "wall"));
		layouts[2].add(new Obstacle(256, 192, 32, 32, "wall.png", "wall"));
		layouts[2].add(new Obstacle(256, 224, 32, 32, "wall.png", "wall"));
		layouts[2].add(new Obstacle(288, 160, 32, 32, "wall.png", "wall"));
		layouts[2].add(new Obstacle(288, 192, 32, 32, "wall.png", "wall"));
		layouts[2].add(new Obstacle(288, 224, 32, 32, "wall.png", "wall"));

		chestlayout[3] = new Item(128, 192, 32, 32, "smallTreasure", "yellow.png");
		layouts[3].add(new Obstacle(256, 32, 32, 32, "wall.png", "wall"));
		layouts[3].add(new Obstacle(256, 0, 32, 32, "wall.png", "wall"));
		layouts[3].add(new Obstacle(224, 32, 32, 32, "wall.png", "wall"));
		layouts[3].add(new Obstacle(224, 0, 32, 32, "wall.png", "wall"));
		enemies[3].add(new Obstacle(210, 0, 40, 20, "red.png", "movingenemy"));

		layouts[3].add(new Obstacle(96, 256, 32, 32, "wall.png", "wall"));
		layouts[3].add(new Obstacle(96, 224, 32, 32, "wall.png", "wall"));
		layouts[3].add(new Obstacle(128, 256, 32, 32, "wall.png", "wall"));
		layouts[3].add(new Obstacle(128, 224, 32, 32, "wall.png", "wall"));

		layouts[3].add(new Obstacle(384, 256, 32, 32, "wall.png", "wall"));
		layouts[3].add(new Obstacle(384, 224, 32, 32, "wall.png", "wall"));
		layouts[3].add(new Obstacle(352, 256, 32, 32, "wall.png", "wall"));
		layouts[3].add(new Obstacle(352, 224, 32, 32, "wall.png", "wall"));

		layouts[4].add(new Obstacle(0, 0, 32, 32, "wall.png", "wall"));
		layouts[4].add(new Obstacle(32, 0, 32, 32, "wall.png", "wall"));
		layouts[4].add(new Obstacle(0, 32, 32, 32, "wall.png", "wall"));
		layouts[4].add(new Obstacle(32, 32, 32, 32, "wall.png", "wall"));

		// number = 2;
		int number = -1;
		int prev = -1;
		for (int j = 0; j < 7; j++) {
			number = (int) Math.floor(Math.random() * 4);
			// number = 3;
			Game.treasures.add(new Item(chestlayout[number].x, chestlayout[number].y + 448 * j + 640,
					chestlayout[number].width, chestlayout[number].height, "smallTreasure", "yellow.png"));
			for (int i = 0; i < layouts[number].size(); i++) {
				Game.obstacles.add(new Obstacle(layouts[number].get(i).x, layouts[number].get(i).y + 448 * j + 640,
						layouts[number].get(i).width, layouts[number].get(i).height, "wall.png", "wall"));
			}
			Game.obstacles.add(new Obstacle(enemies[number].x, enemies[number].y + 448 * j + 640, enemies[number].width,
					enemies[number].height, "red.png", "movingenemy"));
		}
		Game.treasures.add(new Item(128, Game.background.height - 416, 32, 32, "smallTreasure", "yellow.png"));
		Game.obstacles.add(new Obstacle(384, (Game.background.height - 192), 32, 32, "wall.png", "wall"));
		Game.obstacles.add(new Obstacle(384, (Game.background.height - 224), 32, 32, "wall.png", "wall"));
		Game.obstacles.add(new Obstacle(384, (Game.background.height - 256), 32, 32, "wall.png", "wall"));
		Game.obstacles.add(new Obstacle(352, (Game.background.height - 192), 32, 32, "wall.png", "wall"));
		Game.obstacles.add(new Obstacle(352, (Game.background.height - 224), 32, 32, "wall.png", "wall"));
		Game.obstacles.add(new Obstacle(352, (Game.background.height - 256), 32, 32, "wall.png", "wall"));

		Game.obstacles.add(new Obstacle(352, (Game.background.height - 64), 32, 32, "red.png", "urchin"));
		Game.obstacles.add(new Obstacle(128, (Game.background.height - 64), 32, 32, "red.png", "urchin"));

		Game.obstacles.add(new Obstacle(96, (Game.background.height - 320), 32, 32, "wall.png", "wall"));
		Game.obstacles.add(new Obstacle(96, (Game.background.height - 352), 32, 32, "wall.png", "wall"));
		Game.obstacles.add(new Obstacle(96, (Game.background.height - 384), 32, 32, "wall.png", "wall"));
		Game.obstacles.add(new Obstacle(128, (Game.background.height - 320), 32, 32, "wall.png", "wall"));
		Game.obstacles.add(new Obstacle(128, (Game.background.height - 352), 32, 32, "wall.png", "wall"));
		Game.obstacles.add(new Obstacle(128, (Game.background.height - 384), 32, 32, "wall.png", "wall"));

		for (int i = 0; i < 16; i++) {
			Game.obstacles.add(new Obstacle(i * 32, (Game.background.height - 32), 32, 32, "wall.png", "wall"));
		}
		Game.treasures.add(new Item(224, (Game.background.height - 96), 64, 64, "bigTreasure", "yellow.png"));
	}
}
