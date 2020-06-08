package SimpleRegression;

import FilePackage.DateTimeWriter;
import ObjectOriented.PriorityData;

public class LinearRegression {

    int iterator;
    double y_mean = 0;
    double x_mean = 0;
   //  = new double[1050];
    double reg_y_value[] = new double[1050];
  //  = new double[1050];
    double alpha_value = 0;
    double beta_value = 0;
    int length;
    String string;
public  double [] linearRegressionMethods(double x_value[], double y_value[], int numberOfBooks){
    String  className = this.getClass().getSimpleName();
    DateTimeWriter dateTimeWriter =  new DateTimeWriter();
    dateTimeWriter.dateTimeWriterMethods(className);

    for (iterator = 0; iterator < numberOfBooks; iterator++) {
        x_mean = x_mean + x_value[iterator];
        y_mean = y_mean + y_value[iterator];
    }

    x_mean = x_mean / numberOfBooks;
    y_mean = y_mean / numberOfBooks;


    for (iterator = 0; iterator < numberOfBooks; iterator++) {
        x_value[iterator] = x_value[iterator] - x_mean;
        y_value[iterator] = y_value[iterator] - y_mean;
        alpha_value = alpha_value + (x_value[iterator] * y_value[iterator]);
        beta_value = beta_value + (x_value[iterator] * x_value[iterator]);

    }
    double metaValue = alpha_value / beta_value;
    double betaValue = y_mean - (metaValue * x_mean);
    for (iterator = 0; iterator < numberOfBooks; iterator++) {

        reg_y_value[iterator] = betaValue + metaValue * x_value[iterator];
    }
return reg_y_value;
}


}
