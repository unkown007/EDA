package menu;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lista.Lista;
import lista.No;
import validacao.Validacao;
import lista.Operacoes;
import object.AplicacaoInstalada;
import object.Equipamento;
import tarefa.Alterar;
import tarefa.Inserir;
import tarefa.Remover;
import tarefa.Tarefa;

public class Menu {
    byte opc;
    private static Lista<Equipamento> app = new Lista<>();
    private static Lista<Equipamento> testeLista = new Lista<>();
    
    public static void menu() throws ParseException, IOException {
        byte opc;
        do{
            System.out.print("\n\n\tGestão de uma Rede Informática\n");
            System.out.print("\n1 - Equipamento");
            System.out.print("\n2 - Pesquisar");
            System.out.print("\n3 - Listar");
            System.out.print("\n0 - Sair");
            opc = (byte) Validacao.num("\nR: ",0,3);
            switch(opc){
                case 1:
                    menuEquipamento(); break;
                case 2:
                    menuPesquisar(); break;
                case 3:
                    menuListar(); break;
            }
        }while(opc != 0);
    }
    
    /*public static void subMenuEquiEliminar() {
        byte opc;
        do{
            System.out.print("\n\tEliminar:");
            System.out.print("\n1 - Equipamento");
            System.out.print("\n2 - Aplicacoes Instaladas");
            System.out.print("\n3 - Placa de Rede");
            System.out.print("\n0 - Voltar");
            opc = (byte) Validacao.num("\nR: ",0,3);
            switch(opc){
                case 1:
                    subMenuEliminarEquipamento(); break;
                case 2:
                   subMenuEliminarApp(); break;
                case 3:
                   subMenuEliminarRede(); break;
            }
        }while(opc != 0);
    }*/
    
    /*public static void subMenuEliminarEquipamento(){
        app.mostrar();
        
        System.out.println("\nELIMINAR EQUIPAMENTO\n");
        int id1 =(int) Validacao.num("ID(equipamento): ", 1, 99999);
        
        if(app.getNo(id1) == null) {
            System.out.println("Equipamento nao encontrada\n");
            return;
        }
        
        byte conf =(byte) Validacao.num("Confirmacao da elimanacao\n1 - SIM/t"
                + "2 - NAO",1,2);
        if(conf == 1){
            app.remover(id1);
            System.out.println("removido com sucesso!\n");
        }
    }
    
    public static void subMenuEliminarApp(){
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
        
        System.out.println();
        int id2 =(int) Validacao.num("ID(app instalada): ",1, 99999);
        
        if(tmp.ob.getApp().getNo(id2) == null) {
            System.out.println("App nao encontrada\n");
            return;
        }
        
        byte conf =(byte) Validacao.num("Confirmacao da elimanacao\n1 - SIM/t"
                + "2 - NAO",1,2);
        if(conf == 1){
            tmp.ob.getApp().remover(id2);
            System.out.println("removido com sucesso!\n");
        }
    }
    public static void subMenuEliminarRede(){
        No<Equipamento> tmp;
        
        app.mostrar();
        
        System.out.println("\nELIMINAR PLACA DE REDE\n");
        int id1 =(int) Validacao.num("ID(equipamento): ", 1, 99999);
        
        tmp = app.getNo(id1);
        
        if(tmp == null) {
            System.out.println("Equipamento nao encontrado\n");
            return;
        }
        
        tmp.ob.getRede().mostrar();
        
        System.out.println("\n");
        int id2 =(int) Validacao.num("ID(Placa rede): ",1, 99999);
        
        if(tmp.ob.getRede().getNo(id2) == null) {
            System.out.println("Placa de rede nao encontrada\n");
            return;
        }
        
        byte conf =(byte) Validacao.num("Confirmacao da elimanacao\n1 - SIM/t"
                + "2 - NAO",1,2);
        if(conf == 1){
            tmp.ob.getRede().remover(id2);
            System.out.println("removido com sucesso!\n");
        }
    }*/
    
    /*public static void subMenuEquiUpdate() {
        byte opc;
        do{
            System.out.print("\n\tAlterar:");
            System.out.print("\n1 - Equipamento");
            System.out.print("\n0 - Voltar");
            opc = (byte) Validacao.num("\nR: ",0,1);
            switch(opc){
                case 1:
                    subMenuEquiUpdateEq(); break;
            }
        }while(opc != 0);
    }
    
    public static void subMenuEquiUpdateEq() {
        byte opc;
        do{
            System.out.print("\n\tAlterar Equipamento:");
            System.out.print("\n1 - Equipamento");
            System.out.print("\n2 - Aplicacoes Instaladas");
            System.out.print("\n3 - Placa de Rede");
            System.out.print("\n0 - Voltar");
            opc = (byte) Validacao.num("\nR: ",0,3);
            switch(opc){
                case 1:
                    ; break;
                case 2:
                   ; break;
                case 3:
                   ; break;
            }
        }while(opc != 0);
    }
    
    public static void appUpdate(){
        
        
        
    }
    
    public static void equipUpdate(){
        
    }
    
    public static void redeUpdate(){
        
    }*/
    
    public static void menuEquipamento() throws IOException, ParseException {
        byte opc;
        do{
            System.out.print("\n\tEquipamento:");
            System.out.print("\n1 - Visualizar");
            System.out.print("\n2 - Inserir");
            System.out.print("\n3 - Alterar");
            System.out.print("\n4 - Eliminiar");
            System.out.print("\n0 - Voltar");
            opc = (byte) Validacao.num("\nR: ",0,4);
            switch(opc){
                case 1:
                    subMenuEquiVisual(); 
                break;
                case 2:
                    subMenuEquiInser();
                break;
                case 3:
                    subMenuEquiAlter(); 
                break;
                case 4:
                    subMenuEquiRemo(); 
                break;
            }
        }while(opc != 0);
    }
    
    
    // -------------------------------------------------------------
    
    public static void subMenuEquiInser() throws IOException, ParseException {
        byte opc;
        do{
            System.out.print("\n\tINSERIR:");
            System.out.print("\n1 - Equipamento");
            System.out.print("\n2 - Aplicacoes Instaladas");
            System.out.print("\n3 - Placa de Rede");
            System.out.print("\n0 - Voltar");
            opc = (byte) Validacao.num("\nR: ",0,3);
            switch(opc){
                case 1:
                    Inserir.addEquipamento(app);
                break;
                case 2:
                    Inserir.incAppInstaladas(app);
                break;
                case 3:
                    Inserir.incPlacaRede(app);
                break;
            }
        }while(opc != 0);
    }
    
    public static void subMenuEquiAlter() throws IOException, ParseException {
        byte opc;
        do{
            System.out.print("\n\tALTERAR:");
            System.out.print("\n1 - Equipamento");
            System.out.print("\n2 - Aplicacoes Instaladas");
            System.out.print("\n3 - Placa de Rede");
            System.out.print("\n0 - Voltar");
            opc = (byte) Validacao.num("\nR: ",0,3);
            switch(opc){
                case 1:
                   Alterar.alterarEquipamento(app);
                break;
                case 2:
                   Alterar.alterAppIns(app);
                break;
                case 3:
                   Alterar.alterPlaca(app);
                break;
            }
        }while(opc != 0);
    }
    
    public static void subMenuEquiRemo() throws IOException {
        byte opc;
        do{
            System.out.print("\n\tELIMINAR:");
            System.out.print("\n1 - Equipamento");
            System.out.print("\n2 - Aplicacoes Instaladas");
            System.out.print("\n3 - Placa de Rede");
            System.out.print("\n0 - Voltar");
            opc = (byte) Validacao.num("\nR: ",0,3);
            switch(opc){
                case 1:
                    Remover.removerEquipamento(app);
                break;
                case 2:
                    Remover.rmAppinst(app);
                break;
                case 3:
                    Remover.rmPlaca(app);
                break;
            }
        }while(opc != 0);
    }
    
    public static void subMenuEquiVisual() {
        byte opc;
        do{
            System.out.print("\n\tVISUALIZAR:");
            System.out.print("\n1 - Equipamento");
            System.out.print("\n2 - Aplicacoes Instaladas");
            System.out.print("\n3 - Placa de Rede");
            System.out.print("\n0 - Voltar");
            opc = (byte) Validacao.num("\nR: ",0,3);
            switch(opc){
                case 1:
                    app.mostrar(); 
                break;
                case 2:
                   subMenuEquiVisualApp(); 
                break;
                case 3:
                    subMenuEquiVisualRede(); 
                break;
            }
        }while(opc != 0);
    }
    
    // -------------------------------------------------------------
    
    public static void subMenuEquiVisualRede(){
         //int i=1;
         
         System.out.println();
         app.mostrar();
         
         System.out.println();
         int id1 =(int) Validacao.num("ID(equipamento): ", 1, 99999);
         
         if(app.getNo(id1) == null) {
            System.out.println("Equipamento nao encontrado\n");
            return;
         }
         
         System.out.print("\n\tPLACA DE REDE:\n");
         
         app.getNo(id1).ob.getRede().mostrar();
         
         /*while(app.getNo(i) != null) {
            System.out.println("EQUIPAMENTO: " + i);
             app.getNo(i).ob.getRede().mostrar();
             System.out.println();
             i++;
         }*/
     }
    
    public static void subMenuEquiVisualApp(){
         //int i=1;
         
         System.out.println();
         app.mostrar();
         
         System.out.println();
         int id1 =(int) Validacao.num("ID(equipamento): ", 1, 99999);
         
         if(app.getNo(id1) == null) {
            System.out.println("Equipamento nao encontrado\n");
            return;
         }
         
         System.out.print("\n\tAPP INSTALADAS:\n");
         
         app.getNo(id1).ob.getApp().mostrar();
         
         /*while(app.getNo(i) != null) {
            System.out.println("EQUIPAMENTO: " + i);
            app.getNo(i).ob.getApp().mostrar();
            System.out.println();
            i++;
         }*/
     }
     
    private static void menuPesquisar() throws ParseException {
        byte opc;
        do{
            System.out.print("\n\tPesquisar:\n\tTodos os equipamentos");
            System.out.print("\n1 - Com um dado SO");
            System.out.print("\n2 - Que pertencem uma dada rede");
            System.out.print("\n3 - Com uma dada aplicacao");
            System.out.print("\n0 - Voltar");
            opc = (byte) Validacao.num("\nR: ",0,3);
            switch(opc){
                case 1:
                    subPesquisarSO(); break;
                case 2:
                    subListarNelaSituada(); break;
                case 3:
                    subPesquisarApp();
            }
        }while(opc != 0);
    }
    
    private static void subPesquisarApp() throws ParseException{
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        String dc = Validacao.texto("Descricao: ", 2);
        String vs = Validacao.texto("Versao: ", 2);
        String lc = Validacao.texto("Licenca (dd/mm/yyyy): ", 4);
        Date dataUsuario = dataFormatada.parse(lc);
        testeLista = Tarefa.pesquisaDaApp(app, dc, vs, dataUsuario);
        if(testeLista != null)
            testeLista.mostrar();
         else
            System.out.println("\nNão foi encontrado equipamento com \nDescricao: "+dc+"\nVersao: "+vs+"\nLicenca: "+lc);
        
    }
    
    private static void subPesquisarSO() throws ParseException {
         String so = Validacao.texto("Informe o Sistema Operativo: ", 2);
         testeLista = Tarefa.pesquisaSO(app, so);
         if(testeLista != null)
            testeLista.mostrar();
         else
            System.out.println("Nenhum equipamento com SO "+so);
         
     }
    private static void menuListar() throws ParseException {
        byte opc;
        do{
            System.out.print("\n\tListar:");
            System.out.print("\n1 - Totais");
            System.out.print("\n2 - Equipamento com menos certo valor em RAM");
            System.out.print("\n3 - Redes e equipamentos nela situadas");
            System.out.print("\n4 - Equipamento cuja garantia expirou");
            System.out.print("\n5 - Equipamento cuja a licenca expirou");
            System.out.print("\n6 - Dois equipamento com mesmo IP");
            System.out.print("\n7 - Determinar se dois equipamentos podem comunicar");
            System.out.print("\n0 - Voltar");
            opc = (byte) Validacao.num("\nR: ",0,7);
            switch(opc){
                case 1:
                    subListarTotais(); break;
                case 2:
                    subListarRam(); break;
                case 3:
                    subListarNelaSituada(); break;
                case 4:
                    subListarGarantiaEx(); break;
                case 5:
                    subListarLicencaEx(); break;
                case 6:
                    Tarefa.conflitoRede(app); break;
                case 7:
                    Tarefa.comunicarDoisEquipa(app); break;   
            }
        }while(opc != 0);
    }
   
    private static void subListarNelaSituada() throws ParseException{
        testeLista = Tarefa.equipMesmaRede(app);
        if(testeLista != null)
            testeLista.mostrar();
        else
            System.out.println("Nenhum equipamento esta na mesma rede");
    }
    
    private static void subListarLicencaEx() throws ParseException{
        testeLista = Tarefa.lincencaExpirada(app);
        if(testeLista != null)
            testeLista.mostrar();
        else
            System.out.println("Nenhum equipamento com licenca expirada");
    }
     
    private static void subListarGarantiaEx() throws ParseException{
        testeLista = Tarefa.garantiaExpirada(app);
        if(testeLista != null)
            testeLista.mostrar();
        else
            System.out.println("Nenhum equipamento com garantia expirada");
    }
     
    private static void subListarRam(){
        byte ram = (byte)Validacao.num("Informe valor em memoria RAM: ", 1, 999);
        testeLista = Tarefa.menorRam(app, ram);
        if(testeLista != null)
            testeLista.mostrar();
        else
            System.out.println("Nenhum equipamento com "+ram+"GB RAM menor");
    }
     
    private static void subListarTotais(){
        System.out.print("\n\tTotais:");
        System.out.println("\nMIPS: "+Tarefa.getTotalMips(app)+
                "\nMemoria: "+Tarefa.getTotalRam(app)+""
                + "\nCapacidade dos HDs: "+Tarefa.getTotalHd(app));
    }
}

