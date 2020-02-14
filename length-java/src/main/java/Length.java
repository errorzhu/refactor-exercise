public class Length {

    public static final String INCH = "inch";
    public static final String FOOT = "f";
    public static final String YARD = "yard";

    private final double value;
    private final String unit;
    private Unit temp_unit;

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
        if (unit.equals(FOOT)) {
            temp_unit = Unit.FOOT;
        }
        if (unit.equals(YARD)) {
            temp_unit = Unit.YARD;
        }
        if (unit.equals(INCH)) {
            temp_unit = Unit.INCH;
        }
    }

    public Length as(String targetUnit) {
        Length length = this;
        if (this.temp_unit == Unit.FOOT) {
            if (targetUnit.equals(YARD)) {
                length = new Length(this.value / 3, targetUnit);
            } else if (targetUnit.equals(INCH)) {
                length = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.temp_unit == Unit.YARD) {
            if (targetUnit.equals(INCH)) {
                length = new Length(this.value * 36, targetUnit);
            } else if (targetUnit.equals(FOOT)) {
                length = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.temp_unit == Unit.INCH) {
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

    public String getUint() {
        return this.unit;
    }
}
