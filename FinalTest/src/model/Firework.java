package model;

import java.awt.*;
import java.util.Random;

public class Firework {
    public Sparcle[] sparcles;
    public Random random = new Random();

    public Toolkit toolkit = Toolkit.getDefaultToolkit();
    public int x, y;

    public Firework(){
        this.x = random.nextInt(toolkit.getScreenSize().width - 300) + 150;
        this.y = random.nextInt(toolkit.getScreenSize().height - 300) + 150;

        this.sparcles = new Sparcle[20];
        explode();
    }

    public void explode(){
        for(int i = 0; i < sparcles.length; i++){
            sparcles[i] = new Sparcle(x, y);
        }
    }

    public void update(){
        for(int i = 0; i < sparcles.length; i++){
            if(sparcles[i] != null){
                this.sparcles[i].update();
            }
        }
    }
}
