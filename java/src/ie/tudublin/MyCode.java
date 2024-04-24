package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ie.tudublin.Visual;

public class MyCode extends Visual {

    Minim m;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer b;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    String filePath = "C:\\Users\\C22439572\\OneDrive - Technological University Dublin\\SoundProject\\MusicVisuals\\java\\data\\SkengGvnman.mp3";
    float angle;
    int mode = 0;

    public void settings() {
        size(1024, 500);

    }

    public void setup() {
        size(1024, 500);
        surface.setLocation(957, 0);
        rectMode(CENTER);
        stroke(0, 15, 30);
        strokeWeight(25);

        m = new Minim(this);
        ap = m.loadFile(filePath, 1024);
        ap.play();
        b = ap.mix;

        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[width];
    }

    public void keyPressed() {
        if (key >= '0' && key <= '9') {
            mode = key - '0';
        }
        if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
    }

    public void draw() {
        // Get the current amplitude of the audio
        float amplitude = getAmplitude();
        colorMode(HSB);

        switch (mode) {
            case 0:
                background(0, 15, 30);
                translate(width / 2, height / 2);
                for (int i = 0; i < 100; i++) {
                    fill(map(i, 0, 100, 0, 255), 255, 255); // Set fill color using HSB
                    float size = (float)(500 * (0.95 + amplitude * 0.1)); // Adjust size based on amplitude
                    rotate(radians(angle));
                    rect(0, 0, size, size);
                }
                break;
            case 1: {
                background(0, 15, 30);
                float x = width;
                float dia = 110;
                float num = 100;
                translate(width / 2, height / 2);
                for (int i = 0; i < num; i++) {
                    fill(map(i, 0, num, 0, 255), 255, 255); // Set fill color using HSB
                    float size = (float)(dia * (0.95 + amplitude * 0.1)); // Adjust size based on amplitude
                    rotate(radians(angle));
                    ellipse(x, 0, size, size);
                }
            }
            break;
        }

        // Increment angle for animation (slower increment)
        angle += 0.25; // Adjust the increment value to change the speed of the animation
    }

    // Function to calculate the current amplitude of the audio
    public float getAmplitude() {
        float total = 0;
        for (int i = 0; i < b.size(); i++) {
            total += abs(b.get(i));
        }
        return total / b.size();
    }
}
