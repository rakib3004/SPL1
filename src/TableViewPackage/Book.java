package TableViewPackage;

import javafx.beans.property.SimpleStringProperty;

public class Book {
    private SimpleStringProperty bookName;
    private SimpleStringProperty writerName;
    private SimpleStringProperty bookId;
    private SimpleStringProperty borrowCount;
    private SimpleStringProperty price;
    private SimpleStringProperty bookWeight;
    private SimpleStringProperty typeName;

    public Book(SimpleStringProperty bookName,
            SimpleStringProperty writerName,
            SimpleStringProperty bookId,
            SimpleStringProperty typeName) {
        this.bookName = bookName;
        this.writerName = writerName;
        this.bookId = bookId;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName.get();
    }

    public SimpleStringProperty typeNameProperty() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName.set(typeName);
    }

    public Book(SimpleStringProperty bookName,
            SimpleStringProperty writerName,
            SimpleStringProperty bookId,
            SimpleStringProperty typeName,
            SimpleStringProperty borrowCount,
            SimpleStringProperty price,
            SimpleStringProperty bookWeight) {
        this.bookName = bookName;
        this.writerName = writerName;
        this.bookId = bookId;
        this.typeName = typeName;
        this.borrowCount = borrowCount;
        this.price = price;
        this.bookWeight = bookWeight;
    }

    public Book(SimpleStringProperty bookName, SimpleStringProperty writerName,
            SimpleStringProperty bookId) {
        this.bookName = bookName;
        this.writerName = writerName;
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId.get();
    }

    public SimpleStringProperty bookIdProperty() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId.set(bookId);
    }

    public String getBookWeight() {
        return bookWeight.get();
    }

    public SimpleStringProperty bookWeightProperty() {
        return bookWeight;
    }

    public void setBookWeight(String bookWeight) {
        this.bookWeight.set(bookWeight);
    }

    public Book(SimpleStringProperty bookName,
            SimpleStringProperty writerName,
            SimpleStringProperty bookId,
            SimpleStringProperty borrowCount,
            SimpleStringProperty price) {
        this.bookName = bookName;
        this.writerName = writerName;
        this.bookId = bookId;
        this.borrowCount = borrowCount;
        this.price = price;
    }

    public SimpleStringProperty borrowCountProperty() {
        return borrowCount;
    }

    public void setBorrowCount(String borrowCount) {
        this.borrowCount.set(borrowCount);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public Book(String bookName, String writerName, String bookId, String borrowCount, String bookPrice,
            double mlRweight) {
    }

    public Book(String s1, String s2) {

        bookName = new SimpleStringProperty(s1);
        writerName = new SimpleStringProperty(s2);
    }

    public Book(String s1, String s2, String s3, String s4, String s5, String s6, String s7) {

        bookName = new SimpleStringProperty(s1);
        writerName = new SimpleStringProperty(s2);
        bookId = new SimpleStringProperty(s3);
        typeName = new SimpleStringProperty(s4);
        borrowCount = new SimpleStringProperty(s5);
        price = new SimpleStringProperty(s6);
        bookWeight = new SimpleStringProperty(s7);
    }

    public Book(String s1, String s2, String s3) {
        bookName = new SimpleStringProperty(s1);
        writerName = new SimpleStringProperty(s2);
        bookId = new SimpleStringProperty(s3);
    }

    public Book(String s1, String s2, String s3, String s4) {

        bookName = new SimpleStringProperty(s1);
        writerName = new SimpleStringProperty(s2);
        bookId = new SimpleStringProperty(s3);
        typeName = new SimpleStringProperty(s4);
    }

    public String getBookName() {
        return bookName.get();
    }

    public void setBookName(String s) {
        bookName.set(s);
    }

    public String getWriterName() {
        return writerName.get();
    }

    public void setWriterName(String s) {
        writerName.set(s);
    }

    @Override
    public String toString() {
        return (bookName.get() + ", by " + writerName.get());
    }
}
