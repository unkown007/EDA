
package informatica;

import lista.Lista;
import object.Equipamento;

public class Listar {
    private Lista<Equipamento> equipamento = new Lista<>();
    private int Ram;
    private double Hd;
    private double Mips;
    
    public int getTotalRam(){
        if(equipamento.vazia())
            return 0;
        
        for(int i = 0; i < equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                Ram += equipamento.getNo(i).ob.getRAM();
            }
        }
        return Ram;
    }
    
    public double getTotalHd(){
        if(equipamento.vazia())
            return 0.0f;
        
        for(int i = 0; i < equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                Hd += equipamento.getNo(i).ob.getDiscoDuro();
            }
        }
        return Hd;
    }
    
    public double getTotalMips(){
       if(equipamento.vazia())
            return 0.0f;
        
        for(int i = 0; i < equipamento.quantidade(); i++){
            if(equipamento.getNo(i) != null){
                Mips += equipamento.getNo(i).ob.getCPU()*1250;
            }
        }
        return Mips;
    } 
    
    
}
