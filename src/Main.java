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

        //Poggász init
        for(int i = 0; i < packheigth; i++){
            for(int j = 0; j < packwidth; j++){
                pack[i][j] = 0;
            }
        }

       for(int i = 0; i < stuffs.length; i++){
            if((stuffs[i].getHeigth() > stuffs[i].getWidth())){
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

        // rendezés szélesség szerint is
        for (int i = 0; i < (stuffs.length - 1); i++) {
            for (int f = 0; f < stuffs.length - i - 1; f++) {
                if ((stuffs[f].getHeigth() == stuffs[f+1].getHeigth()) && (stuffs[f].getWidth() < stuffs[f + 1].getWidth())) {
                    Stuff stemp = stuffs[f];
                    stuffs[f] = stuffs[f + 1];
                    stuffs[f + 1] = stemp;
                }
            }
        }

        for(int i = 0; i < stuffs.length; i++){
               stuffs[i].changeDir();
        }

        for(int i = 0; i < stuffs.length; i++){
            for(int posY = 0; posY < packheigth; posY++){
                for(int posX = 0; posX < packwidth; posX++){
                    if(!stuffs[i].getPacked() && (pack[posY][posX] == 0) && (packheigth - posY > stuffs[i].getHeigth()-1) && (packwidth - posX > stuffs[i].getWidth()-1)){
                        boolean good = true;
                        for(int sPosY = posY; sPosY < posY + stuffs[i].getHeigth(); sPosY++){
                            for(int sPosX = posX; sPosX < posX + stuffs[i].getWidth(); sPosX++){
                                if(pack[sPosY][sPosX] != 0){
                                    good = false;
                                }
                            }
                        }
                        if(good){
                            for(int packingY = posY; packingY < posY + stuffs[i].getHeigth(); packingY++){
                                for(int packingX = posX; packingX < posX + stuffs[i].getWidth(); packingX++){
                                    pack[packingY][packingX] = stuffs[i].getStuffNumber();
                                }
                            }
                            stuffs[i].setPacked(true);
                        }
                    }else {
                        stuffs[i].changeDir();
                        if(!stuffs[i].getPacked() && (pack[posY][posX] == 0) && (packheigth - posY > stuffs[i].getHeigth()-1) && (packwidth - posX > stuffs[i].getWidth()-1)) {
                            boolean good = true;
                            for (int sPosY = posY; sPosY < posY + stuffs[i].getHeigth(); sPosY++) {
                                for (int sPosX = posX; sPosX < posX + stuffs[i].getWidth(); sPosX++) {
                                    if (pack[sPosY][sPosX] != 0) {
                                        good = false;
                                    }
                                }
                            }
                            if (good) {
                                for (int packingY = posY; packingY < posY + stuffs[i].getHeigth(); packingY++) {
                                    for (int packingX = posX; packingX < posX + stuffs[i].getWidth(); packingX++) {
                                        pack[packingY][packingX] = stuffs[i].getStuffNumber();
                                    }
                                }
                                stuffs[i].setPacked(true);
                            }
                        }else{
                            stuffs[i].changeDir();
                        }
                    }
                }
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
