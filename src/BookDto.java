public class BookDto {

    String Book_Title;
    String Book_Name;
    String Book_Birth;

    public BookDto(String Book_Title, String Book_Name, String Book_Birth){
        this.Book_Title=Book_Title;
        this.Book_Name=Book_Name;
        this.Book_Birth=Book_Birth;
    }

    public String getBook_Title() {
        return Book_Title;
    }

    public String getBook_Name() {
        return Book_Name;
    }

    public String getBook_Birth() {
        return Book_Birth;
    }

}