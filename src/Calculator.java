import javax.swing.*
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
   // components 
    private JTextField display;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;
    private JButton sinButton, cosButton, logButton;
    private JButtton mPlusButton, mMinusButton, mRecallButton, mClearButton;
    private JToggleButton themeButton;
    private JPanel panel;

    // variables
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;
    private double memory = 0;
    private boolean isDarkTheme = false;

    // colors for themes
    private Color lightBg = new Color(245, 245, 245);
    private Color darkBg = new Color(45, 45, 45);
    private Color lightDisplay = Color.WHITE;
    private Color darkDisplay = new Color(30, 30, 30);
    private Color lightText = Color.BLACK;
    private Color darkText = Color.WHITE;
    private Color lightButton = new Color(230, 230, 230);
    private Color darkButton = new Color(60, 60, 60);

    public Calculator() {
        // frame settings
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 600);
        setLayout(null);
        setResizable(false);

        // display field
        display = new JTextField();
        display.setBounds(20, 20, 410, 60);
        display.setFont(new Font("Arial", Font.PLAIN, 28));
        display.setEditable(true);
        display.setHorizontialAlignment(JTextField.RIGHT);
        display.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || c == '.' || c == '+' || c == '-' || c == '*' || c == '/' || c == '\n' || c == '\b')) {
                    e.consume();  // ignore invalid input
                }
                if (c == KeyEvent.VK_ENTER) {
                    equButton.doClick();
                    e.consume();
            }
        });
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 24));
            numberButtons[i].setFocusable(false);
            numberButtons[i].addActionListener(this);
        }

        // the fuction buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        logButton = new JButton("log");
        mPlusButton = new JButton("M+");
        mMinusButton = new JButton("M-");
        mRecallButton = new JButton("MR");
        mClearButton = new JButton("MC");
        themeButton = new JToggleButton("☀/☾");

        functionButtons = new JButton[] {
            addButton, subButton, mulButton, divButton,
            decButton, equButton, delButton, clrButton,
            sinButton, cosButton, logButton,
            mPlusButton, mMinusButton, mRecallButton, mClearButton
        };

        for (JButton button : functionButtons) {
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.setFocusable(false);
            button.addActionListener(this);
        }

        themeButton.setFont(new Font("Arial", Font.PLAIN, 18));
        themeButton.setFocusable(false);
        themeButton.addActionListener(this);

        // button panel
        panel = new JPanel();
        panel.setBounds(20, 100, 410, 450);
        panel.setLayout(new GridLayout(7, 5, 5, 5));

        // add memory buttons
        panel.add(mPlusButton);
        panel.add(mMinusButton);
        panel.add(mRecallButton);
        panel.add(mClearButton);

        // add scientific buttons
        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(logButton);
        panel.add(themeButton);

        // add buttons to panel
        panel.add(clrButton);
        panel.add(delButton);
        panel.add(divButton);
        panel.add(mulButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(subButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(addButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(equButton);

        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(new JLabel()); // empty space
        panel.add(new JLabel()); // empty space

        // add components to frame
        add(display);
        add(panel);

        // set initial theme
        applyTheme();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // # buttons
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText() + i);
            }
        }
        // dec point
        if (e.getSource() == decButton) {
            if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }
        }

        // clr button
        if (e.getSource() == clrButton) {
            display.setText("");
            num1 = num2 = result = 0;
        }

        // del button
        if (e.getSource() == delButton) {
            String str = display.getText();
            if (str.length() > 0) {
                display.setText(str.substring(0, str.length() = 1));
        }







}
