import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.*;
import javax.swing.border.Border;
import java.util.ArrayList;
import java.util.jar.JarEntry;

public class Main 
{

    public static void main(String[] args) throws FileNotFoundException
    {
        JFrame f=new JFrame("NSMB2 Bingo Board Generator");

        
        JButton b=new JButton("Click Here To Generate a Random Bingo Card");

        ImageIcon yetiIcon = new ImageIcon("./nsmb2Icon.jpg");
        f.setIconImage(yetiIcon.getImage());

        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int[] randomSeeds = new int[25];
                ArrayList<String> currentGoals = new ArrayList<String>();
                
                AnyBingo newBoard = new AnyBingo(currentGoals, randomSeeds);
                newBoard.generateBingoCard(newBoard.generateGoals(newBoard.generateSeeds(newBoard.getSeeds()), newBoard.getGoals()));

                newBoard.printSeeds(newBoard.getSeeds());
                b.setText(("Done! Copy/paste the contents of the BINGOCARD.txt file into bingosync!"));
            }
        });

        
        f.add(b, BorderLayout.SOUTH);
        f.setSize(500,100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}


/**
        int[] randomSeeds = new int[25];
        ArrayList<String> currentGoals = new ArrayList<String>();

        
        //Creating a normal bingo board
        if (bingoType.equalsIgnoreCase("N"))
        {

            
        }
    }
 */
