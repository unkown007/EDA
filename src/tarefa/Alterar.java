package tarefa;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import lista.Lista;
import lista.No;
import object.*;
import static tarefa.Tarefa.cudAppInstalada;
import static tarefa.Tarefa.cudPlacaRede;
import validacao.Validacao;

public class Alterar {
    private static SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void alterarEquipamento(Lista<Equipamento> lista) throws IOException, ParseException {
        int pos;
        No<Equipamento> no;
        Lista<AplicacaoInstalada> app;
        Lista<PlacaRede> rede;
        
        pos = (int)Validacao.num("ID: ", 1, 99999);
        
        no = lista.getNo(pos);
        app = no.ob.getApp();
        rede = no.ob.getRede();
        
        var dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        String dataAquisicao = Validacao.texto("Data de aquisicao: ",2);
        var dataUsuario = dataFormatada.parse(dataAquisicao);
        byte garantia =(byte) Validacao.num("Grantia(mes): ", 0, 130);
        int discoDuro = (int)Validacao.num("Capacidade(GB): ", 1, 99999);
        float cpu = (float)Validacao.num("CPU(Ghz): ", 1, 10);
        byte ram =(byte) Validacao.num("Memoria(GB): ", 1, 1000);
        String so = Validacao.texto("Sistema Operativo: ",2);
        
        System.out.println("Aplicacoes Instaladas\n");
        cudAppInstalada(app);
        
        System.out.println("Placas de Rede\n");
        cudPlacaRede(rede);
        
        no.ob.setDataAquisicao(dataUsuario);
        no.ob.setGarantia(garantia);
        no.ob.setDiscoDuro(discoDuro);
        no.ob.setCPU(cpu);
        no.ob.setRAM(ram);
        no.ob.setSistemaOperacinal(so);
        no.ob.setApp(app);
        no.ob.setRede(rede);
        
        lista.actualizar(pos, no);
    }
    
    public static void alterarAppInstaladas(Lista<AplicacaoInstalada> lista) throws IOException, ParseException {   
        int pos;
        
        System.out.println();
        pos = (int)Validacao.num("ID(Aplicacao Instalada): ", 1, 99999);
        
        No<AplicacaoInstalada> no =  lista.getNo(pos);
        
        if(no == null) {
            System.out.println("Aplicacao nao encontrada!\n");
            return;
        }

        //var dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Nova Informacao\n");
        String desc = Validacao.texto("Descricao: ", 2);
        String versao = Validacao.texto("Versao: ", 2);
        String validade = Validacao.texto("Validade (dd/mm/yyyy): ",10);
        var dataUsuario = dataFormatada.parse(validade);
        
        no.ob.setDescricao(desc);
        no.ob.setVersao(versao);
        no.ob.setValidade(dataUsuario);
    }
    
    public static void alterarPlacaRede(Lista<PlacaRede> lista) throws IOException {
        int pos;
        
        System.out.println();
        pos = (int)Validacao.num("ID(Placa de Rede): ", 1, 99999);
        
        No<PlacaRede> no = lista.getNo(pos);
        
        if(no == null) {
            System.out.println("Placa de rede nao encontrada!");
            return;
        }
        
        String ip = Validacao.texto("IP: ",2);
        String mascara = Validacao.texto("Mascara: ",2);
        String broadcast = Validacao.texto("BroadCast: ",2);
        
        no.ob.setEnderecoIP(ip);
        no.ob.setMascaraRede(mascara);
        no.ob.setEnderecoBroadcast(broadcast);
    }
    
    public static void alterAppIns(Lista<Equipamento> app) throws IOException, ParseException {
        No<Equipamento> tmp;
        
        System.out.println();
        app.mostrar();
        
        System.out.println("\nALTERAR APLICACOES INSTALADAS\n");
        int id1 =(int) Validacao.num("ID(equipamento): ", 1, 99999);
        
        tmp = app.getNo(id1);
        
        if(tmp == null) {
            System.out.println("Equipamento nao encontrado\n");
            return;
        }
        
        System.out.println();
        tmp.ob.getApp().mostrar();
        
        alterarAppInstaladas(tmp.ob.getApp());
    }
    
    public static void alterPlaca(Lista<Equipamento> app) throws IOException {
        No<Equipamento> tmp;
        
        System.out.println();
        app.mostrar();
        
        System.out.println("\nALTERAR PLACAS DE REDE\n");
        int id1 =(int) Validacao.num("ID(equipamento): ", 1, 99999);
        
        tmp = app.getNo(id1);
        
        if(tmp == null) {
            System.out.println("Equipamento nao encontrado\n");
            return;
        }
        
        System.out.println();
        tmp.ob.getRede().mostrar();
        
        alterarPlacaRede(tmp.ob.getRede());
    }
}
