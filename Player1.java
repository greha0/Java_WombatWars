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
        
        if(foundLeaf()) {
            eatLeaf(); 
            randomLeaves(1);
        }
        
        if(getLeavesEaten()  == getBiomassa() + Greenfoot.getRandomNumber(100)){
            Biomassa b = new Biomassa();
            getWorld().addObject(b, getX(), getY());
            biomasse++;
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
    
    /**
     * Place a number of leaves into the world at random places.
     * The number of leaves can be specified.
     */
    public void randomLeaves(int howMany)
    {
        for(int i=0; i<howMany; i++) {
            Leaf leaf = new Leaf();
            int x = 0;
            int y = 0;
            do{
                x = Greenfoot.getRandomNumber(getWorld().getWidth());
                y = Greenfoot.getRandomNumber(getWorld().getHeight());
            }while(getWorld().getObjectsAt(x,y,null)==null);
            getWorld().addObject(leaf, x, y);
        }
    }
    
    public int getBiomassa(){
        return biomasse;
    }
    
    

}
