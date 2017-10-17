import java.lang.System;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args)  {
        List<int[][]> stuffs = new ArrayList<int[][]>(); //elemek listája
        List<Integer> stuffSizes = new ArrayList<Integer>(); //elemek méreténke listája
        Scanner scan = new Scanner(System.in);

        int packwidth = scan.nextInt(); //poggyász szélessége
        int packheigth = scan.nextInt(); //poggyász magassága
        int numOfStuff = scan.nextInt(); //elemek száma
        //elemek méreteinek beolvasása
        for (int i = 0; i < numOfStuff; i++){
            int stuffW = scan.nextInt();
            int stuffH = scan.nextInt();
            int[][] stuff = new int[stuffW][stuffH]; //elem init
            //elemek feltöltése azzal a számkóddal ahányadik elem
            for(int k = 0; k < stuffH; k++){
                for(int z = 0; z < stuffW; z++){
                    stuff[z][k] = i+1;
                }
            }
            stuffs.add(stuff);
            stuffSizes.add(stuffW*stuffH); // elemek méretének lista feltöltése
        }

        int[][] packed = new int[packwidth][packheigth]; //poggász init

        for(int k = 0; k < packheigth; k++){
            for(int z = 0; z < packwidth; z++){
                packed[z][k] = 9;
            }
        }
        int packedSize = packheigth*packwidth; //poggyász terület számítás

        for(int i = 0; i < stuffSizes.size(); i ++){
            if(stuffSizes.get(i) <= packedSize){
                System.out.println("Belefér");
                for(int gk = 0; gk < stuffs.get(i)[0].length; gk++){
                    for(int zh = 0; zh < stuffs.get(i).length; zh++){
                        packed[gk][zh] = stuffs.get(i)[gk][zh];
                    }
                }
                packedSize = packedSize - stuffSizes.get(i);
            }else{
                System.out.println("Nem fér bele");
            }
        }
        for(int i = 0; i < packheigth; i++){
            for(int y = 0; y < packwidth; y++){
                System.out.print(packed[i][y]);
            }
            System.out.println();

            /*valami van is */
        }
    }
}

