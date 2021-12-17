package lista;

public interface Operacoes<T> {
    public int inserir(T obj);
    public int remover(int pos);
    public int actualizar(int pos, No<T> obj);
    public void mostrar();
}