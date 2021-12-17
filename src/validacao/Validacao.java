package validacao;

/**
 *
 * @author Basilio
 */

import java.io.*;

public class Validacao {
    private BufferedReader x;

    public Validacao(){
	x = new BufferedReader (new InputStreamReader(System.in));
    }

    public int inteiro(String msg, int min, int max)throws IOException {
	int valor;
		
	do{
            System.out.print(msg+"\t");
            valor = Integer.parseInt(x.readLine());
            if (valor<min || valor >max){
		System.out.print("Numero Invalido Vota a tenter");
            }
	} while(valor<min || valor >max);
	return valor;
	}

    public float real(String msg, float min, float max)throws IOException {
	float valor;
		
	do{
            System.out.print(msg+"\t");
            valor = Float.parseFloat(x.readLine());
            if (valor<min || valor >max){
		System.out.println("Numero Invalido Vota a tenter");
            }
	} while(valor<min || valor >max);
	return valor;
	}

    public String texto(String msg)throws IOException {
        System.out.print(msg+"\t");
            String text = x.readLine();
	return text;
    }
}
