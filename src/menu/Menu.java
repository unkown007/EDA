package menu;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lista.Lista;
import validacao.Validacao;
import lista.Operacoes;
import object.Equipamento;
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
                    subMenuEquiVisual(); break;
               case 2:
                    subMenuEquiInserir(); break;
               case 3:
                    subMenuEquiUpdate(); break;
               case 4:
                    subMenuEquiEliminar(); break;
               
            }
        }while(opc != 0);
    }
    
    public static void subMenuEquiEliminar() {
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
    }
    public static void subMenuEliminarEquipamento(){
        System.out.println(
                    String.format(
                            "%-10s%-20s %-20s %-20s %-20s %-20s %-20s"
                            ,"ID","Data de Aquisicao","Garantia",
                             "Capacidade(GB)","CPU(Ghz)",
                             "Memoria(GB)","Sistema Operativo"));
        for(int i = 1; i <= testeLista.quantidade(); i++){
            testeLista.mostrar();
        }
    }
    public static void subMenuEliminarApp(){
        
    }
    public static void subMenuEliminarRede(){
        
    }
    public static void subMenuEquiUpdate() {
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
            }
        }while(opc != 0);
    }
     public static void subMenuEquiVisual() {
        byte opc;
        do{
            System.out.print("\n\tVisualizar:");
            System.out.print("\n1 - Equipamento");
            System.out.print("\n2 - Aplicacoes Instaladas");
            System.out.print("\n3 - Placa de Rede");
            System.out.print("\n0 - Voltar");
            opc = (byte) Validacao.num("\nR: ",0,3);
            switch(opc){
                case 1:
                    app.mostrar(); break;
                case 2:
                   subMenuEquiVisualApp(); break;
                case 3:
                    subMenuEquiVisualRede(); break;
              
            }
        }while(opc != 0);
    }
     public static void subMenuEquiVisualRede(){
         System.out.print("\n\tPlaca de Rede:");
         for(int i = 1; i <= app.quantidade(); i++){
            for(int k = 1; k <= app.getNo(i).ob.getRede().quantidade(); k++)
                if(app.getNo(k) != null)
                    app.getNo(k).ob.getRede().mostrar();
         }
     }
     public static void subMenuEquiVisualApp(){
         System.out.print("\n\tAplicacoes Instaladas:");
         for(int i = 1; i <= app.quantidade(); i++){
            for(int k = 1; k <= app.getNo(i).ob.getApp().quantidade(); k++)
                if(app.getNo(k) != null)
                      app.getNo(k).ob.getApp().mostrar();
         }
     }
    public static void subMenuEquiInserir() throws IOException, ParseException {
        byte opc;
        do{
            System.out.print("\n\tInserir:");
            System.out.print("\n1 - Equipamento");
            System.out.print("\n0 - Voltar");
            opc = (byte) Validacao.num("\nR: ",0,1);
            switch(opc){
                case 1:
                    Tarefa.addEquipamento(app); break;
            }
        }while(opc != 0);
    }
    
    /* public static void subMenuEquiInserirEq() {
        byte opc;
        do{
            System.out.print("\n\tInserir:");
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
            }
        }while(opc != 0);
    } */
     
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

