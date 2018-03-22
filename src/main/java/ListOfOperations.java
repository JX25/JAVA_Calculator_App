import javax.swing.*;

class ListOfOperations extends JList {
    // JList
    DefaultListModel dlm;
    ListOfOperations() {
        dlm = new DefaultListModel();
        Functions[] fun = {
                new Functions("sin(x)","sin()"),
                new Functions("cos(x)","cos()"),
                new Functions("tan(x)","tan()"),
                new Functions("ctg(x)","ctg()"),
                new Functions("Liczba: π","pi"),
                new Functions("Liczba: e","e"),
                new Functions("Złoty podział: φ","[phi]"),
                new Functions("Dzielenie: /","/"),
                new Functions("Mnozenie: *","*"),
                new Functions("Modulo: #","#"),
                new Functions("Ostatni wynik","0.0"),
        };
        dlm.addElement(fun[0]);
        dlm.addElement(fun[1]);
        dlm.addElement(fun[2]);
        dlm.addElement(fun[3]);
        dlm.addElement(fun[4]);
        dlm.addElement(fun[5]);
        dlm.addElement(fun[6]);
        dlm.addElement(fun[7]);
        dlm.addElement(fun[8]);
        dlm.addElement(fun[9]);
        dlm.addElement(fun[10]);
        setModel(dlm);
    }

    public void update(String wart)
    {
        dlm.remove(dlm.size()-1);
        Functions value = new Functions("Ostatni wynik",wart);
        dlm.addElement(value);
        setModel(dlm);
    }
}
