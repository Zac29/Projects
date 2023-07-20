import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class tic_tac_toe implements ActionListener
{
    private JFrame f;
    private JPanel p;
    private JButton[] buttons = new JButton[9];
    private boolean xTurn=true;

    public tic_tac_toe()
    {
        f=new JFrame("Tic_Tac_Toe");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        p=new JPanel();
        p.setLayout(new GridLayout(3,3));
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        for(int i=0 ; i<9 ; i++)
        {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Cursive", Font.PLAIN,60));
            buttons[i].addActionListener(this);
            p.add(buttons[i]);
        }
        f.add(p,BorderLayout.CENTER);
        f.setSize(600, 600);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton button = (JButton) e.getSource();
        if(xTurn)
        {
            button.setText("X");

        }
        else
        {
            button.setText("0");
        }

        button.setEnabled(false);
        xTurn = !xTurn;

        checkForWinner();
    }
    public void checkForWinner()
    {
         //For Rows
        for(int i=0 ; i<9 ; i+=3)
         {
            if (buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText()) && !buttons[i].isEnabled())
            {
            JOptionPane.showMessageDialog(f, buttons[i].getText() +"Wins !" );
            resetGame();
            return ;
            }
        }
        //For Diagonals
        if (buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && !buttons[0].isEnabled()) 
        {
            JOptionPane.showMessageDialog(f, buttons[0].getText() + " Wins !");
            resetGame();
            return;
        }
        if (buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && !buttons[2].isEnabled()) 
        {
            JOptionPane.showMessageDialog(f, buttons[2].getText() + " wins !");
            resetGame();
            return;
        }
        // Check for Tie
        boolean tie = true;
        for (int i = 0 ; i < 9 ; i++)
        {
            if(buttons[i].isEnabled())
            {
                tie = false;
                break;
            }
        }
        if(tie)
        {
            JOptionPane.showMessageDialog(p,"Tie Game !");
            resetGame();
        }
    }

    public void resetGame()
    {
        for(int i = 0 ; i < 9 ; i++)
        {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        xTurn = true; 
    }
    public static void main(String[] args) 
    {
        new tic_tac_toe();
    }
}

