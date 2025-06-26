import javax.swing.*
import java.awt.*

class AnimatedPaintBox : JPanel() {
    private var x = 0
    private var y = 0
    private var dx = 2
    private var dy = 3
    private val diameter = 30

    init {
        background = Color.WHITE
        preferredSize = Dimension(400, 300)

        // Timer to update animation every 16 ms (~60 FPS)
        Timer(16) { update() }.start()
    }

    private fun update() {
        // Move the circle
        x += dx
        y += dy

        // Bounce off edges
        if (x < 0 || x + diameter > width) dx = -dx
        if (y < 0 || y + diameter > height) dy = -dy

        repaint()  // trigger paintComponent
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        val g2 = g as Graphics2D

        // Draw the moving circle
        g2.color = Color.RED
        g2.fillOval(x, y, diameter, diameter)
    }
}

fun main() {
    SwingUtilities.invokeLater {
        val frame = JFrame("Animated PaintBox")
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        val animatedBox = AnimatedPaintBox()
        frame.contentPane.add(animatedBox)

        frame.pack()
        frame.setLocationRelativeTo(null)
        frame.isVisible = true
    }
}
