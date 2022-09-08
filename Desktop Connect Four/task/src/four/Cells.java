package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cells  extends JButton {
    int col, row;
    static boolean playerOneTurn = true;
    int pickedBy = 0;
    Cells(int col, int row) {
        this.col = col;
        this.row = row;
        this.setFocusPainted(false);
        this.setMargin(new Insets(0, 0, 0, 0));
    }

    public void setCellName(String name){
        this.setName(name);
    }

    public void setCellLabel() {
        if (playerOneTurn){
            this.setLabel("X");
            playerOneTurn = false;
        } else{
            this.setLabel("O");
            playerOneTurn = true;
        }
    }

    public boolean getPlayerTurn(){
        return playerOneTurn;
    }

    public void setPickedBy(int player){
        pickedBy = player;
    }





}
