/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Julian
 */
public class GameWorld extends Sprite implements Dimensionable, Drawable{
    
    private Player player;
    private BufferedImage image; 

    public GameWorld(int width, int height) {
        super(0, 0, width, height);
        player = new Player(width/2, height/2);
        player.setArea(this);
        player.setDrawable(this);
    }

    public void handleKey(int key)
    {
        if(key == KeyEvent.VK_LEFT |
           key == KeyEvent.VK_RIGHT |
           key == KeyEvent.VK_UP |
           key == KeyEvent.VK_DOWN)
        {
            player.handleKey(key);
            
        }
        
    }
    @Override
    public void draw(Graphics g) {
        
        try {
            image = ImageIO.read(new File("src\\co\\edu\\autonoma\\imagenes\\Background.png"));
            g.setColor(Color.DARK_GRAY);
            g.fillRect(x, y, width, height);
            Graphics2D g2d = (Graphics2D) g;
            g2d.translate(x, y);
            g2d.drawImage(image, null, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.draw(g);
        
        
    }

    @Override
    public void redraw() {
        if(drawable != null)
            drawable.redraw();
    }

    @Override
    public void redraw(int x, int y, int width, int height) {
        if(drawable != null)
            drawable.redraw(x, y, width, height);    
    }
}
