/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekti;

/**
 *
 * @author maxki
 */
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
//import java.awt.Dimension;

public class Este {

    //private Auto auto;
    private int xe;
    private int ye;
    private int nopeus = 5;
    private double malli;
    //private int width;
    //private int height;

    private Image image;

    public Este() {

        initEste();
    }

    public void initEste() {
        ye = 0;
        xe = (int) (Math.random() * 450);
        malli = Math.random();
        if(malli <= 0.5){
            ImageIcon kuva = new ImageIcon("src/images/object_cactus.png");
            image = kuva.getImage();
        }else{
            ImageIcon kuva = new ImageIcon("src/images/object_rock.png");
            image = kuva.getImage();
        }
    }

    protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    public Image getImage() {
        return image;
    }
    
    public double getMalli(){
        return malli;
    }
    
    public void setRaha(){
        ImageIcon kuva = new ImageIcon("src/images/object_moneybag.png");
        image = kuva.getImage();
    }
    
    public void setKilpi(){
        ImageIcon kuva = new ImageIcon("src/images/object_heart.png");
        image = kuva.getImage();
    }
    
    public void setVauhti(){
        ImageIcon kuva = new ImageIcon("src/images/object_2X.png");
        image = kuva.getImage();
    }

    /*public void setExplosion() {
        ImageIcon kuvae = new ImageIcon("src/images/explosion.png");
        image = kuvae.getImage();
        this.xe = auto.getX();
        this.ye = auto.getY();
    }*/

    public int getX() {
        return xe;
    }

    public int getY() {
        return ye;
    }
    
    public void setX(int x){
        this.xe = x;
    }
    
    public void setY(int y){
        this.ye = y;
    }

    public void esteMove() {
        ye = ye + this.nopeus;
    }
    
    /*public void upNopeus(){
        this.nopeus = this.nopeus + 5;
    }
    */
    public int getNopeus(){
        return nopeus;
    }
    
    public void setNopeus(int nopeutus){
        this.nopeus = this.nopeus + nopeutus;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(xe, ye, 50, 90);
    }
}
