public class Punto {
    private int x, y;

    public Punto(){
        this(0, 0);
    }

    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Punto(int range){
        x = (int)(Math.random() * range);
        y = (int)(Math.random() * range);
    }

    public int getX(){

        return x;
    }

    public int getY(){

        return y;
    }

    public int cuadrante(){  //<>
        int cuad;

        if(x > 0){
            if(y > 0){
                cuad = 1;
            } else{
                cuad = 4;
            }
        } else {
            if(y > 0){
                cuad = 2;
            } else{
                cuad = 3;
            }
        }

        return cuad;
    }

    public double distancia(Punto punto){
        
        double dist = Math.sqrt(Math.pow(((double)x - (double)punto.getX()), 2.0) + 
        Math.pow(((double)y - (double)punto.getY()), 2.0));

        return dist;
    }
}