# Results of Testing

The test results show the actual outcome of the testing, following the [Test Plan](test-plan.md)

---

## Player Movement Valid

This test will show the player movement functioning, player movement consists of players moving through different scenes
and levels.

### Test Data To Use

Details of test data and reasons for selection.

- Valid Inputs
    - Moving through the map using NSEW buttons where they are in the bounds of the map.
    - Moving through the levels using the B button when they are in the right location.

### Test Result

![java_PiOfFtK1Sr.gif](screenshots/java_PiOfFtK1Sr.gif)

This test was successful, it showed the use of moving through the scenes with the NSEW buttons and moving to another level with the B Button in the right location. This met my expected results over in my [Test Plan](test-plan.md).

---

## Player Movement Boundary

This test will show the player movement functioning, player movement consists of players moving through different scenes
and levels.

### Test Data To Use

- Boundary Input
  - The Player will move through the scenes and the edges of a level, then able to teleport to repeat on a new level.

### Test Result

![java_PiOfFtK1Sr.gif](screenshots/java_PiOfFtK1Sr.gif)

As shown in this test the player can move through the map and to the edges of the level and then was able to teleport to the new level. This meets my expected rest outcome in my [Test Plan](test-plan.md).

---

## Player Movement Invalid

This test will show the player movement functioning, player movement consists of players moving through different scenes
and levels.

### Test Data To Use

- Invalid Inputs
  - Trying to move outside the **boundaries** of the map.
  - Trying to access a new level without being in the right area.

### Test Result

![java_JPY3jDgXtT.gif](screenshots/java_JPY3jDgXtT.gif)

This shows the successful outcome of this test, if the player tries to do a invalid input they are met with a pop-up dialog box explaining why. This meets my expected rest outcome in my [Test Plan](test-plan.md).

---

## Finding a Key Valid

This test will show the valid use of pop-up dialog boxes when a key has been successfully found. This is part of my game
progression.

### Test Data To Use

- Valid Inputs
  - Playing the game normally and finding the hidden keys.

### Test Result

![java_DkW0kuouk7.gif](screenshots/java_DkW0kuouk7.gif)

This test shows the successful outcome of this test, the game responds with pop-up dialogs when the player finds the hidden keys in the game. This meets my expected rest outcome in my [Test Plan](test-plan.md).

---

## Finding a Key Invalid

This test will show how the game handles if a player only finds one or fewer key

### Test Data To Use

- Invalid Inputs
  - Playing the game and trying to skip to the end of the game without finding the keys.

### Test Results

![java_WvP8YBcEqu.gif](screenshots/java_WvP8YBcEqu.gif)

This test shows the expected outcome of this test, the game responds with a pop-up dialog. This meets my expected rest outcome in my [Test Plan](test-plan.md).

---

## Game State (Valid/Win)

This test will show the game in a winning state, this includes the successful find of both hidden keys and then the player
going to the "Manager's Office Door" scene and completing the game.

### Test Date to Use

- Valid Inputs:
  - The player will play the game, find the two hidden keys and exit the game at the Manager's office door.

### Test Results

![java_HgtsthMy07.gif](screenshots/java_HgtsthMy07.gif)

This test shows the expected outcome of this test, the game responds with a pop-up dialog. This meets my expected rest outcome in my [Test Plan](test-plan.md).

---

## Game State (Invalid/Loss)

This test will show the game in a losses state, the player will not have found all or
none of the keys to complete the
game.

### Test Data to Use
- Invalid Inputs:
  - The player attempts to finish the game without collecting any of the keys.

### Test Results
![java_WvP8YBcEqu.gif](screenshots/java_WvP8YBcEqu.gif)
This test shows the expected outcome of this test, the game responds with a pop-up dialog. This meets my expected rest outcome in my [Test Plan](test-plan.md).

---

## Game Setup

This test will show the game successfully starting up. The instructions will pop up, then when the player closes them start the game.

### Test Data to Use
- Input
  - I will start the game, the instructions will pop-up. Then I will close them and play the game.

### Test Results

![idea64_y0mcbvfgs5.gif](screenshots/idea64_y0mcbvfgs5.gif)
