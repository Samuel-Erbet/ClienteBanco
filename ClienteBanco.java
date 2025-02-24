/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author CLIENTE
 */
public class ClienteBanco {
    public float dinheiro;
    public String nome;
    public String sobrenome;
    public int cpf;
    
 /* criacao da classe cliente banco e seus atributos*/
    
    public ClienteBanco(float dinheiro, String nome, String sobrenome, int cpf){
    this.dinheiro = dinheiro;
    this.nome = nome;
    this.sobrenome = sobrenome ;
    this.cpf = cpf;
    }

    
/*Inicialização dos construtores da váriavel utilizando mais de 1 parâmetro*/
    
    
    public float sacar(float num){
        
    if(dinheiro-num<0){
    System.out.println("saldo insuficiente");
    }
    else{
    dinheiro-=num;
    }
    
    System.out.println("saldo atual: "+dinheiro);
    return dinheiro;
    }
    
/* Criando um método chamado sacar, ele vai ter 1 parâmetro que vai ser a quantidade de dinheiro que
    será sacada
*/

    
    
    public float inserir(float num){
    if(num<1){
        System.out.println("insira um valor válido");
    }
    else{
    dinheiro+=num;
    }
    System.out.println("você tem atualmente: "+dinheiro);
    return dinheiro;
    }
    
    
/*
Esse metodo pega um valor e adiciona ele ao saldo da conta do usuário
*/ 
   
    
    
    public void saldo(){
        System.out.println(nome+" você tem "+dinheiro+" disponivel na conta");
    }
/*
esse método é do tipo void ou seja, ele não retorna nenhum valor para o código, somente uma mensagem ao 
    usuário
*/
    
static void menu(){
System.out.println("1 - saldo");
System.out.println("2 - sacar dinheiro");
System.out.println("3 - inserir dinheiro");
System.out.println("4 - sair");

}

/*
Essa função é uma função do tipo void, assim como o metodo anterior, ele irá retornar somente
uma mensagem ao usuário
*/

    public static void main(String[] args) {
        float dinheiro=100;
        int cpf;
        String nome;
        String sobrenome;
        float saque; 
        float deposito;
        
        
        Scanner scanner = new Scanner(System.in);
        
        int opcao = 0;
        
        /*declaração das váriaveis que serao utilizadas na execução do programa*/
        
        System.out.println("insira o seu nome");
        nome = (scanner.nextLine());

        System.out.println("insira o seu sobrenome");
        sobrenome = (scanner.nextLine());
        
        System.out.println("insira o seu cpf");
        cpf = (scanner.nextInt());
        
        
        /* pegar as informações do usuário atraves do scanner e colocar na variável*/
        
        ClienteBanco conta = new ClienteBanco(dinheiro,nome,sobrenome,cpf);

        /*criacao do objeto da classe clienteBanco utilizando as informações das variaveis*/
        
        while (opcao != 4){
        
        
        
        
        menu();
        
        try{ 
            opcao = (scanner.nextInt());
        }catch(InputMismatchException e){
            System.out.println("insira um valor válido, somente numeros, não letras.");
            scanner.next();
            continue;
        };
        
        /* criacao de um loop que vai mostrar opcoes ao usuario e pedir pra ele inserir um valor
           o loop terminará assim que o usuário digitar 4
           alem de analisar o valor que o usuario digitou for de fato um numero caso contrario ele dara um erro,
           pedindo para o usuario inserir outro numero
        */
          
         
            switch (opcao) {
                
                case 1:
                    conta.saldo();
                    break;
                    
                    
                case 2:
                    System.out.println("insira o quanto você quer sacar");
                    saque = (scanner.nextFloat());
                    conta.sacar(saque);
                    break;
                    
                    
                case 3:
                    System.out.println("quanto você quer inserir na conta ?");
                    deposito = (scanner.nextFloat());
                    conta.inserir(deposito);
                    break;
                    
                    
                case 4:
                    opcao = 4;
                    System.out.println("muito obrigado, tenha um ótimo dia!");
                    break;
                    
                    
                default:
                    System.out.println("Erro insira um valor válido");
                
                
                
                
            }
        }
        /*
        baseado na opcao digitada pelo usuario ele caira em uma opcao do switch
        
        1 mostra o saldo da conta dele
        
        2 tira o dinheiro da conta dele baseado no valor digitada e mostra o saldo atual 
        depois do saque
        
        3 inseri dinheiro na conta e depois mostra a quantidade de dinheiro atual
        na conta
        
        4 encerra e execução do código e mostra uma mensagem de agradecimento
        */
        
        scanner.close();
    }
}
