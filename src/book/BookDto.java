package book;

public class BookDto {
    public String Book_Title;
    public String Book_Author;
    public String Book_Birth;

    public BookDto(String Book_Title, String Book_Author, String Book_Birth){
        this.Book_Title=Book_Title;
        this.Book_Author=Book_Author;
        this.Book_Birth=Book_Birth;
    }


    public String getBook_Title() {
        return Book_Title;
    }

    public String getBook_Author() {
        return Book_Author;
    }

    public String getBook_Birth() {
        return Book_Birth;
    }

}