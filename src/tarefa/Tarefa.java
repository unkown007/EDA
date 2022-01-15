package tarefa;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import object.*;
import lista.*;
import static tarefa.Alterar.alterarAppInstaladas;
import static tarefa.Alterar.alterarPlacaRede;
import static tarefa.Inserir.addAppInstaladas;
import static tarefa.Inserir.addPlacaRede;
import static tarefa.Remover.rmAppInstaladas;
import static tarefa.Remover.rmPlacaRede;
import validacao.Validacao;

public class Tarefa {
    private static SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void cudPlacaRede(Lista<PlacaRede> lista) throws IOException {
        byte op;
        
        do {
            System.out.println("1. Inserir");
            System.out.println("2. Remover");
            System.out.println("3. Actualizar");
            System.out.println("0. Voltar");
            op =(byte) Validacao.num("Opcao: ", 0, 3);
            switch(op) {
                case 1:
                    addPlacaRede(lista);
                break;
                case 2:
                    rmPlacaRede(lista);
                break;
                case 3:
                    alterarPlacaRede(lista);
                break;
            }
        }while(op != 0);
    }
   
    public static void cudAppInstalada(Lista<AplicacaoInstalada> lista) throws IOException, ParseException {
        byte op;
        
        do {
            System.out.println("1. Inserir");
            System.out.println("2. Remover");
            System.out.println("3. Actualizar");
            System.out.println("0. Voltar");
            op =(byte) Validacao.num("Opcao: ", 0, 3);
            switch(op) {
                case 1:
                    addAppInstaladas(lista);
                break;
                case 2:
                    rmAppInstaladas(lista);
                break;
                case 3:
                    alterarAppInstaladas(lista);
                break;
            }
        }while(op != 0);
    }
    
    public static int getTotalRam(Lista<Equipamento> equipamento){
        int Ram = 0;
        if(equipamento.vazia())
            return 0;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                Ram += equipamento.getNo(i).ob.getRAM();
            }
        }
        return Ram;
    }
    
    public static double getTotalHd(Lista<Equipamento> equipamento){
         double Hd = 0.0f;
        if(equipamento.vazia())
            return 0.0f;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                Hd += equipamento.getNo(i).ob.getDiscoDuro();
            }
        }
        return Hd;
    }
    
    public static double getTotalMips(Lista<Equipamento> equipamento){
       double Mips = 0.0f;
       if(equipamento.vazia())
            return 0.0f;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                Mips += equipamento.getNo(i).ob.getCPU()*1250;
            }
        }
        return Mips;
    } 
    
    public static Lista<Equipamento> menorRam(Lista<Equipamento> equipamento,int ram){
        Lista<Equipamento> equipRam = new Lista<>();
        if(equipamento.vazia())
            return null;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                if(equipamento.getNo(i).ob.getRAM() < ram){
                    equipRam.inserir(equipamento.getNo(i).ob);
                }
            }
        }
        
        return equipRam;
    }
    
    public static void subListarNelaSituada(Lista<Equipamento> app) throws ParseException{
        Lista<Equipamento> testeLista = new Lista<>();
        testeLista = Pesquisa.equipMesmaRede(app);
        if(!testeLista.vazia()){
            System.out.println();
            testeLista.mostrar();
        }else
            System.out.println("Nenhum equipamento esta na rede fornecida");
    }
    
    public static void subListarLicencaEx(Lista<Equipamento> app) throws ParseException{
        Lista<Equipamento> testeLista = new Lista<>();
        
        if(!Pesquisa.lincencaExpirada(app).vazia())
            testeLista.mostrar();
        else
            System.out.println("Nenhuma Aplicacao com licenca expirada");
    }
     
    public static void subListarGarantiaEx(Lista<Equipamento> app) throws ParseException{
        Lista<Equipamento> testeLista = new Lista<>();
        testeLista = Pesquisa.garantiaExpirada(app);
        if(!testeLista.vazia())
            testeLista.mostrar();
        else
            System.out.println("Nenhum equipamento com garantia expirada");
    }
     
    public static void subListarRam(Lista<Equipamento> app){
        Lista<Equipamento> testeLista = new Lista<>();
        byte ram = (byte)Validacao.num("Informe valor em memoria RAM: ", 1, 999);
        testeLista = Tarefa.menorRam(app, ram);
        if(testeLista != null)
            testeLista.mostrar();
        else
            System.out.println("Nenhum equipamento com "+ram+"GB RAM menor");
    }
     
    public static void subListarTotais(Lista<Equipamento> app){
        System.out.print("\n\tTotais:");
        System.out.println("\nMIPS: "+Tarefa.getTotalMips(app)+
                "\nMemoria: "+Tarefa.getTotalRam(app)+""
                + "\nCapacidade dos HDs: "+Tarefa.getTotalHd(app));
    }
    
    public static void subPesquisarApp(Lista<Equipamento> app) throws ParseException{
        Lista<Equipamento> testeLista = new Lista<>();
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        String dc = Validacao.texto("Descricao: ", 2);
        String vs = Validacao.texto("Versao: ", 2);
        String lc = Validacao.texto("Licenca (dd/mm/yyyy): ", 4);
        Date dataUsuario = dataFormatada.parse(lc);
        testeLista = Pesquisa.pesquisaDaApp(app, dc, vs, dataUsuario);
        if(testeLista.vazia()) {
            System.out.println();
            testeLista.mostrar();
        }else
            System.out.println("\nNão foi encontrado equipamento com \nDescricao: "+dc+"\nVersao: "+vs+"\nLicenca: "+lc);
        
    }
    
    public static void subPesquisarSO(Lista<Equipamento> app) throws ParseException {
        Lista<Equipamento> testeLista = new Lista<>();
        String so = Validacao.texto("Informe o Sistema Operativo: ", 2);
        testeLista = Pesquisa.pesquisaSO(app, so);
        if(testeLista != null)
            testeLista.mostrar();
        else
            System.out.println("Nenhum equipamento com SO: "+so);
         
     }
} 

