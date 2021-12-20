package informatica;

import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;
import menu.Menu;
import tarefa.Tarefa;
import lista.*;
import object.*;

public class Informatica {
    public static Lista<Equipamento> app = new Lista<>();
    private static Lista<AplicacaoInstalada> api = new Lista<>();
    public static void main(String[] args) throws IOException, ParseException {
        //Menu m = new Menu();
        
        
        Tarefa.addEquipamento(app);
        //Tarefa.addEquipamento(app);
       
          api.mostrar();
          //app.mostrar();
        
        //Tarefa.alterarEquipamento(app);
        
        //app.getNo(1).ob.getApp().mostrar();
        
        //PlacaRede.tableHeader();
        
        /*
        Listar l = new Listar();
        System.out.println("RAM: "+l.getTotalRam()+"\nMIPS: "+l.getTotalMips()+"\nHD: "+l.getTotalHd());
        app.mostrar();
        
        Lista<Equipamento> equipMenorRam = l.menorRam(8);
        for(int i = 1; i <= equipMenorRam.quantidade(); i++){
            System.out.println("\nEquipamento"+i+"\nSistema operativo: "+equipMenorRam.getNo(i).ob.getSistemaOperacinal());
        }*/
    }

}