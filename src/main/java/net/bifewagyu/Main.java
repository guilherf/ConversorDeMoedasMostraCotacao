package net.bifewagyu;

import net.bifewagyu.cambios.ConexcaoAPICambio;
import net.bifewagyu.convesorUnitario.ConversorUnitario;

import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


  static  Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {



            int opcao;
            boolean entradaValida = true;

        while (entradaValida) {
            try {
                System.out.println("=================================================================");
                System.out.println("SISTEMA DE CONVERSÃO UNITARIO E CAMOBIO BY: GUILHERME FERREIRA");
                System.out.println("1 CONVERSOR UNITARIO");
                System.out.println("2 CONVERSOR CAMBIO (EM TEMPO REAL)");
                System.out.println("=================================================================");
                opcao = sc.nextInt();
                if (opcao == 1) {
                    System.out.println();
                    System.out.println();
                    ConversorUnitario.menu();
                    sc.reset();
                    entradaValida = false;
                    continue;

                } else if (opcao == 2) {

                    System.out.println();
                    System.out.println();
                    ConexcaoAPICambio.connect();
                    entradaValida = false;
                    continue;
                }
                System.out.println("Numero errado digite um numero 1 ou 2");
                System.out.println();


            } catch (InputMismatchException e) {
                System.out.println("Numero errado porfavor bote um numero valido");
                entradaValida = false;
            }

        }

    }
}