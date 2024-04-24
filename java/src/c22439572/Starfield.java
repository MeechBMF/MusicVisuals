package c22439572;

public class Starfield extends MichaelsVisuals{

    Star[] stars = new Star[100];

    public void settings()
    {
        size(1080, 940);
    }

    public void setup()
    {
        for (int i = 0; i < stars.length; i++)
        {
            stars[i] = new Star();
        }
    }

    public void draw()
    {
        background(0);
        translate(width/2, height/2);
        for (int i = 0; i < stars.length; i++)
        {
            stars[i].update();
            stars[i].show();
        }
    }
    
}
