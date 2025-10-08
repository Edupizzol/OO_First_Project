package Trabalho_OO.Main;

import Trabalho_OO.Main.MenuReal;
import Trabalho_OO.Main.Menu;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MenuReal menu = new MenuReal();

        int opcao = -1;

        while (opcao != 0) {

            menu.MostrarOpções();
            System.out.println("Digite sua opção (ou 0 para sair): ");

            if (sc.hasNextInt()) {

                opcao = sc.nextInt();
                sc.nextLine();

                if (opcao != 0) {

                    menu.executarOpção(opcao);

                }

            } else {
                System.out.println("Opção inválida!");
                sc.nextLine();

            }
        }

        System.out.println("Saindo do sistema...");

        sc.close();
    }
}


