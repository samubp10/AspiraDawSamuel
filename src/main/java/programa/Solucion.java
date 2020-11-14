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
        do {
            usuarioAuten = JOptionPane.showInputDialog("Introduzca el nombre de usuario");
            contrasenaAuten = JOptionPane.showInputDialog("Introduzca la contraseña");
        } while (!USUARIO.equals(usuarioAuten) || !CONTRASENA.equals(contrasenaAuten));
        do {
            valorCarga = JOptionPane.showInputDialog("Introduzca la carga de la aspiradora");
            carga = Double.parseDouble(valorCarga);
        } while (carga < 0 || carga > 100);

    }
}
