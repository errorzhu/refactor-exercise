public enum Unit {
    YARD(36), INCH(1), FOOT(12);

    private double value;
    Unit(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public double getRatio(Unit target){
        return this.getValue()/target.getValue();

    }
}
