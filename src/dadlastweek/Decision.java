/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadlastweek;

import java.awt.Image;

/**
 *
 * @author Aula1
 */
public class Decision {
    protected String decision, event, day, healthstate;
    protected String object;
    protected Decision left, right;
    protected int earnorlost, health;
    protected Image button1, button2, button3;
     
    public Decision(String e, String d, String dia, String objeto, int salud, String estadosalud, Image boton1, Image boton2, Image boton3){
        event = e;
        decision = d;
        day = dia;
        object = objeto;
        health = salud;
        healthstate = estadosalud;
        button1 = boton1;
        button2 = boton2;
        button3 = boton3;
        left = null;
        right = null;
    }
}
