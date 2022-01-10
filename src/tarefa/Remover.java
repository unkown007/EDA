package tarefa;

import java.io.IOException;
import java.text.SimpleDateFormat;
import lista.*;
import object.*;
import validacao.Validacao;

public class Remover {
    private static SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void removerEquipamento(Lista<Equipamento> lista) throws IOException {
        System.out.println();
        lista.mostrar();
        
        System.out.println("\n\tELIMINAR EQUIPAMENTO:\n");
        int id1 =(int) Validacao.num("ID(equipamento): ", 1, 99999);
        
        if(lista.getNo(id1) ==  null) {
            System.out.println("Equipamento nao encontrado\n");
            return;
        }
        
        byte conf =(byte) Validacao.num("Confirmacao da elimanacao\n1 - SIM\t"
                + "2 - NAO",1,2);
        if(conf == 1){
            lista.remover(id1);
            System.out.println("removido com sucesso!\n");
        }
    }
    
    public static void rmAppInstaladas(Lista<AplicacaoInstalada> lista) throws IOException {
        int pos;
        
        System.out.println();
        pos = (int)Validacao.num("ID(app instalada): ", 1, 99999);
        
        if(lista.getNo(pos) == null) {
            System.out.println("App nao encontrada\n");
            return;
        }
        
        byte conf =(byte) Validacao.num("Confirmacao da elimanacao\n1 - SIM\t"
                + "2 - NAO",1,2);
        
        if(conf == 1){
            lista.remover(pos);
            System.out.println("removido com sucesso!\n");
        }
    }
    
    public static void rmPlacaRede(Lista<PlacaRede> lista) throws IOException {
        int pos;
        
        System.out.println();
        pos = (int)Validacao.num("ID(placa de rede): ", 1, 99999);
        
        if(lista.getNo(pos) == null) {
            System.out.println("Placa de rede nao encontrada\n");
            return;
        }
        
        byte conf =(byte) Validacao.num("Confirmacao da elimanacao\n1 - SIM\t"
                + "2 - NAO",1,2);
        
        if(conf == 1){
            lista.remover(pos);
            System.out.println("removido com sucesso!\n");
        }
    }
    
    public static void rmAppinst(Lista<Equipamento> app) throws IOException {
        No<Equipamento> tmp;
        
        System.out.println();
        app.mostrar();
        
        System.out.println("\n\tELIMINAR APP INSTALADA\n");
        int id1 =(int) Validacao.num("ID(equipamento): ", 1, 99999);
        
        tmp = app.getNo(id1);
        
        if(tmp == null) {
            System.out.println("Equipamento nao encontrada\n");
            return;
        }
        
        System.out.println();
        tmp.ob.getApp().mostrar();
        
        rmAppInstaladas(tmp.ob.getApp());
    }
    
    public static void rmPlaca(Lista<Equipamento> app) throws IOException {
        No<Equipamento> tmp;
        
        System.out.println();
        app.mostrar();
        
        System.out.println("\n\tELIMINAR PLACA DE REDE\n");
        int id1 =(int) Validacao.num("ID(equipamento): ", 1, 99999);
        
        tmp = app.getNo(id1);
        
        if(tmp == null) {
            System.out.println("Equipamento nao encontrada\n");
            return;
        }
        
        System.out.println();
        tmp.ob.getRede().mostrar();
        
        rmPlacaRede(tmp.ob.getRede());
    }
}
