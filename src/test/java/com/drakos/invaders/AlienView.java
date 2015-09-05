package com.drakos.invaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

/**
 *
 * @author Drakos Kai
 */
public class AlienView implements EntityView {

    private Entity model;
    private Rectangle graphic;

    public AlienView(Entity model) {
        this.model = model;
        this.graphic = new Rectangle(model.getWidth(), model.getHeight());
        this.graphic.setLocation(model.getXPos(), model.getYPos());
    }

    @Override
    public void draw(Graphics g) {
        if (model.isAlive()) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setPaint(Color.red);
            g2.fill(graphic);
            g2.setPaint(Color.YELLOW);
            g2.draw(graphic);
        }
    }

    @Override
    public void update() {

    }

    @Override
    public boolean isAlive() {
        return model.isAlive();
    }
}
