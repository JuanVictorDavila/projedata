# Projedata

## Projeto desenvolvido na etapa de Teste Técnico

---

## Teste Prático

Considerando que uma indústria possui as pessoas/funcionários abaixo:

Diante disso, você deve desenvolver um projeto java, com os seguintes requisitos:

1– Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).

2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).

3 – Deve conter uma classe Principal para executar as seguintes ações: <br>
3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima. <br>
3.2 – Remover o funcionário “João” da lista. <br>
3.3 – Imprimir todos os funcionários com todas suas informações, sendo que: <br>
• informação de data deve ser exibido no formato dd/mm/aaaa; <br>
• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula. <br>
3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor. <br>
3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”. <br>
3.6 – Imprimir os funcionários, agrupados por função. <br> 
3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12. <br>
3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade. <br>
3.10 – Imprimir a lista de funcionários por ordem alfabética. <br>
3.11 – Imprimir o total dos salários dos funcionários. <br>
3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00. <br>

![Tabela de Funcionários](table.png)

---

## Passos para executar o programa

* Download do arquivo ProjeData.jar dentro da pasta Target
* Abrir o cmd e ir até a pasta onde o arquivo foi salvo
* Executar o comando java -jar ProjeData.jar

```
C:\local\do\arquivo: java -jar projeData.jar
```

---

## Resultado
```
Lista dos funcionários:

Nome                Data de Nascimento       Salário             Função              
Maria               18/10/2000               R$2.009,44          Operador            
Caio                02/05/1961               R$9.836,14          Coordenador         
Miguel              14/10/1988               R$19.119,88         Diretor             
Alice               05/01/1995               R$2.234,68          Recepcionista       
Heitor              19/11/1999               R$1.582,72          Operador            
Arthur              31/03/1993               R$4.071,84          Contador            
Laura               08/07/1994               R$3.017,45          Gerente             
Heloísa             24/05/2003               R$1.606,85          Eletricista         
Helena              02/09/1996               R$2.799,93          Gerente             

________________________________________________________________

Lista dos funcionários ordenados por função:

Operador:
Maria               18/10/2000               R$2.210,38            Operador            
Heitor              19/11/1999               R$1.740,99            Operador            

Eletricista:
Heloísa             24/05/2003               R$1.767,54            Eletricista

Recepcionista:
Alice               05/01/1995               R$2.458,15            Recepcionista

Diretor:
Miguel              14/10/1988               R$21.031,87           Diretor

Gerente:
Laura               08/07/1994               R$3.319,20            Gerente             
Helena              02/09/1996               R$3.079,92            Gerente

Coordenador:
Caio                02/05/1961               R$10.819,75           Coordenador

Contador:
Arthur              31/03/1993               R$4.479,02            Contador

________________________________________________________________

Lista dos funcionários com mês de aniversário 10 e 12:

Maria               18/10/2000               R$2.210,38            Operador            
Miguel              14/10/1988               R$21.031,87           Diretor

________________________________________________________________

Lista dos funcionários ordenados em ordem alfabética:

Nome                Data de Nascimento       Salário             Função              
Alice               05/01/1995               R$2.458,15          Recepcionista       
Arthur              31/03/1993               R$4.479,02          Contador            
Caio                02/05/1961               R$10.819,75         Coordenador         
Heitor              19/11/1999               R$1.740,99          Operador            
Helena              02/09/1996               R$3.079,92          Gerente             
Heloísa             24/05/2003               R$1.767,54          Eletricista         
Laura               08/07/1994               R$3.319,20          Gerente             
Maria               18/10/2000               R$2.210,38          Operador            
Miguel              14/10/1988               R$21.031,87         Diretor

________________________________________________________________

A soma de todos os salários dos funcionários é: R$50.906,82

________________________________________________________________

Quantidade de salários mínimos:

Alice: 2.03
Arthur: 3.70
Caio: 8.93
Heitor: 1.44
Helena: 2.54
Heloísa: 1.46
Laura: 2.74
Maria: 1.82
Miguel: 17.35

```