package c22439572;

public class Terrain extends MichaelsVisuals {
    int cols, rows;
    int scl = 20;
    int w = 1200;
    int h = 1600;

    float[][] terrain;

    float flying = 0;

    // Sun variables
    float sunX, sunY, sunZ; // Position of the sun
    float sunRadius = 300; // Radius of the sun

    public void settings() {
        size(600, 600, P3D);
    }

    public void setup() {
        cols = w / scl;
        rows = h / scl;
        terrain = new float[cols][rows];
        
        // Position the sun more to the right of the screen
        sunX = width * 0.75f;
        sunY = height / 2;
        sunZ = 400; // Adjust the Z position of the sun
    }

    public void draw() {
        flying -= 0.1;

        float yoff = flying;
        for (int y = 0; y < rows; y++) {
            float xoff = 0;
            for (int x = 0; x < cols; x++) {
                terrain[x][y] = map(noise(xoff, yoff), 0, 1, -150, 100);
                xoff += 0.1;
            }
            yoff += 0.1;
        }

        background(0);

        // Draw the terrain
        drawTerrain();

        // Draw the orange sun
        drawSun();

    }

    // Method to draw the terrain
    void drawTerrain() {
        stroke(0, 0, 128);
        noFill();
        translate(width / 2, height / 2);
        rotateX(PI / 3);

        translate(-w / 2, -h / 2);
        for (int y = 0; y < rows - 1; y++) {
            beginShape(TRIANGLE_STRIP);
            for (int x = 0; x < cols; x++) {
                vertex(x * scl, y * scl, terrain[x][y]);
                vertex(x * scl, (y + 1) * scl, terrain[x][y + 1]);
            }
            endShape();
        }
    }

    // Method to draw the orange sun
    void drawSun() {
        // Apply shading to the sun to give it a three-dimensional appearance
        ambientLight(255, 255, 255);
        pointLight(255, 255, 255, sunX, sunY, sunZ);
        
        // Draw the sun as a sphere
        fill(255, 165, 0); // Orange color
        noStroke();
        sphere(sunRadius);
    }
}
