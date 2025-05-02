# Plan for Testing the Program

The test plan lays out the actions and data I will use to test the functionality of my program.

Terminology:

- **VALID** data values are those that the program expects
- **BOUNDARY** data values are at the limits of the valid range
- **INVALID** data values are those that the program should reject
- **NSEW** North, South, East and West
- **LEVEL** A level is a group of scenes like Ikea Scenes
- **SCENE** A Scene is an individual object that contains information about a location that the player can move through,
e.g the entrance way.

---

## Player Movement Valid

This test will show the player movement functioning, player movement consists of players moving through different scenes
and levels.

### Test Data To Use

Details of test data and reasons for selection.

- Valid Inputs
  - Moving through the map using NSEW buttons where they are in the bounds of the map.
  - Moving through the levels using the B button when they are in the right location.

### Expected Test Result

- Valid Inputs: 
  - If the player moves in a valid way, the UI will update after a 3-second cooldown to show the new scene.
  If the player use the right location to teleport, the UI will update after a 3-second cooldown to show the new level.

---

## Player Movement Boundary

This test will show the player movement functioning, player movement consists of players moving through different scenes
and levels.

### Test Data To Use

Details of test data and reasons for selection.

- Boundary Input
  - The Player will move through the scenes and the edges of a level, then able to teleport to repeat on a new level.

### Expected Test Result

- Boundary Result:
  - The game will not break and the player can move through the level in different scenes and levels.

---

## Player Movement Invalid

This test will show the player movement functioning, player movement consists of players moving through different scenes
and levels.

### Test Data To Use

Details of test data and reasons for selection.

- Invalid Inputs
  - Trying to move outside the **boundaries** of the map.
  - Trying to access a new level without being in the right area.

### Expected Test Result

- Invalid Inputs: 
  - If the player moves in a way that goes outside the level boundaries, a pop-up will appear with an error
    and then continues the game without the game break movement. If the player tries to access a new level without being in
    the correct scene, a pop-up will explain why and then the game will continue without breaking.

---

## Finding a Key Valid

This test will show the valid use of pop-up dialog boxes when a key has been successfully found. This is part of my game
progression.

### Test Data To Use

- Valid Inputs
  - Playing the game normally and finding the hidden keys.

### Expected Test Result

- Valid Inputs: If the keys are found, the pop-up box will appear informing the players of their success.

---

## Finding a Key Invalid

This test will show the valid use of pop-up dialog boxes when a key has been successfully found. This is part of my game
progression.

### Test Data To Use

- Invalid Inputs
  - Playing the game and trying to skip to the end of the game without finding the keys.

### Expected Test Result

- Invalid Inputs: If the player tries to finish the game without the keys, nothing will happen and the game won't break

---

## Game State (Valid/Win)

This test will show the game in a winning state, this includes the successful find of both hidden keys and then the player
going to the "Manager's Office Door" scene and completing the game.

### Test Date to Use
- Valid Inputs:
  - The player will play the game, find the two hidden keys and exit the game at the Manager's office door.

### Expected Results
- Valid Results: 
  - The game will show the win pop-up dialog and instructions to reset itself for game play.

---

## Game State (Invalid/Loss)

This test will show the game in a losses state, the player will not have found all or
none of the keys to complete the 
game.

### Test Data to Use
- Invalid Inputs:
  - The player attempts to finish the game without collecting any of the keys.

### Expected Results
- Invalid Results:
  - The game will show the loss pop-up dialog and instructions to reset itself for new game.

---

## Game Setup

This test will show the game successfully starting up. The instructions will pop up, then when the player closes them start the game.

### Test Data to Use
- Input
  - I will start the game, the instructions will pop-up. Then I will close them and play the game.

### Expected Results
- Outcome
  - The game will function correctly without it breaking.

