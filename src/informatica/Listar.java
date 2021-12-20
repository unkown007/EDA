
package informatica;

import lista.Lista;
import object.Equipamento;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import object.AplicacaoInstalada;
import object.PlacaRede;

public class Listar {
    private Lista<Equipamento> equipamento = Informatica.app;
    private SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    private int Ram;
    private double Hd;
    private double Mips;
    
    public int getTotalRam(){
        if(equipamento.vazia())
            return 0;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                Ram += equipamento.getNo(i).ob.getRAM();
            }
        }
        return Ram;
    }
    
    public double getTotalHd(){
        if(equipamento.vazia())
            return 0.0f;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                Hd += equipamento.getNo(i).ob.getDiscoDuro();
            }
        }
        return Hd;
    }
    
    public double getTotalMips(){
       if(equipamento.vazia())
            return 0.0f;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                Mips += equipamento.getNo(i).ob.getCPU()*1250;
            }
        }
        return Mips;
    } 
    
    public Lista<Equipamento> menorRam(int ram){
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
    
    public Lista<Equipamento> lincencaExpirada() throws ParseException{
        Lista<Equipamento> equipLicenca = new Lista<>();
        Lista<AplicacaoInstalada> api = new Lista<>();
        GregorianCalendar gc = new GregorianCalendar();
        Date dataUsuario = dataFormatada.parse(dataFormatada.format(gc.getTime())); //pega a data atual
        
        if(equipamento.vazia())
            return null;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                if(api.vazia())
                    return null;
                if(dataUsuario.after(api.getNo(i).ob.getValidade())) //Verifica se a data atual e superior que da validade
                    equipLicenca.inserir(equipamento.getNo(i).ob);
            }
        }
        
        return equipLicenca;
    } 
    
    public Lista<Equipamento> garantiaExpirada() throws ParseException{
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
    
    public Lista<Equipamento> equipMesmaRede(String broadcast) throws ParseException{
        Lista<Equipamento> equipMesmaRede = new Lista<>();
        Lista<PlacaRede> rede = new Lista<>();
      
        if(equipamento.vazia())
            return null;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                if(rede.getNo(i).ob.getEnderecoBroadcast().equals(broadcast))
                    equipMesmaRede.inserir(equipamento.getNo(i).ob);
            }
        }
        
        return equipMesmaRede;
    } 
    
    public void conflitoRede(String enderecoIp){
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
    
    public void comunicarMesmaRede(String redeBroad){
        Lista<PlacaRede> rede = new Lista<>();
        if(equipamento.vazia())
            return;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null)
                if(rede.getNo(i).ob.getEnderecoBroadcast().equals(redeBroad))
                    System.out.println("Pode se comunicar");
                    
        }
    }
}
