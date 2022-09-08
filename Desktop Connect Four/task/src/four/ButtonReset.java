package four;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonReset extends JButton implements ActionListener {

    ButtonReset(){
        this.setLabel("Reset");
        this.setName("ButtonReset");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
