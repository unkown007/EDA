package lista;

import object.Table;

public class Lista<D extends Table> implements Operacoes<D> {
    public No<D> inicio;
    private int tamanho;
    
    public Lista() {
        inicio = null;
        tamanho = 0;
    }
    
    public boolean vazia() {
        return (inicio == null) ? true : false;
    }
    
    public int quantidade() {
        return tamanho;
    }
    
    public int inserir(D obj) {
        var no = new No<D>();
        
        if(no == null) return -1;
        
        no.ob = obj;
        
        if(inicio == null) {
            no.proximo = null;
            inicio = no;
        } else {
            no.proximo = inicio;
            inicio = no;
        }
        
        tamanho++;
        
        return 1;
    }
    
    public int remover(int pos) {
        No<D> ant, atual;
        int i = 1;
        
        if(vazia()||(pos <= 0)) return -1;
        
        atual = inicio;
        ant = null;
        while((atual != null)&&(i < pos)) {
            ant = atual;
            atual = atual.proximo;
            i++;
        }
        
        if(atual == inicio)
            inicio = inicio.proximo;
        else
            ant.proximo = atual.proximo;
        
        tamanho--;
        
        return 1;
    }
    
    public int actualizar(int pos, No<D> obj) {
        No<D> ant, atual;
        int i=1;
        
        if(vazia()||(pos <= 0)) return -1;
        
        atual = inicio;
        while((atual != null)&&(i < pos)) {
            atual = atual.proximo;
            i++;
        }
        
        if(atual == null) return -1;
        
        atual.ob = obj.ob;
        
        return 1;
    }
    
    public No<D> getNo(int pos) {
        No<D> aux;
        int i=1;
        
        if(vazia()||(pos <= 0)) return null;
        
        aux = inicio;
        while((aux != null)&&(i < pos)) {
            aux = aux.proximo;
            i++;
        }
        
        return aux;
    }
    
    public void mostrar() {
        No<D> aux;
        int i=1;
        
        aux = inicio;
        
        if(vazia()) return;
        
        aux.ob.tableHeader();
        while(aux != null) {
            System.out.println(aux.ob.toString(i++));
            aux = aux.proximo;
        }
    }
}