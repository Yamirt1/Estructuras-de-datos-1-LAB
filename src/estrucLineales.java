import javax.swing.JOptionPane;

public class estrucLineales {
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Bievenidos al menu de estructuras lineales", "Bienvenida", JOptionPane.INFORMATION_MESSAGE);

        int respuesta1 = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (respuesta1 == JOptionPane.YES_OPTION);
        boolean salir = false;

        while (!salir) {
            String[] opcionesMenu1 = {"Pila", "Cola", "Salir"};
            String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una de estas opciones para ingresar al menu",
                    "Menú principal de estructuras lineales",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionesMenu1,
                    opcionesMenu1[0]
            );

            if (seleccion == null || seleccion.equals("Salir")) {
                salir = true;
                JOptionPane.showMessageDialog(null, "Programa finalizado!");
            } else {
                switch (seleccion) {
                    case "Pila":
                        boolean continuar1 = true;
                        int[] vector = null; // Vector inicialmente no creado
                        int index = 0; // Posición
                        boolean pilaCreada = false; // verifica si la pila fue creada

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
                                case "Crear":
                                    if (!pilaCreada) {
                                        vector = new int[5]; // Crear el vector
                                        pilaCreada = true;
                                        index = 0; // Reiniciar el índice
                                        JOptionPane.showMessageDialog(null, "Pila creada con éxito!");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "La pila ya ha sido creada.");
                                    }
                                    break;

                                case "Insertar":
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
                                    break;

                                case "Eliminar":
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
                                    break;

                                case "Está vacía":
                                    if (!pilaCreada) {
                                        JOptionPane.showMessageDialog(null, "Debe crear una pila antes de verificar si está vacía.");
                                    } else {
                                        if (index == 0) {
                                            JOptionPane.showMessageDialog(null, "La pila está vacía.");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "La pila no está vacía.");
                                        }
                                    }
                                    break;
                            }
                        }
                        break;
                }
            }
        }
    }
}