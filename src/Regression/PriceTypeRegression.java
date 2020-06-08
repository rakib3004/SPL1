package Regression;

import FilePackage.DateTimeWriter;
import ObjectOriented.BookData;
import ObjectOriented.GenericAlgo;

public class PriceTypeRegression {

    int iterator;
    double priceMean=0;
    double typeMean=0;
    double bookPrice [] = new double [1050];
    double bookPrice2 [] = new double [1050];
    double typeValue [] =new double[1050];
    double typeValue1 [] =new double[1050];
    double typeValue0 [] =new double[1050];

    int length;
    String string;
    public  void priceTypeRegressionMethods(BookData[] bookData, String[] writerName,
                            String[] borrowCount1, String[] bookPrice1, String[] bookId, int numberOfBooks){

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);


        for(iterator =0; iterator <numberOfBooks; iterator++){
            length = bookId[iterator].length();
            string =bookId[iterator].substring(1,3);
            typeValue[iterator] = Integer.parseInt(string);
            typeValue0[iterator]=typeValue[iterator];
        }

        for(iterator =0; iterator <numberOfBooks; iterator++){
            length = bookPrice1[iterator].length();
            string =bookPrice1[iterator].substring(1,length);
            string=string.replaceAll("[\\t\\n\\r]+","");
            bookPrice[iterator] = Integer.parseInt(string);
        }
        for(iterator =0; iterator <numberOfBooks; iterator++){
            typeMean = typeMean +typeValue[iterator];
            priceMean = priceMean+bookPrice[iterator];
        }

        typeMean = typeMean/numberOfBooks;
        priceMean = priceMean/numberOfBooks;

        double assumpMean1  = 0;
        double assumpMean2  = 0;
        for(iterator =0; iterator <numberOfBooks; iterator++){
            typeValue[iterator] =  typeValue[iterator]  - typeMean;
            bookPrice[iterator]=bookPrice[iterator]-priceMean;
            assumpMean1 = assumpMean1 +( typeValue[iterator]*bookPrice[iterator]);
            assumpMean2 = assumpMean2 + (typeValue[iterator]*typeValue[iterator]);

        }

        double metaValue = assumpMean1/assumpMean2;
        double betaValue = priceMean - (metaValue*typeMean);
        for(iterator =0; iterator <numberOfBooks; iterator++) {

            bookPrice2[iterator] = betaValue + metaValue * typeValue[iterator];
            //     System.out.println(typeValue0[i]+"\t"+typeValue1[i]);
        }
        for(iterator =0; iterator <numberOfBooks; iterator++){

            bookData[iterator].setWeight(bookPrice2[iterator]);
        }
        // SortingTypePrice sortingTypePrice = new SortingTypePrice();
        //sortingTypePrice.algorithm(bookData,numberOfBooks);
        GenericAlgo genericAlgo[] = new GenericAlgo[1050];
        for(iterator = 0; iterator <numberOfBooks; iterator++){
            genericAlgo[iterator] = new GenericAlgo(bookData[iterator].getWeight(), iterator);
        }
        double temporary;
        int temp;
        for(iterator =0; iterator <numberOfBooks; iterator++){
            for(int j=0;j<numberOfBooks;j++){
                if(genericAlgo[iterator].getWeight()>genericAlgo[j].getWeight()){
                    temporary= genericAlgo[iterator].getWeight();
                    genericAlgo[iterator].setWeight(genericAlgo[j].getWeight());
                    genericAlgo[j].setWeight(temporary);
                    temp = genericAlgo[iterator].getIndex();
                    genericAlgo[iterator].setIndex(genericAlgo[j].getIndex());
                    genericAlgo[j].setIndex(temp);
                    bookData[j].setRank(temp,6);

                }
            }
        }
        System.out.println( );
        System.out.println( );
        System.out.println( );
        System.out.println( );
        System.out.println("Optimized View 7 :" );

        for(iterator =190; iterator <numberOfBooks; iterator++){
            System.out.println("Book Name :"+bookData[genericAlgo[iterator].getIndex()].getBookName()+
                    "; Writer Name : "+bookData[genericAlgo[iterator].getIndex()].getWriterName()
                    + "; Weight : "+genericAlgo[iterator].getWeight());
        }


    }

}
