/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doodlebug;


import java.util.*; 
import java.awt.*; 

public class World{ 
    private static Random r= new Random(); 
    private int doodlebugs; 
    private int ants; 
    private static final int SIZE = 20; 
    private Organism[][] oGrid; 

    //constructor\\ 
    World(int d,int a){ 
       oGrid = new Organism[SIZE][SIZE]; 
       doodlebugs = d; 
        ants = a; 
        for(int i = 0; i < d; i++){ 
            boolean isOccupied = true; 
            //potential x & y 
            while(isOccupied){ 
                int potX = r.nextInt(SIZE); 
                int potY = r.nextInt(SIZE); 
                if(oGrid[potX][potY] == null) 
                { 
                    isOccupied = false; 
                    oGrid[potX][potY] = new DoodleBug(this,potX,potY); 
                } 
            } 
        } 
        for(int i = 0; i < a; i++){ 
             boolean isOccupied = true; 
             //potential x & y 
             while(isOccupied){ 
                 int potX = r.nextInt(SIZE); 
                 int potY = r.nextInt(SIZE); 
                 if(oGrid[potX][potY] == null) 
                 { 
                     isOccupied = false; 
                     oGrid[potX][potY] = new Ant(this,potX,potY); 
                 } 
           } 
       } 
    //accessors\\ 
    } 
    public int getdoodlebugs(){ 
        return doodlebugs; 
    } 
    public int getants(){ 
        return ants; 
    } 
   public char[][] getCGrid(){ 
        char[][] grid = new char[SIZE][SIZE];//0 to 19 
        for(int i = 0; i < SIZE; i++){ 
            for(int j = 0;j < SIZE; j++){ 
                if(oGrid[j][i]!=null) 
                    if(oGrid[j][i].getClass().getName().equals("Ant")) 
                        grid[j][i] = 'o'; 
                    else if(oGrid[j][i].getClass().getName().equals("Doodlebug")) 
                        grid[j][i] = 'x'; 
                else 
                    grid[j][i] = ' '; 
            } 
        } 
        return grid; 
    } 
    //mutators\\ 

   public void increasedoodlebugs(){ 
        doodlebugs++; 
    } 
 
    public void decreasedoodlebugs(){ 
        doodlebugs--; 
    } 
 
    public void increaseants(){ 
        ants++; 
    } 

    public void decreaseants(){ 
        ants--; 
    } 
    //methods\\ 
 
    public void moveAll(){ 
        for(int i = 0; i < SIZE; i++){ 
            for(int j = 0;j < SIZE; j++){ 
                if(oGrid[j][i] !=null) 
                    oGrid[j][i].move(); 
            } 
        } 
        for(int i = 0; i < SIZE; i++){ 
            for(int j = 0;j < SIZE; j++){ 
                if(oGrid[j][i] !=null) 
                    oGrid[j][i].moved=false; 
            } 
        } 
    } 
    public void breedAll(){ 
        for(int i = 0; i < SIZE; i++){ 
            for(int j = 0;j < SIZE; j++){ 
                if(oGrid[j][i]!=null) 
                    oGrid[j][i].breed(); 
            } 
        } 
    } 

    public void starveAll(){ 
            for(int i = 0; i < SIZE; i++){ 
                for(int j = 0;j < SIZE; j++){ 
                    if(oGrid[j][i]!=null) 
                        oGrid[j][i].starve(); 
                } 
            } 
    } 

    public boolean isEmpty(int x,int y){ 
        boolean tbr = false; 
        if(oGrid[x][y]==null) 
            tbr = true; 
        return tbr; 
    } 
 
    public boolean isAnt(int x,int y){ 
        boolean tbr = false; 
        if(oGrid[x][y] instanceof Ant) 
        tbr = true; 
        return tbr; 
    } 
    public void setCell(int x, int y, Organism O){ 
        oGrid[x][y] = O; 
    } 
} 

