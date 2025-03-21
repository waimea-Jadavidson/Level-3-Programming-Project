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
    val scene = mutableListOf<Scene>()

}

class Scene(val name: String, val description: String){

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
        rightButton.addActionListener(this)
        add(aButton)

        bButton = JButton("B")
        bButton.bounds = Rectangle(233, 680, 40, 40)
        rightButton.addActionListener(this)
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
    }

    /**
     * Handle any UI events (e.g. button clicks)
     * Usually this involves updating the application model
     * then refreshing the UI view
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            upButton -> println("UP!!!")
        }

        this.requestFocus()
    }

}

