class Character(object):
  xkey = false
  ykey = false
  xdir = ""
  ydir = ""
  up = true
  down = true
  left = true
  right = true
  leftpressed = false
  rightpressed = false
  uppressed = false
  downpressed = false
  moving = true
  attack = false
  attackDir = ""
  speedX = 0
  speedY = 0
  counter = 0
  attackcounter = 0
  lastDir = "up"
  bigTreasure = false
  health = 10
  invincible = 0
  attackposition = 1

  directionqueue = []
  verticalqueue = []
  horizontalqueue = []
  
  def __init__(self, x, y, width, height, src, type):
      self.x = x
      self.y = y
      self.width = width
      self.height = height
      self.src = src
      self.type = type

  def move(self):
    if ((self.x - 2 >= 0 and speedX < 0) or (self.x + self.width + 2 <= 512 and speedX > 0)):
      if ((left == true and xdir == "left") or (right == true and xdir == "right")):
        self.x += speedX
    if ((self.y - 2 >= 0 and speedY < 0) or (self.y + self.height + 2 <= Game.frameheight and speedY > 0)) :
      if ((up == true and ydir == "up") or (down == true and ydir == "down")) :
        self.y += speedY
      
    
  

  def animate(self) :
    if (self.type == "character") :
      if (self.invincible % 10 > 7) :
        self.src = "yellow.png"
      elif (Game.weapon.attack == true) :
        if (attackDir == "up") :
          if (Game.animationcounter <= 10) :
            self.src = "toraupattack1.png"
          elif (Game.animationcounter <= 20) :
            self.src = "toraupattack2.png"
          
        elif (attackDir == "down") :
          if (Game.animationcounter <= 10) :
            self.src = "toradownattack1.png"
          elif (Game.animationcounter <= 20) :
            self.src = "toradownattack2.png"
          
        elif (attackDir == "left") :
          if (Game.animationcounter <= 10) :
            self.src = "toraleftattack1.png"
          elif (Game.animationcounter <= 20) :
            self.src = "toraleftattack2.png"
          
        elif (attackDir == "right") :
          if (Game.animationcounter <= 10) :
            self.src = "torarightattack1.png"
          elif (Game.animationcounter <= 20) :
            self.src = "torarightattack2.png"
          
        
      elif (!directionqueue.isEmpty()) :
        if (directionqueue.get(0) == "up") :
          if (Game.animationcounter <= 10) :
            self.src = "toraup1.png"
          elif (Game.animationcounter <= 20) :
            self.src = "toraup2.png"
          
        elif (directionqueue.get(0) == "down") :
          if (Game.animationcounter <= 10) :
            self.src = "toradown1.png"
          elif (Game.animationcounter <= 20) :
            self.src = "toradown2.png"
          
        elif (directionqueue.get(0) == "left") :
          if (Game.animationcounter <= 10) :
            self.src = "toraleft1.png"
          elif (Game.animationcounter <= 20) :
            self.src = "toraleft2.png"
          
        elif (directionqueue.get(0) == "right") :
          if (Game.animationcounter <= 10) :
            self.src = "toraright1.png"
          elif (Game.animationcounter <= 20) :
            self.src = "toraright2.png"
        
      else :
        if (lastDir == "up") :
          if (Game.animationcounter <= 10) :
            self.src = "toraup1.png"
          elif (Game.animationcounter <= 20) :
            self.src = "toraup2.png"
          
        elif (lastDir == "down") :
          if (Game.animationcounter <= 10) :
            self.src = "toradown1.png"
          elif (Game.animationcounter <= 20) :
            self.src = "toradown2.png"
          
        elif (lastDir == "left") :
          if (Game.animationcounter <= 10) :
            self.src = "toraleft1.png"
          elif (Game.animationcounter <= 20) :
            self.src = "toraleft2.png"
          
        elif (lastDir == "right") :
          if (Game.animationcounter <= 10) :
            self.src = "toraright1.png"
          elif (Game.animationcounter <= 20) :
            self.src = "toraright2.png"

  def loseHealth(int healthAmount, int invincibleAmount):
    if (self.invincible == 0):
      self.health -= healthAmount
      self.invincible += invincibleAmount
      if (!Game.collectedTreasure.isEmpty()):
        Game.collectedTreasure.remove(Game.collectedTreasure.size() - 1)
        Game.collectedTreasures--
      elif (Game.tora.bigTreasure == true):
        Game.bigChest.src = ""

  def update():
    if (self.invincible > 0):
      self.invincible-=1
    if (Game.weapon.attack == true):
      attackcounter += attackposition
      if (attackcounter == 15):
        attackposition = -1
        
      if (attackDir == "up"):
        Game.weapon.y = Game.tora.y - attackcounter * 10
        Game.weapon.x = Game.tora.x + Game.tora.width / 2 - Game.weapon.width / 2
        
      if (attackDir == "down"):
        Game.weapon.y = Game.tora.y + attackcounter * 10
        Game.weapon.x = Game.tora.x + Game.tora.width / 2 - Game.weapon.width / 2
        
      if (attackDir == "left"):
        Game.weapon.x = Game.tora.x - attackcounter * 10
        Game.weapon.y = Game.tora.y + Game.tora.height / 2 - Game.weapon.height / 2
        
      if (attackDir == "right"):
        Game.weapon.x = Game.tora.x + attackcounter * 10
        Game.weapon.y = Game.tora.y + Game.tora.height / 2 - Game.weapon.height / 2
        
      if (((attackDir == "up" or attackDir == "down") and Game.weapon.y == Game.tora.y) or ((attackDir == "left" or attackDir == "right") and Game.weapon.x == Game.tora.x)):
        Game.weapon.attack = false
        attackcounter = 0
        attackposition = 1
        Game.weapon.src = ""
      else:
        Game.weapon.y = Game.tora.y
        Game.weapon.x = Game.tora.x

    if (self.y + self.height > Game.frameheight):
      self.y = Game.frameheight - self.height
    if (self.y < 0 and moving == true):
      self.y = 0
    if (horizontalqueue.isEmpty()):
      speedX = 0
    elif (horizontalqueue.get(0) == "left"):
      speedX = -3
    elif (horizontalqueue.get(0) == "right"):
      speedX = 3

    if (verticalqueue.isEmpty()):
      speedY = 0
    elif (verticalqueue.get(0) == "up"):
      speedY = -3
    elif (verticalqueue.get(0) == "down"):
      speedY = 3

    animate()

    if ((speedX == 0 and speedY == 0) or (counter == 22)):
      counter = 0
    else:
      counter++

    # System.out.println(horizontalqueue)
    # System.out.println(verticalqueue)
    # System.out.println(directionqueue)

  def paint(self):
    image(self.src,self.x,self.y,self.width,self.height)

  def keyReleased(KeyEvent e):
    if (e.keyCode == 'a'):
      xkey = false
      directionqueue.remove("left")
      horizontalqueue.remove("left")
      leftpressed = false
      lastDir = "left"
      
    if (e.keyCode == 'd'):
      xkey = false
      directionqueue.remove("right")
      horizontalqueue.remove("right")
      rightpressed = false
      lastDir = "right"
      
    if (e.keyCode == 'w'):
      ykey = false
      directionqueue.remove("up")
      verticalqueue.remove("up")
      uppressed = false
      lastDir = "up"
      
    if (e.keyCode == 's'):
      ykey = false
      directionqueue.remove("down")
      verticalqueue.remove("down")
      downpressed = false
      lastDir = "down"

  def keyPressed(KeyEvent e):
    if (self.moving == true):
      if (keyCode == 'a' and left == true and leftpressed == false):
        directionqueue.insert(0, "left")
        xkey = true
        horizontalqueue.insert(0, "left")
        xdir = "left"
        leftpressed = true
        
      if (keyCode == 'd' and right == true and rightpressed == false):
        directionqueue.insert(0, "right")
        horizontalqueue.insert(0, "right")
        xkey = true
        xdir = "right"
        rightpressed = true
        
      if (keyCode == 'w' and up == true and uppressed == false):
        directionqueue.insert(0, "up")
        verticalqueue.insert(0, "up")
        ykey = true
        ydir = "up"
        uppressed = true
        
      if (keyCode == 's' and down == true and downpressed == false):
        directionqueue.insert(0, "down")
        verticalqueue.insert(0, "down")
        ykey = true
        ydir = "down"
        downpressed = true
        
      if (Game.Camera.movement == "down" and keyCode == ' ' and Game.weapon.attack == false):
        Game.weapon.attack = true
        if (!directionqueue.isEmpty()):
          attackDir = directionqueue.get(0)
        else:
          attackDir = lastDir
        Game.playSound("attack.wav", "attack")
        if(attackDir == "up"):
          Game.weapon.src = "upattack.png"
        elif(attackDir == "down"):
          Game.weapon.src = "downattack.png"
        elif(attackDir == "left"):
          Game.weapon.src = "leftattack.png"
        elif(attackDir == "right"):
          Game.weapon.src = "rightattack.png"
    
