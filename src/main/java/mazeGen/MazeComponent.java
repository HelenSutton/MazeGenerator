package mazeGen;
import javax.swing.*;
import java.awt.*;

public class MazeComponent extends JComponent {
    private static int startX = 5;
    private static int startY = 5;
    private static int length = 10;

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Maze maze = new Maze();

        maze.createMaze();
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.BLACK);
        for (int i = 0; i < maze.width; i++)
        {
            for (int j = 0; j < maze.height; j++)
            {
                if (maze.grid[i][j].top)
                {
                    g2.drawLine(startX +(i * length), startY + (j * length),
                            startX + ((i+1)*length), startY + (j * length));
                }
                if (maze.grid[i][j].bottom)
                {
                    g2.drawLine(startX +(i * length), startY + ((j+1) * length),
                            startX + ((i+1)*length), startY + ((j+1) * length));

                }
                if (maze.grid[i][j].right)
                {
                    g2.drawLine(startX +((i+1) * length), startY + (j * length),
                            startX + ((i+1)*length), startY + ((j+1) * length));

                }
                if (maze.grid[i][j].left)
                {
                    g2.drawLine(startX +(i * length), startY + (j * length),
                            startX + (i*length), startY + ((j+1) * length));

                }
            }
        }

    }
}
