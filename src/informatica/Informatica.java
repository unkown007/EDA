package informatica;

import java.io.*;
import java.text.ParseException;
import menu.Menu;

public class Informatica {
    
    public static void main(String[] args) throws IOException, ParseException {
          Menu men = new Menu();
          
          men.menu();
          men.save();
    }

}