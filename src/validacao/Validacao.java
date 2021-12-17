package validacao;

/**
 *
 * @author Basilio
 */

import java.io.*;

public class Validacao {
    private static BufferedReader x = new BufferedReader (new InputStreamReader(System.in));

    public Validacao(){
    }

    public static int inteiro(String msg, int min, int max)throws IOException {
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

    public static float real(String msg, float min, float max)throws IOException {
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

    public static String texto(String msg)throws IOException {
        System.out.print(msg+"\t");
            String text = x.readLine();
	return text;
    }
}
