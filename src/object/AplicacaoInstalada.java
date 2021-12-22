package object;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author vm
 */
public class AplicacaoInstalada implements Table {
    private SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    private String descricao;
    private String versao;
    private Date validade;
    private String format = "%-20s %-40s %-20s %-20s";
    
    public AplicacaoInstalada(String descricao, String versao, Date validade) {
        this.descricao = descricao;
        this.versao = versao;
        this.validade = validade;
    }
    //METODOS GETTERS
    public String getDescricao() {
        return descricao;
    }
    public String getVersao() {
        return versao;
    }
    public Date getValidade() {
        return validade;
    }
    
    //METODOS SETTERS
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setVersao(String versao) {
        this.versao = versao;
    }
    public void setValidade(Date validade) {
        this.validade = validade;
    }
    
    public void tableHeader(){
        System.out.println(String.format(format,"ID","Descricao","Versao","Validade"));
    }

    public String toString(int id) {
        return String.format(format, id, this.descricao, this.versao, dataFormatada.format(validade));
    }
}
