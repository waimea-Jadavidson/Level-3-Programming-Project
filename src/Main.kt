/**
 * =====================================================================
 * Programming Project for NCEA Level 3, Standard 91906
 * ---------------------------------------------------------------------
 * Project Name:   SCP 3008
 * Project Author: Jasper Davidson
 * GitHub Repo:    https://github.com/waimea-Jsadavidson/Level-3-Programming-Project
 * ---------------------------------------------------------------------
 * Notes:
 * This game is a horror/exploration based adventure of SCP 3008. For the uninitiated that is a non-euclidean haunted IKEA
 * =====================================================================
 */



import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*
import javax.swing.Timer;

import gameMap.IkeaScenes
import gameMap.MazeScenes
import gameMap.BackroomOfficeScenes
import gameMap.Map
import kotlin.system.exitProcess


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    val app = App() // Create the app model
    MainWindow(app) // Create and show the UI, using the app model

    app.instructionsPopUp.isVisible = true

}


/**
 * The application class (model)
 * This is the place where any application data should be
 * stored, plus any application logic functions
 */
class App() {
    val MAX_WIDTH = 2
    val MAX_HEIGHT = 2

    val player = Player(Pair(0, 0))
    var clue = ""
    var currentMap : Map = IkeaScenes

    // These are gameplay related flags, the player is hunting for a clue to unlock the managers office
    var foundPartialClue = false
    var foundFullClue = false


    private var mapPopUp: MapErrorPopUp = MapErrorPopUp()
    private var gameWinPopUp: GameWinDialog = GameWinDialog()
    private var gameLossPopUp: GameLossDialog = GameLossDialog()
    var instructionsPopUp: InstructionsPopUp = InstructionsPopUp()
    private var levelMoveDialog: LevelMoveDialog = LevelMoveDialog()
    private var keySuccessDialog: KeySuccessDialog = KeySuccessDialog()

    fun showClue(){
        // This sets the clue from the scenes.kt and allows it to be passed into MainWindow
        clue = currentMap.sceneFromPosition(player.playerPosition)?.clue.toString()
        println("CLUE: $clue")

        // Checks if player is in a scene with an important bit of information, then sets a flag off
        if(currentMap.sceneFromPosition(player.playerPosition)?.name == "Ikea Kitchen Trap"){
            foundPartialClue = true
            keySuccessDialog.isVisible = true
            println("CLUE FOUND 1")
        }
        //
        else if (currentMap.sceneFromPosition(player.playerPosition)?.name == "Breakroom 6B"){
            foundFullClue = true
            keySuccessDialog.isVisible = true
            println("CLUE FOUND 2")
        }
    }

    fun gameWinLoss(){
        if(currentMap.sceneFromPosition(player.playerPosition)?.name == "Manager’s Office Door"){
            if(foundPartialClue && foundFullClue){
                gameWinPopUp.isVisible = true
                exitProcess(0)
            }else{
                gameLossPopUp.isVisible = true
                exitProcess(0)
            }
        }
    }

    // This function changes the map scenes when the player is in the right connection scene
    fun mapChange(){
        if (currentMap.name == "IKEA" &&
            currentMap.sceneFromPosition(player.playerPosition)?.name == "Home Section Maze") {
            currentMap = MazeScenes
            player.playerPosition = Pair(0,0)
            println("CURRENT MAP: $currentMap")
        }
        else if(currentMap.name == "MAZE" &&
            currentMap.sceneFromPosition(player.playerPosition)?.name == "Shifting Hallway") {
            currentMap = BackroomOfficeScenes
            println("CURRENT MAP: $currentMap")
            player.playerPosition = Pair(0,0)
            println("SCENE: ${currentMap.sceneFromPosition(player.playerPosition)?.name}")
        }
        else{
            levelMoveDialog.isVisible = true
        }
    }

    // Hides clue when switching scenes
    fun hideclue(){
        clue = "..."
        println("CLUE: $clue")
    }

    // This function provides an easy way to do player movement and error checking for that movement in one method.
    fun playerMovement(source: String) {
        when (source) {
            "u" ->{
                if (player.playerPosition.second > 0){
                    player.playerPosition = Pair(player.playerPosition.first,(player.playerPosition.second-1))
                }else{
                    mapPopUp.isVisible = true
                }
            }
            "d"->{
                if((player.playerPosition.second < MAX_HEIGHT)){
                    player.playerPosition = Pair(player.playerPosition.first,(player.playerPosition.second+1))
                }else{
                    mapPopUp.isVisible = true
                }

            }
            "l"->{
                if(player.playerPosition.first > 0){
                    player.playerPosition = Pair((player.playerPosition.first -1),player.playerPosition.second)
                }else{
                    mapPopUp.isVisible = true
                }

            }
            "r"->{
                if(player.playerPosition.first < MAX_WIDTH){
                    player.playerPosition = Pair((player.playerPosition.first +1),player.playerPosition.second)
                }else{
                    mapPopUp.isVisible = true
                }

            }
        }
        hideclue()
    }

}

// Player Class here as a legacy feature
class Player(var playerPosition: Pair<Int, Int>) {}


/**
 * This is the collection of pop-ups used throughout the game and gameplay to give messages to the player.
 */

class GameWinDialog(): JDialog(){
    init {
        configureWindow()
        addControls()
        setLocationRelativeTo(null)     // Centre the window
    }

    /**
     * Setup the dialog window
     */
    private fun configureWindow() {
        title = "GAME OVER!"
        contentPane.preferredSize = Dimension(400, 200)
        isResizable = false
        isModal = true
        layout = null
        pack()
    }

    /**
     * Populate the window with controls
     */
    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 16)

        // Adding <html> to the label text allows it to wrap
        val message = JLabel("<html> Congrats, you have found the manager. To play again, simply close and reopen the window. </html>")
        message.bounds = Rectangle(25, 25, 350, 150)
        message.horizontalAlignment = SwingConstants.CENTER
        message.font = baseFont
        add(message)
    }
}

class GameLossDialog(): JDialog(){
    init {
        configureWindow()
        addControls()
        setLocationRelativeTo(null)     // Centre the window
    }

    /**
     * Setup the dialog window
     */
    private fun configureWindow() {
        title = "GAME OVER!"
        contentPane.preferredSize = Dimension(400, 200)
        isResizable = false
        isModal = true
        layout = null
        pack()
    }

    /**
     * Populate the window with controls
     */
    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 16)

        // Adding <html> to the label text allows it to wrap
        val message = JLabel("<html> You failed the game, the manager was not happy with you. </html>")
        message.bounds = Rectangle(25, 25, 350, 150)
        message.horizontalAlignment = SwingConstants.CENTER
        message.font = baseFont
        add(message)
    }
}

class LevelMoveDialog(): JDialog(){
    init {
        configureWindow()
        addControls()
        setLocationRelativeTo(null)     // Centre the window
    }

    /**
     * Setup the dialog window
     */
    private fun configureWindow() {
        title = "MAP Error!"
        contentPane.preferredSize = Dimension(400, 200)
        isResizable = false
        isModal = true
        layout = null
        pack()
    }

    /**
     * Populate the window with controls
     */
    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 16)

        // Adding <html> to the label text allows it to wrap
        val message = JLabel("<html> You are unable to teleport here, please keep exploring. </html>")
        message.bounds = Rectangle(25, 25, 350, 150)
        message.horizontalAlignment = SwingConstants.CENTER
        message.font = baseFont
        add(message)
    }
}

class KeySuccessDialog(): JDialog(){
    init {
        configureWindow()
        addControls()
        setLocationRelativeTo(null)     // Centre the window
    }

    /**
     * Setup the dialog window
     */
    private fun configureWindow() {
        title = "Sucess!"
        contentPane.preferredSize = Dimension(400, 200)
        isResizable = false
        isModal = true
        layout = null
        pack()
    }

    /**
     * Populate the window with controls
     */
    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 16)

        // Adding <html> to the label text allows it to wrap
        val message = JLabel("<html> Well Done, you have found a Key. </html>")
        message.bounds = Rectangle(25, 25, 350, 150)
        message.horizontalAlignment = SwingConstants.CENTER
        message.font = baseFont
        add(message)
    }
}

class InstructionsPopUp(): JDialog(){
    init {
        configureWindow()
        addControls()
        setLocationRelativeTo(null)     // Centre the window
    }

    /**
     * Setup the dialog window
     */
    private fun configureWindow() {
        title = "Instructions Pop-Up"
        contentPane.preferredSize = Dimension(500, 600)
        isResizable = false
        isModal = true
        layout = null
        pack()
    }

    /**
     * Populate the window with controls
     */
    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 16)

        // Adding <html> to the label text allows it to wrap
        val message = JLabel("""
        <html>
        <b>Controls:</b><br>
        • W / A / S / D = Move North, West, South, East<br>
        • A Button = Check for Clues<br>
        • B Button = Interact with Scenes (change maps, open doors)<br><br>
        <b>Goals:</b><br>
        1. Explore the infinite IKEA and uncover clues left behind by other wanderers.<br>
        2. Collect all parts of the burned access code (e.g. "757***") from key scenes.<br>
        3. Reach the Manager’s Office and input the full access code to escape.<br><br>
        <b>Important Mechanics:</b><br>
        • Some areas use teleportation — these are <u>one-way only</u>, plan your path wisely.<br>
        • If you reach the final door without all access code parts, the game will fail.<br><br>
        Stay alert. Clues are hidden where you'd least expect them.
        </html>
    """.trimIndent())
        message.bounds = Rectangle(25, 25, 450, 550)
        message.horizontalAlignment = SwingConstants.CENTER
        message.font = baseFont
        add(message)
    }
}

class MapErrorPopUp(): JDialog(){
    init {
        configureWindow()
        addControls()
        setLocationRelativeTo(null)     // Centre the window
    }

    /**
     * Setup the dialog window
     */
    private fun configureWindow() {
        title = "Map Error!"
        contentPane.preferredSize = Dimension(400, 200)
        isResizable = false
        isModal = true
        layout = null
        pack()
    }

    /**
     * Populate the window with controls
     */
    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 16)

        // Adding <html> to the label text allows it to wrap
        val message = JLabel("<html> Error, can't move in the direction </html>")
        message.bounds = Rectangle(25, 25, 350, 150)
        message.horizontalAlignment = SwingConstants.CENTER
        message.font = baseFont
        add(message)
    }
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

    private lateinit var sceneNameLabel: JLabel
    private lateinit var descriptionLabel: JLabel
    private lateinit var clueLabel: JLabel

    // This timer is what will provide some slowness to peoples movement, making actions more deliberate.
    private lateinit var moveTimer: Timer

    // Stamina Label that works with timer to limit movement
    private lateinit var staminaLabel: JLabel
    private lateinit var staminaBar: JLabel

    var enableUI = false


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
        title = "SCP 3008"
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
        val headerFont = Font(Font.SERIF, Font.PLAIN, 50)

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

        sceneNameLabel = JLabel()
        sceneNameLabel.horizontalAlignment = (SwingConstants.CENTER)
        sceneNameLabel.font = headerFont
        sceneNameLabel.bounds = Rectangle(38, 10, 528, 100)
        sceneNameLabel.background = Color(75, 80, 82)
        sceneNameLabel.isOpaque = true
        add(sceneNameLabel)

        clueLabel = JLabel()
        clueLabel.horizontalAlignment = (SwingConstants.CENTER)
        clueLabel.bounds = Rectangle(38, 470, 528, 100)
        clueLabel.background = Color(75, 80, 82)
        clueLabel.isOpaque = true
        add(clueLabel)

        descriptionLabel = JLabel()
        descriptionLabel.horizontalAlignment = (SwingConstants.CENTER)
        descriptionLabel.bounds = Rectangle(38, 150, 528, 300)
        descriptionLabel.background = Color(75, 80, 82)
        descriptionLabel.isOpaque = true
        add(descriptionLabel)

        moveTimer = Timer(3000, this)
        moveTimer.setRepeats(false)

        staminaLabel = JLabel("Stamina")
        staminaLabel.horizontalAlignment = (SwingConstants.CENTER)
        staminaLabel.bounds = Rectangle(300, 589, 70, 30)
        staminaLabel.foreground = Color.WHITE
        add(staminaLabel)

        staminaBar = JLabel()
        staminaBar.bounds = Rectangle(300, 589, 70, 30)
        staminaBar.background = Color(39, 112, 230)
        staminaBar.isOpaque = true
        add(staminaBar)

    }


    /**
     * Update the UI controls based on the current state
     * of the application model
     */
    fun updateView() {
        this.requestFocus()
        println("VIEW: " + app.player.playerPosition)
        sceneNameLabel.text = app.currentMap.sceneFromPosition(app.player.playerPosition)?.name
        descriptionLabel.text = app.currentMap.sceneFromPosition(app.player.playerPosition)?.description
        clueLabel.text = app.clue

        sceneNameLabel.foreground = if(app.currentMap.name == "IKEA"){Color.blue} else if(app.currentMap.name == "MAZE"){Color.red}  else {Color.yellow}
    }

    /**
     * Handle any UI events (e.g. button clicks)
     * Usually this involves updating the application model
     * then refreshing the UI view
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            upButton -> {
                app.playerMovement("u")
                enableUI = false
            }

            downButton -> {
                app.playerMovement("d")
                enableUI = false
            }

            leftButton -> {
                app.playerMovement("l")
                enableUI = false
            }

            rightButton -> {
                app.playerMovement("r")
                enableUI = false
            }

            aButton -> {
                app.showClue()
                enableUI = false
            }

            bButton ->{
                app.mapChange()
                app.gameWinLoss()
                enableUI = false
            }

            moveTimer ->{
                println("TIMER: FINISHED")
                moveTimer.stop()
                enableUI = true
            }
        }

        if (enableUI) {
            arrayOf(upButton, downButton, leftButton, rightButton, aButton, bButton).forEach { i ->
                i.isEnabled = true
            }
            staminaBar.background = Color(39, 112, 230)
        }
        else {
            updateView()
            staminaBar.background = Color.BLACK
            moveTimer.restart()
            arrayOf(upButton, downButton, leftButton, rightButton, aButton, bButton).forEach { i ->
                i.isEnabled = false
            }
        }
    }

}


