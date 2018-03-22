import javax.swing.JTextArea;
import java.awt.*;

class TextArea extends JTextArea {

    TextArea(){
        setColumns(10);
        setRows(1);
        setBackground(Color.lightGray);
        setFont(new Font("Consolas", Font.PLAIN,18));
        setMargin(new Insets(10,10,0,10));
        setEditable(false);
    }
}