package earthquakes.searches;

public class EqSearch {
    private int distance;
    private int minmag;

    public EqSearch(){};

    public void setDistance(int dist){
        distance= dist;
    }

    public void setMinmag(int mm){
        minmag= mm;
    }

    public int getDistance(){
        return distance;
    }

    public int getMinmag(){
        return minmag;
    }

}