package c22439572;

import ie.tudublin.*;

import processing.core.PVector;

public class Blob extends MichaelsVisuals {   
    float x = 300;
    float y = 300;
    float angle = 90;
    float dia = 20;

    public void settings() {
        size(900, 900);
    }

    public void setup() {
        surface.setLocation(987, 70);
    }

    public void draw() {   
        background(20);

        translate(width/2, height/2);
        rotate(radians(angle/3));
        for (float a = 0; a < 360; a += 10) {
            pushMatrix();
            if (angle < 360) 
                rotate(radians(a) * sin(radians(angle)));
            else 
                rotate(radians(a));

            // Randomly generate color
            float r = random(255);
            float g = random(255);
            float b = random(255);
            stroke(r, g, b);
            fill(r, g, b);

            strokeWeight(3);
            line(x * sin(radians(angle)), 0, 0, y - dia/2);
            noStroke();
            ellipse(x * sin(radians(angle)), 0, dia/2, dia/2);
            stroke(r, g, b);
            noFill();
            ellipse(0, y, dia, dia);
            popMatrix();
        }
        angle++;
    } 
}
