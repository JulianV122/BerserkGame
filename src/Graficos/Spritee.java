/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficos;

/**
 *
 * @author Julian
 */
public class Spritee {
    private final int lado;
    
    private int x;
    private int y;
    
    public int[] pixeles;
    private final HojaSprites hoja;
    
    //coleccion de sprites
    public static Spritee cascadaa=new Spritee(925, 0, 0, HojaSprites.cascada);
    //Fin de la coleccion

    public Spritee(final int lado,final int columna, final int fila, final HojaSprites hoja) {
        this.lado = lado;
        
        pixeles = new int[lado * lado];
        
        this.x = columna * lado;
        this.y = fila * lado;
        this.hoja = hoja;
        
        for(int y=0; y < lado; y++){
            for (int x=0; x < lado; x++){
                pixeles[x + y * lado] = hoja.pixeles[(x+this.x)+(y+this.y)*hoja.getAncho()];
            }
        }
    }
    
    
}
