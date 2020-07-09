package JavFX;

import FilePackage.DateTimeWriter;

import java.security.PublicKey;

public class FxDatabase {
        String   index;
    String bookName;
    String writerName;
    String bookId;
    String borrowCount;
    String priceCount;
    public FxDatabase(String  index, String bookName, String writerName, String bookId, String borrowCount, String priceCount) {
        this.bookName = bookName;
        this.writerName = writerName;
        this.bookId = bookId;
        this.borrowCount = borrowCount;
        this.priceCount = priceCount;
    }
    public FxDatabase(String bookName, String writerName, String bookId, String borrowCount, String priceCount) {
        this.bookName = bookName;
        this.writerName = writerName;
        this.bookId = bookId;
        this.borrowCount = borrowCount;
        this.priceCount = priceCount;
    }
}
