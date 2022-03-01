import javax.swing.*;
import java.awt.Container;

public class MainGui extends JFrame {
    private static final long serialVersionUID = -711163588504124217L;

    public MainGui(){
        super("도서대출프로그램");
        setBounds(100 , 100 , 300 , 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        JPanel pane = new JPanel();

        //도서 추가기능
        JLabel labelTitle = new JLabel("제목 : ");
        JTextField textTitle =new JTextField(20);
        JLabel labelName = new JLabel("저자 : ");
        JTextField textName =new JTextField(20);
        JLabel labelBirth = new JLabel("출판일 : ");
        JTextField textBirth =new JTextField(20);
        JButton buttonInsert = new JButton("도서추가");

        //도서 목록조회
        JButton buttonInquire = new JButton("도서전체목록조회");

        //도서찾기
        JLabel labelPeriod = new JLabel("제목 or 저자 : ");
        JButton buttonFind = new JButton("도서찾기");
        JTextField textPeriod = new JTextField(10);

        buttonInsert.setMnemonic('S');

        //도서 추가
        pane.add(labelTitle);
        pane.add(textTitle);
        pane.add(labelName);
        pane.add(textName);
        pane.add(labelBirth);
        pane.add(textBirth);
        pane.add(buttonInsert);
        //도서 목록조회
        pane.add(buttonInquire);
        pane.add(labelPeriod);
        pane.add(textPeriod);

        //도서 찾기
        pane.add(buttonFind);
        contentPane.add(pane);

        setVisible(true);

    }
}
