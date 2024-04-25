package c22439572;

public class Starfield extends MichaelsVisuals{

    static final int NUM_LINES = 10;
    float t;

    public void settings()
    {
        size(1080, 940);
    }

    public void setup()
    {
        background(20);
    }

    public void draw()
    {
        background(20);
        stroke(255);
        strokeWeight(5);

        translate(width/2, height/2);
        for (int i = 0; i < NUM_LINES; i++)
        {
            line(x1(t + i), y1(t + i), x2(t + i), y2(t + i));
        }
        t++;
    }

    float x1(float t){
        return sin(t / 10) * 100 + sin(t / 5) * 20;
    }

    float y1(float t){
        return cos(t / 10) * 100;
    }

    float x2(float t){
        return sin(t / 10) * 200 + sin(t) * 2;
    }

    float y2(float t){
        return cos(t / 20) * 200 + cos(t / 12) * 20;
    }
    
}
