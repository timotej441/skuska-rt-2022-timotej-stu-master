package sk.stuba.fei.uim.oop;

import lombok.Getter;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Controller extends ControllerAdapter{
    @Getter
    private Render render;
    @Getter
    private JLabel actionLabel;
    @Getter
    private JLabel colorLabel;

    private JPanel menu;

    private Color color;

    private String action;

    private int step;

    private int angle;

    private String colorName;

    public Controller(JPanel menu){
        this.menu = menu;
        this.render = new Render();
        this.action = Window.ACTION;
        this.color = Color.RED;
        this.colorName = "Red";
        this.actionLabel = new JLabel(" ",SwingConstants.CENTER);
        this.colorLabel = new JLabel(" ",SwingConstants.CENTER);
        this.step = 10;
        this.angle = 45;
        this.updateLabels();
    }

    public void repaint(){
        this.render.repaint();
    }

    private void updateLabels(){
        this.actionLabel.setText("step:" + step + " angle:" + angle);
        this.colorLabel.setText(colorName);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals(Window.COLOR)){
            this.cycleColor();
        }
        else if(e.getActionCommand().equals(Window.ACTION)){
            this.render.moveTurtle(angle,step,color);
        }
        updateLabels();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.step = ((JSlider) e.getSource()).getValue();
        updateLabels();
    }

    @Override
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                this.render.moveTurtle(0,step,color);
                break;
            case KeyEvent.VK_DOWN:
                this.render.moveTurtle(0,(-1)*step,color);
                break;
            case KeyEvent.VK_LEFT:
                this.render.moveTurtle((-1)*angle,0,color);
                break;
            case KeyEvent.VK_RIGHT:
                this.render.moveTurtle(angle,0,color);
        }
    }

    private void cycleColor(){
        if(this.color.equals(Color.RED)){
            this.color = Color.BLUE;
            this.colorName = "Blue";
        }
        else if(this.color.equals(Color.BLUE)){
            this.color = Color.GREEN;
            this.colorName = "Green";
        }
        else if(this.color.equals(Color.GREEN)){
            this.color = Color.RED;
            this.colorName = "Red";
        }
        this.updateLabels();
    }

    public void setAngle(String s){
        this.angle = Integer.parseInt(s);
        updateLabels();
    }
}
