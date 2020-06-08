package MultiVariableRegression;

import FilePackage.DateTimeWriter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class  MedianCalculation {
    public int sizeA;
    public double interQuartileRange;

    int firstQuartile;
    int thirdQuartile;

    public void medianCalculationMethods(List<Double> list){
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Collections.sort(list);
        System.out.println(list);
        sizeA = list.size();
        findMinimumValue(list);
        findMaximumValue(list);
        findMedianValue(list);
        findFirstQuartileValue(list);
        findThirdQuartileValue(list);

        findInterQuartileRange(list);

        findLowerAdjacentValue(list);
        findUpperAdjacentValue(list);

    }

    public void findMinimumValue(List<Double> list){
        System.out.println("Minimum value : "+list.get(0));

    } public void findFirstQuartileValue(List<Double> list){

        double q1 = sizeA/4;
         firstQuartile = (int)q1;
        double checkFloor = q1 - firstQuartile;
        if(checkFloor>0.5){
            firstQuartile++;
        }
        else{
            firstQuartile++;

            firstQuartile--;
        }

        System.out.println("First Quartile Value : "+list.get(firstQuartile));



    } public void findMedianValue(List<Double> list){


        double median,median1,median2;
        if(sizeA%2==1){
median = list.get(sizeA/2);

        }
        else{

median1  = list.get(sizeA/2);
median2 =  list.get((sizeA-1)/2);

median = (median1 + median2)/2;


        }
        System.out.println("Median value : "+median);



    }
    public void findThirdQuartileValue(List<Double> list){


        double q2 = (3*sizeA)/4;
         thirdQuartile = (int)q2;

        double checkFloor = q2 - thirdQuartile;

        if(checkFloor>0.5){
            thirdQuartile++;
        }
        else{
            thirdQuartile++;

            thirdQuartile--;
        }
        System.out.println("Third Quartile Value : "+list.get(thirdQuartile));
    } public void findMaximumValue(List<Double> list){



        System.out.println("Maximum Value : "+list.get(sizeA-1));

        

    }


    public void findInterQuartileRange(List<Double> list){


        interQuartileRange = list.get(thirdQuartile) -  list.get(firstQuartile) ;

    }

    public void findLowerAdjacentValue(List<Double> list){

        double lowerAdjacentValue = firstQuartile - (1.5 * interQuartileRange);
        System.out.println("Lower Adjacent Value : "+lowerAdjacentValue);

    }
    public void findUpperAdjacentValue(List<Double> list){

        double upperAdjacentValue = thirdQuartile + (1.5 * interQuartileRange);
        System.out.println("Upper Adjacent Value : "+upperAdjacentValue);

    }

}
