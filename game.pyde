class Game(object):
    def move():
        background.move()
        tora.move()
        for i in obstacles:
            obstacles.get(i).move()
    move()
    
    def update():
        background.update()
        if Camera.movement != "stop":
            for i in obstacles: 
                obstacles.get(i).update()
            
        for i in treasures:
            treasures.get(i).update();
            tora.update();
    update()
    
    def paintComponent():
        g.translate(0, 0)
        g.translate(-Camera.x, -Camera.y)
        background.paint(g2d)
        for i in obstacles:
            obstacles.get(i).paint(g2d)
        for i in treasures:
            treasures.get(i).paint(g2d)
            g.translate(Camera.x, Camera.y)
            tora.paint(g2d)
            ui.paint(g2d)
        for i in collectedTreasure:
            collectedTreasure.get(i).paint(g2d)
            bigChest.paint(g2d)
            g.setColor(Color.blue)
            g.fillRect(600, 50, tora.health*10,10)
            g.setColor(Color.black)
            g.fillRect(600+tora.health*10,50,(10-tora.health)*10,10)
    paintComponent()
    
    def main(): 
        finalwidth = framewidth
        finalheight = frameheight
        Game game = new Game()
        game.maptype = "default"
        # frame.setSize(finalwidth, finalheight)
        game.setPreferredSize(new Dimension(finalwidth, finalheight)
        Map.createMap()
        print(frame.getContentPane().getSize())
        Thread.sleep(1000)
    main()
    
    def draw():
        while gameStatus == "playing":
        game.move()
        tora.up = true
        tora.down = true
        tora.left = true
        tora.right = true
        game.update()
        Camera.update()
        game.repaint()
        Thread.sleep(25)
    draw()
