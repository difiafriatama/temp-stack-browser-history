package com.github.affandes.kuliah.pm;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Stack<String> backStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();

        Scanner input = new Scanner(System.in);
        String currentPage = "Home"; // halaman awal

        int menu;

        while (true) {
            System.out.println("\n===== Browser History =====");
            System.out.println("Halaman saat ini : " + currentPage);
            System.out.println("1. Kunjungi halaman baru");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Lihat history");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            menu = input.nextInt();
            input.nextLine(); // clear buffer

            switch (menu) {
                case 1:
                    System.out.print("Masukkan URL: ");
                    String newUrl = input.nextLine();

                    backStack.push(currentPage);
                    currentPage = newUrl;
                    forwardStack.clear();

                    System.out.println("Berhasil pergi ke " + currentPage);
                    break;

                case 2:
                    if (backStack.isEmpty()) {
                        System.out.println("Tidak bisa back, history kosong.");
                    } else {
                        forwardStack.push(currentPage);
                        currentPage = backStack.pop();

                        System.out.println("Kembali ke: " + currentPage);
                    }
                    break;

                case 3:
                    if (forwardStack.isEmpty()) {
                        System.out.println("Tidak bisa forward.");
                    } else {
                        backStack.push(currentPage);
                        currentPage = forwardStack.pop();

                        System.out.println("Maju ke: " + currentPage);
                    }
                    break;

                case 4:
                    System.out.println("\n=== Back Stack ===");
                    for (String s : backStack) System.out.println(s);

                    System.out.println("\n=== Forward Stack ===");
                    for (String s : forwardStack) System.out.println(s);
                    break;

                case 5:
                    System.out.println("Program selesai.");
                    return;

                default:
                    System.out.println("Menu tidak tersedia.");
            }
        }
    }
}
