package escolaridadepoo;

import java.util.ArrayList;

public class ServicoPessoa {

    private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();

    public void setListaPessoa(Pessoa pessoa) {
        this.listaPessoas.add(pessoa);
    }

    public int getQtdPessoasGrauEscolaridade(int escolaridade) {
        int cont = 0;
        for (int i = 0; i < this.listaPessoas.size(); i++) {
            if (this.listaPessoas.get(i).getGrauEscolaridade() == escolaridade) {
                cont++;
            }
        }
        return cont;
    }

    public double getPercentGrauEscolaridade(int escolaridade) {
        double cont = getQtdPessoasGrauEscolaridade(escolaridade);
        return (cont / listaPessoas.size()) * 100;
    }

    public int getGrauEscolaridadeMaiorNumPessoas(int qtdEscolaridade) {
        int maiorNumPessoas = 0;
        int maiorEscolaridade = 0;
        for (int i = 1; i <= qtdEscolaridade; i++) {
            int qtdPessoas = getQtdPessoasGrauEscolaridade(i);
            if (qtdPessoas > maiorNumPessoas) {
                maiorNumPessoas = qtdPessoas;
                maiorEscolaridade = i;
            }
        }
        return maiorEscolaridade;
    }

    public int getGrauEscolaridadeMenorNumPessoas(int qtdEscolaridade) {
        int menorNumPessoas = Integer.MAX_VALUE;
        int menorEscolaridade = 0;
        for (int i = 1; i <= qtdEscolaridade; i++) {
            int qtdPessoas = getQtdPessoasGrauEscolaridade(i);
            if (qtdPessoas < menorNumPessoas) {
                menorNumPessoas = qtdPessoas;
                menorEscolaridade = i;

            }
        }
        return menorEscolaridade;
    }

    public double getPercentGrauEscolaridadePorIdade(int idade, int escolaridade) {
        double qtdPessoas = 0;
        for (int i = 0; i < this.listaPessoas.size(); i++) {
            Pessoa pessoa = this.listaPessoas.get(i);
            if (pessoa.getIdade() < idade && pessoa.getGrauEscolaridade() >= escolaridade) {
                qtdPessoas++;
            }
        }
        return (qtdPessoas / this.listaPessoas.size()) * 100;
    }

    public int getMediaIdade(int escolaridade) {
        int qtdPessoas = 0;
        int idade = 0;
        for (int i = 0; i < this.listaPessoas.size(); i++) {
            Pessoa pessoa = this.listaPessoas.get(i);
            if (pessoa.getGrauEscolaridade() >= escolaridade) {
                qtdPessoas++;
                idade += pessoa.getIdade();
            }
        }
        if (idade != 0 || qtdPessoas != 0) {
            return idade / qtdPessoas;
        }
        return 0;
    }

    public int getMenorIdade(int escolaridade) {
        int menorIdade = Integer.MAX_VALUE;
        for (int i = 0; i < this.listaPessoas.size(); i++) {
            Pessoa pessoa = this.listaPessoas.get(i);
            if ((pessoa.getGrauEscolaridade() >= escolaridade)
                    && (pessoa.getIdade() < menorIdade)) {
                menorIdade = pessoa.getIdade();
            }
        }
        if (menorIdade != Integer.MAX_VALUE) {
            return menorIdade;
        }
        return 0;
    }
}
