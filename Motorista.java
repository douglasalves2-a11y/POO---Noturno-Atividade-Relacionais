public class Motorista {
    private String nome;
    private String cpf;
    private String cnh;
    private int validadeCnh; // Ano de validade

    public Motorista(String nome, String cpf, String cnh, int validadeCnh) {
        setNome(nome);
        setCpf(cpf);
        setCnh(cnh);
        setValidadeCnh(validadeCnh);
    }

    // Getters
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getCnh() { return cnh; }
    public int getValidadeCnh() { return validadeCnh; }

    // Setters com validação
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio.");
        }
        this.cpf = cpf;
    }

    public void setCnh(String cnh) {
        if (cnh == null || cnh.trim().isEmpty()) {
            throw new IllegalArgumentException("CNH não pode ser vazia.");
        }
        this.cnh = cnh;
    }

    public void setValidadeCnh(int validadeCnh) {
        if (validadeCnh < 2000) {
            throw new IllegalArgumentException("Validade da CNH inválida.");
        }
        this.validadeCnh = validadeCnh;
    }

    public boolean isCnhValida() {
        return validadeCnh >= 2024;
    }

    @Override
    public String toString() {
        return "Motorista{nome='" + nome + "', CPF='" + cpf + "', CNH='" + cnh + "', Validade=" + validadeCnh + "}";
    }
}
