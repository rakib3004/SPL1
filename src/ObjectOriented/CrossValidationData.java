package ObjectOriented;

public class CrossValidationData {

    public double calculatedValue;
    public double estimatedData;

    public CrossValidationData(double calculatedValue, double estimatedData) {
        this.calculatedValue = calculatedValue;
        this.estimatedData = estimatedData;
    }

    public double getCalculatedValue() {
        return calculatedValue;
    }

    public void setCalculatedValue(double calculatedValue) {
        this.calculatedValue = calculatedValue;
    }

    public double getEstimatedData() {
        return estimatedData;
    }

    public void setEstimatedData(double estimatedData) {
        this.estimatedData = estimatedData;
    }
}
