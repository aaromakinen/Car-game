/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekti;

//import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Rectangle;
//import javax.swing.ImageIcon;
//import java.util.Random;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Auto auto;
    private final int DELAY = 10;
    private boolean ingame;
    private int life = 1;
    private int pisteet;
    private int info = 0;
    private int credit = 0;
    private int nopeusJuttu = 0;
    private int xkesto = 0;
    private int vauhti = 0;
    private int rahaKesto = 0;
    private int raha = 0;
    private int hpKesto = 0;
    private int hp = 0;
    private int kiviMode = 0;
    
    Este este;
    Este este2;
    Este este3;
    Este este4;
    Este este5;
    Este este6;
    Este este7;

    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        ingame = true;
        pisteet = 0;
        auto = new Auto();
        timer = new Timer(DELAY, this);
        timer.start();
        este = new Este();

        este2 = new Este();

        este3 = new Este();
        
        este4 = new Este();
        
        este5 = new Este();
        
        este6 = new Este();
        
        este7 = new Este();
        
        este.setX(-100);
        este2.setX(-100);
        este3.setX(-100);
        este4.setX(-100);
        este5.setX(-100);
        este6.setX(-100);
        este7.setX(-100);
    }

    @Override
    public void paintComponent(Graphics g) {
        if (ingame == true) {
            super.paintComponent(g);

            doDrawing(g);

            Toolkit.getDefaultToolkit().sync();
        } else {
            drawGameOver(g);
            inGame();
            
        }

    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(auto.getImage(), auto.getX(), auto.getY(), this);
        g2d.drawImage(este.getImage(), este.getX(), este.getY(), this);
        g2d.drawImage(este2.getImage(), este2.getX(), este2.getY(), this);
        g2d.drawImage(este3.getImage(), este3.getX(), este3.getY(), this);
        g2d.drawImage(este4.getImage(), este4.getX(), este4.getY(), this);
        g2d.drawImage(este5.getImage(), este5.getX(), este5.getY(), this);
        g2d.drawImage(este6.getImage(), este6.getX(), este6.getY(), this);
        g2d.drawImage(este7.getImage(), este7.getX(), este7.getY(), this);
        
        drawPisteet(g);
        
        if(this.life == 0){
            drawGameOver(g);
        }
        
        if(info == 1){
            drawInfo(g);
            timer.stop();
        }
        
        if(credit == 1){
            drawCredit(g);
            timer.stop();
        }
        
        if(vauhti == 1){
            drawSpeed(g);
        }
        
        if(raha == 1){
            drawRaha(g);
        }
        
        if(hp == 1){
            drawHP(g);
        }
        
        if(kiviMode == 1){
            drawKivimode(g);
        }
        
    }

    private void drawGameOver(Graphics g) {

    String msg = "HÄVISIT PELIN!!! PISTEESI: " + pisteet;
    Font small = new Font("Helvetica", Font.BOLD, 20);
    FontMetrics fm = getFontMetrics(small);

    g.setColor(Color.white);
    g.setFont(small);
    g.drawString(msg, (500 - fm.stringWidth(msg)) / 2,
            500 / 2);
    }
    
    private void drawSpeed(Graphics g) {

    String msg = "2X SPEED ACTIVATED!!!";
    Font small = new Font("Helvetica", Font.BOLD, 20);
    FontMetrics fm = getFontMetrics(small);

    g.setColor(Color.red);
    g.setFont(small);
    g.drawString(msg, (500 - fm.stringWidth(msg)) / 2,
            300 / 2);
    }
    
    private void drawKivimode(Graphics g) {

    String msg = "KIVIMODE ON";
    Font small = new Font("Helvetica", Font.BOLD, 20);
    FontMetrics fm = getFontMetrics(small);

    g.setColor(Color.blue);
    g.setFont(small);
    g.drawString(msg, (500 - fm.stringWidth(msg)) / 2,
            250 / 2);
    }
    
    private void drawHP(Graphics g) {

    String msg = "1 UP";
    Font small = new Font("Helvetica", Font.BOLD, 20);
    FontMetrics fm = getFontMetrics(small);

    g.setColor(Color.green);
    g.setFont(small);
    g.drawString(msg, (500 - fm.stringWidth(msg)) / 2,
            350 / 2);
    }
    
    private void drawRaha(Graphics g) {

    String msg = "+500 Score!!!";
    Font small = new Font("Helvetica", Font.BOLD, 20);
    FontMetrics fm = getFontMetrics(small);

    g.setColor(Color.yellow);
    g.setFont(small);
    g.drawString(msg, (500 - fm.stringWidth(msg)) / 2,
            400 / 2);
    }
    
    private void drawInfo(Graphics g) {

        String msg = "Nuolinäppäimet - Liikkuminen";
        String msg2 = "Kerää pisteitä selviämällä";
        String msg3 = "Väistä kiviä ja kaktuksia";
        String msg4 = "Kerää rahasäkkejä, nopeutuksia ja suojakilpiä";
        String msg5 = "O = Jatka";
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (500 - fm.stringWidth(msg)) / 2, 500 / 2);
        g.drawString(msg2, (500 - fm.stringWidth(msg)) / 2, 550 / 2);
        g.drawString(msg3, (500 - fm.stringWidth(msg)) / 2, 600 / 2);
        g.drawString(msg4, (500 - fm.stringWidth(msg)) / 2, 650 / 2);
        g.drawString(msg5, (500 - fm.stringWidth(msg)) / 2, 700 / 2);
    }
    
    private void drawPisteet(Graphics g) {

        String msg = "Score: " + pisteet;
        String msg2 = "Lives: " + life;
        String msg3 = "R = Restart";
        String msg4 = "I = Info";
        String msg5 = "C = Credits";
        
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (125 - fm.stringWidth(msg)) / 2, 50 / 2);
        g.drawString(msg2, (125 - fm.stringWidth(msg)) / 2, 100 / 2);
        g.drawString(msg3, (125 - fm.stringWidth(msg)) / 2, 150 / 2);
        g.drawString(msg4, (125 - fm.stringWidth(msg)) / 2, 200 / 2);
        g.drawString(msg5, (125 - fm.stringWidth(msg)) / 2, 250 / 2);
    }
    
    private void drawCredit(Graphics g) {

        String msg = "Ohjelmointi - Max Kivi";
        String msg2 = "Ohjelmointi - Aaro Mäkinen";
        String msg3 = "Grafiikat - Jarno Sirén";
        String msg4 = "V = Jatka";
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (500 - fm.stringWidth(msg)) / 2, 500 / 2);
        g.drawString(msg2, (500 - fm.stringWidth(msg)) / 2, 550 / 2);
        g.drawString(msg3, (500 - fm.stringWidth(msg)) / 2, 600 / 2);
        g.drawString(msg4, (500 - fm.stringWidth(msg)) / 2, 650 / 2);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(pisteet%300 == 0){
            nopeusJuttu = nopeusJuttu + 1;
        }
        
        if (este.getY() >= 1000) {
            este = new Este();
            este.setNopeus(nopeusJuttu);
        }
        if (este2.getY() >= 1333 && este.getY() == 300) {
            este2 = new Este();
            este2.setNopeus(nopeusJuttu);
        }

        if (este3.getY() >= 1666) {
            este3 = new Este();
            este3.setNopeus(nopeusJuttu);
        }
        
        if (este5.getY() >= 3000) {
            este5 = new Este();
            este5.setRaha();
            este5.setNopeus(nopeusJuttu);
        }
        
        if (este6.getY() >= 6000) {
            este6 = new Este();
            este6.setKilpi();
            este6.setNopeus(nopeusJuttu);
        }
        
        if (este7.getY() >= 12000) {
            este7 = new Este();
            este7.setVauhti();
            este7.setNopeus(nopeusJuttu);
        }
        
        pisteet = pisteet + 1;
        auto.move();
        este.esteMove();
        este2.esteMove();
        este3.esteMove();
        este5.esteMove();
        este6.esteMove();
        este7.esteMove();
        checkCollisions();
        //faster();
        repaint();
        if(xkesto + 2000 < pisteet && vauhti == 1){
            auto.setHitaus();
            vauhti = 0;
        }
        
        if(rahaKesto + 50 < pisteet && raha == 1){
            
            raha = 0;
        }
        
        if(hpKesto + 50 < pisteet && hp == 1){
            
            hp = 0;
        }
        
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            auto.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            auto.keyPressed(e);
            
            int key = e.getKeyCode();
            
            if (key == KeyEvent.VK_R) {
                ingame = true;
                pisteet = 0;
                life = 1;
                auto = new Auto();
                timer.start();
                este = new Este();
                nopeusJuttu = 0;
                kiviMode = 0;

                este2 = new Este();

                este3 = new Este();

                este4 = new Este();

                este5 = new Este();

                este6 = new Este();
                
                este7 = new Este();

                este.setX(-100);
                este2.setX(-100);
                este3.setX(-100);
                este4.setX(-100);
                este5.setX(-100);
                este6.setX(-100);
                este7.setX(-100);
            
            }
            
            if (key == KeyEvent.VK_I) {
                info = 1;
                
            }
            
            if (key == KeyEvent.VK_C) {
                credit = 1;
                
            }
            
            if (key == KeyEvent.VK_O && info == 1) {
                info = 0;
                timer.start();
            }
            
            if (key == KeyEvent.VK_V && credit == 1) {
                credit = 0;
                timer.start();
            }
            
            if (key == KeyEvent.VK_M && pisteet < 100) {
                kiviMode = 1;
            }
        }
    }

    private void inGame() {

        if (!ingame) {
            this.life = this.life - 1;
            este4.setX(auto.getX());
            este4.setY(auto.getY());
            repaint();
            timer.stop();

        }
    }

    public void checkCollisions() {
        
        Rectangle pirssi = auto.getBounds();

        Rectangle r1 = este.getBounds();
        Rectangle r2 = este2.getBounds();
        Rectangle r3 = este3.getBounds();
        Rectangle r5 = este5.getBounds();
        Rectangle r6 = este6.getBounds();
        Rectangle r7 = este7.getBounds();
        
        if (r1.intersects(pirssi) && this.life == 1){
            if(este.getMalli()> 0.5 && kiviMode == 1){
                este.setX(-100);
            }else{
                ingame = false;
                este.setX(-100);
            }
        }
        if(r2.intersects(pirssi) && this.life == 1){
            if(este2.getMalli()> 0.5 && kiviMode == 1){
                este2.setX(-100);
            }else{
                ingame = false;
                este2.setX(-100);
            }
        }
        
        if(r3.intersects(pirssi) && this.life == 1){
            if(este3.getMalli()> 0.5 && kiviMode == 1){
                este3.setX(-100);
            }else{
                ingame = false;
                este3.setX(-100);
            }
        }
        if (r1.intersects(pirssi) && this.life > 1){
            if(este.getMalli()> 0.5 && kiviMode == 1){
                este.setX(-100);
            }else{
                this.life = this.life - 1;
                este.setX(-100);
            }
 
        }
        
        if (r2.intersects(pirssi) && this.life > 1){
            if(este2.getMalli()> 0.5 && kiviMode == 1){
                este2.setX(-100);
            }else{
                this.life = this.life - 1;
                este2.setX(-100);
            }
        }
        
        if (r3.intersects(pirssi) && this.life > 1){
            if(este3.getMalli()> 0.5 && kiviMode == 1){
                este3.setX(-100);
            }else{
                this.life = this.life - 1;
                este3.setX(-100);
            }
        }
        
        if(r5.intersects(pirssi)){
            this.pisteet = this.pisteet + 500;
            este5.setX(-100);
            este5.setY(-100);
            rahaKesto = pisteet;
            raha = 1;
        }
        
        if(r6.intersects(pirssi)){
            if(this.life < 3){
                this.life = this.life + 1;
                hpKesto = pisteet;
                hp = 1;
            }else{
                this.pisteet = this.pisteet + 500;
                rahaKesto = pisteet;
                raha = 1;
            }
            este6.setX(-100);
            este6.setY(-100);
            
        }
        
        if(r7.intersects(pirssi)){
            este7.setX(-100);
            este7.setY(-100);
            if(vauhti == 0){
                auto.setNopeus();
                
                xkesto = pisteet;
                vauhti = 1;
            }
        }
        
    }
    
    public int getPisteet(){
        return this.pisteet;
    }
    /*
    public void faster(){
        if(this.pisteet > 300 && este.getNopeus() < 7 && este.getNopeus() < 7 && este.getNopeus() < 7){
            este.upNopeus();
            este2.upNopeus();
            este3.upNopeus();
        }
    }
    */
}
