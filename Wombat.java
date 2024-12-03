import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wombat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wombat extends Actor
{
    private int leavesEaten;
    private int biomasse;
    private int round;
   
    
    public void act()
    {
       
    }
    /**
     * Trova una foglia 
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
     * Mangia una foglia
     */
    
    public void eatLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        if(leaf != null) {
            getWorld().removeObject(leaf);
            leavesEaten = leavesEaten + 1; 
        }
    }
    
    /**
     * Generatore di foglie in posizione casuale
     * è possibile specificare il numero di foglie che si vuole posizionare
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
    /**
     * Ritorna il numero di biomasse che sono state posizionate
     */
    public int getBiomassa(){
        return biomasse;
    }
    
    /**
     * Trova la biomassa 
     */
    public boolean foundBiomassa()
    {
        Actor biomassa = getOneObjectAtOffset(0, 0, Biomassa.class);
        if(biomassa != null) {
            return true;
        }
        else {
            return false;
        }
    }
}
