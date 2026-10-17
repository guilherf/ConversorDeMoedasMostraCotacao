package net.bifewagyu.convesorUnitario;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ConversorUnitario {

   static Scanner scanner = new Scanner(System.in);
   static int opcao = 0;
   static boolean entrada = false;





    public static void menu() {

        while (!entrada) {
        try {
            System.out.println("======ByGuilhermeFerreira=======Sistema de Conversão de Valores Unitarios======ByGuilhermeFerreira=======");
            System.out.println("1. Km para Metros/Metros para Km");
            System.out.println("2. Segundo para Minutos/Minutos para Segundos");
            System.out.println("3. Graus para Kelvin/Kelvin para Graus");
            System.out.println("Ainda para ser feito um dia ai mais sistema de unidade.................");
            System.out.println("Selecione uma opcao: ");
            opcao = scanner.nextInt();
            entrada = true;

            switch (opcao) {
                case 1:
                    kmParaMetros();
                    break;
                    case 2:
                        segundoParaMinuto();
                        break;
                        case 3:
                        grausParaKelvin();
                        break;

            }
        } catch (InputMismatchException e) {
            System.out.println("Numero invalido por favor coloque somente numero que aparece na lista");
            scanner.next();

        }

    }
}


    private static void kmParaMetros() {
        // Fazer um try para retornar erro de letra errado ou algo do tipo. Lembrar de fazer isso algum dia quando fazer a commit
        System.out.println("Escolhido Km para Metros/Metros para Km..... Escolha umas das opção abaixo");
        System.out.println("1. M/Metros para Km");
        System.out.println("2. Km/Kilometros para Metros");
        System.out.println();
        int subOpcao = scanner.nextInt();
        if (subOpcao == 1) {
            System.out.print("Você escolheu KM para METROS agora digite em KM o quanto vc quer converter para Metros: ");
            double km = scanner.nextDouble();
            var metros = km * 1000;

            System.out.println("O valor convertido para Metros ficou em: " + metros +" M/Metros");

        } else if (subOpcao == 2) {
            System.out.println("Você escolheu METROS para KILOMETROS agora digite em METROS o quanto vc quer converter para Kilometros: ");
            double metros =  scanner.nextDouble();
            var kilometros = metros / 1000;

            System.out.println("O valor convertido para Kilometros ficou em: " + kilometros +" Km/Kilometros");

        }


    }


    private static void segundoParaMinuto() {

        // Fazer um try para retornar erro de letra errado ou algo do tipo. Lembrar de fazer isso algum dia quando fazer a commit
        System.out.println("Escolhido Segundo para Minutos/Minutos ...... Escolha umas das opção abaixo");
        System.out.println("1. Seg/Segundo para Minutos");
        System.out.println("2. Min/Minutos para Segundos ");
        System.out.println();
        int subOpcao = scanner.nextInt();
        if (subOpcao == 1) {
            System.out.print("Você escolheu SEGUNDO para MINUTOS agora digite em Segundos o quanto vc quer converter para Minutos: ");
            double segundos = scanner.nextDouble();
            var minutos = segundos / 60;

            System.out.println("O valor convertido para Segundos ficou em: " + minutos +" Min/Minutos");

        } else if (subOpcao == 2) {
            System.out.println("Você escolheu Minutos para segundos agora digite em Minutos o quanto vc quer converter para segundos: ");
            double minutos =  scanner.nextDouble();
            var segundos = minutos * 60;

            System.out.println("O valor convertido para SEGUNDOS ficou em: " + segundos +" Seg/Segundos");

        }








    }

    private static void grausParaKelvin() {
        double valorKelvin = 273.15;
        System.out.println("Escolhido Graus para Kelvin...... Escolha umas das opção abaixo");
        System.out.println("1. G/Graus para Kelvin");
        System.out.println("2. K/Kelvin para Graus");
        System.out.println();
        int subOpcao = scanner.nextInt();
        if (subOpcao == 1) {
            System.out.print("Você escolheu KELVIN para GRAUS agora digite em GRAUS o quanto vc quer converter para KELVIN: ");
            double graus = scanner.nextDouble();
            var kelvin = graus - valorKelvin;

            System.out.println("O valor convertido para Segundos ficou em: " + kelvin +" Min/Minutos");

        } else if (subOpcao == 2) {
            System.out.println("Você escolheu GRAUS para KELVIN agora digite em GRUS o quanto vc quer converter para KELVIN: ");
            double kelvin =  scanner.nextDouble();
            var graus = kelvin + valorKelvin;

            System.out.println("O valor convertido para SEGUNDOS ficou em: " + graus +" Seg/Segundos");

        }




    }

}
