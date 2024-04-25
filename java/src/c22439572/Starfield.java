package c22439572;

import ddf.minim.*;
import ddf.minim.analysis.*;

public class Starfield extends MichaelsVisuals {

    Minim minim;
    AudioPlayer player;
    FFT fft;

    String filePath = "C:\\Users\\C22439572\\OneDrive - Technological University Dublin\\SoundProject\\MusicVisuals\\java\\data\\SkengGvnman.mp3";
    
    float angle;
    static final int NUM_LINES = 10;
    float t;

    public void settings() {
        size(1080, 940);
    }

    public void setup() {
        background(20);
        minim = new Minim(this);
        player = minim.loadFile(filePath, 1024); // Change to your music file
        player.play();
    
        fft = new FFT(player.bufferSize(), player.sampleRate());
    }

    public void draw() {
        background(20);

        translate(width/2, height/2);
        for (int i = 0; i < NUM_LINES; i++) {
            stroke(255, 0, 0); // Red color for the existing line
            line(x1(t - i, fft), y1(t - i, fft), x2(t - i, fft), y2(t - i, fft));

            stroke(0, 255, 0); // Green color for the new line
            line(x3(t + i, fft), y3(t + i, fft), x4(t + i, fft), y4(t + i, fft));
        }
        t++;
    }

    float x1(float t, FFT fft) {
        return sin(-t / 10) * 100 + sin(-t / 5) * 20 + fft.getBand(10) * 50; // Adjust based on music analysis
    }
    
    float y1(float t, FFT fft) {
        return cos(-t / 10) * 100 + fft.getBand(5) * 50; // Adjust based on music analysis
    }
    
    float x2(float t, FFT fft) {
        return sin(-t / 10) * 200 + sin(-t) * 2 + fft.getBand(20) * 50; // Adjust based on music analysis
    }
    
    float y2(float t, FFT fft) {
        return cos(-t / 20) * 200 + cos(-t / 12) * 20 + fft.getBand(15) * 50; // Adjust based on music analysis
    }
    
    // New line functions going opposite direction
    float x3(float t, FFT fft) {
        return cos(t / 10) * 100 + cos(t / 5) * 20 + fft.getBand(25) * 50; // Adjust based on music analysis
    }
    
    float y3(float t, FFT fft) {
        return sin(t / 10) * 100 + fft.getBand(30) * 50; // Adjust based on music analysis
    }
    
    float x4(float t, FFT fft) {
        return cos(t / 10) * 200 + cos(t) * 2 + fft.getBand(35) * 50; // Adjust based on music analysis
    }
    
    float y4(float t, FFT fft) {
        return sin(t / 20) * 200 + sin(t / 12) * 20 + fft.getBand(40) * 50; // Adjust based on music analysis
    }
}
