package book.dao;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import book.BookDto;

public class SearchBooks {
    DBConnector dbConnector=new DBConnector();
    Statement st=null;
    ResultSet rs=null;

    public ArrayList <BookDto> readBook(){
        ArrayList<BookDto> arr = new ArrayList<>();
        System.out.println(arr);
        try {

            Connection con=DBConnector.getConnection();
            st=con.createStatement();
            rs=st.executeQuery("select Book_Title,Book_Author,Book_Birth from bookinfo;");
            while(rs.next()){
                arr.add((new book.BookDto(rs.getString(1), rs.getString(2),
                        rs.getString(3))));
            }
        }
        catch (SQLException throwables) {
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
            Connection con=DBConnector.getConnection();
            st = con.createStatement();
            rs=st.executeQuery("select Book_Title,Book_Author,Book_Birth from bookinfo where " +
                    "Book_Title like '%" + content+  "%' or " +
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
