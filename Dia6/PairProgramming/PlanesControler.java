public class PlanesControler {

    private StrategyPlanes PlaneType;

    public PlanesControler(StrategyPlanes Splane){
        PlaneType = Splane;
    }

    public Double TakeOffTime(double runwaySize){
        return PlaneType.TakeOffTime(runwaySize);
    }

    public Double FlightTime(double distance, int climate){
        return PlaneType.FlightTime(distance, climate);
    }

    public Double LandTime(double runwaySize){
        return PlaneType.LandTime(runwaySize);
    }
}
