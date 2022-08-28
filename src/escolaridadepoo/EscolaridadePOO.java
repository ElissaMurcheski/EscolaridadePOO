package escolaridadepoo;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class EscolaridadePOO {

    public static void main(String[] args) {
        ServicoPessoa servicoPessoa = new ServicoPessoa();
        String grauEscolaridade = JOptionPane.showInputDialog("Qual seu Grau de Escolaridade?"
                + "\n1 --> Ensino Básico \n2 --> Ensino Médio \n3 --> Ensino Superior "
                + "\n4 --> Pós-Graduado \n5 --> Mestrado \n6 --> Doutorado \n0 --> Sair");

        while (!grauEscolaridade.equals("0")) {
            String idade = JOptionPane.showInputDialog("Qual sua idade?");

            Pessoa pessoa = new Pessoa();
            pessoa.setGrauEscolaridade(Integer.parseInt(grauEscolaridade));
            pessoa.setIdade(Integer.parseInt(idade));
            servicoPessoa.setListaPessoa(pessoa);

            grauEscolaridade = JOptionPane.showInputDialog("Qual seu Grau de Escolaridade?"
                    + "\n1 --> Ensino Básico \n2 --> Ensino Médio \n3 --> Ensino Superior "
                    + "\n4 --> Pós-Graduado \n5 --> Mestrado \n6 --> Doutorado \n0 --> Sair");
        }

        String[] grauEscolaridades = {"", "Ensino Básico", "Ensino Médio", "Ensino Superior",
            "Pós-Graduado", "Mestrado", "Doutorado"};
        
        String Resposta = "\n---------- " + "Quantidade de pessoas por Grau de Escolaridade:" + " ----------";
        for (int i = 1; i < grauEscolaridades.length; i++) {
            Resposta += "\n" + grauEscolaridades[i] + ": " + servicoPessoa.getQtdPessoasGrauEscolaridade(i);
        }

        Resposta += "\n" + "\n---------- " + "Percentual de pessoas por Grau de Escolaridade:" + " ----------";
        DecimalFormat df = new DecimalFormat("##,##0.00");
        for (int i = 1; i < grauEscolaridades.length; i++) {
            Resposta += "\n" + grauEscolaridades[i] + ": " + servicoPessoa.getPercentGrauEscolaridade(i) + "%";
        }

        Resposta += "\n" + "\n---------- " + "Grau de Escolaridade com maior número de pessoas:" + " ----------"
                + "\n" + grauEscolaridades[servicoPessoa.getGrauEscolaridadeMaiorNumPessoas(grauEscolaridades.length)];

        Resposta += "\n" + "\n---------- " + "Grau de Escolaridade com menor número de pessoas:" + " ----------"
                + "\n" + grauEscolaridades[servicoPessoa.getGrauEscolaridadeMenorNumPessoas(grauEscolaridades.length)];

        Resposta += "\n" + "\n----- " + "Percentual de pessoas que concluiram o ensino superior antes dos 24 anos: "
                + "\n" + df.format(servicoPessoa.getPercentGrauEscolaridadePorIdade(24, 3)) + "%";   //só passar o que deseja.

        Resposta += "\n" + "\n---------- " + "Média de idade das pessoas que concluíram o mestrado:" + " ----------"
                + "\n" + servicoPessoa.getMediaIdade(5);

        Resposta += "\n" + "\n---------- " + "Menor idade com doutorado concluído:" + " ----------"
                + "\n" + servicoPessoa.getMenorIdade(6);

        JOptionPane.showMessageDialog(null, Resposta);
    }

}
