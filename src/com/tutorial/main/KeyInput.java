package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by AKazakov on 9/28/2017.
 */
public class KeyInput extends KeyAdapter {

    private Handler handler;
    private int xp, xm, yp, ym; //xm stands for x minus and xp stands for x plus etc.

    public KeyInput(Handler handler) {
        this.handler = handler;

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) ym = 5;
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) xm = 5;
                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) yp = 5;
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) xp = 5;

                tempObject.setVelX(xp - xm);
                tempObject.setVelY(yp - ym);


                if (key == KeyEvent.VK_ESCAPE) System.exit(1);
            }


        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) ym = 0;
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) xm = 0;
                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) yp = 0;
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) xp = 0;

                tempObject.setVelX(xp - xm);
                tempObject.setVelY(yp - ym);
            }

        }
    }
}
