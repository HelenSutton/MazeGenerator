package mazeGen;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MazeGUI extends JFrame {

    public MazeGUI()
    {
        final MazeComponent mazeComponent = new MazeComponent();
        setTitle("Maze");
        setSize(1100,900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());
        JButton solve = new JButton("Solve");
        solve.addActionListener(e ->{mazeComponent.solve();});
        root.add(mazeComponent, BorderLayout.CENTER);
        root.add(solve, BorderLayout.NORTH);

        setContentPane(root);
    }

}
