package object;

import java.io.Serializable;
import static java.lang.System.gc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import lista.*;

public class Equipamento implements Table, Serializable {
    private SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    GregorianCalendar gc = new GregorianCalendar();
    private Date dataAquisicao, garantiaData;
    private byte garantia;
    private int discoDuro;
    private float CPU;
    private byte RAM;
    private String sistemaOperacinal;
    private Lista<AplicacaoInstalada> app;
    private Lista<PlacaRede> rede;
    private String format = "%-20s %-20s %-20s %-20s %-20s %-20s %-20s";
     
    public Equipamento(Date dataAquisicao, byte garantia, int discoDuro,
                       float CPU, byte RAM, String sistemaOperacinal,
                       Lista<AplicacaoInstalada> app,
                       Lista<PlacaRede> rede) throws ParseException {
        this.dataAquisicao = dataAquisicao;
        gc.setTime(dataAquisicao);
        gc.add(gc.MONTH, garantia);
        this.garantiaData = dataFormatada.parse(dataFormatada.format(gc.getTime()));
        this.garantia = garantia;
        this.discoDuro = discoDuro;
        this.CPU = CPU;
        this.RAM = RAM;
        this.sistemaOperacinal = sistemaOperacinal;
        this.app = app;
        this.rede = rede;
    }

    public Date getGarantiaData() {
        return garantiaData;
    }

    public void setGarantiaData(Date garantiaData) {
        this.garantiaData = garantiaData;
    }
    
    public static <T extends Lista> void verlista(T ob) {
        ob.mostrar();
    }
    
    //METODOS GETTERS

    public Date getDataAquisicao() {
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

    public Lista<AplicacaoInstalada> getApp() {
        return app;
    }

    public Lista<PlacaRede> getRede() {
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
    
    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public void setCPU(float CPU) {
        this.CPU = CPU;
    }

    public void setRAM(byte RAM) {
        this.RAM = RAM;
    }

    public void setApp(Lista<AplicacaoInstalada> app) {
        this.app = app;
    }
    
    public void setRede(Lista<PlacaRede> rede) {
        this.rede = rede;
    }

    public void tableHeader(){
        System.out.println(String.format(format,"ID","Data de Aquisicao","Garantia",
                                                 "Capacidade(GB)","CPU(Ghz)",
                                                 "Memoria(GB)","Sistema Operativo"));
    }
    
    public String toString(int id) {
        return String.format(format, id, dataFormatada.format(dataAquisicao), this.garantia, this.discoDuro, this.CPU, this.RAM, this.sistemaOperacinal);
    }
}