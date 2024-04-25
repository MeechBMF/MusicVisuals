package ie.tudublin;

import c22439572.Blob;
import c22439572.MichaelsVisuals;
import c22439572.RotatingCircles;
import c22439572.Starfield;
import c22439572.Terrain;
import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;

public class Main {

    public void startUI() {
        String[] a = { "MAIN" };
        processing.core.PApplet.runSketch(a, new Blob());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startUI();
    }
}