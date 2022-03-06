public class BookDto {
    int id;
    String Book_Title;
    String Book_Author;
    String Book_Birth;

    public BookDto(String Book_Title, String Book_Author, String Book_Birth){
        this.Book_Title=Book_Title;
        this.Book_Author=Book_Author;
        this.Book_Birth=Book_Birth;
    }


    public int getId() {
        return id;
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