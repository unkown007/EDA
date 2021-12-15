package informatica;

public class Equipamento {
    private String dataAquisicao;
    private byte garantia;
    private int discoDuro;
    private float CPU;
    private byte RAM;
    private String sistemaOperacinal;
    private AplicacaoInstalada app;
    private PlacaRede rede;

    public Equipamento(String dataAquisicao, byte garantia, int discoDuro, float CPU, byte RAM, String sistemaOperacinal, AplicacaoInstalada app, PlacaRede rede) {
        this.dataAquisicao = dataAquisicao;
        this.garantia = garantia;
        this.discoDuro = discoDuro;
        this.CPU = CPU;
        this.RAM = RAM;
        this.sistemaOperacinal = sistemaOperacinal;
        this.app = app;
        this.rede = rede;
    }
    
    //METODOS GETTERS

    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public byte getGarantia() {
        return garantia;
    }

    public int getDiscoDuro() {
        return discoDuro;
    }

    public float getCPU() {
        return CPU;
    }

    public byte getRAM() {
        return RAM;
    }

    public String getSistemaOperacinal() {
        return sistemaOperacinal;
    }

    public AplicacaoInstalada getApp() {
        return app;
    }

    public PlacaRede getRede() {
        return rede;
    }
    
    //METODOS SETTERS
    public void setGarantia(byte garantia) {
        this.garantia = garantia;
    }
    public void setDiscoDuro(int discoDuro) {
        this.discoDuro = discoDuro;
    }
    public void setSistemaOperacinal(String sistemaOperacinal) {
        this.sistemaOperacinal = sistemaOperacinal;
    }
    
    public void setDataAquisicao(String dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public void setCPU(float CPU) {
        this.CPU = CPU;
    }

    public void setRAM(byte RAM) {
        this.RAM = RAM;
    }

    public void setApp(AplicacaoInstalada app) {
        this.app = app;
    }
    
    public void setRede(PlacaRede rede) {
        this.rede = rede;
    }

    public String toString() {
        return "Equipamento:" + "\nData de duracao:\t" + dataAquisicao + "\nGarantia:\t" + garantia + "\nMemoria do Disco Duro:\t"
        + discoDuro + "\nSistema Operacinal:\t" + sistemaOperacinal;
    }
}
