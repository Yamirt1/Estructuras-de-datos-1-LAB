package PilaP;

import javax.swing.JOptionPane;

public class SistemaPila{
    
    public static void manejarPila() {
        boolean continuar1 = true;
        int[] vector = null; // Vector inicialmente no creado
        int index = 0; // Posición
        boolean pilaCreada = false; // Verifica si la pila fue creada

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

            if (seleccion2 == null || seleccion2.equals("Volver")) {
                continuar1 = false;
                continue;
            }

            switch (seleccion2) {
                case "Crear" -> {
                    if (!pilaCreada) {
                        vector = crearPila();
                        pilaCreada = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "La pila ya ha sido creada.");
                    }
                }
                case "Insertar" ->
                    index = insertarEnPila(vector, index, pilaCreada);
                case "Eliminar" ->
                    index = eliminarDePila(index, pilaCreada);
                case "Está vacía" ->
                    verificarPilaVacia(index, pilaCreada);
                case "Mostrar" ->
                    mostrarResultado(pilaCreada, index, vector);
            }
        }
    }

    private static int[] crearPila() {
        JOptionPane.showMessageDialog(null, "Pila creada con éxito!");
        return new int[5];
    }

    private static int insertarEnPila(int[] vector, int index, boolean pilaCreada) {
        if (!pilaCreada) {
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

    private static int eliminarDePila(int index, boolean pilaCreada) {
        if (!pilaCreada) {
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

    private static void verificarPilaVacia(int index, boolean pilaCreada) {
        if (!pilaCreada) {
            JOptionPane.showMessageDialog(null, "Debe crear una pila antes de verificar si está vacía.");
        } else {
            if (index == 0) {
                JOptionPane.showMessageDialog(null, "La pila está vacía.");
            } else {
                JOptionPane.showMessageDialog(null, "La pila no está vacía.");
            }
        }
    }

    private static void mostrarResultado(boolean pilaCreada, int index, int[] vector) {
        if (!pilaCreada) {
            JOptionPane.showMessageDialog(null, "Debe crear una pila antes de eliminar elementos.");
        } else {
            StringBuilder resultado = new StringBuilder("Elementos en la pila son:\n");
            for (int i = index - 1; i >= 0; i--) {
                resultado.append(vector[i]).append("\n");
            }
            JOptionPane.showMessageDialog(null, resultado.toString(), "Contenido dentro de la pila", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}