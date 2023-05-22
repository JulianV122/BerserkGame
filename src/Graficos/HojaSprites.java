/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Julian
 */
public class HojaSprites {
    private final int ancho;
    private final int alto;
    public final int[] pixeles;
    
    //coleccion de hojas de sprites
    public static HojaSprites cascada = new HojaSprites("src\\co\\edu\\autonoma\\imagenes\\waterfall.jpg", 925, 640);
    //fin de la coleccion

    public HojaSprites(final String ruta,final int ancho,final int alto) {
        this.ancho = ancho;
        this.alto = alto;
        pixeles = new int[ancho*alto];
        
        BufferedImage imagen;
        try {
            imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
 
    public int getAncho() {
        return ancho;
    }
    
    
    
}
