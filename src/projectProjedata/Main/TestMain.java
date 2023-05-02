package projectProjedata.Main;

//import static org.junit.Assert.assertEquals;

import projectProjedata.Classes.Funcionario;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Objects;
//import org.junit.Test;

public class TestMain {

    //@Test
    public void testRemoveEmployee() {
        // Cria uma lista de funcionários
        LinkedList<Funcionario> listaDeFuncionarios = new LinkedList<>();
        listaDeFuncionarios.add(new Funcionario("João", LocalDate.of(1980, 1, 1), new BigDecimal("1500.00"), "Programador"));
        listaDeFuncionarios.add(new Funcionario("Maria", LocalDate.of(1985, 2, 2), new BigDecimal("2000.00"), "Analista"));
        listaDeFuncionarios.add(new Funcionario("Pedro", LocalDate.of(1990, 3, 3), new BigDecimal("2500.00"), "Gerente"));

        removeEmployee(listaDeFuncionarios);
        printListOfEmployees(listaDeFuncionarios);
   
    }

    private void removeEmployee(LinkedList<Funcionario> listaDeFuncionarios) {
        String deleteName = "João";
        listaDeFuncionarios.removeIf(funcionario -> Objects.equals(funcionario.getName(), deleteName));
    }

    private static void printListOfEmployees(LinkedList<Funcionario> listaDeFuncionarios) {
        System.out.printf("%-20s%-25s%-20s%-20s\n", "Nome", "Data de Nascimento", "Salário", "Função");

        for (Funcionario func : listaDeFuncionarios) {
            if(func.getName() != "João") {
                System.out.printf("%-20s%-25sR$%-18s%-20s\n", func.getName(), func.getFormattedBirthdayDate(), func.getSalarioFormatado(), func.getRole());
            } else {
                System.out.printf("Aquiiiiiiiii");
            }
        }
    }
}
