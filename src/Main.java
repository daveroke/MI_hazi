import java.lang.System;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);

        int packheigth = scan.nextInt(); //poggyász magassága
        int packwidth = scan.nextInt(); //poggyász szélessége
        int numOfStuff = scan.nextInt(); //elemek száma
        Stuff[] stuffs = new Stuff[numOfStuff];

        //elemek méreteinek beolvasása
        for (int i = 0; i < numOfStuff; i++){
            int stuffH = scan.nextInt();
            int stuffW = scan.nextInt();
            stuffs[i] = new Stuff(stuffW, stuffH, i); //elem init
        }
        //Poggász init
        int[][] pack = new int[packwidth][packheigth];
        for(int k = 0; k < packheigth; k++){
            for(int z = 0; z < packwidth; z++){
                pack[z][k] = 0;
            }
        }
        
        // Buborék rendezés az elemekre magasság szerint
        for(int i = 0; i < (stuffs.length - 1); i++){
            for(int f = 0; f < stuffs.length - i - 1; f++){
                if(stuffs[f].getHeigth() < stuffs[f+1].getHeigth()){
                    Stuff stemp = stuffs[f];
                    stuffs[f] = stuffs[f+1];
                    stuffs[f+1] = stemp;
                }
            }
        }
        //Buborék rendezés az elemekre szélesség szerint
        for(int i = 0; i < (stuffs.length - 1); i++){
            for(int f = 0; f < stuffs.length - i - 1; f++){
                if(stuffs[f].getWidth() < stuffs[f+1].getWidth()){
                    Stuff stemp = stuffs[f];
                    stuffs[f] = stuffs[f+1];
                    stuffs[f+1] = stemp;
                }
            }
        }


        for(int i = 0; i < packheigth; i++){
            for(int y = 0; y < packwidth; y++){
                if(y < packwidth-1) {
                    System.out.print(pack[y][i] + "\t");
                }else{
                    System.out.print(pack[y][i]);
                }
            }
            System.out.println();
        }
    }

    public void writeInPack(int[][] p, Stuff s){

    }
}
