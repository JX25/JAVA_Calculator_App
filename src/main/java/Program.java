import javax.swing.*;

public class Program {

    public static void main(String [] args)
    {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                App myApp = new App();
                myApp.setVisible(true);
            }
        });
    }

}
