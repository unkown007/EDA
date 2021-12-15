package informatica;

/**
 *
 * @author vm
 */
public class AplicacaoInstalada {
    private String descricao;
    private String versao;
    private String validade;

    public AplicacaoInstalada(String descricao, String versao, String validade, String data_duracao, int garantia, int discoDuro, String sistemaOperacinal) {
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

    public String toString() {
        return "\nAplicacao Instalada:" + "\nDescricao:\t" 
            + descricao + "\nVersao:\t" + versao + "\nValidade:\t" + validade;
    }
}
