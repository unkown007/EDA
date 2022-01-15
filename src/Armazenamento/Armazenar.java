package Armazenamento;

import java.io.*;

import lista.Lista;
import object.Table;

public class Armazenar{
    
    public static <T extends Table> void GravarFichObj(Lista<T> vec, String obj) {
        try {
            FileOutputStream ff = new FileOutputStream(obj + ".dat");
            ObjectOutputStream ss = new ObjectOutputStream(ff);
            ss.writeObject(vec);
            ss.close();
        } catch (IOException xx) {
            System.out.println(xx.toString());
        }
    }

    public static <T extends Table> Lista<T> LerDadosDoFichObj(String obj) {
        Lista<T> vec = new Lista();
        try {
            FileInputStream ii = new FileInputStream(obj + ".dat");
            ObjectInputStream tt = new ObjectInputStream(ii);
            vec = (Lista<T>) tt.readObject();
            tt.close();

        } catch (FileNotFoundException ff) {
            System.out.println("Ficheiro de obj nao encontrado!");
        } catch (ClassNotFoundException cc) {
            System.out.println("Verifique a existencia da classe " + obj);
        } catch (IOException pp) {
            System.out.println("Problemas no leitura do ficheiro!");
        }
        return vec;
    }
}
