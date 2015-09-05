package com.drakos.invaders;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Drakos Kai
 */
public class IntegrationTest {

    private boolean isRunning;

    public IntegrationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void runGame() throws InterruptedException {
        isRunning = true;

        JFrame frame = configureWindow();
        Canvas canvas = configureView(frame);
        List<Entity> entities = createEntities();

        canvas.setIgnoreRepaint(true);
        canvas.createBufferStrategy(2);
        canvas.requestFocus();

        List<EntityView> views = new ArrayList<>(entities.size());

        for (Entity model : entities) {
            views.add(new AlienView(model));
        }

        BufferStrategy strategy = canvas.getBufferStrategy();

        while (isRunning) {
            Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, 800, 600);

            for (EntityView view : views) {
                view.update();
                view.draw(g);
            }
            g.dispose();
            strategy.show();
            
            TimeUnit.MILLISECONDS.sleep(1000);
        }
    }

    private JFrame configureWindow() {
        JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                isRunning = false;
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return frame;
    }

    private Canvas configureView(JFrame frame) {
        Canvas canvas = new Canvas();
        canvas.setBounds(0, 0, 800, 600);

        JPanel contentPanel = (JPanel) frame.getContentPane();

        contentPanel.setPreferredSize(new Dimension(800, 600));
        contentPanel.setLayout(null);
        contentPanel.add(canvas);

        contentPanel.setPreferredSize(new Dimension(800, 600));

        frame.pack();

        frame.setVisible(true);
        frame.setResizable(false);

        return canvas;
    }

    private List<Entity> createEntities() {
        List<Entity> entities = new ArrayList<>();
        for (int row = 0; row < 5; row++) {
            for (int x = 0; x < 12; x++) {
                Entity alien = new AlienModel();
                alien.setXPos(100 + (x * 55));
                alien.setYPos(100 + row * 55);
                entities.add(alien);
            }
        }

        return entities;
    }
}
