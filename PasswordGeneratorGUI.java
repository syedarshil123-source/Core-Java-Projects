import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//First i have imported jswing package which contain GUI components (class) 
// for desktop applications 
//Inheriting jframe
public class PasswordGeneratorGUI extends JFrame{
    private PasswordGenerator passwordGenerator;
    //rendering frame and adding title 
    public PasswordGeneratorGUI(){

        //render frame and add title
        super("Password Generator");

        //setting the size of the frame
        setSize(540, 570);

        //Prevent GUI to get resized 
        setResizable(false);

        //Setitng layout to null to have control on the position 
        //of the buttons and components and we will set manually
        setLayout(null);

        //terminate the programm when GUI is closed(end the process)
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Center the GUI to the screen 
        setLocationRelativeTo(null);

        passwordGenerator = new PasswordGenerator();
        //render GUI components 
        addGUicomponents();

                
    }
        private void addGUicomponents(){
            //creating title 
            JLabel titleLabel = new JLabel("Password Generator ");

            //Setting fonts and all
            titleLabel.setFont(new Font("Dialog",Font.BOLD,32));

            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

            titleLabel.setBounds(0,10,540,39);

            add(titleLabel);

            //create text area
            JTextArea PasswordOutput = new JTextArea();

            //prevent editiing the text area
            PasswordOutput.setEditable(false);
            PasswordOutput.setFont(new Font("Dialog" ,Font.BOLD,32));

            //Add scrollability in case output become so big
            JScrollPane PasswordOutputPane = new JScrollPane(PasswordOutput);
            PasswordOutputPane.setBounds(25, 97, 479, 70);

            PasswordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            add(PasswordOutputPane);
            
            //create password length input
            JTextArea PasswordlengthInputArea = new JTextArea();
            PasswordlengthInputArea.setFont(new Font("Dialog",Font.PLAIN,32));
            PasswordlengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            PasswordlengthInputArea.setBounds(310, 215, 192, 39);
            add(PasswordlengthInputArea);

            JLabel PasswordLengthLabel = new JLabel("Password Length: ");
            PasswordLengthLabel.setFont(new Font("Dialog",Font.PLAIN,32));
            PasswordLengthLabel.setBounds(25, 215, 272, 39);
            add(PasswordLengthLabel);

            //Create Password length label 

            //create toggle buttons 
            //upper case toggle buttons 
            JToggleButton UppercaseToggle = new JToggleButton("Uppercase");
            UppercaseToggle.setFont(new Font("Dialog",Font.PLAIN,26));
            UppercaseToggle.setBounds(25, 302,225,56);
            add(UppercaseToggle);

            //Set lowercase
            JToggleButton LowercaseToggle = new JToggleButton("Lowercase");
            LowercaseToggle.setFont(new Font("Dialog",Font.PLAIN,26));
            LowercaseToggle.setBounds(282, 302, 225, 56); 
            add(LowercaseToggle);

            //Set Symbols toggle
            JToggleButton numbersToggle = new JToggleButton("Numbers");
            numbersToggle.setFont(new Font("Dialog",Font.PLAIN,26));
            numbersToggle.setBounds(25, 373, 225, 56); 
            add(numbersToggle);

            JToggleButton SymbolsToggle = new JToggleButton("Symbols");
            SymbolsToggle.setFont(new Font("Dialog",Font.PLAIN,26));
            SymbolsToggle.setBounds(282, 373, 225, 56); 
            add(SymbolsToggle);

            //Generate Jbutton
            JButton generateButton = new JButton("Generate");
            generateButton.setFont(new Font("Dialog",Font.PLAIN,32));
            generateButton.setBounds(155, 477, 222, 41);
            
            generateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    if(PasswordlengthInputArea.getText().length() <=0) return;
                    boolean anyToggleSelected = LowercaseToggle.isSelected() || UppercaseToggle.isSelected() || numbersToggle.isSelected() || SymbolsToggle.isSelected() ;
                    int Passwordlength = Integer.parseInt(PasswordlengthInputArea.getText());
                    if(anyToggleSelected) {
                        String generatePassword = passwordGenerator.generatePassword(Passwordlength,UppercaseToggle.isSelected(),LowercaseToggle.isSelected(),numbersToggle.isSelected(),SymbolsToggle.isSelected());
                        PasswordOutput.setText(generatePassword);

                        
                    }


                }
            });
            add(generateButton);

        }

}