/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elementos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Julian
 */
public class GameWorld extends Sprite implements Dimensionable, Drawable{

    private Player player;
    private BufferedImage image;
    private ArrayList<Monstruo> monstruos;

    public GameWorld(int width, int height) throws IOException {
        super(0, 0, width, height);
        image = ImageIO.read(new File("src\\co\\edu\\autonoma\\imagenes\\map.png"));
        player = new Player(width/2, height/2);
        player.setArea(this);
        player.setDrawable(this);
        monstruos = new ArrayList<>();
        spawn();
    }

    public void spawn() {
        for (int i = 0; i < 50; i++) {
            int x = (int) (Math.random() * width);
            int y = (int) (Math.random() * height);
            monstruos.add( new Monstruo(x, y, 40, 40, player, 1, 100));
            monstruos.get(i).setArea(this);
            monstruos.get(i).setDrawable(this);
        }
    }

    public ArrayList<Monstruo> getMonstruos() {
        return monstruos;
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
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(image, null, 0, 0);

        player.draw(g2d);
        drawMonstruos(g);
        Toolkit.getDefaultToolkit().sync();

    }

    public void drawMonstruos(Graphics g) {
        for (Monstruo monstruo : monstruos) {
            monstruo.draw(g);
        }
        Toolkit.getDefaultToolkit().sync();
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
