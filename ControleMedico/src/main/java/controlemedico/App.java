package controlemedico;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PacienteDAO dao = new PacienteDAO();

        while (true) {
            System.out.println("\n1. Adicionar Paciente");
            System.out.println("2. Listar Pacientes");
            System.out.println("3. Atualizar Status");
            System.out.println("4. Excluir Paciente");
            System.out.println("0. Sair");
            System.out.print("Selecione: ");
            int op = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            try {
                switch (op) {
                    case 1 -> {
                        Paciente p = new Paciente();
                        System.out.print("Nome: ");
                        p.setNome(scanner.nextLine());
                        System.out.print("CPF: ");
                        p.setCpf(scanner.nextLine());
                        System.out.print("Endereço: ");
                        p.setEndereco(scanner.nextLine());
                        System.out.print("Consulta: ");
                        p.setConsulta(scanner.nextLine());
                        System.out.print("ID da Consulta: ");
                        p.setIdConsulta(scanner.nextLine());
                        dao.adicionarPaciente(p);
                        System.out.println("Paciente adicionado.");
                    }
                    case 2 -> {
                        List<Paciente> lista = dao.listarPacientes();
                        for (Paciente p : lista) {
                            System.out.println(p.getId() + " - " + p.getNome() + " | Status: " + p.getStatus() + " " + p.getCpf() + " " + p.getIdConsulta() +  " " + p.getEndereco() +  " " + p.getConsulta());
                        }
                    }
                    case 3 -> {
                        System.out.print("ID do paciente: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Novo status: ");
                        String status = scanner.nextLine();
                        dao.atualizarStatus(id, status);
                        System.out.println("Status atualizado.");
                    }
                    case 4 -> {
                        System.out.print("ID do paciente a excluir: ");
                        int id = scanner.nextInt();
                        dao.excluirPaciente(id);
                        System.out.println("Paciente excluído.");
                    }
                    case 0 -> {
                        System.out.println("Saindo...");
                        return;
                    }
                    default -> System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
