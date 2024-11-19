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
public class Player2 extends Actor
{
    private int leavesEaten;

    public Player2()
    {
        leavesEaten = 0;
    }

    /**
     * Do whatever the wombat likes to to just now.
     */
    public void act()
    {
        if(foundLeaf()) {
            eatLeaf();
        }  
        move();
    }

    /**
     * Check whether there is a leaf in the same cell as we are.
     */
    public boolean foundLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        if(leaf != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Eat a leaf.
     */
    public void eatLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        if(leaf != null) {
            // eat the leaf...
            getWorld().removeObject(leaf);
            leavesEaten = leavesEaten + 1; 
        }
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

    /**
     * Tell how many leaves we have eaten.
     */
    public int getLeavesEaten()
    {
        return leavesEaten;
    }
}
