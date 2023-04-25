package projectProjedata.Classes;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Objects;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalary() {
        return salario;
    }

    public void setSalary(BigDecimal salario) {
        this.salario = salario;
    }

    public String getRole() {
        return funcao;
    }

    public void setRole(String funcao) {
        this.funcao = funcao;
    }

    public String getSalarioFormatado() {
        return formatarSalario.format(salario).replace(".", ",").replaceFirst(",", ".");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(salario, that.salario) && Objects.equals(funcao, that.funcao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salario, funcao);
    }

    DecimalFormat formatarSalario = new DecimalFormat("###,##0.00");

    @Override
    public String toString() {
        return String.format("%-20s%-25sR$%-20s%-20s", this.getName(), this.getFormattedBirthdayDate(), this.getSalarioFormatado(), this.getRole());
    }
}
