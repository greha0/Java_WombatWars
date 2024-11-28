import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Timer;
/**
 * Write a description of class Biomassa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Biomassa extends Actor
{
    int act = 0;
    /**
     * Act - do whatever the Biomassa wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(act == 20){
            World myWorld = getWorld();
            myWorld.removeObject(this);
        }
      act++;
    }
    
    
}
