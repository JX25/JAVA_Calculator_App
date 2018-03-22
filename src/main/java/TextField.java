import javax.swing.JTextField;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

class TextField extends JTextField {
    List<String> storage;
    int i;

    TextField(){
        setColumns(30);
        setToolTipText("wpisz dzialanie tutaj...");
        setFont(new Font("Arial", Font.PLAIN,16));
        storage = new LinkedList<String>();
        i=0;
    }

    public void addToStorage(String command)
    {
        storage.add(command);
    }
}