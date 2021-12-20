package informatica;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import lista.Lista;
import lista.No;
import object.AplicacaoInstalada;
import object.Equipamento;
import object.PlacaRede;

public class Pesquisar {
    private Lista<Equipamento> equipamento = Informatica.app;
    
    public Pesquisar(){}
    
    public Lista<Equipamento> pesquisaSO(String so) throws ParseException{
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
    
    public Lista<Equipamento> pesquisaDadaApp(String descricao, String versao, Date licenca){
        Lista<Equipamento> equipApp = new Lista<>();
        Lista<AplicacaoInstalada> app = new Lista<>();
        
        if(equipamento.vazia())
            return null;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                if(app.getNo(i).ob.getDescricao().equalsIgnoreCase(descricao)) 
                    if(app.getNo(i).ob.getVersao().equalsIgnoreCase(versao))
                        if(app.getNo(i).ob.getValidade().compareTo(licenca) == 0)
                            equipApp.inserir(equipamento.getNo(i).ob);
            }
        }
        return equipApp;
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
}
