package com.drakos.invaders;

/**
 *
 * @author Drakos Kai
 */
public interface Entity {

    boolean isAlive();

    void setAlive(boolean isAlive);

    int getWidth();

    void setWidth(int width);

    int getHeight();

    void setHeight(int height);

    int getXPos();

    void setXPos(int x);

    int getYPos();

    void setYPos(int y);
}
