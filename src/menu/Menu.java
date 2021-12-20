package menu;
import java.io.*;
import lista.Lista;
import validacao.Validacao;
import lista.Operacoes;
import object.Equipamento;

public class Menu {
    public static Lista<Equipamento> app = new Lista<>();
    private String material;
    byte ops;
    public Validacao val;
    
    
    
    public Menu() throws IOException{
        val = new Validacao();
        menu();
        
    }
    
    public void menu() throws IOException{
        do{
            System.out.println("GESTAO DE REDE INFORMATICA\n"
            + "Base de Dados de equipamentos (PC's ou Servidores)\n"
            + "\nO que deseja:\n"
            + "\t1.\tPara equipamento\n"
            + "\t2.\tPara Aplicacoes instaladas \n"
            + "\t3.\tPara placa de rede\n"
            + "\t0.\tPara sair do sistema")
        ;
        
        ops =(byte) val.inteiro("Escolha uma opcao:",0,3);
        
        if(ops==1){
            material ="equipamento";
        }else{
            if(ops==2){
                material = "aplicacao instalada";
            }else{
                material = "placa de rede";
            }
        }
        
        switch(ops){
            case 0:sair();break;
            case 1:operacoes(material);break;
            case 2:operacoes(material);break;
            case 3:operacoes(material);break;
        }
        }while(ops !=0);
    }
    
    public void operacoes(String elemento)throws IOException{
        barra();
        System.out.println("\t1.\tPara visualizar "+elemento+"\n"
            + "\t2.\tPara inserir "+elemento+"\n"
            + "\t3.\tPara alterar um determinado "+elemento+"\n"
            + "\t4.\tPara eliminar um determinado "+elemento+"\n"
            + "\t0.\tPara voltar ")
        ;
        
        ops =(byte) val.inteiro("Escolha uma opcao:",0,4);
        
        barra();
        switch(ops){
            case 0:menu();break;
            case 1:visualizarEquipamento();break;
            case 2:break;
            case 3:break;
            case 4:break;
        }
    }
    
    public void sair(){
        System.out.println("Saindo do sistema");
    }
    
    public void visualizarEquipamento()throws IOException{
        barra();
        System.out.println("Visualizar:\n"
                + "1.\tTodos equipamentos \n"
                + "2.\tUm determinado equipamento\n"
                + "3.\tQue estao na mesma rede\n"
                + "0.\tVoltar\n");
        ops =(byte) val.inteiro("Escolha uma opcao:",0,2);
        
        switch(ops){
            case 0:menu();break;
            case 1:break;
            case 2:break;
            case 3:break;
        }
        barra();
    }
    
    public void visualEquipTotal() throws IOException{
        barra();
        System.out.println("Totais:\n"
                + "1.\tMIPS \n"
                + "2.\tMemoria \n"
                + "3.\tCapacidade dos HDs\n"
                + "0.\tVoltar\n");
        ops =(byte) val.inteiro("Escolha uma opcao:",0,2);
        
        switch(ops){
            case 0:menu();break;
            case 1:break;
            case 2:break;
            case 3:break;
        }
        barra();
        
    }
    
    public void barra(){
        System.out.println("=======================================");
    }
}

