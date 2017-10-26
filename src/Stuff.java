public class Stuff {
    private int width;
    private int heigth;
    private int stuffNumber;
    private boolean packed;

    public Stuff(int w, int h, int n){
        this.heigth = h;
        this.width = w;
        this.stuffNumber = (n + 1);
        this.packed = false;
    }

    public int getWidth(){
        return width;
    }

    public int getHeigth(){
        return heigth;
    }

    public int getStuffNumber(){
        return stuffNumber;
    }

    public boolean getPacked(){
        return packed;
    }

    public void setPacked(boolean b){
        this.packed = b;
    }

    public void changeDir(){
        int temp = heigth;
        heigth = width;
        width = temp;
    }
}
