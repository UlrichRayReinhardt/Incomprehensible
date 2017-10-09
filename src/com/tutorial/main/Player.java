package com.tutorial.main;

import java.awt.*;
import java.util.Random;

/**
 * Created by AKazakov on 9/22/2017.
 */
public class Player extends GameObject {

    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x,(int) y, (int)32, (int)32);
    }

    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp((float)x, (float)0, (float)Game.WIDTH - 37);
        y = Game.clamp((float)y, (float)0, Game.HEIGHT - 64);
        handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.WHITE, 32, 32, 0.06f, handler));
        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject gameObject = handler.object.get(i);

            if (gameObject.getId() == ID.BasicEnemy || gameObject.getId() == ID.FastEnemy || gameObject.getId() == ID.SmartEnemy) {
                if (getBounds().intersects(gameObject.getBounds())) {
                    HUD.HEALTH -= 2;
                    //collision code
                }
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int)x, (int)y, 32, 32);
    }


}
