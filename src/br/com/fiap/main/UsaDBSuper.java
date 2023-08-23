package br.com.fiap.main;

import javax.swing.JOptionPane;

import br.com.fiap.bean.DragonBallSuper;

public class UsaDBSuper {

	public static void main(String[] args) {
		String aux, nome, path, escolha = "sim";
		int ki, tecnicas, velocidade, transformacoes, opcao;
		DragonBallSuper dbs;
		while (escolha.equalsIgnoreCase("sim")) {
			try {
				aux = JOptionPane.showInputDialog("Escolha uma opção: "
						+ "\n1- Cadastrar um personagem de de Dragon Ball Super"
						+ "\n2- Consultar um personagem de Dragon Ball Super");
				opcao = Integer.parseInt(aux);
				path = JOptionPane.showInputDialog("Informe o caminho da pasta.");
				dbs = new DragonBallSuper();
				switch (opcao) {
				case 1:
					nome = JOptionPane.showInputDialog("Informe o nome do personagem");
					dbs.setNome(nome);
					aux = JOptionPane.showInputDialog("Informe a quantidade de Ki do personagem");
					ki = Integer.parseInt(aux);
					aux = JOptionPane.showInputDialog("Informe a quantidade/poder das técnicas do personagem");
					tecnicas = Integer.parseInt(aux);
					aux = JOptionPane.showInputDialog("Informe a velocidade do personagem");
					velocidade = Integer.parseInt(aux);
					aux = JOptionPane.showInputDialog("Informe a quantidade de transformações do personagem");
					transformacoes = Integer.parseInt(aux);
					
					dbs.setKi(ki);
					dbs.setTecnicas(tecnicas);
					dbs.setVelocidade(velocidade);
					dbs.setTransformacoes(transformacoes);
					JOptionPane.showMessageDialog(null, dbs.gravar(path));
					break;
				case 2:
					nome = JOptionPane.showInputDialog("Digite o nome do personagem");
					dbs.setNome(nome);
					dbs = dbs.ler(path);
					if (dbs == null) {
						JOptionPane.showMessageDialog(null, "Esse personagem não existe ou não foi cadastrado");
					} else {
						JOptionPane.showMessageDialog(null, "Exibindo dados do personagem:" 
								+ "\nCaminho" + path + "\nNome: " + dbs.getNome() 
								+ "\nKi: " + dbs.getKi() + "\nTécnicas: " + dbs.getTecnicas()
								+ "\nVelocidade: " + dbs.getVelocidade() + "\nTransformações: " + dbs.getTransformacoes());
					}
					
					break;

				default:
					JOptionPane.showMessageDialog(null, "Escolha incorreta");
				}
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			escolha = JOptionPane.showInputDialog("Deseja continuar?");
		}
		JOptionPane.showMessageDialog(null, "Fim de programa");
	}

}
