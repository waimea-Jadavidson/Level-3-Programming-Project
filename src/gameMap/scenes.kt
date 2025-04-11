/**
 * This is the file where scenes are stored.
 * This is because initialising scenes within the orginal main file created clutter and it was harder to read.
 *
 * **/

package gameMap

import gameMap.IkeaScenes.scenes


class Location(val scenes: MutableMap<Pair<Int,Int>, Location>, val name: String, val coords: Pair<Int,Int>){
    lateinit var description: String
    lateinit var clue: String

    init {
        scenes[coords] = this
    }
}
/**
 *
 * This is the object that stores all the scene details for the Ikea Level.
 * This keeps everything in one clear place
 *
 * **/

open class Map(val name: String){

    val scenes = mutableMapOf<Pair<Int,Int>, Location>()
    
    fun sceneFromPosition(position: Pair<Int,Int>): Location? {
        return scenes[position]
    }
}

object IkeaScenes : Map("IKEA") {

    // Top Row of 3*3
    val entranceWay = Location(scenes, "Entrance That Was", Pair(0, 0))
    val fallenDisplay = Location(scenes, "Fallen Display", Pair(0, 1))
    val theFakeExit = Location(scenes, "The Fake Exit", Pair(0, 2))

    // Middle Row of 3*3
    val lostCustomerServices = Location(scenes, "Lost Customer Services", Pair(1,0))
    val theNightMarket = Location(scenes, "The Night-Market", Pair(1,1))
    val homeSectionMaze = Location(scenes, "Home Section Maze", Pair(1,2))

    //Bottom Row of 3*3
    val warehouseDepths = Location(scenes, "Warehouse Depths", Pair(2,0))
    val endlessAisles = Location(scenes, "Endless Aisles", Pair(2,1))
    val meatballStorage = Location(scenes, "Meatball Storage", Pair(2,2))

    init {
        // Top Row Descriptions
        entranceWay.description = "<html>The spot where new wanderers arrive. The sliding glass doors are gone, replaced by endless aisles. Shopping carts and discarded bags suggest others came before you.</html>"
        entranceWay.clue = "<html>\"To find the one who knows it all,\n" +
                "Look where the help desk starts to fall.\n" +
                "Flickering lights and an empty screen,\n" +
                "Where forgotten requests have always been.\n" +
                "The manager waits, though not in sight,\n" +
                "Follow the hum, and you’ll be right.\"</html>"

        fallenDisplay.description = "<html>A collapsed showroom setup with broken furniture and scattered price tags. A single security camera, unplugged but still glowing red, watches from above.</html>"
        fallenDisplay.clue = "No Clue, keep looking!!!"

        theFakeExit.description = "<html>A glowing red \"EXIT\" sign hangs above an archway. Those who enter come out the other side, back where they started.</html>"
        theFakeExit.clue = "No Clue, keep looking!!!"

        // Middle Row Descriptions
        lostCustomerServices.description = "<html>A dusty help desk with a blinking computer screen. The screen only types back cryptic messages like \"Stock Unavailable\" and \"Employee Assistance Required.\"</html>"
        lostCustomerServices.clue ="<html>\"To find your way through twists and turns,\n" +
                "Where couches sit and shelves burn,\n" +
                "Look for the place where paths collide,\n" +
                "Where every corner’s a place to hide.\n" +
                "A maze of furniture, walls of cheer,\n" +
                "Step carefully, the exit’s near.\"</html>"

        theNightMarket.description = "<html>A survivor camp built from scavenged shelves and pallets. People trade for food, batteries, and tools. A handwritten sign warns: \"STORE CLOSES AT 10 PM.\"</html>"
        theNightMarket.clue = "No Clue, keep looking!!!"

        homeSectionMaze.description = "<html>A twisted labyrinth of sofas, bookshelves, and coffee tables arranged in unnatural patterns. Walking in a straight line somehow leads you back to where you started.</html>"
        homeSectionMaze.clue ="No Clue, keep looking!!!"

        // Bottom Row Descriptions
        warehouseDepths.description = "<html>Towering storage racks filled with mislabeled boxes. Some boxes contain normal IKEA products—others hold things that move when no one's looking.</html>"
        homeSectionMaze.clue = "No Clue, keep looking!!!"

        endlessAisles.description = "<html>Infinite rows of shelves stocked with identical items. A faint, distorted voice over the intercom repeats, \"Attention shoppers, the store is now closed.\"</html>"
        endlessAisles.clue = "No Clue, keep looking!!!"

        meatballStorage.description = "<html>A freezer room filled with metal trays of IKEA meatballs. Some trays are warm, as if freshly prepared… but the kitchen is nowhere in sight.</html>"
        meatballStorage.clue = "No Clue, keep looking!!!"






    }


}

/**
 *
 * This is the object that stores all the scene details for the Maze Level.
 * This keeps everything in one clear place
 *
 * **/

object MazeScenes : Map("MAZE"){

    // Top Row of 3*#
    val sofaJungle = Location(scenes, "Sofa Jungle", Pair(0, 0))
    val shelvingLabyrinth = Location(scenes, "Shelving Labyrinth", Pair(0, 1))
    val cushionedDeadEnd = Location(scenes, "Cushioned Dead End", Pair(0, 2))

    // Middle Row of 3*3
    val storageStacks = Location(scenes, "Storage Stacks", Pair(1, 0))
    val heartOfTheMaze = Location(scenes, "The Heart of the Maze", Pair(1, 1))
    val ikeaKitchenTrap = Location(scenes, "Ikea Kitchen Trap", Pair(1, 2))

    // Bottom Row of 3*3
    val loungeParadise = Location(scenes, "Lounge Paradise", Pair(2, 0))
    val shiftingHallway = Location(scenes, "Shifting Hallway", Pair(2, 1))
    val hiddenDoor = Location(scenes, "The Hidden Door", Pair(2, 2))

    init{
        // Top Row Description
        sofaJungle.description = "<html>A disorganized pile of mismatched sofas, armchairs, and recliners. Pillows are scattered everywhere, and a faint scent of furniture polish lingers in the air.</html>"
        sofaJungle.clue = "<html>\"At the center, all paths meet,\n" +
                "A glass reflection shows your feat.\n" +
                "Look for where the table lies,\n" +
                "The path ahead is full of lies.\n" +
                "Where the walls shift, find your way,\n" +
                "And through the door, you'll see the day.\"</html>No Clue, keep looking!!!"

        shelvingLabyrinth.description = "<html>Tall bookshelves that seem to go on forever, each path leading to more bookshelves. It's easy to get lost, and the shelves appear to shift slightly when you're not looking.</html>"
        shelvingLabyrinth.clue = "No Clue!!! Keep Looking!!!"

        cushionedDeadEnd.description = "<html>A cozy nook surrounded by cushions and throws. It looks inviting, but the way forward is blocked by a towering wall of fabric samples.</html>"
        cushionedDeadEnd.clue = "No Clue!!! Keep Looking!!!"

        // Middle Row Description
        storageStacks.description = "<html>Boxes stacked high, with labels too blurry to read. Some boxes seem to have moved on their own, leaving a faint trail in the dust.</html>"
        storageStacks.clue = "No Clue!!! Keep Looking!!!"

        heartOfTheMaze.description = "<html>The central section where paths cross and overlap. A massive glass coffee table sits in the middle, reflecting the surroundings like a distorted mirror. This spot feels oddly familiar—like it might connect to another place.</html>"
        heartOfTheMaze.clue = "The table reflects what you seek the most — the scent of bread drifts from the South"

        ikeaKitchenTrap.description = "<html>A section filled with fake kitchen setups. The aroma of fresh bread wafts from one area, but you can't find the source. A door behind the fridge seems suspiciously out of place.</html>"
        ikeaKitchenTrap.clue = "\"Walls shift when doors are fed. Try the path that never led.\" Burnt Access Code (757***)"

        // Bottom Row Description
        loungeParadise.description = "<html>A perfect living room setup with soft lighting and a huge flat-screen TV. But the remote is nowhere to be found, and the TV always seems to be stuck on static.</html>"
        loungeParadise.clue = "No Clue!!! Keep Looking!!!"

        shiftingHallway.description = "<html>A narrow corridor of dimly lit hallway furniture. The walls feel like they’re closing in, and the path ahead feels uncertain. The floor seems to shift occasionally.</html>"
        shiftingHallway.clue = "No Clue!!! Keep Looking!!!"

        hiddenDoor.description = "<html>A plain door behind a bookshelf in a corner. There's a faint scratching sound from the other side. It’s locked but you feel as if someone’s watching from the other side.</html>"
        hiddenDoor.clue = "No Clue!!! Keep Looking!!!"




    }
}

object BackroomOfficeScenes: Map("BACKROOMS"){
    val serverRoom = Location(scenes,"Server Room", Pair(0, 0))
    val hrDepartment = Location(scenes,"HR Department", Pair(0, 1))
    val emergencyStairwell = Location(scenes,"Emergency Stairwell", Pair(0, 2))

    // Middle Row
    val adminCubicles = Location(scenes,"Admin Cubicles", Pair(1, 0))
    val securityOffice = Location(scenes,"Security Office", Pair(1, 1))
    val breakroom6B = Location(scenes,"Breakroom 6B", Pair(1, 2))

    // Bottom Row
    val filingVault = Location(scenes,"Filing Vault", Pair(2, 0))
    val managerOfficeDoor = Location(scenes,"Manager’s Office Door", Pair(2, 1))
    val lockedArchives = Location(scenes,"Locked Archives", Pair(2, 2))

    init {
        serverRoom.description = "<html>Blades of fans spin endlessly. Cables crawl like vines across the floor. The servers beep in a pattern that sounds almost like Morse code.</html>"
        serverRoom.clue = ""

        hrDepartment.description = "<html>Empty chairs and shredded paperwork. A complaint form sits half-completed: \"He never clocked out. He never left.\"</html>"
        hrDepartment.clue = ""

        emergencyStairwell.description = "<html>The stairs descend forever. A red light pulses below. There’s no echo from your footsteps.</html>"
        emergencyStairwell.clue = ""

        adminCubicles.description = "<html>Gray partitions form a soul-crushing maze. Phones ring with no callers. A calendar still shows 1999.</html>"
        adminCubicles.clue = ""

        securityOffice.description = "<html>Monitors flicker between camera feeds and static. One shows Breakroom 6B. A sticky note says: \"He’s still watching.\"</html>"
        securityOffice.clue = "Breakroom 6B is where you want to be"

        breakroom6B.description = "<html>An ordinary breakroom—except the food is warm, and the clock always reads 6:66. Something knocks gently from the vending machine.</html>"
        breakroom6B.clue = "<html> Burnt Access Code (***400), you have found access key, Press A to enter the mangers room and win</html>"

        filingVault.description = "<html>Rows of cabinets labeled in foreign symbols. One drawer contains a photo of the player—taken moments ago.</html>"
        filingVault.clue = ""

        managerOfficeDoor.description = "<html>A thick wooden door sealed by a keypad and scanner. Above it, a plaque: \"M. GRANGER – GENERAL MANAGER.\" It hums softly.</html>"
        managerOfficeDoor.clue = "<html> Find the access key, then Press A to enter the room and find the manager </html>"

        lockedArchives.description = "<html>Files are chained shut and nailed to the wall. A faint heartbeat echoes through the room. One file folder is missing.</html>"
        lockedArchives.clue = ""

    }
}