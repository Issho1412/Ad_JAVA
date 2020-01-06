package model;

import java.util.Random;

public class Sparcle {
    float x, y;
    float motionX, motionY, speed;

    Random random = new Random();

    public Sparcle(float x, float y){
        this.x = x;
        this.y = y;

        this.speed = random.nextFloat();
        this.motionX = (random.nextFloat()*0.5F)*this.speed;
        this.motionY = (random.nextFloat()*0.5F)*this.speed;
    }

    public void update(){
        this.x += this.motionX;
        this.y += this.motionY;
    }
}
