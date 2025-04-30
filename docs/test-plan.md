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

## Player Movement

This test will show the player movement functioning, player movement consists of players moving through different scenes
and levels.

### Test Data To Use

Details of test data and reasons for selection.

- Valid Inputs
  - Moving through the map using NSEW buttons where they are in the bounds of the map.
  - Moving through the levels using the B button when they are in the right location.
- Boundary
  - The Player can move through full map, moving through the 3 different levels and allowing to go the end.
- Invalid Inputs
  - Trying to move outside the **boundaries** of the map.
  - Trying to access a new level without being in the right area.

### Expected Test Result

- Valid Inputs: If the player moves in a valid way, the UI will update after a 3-second cooldown to show the new scene.
If the player use the right location to teleport, the UI will update after a 3-second cooldown to show the new level.

- Invalid Inputs: If the player moves in a way that goes outside the level boundaries, a pop-up will appear with an error
and then continues the game without the game break movement. If the player tries to access a new level without being in 
the correct scene, a pop-up will explain why and then the game will continue without breaking.

---

## Finding a Key

This test will show the valid use of pop-up dialog boxes when a key has been successfully found. This is part of my game
progression.


### Test Data To Use

- Valid Inputs
  - Playing the game normally and finding the hidden keys.
- Invalid Inputs
  - Playing the game and trying to skip to the end of the game without finding the keys

### Expected Test Result

- Valid Inputs: If the keys are found, the pop-up box will appear informing the players of their success.

- Invalid Inputs: If the player tries to finish the game without the keys, nothing will happen and the game won't break

---


