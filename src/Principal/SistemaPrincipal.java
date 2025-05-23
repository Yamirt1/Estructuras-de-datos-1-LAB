package Principal;

import Cola.SistemaCola;
import PilaP.SistemaPila;
import javax.swing.JOptionPane;

public class SistemaPrincipal {

    public void iniciarSistema() {
        JOptionPane.showMessageDialog(null, "Bienvenidos al menú de estructuras lineales", "Bienvenida", JOptionPane.INFORMATION_MESSAGE);

        int respuesta1 = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (respuesta1 == JOptionPane.YES_OPTION) {
            mostrarMenuPrincipal();
        }

        JOptionPane.showMessageDialog(null, "Programa finalizado!");
    }

    private static void mostrarMenuPrincipal() {
        boolean salir = false;

        while (!salir) {
            String[] opcionesMenu1 = {"Pila", "Cola", "Cola - Circular", "Salir"};
            String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una de estas opciones para ingresar al menú",
                    "Menú principal de estructuras lineales",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionesMenu1,
                    opcionesMenu1[0]
            );

            if (seleccion == null || seleccion.equals("Salir")) {
                salir = true;
            } else {
                switch (seleccion) {
                    case "Pila" ->
                        SistemaPila.manejarPila();
                    case "Cola" ->
                        SistemaCola.manejarCola();
                    case "Cola - Circular" ->
                        JOptionPane.showMessageDialog(null, "Funcionalidad de cola circular no implementada.");
                }
            }
        }
    }
}