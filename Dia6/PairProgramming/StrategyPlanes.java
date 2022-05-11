public interface StrategyPlanes {

    public double FlightTime(double distance, int climate);

    public double LandTime(double runwaySize);
    
    public double TakeOffTime(double runwaySize);

}
