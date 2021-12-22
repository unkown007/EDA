package informatica;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import menu.Menu;
import tarefa.Tarefa;
import lista.*;
import object.*;

public class Informatica {
    
    public static void main(String[] args) throws IOException, ParseException {
        Menu m = new Menu();
        
        //Lista<Equipamento> app = new Lista<>();
        //Lista<Equipamento> app2 = new Lista<>();
        
        //Tarefa.addEquipamento(app1);
        //Tarefa.addEquipamento(app1);
        //Tarefa.addEquipamento(app1);
        //Tarefa.addEquipamento(app2);
       
         //app2.mostrar();
         //app1.mostrar();
         
         //No<Equipamento> n = app1.getNo(2);
         
         //n.ob.getApp().mostrar();
         
         //Tarefa.conflitoRede(app1);
         
        
         /*Lista<Equipamento> testeUniversal = Tarefa.pesquisaSO(app1, "Windows");
         testeUniversal.getNo(1).ob.getApp().mostrar();
         testeUniversal.getNo(1).ob.getRede().mostrar();
         for(int i = 1; i <= testeUniversal.quantidade(); i++){
            System.out.println("\nEquipamento"+i+"\nSistema operativo: "+testeUniversal.getNo(i).ob.getSistemaOperacinal());
         }
         /* */
         
         //Tarefa.comunicarDoisEquipa(app1);
            
         /*
         //Tarefa.conflitoRede(app1, "192.78.18.12");
         */
         
         /*Lista<Equipamento> testeUniversal4 = Tarefa.garantiaExpirada(app1);
         if(testeUniversal4 != null && !testeUniversal4.vazia()){
            testeUniversal4.getNo(1).ob.getApp().mostrar();
            for(int i = 1; i <= testeUniversal4.quantidade(); i++){
               System.out.println("\nEquipamento"+i+"\nSistema operativo: "+testeUniversal4.getNo(i).ob.getSistemaOperacinal());
            }
         }*/
         
         
         /*SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
         Date dataUsuario = dataFormatada.parse("21/01/2022");
         Lista<Equipamento> testeUniversal2 = Tarefa.pesquisaDaApp(app1, "Bom", "v4", dataUsuario);
     
         for(int i = 1; i <= testeUniversal2.quantidade(); i++){
            System.out.println("\nEquipamento"+i+"\nSistema operativo: "+testeUniversal2.getNo(i).ob.getSistemaOperacinal());
         }
         /*/
         
         /*
         Lista<Equipamento> testeUniversal3 = Tarefa.equipMesmaRede(app1);
         for(int i = 1; i <= testeUniversal3.quantidade(); i++){
            System.out.println("\nEquipamento"+i+"\nSistema operativo: "+testeUniversal3.getNo(i).ob.getSistemaOperacinal());
         }
         /*
         System.out.println("\nTOTAL\nHD: "+Tarefa.getTotalHd(app1)+"\nMIPS: "+Tarefa.getTotalMips(app1)+"\nRAM: "+Tarefa.getTotalRam(app1));
         
         Lista<Equipamento> testeUniversal6 = Tarefa.menorRam(app1, 4);
          for(int i = 1; i <= testeUniversal6.quantidade(); i++){
            System.out.println("\nEquipamento"+i+"\nSistema operativo: "+testeUniversal6.getNo(i).ob.getSistemaOperacinal());
         }
         
         Lista<Equipamento> testeUniversal5 = Tarefa.lincencaExpirada(app1);
         for(int i = 1; i <= testeUniversal5.quantidade(); i++){
            System.out.println("\nEquipamento"+i+"\nSistema operativo: "+testeUniversal5.getNo(i).ob.getSistemaOperacinal());
         }
       
        Lista<Equipamento> equipMenorRam = l.menorRam(8);
        for(int i = 1; i <= equipMenorRam.quantidade(); i++){
            System.out.println("\nEquipamento"+i+"\nSistema operativo: "+equipMenorRam.getNo(i).ob.getSistemaOperacinal());
        }
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