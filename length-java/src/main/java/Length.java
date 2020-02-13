public class Length {
    private final double value;
    private final String unit;

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(String targetUnit) {
        Length length = this;
        if (this.unit.equals("f")) {
            if (targetUnit.equals("yard")) {
                length = new Length(this.value / 3, targetUnit);
            } else if (targetUnit.equals("inch")) {
                length = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.unit.equals("yard")) {
            if (targetUnit.equals("inch")) {
                length = new Length(this.value * 36, targetUnit);
            } else if (targetUnit.equals("f")){
                length = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.unit.equals("inch")) {
            if (targetUnit.equals("f")) {
                length = new Length(this.value / 12, targetUnit);
            } else if (targetUnit.equals("yard")) {
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
