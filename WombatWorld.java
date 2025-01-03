import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage

import java.util.Random;

/**
 * A world where wombats live.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class WombatWorld extends World
{
    /**
     * Create a new world with 8x8 cells and
     * with a cell size of 60x60 pixels
     */
    public WombatWorld() 
    {
        super(12, 12, 60);        
        setBackground("cell.jpg");
    }

    /**
     * Populate the world with a fixed scenario of wombats and leaves.
     */    
    public void populate()
    {
        int x , y;
        Random randomGenerator = new Random();
        Player1 w1 = new Player1();
        addObject(w1, randomGenerator.nextInt(12), randomGenerator.nextInt(12));
        
        do{
            x = randomGenerator.nextInt(getWidth());
            y = randomGenerator.nextInt(getHeight());
        }while(getObjectsAt(x,y,null)==null);
        
        Player2 w2 = new Player2();
        addObject(w2, x, y);
        
        randomLeaves(3);
     
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
                x = Greenfoot.getRandomNumber(getWidth());
                y = Greenfoot.getRandomNumber(getHeight());
            }while(getObjectsAt(x,y,null)==null);
            addObject(leaf, x, y);
        }
    }
    
    
}