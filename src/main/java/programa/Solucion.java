/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Samuel
 */
public class Solucion {

    public static void main(String[] args) {
        //Declaración de variables y arrays
        boolean repetir = true;
        int contador = 0;
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
        final double DESGASTEASPIRACION = 1.5;
        final double DESGASTEASPIRACIONFREGADO = 2.25;
        String[] dependencias = {"Cocina", "Salón", "Cuarto de baño", "Dormitorio 1", "Dormitorio 2"};
        boolean[] limpiadoSiNo = {false, false, false, false, false};
        int m2dependencia = 0;
        int[] m2dependencias = new int[5];
        int i;
        //Sistema dew autenticación hecho con un bucle
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
        //Este do es un bucle que se ejecuta mientras la respuesta no sea 6 que es salir de la aplicación
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
                            //este contador está a cero porque así cuando se sume 1 empezará en 0 y podrá ser un dígito del array.
                            contador = -1;
                            JOptionPane.showMessageDialog(null, "Ha elegido la opción de "
                                    + "Modo completo ");
                            //Este bucle lo que hace es pasar por todas las dependencias e ir calculando si puede 
                            //entrar a limpiar o no, en caso de que no pueda, revierte la operación hecha para saber
                            //si la siguiente habitación la puede hacer o no. 
                            for (i = 0; i < dependencias.length; i++) {
                                //La operación básicamente lo que hace es multiplicar los metros cuadrados de la dependencia en cuestión
                                //por lo que gasta por metro cuadrado y esto se lo resta a carga.
                                cargaGastada = m2dependencias[i] * DESGASTEASPIRACION;
                                carga -= cargaGastada;
                                //Este if, dice que si la carga es menor a la carga mínima establecida, suma la carga gastada (la pirmera operación )
                                //a la carga, deshaciendo lo anteriormente hecho y haciendo el continue, volvemos a que se vuelva a repetir el bucle pero con la 
                                //siguiete dependencia.
                                if (carga < CARGAMINIMA) {
                                    carga += cargaGastada;
                                    continue;
                                }
                                //En este if, dice que si la carga es mayor o igual a la carga mínima después de haber hecho la operación que se plantea anteriormente,
                                //muestra un mensaje de confirmación y vuelve a true el valor que esté en la posición de la dependencia que se está limpiando
                                //(i) y se suma 1 al contador para después saber donde está la aspiradora.
                                if (carga >= CARGAMINIMA) {
                                    JOptionPane.showMessageDialog(null, "Se está limpiando la dependencia " + dependencias[i] + " , por favor espere... ");
                                    limpiadoSiNo[i] = true;
                                    contador++;
                                    //si no se cumple el if, que se repita el bucle con el siguiente valor
                                }

                            }

                            for (i = 0; i < dependencias.length; i++) {
                                //Si en la posición que estemos en el array de "limpiandoSiNo[]" es igual a true, enseña el mensaje
                                if (limpiadoSiNo[i] == true) {
                                    JOptionPane.showMessageDialog(null, "La habitación " + dependencias[i] + " la he podido limpiar");
                                    //Si no, muestra este otro mensaje
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
                                //Este do se hace mientra que el usuario no conteste un número entre 1 y 6.
                                do {
                                    confDependencia = JOptionPane.showInputDialog("Indique la habitacion que quiere limpiar \n 1 - Cocina \n 2 - Salón \n "
                                            + "3 - Cuarto de baño \n 4 - Dormitorio 1 \n 5 - Dormitorio 2 \n 6 - Salir");
                                    elecDependencia = Integer.parseInt(confDependencia);
                                } while (elecDependencia < 1 || elecDependencia > 6);
                                //En este switch se eligen las dependencias que se van a limpiar 1 a 1.
                                switch (elecDependencia) {
                                    //pregunta la dependencia que quiere limpiar mientras que al calcular cuanto le va a llevar 
                                    //hacer la dependencia no de 3 o menos, la hará, si da 3 o menos, irá a la estación de carga
                                    case 1:
                                        cargaGastada = m2dependencias[0] * DESGASTEASPIRACION;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            contador = 0;
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
                                        //Hace lo mismo que el código anterior solo que con una dependencia diferente.
                                        cargaGastada = m2dependencias[1] * DESGASTEASPIRACION;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            contador = 1;
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
                                        //Hace lo mismo que el código anterior solo que con una dependencia diferente.
                                        cargaGastada = m2dependencias[2] * DESGASTEASPIRACION;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            contador = 2;
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
                                        //Hace lo mismo que el código anterior solo que con una dependencia diferente.
                                        cargaGastada = m2dependencias[3] * DESGASTEASPIRACION;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            contador = 3;
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
                                        //Hace lo mismo que el código anterior solo que con una dependencia diferente.
                                        cargaGastada = m2dependencias[4] * DESGASTEASPIRACION;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            contador = 4;
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
                                        //Con esta opción sale de la aspiración en modo dependencias
                                        JOptionPane.showMessageDialog(null, "Usted ha elegido la opción de salir");
                                        break;

                                }

                            } while (elecDependencia != 6);
                            break;
                    }
                    break;
                //Aquí entras en la opción de aspiración y fregado
                case 2:
                    //todo este código es igual al que está abajo arriba solo cambiando el desgaste por metro cuadrado
                    JOptionPane.showMessageDialog(null, "Ha elegido la opción de "
                            + "Aspiración y fregado ");
                    confAspiracion = JOptionPane.showInputDialog("Elija una opción \n 1 - Modo completo \n 2 - Modo dependencias ");
                    elecAspiracion = Integer.parseInt(confAspiracion);
                    //Este switch indica el modo de apiración escogido por el usuario
                    switch (elecAspiracion) {
                        //Con este case entra en el modo completo
                        case 1:
                            //este contador está a cero porque así cuando se sume 1 empezará en 0 y podrá ser un dígito del array.
                            contador = -1;
                            JOptionPane.showMessageDialog(null, "Ha elegido la opción de "
                                    + "Modo completo ");
                            //Este bucle lo que hace es pasar por todas las dependencias e ir calculando si puede 
                            //entrar a limpiar o no, en caso de que no pueda, revierte la operación hecha para saber
                            //si la siguiente habitación la puede hacer o no. 
                            for (i = 0; i < dependencias.length; i++) {
                                //La operación básicamente lo que hace es multiplicar los metros cuadrados de la dependencia en cuestión
                                //por lo que gasta por metro cuadrado y esto se lo resta a carga.
                                cargaGastada = m2dependencias[i] * DESGASTEASPIRACIONFREGADO;
                                carga -= cargaGastada;
                                //Este if, sice que si la carga es menor a la carga mínima establecida, suma la carga gastada (la pirmera operación )
                                //a la carga, deshaciendo lo anteriormente hecho y haciendo el continue, volvemos a que se vuelva a repetir el bucle pero con la 
                                //siguiete dependencia.
                                if (carga < CARGAMINIMA) {
                                    carga += cargaGastada;
                                    continue;
                                }
                                //En este if, dice que si la carga es mayor o igual a la carga mínima después de haber hecho la operación que se plantea anteriormente,
                                //muestra un mensaje de confirmación y vuelve a true el valor que esté en la posición de la dependencia que se está limpiando
                                //(i) y se suma 1 al contador para después saber donde está la aspiradora.
                                if (carga >= CARGAMINIMA) {
                                    JOptionPane.showMessageDialog(null, "Se está limpiando la dependencia  " + dependencias[i] + " , por favor espere... ");
                                    limpiadoSiNo[i] = true;
                                    contador++;
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
                                        cargaGastada = m2dependencias[0] * DESGASTEASPIRACIONFREGADO;
                                        carga -= cargaGastada;
                                        contador = 0;
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
                                        cargaGastada = m2dependencias[1] * DESGASTEASPIRACIONFREGADO;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            contador = 1;
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
                                        cargaGastada = m2dependencias[2] * DESGASTEASPIRACIONFREGADO;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            contador = 2;
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
                                        cargaGastada = m2dependencias[3] * DESGASTEASPIRACIONFREGADO;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            contador = 3;
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
                                        cargaGastada = m2dependencias[4] * DESGASTEASPIRACIONFREGADO;
                                        carga -= cargaGastada;
                                        if (carga >= CARGAMINIMA) {
                                            contador = 4;
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
                                        JOptionPane.showMessageDialog(null, "Ha decidido salir de la aplicación");
                                        break;

                                }

                            } while (elecDependencia != 6);
                            break;
                    }
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Ha entrado usted en la opción de Estado General ");
                    confEstadoGeneral = JOptionPane.showInputDialog("Elija una opción: \n1-Fecha y hora actuales\n2-Nivel de batería del robot\n"
                            + "3-Lugar donde se encuentra el robot\n4-Dependencias y metros de la casa");
                    elecEstadoGeneral = Integer.parseInt(confEstadoGeneral);
                    switch (elecEstadoGeneral) {
                        case 1:
                            Date date = new Date();
                            //Obtenerhora y fecha y salida por pantalla con formato:
                            DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
                            JOptionPane.showMessageDialog(null, "Hora y fecha actuales: " + hourdateFormat.format(date));
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "El nivel de batería del robot es: " + carga + " %");
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "El robot se encuentra en la dependencia: " + dependencias[contador]);
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Se está cargando la aspiradora, por favor espere...");
                    carga = 100;
                    JOptionPane.showMessageDialog(null, "La aspiradora se ha cargado con éxito, su nivel de carga es ahora del " + carga + "%");
                    break;
                case 5:
                    repetir = false;
                    break;

            }
        } while (repetir);
    }

}
