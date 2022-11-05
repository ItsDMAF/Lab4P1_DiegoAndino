package lab4p1_diegoandino;

import java.util.Scanner;

public class Lab4P1_DiegoAndino {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("");
            System.out.println("1 <- Sumador binario");
            System.out.println("2 <- Contains");
            System.out.println("3 <- Alpha");
            System.out.println("4 <- Salida.");
            System.out.println("Ingrese la opcion que desea: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:

                    System.out.println("Ingrese primer binario: ");
                    String bino1 = leer.next();
                    System.out.println("Ingrese segundo binario: ");
                    String bino2 = leer.next();
                    
                    SumadorBinario(bino1, bino2);

                    break;
//------------------------------------------------------------------------------                   
                case 2:

                    //int tamaño1, tamaño2, resultado;
                    System.out.println("Ingrese la primera cadena: ");
                    String contenedor = leer.next();
                    System.out.println("Ingrese la segunda cadena: ");
                    String contenida = leer.next();

                    Contains(contenedor, contenida);

                    break;
//------------------------------------------------------------------------------                   
                case 3:
                    System.out.println("Ingrese una cadena: ");
                    String cadena = leer.next();

                    Alpha(cadena);

                    break;
//------------------------------------------------------------------------------  
            }

        } while (opcion != 4);
    }

    public static void SumadorBinario(String bino1, String bino2) {
        String bino = "";

        boolean valid = true;
        if (bino1.length() == bino2.length()) {
            for (int i = 0; i < bino1.length(); i++) {
                if ((bino1.charAt(i) != '1' && bino1.charAt(i) != '0') && (bino2.charAt(i) != '1' && bino2.charAt(i) != '0')) {
                    valid = false;
                    break;
                }

            }
        } else {
            valid = false;
        }
        if (valid) {
            System.out.println("en el valid");
            char carry = '0';
            for (int i = 0; i < bino1.length(); i++) {
                char num1 = bino1.charAt(i);
                char num2 = bino2.charAt(i);

                if (carry == '0') {
                    if (num1 == '0' && num2 == '0') {
                        bino += '0';
                        carry = '0';
                    }
                    if (num1 == '1' && num2 == '0' || num1 == '0' && num2 == '1') {
                        bino += '1';
                        carry = '0';
                    }
                    if (num1 == '1' && num2 == '1') {
                        bino += '0';
                        carry = '1';
                    }
                } else {
                    if (num1 == '0' && num2 == '0') {
                        bino += '1';
                        carry = '0';
                    }
                    if (num1 == '1' && num2 == '0' || num1 == '0' && num2 == '1') {
                        bino += '0';
                        carry = '1';
                    }
                    if (num1 == '1' && num2 == '1') {
                        bino += '1';
                        carry = '1';
                    }
                }
            }

            System.out.print(bino);
            bino = "0";

        } else {
            System.out.println("not valid");
        }

    }

    public static void Contains(String contenedor, String contenida) {
        int cont = 0;
        boolean si = true;

        for (int i = 0; i < contenedor.length(); i++) {
            if (contenida.length() == i) {
                break;
            }
            if (contenida.charAt(i) == contenedor.charAt(i)) {
                cont++;

            }

        }
        if (cont == contenida.length()) {
            System.out.println(si);
            System.out.println("La cadena " + contenedor + " contiene a la cadena " + contenida);

        } else {
            System.out.println("No la contiene o la segunda cadena es mas grande.");
        }
    }

    public static void Alpha(String cadena) {
        int contad = 0;

        for (int i = 0; i < cadena.length(); i++) {
            char cadena1 = cadena.charAt(i);
            if ((int) cadena1 > 65 && (int) cadena1 < 91 || (int) cadena1 > 96 && (int) cadena1 < 123) {
                contad++;

            }
        }
        if (contad == cadena.length()) {
            System.out.println("La cadena sólo contiene letras.");
        } else {
            System.out.println("La cadena contiene caracteres que no son letras.");
        }

    }
}
