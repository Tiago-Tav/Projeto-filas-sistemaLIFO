package AtividadeFinal;
import java.util.Scanner;

public class ControleDePilha {
	/*
	 * Disciplina 	Programação Orientada a Objetos
	 * 
	 * Autores 		Tiago Silva Tavares de Siqueira 	RA 201884
	 * 				Wictor Hugo Santos Pereira 			RA 194387
	 * 				Gabrielly Da Frota Ferreira Vaz		RA 201969
	 * 
	 * Atividade 	Final 3EC
	 * 
	 * Data 		13/06/2024
	 */ 
	

    public static void main(String[] args) throws InterruptedException {
    	
    	try (Scanner input = new Scanner(System.in)) {
			String senhaFila = null;
			Pilha pilhaChamada = null;
			

			Pilha URG = new Pilha("URG", 6);
			Pilha I80 = new Pilha("I80", 5);
			Pilha VIP = new Pilha("VIP", 4);
			Pilha PFL = new Pilha("PFL", 3);
			Pilha I60 = new Pilha("I60", 2);
			Pilha NML = new Pilha("NML", 1);

			Pilha[] conjunto = {URG,I80,VIP,PFL,I60,NML};

			int output = 6;

			while (output != 0){
				
				inicial();
				output = input.nextInt();

			    switch(output) {
			      case 1:
			              mostrarCadastro();
			              output = input.nextInt();
			              switch(output) {
			              		case 1:
			              			URG.inserir();
			              			URG.addPontos();
			              			System.out.println(" SENHA GERADA: " + escolherCor(URG.mostrarElemento()) +" " + URG.mostrarElemento() + escolherCor("") +"\n\n\n\n");                 			
									Thread.sleep(1000);
									break;
			              		case 2:
			              			PFL.inserir();
			              			PFL.addPontos();
			              			System.out.println(" SENHA GERADA: " + escolherCor(PFL.mostrarElemento()) +" "   + PFL.mostrarElemento() + escolherCor("") + "\n\n\n\n");                 			
									Thread.sleep(1000);
			              			break;
			              		case 3:
			              			I80.inserir();
			              			I80.addPontos();
			              			System.out.println(" SENHA GERADA: " + escolherCor(I80.mostrarElemento()) +" "  + I80.mostrarElemento() + escolherCor("") + "\n\n\n\n");                 			
									Thread.sleep(1000);
			              			break;
			              		case 4:
			              			I60.inserir();
			              			I60.addPontos();
			              			System.out.println(" SENHA GERADA: " + escolherCor(I60.mostrarElemento()) +" "  + I60.mostrarElemento() + escolherCor("") + "\n\n\n\n");                 			
									Thread.sleep(1000);
			              			break;
			              		case 5:
			              			VIP.inserir();
			              			VIP.addPontos();
			              			System.out.println(" SENHA GERADA: " + escolherCor(VIP.mostrarElemento()) +" "  + VIP.mostrarElemento() + escolherCor("") + "\n\n\n\n");                 			
									Thread.sleep(1000);
			              			break;
			              		case 6:
			              			NML.inserir();
			              			NML.addPontos();
			              			System.out.println(" SENHA GERADA: " + escolherCor(NML.mostrarElemento()) +" "  + NML.mostrarElemento() + escolherCor("") + "\n\n\n\n");                 			
									Thread.sleep(1000);
			              			break;
			              			
			              		default:
			              			if (output == 0) {
			              				output = 5;
			              			}
			              			System.out.println("Você inseriu um valor invalido!");
			              			Thread.sleep(1000);
			              		
			              		}
			        break;
			      case 2:

			        	  acessoMedico(conjunto);
			              output = input.nextInt();
			              		switch(output) {
			              			case 9:
			              				break;
			              		
			              			
			              			case 1:
			              				senhaFila = proximaSenha(conjunto);
			                  			chamar(senhaFila);
			                  			Thread.sleep(3000);
			              				break;
			              			case 2:
			              				if (Pilha.algumaChamada != false) {
			              					senhaFila = proximaSenha(conjunto);
			                  				atender(senhaFila);
			                  				pilhaChamada = pilhaChamada(conjunto);
			                  				pilhaChamada.atender();
			                  				adicionarPontosTodosComExcessao(conjunto, pilhaChamada);
			                  				
			                  				
			              				}
			              				else {
			              					System.out.println("\n\n\n Chame uma senha antes de atende-la!");
			              				}
			              				Thread.sleep(3000);
			              				break;
			              			default:
			              				if (output == 0) {
			                  				output = 5;
			                  			}
			                      	  System.out.println("\n\n\n Você inseriu um valor invalido! \n\n\n");
			                      	  Thread.sleep(2000);
			                      	  break;
			              		}
			    	  }
			    	  


			    }
		}

        }


    static void acessoMedico(Pilha[] conjunto){
    	

    	System.out.println("+--------------------------------------------------+");
        System.out.print("|            Bem-vindo ao Sistema Médico!          |\n");
        System.out.println("+--------------------------------------------------+");
        System.out.println("|\t Dr. No Problem, CRM 01.892                |");
        System.out.println("+-------------------------------------------------+");
        System.out.println("|             !Controle de Pacientes!              |");
        System.out.println("+--------------------------------------------------+");
    	

        for (Pilha pilha : conjunto) {

            String mostrar = "";

                if (pilha.elementos != null) {
                	
                    for (String s : pilha.elementos) {
                        mostrar = (" " + s + " " + mostrar );
                    }
                } else {
                	pilha.pontuacao = 0;
                }
                	System.out.print("|");
                    System.out.println("pontos:" + pilha.mostrarPontos() + "  " + escolherCor(pilha.tipoLista) + pilha.tipoLista + " [" + mostrar + " ]" + escolherCor(""));
            }
        

        System.out.println("+--------------------------------------------------+");
        System.out.println("| 9- Voltar         1- Chamar          2- Atender  |");
        System.out.println("+--------------------------------------------------+");
        }
    
    
    static void mostrarCadastro() {
    	//Dr. No Problem, CRM 01.892

        System.out.println("\n\n\n\n+--------------------------------------------------+");
        System.out.println("|Bem-vindo ao Sistema de Chamada de Senhas Médicas |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("|\t Dr. No Problem, CRM 01.892                |");
        System.out.println("+--------------------------------------------------+");  
        System.out.println("|Por favor, selecione o tipo de paciente:          |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("|\t 1 URG - Urgente                           |");
        System.out.println("|\t 2 PFL - Preferencial                      |");
        System.out.println("|\t 3 I80 - Idoso80                           |");
        System.out.println("|\t 4 I60 - Idoso60                           |");
        System.out.println("|\t 5 VIP - VIP                               |");
        System.out.println("|\t 6 NML - Normal                            |");
        System.out.println("+--------------------------------------------------+\n");
        System.out.println("Digite o código correspondente ao seu tipo de paciente:\n ");


    }
    
    static void inicial() {
    	System.out.println("\n\n\n\n+--------------------------------------------------+");
        System.out.print("|Bem-vindo ao Sistema de Chamada de Senhas Médicas |\n");
        System.out.println("+--------------------------------------------------+");
        System.out.println("|\t Dr. No Problem, CRM 01.892                |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("|              SISTEMA DE CADASTRO                 |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("|\t 1 CDP - Cadastro De Pacientes             |");
        System.out.println("|\t 2 AM - Acesso Médico                      |");
        System.out.println("|\t                                           |");
        System.out.println("|\t 0 QUIT - Finzalizar Processos             |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("Digite o NUMERO correspondente as opcoes:   ");

    }
    
    
    static void chamar(String senha) {
   
    	
    	 if (senha.length() > 10) {
    		 System.out.println("\n\n"+senha);
    	 }
    	 else {
    		
    		 
    		 System.out.println("\n\n\n+----------------------------------------------------+");
             System.out.println("|  Bem-vindo ao Sistema de Chamada de Senhas Médicas |");
             System.out.println("+----------------------------------------------------+");
             System.out.println("|\t Dr. No Problem, CRM 01.892                  |");
         	 System.out.println("+----------------------------------------------------+");
             System.out.println("|                !AGUARDE A CHAMADA!                 |");
             System.out.println("+----------------------------------------------------+");
             System.out.println("|-------------------!SENHA ATUAL!--------------------|");
             System.out.println("|" +   escolherCor(senha)  + "                     "+ senha + escolherCor(""));
             System.out.println("|       !Por favor, Dirija-se ao Consultório!        |");
             System.out.println("+----------------------------------------------------+");
    	 }
    	 
         
    }
    
    static void atender(String senha) {
   	 	System.out.println("\n\n\n+----------------------------------------------------+");
        System.out.println("|  Bem-vindo ao Sistema de Chamada de Senhas Médicas |");
        System.out.println("+----------------------------------------------------+");
        System.out.println("|\t Dr. No Problem, CRM 01.892                  |");
    	System.out.println("+----------------------------------------------------+");
        System.out.println("|                 !SENHA ATENDIDA!                   |");
        System.out.println("|  "+ escolherCor(senha) + "                   "+ senha + escolherCor(""));
        System.out.println("|          !OBRIGADO PELA SUA PACIENCIA!             |");
        System.out.println("+----------------------------------------------------+");
        
   }
    static Pilha pilhaChamada(Pilha[] conj) {
    	if(Pilha.algumaChamada == true) {
    		for (Pilha fila : conj) {
				if (fila.filaChamada == true) {
					return fila;
				}
    		}
    	}
    	
    	return null;
    }
    
    static String proximaSenha(Pilha[] conj) {
    	if (Pilha.algumaChamada == true) {
    		for (Pilha fila : conj) {
    				if (fila.filaChamada == true) {
    					return fila.chamar();
    				}
        		}
		}
    	Pilha maior = null;
    	int maiorPontuacao = 0;
    	for (Pilha fila : conj) {
    		if(fila.pontuacao > maiorPontuacao) {
    			maior = fila;
    			maiorPontuacao = fila.pontuacao;
    		}
    	}
    	if (maior == null) {
    		return " Adicione alguma senha antes de chamar! ";
    	}
    	return maior.chamar();
    }
    
    static void adicionarPontosTodosComExcessao(Pilha[] conjunto, Pilha excessao) {
    	for (Pilha fila : conjunto) {
    		if (fila != excessao) {
    			if (fila.elementos == null || fila.elementos.length == 0) {
    				fila.zerarPontos();
    			} else {
    			fila.addPontos();
    			}
    		} else {
    			fila.zerarPontos();
    			if(fila.elementos == null || fila.elementos.length > 0) {
    				fila.addPontos();
    			}
    			
    		}
    	}
    }
    
    static void adicionarPontosSomenteUm(Pilha[] conjunto, Pilha destinado) {
    	for (Pilha fila : conjunto) {
    		if (fila == destinado) {
    			fila.addPontos();
    		}
    	}
    }
    
    static String escolherCor(String senha) {
    	String RESET = "\u001B[0m";
    	String RED = "\u001B[31m";
    	String GREEN = "\u001B[32m";
    	String YELLOW = "\u001B[33m";
    	String BLUE = "\u001B[34m";
    	String MAGENTA = "\u001B[35m";
    	String CYAN = "\u001B[36m";

    	
    	String cod = "";
    	
    	if(senha.length() != 0) {
    		cod = senha.substring(0,3);
    	}
    		
    	
    	String cor = RESET;
		 switch (cod) {
		 case "URG":
			 cor = RED;
			 break;
		 case "I80":
			 cor = MAGENTA;
			 break;
		 case "I60":
			 cor = CYAN;
			 break;
		 case "PFL":
			 cor = GREEN;
			 break;
		 case "VIP":
			 cor = YELLOW;
			 break;
		 case "NML":
			 cor = BLUE;
			 break;
		 }
		 return cor;
    }
    
    
}