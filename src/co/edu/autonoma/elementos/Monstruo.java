package co.edu.autonoma.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Monstruo extends Sprite {
    private Player player;
    private int velocidad;
    private int distancia;
    int pastx;
    int pasty;

    public Monstruo(int x, int y, int width, int height, Player player, int velocidad, int distancia) {
        super(x, y, width, height);
        this.player = player;
        this.velocidad = velocidad;
        this.distancia = distancia;
        pastx = x;
        pasty = y;
    }

    @Override
    public void draw(Graphics g) {
        // Dibujar el monstruo como un rectángulo negro
        g.setColor(Color.BLACK);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void move(ArrayList<Monstruo> monstruos) {
        pastx = x;
        pasty = y;
        int dx = player.getX() - getX();
        int dy = player.getY() - getY();

        double distanciaAlJugador = Math.sqrt(dx * dx + dy * dy);
        double ratio = distancia / distanciaAlJugador;
        int offsetX = (int) ((dx * ratio) * 0.02);
        int offsetY = (int) ((dy * ratio) * 0.02);

        int newx = getX() + offsetX;
        int newy =getY() + offsetY;

        for (Monstruo otroMonstruo : monstruos) {
            if (otroMonstruo != this) {
                int distanciaX = Math.abs(newx - otroMonstruo.getX());
                int distanciaY = Math.abs(newy - otroMonstruo.getY());

                int distanciaMinima = 40;
                if (distanciaX <= distanciaMinima && distanciaY <= distanciaMinima) {
                    return;
                }
            }
        }
        setX(newx);
        setY(newy);

        drawable.redraw(pastx, pasty, width, height);
        drawable.redraw(x, y, width, height);
    }

}
