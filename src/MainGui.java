import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainGui {
    JFrame jframe = new JFrame();
    JPanel jpanel = new JPanel();
    //텍스트

    JLabel ㅣTitle = new JLabel("제목 : ");
    JTextField tTitle = new JTextField(); //제목

    JLabel ㅣName = new JLabel("저자 : ");
    JTextField tName = new JTextField(); //저자

    JLabel ㅣBirth = new JLabel("출판일 : ");

    JTextField tBirth = new JTextField(); //출판일
    JLabel ㅣSearch = new JLabel("제목,저자 : ");
    JTextField tSearch = new JTextField(); //제목,저자 검색

    JTextArea tprint = new JTextArea();
    JButton btnInsert,btnRead,btnSearch;




    MainGui() {
        GUI_init();
    }

    public void GUI_init() {
        jframe.setTitle("도서관리프로그램");
        jframe.setBounds(50, 50, 500, 450);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jpanel.setLayout(null);
        jframe.add(jpanel);

        tTitle.setBounds(50, 25, 70, 25);
        jpanel.add(tTitle);
        ㅣTitle.setBounds(10, 21, 70, 30);
        jpanel.add(ㅣTitle);

        tName.setBounds(160, 25, 70, 25);
        jpanel.add(tName);
        ㅣName.setBounds(125, 21, 70, 30);
        jpanel.add(ㅣName);

        tBirth.setBounds(285, 25, 80, 25);
        jpanel.add(tBirth);
        ㅣBirth.setBounds(240, 21, 70, 30);
        jpanel.add(ㅣBirth);

        tSearch.setBounds(190, 65, 120, 25);
        jpanel.add(tSearch);
        ㅣSearch.setBounds(125, 61, 70, 30);
        jpanel.add(ㅣSearch);

        //도서추가 버튼
        jpanel.add(btnInsert = new JButton("도서추가"));
        btnInsert.setBounds(370, 20, 100, 30);

        //전체출력 버튼
        jpanel.add(btnRead = new JButton("전체출력"));
        btnRead.setBounds(10, 60, 100, 30);


        //검색 버튼
        jpanel.add(btnSearch = new JButton("제목 or 저자 검색"));
        btnSearch.setBounds(320, 60, 150, 30);

        //출력패널
        JScrollPane jsp = new JScrollPane(tprint);
        jsp.setBounds(23, 145, 420, 250);
        jpanel.add(jsp);

        CRUDController dao = new CRUDController();
        //도서추가
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tprint.setText("");

                String Book_Title=tTitle.getText();
                String Book_Name=tName.getText();
                String Book_Birth=tBirth.getText();
                dao.insertBook(new BookDto(Book_Title,Book_Name,Book_Birth));

                tprint.append("도서 입력완료 \n");

                tTitle.setText("");
                tName.setText("");
                tBirth.setText("");
                tprint.setText("");
            }
        });

        //도서 전체목록조회

       btnRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                tprint.setText("");
                ArrayList<BookDto> arr = new ArrayList<BookDto>();
                arr = dao.readBook();
                tprint.append(" \n");
                tprint.append("\t" + "책 제목 " + "\t" + "  저자" + "\t" + "         출판일\n");
                tprint.append("\t" + "------------------------------------------------------------\n");

                for (BookDto model : arr) {
                    tprint.append("\t" + model.getBook_Title() + " \t " + model.getBook_Name() + " \t " + model.getBook_Birth()
                            + "\n");
                }
            }
        });

       //도서 검색
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                tprint.setText("");
                String substance = tSearch.getText();

                ArrayList<BookDto> arr = new ArrayList<BookDto>();
                arr = dao.searchBook(substance);
                tprint.append(" \n");
                tprint.append("\t" + "책 제목 " + "\t" + " 저자" + "\t" +  "       출판일\n");
                tprint.append("\t" + "------------------------------------------------------------\n");

                for (BookDto bookDto : arr) {
                    tprint.append("\t" + bookDto.getBook_Title() + " \t " + bookDto.getBook_Name() + " \t " + bookDto.getBook_Birth()
                            + "\n");
                }
                tTitle.setText("");
                tName.setText("");
                tBirth.setText("");
                tSearch.setText("");
            }
        });

    }
}