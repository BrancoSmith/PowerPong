import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class IniciaRanking extends Actor
{

    /**
     * Act - do whatever the Ranking wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
         if (Greenfoot.mouseClicked(this)) {
            saiSom();
            Greenfoot.setWorld( new  Ranking());
        }
    }
    
    public void saiSom()
    {
            Inicio World =(Inicio) getWorld();
            World.desligaSom();
        }
}
