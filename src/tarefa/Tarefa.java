package tarefa;

import informatica.Informatica;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import object.*;
import lista.*;
import menu.Menu;
import validacao.Validacao;

public class Tarefa {
    private static SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void addEquipamento(Lista<Equipamento> lista) throws IOException, ParseException {
        //var dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Equipamento\n");
        String dataAquisicao = Validacao.texto("Data de aquisicao (dd/mm/yyyy): ");
        var dataUsuario = dataFormatada.parse(dataAquisicao);
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
        
        Equipamento eq = new Equipamento(dataUsuario, garantia,
                                         discoDuro, cpu, ram,
                                         so, app, placa);
        lista.inserir(eq);
    }
    
    public static void removerEquipamento(Lista<Equipamento> lista) throws IOException {
        int pos;
        
        pos = Validacao.inteiro("ID: ", 1, 99999);
        
        lista.remover(pos);
    }
    
    public static void alterarEquipamento(Lista<Equipamento> lista) throws IOException, ParseException {
        int pos;
        No<Equipamento> no;
        Lista<AplicacaoInstalada> app;
        Lista<PlacaRede> rede;
        
        pos = Validacao.inteiro("ID: ", 1, 99999);
        
        no = lista.getNo(pos);
        app = no.ob.getApp();
        rede = no.ob.getRede();
        
        var dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        String dataAquisicao = Validacao.texto("Data de aquisicao: ");
        var dataUsuario = dataFormatada.parse(dataAquisicao);
        byte garantia =(byte) Validacao.inteiro("Grantia(mes): ", 0, 130);
        int discoDuro = Validacao.inteiro("Capacidade(GB): ", 1, 99999);
        float cpu = Validacao.real("CPU(Ghz): ", 1.0f, 10f);
        byte ram =(byte) Validacao.inteiro("Memoria(GB): ", 1, 1000);
        String so = Validacao.texto("Sistema Operativo: ");
        
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
    
    public static void addAppInstaladas(Lista<AplicacaoInstalada> lista) throws IOException, ParseException {
        boolean st = true;
        byte op;
        GregorianCalendar gc = new GregorianCalendar();
        while(st) {
            //var dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            String desc = Validacao.texto("Descricao: ");
            String versao = Validacao.texto("Versao: ");
            byte validade = (byte)Validacao.inteiro("Validade [1 - 30 dias]: ",1,999);
            
            gc.add(gc.MONTH, validade); // pega a data atual do calendario e acrecenta somente o mes
                                        //conforme o numero de validade, mantendo o dia da semana 
                                        
            var dataUsuario = dataFormatada.parse(dataFormatada.format(gc.getTime()));
            
            AplicacaoInstalada tmp = new AplicacaoInstalada(desc,versao,dataUsuario);
            
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
    
    public static void alterarAppInstaladas(Lista<AplicacaoInstalada> lista) throws IOException, ParseException {
        int pos;
        
        pos = Validacao.inteiro("ID: ", 1, 99999);
        
        No<AplicacaoInstalada> no = lista.getNo(pos);
        
        //var dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Nova Informacao\n");
        String desc = Validacao.texto("Descricao: ");
        String versao = Validacao.texto("Versao: ");
        String validade = Validacao.texto("Validade (dd/mm/yyyy): ");
        var dataUsuario = dataFormatada.parse(validade);
        
        no.ob.setDescricao(desc);
        no.ob.setVersao(versao);
        no.ob.setValidade(dataUsuario);
        
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
    
    public static void cudPlacaRede(Lista<PlacaRede> lista) throws IOException {
        byte op;
        
        do {
            System.out.println("1. Inserir");
            System.out.println("2. Remover");
            System.out.println("3. Actualizar");
            System.out.println("0. Voltar");
            op =(byte) Validacao.inteiro("Opcao: ", 0, 3);
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
            op =(byte) Validacao.inteiro("Opcao: ", 0, 3);
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
    
    public static Lista<Equipamento> lincencaExpirada(Lista<Equipamento> equipamento) throws ParseException{
        Lista<Equipamento> equipLicenca = new Lista<>();
        No<Equipamento> api = new No<>();
        GregorianCalendar gc = new GregorianCalendar();
        Date dataUsuario = dataFormatada.parse(dataFormatada.format(gc.getTime())); //pega a data atual
        
        if(equipamento.vazia())
            return null;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                if(api.ob.getApp().vazia())
                    return null;
                if(dataUsuario.after(api.ob.getApp().getNo(i).ob.getValidade())) //Verifica se a data atual e superior que da validade
                    equipLicenca.inserir(equipamento.getNo(i).ob);
            }
        }
        
        return equipLicenca;
    } 
    
    public static Lista<Equipamento> garantiaExpirada(Lista<Equipamento> equipamento) throws ParseException{
        Lista<Equipamento> equipGarantia = new Lista<>();
        GregorianCalendar gc = new GregorianCalendar();
        Date dataUsuario = dataFormatada.parse(dataFormatada.format(gc.getTime())); //pega a data atual
        
        if(equipamento.vazia())
            return null;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                if(dataUsuario.after(equipamento.getNo(i).ob.getGarantiaData())) //Verifica se a data atual e superior que de garamtia
                    equipGarantia.inserir(equipamento.getNo(i).ob);
            }
        }
        
        return equipGarantia;
    } 
    
    public static Lista<Equipamento> equipMesmaRede(Lista<Equipamento> equipamento, String broadcast) throws ParseException{
        Lista<Equipamento> equipMesmaRede = new Lista<>();
        No<Equipamento> rede = new No<>();
      
        if(equipamento.vazia())
            return null;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                 for(int j = 1; j <= rede.ob.getRede().quantidade(); j++){
                    if(rede.ob.getRede().getNo(j) != null){
                        if(rede.ob.getRede().getNo(j).ob.getEnderecoBroadcast().equals(broadcast))
                            equipMesmaRede.inserir(equipamento.getNo(i).ob);
                    }
                 }
            }
        }
        
        return equipMesmaRede;
    } 
    
    public static void conflitoRede(Lista<Equipamento> equipamento, String enderecoIp){
        Lista<PlacaRede> rede = new Lista<>();
        if(equipamento.vazia())
            return;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                if(rede.getNo(i).ob.getEnderecoIP().equals(enderecoIp))
                    System.out.println("Conflito");
            }
        }
    }
    
    public static Lista<Equipamento> pesquisaSO(Lista<Equipamento> equipamento, String so) throws ParseException{
        Lista<Equipamento> equipSo = new Lista<>();
    
        if(equipamento.vazia())
            return null;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                if(equipamento.getNo(i).ob.getSistemaOperacinal().equals(so)) 
                    equipSo.inserir(equipamento.getNo(i).ob);
            }
        }
        return equipSo;
    } 
    
    public static Lista<Equipamento> pesquisaDadaApp(Lista<Equipamento> equipamento, String descricao, String versao, Date licenca){
        Lista<Equipamento> equipApp = new Lista<>();
        No<Equipamento> app = new No<>();
        
        if(equipamento.vazia())
            return null;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                for(int j = 1; j <= app.ob.getApp().quantidade(); j++){
                    if(app.ob.getApp().getNo(j) != null){
                        if(app.ob.getApp().getNo(j).ob.getDescricao().equalsIgnoreCase(descricao)) 
                            if(app.ob.getApp().getNo(j).ob.getVersao().equalsIgnoreCase(versao))
                                if(app.ob.getApp().getNo(j).ob.getValidade().compareTo(licenca) == 0)
                                    equipApp.inserir(equipamento.getNo(i).ob);
                    }
                }
            }
        }
        return equipApp;
    } 
    
    public static boolean comunicarDoisEquipa(Lista<Equipamento> equipamento1, Lista<Equipamento> equipamento2) throws ParseException{
        Lista<Equipamento> equipMesmaRede = new Lista<>();
        No<Equipamento> rede = new No<>();
        
        if(equipamento1.vazia() || equipamento2.vazia())
            return false;
        
        for(int i = 1; i <= equipamento1.quantidade(); i++){
            if(equipamento1.getNo(i) != null){
                for(int j = 1; j <= equipamento2.quantidade(); j++){
                    if(equipamento2.getNo(i) != null){
                        if(rede.ob.getRede().getNo(i).ob.getEnderecoBroadcast().equals(rede.ob.getRede().getNo(j).ob.getEnderecoBroadcast())){
                            System.out.println("Podem se comunicar");
                            break;
                        }
                    }
                }
            }
        }
        
        return true;
    } 
}
