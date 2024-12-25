# BrickBreaker Game

An improved version of the classic BrickBreaker game implemented in Java. This game features dynamic gameplay with multiple difficulty levels, unique paddle types, and object-oriented programming concepts to provide an engaging and fun experience.

![Level 2 Gameplay](pictures/level2.jpeg)

## Features

- **Difficulty Levels**: Choose from three levels of difficulty to match your skill.
- **Unique Paddles**: Includes three paddle types:
  - **Standard**: Default paddle for classic gameplay.
  - **Lazy**: A slower paddle for a more relaxed experience.
  - **Laser**: A specialized paddle with additional functionalities.
- **Dynamic Gameplay**:
  - White bricks require **1 hit** to destroy.
  - Yellow bricks require **2 hits**.
  - Red bricks require **3 hits**.
- **High Scores**: Tracks player scores for competitive replayability.
- **Object-Oriented Design**: Implements clean and modular Java code with well-defined classes.

## How to Play

- **Controls**: Use the **right** and **left arrow keys** to move the paddle.
- Prevent the ball from falling and destroy all bricks to advance to the next level.
- When all lives are lost, the game ends, but you can restart by pressing **Enter**.

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/BrickBreaker.git

2. Navigate to the project directory:
   ```bash
   cd BrickBreaker

3. Compile the code using your preferred Java IDE or javac command:
   ```bash
   javac -d bin src/**/*.java

4. Run the game:
    ```bash
   java -cp bin org.cis1200.Game

You can also navigate to the game file and run it directly using:
Path: BreakBreakerGame/src/main/java/org/cis1200/Game.java






