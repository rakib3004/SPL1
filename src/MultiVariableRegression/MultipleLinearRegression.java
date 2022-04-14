package MultiVariableRegression;

import FilePackage.DateTimeWriter;
import ObjectOriented.PriorityData;

public class MultipleLinearRegression {

  /*
   * d1 = a1X + b1Y + c1Z
   * d2 = a2X + b2Y + c2Z
   * d3 = a3X + b3Y + c3Z
   */
  double a1, a2, a3;
  double b1, b2, b3;
  double c1, c2, c3;
  double d1, d2, d3;
  int iterator;
  double[] a_array = new double[3];
  double[] b_array = new double[3];
  double[] c_array = new double[3];
  double[] d_array = new double[3];
  double y_mean;
  Matrix matrix = new Matrix();

  public PriorityData[] multipleLinearRegressionMethods(PriorityData[] priorityData, int numberOfBooks) {
    String className = this.getClass().getSimpleName();
    DateTimeWriter dateTimeWriter = new DateTimeWriter();
    dateTimeWriter.dateTimeWriterMethods(className);

    for (iterator = 0; iterator < numberOfBooks; iterator++) {
      y_mean = y_mean + priorityData[iterator].bookPriority;
    }
    y_mean = y_mean / numberOfBooks;
    for (iterator = 0; iterator < numberOfBooks; iterator++) {
      d1 = d1 + (priorityData[iterator].bookPriority * priorityData[iterator].borrowPriority);
    }
    for (iterator = 0; iterator < numberOfBooks; iterator++) {
      d2 = d2 + (priorityData[iterator].bookPriority * priorityData[iterator].timePriority);
    }
    for (iterator = 0; iterator < numberOfBooks; iterator++) {
      d3 = d3 + (priorityData[iterator].bookPriority * priorityData[iterator].pricePriority);
    }
    for (iterator = 0; iterator < numberOfBooks; iterator++) {
      a1 = a1 + (priorityData[iterator].borrowPriority * priorityData[iterator].borrowPriority);
    }
    for (iterator = 0; iterator < numberOfBooks; iterator++) {
      b1 = b1 + (priorityData[iterator].timePriority * priorityData[iterator].borrowPriority);
    }
    for (iterator = 0; iterator < numberOfBooks; iterator++) {
      c1 = c1 + (priorityData[iterator].pricePriority * priorityData[iterator].borrowPriority);
    }

    for (iterator = 0; iterator < numberOfBooks; iterator++) {
      a2 = a2 + (priorityData[iterator].borrowPriority * priorityData[iterator].timePriority);
    }
    for (iterator = 0; iterator < numberOfBooks; iterator++) {
      b2 = b2 + (priorityData[iterator].timePriority * priorityData[iterator].timePriority);
    }
    for (iterator = 0; iterator < numberOfBooks; iterator++) {
      c2 = c2 + (priorityData[iterator].pricePriority * priorityData[iterator].timePriority);
    }
    for (iterator = 0; iterator < numberOfBooks; iterator++) {
      a3 = a3 + (priorityData[iterator].borrowPriority * priorityData[iterator].pricePriority);
    }
    for (iterator = 0; iterator < numberOfBooks; iterator++) {
      b3 = b3 + (priorityData[iterator].timePriority * priorityData[iterator].pricePriority);
    }
    for (iterator = 0; iterator < numberOfBooks; iterator++) {
      c3 = c3 + (priorityData[iterator].pricePriority * priorityData[iterator].pricePriority);
    }

    a_array[0] = a1;
    a_array[1] = a2;
    a_array[2] = a3;

    b_array[0] = b1;
    b_array[1] = b2;
    b_array[2] = b3;

    c_array[0] = c1;
    c_array[1] = c2;
    c_array[2] = c3;

    d_array[0] = d1;
    d_array[1] = d2;
    d_array[2] = d3;

    priorityData = matrix.evaluateMatrix(a_array, b_array, c_array, d_array, priorityData, numberOfBooks, y_mean);
    // ,a2,a3,b1,b2,b3,c1,c2,c3,d1,d2,d3;
    return priorityData;
  }
}