/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Projekti;


import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
//import java.awt.Dimension;

public class Auto {

    //private int height;
    //private int width;
    private double dx;
    private double dy;
    private int x;
    private int y;
    private Image image;
    int väri = 0;
    double nopeus = 10;

    public Auto() {

        initAuto();
    }

    private void initAuto() {
        ImageIcon kuvared = new ImageIcon("src/images/car_red.png");

        image = kuvared.getImage();

        x = 200;
        y = 800;
    }

    public void move() {
        if (x > 0 && dx < 0 || x < 450 && dx > 0) {
            x += dx;
        }
        if (y > 0 && dy < 0 || y < 875 && dy > 0) {
            y += dy;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            ImageIcon kuvared = new ImageIcon("src/images/car_red_angle2.png");
            image = kuvared.getImage();
            dx = -1 * nopeus;

        }

        if (key == KeyEvent.VK_RIGHT) {
            ImageIcon kuvared = new ImageIcon("src/images/car_red_angle1.png");
            image = kuvared.getImage();
            dx = 1 * nopeus;

        }

        if (key == KeyEvent.VK_UP) {

            dy = -1 * nopeus;

        }

        if (key == KeyEvent.VK_DOWN) {

            dy = 1 * nopeus;

        }

        /*if (key == KeyEvent.VK_1) {

            ImageIcon kuvared = new ImageIcon("src/images/car_red.png");
            image = kuvared.getImage();
            nopeus = 10;
        }

        if (key == KeyEvent.VK_2) {

            ImageIcon kuvablack = new ImageIcon("src/images/car_black.png");
            image = kuvablack.getImage();
            nopeus = 10;
        }

        if (key == KeyEvent.VK_3) {

            ImageIcon kuvablue = new ImageIcon("src/images/car_blue.png");
            image = kuvablue.getImage();
            nopeus = 5;
        }

        if (key == KeyEvent.VK_4) {

            ImageIcon kuvayellow = new ImageIcon("src/images/car_yellow.png");
            image = kuvayellow.getImage();
            nopeus = 8;
        }

        if (key == KeyEvent.VK_5) {

            ImageIcon kuvagreen = new ImageIcon("src/images/car_green.png");
            image = kuvagreen.getImage();
            nopeus = 9;
        }*/
        
        if (key == KeyEvent.VK_K) {

            ImageIcon kuvared = new ImageIcon("src/images/explosion.png");
            image = kuvared.getImage();
            nopeus = 0;
        }

    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            ImageIcon kuvared = new ImageIcon("src/images/car_red.png");
            image = kuvared.getImage();
            dx = 0;

        }

        if (key == KeyEvent.VK_RIGHT) {
            ImageIcon kuvared = new ImageIcon("src/images/car_red.png");
            image = kuvared.getImage();
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {

            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 87);
    }
    
    public void setNopeus(){
        nopeus = nopeus * 2;
    }
    
    public void setHitaus(){
        nopeus = nopeus / 2;
    }
    
    
}
