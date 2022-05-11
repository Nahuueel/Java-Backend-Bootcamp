public class HerculesC130 implements StrategyPlanes{

    @Override
    public double FlightTime(double distance, int climate) {
        switch(climate)
        case 0:
        return distance/590;
        case 1:
        return (distance/590) * 1.15;
        case 2:
        return (distance/590) * 1.25;
        case 3:
        return (distance/590) * 1.50;
        default:
            

    }

    @Override
    public double LandTime(double runwaySize) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double TakeOffTime(double runwaySize) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
