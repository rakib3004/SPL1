package ObjectOriented;

public class AHPcriteriaWeight {


    public double lowPrice;
    public double mediumPrice;
    public double highPrice;

    public double highlyDemand;
    public double highMediumDemand;
    public double lowMediumDemand;
    public double lowlyDemand;

    public double latestBook;
    public double newlyBook;
    public double recentlyOldBook;
    public double oldBook;
    public double oldestBook;

    public double uponnashType;
    public double kobitaType;
    public double scienceFictionType;
    public double kisorUponnashType;
    public double religionType;
    public double othersType;


    public AHPcriteriaWeight() {

    }

    public AHPcriteriaWeight(double uponnashType, double kobitaType,
                             double scienceFictionType, double kisorUponnashType,
                             double religionType, double othersType) {
        this.uponnashType = uponnashType;
        this.kobitaType = kobitaType;
        this.scienceFictionType = scienceFictionType;
        this.kisorUponnashType = kisorUponnashType;
        this.religionType = religionType;
        this.othersType = othersType;
    }


    public AHPcriteriaWeight(double lowPrice, double mediumPrice, double highPrice) {
        this.lowPrice = lowPrice;
        this.mediumPrice = mediumPrice;
        this.highPrice = highPrice;
    }

    public AHPcriteriaWeight(double latestBook, double newlyBook, double recentlyOldBook, double oldBook, double oldestBook) {
        this.latestBook = latestBook;
        this.newlyBook = newlyBook;
        this.recentlyOldBook = recentlyOldBook;
        this.oldBook = oldBook;
        this.oldestBook = oldestBook;
    }

    public AHPcriteriaWeight(double lowlyDemand, double lowMediumDemand, double highMediumDemand, double highlyDemand) {
        this.lowlyDemand = lowlyDemand;
        this.lowMediumDemand = lowMediumDemand;
        this.highMediumDemand = highMediumDemand;
        this.highlyDemand = highlyDemand;
    }




    public AHPcriteriaWeight(double highPrice, double mediumPrice, double lowPrice, double highlyDemand,
                             double highMediumDemand, double lowMediumDemand , double lowlyDemand,
                             double latestBook, double newlyBook, double recentlyOldBook, double oldBook,
                             double oldestBook, double uponnashType, double kobitaType, double scienceFictionType,
                             double religionType, double kisorUponnashType, double othersType) {
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.mediumPrice = mediumPrice;
        this.lowlyDemand = lowlyDemand;
        this.lowMediumDemand = lowMediumDemand;
        this.highMediumDemand = highMediumDemand;
        this.highlyDemand = highlyDemand;
        this.latestBook = latestBook;
        this.newlyBook = newlyBook;
        this.recentlyOldBook = recentlyOldBook;
        this.oldBook = oldBook;
        this.oldestBook = oldestBook;
        this.uponnashType = uponnashType;
        this.kobitaType = kobitaType;
        this.scienceFictionType = scienceFictionType;
        this.religionType = religionType;
        this.kisorUponnashType = kisorUponnashType;
        this.othersType = othersType;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public double getMediumPrice() {
        return mediumPrice;
    }

    public void setMediumPrice(double mediumPrice) {
        this.mediumPrice = mediumPrice;
    }

    public double getLowlyDemand() {
        return lowlyDemand;
    }

    public void setLowlyDemand(double lowlyDemand) {
        this.lowlyDemand = lowlyDemand;
    }

    public double getLowMediumDemand() {
        return lowMediumDemand;
    }

    public void setLowMediumDemand(double lowMediumDemand) {
        this.lowMediumDemand = lowMediumDemand;
    }

    public double getHighMediumDemand() {
        return highMediumDemand;
    }

    public void setHighMediumDemand(double highMediumDemand) {
        this.highMediumDemand = highMediumDemand;
    }

    public double getHighlyDemand() {
        return highlyDemand;
    }

    public void setHighlyDemand(double highlyDemand) {
        this.highlyDemand = highlyDemand;
    }

    public double getLatestBook() {
        return latestBook;
    }

    public void setLatestBook(double latestBook) {
        this.latestBook = latestBook;
    }

    public double getNewlyBook() {
        return newlyBook;
    }

    public void setNewlyBook(double newlyBook) {
        this.newlyBook = newlyBook;
    }

    public double getRecentlyOldBook() {
        return recentlyOldBook;
    }

    public void setRecentlyOldBook(double recentlyOldBook) {
        this.recentlyOldBook = recentlyOldBook;
    }

    public double getOldBook() {
        return oldBook;
    }

    public void setOldBook(double oldBook) {
        this.oldBook = oldBook;
    }

    public double getOldestBook() {
        return oldestBook;
    }

    public void setOldestBook(double oldestBook) {
        this.oldestBook = oldestBook;
    }

    public double getUponnashType() {
        return uponnashType;
    }

    public void setUponnashType(double uponnashType) {
        this.uponnashType = uponnashType;
    }

    public double getKobitaType() {
        return kobitaType;
    }

    public void setKobitaType(double kobitaType) {
        this.kobitaType = kobitaType;
    }

    public double getScienceFictionType() {
        return scienceFictionType;
    }

    public void setScienceFictionType(double scienceFictionType) {
        this.scienceFictionType = scienceFictionType;
    }

    public double getReligionType() {
        return religionType;
    }

    public void setReligionType(double religionType) {
        this.religionType = religionType;
    }

    public double getKisorUponnashType() {
        return kisorUponnashType;
    }

    public void setKisorUponnashType(double kisorUponnashType) {
        this.kisorUponnashType = kisorUponnashType;
    }

    public double getOthersType() {
        return othersType;
    }

    public void setOthersType(double othersType) {
        this.othersType = othersType;
    }


}
