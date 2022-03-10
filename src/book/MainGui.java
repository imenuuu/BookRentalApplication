package book;

import book.dao.InsertBooks;
import book.dao.SearchBooks;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Vector;

public class MainGui {
    JFrame jframe = new JFrame();
    JPanel bookPage = new JPanel();
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


    JTable table;
    DefaultTableModel defaultTableModel;
    JScrollPane scrolledTable;


    MainGui() {
        GUI_init();

    }

    public void GUI_init() {
        jframe.setTitle("도서관리프로그램");
        jframe.setBounds(50, 50, 780, 450);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        bookPage.setLayout(null);
        jframe.add(bookPage);

        tTitle.setBounds(60, 25, 200, 25);
        bookPage.add(tTitle);
        Title.setBounds(10, 20, 70, 30);
        bookPage.add(Title);
        tName.setBounds(60, 65, 200, 25);
        bookPage.add(tName);
        Name.setBounds(10, 60, 70, 30);
        bookPage.add(Name);
        tBirth.setBounds(60, 105, 200, 25);
        bookPage.add(tBirth);
        Birth.setBounds(10, 100, 70, 30);
        bookPage.add(Birth);


        //도서추가 버튼
        bookPage.add(btnInsert = new JButton("도서추가"));
        btnInsert.setBounds(160, 140, 100, 30);
        //전체출력 버튼
        bookPage.add( btnRead = new JButton("전체출력"));
        btnRead.setBounds(660, 20, 100, 30);
        //검색 버튼
        bookPage.add(btnSearch = new JButton("제목 or 저자 검색"));
        tSearch.setBounds(370, 25, 120, 25);

        bookPage.add(tSearch);
        Search.setBounds(300, 20, 70, 30);
        bookPage.add(Search);
        btnSearch.setBounds(500, 20, 150, 30);

        table =new JTable();
        table.setBounds(300, 60, 460, 400);
        bookPage.add(table);


        InsertBooks insertBooks=new InsertBooks();
        btnInsert.addActionListener(e -> {
            String Book_Title=tTitle.getText();
            String Book_Author=tName.getText();
            String Book_Birth=tBirth.getText();
            insertBooks.InsertBooks(new BookDto(Book_Title,Book_Author,Book_Birth));
            JOptionPane.showConfirmDialog(null,"추가완료");
            tTitle.setText("");
            tName.setText("");
            tBirth.setText("");
        });


        //도서 전체목록조회

        SearchBooks searchdao=new SearchBooks();

        btnRead.addActionListener(e -> {
            tTitle.setText("");
            tName.setText("");
            tBirth.setText("");
            table.setVisible(false);

            ArrayList<BookDto> arr=searchdao.readBook();
            Vector<String> content = new Vector<>();

            content.addElement("책 제목");
            content.addElement("책 저자");
            content.addElement("출판일");
            arr=searchdao.readBook();

            defaultTableModel = new DefaultTableModel(content, 0);

            for (BookDto bookDto : arr) {
                Vector<Object> list = new Vector<>();
                list.addElement(bookDto.getBook_Title());
                list.addElement(bookDto.getBook_Author());
                list.addElement(bookDto.getBook_Birth());
                defaultTableModel.addRow(list);
            }
            table.setVisible(true);
            table = new JTable(defaultTableModel);
            table.setBounds(300, 60, 460, 400);
            bookPage.add(table);

            tTitle.setText("");
            tName.setText("");
            tBirth.setText("");
            tSearch.setText("");

        });


        //도서 검색
        btnSearch.addActionListener(e -> {


                tprint.setVisible(false);
                table.setVisible(false);

                String substance = tSearch.getText();

                ArrayList<BookDto> arr;
                arr = searchdao.searchBook(substance);

                Vector<String> content = new Vector<>();

                content.addElement("책 제목");
                content.addElement("책 저자");
                content.addElement("출판일");
                defaultTableModel = new DefaultTableModel(content, 0);

                for (BookDto bookDto : arr) {
                    Vector<Object> list= new Vector<>();
                    list.addElement(bookDto.getBook_Title());
                    list.addElement(bookDto.getBook_Author());
                    list.addElement(bookDto.getBook_Birth());
                    defaultTableModel.addRow(list);
                }
                table = new JTable(defaultTableModel);
                table.setBounds(300, 60, 460, 400);
                table.setVisible(true);
                bookPage.add(table);
                tTitle.setText("");
                tName.setText("");
                tBirth.setText("");
                tSearch.setText("");

            });

    }
        }