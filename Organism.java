/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doodlebug;


public abstract class Organism
{ 
    protected boolean moved; 
    protected int x; 
    protected int y; 
    protected World world; 
 
    public Organism(World w,int _x, int _y){ 
        world = w; 
        x = _x; 
        y = _y; 
    } 

    public void move()
    { 
 
    } 

    public void breed()
    { 

    } 
 
    public void starve()
    { 
 
    } 
} 
