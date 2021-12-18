package object;

/**
 *
 * @author vm
 */
public class AplicacaoInstalada implements Table {
    private String descricao;
    private String versao;
    private String validade;
    private String format = "%-40s %-20s %-20s";
    
    public AplicacaoInstalada(String descricao, String versao, String validade) {
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
    public String getValidade() {
        return validade;
    }
    
    //METODOS SETTERS
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setVersao(String versao) {
        this.versao = versao;
    }
    public void setValidade(String validade) {
        this.validade = validade;
    }
    
    public void tableHeader(){
        System.out.println(String.format(format,"Descricao","Versao","Validade"));
    }

    public String toString() {
        return String.format(format, this.descricao, this.versao, this.validade);
    }
}
