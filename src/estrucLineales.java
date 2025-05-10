import javax.swing.JOptionPane;

public class estrucLineales {

    public static void main(String[] args) {
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
            String[] opcionesMenu1 = {"Pila", "Cola", "Salir"};
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
                    case "Pila" -> manejarPila();
                    case "Cola" -> JOptionPane.showMessageDialog(null, "Funcionalidad de Cola no implementada aún.");
                }
            }
        }
    }

    private static void manejarPila() {
        boolean continuar1 = true;
        int[] vector = null; // Vector inicialmente no creado
        int index = 0; // Posición
        boolean pilaCreada = false; // Verifica si la pila fue creada

        while (continuar1) {
            String[] opcionesMenu2 = {"Insertar", "Eliminar", "Está vacía", "Crear", "Volver"};
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
                case "Crear" -> pilaCreada = crearPila(vector, pilaCreada);
                case "Insertar" -> index = insertarEnPila(vector, index, pilaCreada);
                case "Eliminar" -> index = eliminarDePila(index, pilaCreada);
                case "Está vacía" -> verificarPilaVacia(index, pilaCreada);
            }
        }
    }

    private static boolean crearPila(int[] vector, boolean pilaCreada) {
        if (!pilaCreada) {
            vector = new int[5]; // Crear el vector
            JOptionPane.showMessageDialog(null, "Pila creada con éxito!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "La pila ya ha sido creada.");
            return pilaCreada;
        }
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
}