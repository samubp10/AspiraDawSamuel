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
        String confPrincipal;
        int elecPrincipal;
        String confAspiracion;
        int elecAspiracion;
        String confEstadoGeneral;
        int elecEstadoGeneral;
        String confDependencia;
        int elecDependencia;
        double cargaGastada;
        double desgasteAspiracion = 0.015;
        double desgasteApiracionFregado = 0.0225;
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
        confPrincipal = JOptionPane.showInputDialog("Elija una opción \n 1 - Aspiración \n 2 - Aspiración y fregado \n "
                + "3 - EStado general \n 4 - Estado General \n 5 - Base de carga \n 6 - Salir");
        elecPrincipal = Integer.parseInt(confPrincipal);
        switch (elecPrincipal) {
            case 1:
                confAspiracion = JOptionPane.showInputDialog("Elija una opción \n 1 - Modo completo \n 2 - Modo dependencias ");
                elecAspiracion = Integer.parseInt(confAspiracion);
                switch (elecAspiracion) {
                    case 1:
                        JOptionPane.showInputDialog("Ha elegido la opción de "
                                + "Modo completo ");
                        break;
                    case 2:
                        JOptionPane.showInputDialog("Ha elegido la opción de "
                                + "Modo dependencias ");
                        do {
                            confDependencia = JOptionPane.showInputDialog("Indique la habitacion que quiere limpiar \n 1 - Cocina \n 2 - Salón \n "
                                    + "3 - Cuarto de baño \n 4 - Dormitorio 1 \n 5 - Dormitorio 2 \n 6 - Salir");
                            elecDependencia = Integer.parseInt(confDependencia);
                            switch (elecDependencia) {
                                case 1:
                                    if (carga >= 3) {
                                        cargaGastada = m2dependencias[0] * desgasteAspiracion;
                                        carga -= cargaGastada;
                                    }
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    JOptionPane.showInputDialog("Usted ha elegido la opción de salir");
                                    break;

                            }
                        } while (elecDependencia != 6);
                        break;
                }
                break;
            case 2:
                JOptionPane.showInputDialog("Ha elegido la opción de "
                        + "Aspiración y fregado ");

                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;

        }
    }

}
