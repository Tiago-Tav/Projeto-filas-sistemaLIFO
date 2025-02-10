package AtividadeFinal;
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

public class Pilha extends EstrategiaLIFO {
	
	int ultimo = 0;
	String tipoLista = "NML";
	String[] elementos;
	Senha novaSenha = new Senha();
	
	static boolean algumaChamada = false;
	boolean filaChamada = false;
	
	int pontuacao = 0;
	int ganhoDePontuacao = 0;
	
	
	Pilha(String tipoLista, int ganhoPTT){
		for(TipoLista valor : TipoLista.values()) {
			if (tipoLista.toUpperCase() == valor.tipo){
				this.tipoLista = valor.tipo;
			}
		this.ganhoDePontuacao = ganhoPTT;
			
		}
	}
	
	
	@Override
    public String inserir() {
		
		novaSenha.gerarSenha();
		String gerada = novaSenha.retornarSenha();
		String aSerAdicionado = this.tipoLista + "-" + gerada;
		adicionarElemento(aSerAdicionado);
		return aSerAdicionado;
		
	}
	
	@Override
    public void remover() {
		
		String[] novoElementos = new String[ultimo - 1];
		int i = 0;
		if (elementos != null) {
			while (i < novoElementos.length) {
				novoElementos[i] = elementos[i];
				++i;
			}
			--ultimo;
		elementos = novoElementos;
		}
		
	}
	
	@Override
    public String chamar() {
		if (filaChamada) {
			for(String senha : elementos) {
				char[] temp = senha.toCharArray();
				if ('*' == temp[temp.length-1]) {
					return elementos[ultimo - 1];
				}
			}
		}
		
		if (ultimo > 0) {
			String senha = elementos[ultimo - 1];
			senha = senha + "*";
			elementos[ultimo - 1] = senha;
			filaChamada = true;
			algumaChamada = true;
            return senha;
        }
        return "Nenhuma senha disponível";
	}
	
	@Override
    public String atender() {
        if (ultimo > 0) {
            String senhaAtendida = elementos[ultimo - 1];
            remover();
            filaChamada = false;
            algumaChamada = false;
            return senhaAtendida;
        }
        return "Nenhuma senha para atender";
	}

	@Override
    public String listar() {
		return "";
	}
	
	public void mostrarTipo() {
		System.out.println(this.tipoLista);
	}
	
	void adicionarElemento(String elemento) {
		
		String[] novoElementos = new String[ultimo + 1];
		int i = 0;
		if (elementos != null) {
			while (i < ultimo) {
				novoElementos[i] = elementos[i];
				++i;
			}
		}
		if(filaChamada) {
			novoElementos[i] = novoElementos[i - 1];
			novoElementos[i - 1] = elemento;
		}
		else {
			novoElementos[i] = elemento;
		}
		
		elementos = novoElementos;
		++ultimo;
		
		
	}
	
	public String mostrarElemento() {
		
		String elemento = this.elementos[ultimo - 1];
		
		if (this.filaChamada == true) {
			elemento = this.elementos[ultimo - 2];
		}
		
		
		return elemento;
	}
	
	public void addPontos() {
		this.pontuacao = this.pontuacao + this.ganhoDePontuacao + (this.ultimo * this.ganhoDePontuacao /2);
	}
	
	public void zerarPontos() {
		this.pontuacao = 0;
	}
	
	public String mostrarPontos() {
		return String.valueOf(this.pontuacao);
	}

}
