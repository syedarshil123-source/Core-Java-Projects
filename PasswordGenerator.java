//In this class we will make the backend (logic behind the Password generator)

import java.util.Random;

public class PasswordGenerator{
    //Charactor polls 
    //These strings will hold the characters and alal that we randomly pick to make password
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String SYMBOLS = "!@#$%^&*()_-+={}[];:'|,.<>/?";

    //Random class will allow us to generate random numbers that will be used randomly to generate password
    private final Random random;

    public PasswordGenerator(){ random = new Random();}
    public String generatePassword(int length, boolean includeuppercase, boolean includelowercase , boolean includenumbers ,boolean includesymbols){
        StringBuilder PasswordBuilder = new StringBuilder();
        String validcharacters = "";
        if(includelowercase) validcharacters +=LOWERCASE_CHARACTERS;
        if(includeuppercase) validcharacters +=UPPERCASE_CHARACTERS;
        if(includesymbols) validcharacters +=SYMBOLS;
        if(includenumbers) validcharacters += NUMBERS;

        for(int i=0;i<length ;i++){
            //generate random index 

            int randomIndex = random.nextInt(validcharacters.length());

            //get the char based on the random index
            char randomchar = validcharacters.charAt(randomIndex);
        PasswordBuilder.append(randomchar);

        //do the until we have reached the length that the user has provided to us 

        }
        return PasswordBuilder.toString();

    }


}