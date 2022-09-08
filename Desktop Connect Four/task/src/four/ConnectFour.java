package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class ConnectFour extends JFrame {

    int rows = 6, cols =7;
    Cells[][] cells = new Cells[cols][rows];
    ButtonReset resetButton = new ButtonReset();
    boolean hasWinner = false;

    public ConnectFour() {
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(mainPanel());
        setVisible(true);
        setLayout(null);
        setTitle("Connect Four");
    }

    public void resetGame(){
        this.getContentPane().invalidate();
        this.getContentPane().validate();
        this.getContentPane().repaint();
    }

    private JPanel mainPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(createPanel());
        panel.add(resetPanel());
        return panel;
    }


    private JPanel resetPanel(){
        JPanel panel = new JPanel();
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Cells[] cells: cells){
                   for(Cells cell: cells){
                        cell.setLabel(" ");
                        cell.setBackground(null);
                        cell.setPickedBy(0);
                    }
                }
                Cells.playerOneTurn = true;
                resetGame();
                hasWinner = false;
            }
        });
        panel.add(resetButton);
        panel.setMaximumSize(new Dimension(100, 50));
        return panel;
    }

    private JPanel createPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rows, cols));
        int currentRows = 0, currentCols = 0;
        while(currentCols < cols && currentRows < rows ){
            cells[currentCols][currentRows] = new Cells(currentCols, currentRows);
            panel.add(cells[currentCols][currentRows]);
            currentCols++;
            if(currentCols == cols){
                currentCols = 0;
                currentRows++;
            }
        }
        createCellLabels();
        return panel;
    }

    private void checkWinCon(int player){
        for (int i = 5; i >=0; i--){
            for (int j = 6; j >= 0; j--){
                if(cells[j][i].pickedBy == player &&
                        cells[j][i-1].pickedBy == player &&
                        cells[j][i-2].pickedBy == player &&
                        cells[j][i-3].pickedBy == player
                ){
                    cells[j][i].setBackground(Color.CYAN);
                    cells[j][i-1].setBackground(Color.CYAN);
                    cells[j][i-2].setBackground(Color.CYAN);
                    cells[j][i-3].setBackground(Color.CYAN);
                    hasWinner = true;
                }
                if(cells[j][i].pickedBy == player &&
                        cells[j-1][i-1].pickedBy == player &&
                        cells[j-2][i-2].pickedBy == player &&
                        cells[j-3][i-3].pickedBy == player
                ){
                    cells[j][i].setBackground(Color.CYAN);
                    cells[j-1][i-1].setBackground(Color.CYAN);
                    cells[j-2][i-2].setBackground(Color.CYAN);
                    cells[j-3][i-3].setBackground(Color.CYAN);
                    hasWinner = true;
                }
                if(cells[j][i].pickedBy == player &&
                        cells[j-1][i].pickedBy == player &&
                        cells[j-2][i].pickedBy == player &&
                        cells[j-3][i].pickedBy == player
                ){
                    cells[j][i].setBackground(Color.CYAN);
                    cells[j-1][i].setBackground(Color.CYAN);
                    cells[j-2][i].setBackground(Color.CYAN);
                    cells[j-3][i].setBackground(Color.CYAN);
                    hasWinner = true;
                }
                if(cells[j][i].pickedBy == player &&
                        cells[j+1][i-1].pickedBy == player &&
                        cells[j+2][i-2].pickedBy == player &&
                        cells[j+3][i-3].pickedBy == player
                ){
                    cells[j][i].setBackground(Color.CYAN);
                    cells[j+1][i-1].setBackground(Color.CYAN);
                    cells[j+2][i-2].setBackground(Color.CYAN);
                    cells[j+3][i-3].setBackground(Color.CYAN);
                    hasWinner = true;
                }
            }
        }
    }
    private void createCellLabels(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j< cols; j++){
                cells[j][i].setLabel(" ");
                cells[j][i].setCellName("Button" + String.valueOf((char)(j + 65)) +"" + String.valueOf(rows-i));
                int finalJ = j;
                cells[j][i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int checkRows = rows-1;
                        while (checkRows >= 0) {
                            if(Objects.equals(cells[finalJ][checkRows].getLabel(), " ")){
                                if(!hasWinner){
                                cells[finalJ][checkRows].setCellLabel();;
                                if(!Cells.playerOneTurn){
                                    cells[finalJ][checkRows].setPickedBy(1);
                                    checkWinCon(1);
                                }else{
                                    cells[finalJ][checkRows].setPickedBy(2);
                                    checkWinCon(2);
                                }
                                }
                                break;
                            }else{
                                checkRows--;
                            }
                        }
                    }

                });
            }
        }
    }

}