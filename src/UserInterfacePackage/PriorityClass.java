package UserInterfacePackage;

import ObjectOriented.PriorityData;

public class PriorityClass {
   public PriorityData priorityData;
  public   double mlrWeight;
  public int index;

    public PriorityClass(double mlrWeight, int index) {
        this.mlrWeight = mlrWeight;
        this.index = index;
    }

    public PriorityClass() {
    }

    public PriorityClass(PriorityData priorityData, double mlrWeight) {
        this.priorityData = priorityData;
        this.mlrWeight = mlrWeight;
    }

    public PriorityData getPriorityData() {
        return priorityData;
    }

    public void setPriorityData(PriorityData priorityData) {
        this.priorityData = priorityData;
    }

    public double getMlrWeight() {
        return mlrWeight;
    }

    public void setMlrWeight(double mlrWeight) {
        this.mlrWeight = mlrWeight;
    }
}
