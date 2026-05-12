public class Veiculo {
    private String placa;
    private String modelo;
    private float capacidadeTanque;
    private float combustivelAtual;

    public Veiculo(String placa, String modelo, float capacidadeTanque, float combustivelAtual) {
        setPlaca(placa);
        setModelo(modelo);
        setCapacidadeTanque(capacidadeTanque);
        setCombustivelAtual(combustivelAtual);
    }

    // Getters
    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public float getCapacidadeTanque() { return capacidadeTanque; }
    public float getCombustivelAtual() { return combustivelAtual; }

    // Setters com validação
    public void setPlaca(String placa) {
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("Placa não pode ser vazia.");
        }
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("Modelo não pode ser vazio.");
        }
        this.modelo = modelo;
    }

    public void setCapacidadeTanque(float capacidadeTanque) {
        if (capacidadeTanque <= 0) {
            throw new IllegalArgumentException("Capacidade do tanque deve ser positiva.");
        }
        this.capacidadeTanque = capacidadeTanque;
    }

    public void setCombustivelAtual(float combustivelAtual) {
        if (combustivelAtual < 0) {
            throw new IllegalArgumentException("Combustível não pode ser negativo.");
        }
        this.combustivelAtual = combustivelAtual;
    }

    public void abastecer(float litros) {
        if (litros <= 0) {
            System.out.println("Quantidade de litros inválida.");
            return;
        }
        float total = this.combustivelAtual + litros;
        if (total > this.capacidadeTanque) {
            System.out.println("Aviso: quantidade excede a capacidade. Abastecendo até o limite.");
            this.combustivelAtual = this.capacidadeTanque;
        } else {
            this.combustivelAtual = total;
        }
        System.out.printf("Veículo abastecido. Combustível atual: %.2f L%n", this.combustivelAtual);
    }

    public boolean viajar(float distancia) {
        // Consumo médio: 10 km/l
        float consumo = distancia / 10.0f;
        if (consumo > this.combustivelAtual) {
            System.out.printf("Erro: combustível insuficiente para %.2f km. Combustível disponível: %.2f L (suficiente para %.2f km).%n",
                distancia, this.combustivelAtual, this.combustivelAtual * 10);
            return false;
        }
        this.combustivelAtual -= consumo;
        System.out.printf("Viagem de %.2f km concluída. Combustível restante: %.2f L%n", distancia, this.combustivelAtual);
        return true;
    }

    @Override
    public String toString() {
        return "Veiculo{placa='" + placa + "', modelo='" + modelo + "', tanque=" + capacidadeTanque + "L, combustivel=" + combustivelAtual + "L}";
    }
}
