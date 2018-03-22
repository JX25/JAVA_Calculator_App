import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class LeftPanel extends JPanel {

    LeftPanel(TextArea textArea, TextField textField){
        Border paddingLeft = BorderFactory.createEmptyBorder(10, 20, 10, 0);
        setBorder(paddingLeft);
        setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll,BorderLayout.CENTER);
        add(textField,BorderLayout.SOUTH);
    }

}