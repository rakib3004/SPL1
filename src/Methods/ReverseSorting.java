package Methods;

import FilePackage.DateTimeWriter;
import ObjectOriented.BookData;
import ObjectOriented.GenericAlgo;
import ObjectOriented.PriorityData;

public class ReverseSorting {

    int iterator,jterator;

    GenericAlgo genericAlgo[] = new GenericAlgo[1050];

    public PriorityData[] reverseSortingMLRmethods(PriorityData[] priorityData, int numberOfBooks){
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        PriorityData temporaryPriority;
        for(iterator = 0; iterator <numberOfBooks; iterator++){
            for(jterator= iterator+1;jterator<numberOfBooks;jterator++){
                if(priorityData[iterator].getMLRweight()>priorityData[jterator].getMLRweight()){
                    temporaryPriority = priorityData[jterator];
                    priorityData[jterator] = priorityData[iterator];
                    priorityData[iterator] = temporaryPriority;
                }
            }
        }
        return priorityData;
    }
    public PriorityData[] reverseSortingAHPmethods(PriorityData[] priorityData, int numberOfBooks){
        PriorityData temporaryPriority;
        for(iterator = 0; iterator <numberOfBooks; iterator++){
            for(jterator= iterator+1;jterator<numberOfBooks;jterator++){
                if(priorityData[iterator].getAHPweight()>priorityData[jterator].getAHPweight()){
                    temporaryPriority = priorityData[jterator];
                    priorityData[jterator] = priorityData[iterator];
                    priorityData[iterator] = temporaryPriority;
                }
            }
        }
        return priorityData;
    }
    public PriorityData[] reverseSortingPRAmethods(PriorityData[] priorityData, int numberOfBooks){
        PriorityData temporaryPriority;
        for(iterator = 0; iterator <numberOfBooks; iterator++){
            for(jterator= iterator+1;jterator<numberOfBooks;jterator++){
                if(priorityData[iterator].getPRAweight()>priorityData[jterator].getPRAweight()){
                    temporaryPriority = priorityData[jterator];
                    priorityData[jterator] = priorityData[iterator];
                    priorityData[iterator] = temporaryPriority;
                }
            }
        }
        return priorityData;
    }
    public GenericAlgo[] sortingMLRmethods(PriorityData[] priorityData, int numberOfBooks){

        for(iterator = 0; iterator <numberOfBooks; iterator++){
            genericAlgo[iterator] = new GenericAlgo(priorityData[iterator].getMLRweight(), iterator);
        }
        double temporary;
        int temp;
        for( iterator=0;iterator<numberOfBooks;iterator++){
            for(int jterator=iterator+1;jterator<numberOfBooks;jterator++){
                if(genericAlgo[iterator].getWeight()<genericAlgo[jterator].getWeight()){
                    temporary= genericAlgo[iterator].getWeight();
                    genericAlgo[iterator].setWeight(genericAlgo[jterator].getWeight());
                    genericAlgo[jterator].setWeight(temporary);
                    temp = genericAlgo[iterator].getIndex();
                    genericAlgo[iterator].setIndex(genericAlgo[jterator].getIndex());
                    genericAlgo[jterator].setIndex(temp);
                }
            }
        }
        return genericAlgo;
    }
    public GenericAlgo[] sortingAHPmethods(PriorityData[] priorityData, int numberOfBooks){
        GenericAlgo genericAlgo[] = new GenericAlgo[632];
        for(iterator = 0; iterator <numberOfBooks; iterator++){
            genericAlgo[iterator] = new GenericAlgo(priorityData[iterator].getAHPweight(), iterator);
        }
        double temporary;
        int temp;
        for( iterator=0;iterator<numberOfBooks;iterator++){
            for(int jterator=iterator+1;jterator<numberOfBooks;jterator++){
                if(genericAlgo[iterator].getWeight()<genericAlgo[jterator].getWeight()){
                    temporary= genericAlgo[iterator].getWeight();
                    genericAlgo[iterator].setWeight(genericAlgo[jterator].getWeight());
                    genericAlgo[jterator].setWeight(temporary);
                    temp = genericAlgo[iterator].getIndex();
                    genericAlgo[iterator].setIndex(genericAlgo[jterator].getIndex());
                    genericAlgo[jterator].setIndex(temp);
                }
            }
        }
        return genericAlgo;
    }
    public GenericAlgo[] sortingPRAmethods(PriorityData[] priorityData, int numberOfBooks){

        GenericAlgo genericAlgo[] = new GenericAlgo[632];

        for(iterator = 0; iterator <numberOfBooks; iterator++){
            genericAlgo[iterator] = new GenericAlgo(priorityData[iterator].getPRAweight(), iterator);
        }
        double temporary;
        int temp;
        for( iterator=0;iterator<numberOfBooks;iterator++){
            for(int jterator=iterator+1;jterator<numberOfBooks;jterator++){
                if(genericAlgo[iterator].getWeight()<genericAlgo[jterator].getWeight()){
                    temporary= genericAlgo[iterator].getWeight();
                    genericAlgo[iterator].setWeight(genericAlgo[jterator].getWeight());
                    genericAlgo[jterator].setWeight(temporary);
                    temp = genericAlgo[iterator].getIndex();
                    genericAlgo[iterator].setIndex(genericAlgo[jterator].getIndex());
                    genericAlgo[jterator].setIndex(temp);
                }
            }
        }
        return genericAlgo;
    }
}