import javax.swing.*
import java.awt.*
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

// Custom JPanel that acts like a PaintBox
class PaintBox : JPanel() {
    private val points = mutableListOf<Point>()

    init {
        background = Color.WHITE
        preferredSize = Dimension(400, 300)

        // Mouse listener to draw points on mouse drag
        addMouseMotionListener(object : MouseAdapter() {
            override fun mouseDragged(e: MouseEvent) {
                points.add(e.point)
                repaint()
            }
        })
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        val g2 = g as Graphics2D
        g2.color = Color.BLACK
        g2.stroke = BasicStroke(2f)
        for (point in points) {
            g2.fillOval(point.x, point.y, 4, 4)
        }
    }
}

fun main() {
    SwingUtilities.invokeLater {
        val frame = JFrame("PaintBox Example")
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        val paintBox = PaintBox()
        frame.contentPane.add(paintBox)

        frame.pack()
        frame.setLocationRelativeTo(null)
        frame.isVisible = true
    }
}