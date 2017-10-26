import java.lang.System;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int packheigth = scan.nextInt(); //poggyász magassága
        int packwidth = scan.nextInt(); //poggyász szélessége
        int numOfStuff = scan.nextInt(); //elemek száma
        Stuff[] stuffs = new Stuff[numOfStuff];
        int[][] pack = new int[packheigth][packwidth];

        //elemek méreteinek beolvasása
        for (int i = 0; i < numOfStuff; i++) {
            int stuffH = scan.nextInt();
            int stuffW = scan.nextInt();
            stuffs[i] = new Stuff(stuffW, stuffH, i); //elem init
        }
        scan.close();

        for(int i = 0; i < packheigth; i++){
            for(int j = 0; j < packwidth; j++){
                pack[i][j] = 0;
            }
        }

        for (int i = 0; i < stuffs.length; i++) {
            if (stuffs[i].getHeigth() <= stuffs[i].getWidth()) {
                stuffs[i].changeDir();
            }
        }

        // Buborék rendezés az elemekre magasság szerint
        for (int i = 0; i < (stuffs.length - 1); i++) {
            for (int f = 0; f < stuffs.length - i - 1; f++) {
                if (stuffs[f].getHeigth() < stuffs[f + 1].getHeigth()) {
                    Stuff stemp = stuffs[f];
                    stuffs[f] = stuffs[f + 1];
                    stuffs[f + 1] = stemp;
                }
            }
        }

        for(int i = 0; i < stuffs.length; i++){
            if((pack[0][0] == 0)){
                if(packheigth >= stuffs[i].getHeigth() && packwidth >= stuffs[i].getWidth()) {
                    for (int a = 0; a < stuffs[i].getHeigth(); a++) {
                        for (int b = 0; b < stuffs[i].getWidth(); b++) {
                            pack[a][b] = stuffs[i].getStuffNumber();
                        }
                    }
                }else{
                    System.out.println("nem jó méret");
                }
            }else{

            }
        }

        for(int i = 0; i < packheigth; i++){
            for(int j = 0; j < packwidth; j++){
                if(j < packwidth-1) {
                    System.out.print(pack[i][j] + "\t");
                }else{
                    System.out.print(pack[i][j]);
                }
            }System.out.println();
        }
    }

}
