public class Main {
    public static void main(String[] args) {

        System.out.println("===== SISTEMA DE GESTÃO DE FROTA LOGÍSTICA =====\n");

        // ─── 1. Instanciar 2 motoristas ───────────────────────────────────────
        Motorista motorista1 = new Motorista("Carlos Silva", "111.111.111-11", "CNH-001", 2027);
        Motorista motorista2 = new Motorista("Ana Souza",   "222.222.222-22", "CNH-002", 2022); // CNH vencida

        System.out.println("Motoristas criados:");
        System.out.println(" - " + motorista1);
        System.out.println(" - " + motorista2);

        // ─── 2. Instanciar 2 veículos ─────────────────────────────────────────
        Veiculo veiculo1 = new Veiculo("ABC-1234", "Caminhão Volvo FH", 400f, 0f);
        Veiculo veiculo2 = new Veiculo("XYZ-5678", "Fiat Strada",        60f, 30f);

        System.out.println("\nVeículos criados:");
        System.out.println(" - " + veiculo1);
        System.out.println(" - " + veiculo2);

        // ─── 3. Tentar criar viagem com CNH vencida (deve falhar) ─────────────
        System.out.println("\n--- Teste: Viagem com CNH vencida ---");
        Viagem viagemInvalida = new Viagem("São Paulo", 300f, motorista2, veiculo2);
        viagemInvalida.iniciarViagem(); // deve exibir erro

        // ─── 4. Criar viagem válida, abastecer e executar ─────────────────────
        System.out.println("\n--- Teste: Viagem válida ---");
        veiculo1.abastecer(200f); // abastece 200L

        Viagem viagemValida = new Viagem("Belo Horizonte", 500f, motorista1, veiculo1);
        viagemValida.iniciarViagem();

        // ─── 5. Imprimir status final do combustível ──────────────────────────
        System.out.println("\n--- Status final do combustível ---");
        System.out.printf("Veículo %s (%s): %.2f L restantes%n",
            veiculo1.getModelo(), veiculo1.getPlaca(), veiculo1.getCombustivelAtual());
        System.out.printf("Veículo %s (%s): %.2f L restantes%n",
            veiculo2.getModelo(), veiculo2.getPlaca(), veiculo2.getCombustivelAtual());

        // ─── Relatório final ──────────────────────────────────────────────────
        viagemValida.gerarRelatorio();
    }
}
