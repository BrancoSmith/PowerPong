package PowerPong;

import lang.stride.*;
import greenfoot.*;
/**
 * Write a description of class Bola here.
 * @author (your name) @version (a version number or a date)
 */
public class Bola extends Actor
{
    public int speed = 3;
    public int hDirection = 1;//Direita:1 Esquerda:-1
<<<<<<< HEAD
    public int vDirection = 1;//Cima:-1 Baixo=1
    public int res = 0;//Variável pra fazer essa desgraça funcionar
    /**
     * 
     */
    public void act()
    {
        Jogo mundo = (Jogo) getWorld(); 
        if(mundo.cicloAtual()>193){
            movimentoBola();
        }
=======
    public int vDirection = 1;//Cima:-1 Baixo=1    
    
    public void act()
    {
        vaiBola();
        speedUp();
>>>>>>> 6460973f03d83aeb6b733d3453a71b6f8ae851b2
        changeDirection();
        somaPontoUm();
        somaPontoDois();
        addRes();
        speedUp();
        resetRes();
    }

    public void vaiBola(){
        Jogo mundo = (Jogo) getWorld(); 
        if(mundo.cicloAtual()>193){
            movimentoBola();
        }
    }

    public void movimentoBola(){
        int newX = (getX() + hDirection * speed);
        int newY = (getY() + vDirection * speed);
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
            hDirection*= -1;
        }
        if((getY() <= 650) && pong2 != null){
            hDirection*= - 1;
        }
    }

    public void somaPontoUm(){
        if(getX()>= 695){
            Jogo World =(Jogo) getWorld();
            World.acrescentaPontosUm(1);
            World.acrescentaPontosPartida(1);
        }
    }

    public void somaPontoDois(){
        if(getX()<=5){
            Jogo World = (Jogo) getWorld();
            World.acrescentaPontosDois(1);
            World.acrescentaPontosPartida(1);
        }
    }
<<<<<<< HEAD
    
    public void addRes(){//adiciona +1 na variavel res, maximo 8 por causa da repetiçao do n° 1 oito vezes(vlw Matheus)
        Jogo mundo = getWorldOfType(Jogo.class);
        if(mundo.oTempoEstaZerado()){
            this.res = res +1;
           
        }
    }
    
    public void resetRes(){//Faz essa desgraça voltar pra 1
        if(res == 8){
            res = 0;
        }
    }
    
    public void speedUp(){
        if(res == 8){
            speed = speed+2;
        }
    }
    
=======

    public void speedUp(){        
        Jogo mundo = getWorldOfType(Jogo.class);           
        if (mundo.oTempoEstaZerado()){
            this.speed = this.speed+1;
        }                 
    }

>>>>>>> 6460973f03d83aeb6b733d3453a71b6f8ae851b2
    public  Bola(){
        GreenfootImage img = new GreenfootImage(18, 17);
        img.setColor(Color.WHITE);
        img.fillRect(0, 0,img.getWidth()-1, img.getHeight()-1);
        setImage(img);
    }
<<<<<<< HEAD
     
=======
>>>>>>> 6460973f03d83aeb6b733d3453a71b6f8ae851b2
}
