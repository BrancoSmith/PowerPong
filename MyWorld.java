import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 390, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        BarraLateral barraLateral = new BarraLateral();
        addObject(barraLateral,350,22);
        BarraLateral barraLateral2 = new BarraLateral();
        addObject(barraLateral2,350,367);
        Score score = new Score();
        addObject(score,22,8);
        Score score2 = new Score();
        addObject(score2,614,8);
        Time time = new Time();
        addObject(time,459,9);
        Match match = new Match();
        addObject(match,192,8);
        time.setLocation(476,12);
        match.setLocation(218,9);
        time.setLocation(473,13);
        time.setLocation(487,14);
        time.setLocation(483,12);
        time.setLocation(485,57);
        removeObject(time);
        Time time2 = new Time();
        addObject(time2,459,9);
        BarraCentral barraCentral = new BarraCentral();
        addObject(barraCentral,358,195);
    }
}
