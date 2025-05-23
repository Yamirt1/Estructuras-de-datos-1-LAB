package Cola;

import javax.swing.JOptionPane;

public class SistemaCola {

    public static void manejarCola() {
        boolean continuar1 = true;
        int[] vector = null; // Vector inicialmente no creado
        int index = 0; // Posición
        boolean colaCreada = false;

        while (continuar1) {
            String[] opcionesMenu2 = {"Insertar", "Eliminar", "Está vacía", "Crear", "Volver", "Mostrar"};
            String seleccion2 = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una de estas opciones para este menú",
                    "Menú de pilas",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionesMenu2,
                    opcionesMenu2[0]
            );

            if(seleccion2 == null || seleccion2.equals("Volver")) {
                continuar1 = false;
                continue;
            }
            switch (seleccion2){
               case "Crear" -> {
                   if (!colaCreada) {
                       vector = crearCola();
                       colaCreada = true;
                   } else {
                       JOptionPane.showMessageDialog(null, "La cola ya ha sido creada.");
                   }
               }
               case "Insertar" ->
                   index = insertarEnCola(vector, index, colaCreada);
               case "Eliminar" ->
                   index = eliminarCola(colaCreada, index);
            }
        }
    }

    private static int[] crearCola() {
        JOptionPane.showMessageDialog(null, "Cola creada con éxito!");
        return new int[5];
    }

    private static int insertarEnCola(int[] vector, int index, boolean colaCreada) {
        if (!colaCreada) {
            JOptionPane.showMessageDialog(null, "Debe crear una pila antes de insertar elementos.");
        } else {
            while (index < 5) {
                String input = JOptionPane.showInputDialog(null, "Ingrese un número (" + (index + 1) + "/5):", "Insertar", JOptionPane.QUESTION_MESSAGE);
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Inserción cancelada.");
                    break;
                }
                try {
                    int numero = Integer.parseInt(input);
                    vector[index] = numero;
                    index++;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                }
            }
            if (index == 5) {
                JOptionPane.showMessageDialog(null, "El vector ya está lleno. No se pueden insertar más valores.");
            }
        }
        return index;
    }

    private static int eliminarCola(boolean colaCreada, int index) {    
      if (!colaCreada) {
            JOptionPane.showMessageDialog(null, "Debe crear una pila antes de eliminar elementos.");
        } else {
            if (index > 0) {
                index--;
                JOptionPane.showMessageDialog(null, "Elemento eliminado correctamente!");
            } else {
                JOptionPane.showMessageDialog(null, "La pila está vacía. No hay elementos para eliminar.");
            }
        }
        return index;
    }
}