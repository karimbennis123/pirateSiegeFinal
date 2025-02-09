import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class TutorialAmouredSkelly extends Crewmen
{
    private int healthPoints = 500;
    private long lastActionTime = 0; 
    
    public TutorialAmouredSkelly()
    {
        GreenfootImage img = getImage();
        img.scale(125, 125); 
    }
    /**
     * Act - do whatever the TutorialAmouredSkelly wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        isFighting();
        isDead();
    }
    
    protected void isFighting(){
        if(isTouching(Enemies.class)){
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastActionTime >= 1200){
                healthPoints -= enemyDamage;
                lastActionTime = currentTime;
            }
        }
    }
    protected void isDead(){
        if(healthPoints <= 0){
         getWorld().removeObject(this);
        }
    }
}
