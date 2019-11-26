package earthquakes.searches;

public class EqSearch {
    private int distance;
    private int minmag;
    private int lat;
    private int lon;
    private String location;

    public EqSearch(){};

    public void setDistance(int dist){
        distance= dist;
    }

    public void setMinmag(int mm){
        minmag= mm;
    }

    public void setLat(int la){
        lat= la;
    }

    public void setLon(int lo){
        lon= lo;
    }

    public void setLocation(String loc){
        location= loc;
    }

    public int getDistance(){
        return distance;
    }

    public int getMinmag(){
        return minmag;
    }

    public int getLat(){
        return lat;
    }

    public int getLon(){
        return lon;
    }

    public String getLocation(){
        return location;
    }

}