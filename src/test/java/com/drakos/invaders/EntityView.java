package com.drakos.invaders;

import java.awt.Graphics;

/**
 *
 * @author Drakos Kai
 */
public interface EntityView {

    void draw(Graphics g);

    void update();

    boolean isAlive();
}
