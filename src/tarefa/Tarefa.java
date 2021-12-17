package tarefa;

import java.io.IOException;
import object.*;
import lista.*;
import validacao.Validacao;
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
        Lista<AplicacaoInstalada> app = new Lista<AplicacaoInstalada>();
        addAppInstaladas(app);
        
        //add placas de rede
        Lista<PlacaRede> placa = new Lista<PlacaRede>();
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
}
