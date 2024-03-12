package sk.stuba.fei.uim.oop.turtle;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public class Turtle {
    @Getter @Setter
    private int x,x1;
    @Getter @Setter
    private int y,y1;
    @Getter @Setter
    private int angle;

    private int size;

    private Color color;

    public Turtle(int x, int y){
        this.x = x;
        this.y = y;
        this.size = 50;
        this.angle = -90;
    }


    public void draw(Graphics g){
        g.setColor(Color.GREEN.darker());
        g.fillOval(x-size/2,y-size/2,size,size);

        g.setColor(Color.yellow.darker());
        g.fillOval((x+((int)(size/2 * Math.cos(Math.toRadians(angle)))))-size/4,(y+((int)(size/2 * Math.sin(Math.toRadians(angle)))))-size/4,size/2,size/2);

        g.setColor(Color.BLACK);
    }

    public void setLineColor(Color color){
        this.color = color;
    }

    public void drawLine(Graphics g){
        g.setColor(color);
        g.drawLine(x1-size/4, y1-size/4, x-size/4, y-size/4);
        g.setColor(Color.BLACK);
    }
}
