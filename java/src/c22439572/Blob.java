package c22439572;

import ie.tudublin.*;
import ddf.minim.*;

public class Blob extends MichaelsVisuals {
    float x = 300;
    float y = 300;
    float angle = 90;
    float dia = 20;
    float minSize = 10; // Minimum size of the image
    float maxSize = 100; // Maximum size of the image
	
    String filePath = "C:\\Users\\C22439572\\OneDrive - Technological University Dublin\\SoundProject\\MusicVisuals\\java\\data\\SkengGvnman.mp3";
    
    Minim minim;
    AudioPlayer player;

    public void settings() {
        size(900, 900);
    }

    public void setup() {
        surface.setLocation(987, 70);
        minim = new Minim(this);
        player = minim.loadFile(filePath);
        player.play();
    }

    public void draw() {   
        background(20);

        // Get the amplitude value from the audio
        float amp = player.mix.level();

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

            // Map the amplitude to the size of the image
            float imageSize = map(amp, 0, 1, minSize, maxSize);

            strokeWeight(3);
            line(x * sin(radians(angle)), 0, 0, y - dia/2);
            noStroke();
            ellipse(x * sin(radians(angle)), 0, imageSize, imageSize);
            stroke(r, g, b);
            noFill();
            ellipse(0, y, dia, dia);
            popMatrix();
        }
        angle++;
    }
} 