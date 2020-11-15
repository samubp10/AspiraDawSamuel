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
        //Declaración de variables y arrays
        boolean repetir = true;
        final String USUARIO = "usuario";
        final String CONTRASENA = "usuario";
        String usuarioAuten;
        String contrasenaAuten;
        String valorCarga;
        double carga;
        final double CARGAMINIMA = 3;
        String confPrincipal;
        int elecPrincipal;
        String confAspiracion;
        int elecAspiracion;
        String confEstadoGeneral;
        int elecEstadoGeneral;
        String confDependencia;
        int elecDependencia;
        double cargaGastada;
        double desgasteAspiracion = 1.5;
        double desgasteApiracionFregado = 2.25;
        String[] dependencias = {"Cocina", "Salón", "Cuarto de baño", "Dormitorio 1", "Dormitorio 2"};
        boolean[] limpiadoSiNo = {false, false, false, false, false};
        int m2dependencia = 0;
        int[] m2dependencias = new int[5];
        int i;
        //Sistema dew uatenticación hecho con un bucle
        do {
            usuarioAuten = JOptionPane.showInputDialog("Introduzca el nombre de usuario");
            contrasenaAuten = JOptionPane.showInputDialog("Introduzca la contraseña");
        } while (!USUARIO.equals(usuarioAuten) || !CONTRASENA.equals(contrasenaAuten));
        //Pide la carga de la aspiradora para saber cuanta batería tiene la aspiradora
        do {
            valorCarga = JOptionPane.showInputDialog("Introduzca la carga de la aspiradora");
            carga = Double.parseDouble(valorCarga);
        } while (carga < 0 || carga > 100);
        //Este bucle sirve para introducir datos en el array de los metros cuadrados de las dependencias
        for (i = 0; i < dependencias.length; i++) {
            do {
                String m2 = JOptionPane.showInputDialog("Introduzca el número de metros al cuadrado que tiene la dependencia "
                        + dependencias[i]);
                m2dependencia = Integer.parseInt(m2);
                m2dependencias[i] = (int) m2dependencia;
            } while (m2dependencia < 1 || m2dependencia > 100);
        }
        do {

            //Entramos en el menú del programa, en el cuál selecciona una opción 
            do {
                confPrincipal = JOptionPane.showInputDialog("Elija una opción \n 1 - Aspiración \n 2 - Aspiración y fregado \n "
                        + "3 - Estado general \n 4 - Base de carga \n 5 - Salir");
                elecPrincipal = Integer.parseInt(confPrincipal);
            } while (elecPrincipal < 1 || elecPrincipal > 5);
            //switch que engloba todo el menú
            switch (elecPrincipal) {
                //El caso 1 que entra en las opciones de "ASPIRACIÓN"
                case 1:
                    JOptionPane.showMessageDialog(null, "Ha entrado en el modo de aspiración, a continuación elija que opción quiere que la aspiradora realize");
                    confAspiracion = JOptionPane.showInputDialog("Elija una opción \n 1 - Modo completo \n 2 - Modo dependencias ");
                    elecAspiracion = Integer.parseInt(confAspiracion);
                    //Este switch indica el modo de apiración escogido por el usuario
                    switch (elecAspiracion) {
                        //Con este case entra en el modo completo
                        case 1:
                            JOptionPane.showMessageDialog(null, "Ha elegido la opción de "
                                    + "Modo completo ");
                            for (i = 0; i < dependencias.length; i++) {
                                cargaGastada = m2dependencias[i] * desgasteAspiracion;
                                System.out.println(cargaGastada);
                                carga -= cargaGastada;
                                System.out.println(carga);
                                if (carga < CARGAMINIMA) {
                                    carga += cargaGastada;
                                    continue;
                                }

                                if (carga >= CARGAMINIMA) {
                                    JOptionPane.showMessageDialog(null, "Se está limpiando la dependencia " + dependencias[i] + " , por favor espere... ");
                                    limpiadoSiNo[i] = true;
                                } else {
                                    continue;
                                }
                                continue;

                            }
                            for (i = 0; i < dependencias.length; i++) {
                                if (limpiadoSiNo[i] == true) {
                                    JOptionPane.showMessageDialog(null, "La habitación" + dependencias[i] + " la he podido limpiar");
                                } else {

                                    JOptionPane.showMessageDialog(null, "La habitación " + dependencias[i] + " no la he podido limpiar");

                                }

                            }
                            break;
                        //Con este case entra en la opción por dependencias

                        case 2:
                            JOptionPane.showMessageDialog(null, "Ha elegido la opción de "
                                    + "Modo dependencias ");
                            //pregunta la dependencia que quiere limpiar mientras que la respuesta sea no sea 6

                            do {
                                confDependencia = JOptionPane.showInputDialog("Indique la habitacion que quiere limpiar \n 1 - Cocina \n 2 - Salón \n "
                                        + "3 - Cuarto de baño \n 4 - Dormitorio 1 \n 5 - Dormitorio 2 \n 6 - Salir");
                                elecDependencia = Integer.parseInt(confDependencia);
                                switch (elecDependencia) {
                                    //pregunta la dependencia que quiere limpiar mientras que al calcular cuanto le va a llevar 
                                    //hacer la dependencia no de 3 o menos, la hará, si da 3 o menos, irá a la estación de carga
                                    case 1:
                                        cargaGastada = m2dependencias[0] * desgasteAspiracion;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            JOptionPane.showMessageDialog(null, "Se está limpiando la cocina, por favor espere... ");
                                            JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            JOptionPane.showMessageDialog(null, "Ha terminado de limpiar la cocina ");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                    + "la battería se quede a cero, por favor espere... ");
                                            carga = 100;
                                            JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");

                                        }
                                        continue;
                                    case 2:
                                        cargaGastada = m2dependencias[1] * desgasteAspiracion;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            JOptionPane.showMessageDialog(null, "Se está limpiando el Salón, por favor espere... ");
                                            JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            JOptionPane.showMessageDialog(null, "Ha terminado de limpiar el salón ");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                    + "la battería se quede a cero, por favor espere... ");
                                            carga = 100;
                                            JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");

                                        }
                                        continue;
                                    case 3:
                                        cargaGastada = m2dependencias[2] * desgasteAspiracion;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            JOptionPane.showMessageDialog(null, "Se está limpiando el cuarto de baño, por favor espere... ");
                                            JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            JOptionPane.showMessageDialog(null, "Ha terminado de limpiar del cuarto de baño ");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                    + "la battería se quede a cero, por favor espere... ");
                                            carga = 100;
                                            JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");

                                        }
                                        continue;
                                    case 4:
                                        cargaGastada = m2dependencias[3] * desgasteAspiracion;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            JOptionPane.showMessageDialog(null, "Se está limpiando el dormitorio 1, por favor espere... ");
                                            JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            JOptionPane.showMessageDialog(null, "Ha terminado de limpiar el dormitorio 1 ");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                    + "la battería se quede a cero, por favor espere... ");
                                            carga = 100;
                                            JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");

                                        }
                                        continue;
                                    case 5:
                                        cargaGastada = m2dependencias[4] * desgasteAspiracion;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            JOptionPane.showMessageDialog(null, "Se está limpiando el dormitorio 2, por favor espere... ");
                                            JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            JOptionPane.showMessageDialog(null, "Ha terminado de limpiar la el dormitorio 2 ");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                    + "la battería se quede a cero, por favor espere... ");
                                            carga = 100;
                                            JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");

                                        }
                                        continue;
                                    case 6:
                                        JOptionPane.showInputDialog("Usted ha elegido la opción de salir");
                                        break;

                                }

                            } while (elecDependencia != 6);
                            break;
                    }
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Ha elegido la opción de "
                            + "Aspiración y fregado ");
                    confAspiracion = JOptionPane.showInputDialog("Elija una opción \n 1 - Modo completo \n 2 - Modo dependencias ");
                    elecAspiracion = Integer.parseInt(confAspiracion);
                    //Este switch indica el modo de apiración escogido por el usuario
                    switch (elecAspiracion) {
                        //Con este case entra en el modo completo
                        case 1:
                            JOptionPane.showMessageDialog(null, "Ha elegido la opción de "
                                    + "Modo completo ");
                            for (i = 0; i < dependencias.length; i++) {
                                cargaGastada = m2dependencias[i] * desgasteApiracionFregado;
                                System.out.println(cargaGastada);
                                carga -= cargaGastada;
                                System.out.println(carga);
                                if (carga < CARGAMINIMA) {
                                    carga += cargaGastada;
                                    continue;
                                }

                                if (carga >= CARGAMINIMA) {
                                    JOptionPane.showMessageDialog(null, "Se está limpiando la dependencia " + dependencias[i] + " , por favor espere... ");
                                    limpiadoSiNo[i] = true;
                                } else {
                                    continue;
                                }
                                continue;

                            }
                            for (i = 0; i < dependencias.length; i++) {
                                if (limpiadoSiNo[i] == true) {
                                    JOptionPane.showMessageDialog(null, "La habitación" + dependencias[i] + " la he podido limpiar");
                                } else {

                                    JOptionPane.showMessageDialog(null, "La habitación " + dependencias[i] + " no la he podido limpiar");

                                }

                            }
                            break;
                        //Con este case entra en la opción por dependencias

                        case 2:
                            JOptionPane.showMessageDialog(null, "Ha elegido la opción de "
                                    + "Modo dependencias ");
                            //pregunta la dependencia que quiere limpiar mientras que la respuesta sea no sea 6

                            do {
                                confDependencia = JOptionPane.showInputDialog("Indique la habitacion que quiere limpiar \n 1 - Cocina \n 2 - Salón \n "
                                        + "3 - Cuarto de baño \n 4 - Dormitorio 1 \n 5 - Dormitorio 2 \n 6 - Salir");
                                elecDependencia = Integer.parseInt(confDependencia);
                                switch (elecDependencia) {
                                    //pregunta la dependencia que quiere limpiar mientras que al calcular cuanto le va a llevar 
                                    //hacer la dependencia no de 3 o menos, la hará, si da 3 o menos, irá a la estación de carga
                                    case 1:
                                        cargaGastada = m2dependencias[0] * desgasteApiracionFregado;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            JOptionPane.showMessageDialog(null, "Se está limpiando la cocina, por favor espere... ");
                                            JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            JOptionPane.showMessageDialog(null, "Ha terminado de limpiar la cocina ");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                    + "la battería se quede a cero, por favor espere... ");
                                            carga = 100;
                                            JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");

                                        }
                                        continue;
                                    case 2:
                                        cargaGastada = m2dependencias[1] * desgasteApiracionFregado;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            JOptionPane.showMessageDialog(null, "Se está limpiando el Salón, por favor espere... ");
                                            JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            JOptionPane.showMessageDialog(null, "Ha terminado de limpiar el salón ");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                    + "la battería se quede a cero, por favor espere... ");
                                            carga = 100;
                                            JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");

                                        }
                                        continue;
                                    case 3:
                                        cargaGastada = m2dependencias[2] * desgasteApiracionFregado;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            JOptionPane.showMessageDialog(null, "Se está limpiando el cuarto de baño, por favor espere... ");
                                            JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            JOptionPane.showMessageDialog(null, "Ha terminado de limpiar del cuarto de baño ");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                    + "la battería se quede a cero, por favor espere... ");
                                            carga = 100;
                                            JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");

                                        }
                                        continue;
                                    case 4:
                                        cargaGastada = m2dependencias[3] * desgasteApiracionFregado;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            JOptionPane.showMessageDialog(null, "Se está limpiando el dormitorio 1, por favor espere... ");
                                            JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            JOptionPane.showMessageDialog(null, "Ha terminado de limpiar el dormitorio 1 ");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                    + "la battería se quede a cero, por favor espere... ");
                                            carga = 100;
                                            JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");

                                        }
                                        continue;
                                    case 5:
                                        cargaGastada = m2dependencias[4] * desgasteApiracionFregado;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            JOptionPane.showMessageDialog(null, "Se está limpiando el dormitorio 2, por favor espere... ");
                                            JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            JOptionPane.showMessageDialog(null, "Ha terminado de limpiar la el dormitorio 2 ");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                    + "la battería se quede a cero, por favor espere... ");
                                            carga = 100;
                                            JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");

                                        }
                                        continue;
                                    case 6:
                                        JOptionPane.showInputDialog("Usted ha elegido la opción de salir");
                                        break;

                                }

                            } while (elecDependencia != 6);
                            break;
                    }
                    break;

                case 3:
                    break;
                case 4:
                     JOptionPane.showMessageDialog(null, "Se está acrgando la aspiradora, por favor espere...");
                     carga = 100;
                     JOptionPane.showMessageDialog(null, "La aspiradora se ha cargado con éxito, su niver de carga es ahora del 100%");
                    break;
                case 5:
                    repetir = false;
                    break;

            }
        } while (repetir);
    }

}
