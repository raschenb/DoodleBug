/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doodlebug;

/**
 *
 * @author rasch
 */
//Predator Prey Simulation 
//Doodlebugs and ants move around 
//a grid. if a doodlebug lands on an ant 
//the ant is eaten by the doodlebug. 
//If an ant lives for 3 turns it breeds. 
//If a doodlebug lives for 8 turns it breeds 
//If a doodlebug doesnt eat for 3 turns it starves 
 
import java.util.*; 
import java.awt.*; 
import java.io.*; 
import java.lang.*; 
 public class Simulation {
    public static Scanner s = new Scanner(System.in); 

    public static void main(String[] args){ 
        World world = new World(6,100);//////////ants/doodlebugs 
        DisplayFrame disp = new DisplayFrame("DoodleBugs", 20, 20 ); 
        disp.setGrid( world.getCGrid() ); 
        String input = "4"; 
        int timesteps = 2; 
        boolean playing = true; 
        while(playing){ 
            System.out.println("Options: [ENTER] Last timestep."); 
            System.out.println("         [Q]     Quit Simulation."); 
            System.out.println("         [n]     Compute n timesteps."); 
            input = s.nextLine(); 
            if(input.equals("Q")||input.equals("q")){ 
                playing = false; 
                continue; 
            } 
            else if(input.equals("1")){ 
                timestep(timesteps,world); 
            } 
            //else if(isNum(input)){ 
              //  timesteps = Integer.parseInt(input); 
                //timestep(timesteps,world); 
            //} 
            else{ 
               System.out.println("Try again!"); 
              continue; 
            } 
            disp.setGrid( world.getCGrid() ); 
        } 
    } 
    public static void timestep(int timesteps, World w){ 
        for(int i = timesteps; i > 0; i--){ 
            w.moveAll(); 
            w.breedAll(); 
            w.starveAll(); 
    } 
        } 
    public static boolean isNum(String s){ 
        try{ 
            Integer.parseInt(s); 
        } catch(NumberFormatException e)
        { 
            System.out.println(e);
            return false; 
        } 
        return true; 
} 
} 
