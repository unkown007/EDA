package lista;

import java.io.Serializable;

public class No<T> implements Serializable {
    public T ob;
    public No<T> proximo;
}
