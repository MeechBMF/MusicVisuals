package c22439572;

import processing.core.PVector;



public class Blob extends MichaelsVisuals
{
    PVector[][] globe;
    float offset = 0;
    float m = 0;
    float mchange = 0;
    int total = 75;

    public void settings()
    {
        size(600, 600, P3D);
    }
    public void setup()
    {
        colorMode(HSB);
        globe = new PVector[total + 1][total + 1];

    }

    float a = 1;
    float b = 1;

    float supershape(float theta, float m, float n1, float n2, float n3)
    {
        float t1 = abs((1 / a) * cos(m * theta / 4));
        t1 = pow(t1, n2);
        float t2 = abs ((1 / b) * sin(m * theta / 4));
        t2 = pow(t2, n3);
        float t3 = t1 + t2;
        float r = pow(t3, -1 / n1);
        return r;
    }


    public void draw()
    {   
        m = map(sin(mchange), -1, 1, 0, 7);
        mchange += 0.05;

        background(0);
        noStroke();
        lights();

    

        translate(width/2, height/2);
        float r = 200;

        for (int i = 0; i < total + 1; i++)
        {
            float lat = map(i, 0, total, HALF_PI, HALF_PI);
            float r2 = supershape(lat, m, (float)0.2, (float)1.7, (float)1.7);
            for (int j = 0; j < total + 1; j++)
            {
                float lon = map(j, 0, total, -PI, PI);
                float r1 = supershape(lon, m, (float)0.2, (float)1.7, (float)1.7);
                float x = r * r1 * cos(lat) * r2 * cos(lon);
                float y = r * r1 * sin(lat) * r2 * cos(lon);
                float z = r * r2 * sin(lat);
                globe[i][j] = new PVector(x, y, z);
                stroke(255);
                strokeWeight(10);
            }
        }

        offset += 5;
        for (int i = 0; i < total; i++)
        {
            float hu = map(i, 0, total, 0, 255 * 6);
            fill((hu + offset) % 255, 255, 255);
            beginShape(TRIANGLE_STRIP);
            for (int j = 0; j < total+1; j++)
            {
                PVector v1 = globe[i][j];
                vertex(v1.x, v1.y, v1.z);
                PVector v2 = globe[i + 1][j];
                vertex(v2.x, v2.y, v2.z);
            }
            endShape();
        }
    }
    
}
