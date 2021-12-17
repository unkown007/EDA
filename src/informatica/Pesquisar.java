
package informatica;

import java.util.Vector;
import lista.Lista;
import lista.No;
import object.Equipamento;

public class Pesquisar {
    private Lista<Equipamento> equipamento = new Lista<>();
    
    public Vector pesquisaSO(String soPesquisa){
        Vector vect = new Vector();
        if(equipamento.vazia())
            return new Vector();
        
        for(int i = 0; i < equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                if(equipamento.getNo(i).ob.getSistemaOperacinal().equals(soPesquisa))
                    vect.addElement(equipamento.getNo(i));
            }
        }
        return vect;
    }
    
    public void appD(String designacao){
        //Wait de metodos equipamentos
    }
    
    public void appV(String versao){
        //Wait de metodos equipamentos
    }
    
    public void appVL(String validaLicenca){
        //Wait de metodos equipamentos
    }
}
