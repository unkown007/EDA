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
    
    public static Lista<Equipamento> lincencaExpirada(Lista<Equipamento> equipamento) throws ParseException{
        Lista<Equipamento> equipLicenca = new Lista<>();
        No<Equipamento> api;
        GregorianCalendar gc = new GregorianCalendar();
        Date dataUsuario = dataFormatada.parse(dataFormatada.format(gc.getTime())); //pega a data atual
        
        if(equipamento.vazia())
            return null;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                api = equipamento.getNo(i);
                if(api.ob.getApp().vazia())
                    return null;
                if(dataUsuario.after(api.ob.getApp().getNo(i).ob.getValidade())) //Verifica se a data atual e superior que da validade
                    equipLicenca.inserir(equipamento.getNo(i).ob);
            }
        }
        
        return equipLicenca;
    } 
    
    public static Lista<Equipamento> garantiaExpirada(Lista<Equipamento> equipamento) throws ParseException{
        Lista<Equipamento> equipGarantia = null;
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
        
        if(equipGarantia == null){
            System.out.println("Garantia nao expirada");
            return new Lista<>();
        }
        return equipGarantia;
    } 
    
    public static Lista<Equipamento> equipMesmaRede(Lista<Equipamento> equipamento) throws ParseException{
        Lista<Equipamento> equipMesmaRede = new Lista<>();
        No<Equipamento> redes1;
        Lista<PlacaRede> rede1;
      
        if(equipamento.vazia())
            return null;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                redes1 = equipamento.getNo(i);
                for(int j = 1; j <= redes1.ob.getRede().quantidade(); j++){
                    if(equipamento.getNo(j) != null){
                        //redes2 = equipamento.getNo(j);
                        for(int k = j + 1; k <= redes1.ob.getRede().quantidade(); k++){
                            rede1 = equipamento.getNo(j).ob.getRede();
                            //rede2 = equipamento.getNo(k).ob.getRede();
                            if(rede1.getNo(j).ob.getEnderecoBroadcast().equals(rede1.getNo(k).ob.getEnderecoBroadcast()))
                                equipMesmaRede.inserir(equipamento.getNo(i).ob);
                        }
                    }
                }
            }
        }
        /*
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                 for(int j = 1; j <= redes1.ob.getRede().quantidade(); j++){
                    if(redes1.ob.getRede().getNo(j) != null){
                        for(int k = 1; k <= redes2.ob.getRede().quantidade(); k++){
                            if(redes2.ob.getRede().getNo(k) != null){
                                if(rede1.getNo(i).ob.getEnderecoBroadcast().equals(rede1.getNo(j).ob.getEnderecoBroadcast())
                                        && rede1.getNo(j).ob.getEnderecoBroadcast().equals(rede2.getNo(k).ob.getEnderecoBroadcast()))
                                    equipMesmaRede.inserir(equipamento.getNo(i).ob);
                            }
                        }
                    }
                 }
            }
        }
        */
        return equipMesmaRede;
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
        No<Equipamento> app;
        
        if(equipamento.vazia())
            return null;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                app = equipamento.getNo(i);
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
    
    public static void comunicarDoisEquipa(Lista<Equipamento> equipamento) throws ParseException{
        No<Equipamento> redes1;
        Lista<PlacaRede> rede1;
        boolean status = false;
        if(equipamento.vazia())
            return;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                redes1 = equipamento.getNo(i);
                for(int j = 1; j <= redes1.ob.getRede().quantidade(); j++){
                    if(equipamento.getNo(j) != null){
                        for(int k = j + 1; k <= redes1.ob.getRede().quantidade(); k++){
                            rede1 = equipamento.getNo(j).ob.getRede();
                            if(rede1.getNo(j).ob.getEnderecoBroadcast().equals(rede1.getNo(k).ob.getEnderecoBroadcast()))
                                status = true;
                        }
                    }
                }
            }
        }
        
        if(status)
            System.out.println("Podem comunicar");
        else
            System.out.println("Não podem comunicar");
        /*
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                rede1 = equipamento.getNo(i);
                for(int j = i + 1; j <= rede1.ob.getRede().quantidade(); j++){
                    if(equipamento.getNo(j) != null){
                        rede2 = equipamento.getNo(j);
                            if(rede1.ob.getRede().getNo(i).ob.getEnderecoBroadcast().equals(rede2.ob.getRede().getNo(j).ob.getEnderecoBroadcast())){
                                System.out.println("\nPodem se comunicar");
                                break;
                            }
                        }
                    }
                }
            }*/
     }
} 

