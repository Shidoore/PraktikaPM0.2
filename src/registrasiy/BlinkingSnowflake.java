package registrasiy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
/**
 *
 * @author Петросян Юрик ДКИП-312
 */


public class BlinkingSnowflake extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private Image snowflakeImage;
    private int snowflakeX = 50;
    private int snowflakeY = 50;
    private boolean isVisible = true;

    public BlinkingSnowflake() {
        loadImage();
        initComponents();
    }

    private void loadImage() {
        ImageIcon icon = new ImageIcon("C:\\Users\\Shido\\Downloads\\Снег.png");
        snowflakeImage = icon.getImage();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Blinking Snowflake");

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Изменение видимости снежинки для мигания
                isVisible = !isVisible;
                repaint();
            }
        });
        timer.start();

        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (isVisible) {
            drawSnowflake(g);
        }
    }

    private void drawSnowflake(Graphics g) {
        int x = snowflakeX;
        int y = snowflakeY;

        ImageObserver observer = this;
        g.drawImage(snowflakeImage, x, y, observer);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BlinkingSnowflake::new);
    }
}