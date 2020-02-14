public class Length {

    public static final String INCH = "inch";
    public static final String FOOT = "f";
    public static final String YARD = "yard";

    private final double value;

    private Unit unit;

    public Length(double value, String unit) {
        this.value = value;

        if (unit.equals(FOOT)) {
            this.unit = Unit.FOOT;
        }
        if (unit.equals(YARD)) {
            this.unit = Unit.YARD;
        }
        if (unit.equals(INCH)) {
            this.unit = Unit.INCH;
        }
    }

    public Length as(String targetUnit) {
        Length length = this;
        if (this.unit == Unit.FOOT) {
            if (targetUnit.equals(YARD)) {
                length = new Length(this.value / 3, targetUnit);
            } else if (targetUnit.equals(INCH)) {
                length = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.unit == Unit.YARD) {
            if (targetUnit.equals(INCH)) {
                length = new Length(this.value * 36, targetUnit);
            } else if (targetUnit.equals(FOOT)) {
                length = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.unit == Unit.INCH) {
            if (targetUnit.equals(FOOT)) {
                length = new Length(this.value / 12, targetUnit);
            } else if (targetUnit.equals(YARD)) {
                length = new Length(this.value / 36, targetUnit);
            }
        }

        return length;
    }

    public double getValue() {
        return this.value;
    }


    public Unit getUnit() {
        return unit;
    }
}
