public class Length {

    private final double value;

    private Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }


    public Length as(Unit targetUnit) {
        double ratio = this.unit.getRatio(targetUnit);
        return  new Length(this.value*ratio,targetUnit);
    }

    public double getValue() {
        return this.value;
    }


    public Unit getUnit() {
        return unit;
    }
}
