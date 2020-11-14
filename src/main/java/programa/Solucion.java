/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import javax.swing.JOptionPane;

/**
 *
 * @author Samuel
 */
public class Solucion {

    public static void main(String[] args) {
        final String USUARIO = "usuario";
        final String CONTRASENA = "usuario";
        String usuarioAuten;
        String contrasenaAuten;
        String valorCarga;
        double carga;
        String[] dependencias = {"Cocina", "Salón", "Cuarto de baño", "Dormitorio 1", "Dormitorio 2"};
        int m2dependencia = 0;
        int[] m2dependencias = new int[5];
        int i;
        do {
            usuarioAuten = JOptionPane.showInputDialog("Introduzca el nombre de usuario");
            contrasenaAuten = JOptionPane.showInputDialog("Introduzca la contraseña");
        } while (!USUARIO.equals(usuarioAuten) || !CONTRASENA.equals(contrasenaAuten));
        do {
            valorCarga = JOptionPane.showInputDialog("Introduzca la carga de la aspiradora");
            carga = Double.parseDouble(valorCarga);
        } while (carga < 0 || carga > 100);
        for (i = 0; i < dependencias.length; i++) {
            do {
                String m2 = JOptionPane.showInputDialog("Introduzca el número de metros al cuadrado que tiene la dependencia "
                        + dependencias[i]);
                m2dependencia = Integer.parseInt(m2);
                m2dependencias[i] = (int) m2dependencia;
                System.out.println(dependencias[i] + " " + m2dependencias[i]);
            } while (m2dependencia < 1 || m2dependencia > 100);
        }
    }
}
