package tarefa;

import java.io.IOException;
import object.*;
import lista.*;
import validacao.Validacao;

public class Tarefa {
    public static void addEquipamento(Lista<Equipamento> lista) throws IOException {
        String dataAquisicao = Validacao.texto("Data de aquisicao: ");
        byte garantia =(byte) Validacao.inteiro("Grantia(mes): ", 0, 130);
        int discoDuro = Validacao.inteiro("Capacidade(GB): ", 1, 99999);
        float cpu = Validacao.real("CPU(Ghz): ", 1.0f, 10f);
        byte ram =(byte) Validacao.inteiro("Memoria(GB): ", 1, 1000);
        String so = Validacao.texto("Sistema Operativo: ");
        
        // add aplicacoes instaladas
        System.out.println("Aplicacoes Instaladas\n");
        var app = new Lista<AplicacaoInstalada>();
        addAppInstaladas(app);
        
        //add placas de rede
        System.out.println("Placas de Rede\n");
        var placa = new Lista<PlacaRede>();
        addPlacaRede(placa);
        
        Equipamento eq = new Equipamento(dataAquisicao, garantia,
                                         discoDuro, cpu, ram,
                                         so, app, placa);
        lista.inserir(eq);
    }
    
    public static void addAppInstaladas(Lista<AplicacaoInstalada> lista) throws IOException {
        boolean st = true;
        byte op;
        
        while(st) {
            String desc = Validacao.texto("Descricao: ");
            String versao = Validacao.texto("Versao: ");
            String validade = Validacao.texto("Validade: ");
            AplicacaoInstalada tmp = new AplicacaoInstalada(desc,versao,validade);
            lista.inserir(tmp);
            op =(byte) Validacao.inteiro("Continuar a inserir?\n1. Sim\n2. Nao\nOpcao: ",
                                          1, 2);
            if(op == 2) st = false;
        }
    }
    
    public static void rmAppInstaladas(Lista<AplicacaoInstalada> lista) throws IOException {
        int pos;
        
        pos = Validacao.inteiro("ID: ", 1, 99999);
        
        lista.remover(pos);
    }
    
    public static void alterarAppInstaladas(Lista<AplicacaoInstalada> lista) throws IOException {
        int pos;
        
        pos = Validacao.inteiro("ID: ", 1, 99999);
        
        No<AplicacaoInstalada> no = lista.getNo(pos);
        
        System.out.println("Nova Informacao\n");
        String desc = Validacao.texto("Descricao: ");
        String versao = Validacao.texto("Versao: ");
        String validade = Validacao.texto("Validade: ");
        
        no.ob.setDescricao(desc);
        no.ob.setVersao(versao);
        no.ob.setValidade(validade);
        
        lista.actualizar(pos, no);
    }
    
    public static void addPlacaRede(Lista<PlacaRede> lista) throws IOException {
        boolean st = true;
        byte op;
        
        while(st) {
            String ip = Validacao.texto("IP: ");
            String mascara = Validacao.texto("Mascara: ");
            String broadcast = Validacao.texto("BroadCast: ");
            PlacaRede placa = new PlacaRede(ip,mascara,broadcast);
            lista.inserir(placa);
            op =(byte) Validacao.inteiro("Continuar a inserir?\n1. Sim\n2. Nao\nOpcao: ",
                                          1, 2);
            if(op == 2) st = false;
        }
    }
    
    public static void rmPlacaRede(Lista<PlacaRede> lista) throws IOException {
        int pos;
        
        pos = Validacao.inteiro("ID: ", 1, 99999);
        
        lista.remover(pos);
    }
    
    public static void alterarPlacaRede(Lista<PlacaRede> lista) throws IOException {
        int pos;
        
        pos = Validacao.inteiro("ID: ", 1, 99999);
        
        No<PlacaRede> no = lista.getNo(pos);
        String ip = Validacao.texto("IP: ");
        String mascara = Validacao.texto("Mascara: ");
        String broadcast = Validacao.texto("BroadCast: ");
        
        no.ob.setEnderecoIP(ip);
        no.ob.setMascaraRede(mascara);
        no.ob.setEnderecoBroadcast(broadcast);
        
        lista.actualizar(pos, no);
    }
     
    public static void removerEquipamento(Lista<Equipamento> lista) throws IOException {
        int pos;
        
        pos = Validacao.inteiro("ID: ", 1, 99999);
        
        lista.remover(pos);
    }
    
    public static void alterarEquipamento(Lista<Equipamento> lista) throws IOException {
        int pos;
        No<Equipamento> no;
        
        pos = Validacao.inteiro("ID: ", 1, 99999);
        
        no = lista.getNo(pos);
        
        String dataAquisicao = Validacao.texto("Data de aquisicao: ");
        byte garantia =(byte) Validacao.inteiro("Grantia(mes): ", 0, 130);
        int discoDuro = Validacao.inteiro("Capacidade(GB): ", 1, 99999);
        float cpu = Validacao.real("CPU(Ghz): ", 1.0f, 10f);
        byte ram =(byte) Validacao.inteiro("Memoria(GB): ", 1, 1000);
        String so = Validacao.texto("Sistema Operativo: ");
        
        System.out.println("Aplicacoes Instaladas\n");
        
    }
}
