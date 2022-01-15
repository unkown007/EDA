package menu;
import Armazenamento.Armazenar;
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
import tarefa.*;

public class Menu {
    byte opc;
    private static Lista<Equipamento> app;// = new Lista<>();
    private static Lista<Equipamento> testeLista = new Lista<>();
    
    public Menu() {
        app = Armazenar.LerDadosDoFichObj("equipamento");
    }
    
    public static void save() {
        Armazenar.GravarFichObj(app,"equipamento");
    }
    
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
     }
    
    public static void subMenuEquiVisualApp(){
         
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
                    Tarefa.subPesquisarSO(app); break;
                case 2:
                    Tarefa.subListarNelaSituada(app); break;
                case 3:
                    Tarefa.subPesquisarApp(app);
            }
        }while(opc != 0);
    }
    
    private static void menuListar() throws ParseException {
        byte opc;
        do{
            System.out.print("\n\tListar:");
            System.out.print("\n1 - Totais");
            System.out.print("\n2 - Equipamento com menos certo valor em RAM");
            System.out.print("\n3 - Redes e equipamentos nela situadas");
            System.out.print("\n4 - Equipamento cuja garantia expirou");
            System.out.print("\n5 - Aplicacoes cuja a licenca expirou");
            System.out.print("\n6 - Dois equipamento com mesmo IP");
            System.out.print("\n7 - Determinar se dois equipamentos podem comunicar");
            System.out.print("\n0 - Voltar");
            opc = (byte) Validacao.num("\nR: ",0,7);
            switch(opc){
                case 1:
                    Tarefa.subListarTotais(app); break;
                case 2:
                    Tarefa.subListarRam(app); break;
                case 3:
                    Tarefa.subListarNelaSituada(app); break;
                case 4:
                    Tarefa.subListarGarantiaEx(app); break;
                case 5:
                   Tarefa.subListarLicencaEx(app); break;
                case 6:
                    Pesquisa.conflitoRede(app); break;
                case 7:
                    Pesquisa.comunicarDoisEquipa(app); break;   
            }
        }while(opc != 0);
    }
}

