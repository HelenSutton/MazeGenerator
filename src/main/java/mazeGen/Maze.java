package mazeGen;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class Maze
{
    int height = 40;
    int width = 50;
    Cell grid[][];
    Random rand = new Random();
    Stack<Cell> mazeStack = new Stack<Cell>();
    Stack<Cell> mazeSolveStack = new Stack <Cell>();

    public Maze()
    {
       grid = new Cell[width][height];
       for (int i = 0; i<width; i++){
           for (int j = 0;j<height; j++){
               grid [i][j]= new Cell();
               grid [i][j].iValue = i;
               grid[i][j].jValue = j;
           }
       }
       this.createMaze();
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
            {
                if (random == 0) {
                    if (j == 0 || grid[i][j-1].visited) {
                        sidesChecked++;
                        random++;
                    } else
                        {
                        foundPath = true;
                        current.top = false;
                        mazeStack.push(current);
                        j--;
                        current = grid[i][j];
                        current.bottom = false;
                    }
                }
                if (random == 1 && sidesChecked < 4) {
                    if (j == height-1 || grid[i][j+1].visited) {
                        sidesChecked++;
                        random++;
                    } else
                        {
                        foundPath = true;
                        current.bottom = false;
                        mazeStack.push(current);
                        j++;
                        current = grid[i][j];
                        current.top = false;
                    }
                }
                if (random == 2 && sidesChecked < 4) {
                    if (i == 0 || grid[i-1][j].visited) {
                        sidesChecked++;
                        random++;
                    }
                    else {
                        foundPath = true;
                        current.left = false;
                        mazeStack.push(current);
                        i--;
                        current = grid[i][j];
                        current.right = false;
                    }
                }
                if (random == 3 && sidesChecked < 4) {
                    if (i == width-1 || grid[i+1][j].visited) {
                        sidesChecked++;
                        random = 0;
                    }
                    else {
                        foundPath = true;
                        current.right = false;
                        mazeStack.push(current);
                        i++;
                        current = grid[i][j];
                        current.left = false;
                    }
                }
                if (sidesChecked == 4 ) {
                    foundPath = true;
                    current = mazeStack.pop();
                    i = current.iValue;
                    j = current.jValue;
                }
            }
        } while(!mazeStack.isEmpty());
    }

    public void solveMaze()
    {
        Cell exit = grid[width-1][height-1];
        int i = 0;
        int j = 0;
        Cell current = grid[i][j];
        mazeSolveStack.push(current);
        current.solveVisited = true;
        while (!(current == exit))
        {
            if (grid[i][j] != grid[0][0] && !grid[i][j].top && !grid[i][j-1].solveVisited)
            {
                j--;
                current = grid[i][j];
                mazeSolveStack.push(current);
                current.solveVisited = true;
            }
            else if(!grid[i][j].bottom && !grid[i][j+1].solveVisited )
            {
                j++;
                current = grid[i][j];
                mazeSolveStack.push(current);
                current.solveVisited = true;
            }
            else if (!grid[i][j].left && !grid[i-1][j].solveVisited)
            {
                i--;
                current = grid[i][j];
                mazeSolveStack.push(current);
                current.solveVisited = true;
            }
            else if (!grid[i][j].right && !grid[i+1][j].solveVisited)
            {
                i++;
                current = grid [i][j];
                mazeSolveStack.push(current);
                current.solveVisited = true;
            }
            else
            {
                mazeSolveStack.pop();
               current = mazeSolveStack.peek();
               i = current.iValue;
               j= current.jValue;
            }

        }

    }

}

