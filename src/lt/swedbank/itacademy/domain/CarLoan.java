package lt.swedbank.itacademy.domain;

public class CarLoan extends VehicleLoan implements Comparable<CarLoan>{
    private float enginePower;

    public float getEnginePower()  {
        return enginePower;
    }

    public void setEnginePower(float enginePower) {
        this.enginePower = enginePower;
    }

    @Override
    public int compareTo(CarLoan carLoan) {
        int compared = carLoan.getPrice().compareTo(this.getPrice());
        if(compared != 0){

            return  compared;
        }
        if(enginePower < carLoan.getEnginePower())
        {
            return 1;
        }
        else if(enginePower > carLoan.getEnginePower())
        {
            return -1;
        }
        compared = this.getInterestRate().compareTo(carLoan.getInterestRate());
        return compared;
    }
}
