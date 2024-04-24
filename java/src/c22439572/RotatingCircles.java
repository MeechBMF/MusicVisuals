package c22439572;

import ie.tudublin.*;

public class RotatingCircles extends MichaelsVisuals
{   
    MichaelsVisuals mvs;

    public void setup()
    {
        size(1024, 500);
        surface.setLocation(957, 0);
        rectMode(CENTER);
        stroke(0, 15, 30);
        strokeWeight(25);
        frameRate(10);
    }

    public void keyPressed() {
        if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
    }

    public void render() 
    {
        // Get the current amplitude of the audio
        float amplitude = getAmplitude();
        colorMode(HSB);
        translate(width / 2, height / 2);
        for (int i = 0; i < 100; i++) {
            fill(map(i, 0, 100, 0, 255), 255, 255); // Set fill color using HSB
            float size = (float)(500 * (0.95 + amplitude * 0.1)); // Adjust size based on amplitude
            rotate(radians(angle));
            rect(0, 0, size, size);
        }
    }
} 