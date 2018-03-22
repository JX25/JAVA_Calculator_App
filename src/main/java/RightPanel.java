import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class RightPanel extends JPanel {
    RightPanel(ListOfOperations list, Evaluate button){
        Border paddingRight = BorderFactory.createEmptyBorder(10, 0, 10, 20);
        setBorder(paddingRight);
        setLayout(new BorderLayout());
        add(list,BorderLayout.CENTER);
        add(button,BorderLayout.SOUTH);
    }
}