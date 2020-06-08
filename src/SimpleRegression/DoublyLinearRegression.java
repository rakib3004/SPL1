package SimpleRegression;

import FilePackage.DateTimeWriter;
import ObjectOriented.PriorityData;
import SimpleRegression.CalculateDoublyRegression;

public class DoublyLinearRegression {
    int number=632;
    int iterator;
double sumYX2,sumYX3,sumX3square,sumX2square,sumX2X3;
double meanY,meanX2,meanX3;

CalculateDoublyRegression calculateDoublyRegression = new CalculateDoublyRegression();
    public void doublyLinearRegressionMethods(PriorityData[] priorityData, int numberOfBooks){
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        for(iterator =0; iterator <number; iterator++){
meanX2 = meanX2 + priorityData[iterator].borrowPriority;
        }for(iterator =0; iterator <number; iterator++){
meanX3 = meanX3 + priorityData[iterator].timePriority;
        }for(iterator =0; iterator <number; iterator++){
meanY = meanY + priorityData[iterator].bookPriority ;
        }
        meanY = meanY / number;
        meanX2 = meanX2 / number;
        meanX3 = meanX3 / number;

        for(iterator =0; iterator <number; iterator++){
            sumX2square= sumX2square + Math.pow(priorityData[iterator].borrowPriority,2);
        }

        for(iterator =0; iterator <number; iterator++) {
            sumX3square= sumX3square + Math.pow(priorityData[iterator].timePriority,2);

        }
 for(iterator =0; iterator <number; iterator++) {
     sumYX2 = sumYX2 + (priorityData[iterator].bookPriority*priorityData[iterator].borrowPriority);

        }
 for(iterator =0; iterator <number; iterator++) {
     sumYX3 = sumYX3 + (priorityData[iterator].bookPriority*priorityData[iterator].timePriority);

        }
 for(iterator =0; iterator <number; iterator++) {
     sumX2X3 = sumX2X3 + (priorityData[iterator].borrowPriority*priorityData[iterator].timePriority);
        }
 double beta1,beta2,beta3;

 beta2 = ((sumYX2*sumX3square)-(sumYX3*sumX2X3))/((sumX2square*sumX3square)-(sumX2X3*sumX2X3));
 beta3 = ((sumYX3*sumX2square)-(sumYX2*sumX2X3))/((sumX2square*sumX3square)-(sumX2X3*sumX2X3));
 //beta2 = Math.pow(beta2,-1);
 //beta3 = Math.pow(beta3,-1);

 beta1 = meanY - (beta2*meanX2) - (beta3*meanX3);

 calculateDoublyRegression.calculateDoublyRegressionMethod(beta1,beta2,beta3,priorityData);
        }
}
