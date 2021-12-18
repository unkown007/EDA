package informatica;

import java.io.IOException;
import menu.Menu;
import tarefa.Tarefa;
import lista.*;
import object.*;

public class Informatica {

    public static void main(String[] args) throws IOException {
        //Menu m = new Menu();
        
        var app = new Lista<Equipamento>();
        Tarefa.addEquipamento(app);
        Tarefa.addEquipamento(app);
        
        //app.mostrar();
        
        //Tarefa.alterarEquipamento(app);
        
        //app.getNo(1).ob.getApp().mostrar();
        
        //PlacaRede.tableHeader();
        app.mostrar();
    }

}

