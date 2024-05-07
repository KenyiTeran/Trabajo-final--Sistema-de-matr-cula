package TrabajoFinal;

import java.util.Scanner;

public class trabajoFinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        // Datos del estudiante
        String[] preguntasDatos = {
                "Ingrese su numero de DNI: ",
                "Ingrese su apellido paterno: ",
                "Ingrese su apellido materno: ",
                "Ingrese su nombre: ",
                "Ingrese su edad: ",
                "Ingrese el nombre de su colegio: ",
                "Su colegio de procedencia es estatal o particular: ",
                "Ingrese la modalidad de su preferencia (presencial o virtual): ",
                "Ingrese su genero (Masculino o Femenino): "
        };

        String[] respuestasDatos = new String[preguntasDatos.length];

        for (int i = 0; i < preguntasDatos.length; i++) {
            System.out.print(preguntasDatos[i]);
            if (i == 4) {
                int edad = sc.nextInt();
                respuestasDatos[i] = Integer.toString(edad);
                sc.nextLine();
            } else {
                respuestasDatos[i] = sc.nextLine();
            }
        }


        //Evaluacion para alumnos de 5to
        System.out.println("Responder solo verdadero o falso en cada pregunta");
        String[] preguntasEvaluacion = {
                "1. Si el valor del lado del cuadrado es 5cm, su perimetro seria de 20 cm: ",
                "2. Si el valor del lado de un triangulo equilatero es 8cm, su perimetro seria 64cm: ",
                "3. Si el valor de los catetos es 3cm y 4cm, entonces su hipotenusa mide 5cm: ",
                "4. El numero que aumentado en 2, luego multiplicado por 5, y disminuido en 3, da por resultado 47 es 9: "
        };

        String[] respuestas = new String[preguntasEvaluacion.length];

        for (int i = 0; i < preguntasEvaluacion.length; i++) {
            System.out.print(preguntasEvaluacion[i]);
            respuestas[i] = sc.nextLine();
        }


        int nota1 = obtNota1(respuestas[0]);
        int nota2 = obtNota2(respuestas[1]);
        int nota3 = obtNota3(respuestas[2]);
        int nota4 = obtNota4(respuestas[3]);


        int notaFinal = nota1 + nota2 + nota3 + nota4;;
        System.out.print("Su nota final es: " + notaFinal + "\n");
        sc.nextLine();


        //Cantidad de horas sugeridas despues de la evaluacion
        int horasSug = obtCantHoras(notaFinal);
        int precioPorHora = obtPrecio(respuestasDatos[6],respuestasDatos[7]);
        String articulo = obtArt(respuestasDatos[8]);

        //INFORME
        System.out.println("INFORME DEL ALUMNO");
        System.out.println("Despues del proceso de evaluacion, " + articulo + " " + respuestasDatos[3] + " " + respuestasDatos[1] + " obtuvo una nota de " +
                notaFinal + " puntos, " +
                "por lo que se le sugiere tomar clases de " + horasSug + " horas semanales.");
        System.out.println("El precio por hora segun la modalidad elegida es de: " + precioPorHora + " soles.");

        System.out.print("Si desea continuar con el proceso de matricula, ingrese la palabra SI, de lo contario ingrese la palabra NO:");
        String respuesta = sc.nextLine();
        //sc.nextLine();
        String opcionesPago = obtOpc(respuesta);
        System.out.println(opcionesPago);
        String pago = sc.nextLine();
        String cuenta = obtCu(pago);
        System.out.println(cuenta);
        System.out.println("Enviar la captura del pago realizado para que se active el codigo del estudiante.");

        //Generar codigo
        String codigo = respuestasDatos[3].substring(0,1) + respuestasDatos[1].substring(0,1) + respuestasDatos[2].substring(0,1) +
                respuestasDatos[0].substring(0,8);

        //FINAL DE MATRICULA
        System.out.println(" ");
        System.out.println("MATRICULA EXITOSA");
        System.out.println("Tu codigo de acceso a la plataforma para que puedas visualizar tus horarios es:" + codigo);
    }

    private static String obtCu(String pago) {
        String cuenta = "";
        if(pago.equals("yape")){
            cuenta = "Realizar el pago al numero 907280626";
        }else if(pago.equals("transferencia")){
            cuenta = "Realizar el pago a la siguiente cuenta: BCP SOLES CC: 19170242851073 o BCP SOLES CCI: 00219117024285107359";
        }
        return cuenta;
    }

    private static String obtOpc(String respuesta) {
        String opciones = "";
        if (respuesta.equals("SI")) {
            opciones = "Con que medio desea pagar (yape o transferencia): ";
        }else if (respuesta.equals("NO")) {
            opciones = "Gracias por su tiempo, los esperamos en otra oportunidad.";
        }
        return opciones;
    }

    private static String obtArt(String genero) {
        String articulo = "";
        if (genero.equals("Masculino")) {
            articulo = "el alumno";
        }else if (genero.equals("Femenino")) {
            articulo = "la alumna";
        }
        return articulo;
    }

    private static int obtPrecio(String procedencia, String modalidad) {
        int precio = 0;
        if(procedencia.equals("Estatal") && modalidad.equals("Virtual")) {
            precio = 40;
        }else if(procedencia.equals("Estatal") && modalidad.equals("Presencial")) {
            precio = 50;
        }else if(procedencia.equals("Particular") && modalidad.equals("Virtual")) {
            precio = 50;
        }else if(procedencia.equals("Particular") && modalidad.equals("Presencial")) {
            precio = 60;
        }
        return precio;
    }

    private static int obtCantHoras(int notaFinal) {
        int sugeridas = 0;
        if (notaFinal == 5) {
            sugeridas = 8;
        }else if (notaFinal == 10) {
            sugeridas = 6;
        }else if (notaFinal == 15) {
            sugeridas = 4;
        }else if (notaFinal == 20) {
            sugeridas = 2;
        }else if (notaFinal == 0) {
            sugeridas = 10;
        }
        return sugeridas;
    }

    private static int obtNota1(String r1) {
        int nota = 0;
        if (r1.equals("v")) {
            nota = 5;
        }else if (r1.equals("f")) {
            nota = 0;
        }
        return nota;
    }

    private static int obtNota2(String r2) {
        int nota = 0;
        if (r2.equals("v")) {
            nota = 0;
        }else if (r2.equals("f")) {
            nota = 5;
        }
        return nota;
    }

    private static int obtNota3(String r3) {
        int nota = 0;
        if (r3.equals("v")) {
            nota = 5;
        }else if (r3.equals("f")) {
            nota = 0;
        }
        return nota;
    }

    private static int obtNota4(String r4) {
        int nota = 0;
        if (r4.equals("v")) {
            nota = 0;
        }else if (r4.equals("f")) {
            nota = 5;
        }
        return nota;
    }
}