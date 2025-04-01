/**
 * This is the file where scenes are stored.
 * This is because initialising scenes within the orginal main file created clutter and it was harder to read.
 *
 * **/

package gameMap

val scenes = mutableMapOf<Pair<Int,Int>, Location>()

class Location(name: String, val coords: Pair<Int,Int>){
     lateinit var description: String

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

object IkeaScene {

    // Top Row of 3*3
    val entranceWay = Location("Entrance That Was", Pair(0, 0))
    val fallenDisplay = Location("Fallen Display", Pair(0, 1))
    val theFakeExit = Location("The Fake Exit", Pair(0, 2))

    // Middle Row of 3*3
    val lostCustomerServices = Location("Lost Customer Services", Pair(1,0))
    val theNightMarket = Location("The Night-Market", Pair(1,1))
    val homeSectionMaze = Location("Home Section Maze", Pair(1,2))

    //Bottom Row of 3*3

    init {
        // Top Row Descriptions
        entranceWay.description = "The spot where new wanderers arrive. The sliding glass doors are gone, replaced by endless aisles. Shopping carts and discarded bags suggest others came before you."
        fallenDisplay.description = " A collapsed showroom setup with broken furniture and scattered price tags. A single security camera, unplugged but still glowing red, watches from above."
        theFakeExit.description = "A glowing red \"EXIT\" sign hangs above an archway. Those who enter come out the other side, back where they started."

        // Middle Row descriptions
        lostCustomerServices.description = "A dusty help desk with a blinking computer screen. The screen only types back cryptic messages like \"Stock Unavailable\" and \"Employee Assistance Required.\""
        theNightMarket.description = "A survivor camp built from scavenged shelves and pallets. People trade for food, batteries, and tools. A handwritten sign warns: \"STORE CLOSES AT 10 PM.\""
        homeSectionMaze.description = "A twisted labyrinth of sofas, bookshelves, and coffee tables arranged in unnatural patterns. Walking in a straight line somehow leads you back to where you started."






    }

    fun sceneFromPosition(position: Pair<Int,Int>): Location? {
        return scenes[position]
    }
}