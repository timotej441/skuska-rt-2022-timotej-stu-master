package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Window {

    public static final String ACTION = "ACTION";
    public static final String COLOR = "COLOR";
    public static final String[] ANGLE = {"0", "5" ,"10", "45", "90" , "180"};

    public Window(){
        JFrame frame = new JFrame("Drawing RT");
        JPanel menu = new JPanel();
        Controller logic = new Controller(menu);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,900);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(logic.getRender(), BorderLayout.CENTER);
        frame.addKeyListener(logic);
        frame.requestFocus();

        JComboBox comboBox = new JComboBox(ANGLE);
        comboBox.setSelectedItem("45");
        comboBox.setFocusable(false);
        comboBox.addActionListener(e -> {
            logic.setAngle((String) Objects.requireNonNull(comboBox.getSelectedItem()));
        });

        JSlider slider = new JSlider(0,100,10);
        slider.setMajorTickSpacing(10);
        slider.setSnapToTicks(true);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setFocusable(false);
        slider.addChangeListener(logic);

        JButton action = new JButton(ACTION);
        action.addActionListener(logic);
        action.setFocusable(false);

        JButton color = new JButton(COLOR);
        color.addActionListener(logic);
        color.setFocusable(false);

        menu.setLayout(new GridLayout(2,6));
        menu.add(comboBox);
        menu.add(slider);
        menu.add(action);
        menu.add(logic.getActionLabel());
        menu.add(color);
        menu.add(logic.getColorLabel());
        frame.add(menu, BorderLayout.PAGE_END);
        frame.setVisible(true);
    }
}
