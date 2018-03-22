import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.mariuszgromada.math.mxparser.Expression;


public class App extends JFrame implements ActionListener {

    protected LeftPanel lePanel;
    protected RightPanel rPanel;
    protected JMenuBar menuBar;
    protected JMenu menu;
    protected JMenuItem reset,exit;
    protected ListOfOperations operationsList;
    protected TextField command;
    protected TextArea results;
    protected Evaluate button;

    App()
    {

        super("sciCalculator Java_03");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout frameLayout = new BorderLayout();
        frameLayout.setHgap(10);
        frameLayout.setVgap(10);
        setLayout(frameLayout);

        //Menu creating
        menuBar = new JMenuBar();
        menu = new JMenu("Opcje");
        reset = new JMenuItem("Resetuj");
        reset.addActionListener(this);
        exit = new JMenuItem("Wyjdź");
        exit.addActionListener(this);
        menu.add(reset);
        menu.add(exit);
        menu.addActionListener(this);
        menuBar.add(menu);

        //Operation List
        operationsList = new ListOfOperations();
        operationsList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                chooseOption(e);
            }
        });

        //Command
        command = new TextField();
        command.addActionListener(this);
        command.addKeyListener( new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent e){
                prevCalls(e);
            }
            private void prevCalls(KeyEvent e){
                int keyCode = e.getKeyCode();

                 if (keyCode == 38) {
                    try{
                        command.setText( command.storage.get(command.i) );
                    }catch(Exception ex){

                    }
                    command.i--;
                }
                else if (keyCode == 40) {
                    try{
                        command.setText( command.storage.get(command.i) );
                    }catch(Exception ex){

                    }
                    command.i++;
                }
            }
        });

        //Result
        results = new TextArea();
        //Button
        button = new Evaluate();
        button.addActionListener(this);
        //Panels
        lePanel = new LeftPanel(results,command);
        rPanel = new RightPanel(operationsList,button);

        add(menuBar,BorderLayout.NORTH);
        add(lePanel,BorderLayout.CENTER);
        add(rPanel,BorderLayout.EAST);

        setResizable(true);
    }

    public void actionPerformed(ActionEvent e) {

        if( e.getSource()==button || e.getSource()==command)
        {
            String operation = command.getText();
            Expression exp = new Expression(operation);
            if (exp.checkSyntax())
            {
                Double res = exp.calculate();
                operationsList.update(res.toString());
                results.append( ExpressionMessageFormat.returnExpression(operation,res.toString()) );
                command.addToStorage(command.getText());
                command.i = command.storage.size();
                command.setText("");
            }
            else{
                String errorMessage = exp.getErrorMessage();
                JOptionPane.showMessageDialog(null, errorMessage,"Błąd składni",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if( e.getSource() == exit )
        {
            System.exit(0);
        }
        else if( e.getSource() == reset )
        {
            results.setText("");
            command.setText("");
            command.requestFocusInWindow();
        }
    }

    private void chooseOption(MouseEvent e)
    {
        if (!operationsList.getValueIsAdjusting() || e.getClickCount() == 2)
        {
            Functions value = (Functions) operationsList.getSelectedValue();
            String operation = value.getParser();

            if( value.getMenuKey().equals("Ostatni wynik"))
            {
                String text = command.getText()+value.getParser();
                command.setText(text);
                command.requestFocusInWindow();
                return;
            }

            if(operation.contains("("))
            {
                int indexOfBracket = operation.indexOf('(');
                int length = command.getText().length();
                String text = command.getText()+operation;
                command.setText(text);
                command.setCaretPosition(length+indexOfBracket+1);
                command.requestFocusInWindow();
            }
            else{
                String text = command.getText()+operation;
                command.setText(text);
                command.requestFocusInWindow();
            }

        }
    }


}





