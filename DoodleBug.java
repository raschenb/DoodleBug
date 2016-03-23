/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doodlebug;
import java.awt.*;
import java.io.*;
import java.util.*;
public class DoodleBug extends Organism{
    private static Random r = new Random();
    private int untilBreed;
    private int untilStarve;
    public DoodleBug( World world,int _x, int _y){
        super(world, _x, _y );
        untilBreed = 8;
        untilStarve = 3;
        moved = true;
    }
    public void move(){
            if(!moved){
                //potential directions in order
                int[] potMoves = new int[4];
                int i = 1;
                potMoves[0] = r.nextInt(4);
                do{
                    do{
                       potMoves[i] = r.nextInt(4);
                    }
                    while(potMoves[i]!=potMoves[i-1]);
                    i++;
                }
                while(i<4);
                i = 0;
                boolean empty = false;
                int oldx = x;
                int oldy = y;
                while(i<4 && !empty){
                   switch(potMoves[i]){
                      case 0:
                          if(x!=0){
                              if(world.isEmpty(x-1,y)){
                                  empty = true;
                                  world.setCell(x-1,y,this);
                                  world.setCell(oldx,y,null);
                                  moved = true;
                                  untilBreed--;
                                  untilStarve--;
                                  x=x-1;
                              }
                          }
                          else if(world.isEmpty(19,y)){

                                  empty = true;
                                  untilBreed--;
                                  untilStarve--;
                                  world.setCell(19,y,this);
                                  world.setCell(oldx,y,null);
                                  moved = true;
                                  x=19;
                          }
                          break;
                      case 1:
                          if(x!=19){
                              if(world.isEmpty(x+1,y)){
                                  untilBreed--;
                                  untilStarve--;
                                  world.setCell(x+1,y,this);
                                  world.setCell(oldx,y,null);
                                  moved = true;
                                  empty = true;
                                  x=x+1;
                              }
                          }
                          else if(world.isEmpty(0,y)){
                                  world.setCell(0,y,this);
                                  world.setCell(oldx,y,null);
                                  moved = true;
                                  empty = true;
                                  x=0;
                                  untilBreed--;
                                  untilStarve--;
                          }
                          break;
                      case 2:
                          if(y!=0){
                              if(world.isEmpty(x,y-1)){
                                  world.setCell(x,y-1,this);
                                  world.setCell(x,oldy,null);
                                  moved = true;
                                  empty = true;
                                  y=y-1;
                                  untilBreed--;
                                  untilStarve--;
                             }
                          }
                          else if(world.isEmpty(x,19)){
                                  world.setCell(x,19,this);
                                  world.setCell(x,oldy,null);
                                  moved = true;
                                  empty = true;
                                  y=19;
                                  untilBreed--;
                                  untilStarve--;
                          }
                          break;
                      case 3:
                          if(y!=19){
                           if(world.isEmpty(x,y+1)){
                                  world.setCell(x,y+1,this);
                                  world.setCell(x,oldy,null);
                                  moved = true;
                                  empty = true;
                                  y=y+1;
                                  untilBreed--;
                                  untilStarve--;
                              }
                          }
                          else if(world.isEmpty(x,0)){
                                  world.setCell(x,0,this);
                                  world.setCell(x,oldy,null);
                                  moved = true;
                                  empty = true;
                                  y=0;
                                  untilBreed--;
                                  untilStarve--;
                          }
                          break;
                }
            i++;
            }
            i= 0;
            while(i<4 && !empty){
                switch(potMoves[i]){
                    case 0:
                     if(x!=0){
                         if(world.isAnt(x-1,y)){
                             empty = true;
                             world.setCell(x-1,y,this);
                             world.setCell(oldx,y,null);
                             moved = true;
                             untilBreed--;
                             untilStarve=3;
                             x=x-1;
                         }
                     }
                    else if(world.isAnt(19,y)){
                             empty = true;
                             untilBreed--;
                             untilStarve=3;
                             world.setCell(19,y,this);
                             world.setCell(oldx,y,null);
                             moved = true;
                             x=19;
                     }
                     break;
                 case 1:
                     if(x!=19){
                         if(world.isAnt(x+1,y)){
                             untilBreed--;
                             untilStarve=3;
                             world.setCell(x+1,y,this);
                             world.setCell(oldx,y,null);
                             moved = true;
                             empty = true;
                             x=x+1;
                         }
                     }
                     else if(world.isAnt(0,y)){
                             world.setCell(0,y,this);
                             world.setCell(oldx,y,null);
                             moved = true;
                             empty = true;
                             x=0;
                             untilBreed--;
                             untilStarve=3;
                     }
                     break;
                 case 2:
                     if(y!=0){
                         if(world.isAnt(x,y-1)){
                             world.setCell(x,y-1,this);
                             world.setCell(x,oldy,null);
                             moved = true;
                             empty = true;
                             y=y-1;
                             untilBreed--;
                             untilStarve=3;
                         }
                     }
                     else if(world.isAnt(x,19)){
                             world.setCell(x,19,this);
                             world.setCell(x,oldy,null);
                             moved = true;
                             empty = true;
                             y=19;
                             untilBreed--;
                             untilStarve=3;
                     }
                     break;
                 case 3:
                     if(y!=19){
                      if(world.isAnt(x,y+1)){
                             world.setCell(x,y+1,this);
                             world.setCell(x,oldy,null);
                             moved = true;
                             empty = true;
                             y=y+1;
                             untilBreed--;
                             untilStarve=3;
                         }
                     }
                     else if(world.isAnt(x,0)){
                             world.setCell(x,y+1,this);
                             world.setCell(x,oldy,null);
                             moved = true;
                             empty = true;
                             y=0;
                             untilBreed--;
                             untilStarve=3;
                     }
                     break;
                }
            i++;
            }
        }
    }
public void breed(){
       if(untilBreed==0){
            //potential directions in order
            int[] potMoves = new int[4];
            int i = 1;
            potMoves[0] = r.nextInt(4);
            do{
                do{
                    potMoves[i] = r.nextInt(4);
                }
                while(potMoves[i]!=potMoves[i-1]);
                i++;
            }
            while(i<4);
            i = 0;
            boolean empty = false;
            int oldx = x;
            int oldy = y;
            while(i<4 && !empty){
                switch(potMoves[i]){
                    case 0:
                        if(x!=0){
                            if(world.isEmpty(x-1,y)){
                                world.setCell(x-1,y,new DoodleBug(world, x-1,y));
                                untilBreed = 3;
                                empty = true;
                            }
                        }
                        else if(world.isEmpty(19,y)){
                                world.setCell(19,y,new DoodleBug(world, 19,y));
                                untilBreed = 3;
                                empty = true;
                        }
                        break;
                    case 1:
                        if(x!=19){
                            if(world.isEmpty(x+1,y)){
                                world.setCell(x+1,y,new DoodleBug(world, x+1,y));
                                untilBreed=3;
                                empty = true;
                            }
                        }
                        else if(world.isEmpty(0,y)){
                            world.setCell(0,y,new DoodleBug(world, 0,y));
                            untilBreed=3;
                            empty = true;
                        }
                        break;
                    case 2:
                        if(y!=0){
                            if(world.isEmpty(x,y-1)){
                            world.setCell(x,y-1,new DoodleBug(world, x,y-1));
                            untilBreed=3;
                            empty = true;
                            }
                        }
                        else if(world.isEmpty(x,19)){
                            world.setCell(x,19,new DoodleBug(world, x,19));
                            untilBreed=3;
                            empty = true;
                        }
                        break;
                    case 3:
                        if(y!=19){
                            if(world.isEmpty(x,y+1)){
                                world.setCell(x,y+1,new DoodleBug(world, x,y+1));
                                untilBreed=3;
                                empty = true;
                            }
                        }
                        else if(world.isEmpty(x,0)){
                            world.setCell(x,0,new DoodleBug(world, x,0));
                            untilBreed=3;
                            empty = true;
                        }
                        break;
                }
            i++;
            }
        }
    }
    public void starve(){
        if(untilStarve==0)
            world.setCell(x,y,null);
    }
}

