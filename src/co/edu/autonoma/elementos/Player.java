/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author Julian
 */
public class Player extends Sprite {
    
    private int step;
    int pastx;
    int pasty;

    public Player(int x, int y) {
        super(x, y, 40,40);
        step = 10;
        pastx = x;
        pasty = y;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
    
    public void handleKey(int key)
    {
        if(key == KeyEvent.VK_LEFT |
           key == KeyEvent.VK_RIGHT |
           key == KeyEvent.VK_UP |
           key == KeyEvent.VK_DOWN)
        {
            if(move(key))
                if(drawable != null){
                    drawable.redraw(pastx, pasty, width, height);
                    drawable.redraw(x, y, width, height);
                }
        }
    }
    
    
    public boolean move(int direction)
    {        
       int ox = x;
       int oy = y;
        if(direction == KeyEvent.VK_LEFT){
            pastx = x;
            x -= step;
        }
        if(direction == KeyEvent.VK_RIGHT){
            pastx = x;
            x += step;
        }  
        if(direction == KeyEvent.VK_UP){
            pasty = y;
            y -= step;
        }    
        if(direction == KeyEvent.VK_DOWN){
            pasty = y;
            y += step;
        }     
        if (x < this.area.getX()){
            x = this.area.getX();
        }
        if (y < this.area.getY()){
            y = this.area.getY();
        }
        if (x + this.width > this.area.getWidth()){
            x = this.area.getWidth() - this.width;
        }
        if (y + this.height > this.area.getHeight()){
            y = this.area.getHeight() - this.height;
        }
        if( x == ox & y == oy){
            return false;
        }
        return true;
    }
}
