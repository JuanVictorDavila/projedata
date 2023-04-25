package projectProjedata.Classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Pessoa {

    private String nome;
    private LocalDate dataNascimento;

    public Pessoa() {
    }

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getName() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public LocalDate getBirthday() {
        return dataNascimento;
    }

    public String getFormattedBirthdayDate() {
        return dataNascimento.format(formataData);
    }

    public void setBirthday(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome) && Objects.equals(dataNascimento, pessoa.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataNascimento);
    }
}