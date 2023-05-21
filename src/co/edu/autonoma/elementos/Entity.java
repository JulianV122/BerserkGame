/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elementos;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Julian
 */
public abstract class Entity {
    public int velocity;
    public Point2D point;
    public int alto;
    public int ancho;
    public BufferedImage imagen;

    public Entity(int velocity, Point2D point, int alto, int ancho, BufferedImage imagen) {
        this.velocity = velocity;
        this.point = point;
        this.alto = alto;
        this.ancho = ancho;
        this.imagen = imagen;
    }
    
    public Rectangle getBounds() {
        return new Rectangle((int) point.getX(), (int) point.getY(), ancho, alto);
    }

    public Point2D getPoint() {
        return point;
    }
    
    
    public void draw(Graphics2D g2d){}
    
    public boolean collision (Entity another) {
        Rectangle r1 = this.getBounds();
        Rectangle r2 = another.getBounds();
        return r1.intersects(r2);
    }
    
}
