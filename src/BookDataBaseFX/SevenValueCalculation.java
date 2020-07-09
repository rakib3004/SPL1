package BookDataBaseFX;

import FilePackage.DateTimeWriter;

import java.util.Collections;
import java.util.List;

public class SevenValueCalculation {
    public int sizeA;
    public double interQuartileRange;
    int firstQuartile;
    int thirdQuartile;
    public double [] sevenValueCalculationMethods(List<Double> list){

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        
               double [] sevenValueArray  =  new double[7];
        Collections.sort(list);
        System.out.println(list);
        sizeA = list.size();
       sevenValueArray[0] =  findMinimumValue(list);
        sevenValueArray[6] =findMaximumValue(list);
        sevenValueArray[3]= findMedianValue(list);
        sevenValueArray[2]= findFirstQuartileValue(list);
        sevenValueArray[4]=  findThirdQuartileValue(list);

        findInterQuartileRange(list);
      sevenValueArray[1]=  findLowerAdjacentValue(list);
        sevenValueArray[5]=  findUpperAdjacentValue(list);
        return sevenValueArray;

    }
    public double  findMinimumValue(List<Double> list){

   return    list.get(0);
    } public double  findFirstQuartileValue(List<Double> list){
        String  className = this.getClass().getSimpleName();

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
        return  list.get(firstQuartile);

    } public double  findMedianValue(List<Double> list){
        String  className = this.getClass().getSimpleName();

        double median,median1,median2;
        if(sizeA%2==1){
            median = list.get(sizeA/2);
        }
        else{
            median1  = list.get(sizeA/2);
            median2 =  list.get((sizeA-1)/2);

            median = (median1 + median2)/2;
        }
return  median;
    }
    public double  findThirdQuartileValue(List<Double> list){
        String  className = this.getClass().getSimpleName();

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
        return  list.get(thirdQuartile);

    } public double  findMaximumValue(List<Double> list){
        String  className = this.getClass().getSimpleName();
      return list.get(sizeA-1);
    }
    public void findInterQuartileRange(List<Double> list){

        String  className = this.getClass().getSimpleName();
                interQuartileRange = list.get(thirdQuartile) -  list.get(firstQuartile) ;
    }
    public double findLowerAdjacentValue(List<Double> list){
        String  className = this.getClass().getSimpleName();

        double lowerAdjacentValue = firstQuartile - (1.5 * interQuartileRange);
  return lowerAdjacentValue;
    }
    public double findUpperAdjacentValue(List<Double> list){
        String  className = this.getClass().getSimpleName();

        double upperAdjacentValue = thirdQuartile + (1.5 * interQuartileRange);
return upperAdjacentValue;
    }
}
