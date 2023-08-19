package com.quiral.agendainteractiva;
import com.quiral.ventanas.Logueo;

/**
 * @author CiggyRat
 */
public class AgendaInteractiva {
    public static void main(String[] args) {
        System.out.println("Proyecto de Ejemplo");
        System.out.println("La idea es desarrollar una pequeña aplicacion desde 0, y poder"
                + "practicar mis buenas practicas e implementar cosas que he aprendido en el"
                + "ultimo año, además de avanzar con cuestiones de Taller de Programación III");
        System.out.println("La idea sería usar unicamente archivos, al menos en principio, "
                + "e implementar cuestiones como el 'unificador' de metodos (practicar la modulacion"
                + "y encapsulamiento de la mejor forma posible");
        System.out.println("El main unicamente va a ser un bootstrap de las demás pantallas. "
                + "Queda como clase vacía");
    
        Logueo logueo = new Logueo();
        logueo.setVisible(true);
    }
}
