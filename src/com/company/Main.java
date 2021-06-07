package com.company;

import java.util.Scanner;

public class Main {

    private static Kart[][] kart = new Kart[4][4];

    public static void main(String[] args) {

     kart[0][0] = new Kart('E');
     kart[0][1] = new Kart('A');
     kart[0][2] = new Kart('B');
     kart[0][3] = new Kart('F');
     kart[1][0] = new Kart('G');
     kart[1][1] = new Kart('A');
     kart[1][2] = new Kart('D');
     kart[1][3] = new Kart('H');
     kart[2][0] = new Kart('F');
     kart[2][1] = new Kart('C');
     kart[2][2] = new Kart('D');
     kart[2][3] = new Kart('H');
     kart[3][0] = new Kart('E');
     kart[3][1] = new Kart('H');
     kart[3][2] = new Kart('B');
     kart[3][3] = new Kart('C');




        while(oyunBittimi() == false){          //false olduğu sürece while dönsün
            kartTahtasi();
            tahminEt();
        }

    }


    public static void tahminEt(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("1. Tahminini gir ( i ve j değerlerini, boşluk olucak şekilde) : ");

        int i1 = scanner.nextInt();
        int j1 = scanner.nextInt();

        //Tahtayı ilk göster kullanıcı tahminleri için
        kart[i1][j1].setTahmin(true);
        kartTahtasi();


        System.out.print("2. Tahminini gir ( i ve j değerlerini, boşluk olucak şekilde) : ");
        int i2 = scanner.nextInt();
        int j2 = scanner.nextInt();


        if(kart[i1][j1].getDeger() == kart[i2][j2].getDeger()){
            System.out.println("Doğru Tahmin. . . . . .");
            kart[i2][j2].setTahmin(true);
        }
        else {
            System.out.println("Tahmin Yanlış devam!");
            kart[i1][j1].setTahmin(false);
        }



    }






    public static boolean oyunBittimi(){
        for(int i=0 ; i < 4 ; i++){
            for(int j=0 ; j < 4 ; j++){

                if(kart[i][j].isTahmin() == false){
                    return false;
                }
            }
        }

        return true;
    }


    public static void kartTahtasi(){
        for(int i =0 ; i < 4 ; i++){
            System.out.println("___________________________");
            for(int j = 0 ; j < 4 ; j++){

                if(kart[i][j].isTahmin()){                                        //Kart Tahmini doğruysa
                    System.out.print(" | "+kart[i][j].getDeger()+ " | ");       //Kartları göster

                }else {
                    System.out.print(" | | ");                                   //BOŞ TAHTAYI GÖSTER
                }
            }
            System.out.println(); //Alt satıra in 1.satır tamamlandıktan sonra
        }
        System.out.println("___________________________");
    }




}
