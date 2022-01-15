package informatica;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import menu.Menu;
import tarefa.Tarefa;
import lista.*;
import object.*;
import tarefa.Inserir;

public class Informatica {
    
    public static void main(String[] args) throws IOException, ParseException {
          Menu men = new Menu();
          
          men.menu();
          men.save();
    }

}