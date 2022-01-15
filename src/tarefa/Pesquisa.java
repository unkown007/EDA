package tarefa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import lista.Lista;
import lista.No;
import object.*;
import validacao.Validacao;

public class Pesquisa {
    private static SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void comunicarDoisEquipa(Lista<Equipamento> equipamento) throws ParseException{
        No<Equipamento> no1, no2;
        No<PlacaRede> aux1, aux2;
        boolean status = false;
        int id, i, j;
        
        if(equipamento.vazia())
            return;
        
        System.out.println();
        equipamento.mostrar();
        
        System.out.println();
        do {
            id =(int) Validacao.num("ID(equipamento 1): ", 1, 99999);
            no1 = equipamento.getNo(id);
            if(no1 == null)
                System.out.println("Equipamento nao encontrado!!!");
        }while(no1 == null);
        
        System.out.println();
        do {
            id =(int) Validacao.num("ID(equipamento 2): ", 1, 99999);
            no2 = equipamento.getNo(id);
            if(no2 == null)
                System.out.println("Equipamento nao encontrado!!!");
        }while(no2 == null);
        
        i = 1;
        while(no1.ob.getRede().getNo(i) != null) {
            aux1 = no1.ob.getRede().getNo(i);
            j = 1;
            while(no2.ob.getRede().getNo(j) != null) {
                aux2 = no2.ob.getRede().getNo(j);
                if(aux1.ob.getEnderecoBroadcast().equals(aux2.ob.getEnderecoBroadcast())&&
                   aux1.ob.getMascaraRede().equals(aux2.ob.getMascaraRede()))
                    status = true;
                j++;
            }
            i++;
        }
        
        System.out.println();
        if(status)
            System.out.println("Podem comunicar");
        else
            System.out.println("Não podem comunicar");
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
    
    public static Lista<Equipamento> pesquisaDaApp(Lista<Equipamento> equipamento, String descricao, String versao, Date licenca){
        Lista<Equipamento> equipApp = new Lista<>();
        No<AplicacaoInstalada> no;
        Lista<AplicacaoInstalada> app;
        
        int i,j;
        
        if(equipamento.vazia())
            return null;
        
        i=1;
        while(equipamento.getNo(i) != null) {
            j=1;
            app = equipamento.getNo(i).ob.getApp();
            while(app.getNo(j) != null) {
                no = app.getNo(j);
                if(no.ob.getDescricao().equals(descricao)&&
                    no.ob.getVersao().equals(versao)&&
                    no.ob.getValidade().equals(licenca))
                    equipApp.inserir(equipamento.getNo(i).ob);
                j++;
            }
            i++;
        }
        
        return equipApp;
    }
    
    public static void conflitoRede(Lista<Equipamento> equipamento){
        No<Equipamento> aux1, aux2;
        No<PlacaRede> p1, p2;
        int i=1,j,k,w;
        boolean st;
        
        if(equipamento.vazia())
            return;
        
        st = false;
        while(equipamento.getNo(i) != null) {
            aux1 = equipamento.getNo(i);
            j=i+1;
            k=1;
            while(aux1.ob.getRede().getNo(k) != null) {
                p1 = aux1.ob.getRede().getNo(k);
                while(equipamento.getNo(j) != null) {
                    aux2 = equipamento.getNo(j);
                    w = 1;
                    while(aux2.ob.getRede().getNo(w) != null) {
                        p2 = aux2.ob.getRede().getNo(w);
                        if(p1.ob.getEnderecoIP().equals(p2.ob.getEnderecoIP())&&
                            p1.ob.getEnderecoBroadcast().equals(p2.ob.getEnderecoBroadcast())&&
                            p1.ob.getMascaraRede().equals(p2.ob.getMascaraRede())) {
                            st = true;
                        }
                        w++;
                    }
                    j++;
                }
                k++;
            }
            i++;
        }
        
        if(st) {
            System.out.println("\nConflitos na Rede\n");
        }else {
            System.out.println("\nNao ha conflitos na Rede\n");
        }
    }
    
    public static Lista<Equipamento> equipMesmaRede(Lista<Equipamento> equipamento) throws ParseException{
        Lista<Equipamento> equipMesmaRede = new Lista<>();
        No<PlacaRede> no;
        Lista<PlacaRede> rede;
        
        int i, j;
        
        if(equipamento.vazia())
            return null;
        
        System.out.println("\nInformacoes basicas da rede:");
        String mascara = Validacao.texto("Mascara: ",2);
        String broadcast = Validacao.texto("BroadCast: ",2);
        
        i=1;
        while(equipamento.getNo(i) != null) {
            j=1;
            rede = equipamento.getNo(i).ob.getRede();
            while(rede.getNo(j) != null) {
                no = rede.getNo(j);
                if(no.ob.getEnderecoBroadcast().equals(broadcast)&&
                    no.ob.getMascaraRede().equals(mascara))
                    equipMesmaRede.inserir(equipamento.getNo(i).ob);
                j++;
            }
            i++;
        }
        
        return equipMesmaRede;
    }
    
    public static Lista<Equipamento> garantiaExpirada(Lista<Equipamento> equipamento) throws ParseException{
        Lista<Equipamento> equipGarantia = new Lista<>();
        GregorianCalendar gc = new GregorianCalendar();
        Date dataUsuario = dataFormatada.parse(dataFormatada.format(gc.getTime())); //pega a data atual
        
        if(equipamento.vazia())
            return null;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                if(dataUsuario.after(equipamento.getNo(i).ob.getGarantiaData())) {//Verifica se a data atual e superior que de garamtia
                    equipGarantia.inserir(equipamento.getNo(i).ob);
                }
            }
        }
        
        return equipGarantia;
    }
    
    public static Lista<AplicacaoInstalada> lincencaExpirada(Lista<Equipamento> equipamento) throws ParseException{
        Lista<AplicacaoInstalada> appLicenca = new Lista<>();
        No<Equipamento> api;
        GregorianCalendar gc = new GregorianCalendar();
        Date dataUsuario = dataFormatada.parse(dataFormatada.format(gc.getTime())); //pega a data atual
        
        if(equipamento.vazia())
            return null;
     
        int i = 1;
        int j;
        
        while(equipamento.getNo(i) != null){
            api = equipamento.getNo(i);
            j=1;
            
            while(api.ob.getApp().getNo(j)!=null){
                if(dataUsuario.after(api.ob.getApp().getNo(j).ob.getValidade())) //Verifica se a data atual e superior que da validade
                    appLicenca.inserir(api.ob.getApp().getNo(j).ob);
                j++;
            }
            i++;
        }
        
        return appLicenca;
    }
}
