package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class EnemyBossBullet extends GameObject {

    private Handler handler;
    Random r = new Random();


    public EnemyBossBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = (r.nextInt(5 - -5)+ -5);
        velY = 5;
    }


    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        if(y >= Game.HEIGHT) handler.removeObject(this);


    //    if (y <= 0 || y >= Game.HEIGHT - 48) velY *= -1;
      //  if (x <= 0 || x >= Game.WIDTH - 18) velX *= -1;

        handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.red, 16, 16, 0.06f, handler));
    }

    public void render(Graphics g) {

        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, 16, 16);
    }
}
