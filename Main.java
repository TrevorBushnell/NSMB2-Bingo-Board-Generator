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
import java.util.ArrayList;

public class Main 
{

    public static void main(String[] args) throws FileNotFoundException
    {
        JFrame f=new JFrame("NSMB2 Bingo Board Generator");

        
        JButton b=new JButton("Click Here To Generate a Random Bingo Card");

        ImageIcon nsmb2Icon = new ImageIcon("./nsmb2Icon.jpg");
        f.setIconImage(nsmb2Icon.getImage());

        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    fileWriting();
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                b.setText(("Done! Copy/paste the contents of the BINGOCARD.txt file into bingosync!"));
            }
        });

        
        f.add(b, BorderLayout.SOUTH);
        f.setSize(500,100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }


    // Maybe this will fix my problem?
    public static void fileWriting() throws FileNotFoundException
    {
        BingoBoard board = new BingoBoard();
        board.generateSeeds(board.getSeeds());
        board.addGoalsToStorage();
    }
}