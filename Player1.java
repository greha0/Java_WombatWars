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
public class Player1 extends Actor
{
    private int leavesEaten;

    public Player1()
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
            World world = getWorld();
            world.randomLeaves(1);
            
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

    /**
     * Tell how many leaves we have eaten.
     */
    public int getLeavesEaten()
    {
        return leavesEaten;
    }

}
