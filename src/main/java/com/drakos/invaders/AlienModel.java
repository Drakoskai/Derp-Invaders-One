package com.drakos.invaders;

/**
 *
 * @author Drakos Kai
 */
public class AlienModel implements Entity {

    private int x;
    private int y;
    private int h;
    private int w;
    private boolean isAlive;

    public AlienModel() {
        x = 0;
        y = 0;
        h = 20;
        w = 20;
        isAlive = true;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    @Override
    public int getWidth() {
        return w;
    }

    @Override
    public void setWidth(int width) {
        this.w = width;
    }

    @Override
    public int getHeight() {
        return h;
    }

    @Override
    public void setHeight(int height) {
        this.h = height;
    }

    @Override
    public int getXPos() {
        return x;
    }

    @Override
    public void setXPos(int x) {
        this.x = x;
    }

    @Override
    public int getYPos() {
        return y;
    }

    @Override
    public void setYPos(int y) {
        this.y = y;
    }
}
