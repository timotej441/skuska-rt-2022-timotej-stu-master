package sk.stuba.fei.uim.oop;

import lombok.Getter;
import sk.stuba.fei.uim.oop.turtle.Turtle;

import javax.swing.*;
import java.awt.*;

public class Render extends JPanel {

    @Getter
    public Turtle turtle;

    public Render(){
        this.setBackground(Color.GRAY);
        this.turtle = new Turtle(350, 450);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        this.turtle.drawLine(g);
        this.turtle.draw(g);
    }

    public void moveTurtle(int angle, int step, Color color){
        angle = this.turtle.getAngle() + angle;
        this.turtle.setX1(turtle.getX());
        this.turtle.setY1(turtle.getY());
        int x = turtle.getX() + ((int)(step * Math.cos(Math.toRadians(angle))));
        int y = turtle.getY() + ((int)(step * Math.sin(Math.toRadians(angle))));
        this.turtle.setLineColor(color);
        this.turtle.setX(x);
        this.turtle.setY(y);
        this.turtle.setAngle(angle);
        this.repaint();
    }
}
