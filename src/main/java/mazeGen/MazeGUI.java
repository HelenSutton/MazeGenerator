package mazeGen;
import javax.swing.*;
import java.awt.*;

public class MazeGUI extends JFrame {

    public MazeGUI()
    {
        MazeComponent mazeComponent = new MazeComponent();
        setTitle("Maze");
        setSize(1100,1100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());
        root.add(mazeComponent, BorderLayout.CENTER);
        setContentPane(root);
    }

}
