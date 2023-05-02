package projectProjedata.Main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

import projectProjedata.Classes.Funcionario;
import projectProjedata.Classes.Pessoa;

public class Main {
    public static void main(String[] args) {
        LinkedList<Funcionario> listaDeFuncionarios = new LinkedList<>();

        registerEmployees(listaDeFuncionarios);
        removeEmployee(listaDeFuncionarios);
        
        System.out.println("\n________________________________________________________________\n");
        System.out.println("\nLista dos funcionários: \n");
        printListOfEmployees(listaDeFuncionarios);

        System.out.println("\n________________________________________________________________\n");
        applySalaryIncrease(listaDeFuncionarios);

        System.out.println("Lista dos funcionários ordenados por função: \n"); 
        employeesGroupedByRole(listaDeFuncionarios);

        System.out.println("________________________________________________________________\n");
        System.out.println("Lista dos funcionários com mês de aniversário 10 e 12: \n");
        getByBirthday(listaDeFuncionarios);

        System.out.println("\n________________________________________________________________\n");
        System.out.println("Lista dos funcionários ordenados em ordem alfabética: \n");
        alfabeticalOrder(listaDeFuncionarios);

        System.out.println("\n________________________________________________________________\n");
        String totalSalaries = sumAllSalaries(listaDeFuncionarios);
        System.out.println("Total de todos os salários dos funcionários é: R$" + totalSalaries);
        System.out.println("\n________________________________________________________________\n");
        System.out.println("Quantidade de salários mínimos:\n");
        minimumSalaryQuantity(listaDeFuncionarios);
        System.out.println("\n________________________________________________________________\n");
    }

    private static void registerEmployees(LinkedList<Funcionario> listaDeFuncionarios) {
        listaDeFuncionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador"));
        listaDeFuncionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), BigDecimal.valueOf(2284.38), "Operador"));
        listaDeFuncionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), BigDecimal.valueOf(9836.14), "Coordenador"));
        listaDeFuncionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.88), "Diretor"));
        listaDeFuncionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), BigDecimal.valueOf(2234.68), "Recepcionista"));
        listaDeFuncionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador"));
        listaDeFuncionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), BigDecimal.valueOf(4071.84), "Contador"));
        listaDeFuncionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), BigDecimal.valueOf(3017.45), "Gerente"));
        listaDeFuncionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), BigDecimal.valueOf(1606.85), "Eletricista"));
        listaDeFuncionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), BigDecimal.valueOf(2799.93), "Gerente"));
    }

    private static void removeEmployee(LinkedList<Funcionario> listaDeFuncionarios) {
        String deleteName = "João";
        listaDeFuncionarios.removeIf(funcionario -> Objects.equals(funcionario.getName(), deleteName));
    }

    private static void printListOfEmployees(LinkedList<Funcionario> listaDeFuncionarios) {
        System.out.printf("%-20s%-25s%-20s%-20s\n", "Nome", "Data de Nascimento", "Salário", "Função");

        for (Funcionario func : listaDeFuncionarios) {
            System.out.printf("%-20s%-25sR$%-18s%-20s\n", func.getName(), func.getFormattedBirthdayDate(), func.getSalarioFormatado(), func.getRole());
        }
    }

    private static void applySalaryIncrease(LinkedList<Funcionario> listaDeFuncionarios) {
        for (Funcionario listaDeFuncionario : listaDeFuncionarios) {
            listaDeFuncionario.setSalary(listaDeFuncionario.getSalary().multiply(BigDecimal.valueOf(1.1)));
        }
    }

    private static Map<Object, List<Funcionario>> groupEmployeesByRole(LinkedList<Funcionario> listaDeFuncionarios) {
        return listaDeFuncionarios.stream().collect(Collectors.groupingBy(Funcionario::getRole));
    }

    private static void employeesGroupedByRole(LinkedList<Funcionario> listaDeFuncionarios) {
        Map<Object, List<Funcionario>> employeesGroupedByRole = groupEmployeesByRole(listaDeFuncionarios);
        
        for (Map.Entry<Object, List<Funcionario>> entry : employeesGroupedByRole.entrySet()) {
            System.out.println(entry.getKey() + ": ");
            entry.getValue().stream().forEach(System.out::println);
            System.out.println();
        }
    }

    private static void getByBirthday (LinkedList<Funcionario> listaDeFuncionarios) {
        listaDeFuncionarios.stream()
        .filter((funcionario) ->
                funcionario.getBirthday().getMonth() == ((Month.of(10))))
        .forEach(System.out::println);

        listaDeFuncionarios.stream()
        .filter((funcionario) ->
                funcionario.getBirthday().getMonth() == ((Month.of(12))))
        .forEach(System.out::println);
    }

    private static void alfabeticalOrder (LinkedList<Funcionario> listaDeFuncionarios) {
        listaDeFuncionarios.sort(Comparator.comparing(Pessoa::getName));

        printListOfEmployees(listaDeFuncionarios);
    }

    private static String sumAllSalaries (LinkedList<Funcionario> listaDeFuncionarios) {
        BigDecimal somaDosSalarios = listaDeFuncionarios.stream()
        .map(Funcionario::getSalary)
        .reduce(BigDecimal.ZERO, BigDecimal::add);

        DecimalFormat formatarSalario = new DecimalFormat("###,##0.00");
        String salarioFormatado = formatarSalario.format(somaDosSalarios).replace(".", ",").replaceFirst(",", ".");

        return salarioFormatado;
    }

    private static void minimumSalaryQuantity (LinkedList<Funcionario> listaDeFuncionarios) {
        BigDecimal salarioMinimo = BigDecimal.valueOf(1212.00);

        DecimalFormat formatarQuantidadeDeSalariosMinimos = new DecimalFormat("#,##0.00");

        for (Funcionario func : listaDeFuncionarios) {
            String quantidadeDeSalariosMinimos = formatarQuantidadeDeSalariosMinimos.format(func.getSalary().divide(salarioMinimo, RoundingMode.CEILING)).replace(".", ",").replaceFirst(",", ".");
            System.out.println(func.getName() + ": " + quantidadeDeSalariosMinimos + " salarios mínimos");
        }
    }
}
