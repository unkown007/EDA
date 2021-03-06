package object;

import java.io.Serializable;

public class PlacaRede implements Table, Serializable {
    private String enderecoIP;
    private String mascaraRede;
    private String enderecoBroadcast;
    private String format = "%-20s %-20s %-20s %-20s";
    
    public PlacaRede(String enderecoIP, String mascaraRede, String enderecoBroadcast) {
        this.enderecoIP = enderecoIP;
        this.mascaraRede = mascaraRede;
        this.enderecoBroadcast = enderecoBroadcast;
    }
    
    //METODOS GETTERS
    public String getEnderecoIP() {
        return enderecoIP;
    }
    public String getMascaraRede() {
        return mascaraRede;
    }
    public String getEnderecoBroadcast() {
        return enderecoBroadcast;
    }
    
    //METODOS SETTERS
    public void setEnderecoIP(String enderecoIP) {
        this.enderecoIP = enderecoIP;
    }
    public void setMascaraRede(String mascaraRede) {
        this.mascaraRede = mascaraRede;
    }
    public void setEnderecoBroadcast(String enderecoBroadcast) {
        this.enderecoBroadcast = enderecoBroadcast;
    }
    
    public void tableHeader(){
        System.out.println(String.format(format,"ID","IP","Mascara","BroadCast"));
    }
    
    public String toString(int id) {
        return String.format(format, id, this.enderecoIP, this.mascaraRede, this.enderecoBroadcast);
    }
    
    
}
