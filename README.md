# spring-boot-thymeleaf-salaoArraso
Projeto com SpringBoot e Thymeleaf para gerenciamento de Agenda de um Salão de Beleza

# Aplicação para gerenciamento - Salão ARRAZUS!
Sistema para gerenciamento de serviços de salão de beleza. Estara disponivel o gerenciamento de calendario, bem como a agenda de serviços do estabelecimento. 

# Passos realizados no Projeto
1. Definição de Requisitos:
Levanta os requisitos mínimos, estuda a viabilidade e define o modelo a ser usado;

2. Documentação do Projeto:
Envolve atividades de concepção, especificação, design da interface, prototipação, design da arquitetura;

3. Implementação e desenvolvimento:
Tradução para uma linguagem de programação das funcionalidades definidas durante as fases anteriores;

4. Cobertura e testes:
Realização de testes no que foi desenvolvido de acordo com os requisitos;

5. Disponilização em produção:
Implantação em produção do produto final;

# Tecnologias utilizadas:

![image](https://user-images.githubusercontent.com/48540484/84463495-5c09f280-ac48-11ea-9be7-e71a13a6e133.png)

- **Requisitos funcionais:**
Se trata das funcionalidades que o sistema deve ter.

		1: O sistema deve permitir que o funcionario insira no calendário serviços a serem realizados;
		2: O sistema deve permitir que o funcionario remova do calendário serviços a serem realizados;
		3: O sistema deve possibilitar a consulta de serviços que já foram ou serão realizados;
		4: O sistema deve possibilitar a alteração apenas de serviços que serão realizados;
		5: O sistema possibilitara ao usuario inserir despesas do estabelecimento, como: contas, produtos, serviços, manutenções e gastos imprevistos para seu funcionamento;
		6: O sistema permitira inserir dados dos clientes, como: nome, endereço e contatos;
		7: O sistema permitira alterar os dados dos clientes;
		8: O sistema permitira remover clientes caso seja necessário;
		9: O sistema deverá apresentara a lista de clientes e seus respectivos contatos para consulta;
		10: O sistema apresentara os próximos serviços a serem realizados no estabelecimento, para o dia de referência;
		11: O sistema deverá alertar o funcionario na proximidade de horario para os próximos serviços a serem realizados;
		12: O sistema permitira inserir dados de fornecedores, como: nome, endereço e contatos;
		13: O sistema permitira alterar os dados dos fornecedores;
		14: O sistema permitira remover fornecedores caso seja necessário;
		15: O sistema deverá apresentara a lista de fornecedores e seus respectivos contatos para consulta;
		16: O sistema possibilitara consultar a movimentação de caixa, referente as entradas e saidas;
		17: O sistema possibilitara filtrar a movimentação de caixa por: entrada, tipo de entrada, saida, tipo de saida, dia, mês, ano e data vigente;

# Documentação

- **Requisitos não funcionais:**
Estes tratam de recursos que não são funcionalidades, mas sim características do sistema, como restrições, segurança, confiabilidade, velocidade, validações. entre outros.

		1: Desempenho:
			→ O processamento e tempo de resposta do sistema deverá ser rapido, haja vista que a base do sistema não terá vinculo com a internet da pessoa;
		2: Disponibilidade:
			→ Não haverá janela de manutenção, portanto o sistema não estara inoperante, podendo ser utilizado 24 h por dia;
			→ Todos os dados serão salvos instantaneamente no BD, caso ocorra indisponibilidade ou queda à nivel de hardware ou software;
		3: Segurança:
			→ Não haverá armazenamento de senhas e usuarios de sistema. Sistema será local, sem servidor web;
		4: Compatibilidade:
			→ Disponivel apenas para Sistema Operacional Windows. Será necessario que o SO tenha Browser de preferencia, Banco de Dados e JAVA instalado;
		5: Confiabilidade:
			→ A aplicaçao irá persisitir os dados em Banco de Dados. Será mantido tbm arquivo backup de aplicação, vinculando de preferência com o OneDrive;
			→ O Backup devera ser discutido, podendo ser uma ação schedulada batch, ou por requisição do usuario do sistema;
		6: Padrões:
			→ O sistema será desenvolvido em JAVA e utilizara o Spring Framework, seguindo a estrutura Spring Boot e Spring MVC para uma aplicação Web. 
			→ Utilizara o paradigma Orientada a Objetos para o desenvolvimento backend e também o paradigma Relacional para o Banco de Dados. A integragação entre os paradigmas será realizada com a implementação do Hibernate, através da biblioteca padrão de persistencia de objetos no JAVA, o JPA.
			→ Caso ocorra algum problema na aplicação, que não foi identificado nos testes, este estara disponivel em arquivos de logs do sistema (.txt);

- **Diagrama de Caso de Uso:** Auxilia no levantamento dos requisitos funcionais do sistema, descrevendo um conjunto de funcionalidades do sistema e suas interações com elementos externos.
![image](https://user-images.githubusercontent.com/48540484/91641512-4b714900-e9fb-11ea-96bf-2d0a3128a385.png)

- **Diagrama de Classes:** É a abstração de um objeto da vida real (vida real que será tratada via software), que agrupa dados (atributos) e procedimentos (operações) relacionados ao seu contexto.
![image](https://user-images.githubusercontent.com/48540484/91641521-54fab100-e9fb-11ea-9d34-36ce9000b486.png)

- **Diagrama Entidade Relacionamento (DER):** É um modelo conceitual utilizado na Engenharia de Software para descrever os objetos (entidades) envolvidos em um domínio de negócios, com suas características (atributos) e como elas se relacionam entre si (relacionamentos). Em geral, este modelo representa de forma abstrata a estrutura que possuirá o banco de dados da aplicação.

![image](https://user-images.githubusercontent.com/48540484/91641573-b3279400-e9fb-11ea-9d56-242ffdaf635e.png)

