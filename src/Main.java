import java.lang.System;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args)  {
        //List<Stuff> stuffs = new ArrayList<Stuff>(); //elemek listája
        Scanner scan = new Scanner(System.in);

        int packwidth = scan.nextInt(); //poggyász szélessége
        int packheigth = scan.nextInt(); //poggyász magassága
        int numOfStuff = scan.nextInt(); //elemek száma
        int[] stuffSizes = new int[numOfStuff]; //elemek méretének// listája
        Stuff[] stuffs = new Stuff[numOfStuff];

        //elemek méreteinek beolvasása
        for (int i = 0; i < numOfStuff; i++){
            int stuffW = scan.nextInt();
            int stuffH = scan.nextInt();
            stuffs[i] = new Stuff(stuffW, stuffH, i); //elem init
            stuffSizes[i] = stuffH*stuffW;
        }
        //Poggász init
        int[][] pack = new int[packwidth][packheigth];
        for(int k = 0; k < packheigth; k++){
            for(int z = 0; z < packwidth; z++){
                pack[z][k] = 0;
            }
        }
        int packedSize = packheigth*packwidth; //poggyász terület számítás
        
        // Buborék rendezés az elemekre
        for(int i = 0; i < (stuffSizes.length - 1); i++){
            for(int f = 0; f < stuffSizes.length - i - 1; f ++){
                if(stuffSizes[f] > stuffSizes[f+1]){
                    int temp = stuffSizes[f];
                    Stuff stemp = stuffs[f];
                    stuffSizes[f] = stuffSizes[f+1];
                    stuffs[f] = stuffs[f+1];
                    stuffSizes[f+1] = temp;
                    stuffs[f+1] = stemp;
                }
            }
        }

        for(int i = 0; i < stuffSizes.length; i++){
            if(packheigth >= stuffs[i].getHeigth() && packwidth >= stuffs[i].getWidth() && stuffSizes[i] <= packedSize){
                System.out.println("Belefér");
                packedSize = packedSize - stuffSizes[i];
            }else{
                stuffs[i].changeDir();
                if(packheigth >= stuffs[i].getHeigth() && packwidth >= stuffs[i].getWidth() && stuffSizes[i] <= packedSize){
                    System.out.println("Belefér");
                    packedSize = packedSize - stuffSizes[i];
                }else {
                    System.out.println("Nem fér bele");
                }
            }
        }

        for(int i = 0; i < packheigth; i++){
            for(int y = 0; y < packwidth; y++){
                System.out.print(pack[y][i]);
            }
            System.out.println();
<<<<<<< HEAD
=======
            
>>>>>>> 28f160eca83d82ffbced0f62a9cceaec68994449
        }

    }


}

