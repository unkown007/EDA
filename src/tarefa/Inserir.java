package tarefa;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import lista.*;
import object.*;
import validacao.Validacao;

public class Inserir {
    private static SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void addEquipamento(Lista<Equipamento> lista) throws IOException, ParseException {
        //var dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("\nEQUIPAMENTO\n");
        String dataAquisicao = Validacao.texto("Data de aquisicao (dd/mm/yyyy): ", 2);
        var dataUsuario = dataFormatada.parse(dataAquisicao);
        byte garantia =(byte) Validacao.num("Grantia(mes): ", 0, 130);
        int discoDuro = (int)Validacao.num("Capacidade(GB): ", 1, 99999);
        float cpu = (float)Validacao.num("CPU(Ghz): ", 1, 10);
        byte ram =(byte) Validacao.num("Memoria(GB): ", 1, 1000);
        String so = Validacao.texto("Sistema Operativo: ",2);
        
        // add aplicacoes instaladas
        System.out.println("\nAPP INSTALADAS\n");
        var app = new Lista<AplicacaoInstalada>();
        addAppInstaladas(app);
        
        //add placas de rede
        System.out.println("\nPLACAS DE REDE\n");
        var placa = new Lista<PlacaRede>();
        addPlacaRede(placa);
        
        Equipamento eq = new Equipamento(dataUsuario, garantia,
                                         discoDuro, cpu, ram,
                                         so, app, placa);
        lista.inserir(eq);
    }
    
    public static void addAppInstaladas(Lista<AplicacaoInstalada> lista) throws IOException, ParseException {
        boolean st = true;
        byte op;
        GregorianCalendar gc = new GregorianCalendar();
        while(st) {
            //var dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            String desc = Validacao.texto("Descricao: ",2);
            String versao = Validacao.texto("Versao: ",2);
            byte validade = (byte)Validacao.num("Validade [1(Mes)]: ",1,999);
            
            gc.add(gc.MONTH, validade); // pega a data atual do calendario e acrecenta somente o mes
                                        //conforme o numero de validade, mantendo o dia da semana 
                                        
            var dataUsuario = dataFormatada.parse(dataFormatada.format(gc.getTime()));
            
            AplicacaoInstalada tmp = new AplicacaoInstalada(desc,versao,dataUsuario);
            
            lista.inserir(tmp);
            op =(byte) Validacao.num("Continuar a inserir?\n1. Sim\n2. Nao\nOpcao: ",
                                          1, 2);
            if(op == 2) st = false;
        }
    }
    
    public static void addPlacaRede(Lista<PlacaRede> lista) throws IOException {
        boolean st = true;
        byte op;
        
        while(st) {
            String ip = Validacao.texto("IP: ",2);
            String mascara = Validacao.texto("Mascara: ",2);
            String broadcast = Validacao.texto("BroadCast: ",2);
            PlacaRede placa = new PlacaRede(ip,mascara,broadcast);
            lista.inserir(placa);
            op =(byte) Validacao.num("Continuar a inserir?\n1. Sim\n2. Nao\nOpcao: ",
                                          1, 2);
            if(op == 2) st = false;
        }
    }
    
    public static void incPlacaRede(Lista<Equipamento> app) throws IOException {
        No<Equipamento> tmp;
        
        System.out.println();
        app.mostrar();
        
        System.out.println("\nADICIONAR NOVAS PLACAS DE REDE\n");
        int id1 =(int) Validacao.num("ID(equipamento): ", 1, 99999);
        
        tmp = app.getNo(id1);
        
        if(tmp == null) {
            System.out.println("Equipamento nao encontrado\n");
            return;
        }
        
        System.out.println();
        
        addPlacaRede(tmp.ob.getRede());
    }
    
    public static void incAppInstaladas(Lista<Equipamento> app) throws IOException, ParseException {
        No<Equipamento> tmp;
        
        System.out.println();
        app.mostrar();
        
        System.out.println("\nADICIONAR NOVAS APLICACOES\n");
        int id1 =(int) Validacao.num("ID(equipamento): ", 1, 99999);
        
        tmp = app.getNo(id1);
        
        if(tmp == null) {
            System.out.println("Equipamento nao encontrado\n");
            return;
        }
        
        System.out.println();
        
        addAppInstaladas(tmp.ob.getApp());
    }
    
    
}
