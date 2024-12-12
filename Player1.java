import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.List;
import java.util.ArrayList;

/**
 * Player1. A Player1 moves forward until it can't do so anymore, at
 * which point it turns left. If a wombat finds a leaf, it eats it.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class Player1 extends Wombat
{
    private int leavesEaten;
    private int biomasse;
    private int round;

    public Player1()
    {
        leavesEaten = 0;
        biomasse = 0;
        round = 1;
    }

    /**
     * Do whatever the wombat likes to to just now.
     */
    public void act()
    {
        round++;
        int roundNow=0;
        
        if(foundLeaf()) {
            eatLeaf(); 
            randomLeaves(1);
            if(getBiomassa() == Greenfoot.getRandomNumber(10)){
                Biomassa b = new Biomassa();
                getWorld().addObject(b, getX()-1, getY()-1);
                biomasse++;
            }
        }
        
        if(foundBiomassa()){
            roundNow = round;
            if(round-roundNow <= 5){
                return;
            }
        }
        
        if(nearWombat()){
            
        } else {
            if(getOneObjectAtOffset(1, 0, Wombat.class)!= null){
                
            }
        }
        move();
    }
    
    /**
     * Move one cell forward in the current direction.
     */
    public void move()
    {
      
        if(Greenfoot.isKeyDown("Right")){
            setLocation(getX() + 1, getY());
            setRotation(0);
        }
        
        if(Greenfoot.isKeyDown("Left")){
            setLocation(getX() - 1, getY());
            setRotation(180);
        }
        
        if(Greenfoot.isKeyDown("Up")){
            setLocation(getX(), getY() - 1);
            setRotation(270);
        }
        
        if(Greenfoot.isKeyDown("Down")){
            setLocation(getX(), getY() + 1);
            setRotation(90);
        }
        
    }

}
