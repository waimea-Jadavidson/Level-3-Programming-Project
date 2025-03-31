/**
 * =====================================================================
 * Programming Project for NCEA Level 3, Standard 91906
 * ---------------------------------------------------------------------
 * Project Name:   PROJECT NAME HERE
 * Project Author: Jasper Davidson
 * GitHub Repo:    https://github.com/waimea-Jsadavidson/Level-3-Programming-Project
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
 * =====================================================================
 */



import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    val app = App()         // Create the app model
    MainWindow(app)         // Create and show the UI, using the app model
}


/**
 * The application class (model)
 * This is the place where any application data should be
 * stored, plus any application logic functions
 */
class App() {
    val WIDTH = 2
    val HEIGHT = 2

    val scene = mutableListOf<Scene>()
    val items = mutableListOf<Item>()
    val player = Player("John Doe", Pair(0, 0))


    init {
        scene.add(
            Scene(
                "Entrance",
                "<html> The entrance to a large retail unit previously owned by and branded as IKEA, a popular furniture retail chain </html>",
                Pair(0, 0)
            )
        )
        scene.add(
            Scene(
                "Entrance Way",
                "<html> An expansive room with the boundries hidden in the distance, white flourescent lights hang from the rooth and shelves and items layed out through the room. </html>",
                Pair(1, 0)
            )
        )
        scene.add(
            Scene(
                "BLANK",
                "<html> BLANK",
                Pair(2, 0)
            )
        )
        scene.add(
            Scene(
                "BLANK",
                "<html> BLANK",
                Pair(0, 1)
            )
        )
        scene.add(
            Scene(
                "BLANK",
                "<html> BLANK",
                Pair(1, 1)
            )
        )
        scene.add(
            Scene(
                "BLANK",
                "<html> BLANK",
                Pair(2, 1)
            )
        )
        scene.add(
            Scene(
                "BLANK",
                "<html> BLANK",
                Pair(0, 2)
            )
        )
        scene.add(
            Scene(
                "BLANK",
                "<html> BLANK",
                Pair(1, 2)
            )
        )
        scene.add(
            Scene(
                "BLANK",
                "<html> BLANK",
                Pair(2, 2)
            )
        )

    }

    fun playerMovement(source: String) {
        when (source) {
            "u" ->{
                if (player.playerPosition.second > 0){
                    player.playerPosition = Pair(player.playerPosition.first,(player.playerPosition.second-1))
                }
            }
            "d"->{
                if((player.playerPosition.second < HEIGHT)){
                    player.playerPosition = Pair(player.playerPosition.first,(player.playerPosition.second+1))
                }

            }
            "l"->{
                if(player.playerPosition.first > 0){
                    player.playerPosition = Pair((player.playerPosition.first -1),player.playerPosition.second)
                }

            }
            "r"->{
                if(player.playerPosition.first < WIDTH){
                    player.playerPosition = Pair((player.playerPosition.first +1),player.playerPosition.second)
                }

            }

        }
    }

}

class Player(val name: String, var playerPosition: Pair<Int, Int>) {}

class Item(val name: String, val description: String){

}

class Scene(val name: String, val description: String, val coords: Pair<Int,Int>, val items: MutableList<Item>?=null){

}

/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow(val app: App) : JFrame(), ActionListener {

    private lateinit var upButton: JButton
    private lateinit var downButton: JButton
    private lateinit var leftButton: JButton
    private lateinit var rightButton: JButton

    private lateinit var aButton: JButton
    private lateinit var bButton: JButton

    private lateinit var textLabel: JLabel
    private lateinit var scenePanal: JLabel


    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the windows
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true
        this.isFocusable = true  // Make it visible
        updateView()                    // Initialise the UI
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(600, 800)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        background = Color.GRAY
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 36)

        upButton = JButton("N")
        upButton.bounds = Rectangle(78, 578, 30, 60)
        upButton.addActionListener(this)
        add(upButton)

        downButton = JButton("S")
        downButton.bounds = Rectangle(78, 670, 30, 60)
        downButton.addActionListener(this)
        add(downButton)

        leftButton = JButton("W")
        leftButton.bounds = Rectangle(19, 639, 60, 30)
        leftButton.addActionListener(this)
        add(leftButton)

        rightButton = JButton("E")
        rightButton.bounds = Rectangle(108, 639, 60, 30)
        rightButton.addActionListener(this)
        add(rightButton)

        aButton = JButton("A")
        aButton.bounds = Rectangle(233, 589, 40, 40)
        aButton.addActionListener(this)
        add(aButton)

        bButton = JButton("B")
        bButton.bounds = Rectangle(233, 680, 40, 40)
        bButton.addActionListener(this)
        add(bButton)

        textLabel = JLabel()
        textLabel.bounds = Rectangle(38, 196, 528, 160)
        textLabel.background = Color.GREEN
        textLabel.isOpaque = true
        add(textLabel)

        scenePanal = JLabel()
        scenePanal.bounds = Rectangle(38, 36, 528, 512)
        scenePanal.background = Color.RED
        scenePanal.isOpaque = true
        add(scenePanal)



    }


    /**
     * Update the UI controls based on the current state
     * of the application model
     */
    fun updateView() {
        this.requestFocus()
        println("VIEW: " + app.player.playerPosition)
        textLabel.text = app.scene[(app.player.playerPosition.second* app.WIDTH)+app.player.playerPosition.first].description
    }

    /**
     * Handle any UI events (e.g. button clicks)
     * Usually this involves updating the application model
     * then refreshing the UI view
     */
    override fun actionPerformed(e: ActionEvent?) {
        println(e?.source)

        when (e?.source) {
            upButton -> {
                app.playerMovement("u")
            }

            downButton -> {
                app.playerMovement("d")
            }

            leftButton -> {
                app.playerMovement("l")
            }

            rightButton -> {
                app.playerMovement("r")
            }
        }
        updateView()
    }

}

