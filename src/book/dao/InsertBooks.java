package book.dao;

import book.BookDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertBooks {
    DBConnector dbConnector=new DBConnector();
    Statement st=null;
    public void InsertBooks(BookDto bookDto){
        try {
            Connection con=DBConnector.getConnection();
            st=con.createStatement();
            int stmt=st.executeUpdate("insert into bookinfo(Book_Title,Book_Author, Book_Birth) " +
                    "values('"+bookDto.Book_Title+"', '"+ bookDto.Book_Author+"',' "+bookDto.Book_Birth+"');");
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

}
