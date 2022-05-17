public class Book {
    private String bookName;
    private int bookId;
    private String bookAut;
    private String bookNum;
    public Book(){

    }

    public Book(String bookName, int bookId, String bookAut, String bookNum) {
        super();
        this.bookName = bookName;
        this.bookId = bookId;
        this.bookAut = bookAut;
        this.bookNum = bookNum;
    }

    public String getBookName() {
        return bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookAut() {
        return bookAut;
    }

    public String getBookNum() {
        return bookNum;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookAut(String bookAut) {
        this.bookAut = bookAut;
    }

    public void setBookNum(String bookNum) {
        this.bookNum = bookNum;
    }
}