package ObjectOriented;

public class PriorityData {
   public double bookPriority ;
    public  double timePriority;
    public   double borrowPriority ;
    public  double pricePriority;
    public int index;
    public   BookData bookData;
    public double MLRweight;
    public double AHPweight;
    public double PRAweight;
    public double bookPriorityOne ;


    public PriorityData(double bookPriority, double timePriority, double borrowPriority,
                        double pricePriority, int index, BookData bookData, double MLRweight,
                        double AHPweight, double PRAweight) {
        this.bookPriority = bookPriority;
        this.timePriority = timePriority;
        this.borrowPriority = borrowPriority;
        this.pricePriority = pricePriority;
        this.index = index;
        this.bookData = bookData;
        this.MLRweight = MLRweight;
        this.AHPweight = AHPweight;
        this.PRAweight = PRAweight;
    }



    public PriorityData(double bookPriority,
                        double timePriority, double borrowPriority,
                        double pricePriority,int index , BookData
                                bookData,double MLRweight) {
        this.bookPriority = bookPriority;
        this.timePriority = timePriority;
        this.borrowPriority = borrowPriority;
        this.pricePriority = pricePriority;
        this.MLRweight = MLRweight;
        this.bookData = bookData;
        this.index = index;
    }

    public double getTimePriority() {
        return timePriority;
    }

    public void setTimePriority(double timePriority) {
        this.timePriority = timePriority;
    }

    public double getBorrowPriority() {
        return borrowPriority;
    }

    public void setBorrowPriority(double borrowPriority) {
        this.borrowPriority = borrowPriority;
    }

    public double getPricePriority() {
        return pricePriority;
    }

    public void setPricePriority(double pricePriority) {
        this.pricePriority = pricePriority;
    }

    public BookData getBookData() {
        return bookData;
    }

    public void setBookData(BookData bookData) {
        this.bookData = bookData;
    }

    public double getBookPriorityOne() {
        return bookPriorityOne;
    }

    public void setBookPriorityOne(double bookPriorityOne) {
        this.bookPriorityOne = bookPriorityOne;
    }

    public double getMLRweight() {
        return MLRweight;
    }

    public void setMLRweight(double MLRweight) {
        this.MLRweight = MLRweight;
    }


    public PriorityData(double bookPriority , double timePriority,
                        double borrowPriority ,  double pricePriority,
                        int index,BookData bookData){
        this.bookPriority =bookPriority;
        this.timePriority = timePriority;
        this.borrowPriority = borrowPriority;
        this.pricePriority = pricePriority;
        this.index = index;
        this.bookData = bookData;
    }

    public PriorityData(double bookPriorityOne){
        this.bookPriorityOne =bookPriorityOne;
    }
public void setBookPriority(double bookPriority)
{
        this.bookPriority = bookPriority;
}
public double getBookPriority(){
        return  this.bookPriority;
}

public void setIndex(int index){
        this.index = index;
}
public int getIndex(){
    return  this.index;
}

    public double getAHPweight() {
        return AHPweight;
    }

    public void setAHPweight(double AHPweight) {
        this.AHPweight = AHPweight;
    }

    public double getPRAweight() {
        return PRAweight;
    }

    public void setPRAweight(double PRAweight) {
        this.PRAweight = PRAweight;
    }
}
