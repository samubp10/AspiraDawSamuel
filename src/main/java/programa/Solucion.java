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
        //Booleano para saber si se tiene que repetir el programa o no (si repetir está a true se repite y si está a false no)
        boolean repetir = true;
        //Esta variable int sirve para saber la posición del robot en cada momento
        int posicion = 0;
        //El campo de nombre de usuario para logearse
        final String USUARIO = "usuario";
        //Campo de contraseña para logearse
        final String CONTRASENA = "usuario";
        //Variable que contiene lo que introduce el usuario en el campo de nombre de usuario
        String usuarioAuten;
        //Variable que contiene la contraseña que mete el usuario al intentar logearse
        String contrasenaAuten;
        //String que contiene el valor de la batería para después pasarla a double
        String valorCarga;
        //Variable que contiene el valor de la batería del robot
        double carga;
        //Una constante que contiene el valor máximo que puede tener la batería 
        final double CARGAMAXIMA = 100;
        //Una constante que contiene el valor mínimo que puede tener la batería 
        final double CARGAMINIMA = 3;
        //String que contiene el número que mete el usuario por teclado el cuál
        //servirá para elegir entre las opciones de la configuración principal.
        String confPrincipal;
        //Esta variable sirve para indicar con un número entero la opción elegida por el usuario en 
        //la configuración principal
        int elecPrincipal = 0;
        //String que contiene el número que mete el usuario por teclado el cuál
        //servirá para elegir entre las opciones de la configuración de la aspiración.
        String confAspiracion;
        //Esta variable sirve para indicar con un número entero la opción elegida por el usuario en 
        //la aspiración
        int elecAspiracion = 0;
        //String que contiene el número que mete el usuario por teclado el cuál
        //servirá para elegir entre las opciones de la configuración del estado general.
        String confEstadoGeneral;
        //Esta variable sirve para indicar con un número entero la opción elegida por el usuario en 
        //la configuración del estado general.
        int elecEstadoGeneral = 0;
        //String que contiene el número que mete el usuario por teclado el cuál
        //servirá para elegir entre las opciones de la configuración del modo dependencia.
        String confDependencia;
        //Esta variable sirve para indicar con un número entero la opción elegida por el usuario en 
        //la configuración principal
        int elecDependencia = 0;
        //Contiene la cantidad de carga que gasta al limpiar una habitación
        double cargaGastada;
        //Constante que contiene lo que gasta por metro cuadrado en el modo de aspiración
        final double DESGASTEASPIRACION = 1.5;
        //Constante que contiene lo que gasta por metro cuadrado en el modo de aspiración y fregado
        final double DESGASTEASPIRACIONFREGADO = 2.25;
        //Array de string que contiene las dependencias de la casa.
        String[] dependencias = {"Cocina", "Salón", "Cuarto de baño", "Dormitorio 1", "Dormitorio 2"};
        //Array de booleanos que contiene false si no ha limpiado la habitación, y true si si la ha limpiado (sirve para el modo completo)
        boolean[] limpiadoSiNo = {false, false, false, false, false};
        //Esta variable contiene los metros de cada dependencia.
        int m2dependencia = 0;
        //Array que sirve para almacenar los metros cuadrados que se van introduciendo para cada dependencia.
        int[] m2dependencias = new int[5];
        //Variable que utilizo en todos los for.
        int i;
        //Sistema dew autenticación hecho con un bucle, se repite mientras lo que ha introducido no sea igual al nombre de usuario o a la contraseña.
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
                confPrincipal = JOptionPane.showInputDialog("Estado de la batería: " + carga + "\nElija una opción: \n 1 - Aspiración \n 2 - Aspiración y fregado \n "
                        + "3 - Estado general \n 4 - Base de carga \n 5 - Salir");
                elecPrincipal = Integer.parseInt(confPrincipal);
            } while (elecPrincipal < 1 || elecPrincipal > 5);
            //switch que engloba todo el menú en el que podrá elegir entre las opciones que están arriba
            switch (elecPrincipal) {
                //El caso 1 que entra en las opciones de "ASPIRACIÓN"
                case 1:
                    JOptionPane.showMessageDialog(null, "Ha entrado en el modo de aspiración, a continuación elija que opción quiere que la aspiradora realize");
                    //Este do indica que el modo de aspiración se hará mientras no se eliga salir.
                    do {
                        //Este do hace que se repita la pregunta mientras se escriba un número entero entre 1 y 3
                        do {
                            confAspiracion = JOptionPane.showInputDialog("Elija una opción \n 1 - Modo completo \n 2 - Modo dependencias \n3 - Salir ");
                            elecAspiracion = Integer.parseInt(confAspiracion);
                        } while (elecAspiracion < 1 || elecAspiracion > 3);
                        //Este switch indica el modo de apiración escogido por el usuario
                        switch (elecAspiracion) {
                            //Con este case entra en el modo completo
                            case 1:
                                //Estos falses indica que ninguna habitación se ha limpiado.
                                limpiadoSiNo[0] = false;
                                limpiadoSiNo[1] = false;
                                limpiadoSiNo[2] = false;
                                limpiadoSiNo[3] = false;
                                limpiadoSiNo[4] = false;
                                //este contador está a cero porque así cuando se sume 1 empezará en 0 y podrá ser un dígito del array.
                                posicion = -1;
                                JOptionPane.showMessageDialog(null, "Ha elegido la opción de "
                                        + "Modo completo ");
                                JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
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
                                        posicion++;
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
                                //Muestra el estado de la batería
                                JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                break;
                            //Con este case entra en la opción por dependencias
                            case 2:
                                JOptionPane.showMessageDialog(null, "Ha elegido la opción de "
                                        + "Modo dependencias ");
                                JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
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
                                            //Multiplica los metros de la dependencia en cuestión por el desgaste de la aspiración
                                            cargaGastada = m2dependencias[0] * DESGASTEASPIRACION;
                                            //El resultado anterior lo resta a la carga.
                                            carga -= cargaGastada;
                                            //Si la carga es mayor o iguial que la cargamínia que es 3, dice que se ha limpiado la cocina, si no,
                                            //dice que no tiene suficiente batería y que se va a dirigir a la estación de carga
                                            if (carga >= CARGAMINIMA) {
                                                posicion = 0;
                                                JOptionPane.showMessageDialog(null, "Se está limpiando la cocina, por favor espere... ");
                                                JOptionPane.showMessageDialog(null, "Ha terminado de limpiar la cocina ");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                        + "la batería se quede a cero, por favor espere... ");
                                                carga = 100;
                                                JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");

                                            }
                                            //Muestra el estado de la batería.
                                            JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            continue;
                                        case 2:
                                            //Hace lo mismo que el código anterior solo que con una dependencia diferente.
                                            cargaGastada = m2dependencias[1] * DESGASTEASPIRACION;
                                            carga -= cargaGastada;
                                            if (carga >= CARGAMINIMA) {
                                                posicion = 1;
                                                JOptionPane.showMessageDialog(null, "Se está limpiando el Salón, por favor espere... ");
                                                JOptionPane.showMessageDialog(null, "Ha terminado de limpiar el salón ");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                        + "la batería se quede a cero, por favor espere... ");
                                                carga = 100;
                                                JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");

                                            }
                                            JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            continue;
                                        case 3:
                                            //Hace lo mismo que el código anterior solo que con una dependencia diferente.
                                            cargaGastada = m2dependencias[2] * DESGASTEASPIRACION;
                                            carga -= cargaGastada;
                                            if (carga >= CARGAMINIMA) {
                                                posicion = 2;
                                                JOptionPane.showMessageDialog(null, "Se está limpiando el cuarto de baño, por favor espere... ");

                                                JOptionPane.showMessageDialog(null, "Ha terminado de limpiar del cuarto de baño ");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                        + "la batería se quede a cero, por favor espere... ");
                                                carga = 100;
                                                JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");

                                            }
                                            JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            continue;
                                        case 4:
                                            //Hace lo mismo que el código anterior solo que con una dependencia diferente.
                                            cargaGastada = m2dependencias[3] * DESGASTEASPIRACION;
                                            carga -= cargaGastada;
                                            if (carga >= CARGAMINIMA) {
                                                posicion = 3;
                                                JOptionPane.showMessageDialog(null, "Se está limpiando el dormitorio 1, por favor espere... ");

                                                JOptionPane.showMessageDialog(null, "Ha terminado de limpiar el dormitorio 1 ");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                        + "la batería se quede a cero, por favor espere... ");
                                                carga = 100;
                                                JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");

                                            }
                                            JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            continue;
                                        case 5:
                                            //Hace lo mismo que el código anterior solo que con una dependencia diferente.
                                            cargaGastada = m2dependencias[4] * DESGASTEASPIRACION;
                                            carga -= cargaGastada;
                                            if (carga >= CARGAMINIMA) {
                                                posicion = 4;
                                                JOptionPane.showMessageDialog(null, "Se está limpiando el dormitorio 2, por favor espere... ");

                                                JOptionPane.showMessageDialog(null, "Ha terminado de limpiar la el dormitorio 2 ");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                        + "la batería se quede a cero, por favor espere... ");
                                                carga = 100;
                                                JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");

                                            }
                                            JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            continue;
                                        case 6:
                                            //Con esta opción sale de la aspiración en modo dependencias
                                            JOptionPane.showMessageDialog(null, "Usted ha elegido la opción de salir");
                                            break;

                                    }

                                } while (elecDependencia != 6);
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Usted ha elegido la opción de salir");
                                break;
                        }

                    } while (elecAspiracion != 3);
                    break;
                //Aquí entras en la opción de aspiración y fregado
                case 2:
                    //¡IMPORTANTE!
                    //todo este código es igual al de solo aspiración solo cambiando el desgaste por metro cuadrado
                    JOptionPane.showMessageDialog(null, "Ha elegido la opción de "
                            + "Aspiración y fregado ");
                    //Con este do consigo que se repita el interior hasta que el usuario introduzca la opción 3.
                    do {
                        do {
                            confAspiracion = JOptionPane.showInputDialog("Elija una opción \n 1 - Modo completo \n 2 - Modo dependencias \n 3 - Salir");
                            elecAspiracion = Integer.parseInt(confAspiracion);
                        } while (elecAspiracion < 1 || elecAspiracion > 3);
                        //Este switch indica el modo de apiración escogido por el usuario
                        switch (elecAspiracion) {
                            //Con este case entra en el modo completo
                            case 1:
                                limpiadoSiNo[0] = false;
                                limpiadoSiNo[1] = false;
                                limpiadoSiNo[2] = false;
                                limpiadoSiNo[3] = false;
                                limpiadoSiNo[4] = false;
                                //este contador está a cero porque así cuando se sume 1 empezará en 0 y podrá ser un dígito del array.
                                posicion = -1;
                                JOptionPane.showMessageDialog(null, "Ha elegido la opción de "
                                        + "Modo completo ");
                                JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
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
                                        posicion++;
                                    } else {
                                        continue;
                                    }

                                    continue;

                                }
                                for (i = 0; i < dependencias.length; i++) {
                                    if (limpiadoSiNo[i] == true) {
                                        JOptionPane.showMessageDialog(null, "La habitación " + dependencias[i] + " la he podido limpiar");
                                    } else {

                                        JOptionPane.showMessageDialog(null, "La habitación " + dependencias[i] + " no la he podido limpiar");

                                    }

                                }
                                JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                break;

                            //Con este case entra en la opción por dependencias
                            case 2:
                                JOptionPane.showMessageDialog(null, "Ha elegido la opción de "
                                        + "Modo dependencias ");
                                //pregunta la dependencia que quiere limpiar mientras que la respuesta sea no sea 6
                                JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
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
                                            posicion = 0;
                                            if (carga >= CARGAMINIMA) {
                                                JOptionPane.showMessageDialog(null, "Se está limpiando la cocina, por favor espere... ");

                                                JOptionPane.showMessageDialog(null, "Ha terminado de limpiar la cocina ");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                        + "la batería se quede a cero, por favor espere... ");
                                                carga = 100;
                                                JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");
                                                JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            }
                                            continue;
                                        case 2:
                                            cargaGastada = m2dependencias[1] * DESGASTEASPIRACIONFREGADO;
                                            carga -= cargaGastada;
                                            if (carga >= CARGAMINIMA) {
                                                posicion = 1;
                                                JOptionPane.showMessageDialog(null, "Se está limpiando el Salón, por favor espere... ");

                                                JOptionPane.showMessageDialog(null, "Ha terminado de limpiar el salón ");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                        + "la batería se quede a cero, por favor espere... ");
                                                carga = 100;
                                                JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");
                                                JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            }
                                            continue;
                                        case 3:
                                            cargaGastada = m2dependencias[2] * DESGASTEASPIRACIONFREGADO;
                                            carga -= cargaGastada;
                                            if (carga >= CARGAMINIMA) {
                                                posicion = 2;
                                                JOptionPane.showMessageDialog(null, "Se está limpiando el cuarto de baño, por favor espere... ");

                                                JOptionPane.showMessageDialog(null, "Ha terminado de limpiar del cuarto de baño ");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                        + "la batería se quede a cero, por favor espere... ");
                                                carga = 100;
                                                JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");
                                                JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            }
                                            continue;
                                        case 4:
                                            cargaGastada = m2dependencias[3] * DESGASTEASPIRACIONFREGADO;
                                            carga -= cargaGastada;
                                            if (carga >= CARGAMINIMA) {
                                                posicion = 3;
                                                JOptionPane.showMessageDialog(null, "Se está limpiando el dormitorio 1, por favor espere... ");

                                                JOptionPane.showMessageDialog(null, "Ha terminado de limpiar el dormitorio 1 ");

                                            } else {
                                                JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                        + "la batería se quede a cero, por favor espere... ");
                                                carga = 100;
                                                JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");

                                            }
                                            JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            continue;
                                        case 5:
                                            cargaGastada = m2dependencias[4] * DESGASTEASPIRACIONFREGADO;
                                            carga -= cargaGastada;
                                            if (carga >= CARGAMINIMA) {
                                                posicion = 4;
                                                JOptionPane.showMessageDialog(null, "Se está limpiando el dormitorio 2, por favor espere... ");

                                                JOptionPane.showMessageDialog(null, "Ha terminado de limpiar la el dormitorio 2 ");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No tiene suficiente batería la aspiradora, se redirigirá a estación de carga antes de que"
                                                        + "la batería se quede a cero, por favor espere... ");
                                                carga = 100;
                                                JOptionPane.showMessageDialog(null, "Ya ha terminado la carga de su aspiradora.");

                                            }
                                            JOptionPane.showMessageDialog(null, "El estado de la batería es del " + carga + "%");
                                            continue;
                                        case 6:
                                            JOptionPane.showMessageDialog(null, "Ha decidido salir");
                                            break;

                                    }

                                } while (elecDependencia != 6);
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Usted ha elegido la opción de salir");
                                break;
                        }
                    } while (elecAspiracion != 3);
                    break;
                //Con este case se entra a la opción de "Estado general" el cuál contiene información sobre el robot
                case 3:
                    JOptionPane.showMessageDialog(null, "Ha entrado usted en la opción de Estado General ");
                    //Con este do hago que el código se repita mientras el usuario no meta el 5 (salir)
                    do {
                        do {
                            confEstadoGeneral = JOptionPane.showInputDialog("Elija una opción: \n1-Fecha y hora actuales\n2-Nivel de batería del robot\n"
                                    + "3-Lugar donde se encuentra el robot\n4-Dependencias y metros de la casa\n5-Salir");
                            elecEstadoGeneral = Integer.parseInt(confEstadoGeneral);
                        } while (elecEstadoGeneral < 1 || elecEstadoGeneral > 5);
                        //switch para elegir entre las cuatro opciones que se muestran arriba.
                        switch (elecEstadoGeneral) {
                            //Este case muestra la fecha y hora actuales congiendolas del sistema.
                            case 1:
                                Date date = new Date();
                                //Obtenerhora y fecha y salida por pantalla con formato:
                                DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
                                JOptionPane.showMessageDialog(null, "Hora y fecha actuales: " + hourdateFormat.format(date));
                                break;
                            //Con esta opción te muestra el nivel de batería que tiene tu robot.
                            case 2:
                                JOptionPane.showMessageDialog(null, "El nivel de batería del robot es: " + carga + " %");
                                break;
                            //Esta opción te muestra donde se ha quedado el robot (en que dependencia se ha quedado)
                            case 3:
                                JOptionPane.showMessageDialog(null, "El robot se encuentra en la dependencia: " + dependencias[posicion]);
                                break;
                            //Esta opción te muestra las dependencias de la casa y los metros cuadrados de cada una.
                            case 4:
                                JOptionPane.showMessageDialog(null, "Las dependencias de la casa son: \n"
                                        + " - " + dependencias[0] + " de " + m2dependencias[0] + " metros cuadrados " + "\n"
                                        + " - " + dependencias[1] + " de " + m2dependencias[1] + " metros cuadrados " + "\n"
                                        + " - " + dependencias[2] + " de " + m2dependencias[2] + " metros cuadrados " + "\n"
                                        + " - " + dependencias[3] + " de " + m2dependencias[3] + " metros cuadrados " + "\n"
                                        + " - " + dependencias[4] + " de " + m2dependencias[4] + " metros cuadrados " + "\n");
                                break;
                            //Con esta opción sale de la opciones de Estado general
                            case 5:
                                JOptionPane.showMessageDialog(null, "Ha salido de Estado general");
                                break;
                        }
                    } while (elecEstadoGeneral != 5);
                    break;
                //Este case pertenece a la base de carga
                case 4:
                    JOptionPane.showMessageDialog(null, "Se está cargando la aspiradora, por favor espere...");
                    carga = CARGAMAXIMA;
                    JOptionPane.showMessageDialog(null, "La aspiradora se ha cargado con éxito, su nivel de carga es ahora del " + carga + "%");
                    break;
                //Con este case indicas que te sales de la aplicación al poner repetir a false
                case 5:
                    repetir = false;
                    break;

            }
            //Si repetir está a false, se sale de la aplicación
        } while (repetir);
    }

}
