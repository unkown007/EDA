package informatica;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import lista.Lista;
import lista.No;
import menu.Menu;
import object.AplicacaoInstalada;
import object.Equipamento;
import object.PlacaRede;

public class Pesquisar {
    private Lista<Equipamento> equipamento = Menu.app;
    
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
        No<Equipamento> app = new No<>();
        
        if(equipamento.vazia())
            return null;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                if(app.ob.getApp().getNo(i).ob.getDescricao().equalsIgnoreCase(descricao)) 
                    if(app.ob.getApp().getNo(i).ob.getVersao().equalsIgnoreCase(versao))
                        if(app.ob.getApp().getNo(i).ob.getValidade().compareTo(licenca) == 0)
                            equipApp.inserir(equipamento.getNo(i).ob);
            }
        }
        return equipApp;
    } 
    
    public Lista<Equipamento> equipMesmaRede(String broadcast) throws ParseException{
        Lista<Equipamento> equipMesmaRede = new Lista<>();
        No<Equipamento> rede = new No<>();
        
        if(equipamento.vazia())
            return null;
        
        for(int i = 1; i <= equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                if(rede.ob.getRede().getNo(i).ob.getEnderecoBroadcast().equals(broadcast))
                    equipMesmaRede.inserir(equipamento.getNo(i).ob);
            }
        }
        
        return equipMesmaRede;
    } 
}
