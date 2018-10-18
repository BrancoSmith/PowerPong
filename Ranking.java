import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Ranking extends World
{

    /**
     * Constructor for objects of class Ranking.
     */
    public Ranking()
    {
        super(700, 390, 1);
        prepare();
    }

    public void act(){
        showText("Ranking", 350, 195);
    }

    /**
     * Prepara o mundo para o início do programa.
     * Ou seja: criar os objetos iniciais e adicioná-los ao mundo.
     */
    private void prepare()
    {
        VoltarInicio voltarinicio2 = new VoltarInicio();
        addObject(voltarinicio2,299,270);
    }
}
