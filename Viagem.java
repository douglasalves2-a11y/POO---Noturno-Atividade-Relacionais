public class Viagem {
    private String destino;
    private float distanciaTotal;
    private Motorista motorista;
    private Veiculo veiculo;

    public Viagem(String destino, float distanciaTotal, Motorista motorista, Veiculo veiculo) {
        setDestino(destino);
        setDistanciaTotal(distanciaTotal);
        setMotorista(motorista);
        setVeiculo(veiculo);
    }

    // Getters
    public String getDestino() { return destino; }
    public float getDistanciaTotal() { return distanciaTotal; }
    public Motorista getMotorista() { return motorista; }
    public Veiculo getVeiculo() { return veiculo; }

    // Setters
    public void setDestino(String destino) {
        if (destino == null || destino.trim().isEmpty()) {
            throw new IllegalArgumentException("Destino não pode ser vazio.");
        }
        this.destino = destino;
    }

    public void setDistanciaTotal(float distanciaTotal) {
        if (distanciaTotal <= 0) {
            throw new IllegalArgumentException("Distância deve ser positiva.");
        }
        this.distanciaTotal = distanciaTotal;
    }

    public void setMotorista(Motorista motorista) {
        if (motorista == null) {
            throw new IllegalArgumentException("Motorista não pode ser nulo.");
        }
        this.motorista = motorista;
    }

    public void setVeiculo(Veiculo veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("Veículo não pode ser nulo.");
        }
        this.veiculo = veiculo;
    }

    public void iniciarViagem() {
        // Verifica se motorista e veículo estão aptos
        if (!motorista.isCnhValida()) {
            System.out.println("Erro: A viagem não pode ser iniciada. CNH do motorista " 
                + motorista.getNome() + " está vencida (validade: " + motorista.getValidadeCnh() + ").");
            return;
        }
        if (veiculo == null) {
            System.out.println("Erro: Nenhum veículo vinculado à viagem.");
            return;
        }

        System.out.println("\n=== Iniciando viagem para " + destino + " ===");
        boolean sucesso = veiculo.viajar(distanciaTotal);
        if (!sucesso) {
            System.out.println("Viagem interrompida por falta de combustível.");
        } else {
            System.out.println("Viagem concluída com sucesso!");
        }
    }

    public void gerarRelatorio() {
        System.out.println("\n========== RELATÓRIO DA VIAGEM ==========");
        System.out.println("Destino       : " + destino);
        System.out.println("Distância     : " + distanciaTotal + " km");
        System.out.println("Motorista     : " + motorista.getNome() + " (CNH: " + motorista.getCnh() + ", Validade: " + motorista.getValidadeCnh() + ")");
        System.out.println("Veículo       : " + veiculo.getModelo() + " (Placa: " + veiculo.getPlaca() + ")");
        System.out.printf("Combustível   : %.2f L restantes%n", veiculo.getCombustivelAtual());
        System.out.println("=========================================");
    }
}
