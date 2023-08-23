package br.com.fiap.bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Classe para objetos do tipo DragonBallSuper
 * Esta classe implementa a interface IDBSuper e fornece atributos e métodos.
 * Para representar um personagem da série Dragon Ball Super. Inclui informações como nome do personagem, nível de ki, número de técnicas, velocidade e transformações.
 * A classe também contém métodos para ler e escrever informações de caracteres de/para  arquivos de texto.
 * @author vitor
 * @version 1.0
 * */

public class DragonBallSuper implements IDBSuper {
	
	private String nome;
	private int ki;
	private int tecnicas;
	private int velocidade;
	private int transformacoes;
	

	public DragonBallSuper() {}
	
	

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getKi() {
		return ki;
	}



	public void setKi(int ki) {
		this.ki = ki;
	}



	public int getTecnicas() {
		return tecnicas;
	}



	public void setTecnicas(int tecnicas) {
		this.tecnicas = tecnicas;
	}



	public int getVelocidade() {
		return velocidade;
	}



	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}



	public int getTransformacoes() {
		return transformacoes;
	}



	public void setTransformacoes(int transformacoes) {
		this.transformacoes = transformacoes;
	}


	/**
	 * * Lê e preenche os atributos de um objeto DragonBallSuper a partir de um arquivo de texto.
	 * * Este método lê os atributos de um objeto DragonBallSuper de um arquivo de texto localizado no caminho especificado.
	 * * As informações são lidas linha por linha do arquivo de texto e atribuídas aos atributos correspondentes do objeto DragonBallSuper.
	 * @author vitor
	 * @param path O caminho para o diretório onde o arquivo de texto está localizado.
	 * @return Retorna um objeto da classe DragonBallSuper com atributos preenchidos a partir do arquivo de texto ou nulo se ocorrer um erro durante a leitura do arquivo.
	 * @throws NumberFormatException Se houver um erro ao analisar valores numéricos do arquivo.
	 * @throws IOException Se ocorrer um erro durante a leitura do arquivo.
	 * */

	public DragonBallSuper ler (String path) {
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(path + "/" + nome + ".txt"));
			nome = br.readLine();
			ki = Integer.parseInt(br.readLine());
			tecnicas = Integer.parseInt(br.readLine());
			velocidade = Integer.parseInt(br.readLine());
			transformacoes = Integer.parseInt(br.readLine());
			br.close();
			return this;
		} catch (IOException e) {
			return null;
		}
	}
	
	/**
	* Grava os atributos de um objeto DragonBallSuper em um arquivo de texto.
	* Este método pega os atributos de um objeto DragonBallSuper e os grava em um arquivo de texto em linhas separadas usando PrintWriter.
	* @author vitor
	* @param path O caminho para o diretório onde o arquivo de texto será criado ou substituído.
	* @return Uma mensagem indicando o status do processo de gravação do arquivo.
	* @throws IOException Se ocorrer um erro ao gravar no arquivo.
	*/
	
	public String gravar(String path) {
		try {
			File dir = new File(path);
			if (!dir.exists()) {
				dir.mkdir();
			}
			PrintWriter pw = new PrintWriter(path + "/" + nome + ".txt");
			pw.println(nome);
			pw.println(ki);
			pw.println(tecnicas);
			pw.println(velocidade);
			pw.println(transformacoes);
			pw.flush();
			pw.close();
			return "Arquivo gravado com sucesso!";
		} catch (IOException e) {
			return "Erro ao gravar arquivos" + e.getMessage();
		}
	}	
}
