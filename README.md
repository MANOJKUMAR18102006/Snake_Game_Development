# Snake_Game_Development

i)This is a gaming application
ii)It is built using Java Swing or javaFX for the frontend (UI).
iii)The game logic (snake movement, food, collision) is written in Java OOP.
iv)The scores and user details are stored in a database (SQLite/MySQL)

FEATURES:

1)Game Features:
   i)Classic Snake Game (arrow key controls).
   ii)Snake grows when eating food.
   iii)Score increases with each food.
   iv)Game Over if snake hits wall or itself.
   v)Restart option.

2)User Features:
   i)User Registration
   ii)User Login
   iii)Each user’s scores are saved in the database.

3)Scoreboard Features:
   i)Leaderboard shows Top Players.
   ii)Each user can see their personal best scores.
   iii)Score saved automatically at game over.

4)OOPs concept:
   i)Inheritance
   ii)Polymorphism
   iii)Abstraction
   iv)Encapsulation
   v)Composition

UML DIAGRAM:
                ┌───────────────────┐
                │     GameObject     │  (Abstract Class)
                ├───────────────────┤
                │ - x : int         │
                │ - y : int         │
                ├───────────────────┤
                │ + draw(g) : void  │
                │ + getX() : int    │
                │ + getY() : int    │
                └─────────▲─────────┘
                          │
      ┌───────────────────┴───────────────────┐
      │                                       │
┌───────────────┐                      ┌───────────────┐
│ SnakeSegment  │                      │     Food      │
├───────────────┤                      ├───────────────┤
│ - color       │                      │ - color       │
├───────────────┤                      ├───────────────┤
│ + draw(g)     │                      │ + draw(g)     │
└───────────────┘                      └───────────────┘


┌─────────────────────────────┐
│       Snake                 │
├─────────────────────────────┤
│ - body : List<SnakeSegment> │
│ - direction : String        │
├─────────────────────────────┤
│ + move() : void             │
│ + grow() : void             │
│ + checkCollision() :boolean │
└─────────▲───────────────────┘
          │ (HAS-A)
          │
┌────────────────────┐
│      Board         │
├────────────────────┤
│ - snake : Snake    │
│ - food : Food      │
│ - score : int      │
├────────────────────┤
│ + startGame()      │
│ + update()         │
│ + paint(g)         │
└────────────────────┘


┌────────────────────┐
│      User          │
├────────────────────┤
│ - username : String│
│ - password : String│
│ - highScore : int  │
├────────────────────┤
│ + getUserData()    │
│ + setHighScore()   │
└─────────▲──────────┘
          │
┌────────────────────┐
│ DatabaseManager    │
├────────────────────┤
│ + registerUser()   │
│ + loginUser()      │
│ + saveScore()      │
│ + getLeaderboard() │
└────────────────────┘


┌────────────────────┐
│       Game         │
├────────────────────┤
│ - board : Board    │
│ - user : User      │
├────────────────────┤
│ + main()           │
│ + run()            │
└────────────────────┘
