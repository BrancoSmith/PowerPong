import lang.stride.*;
import greenfoot.*;

/**
 * Write a description of class Bola here.
 * @author (your name) @version (a version number or a date)
 */
public class Bola extends Actor
{
    public int res = 0;
    public int speed = 3;
    public int hDirection = 1;//Direita:1 Esquerda:-1
    public int vDirection = 1;//Cima:-1 Baixo=1    

    public void act()
    {                               
        vaiBola();
        changeDirection();
        somaPontoUm();
        somaPontoDois();
        addRes();
        speedUp();
        resetRes();
        pegaModificadorGanharPowerBoost();
        pegaModificadorTamanhoDoPad();
    }    

    /*public void moverRandom(){
        int newX = getX() + hDirection * speed * -1;
        int newY = getY() + vDirection * speed * -1;
        Jogo mundo = (Jogo) getWorld(); 
        if(mundo.cicloAtual()>193){
            hDirection*=-1;
        }else{
            vDirection*=+1;
        }
    }*/

    public void pegaModificadorGanharPowerBoost(){
        int meioDoMundo = getWorldOfType(Jogo.class).getWidth() / 2; 
        Actor obj = getOneIntersectingObject(ModificadorGanharPowerBoost.class);
        if (obj != null){
            Greenfoot.playSound("SomGanharPowerBoost.wav");

            getWorldOfType(Jogo.class).removeObject(obj);
            if(meioDoMundo > getX()){
                getWorldOfType(Jogo.class).pong.addTimeBoost();
            }
            else if(meioDoMundo < getX()){
                getWorldOfType(Jogo.class).pong2.addTimeBoost(); 
            }
        }
    }

    public void pegaModificadorTamanhoDoPad(){
        int meioDoMundo = getWorldOfType(Jogo.class).getWidth() / 2; 
        Actor obj = getOneIntersectingObject(ModificadorDeTamanhoPad.class);
        if (obj != null){
            Greenfoot.playSound("SomGanharPowerBoost.wav");

            getWorldOfType(Jogo.class).removeObject(obj);
            if(meioDoMundo > getX()){
                getWorldOfType(Jogo.class).pong.ModificarTamanhoPad();
            }
            else if(meioDoMundo < getX()){
               getWorldOfType(Jogo.class).pong2.ModificarTamanhoPad(); 
            }
        }

    }

    /*public void movimentoAleatorio(boolean moveRandom){
    if(isTouching(BarraCentral.class) && moveRandom){
    changeDirection();
    }
    else{            
    changeDirection();         
    } 
    } */

    public void vaiBola(){
        Jogo mundo = (Jogo) getWorld();
        if(mundo.cicloAtual()>193){
            movimentoBola();
        /*}else{
            moverRandom();
        }*/
        }
    }

    public void movimentoBola(){
        int newX = getX() + hDirection * speed;
        int newY = getY() + vDirection * speed;
        setLocation(newX,newY);        
    }

    public void changeDirection(){
        Pong pong = (Pong)getOneIntersectingObject(Pong.class);
        Pong2 pong2 = (Pong2)getOneIntersectingObject(Pong2.class);         
        if(getX()>=getWorld().getWidth() - 5){
            hDirection*=-1;
        }
        if(getY()>=getWorld().getHeight() - 5){
            vDirection*=-1;
        }
        if(getX() <= 5){
            hDirection*=-1;
        }
        if(getY() <= 5){
            vDirection*=-1;
        }
        if(getY() <= 30 && isTouching(BarraLateral.class)){
            vDirection*=-1;
        }
        if(getY() <= 367 && isTouching(BarraLateral2.class)){
            vDirection*=-1;
        }
        if((getX() <= 60) && pong != null){
            Greenfoot.playSound("ToquePong.wav");
            hDirection*= -1;
        }
        if((getY() <= 650) && pong2 != null){
            Greenfoot.playSound("ToquePong.wav");
            hDirection*= - 1;
        }
    }

    public void somaPontoUm(){
        if(getX()>= 695){
            Greenfoot.playSound("FazGol.wav");
            Jogo World =(Jogo) getWorld();
            World.acrescentaPontosUm(1);
            World.acrescentaPontosPartida(1);
            setLocation(getX(),getY());
            setLocation(67, 198);            
        }                    
    }

    public void somaPontoDois(){
        if(getX()<=5){
            Greenfoot.playSound("FazGol.wav");
            Jogo World = (Jogo) getWorld();
            World.acrescentaPontosDois(1);
            World.acrescentaPontosPartida(1);
            setLocation(644, 198);
        }
    }

    public void addRes(){        
        Jogo mundo = getWorldOfType(Jogo.class);           
        if (mundo.oTempoEstaZerado()){
            Greenfoot.playSound("SomSpeedUp.wav");
            res = res+1;
        }                 
    }

    public void speedUp(){
        if(res == 8){
            speed = speed+2;
        }
    }

    public void resetRes(){
        if(res == 8){
            res = 0;
        }
    }

    public Bola(){
        GreenfootImage img = new GreenfootImage(18, 17);
        img.setColor(Color.WHITE);
        img.fillRect(0, 0,img.getWidth()-1, img.getHeight()-1);
        setImage(img);
    }        
}
