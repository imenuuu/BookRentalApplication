package book;

import book.dao.InsertBooks;
import book.dao.SearchBooks;

import javax.swing.*;
import java.util.ArrayList;

public class MainGui {
    JFrame jframe = new JFrame();
    JPanel jpanel = new JPanel();
    //텍스트

    JLabel Title = new JLabel("제목 : ");
    JTextField tTitle = new JTextField(); //제목

    JLabel Name = new JLabel("저자 : ");
    JTextField tName = new JTextField(); //저자

    JLabel Birth = new JLabel("출판일 : ");

    JTextField tBirth = new JTextField(); //출판일
    JLabel Search = new JLabel("제목,저자 : ");
    JTextField tSearch = new JTextField(); //제목,저자 검색

    JTextArea tprint = new JTextArea();
    JButton btnInsert,btnRead,btnSearch;




    MainGui() {
        GUI_init();

    }

    public void GUI_init() {
        jframe.setTitle("도서관리프로그램");
        jframe.setBounds(50, 50, 780, 450);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jpanel.setLayout(null);
        jframe.add(jpanel);

        tTitle.setBounds(60, 25, 200, 25);
        jpanel.add(tTitle);
        Title.setBounds(10, 20, 70, 30);
        jpanel.add(Title);

        tName.setBounds(60, 65, 200, 25);
        jpanel.add(tName);
        Name.setBounds(10, 60, 70, 30);
        jpanel.add(Name);

        tBirth.setBounds(60, 105, 200, 25);
        jpanel.add(tBirth);
        Birth.setBounds(10, 100, 70, 30);
        jpanel.add(Birth);

        //도서추가 버튼
        jpanel.add(btnInsert = new JButton("도서추가"));
        btnInsert.setBounds(160, 140, 100, 30);
        //전체출력 버튼
        jpanel.add( btnRead = new JButton("전체출력"));
        btnRead.setBounds(660, 20, 100, 30);
        //검색 버튼
        jpanel.add(btnSearch = new JButton("제목 or 저자 검색"));
        tSearch.setBounds(370, 25, 120, 25);
        jpanel.add(tSearch);
        Search.setBounds(300, 20, 70, 30);
        jpanel.add(Search);
        btnSearch.setBounds(500, 20, 150, 30);



        //출력패널
        JScrollPane jsp = new JScrollPane(tprint);
        jsp.setBounds(300, 60, 460, 400);
        jpanel.add(jsp);

        InsertBooks insertBooks=new InsertBooks();
        btnInsert.addActionListener(e -> {
            tprint.setText("");

            String Book_Title=tTitle.getText();
            String Book_Author=tName.getText();
            String Book_Birth=tBirth.getText();
            insertBooks.InsertBooks(new BookDto(Book_Title,Book_Author,Book_Birth));

            tTitle.setText("");
            tName.setText("");
            tBirth.setText("");
            tprint.setText("");
            tprint.append("도서 추가완료 \n");
        });

        //도서 전체목록조회

        SearchBooks searchdao=new SearchBooks();

        btnRead.addActionListener(arg0 -> {
            tprint.setText("");
            ArrayList<book.BookDto> arr;
            arr = searchdao.readBook();
            tprint.append(" \n");
            tprint.append("\t" + "책 제목 " + "\t" + "  저자" + "\t" + "         출판일\n");
            tprint.append("\t" + "------------------------------------------------------------\n");

            for (book.BookDto model : arr) {
                tprint.append("\t" + model.getBook_Title() + " \t " + model.getBook_Author() + " \t " + model.getBook_Birth()
                        + "\n");
            }
        });

        //도서 검색
        btnSearch.addActionListener(arg0 -> {
            tprint.setText("");
            String substance = tSearch.getText();
            ArrayList<BookDto> arr;
            arr = searchdao.searchBook(substance);
            tprint.append(" \n");
            tprint.append("\t" + "책 제목 " + "\t" + " 저자" + "\t" +  "       출판일\n");
            tprint.append("\t" + "------------------------------------------------------------\n");
            for (BookDto bookDto : arr) {
                tprint.append("\t" + bookDto.getBook_Title() + " \t " + bookDto.getBook_Author() + " \t " + bookDto.getBook_Birth()
                        + "\n");
            }
            tTitle.setText("");
            tName.setText("");
            tBirth.setText("");
            tSearch.setText("");
        });

    }
}