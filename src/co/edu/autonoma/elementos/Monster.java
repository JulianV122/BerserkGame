/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elementos;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Julian
 */
public class Monster extends Entity{
    boolean checkcollicion = false;

    public Monster(int velocity, Point2D point, int alto, int ancho, BufferedImage imagen) {
        super(velocity, point, alto, ancho, imagen);
    }
    
    public boolean isCheckcollicion() {
        return checkcollicion;
    }
    
    public void move(Point2D direction) {
        for (int i = 0; i < 5; i++) {
            double distance = point.distance(direction)/velocity;
            if (distance > 0) {
                double dx = (direction.getX() - point.getX()) / distance;
                double dy = (direction.getY() - point.getY()) / distance;
                point.setLocation(
                    point.getX() + dx,
                    point.getY() + dy
                );
            }
        }
    }
    
    public void moveCollision( Monster actual) {
        actual.getPoint().setLocation(
                actual.getPoint().getX() + 5,
                actual.getPoint().getY() + 5
        );
        point.setLocation(
                    point.getX() - 5,
                    point.getY() - 5
                );
    }

}
