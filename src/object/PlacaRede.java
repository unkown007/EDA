package object;

public class PlacaRede {
    private String enderecoIP;
    private String mascaraRede;
    private String enderecoBroadcast;
    
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

    public String toString() {
        return "Placa de Rede:" + "\nEndereco de IP:\t" + enderecoIP 
        + "\nMascara de Rede:\t" + mascaraRede + "\nEndereco Broadcast:\t" + enderecoBroadcast;
    }
    
    
}
