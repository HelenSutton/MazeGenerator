package mazeGen;
import java.util.Random;
import java.util.Stack;

public class Maze
{
    int height = 20;
    int width = 20;
    Cell grid[][];
    Random rand = new Random();
    Stack<Cell> mazeStack = new Stack<Cell>();

    public Maze()
    {
       grid = new Cell[width][height];
       for (int i = 0; i<width; i++){
           for (int j = 0;j<height; j++){
               grid [i][j]= new Cell();
           }
       }
    }

    public void createMaze()
    {
        //create start
        grid[0][0].top = false;
        //create end
        grid [width-1][height-1].bottom= false;
        int i = 0;
        int j = 0;
        Cell current = grid [i][j];
        int random;
        int sidesChecked;
        boolean foundPath;
        do
        {
            random = rand.nextInt(4);
            sidesChecked = 0;
            current.visited = true;
            foundPath = false;
            while (!foundPath)
            if (random == 0)
            {
                if (j == 0 || grid [i][j--].visited )
                {
                    sidesChecked++;
                    random++;
                }
                else
                {
                    foundPath = true;
                    current.top = false;
                    mazeStack.push(current);
                    j--;
                    current = grid[i][j];
                    current.bottom = false;
                }
            }
            if (random == 1 && sidesChecked < 4)
            {
                if (j == height-- || grid [i][j++].visited)
                {
                    sidesChecked++;
                    random++;
                }
                else
                {
                    foundPath = true;
                    current.bottom = false;
                    mazeStack.push(current);
                    j++;
                    current = grid [i][j];
                    current.top = false;
                }
            }
            if (random == 2 && sidesChecked < 4)
            {
                if (i == 0 || grid [i--][j].visited)
                {
                    sidesChecked++;
                    random++;
                }
                else
                {
                    foundPath = true;
                    current.left = false;
                    mazeStack.push(current);
                    i--;
                    current = grid [i][j];
                    current.right = false;
                }
            }
            if (random == 3 && sidesChecked < 4)
            {
                if (i == width-- || grid [i++][j].visited)
                {
                    sidesChecked++;
                    random++;
                }
                else
                {
                    foundPath = true;
                    current.right = false;
                    mazeStack.push(current);
                    i++;
                    current = grid[i][j];
                    current.left = false;
                }
            }
            if (sidesChecked == 4)
            {
                foundPath = true;
                current = mazeStack.pop();
            }

        }
        while(!mazeStack.empty());
    }
    public void print (){
        for (int i = 0; i<width; i++){
            for (int j = 0;j<height; j++){
                 System.out.println("visited = "+ grid [i][j].visited + " top " +grid [i][j].top
                 + "bottom " + grid [i][j].bottom);
            }
        }


    }
}

