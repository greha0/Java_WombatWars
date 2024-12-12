import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.util.List;
import java.util.ArrayList;

/**
 * Player2. A Player2 moves forward until it can't do so anymore, at
 * which point it turns left. If a wombat finds a leaf, it eats it.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class Player2 extends Wombat
{
    private int leavesEaten;
    private int biomasse;
    private int round;

    public Player2()
    {
        leavesEaten = 0;
        biomasse = 0;
        round = 0;
    }

    /**
     * Do whatever the wombat likes to to just now.
     */
    public void act()
    {
        int roundNow = 0;
        if(foundLeaf()) {
            eatLeaf();
            randomLeaves(1);
        }  
        
        if(foundBiomassa()){
            roundNow = round;
            if(round-roundNow <= 5){
                return;
            }
        }
        
        if(getLeavesEaten()  == getBiomassa() + Greenfoot.getRandomNumber(100)){
            Biomassa b = new Biomassa();
            getWorld().addObject(b, getX(), getY());
            biomasse++;
        }
        move();
    }

    /**
     * Move one cell forward in the current direction.
     */
    public void move()
    {
      
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX() + 1, getY());
            setRotation(0);
        }
        
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX() - 1, getY());
            setRotation(180);
        }
        
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY() - 1);
            setRotation(270);
        }
        
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY() + 1);
            setRotation(90);
        }
        
    } 
}
