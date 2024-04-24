package c22439572;

public class Star extends Starfield{
    float x, y, z, pz;
    float speed;
    float r;

    public Star(){
        x = random(-width, width);
        y = random(-height, height);
        z = random(width);
    }

    public void update()
    {
        z = z - 10;
        if (z < 1)
        {
            z = width;
            x = random(-width, width);
            y = random(-height, height);
        }
    }

    public void show()
    {
        fill(255);
        noStroke();

        float sx = map(x / z, 0, 1, 0, width);
        float sy = map(y / z, 0, 1, 0, height);

        float r = map(z, 0, width, 16, 0);
        ellipse(sx, sy, 8, 8);
    }
    
}
