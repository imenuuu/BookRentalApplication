
import java.sql.*;
import java.util.ArrayList;

public class CRUDController {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;

    public CRUDController(){
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bookrental","root","gus990413");
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

    }
    public void insertBook(BookDto bookDto){
        try {
            st=con.createStatement();
            int stmt=st.executeUpdate("insert into bookinfo(book_title, " +
                    "book_author, book_birth) values('"+bookDto.Book_Title+"', '"+
                    bookDto.Book_Author+"',' "+bookDto.Book_Birth+"');");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally{
            try {
                st.close();
            }
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }


    }
    public ArrayList<BookDto> readBook(){
        ArrayList<BookDto> arr = new ArrayList<>();
        System.out.println(arr);
        try {
            st=con.createStatement();
            rs=st.executeQuery("select Book_Title,Book_Author,Book_Birth " +
                    "from bookinfo;");
            while(rs.next()){
                arr.add(new BookDto(rs.getString(1),
                        rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally{
            try {
                st.close();
            }
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return arr;
    }

    public ArrayList<BookDto> searchBook(String content) {
        ArrayList<BookDto> arr = new ArrayList<>();
        System.out.println(arr);
        try {
            st = con.createStatement();
            rs=st.executeQuery("select Book_Title,Book_Author,Book_Birth " +
                    "from bookinfo where Book_Title like '%" + content+  "%' or " +
                    "Book_Author like '%" + content+  "%';");
            while(rs.next()){
                arr.add(new BookDto(rs.getString(1),rs.getString(2),
                        rs.getString(3)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally{
            try {
                st.close();
            }
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return arr;
    }

}
