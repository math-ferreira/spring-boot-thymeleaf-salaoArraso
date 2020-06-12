# spring-boot-thymeleaf-salaoArraso
Projeto com SpringBoot e Thymeleaf para gerenciamento de Agenda de um Salão de Beleza

# Aplicação para gerenciamento - Salão ARRAZUS!
Sistema para gerenciamento de serviços de salão de beleza. Estara disponivel o gerenciamento de calendario, bem como a agenda de serviços do estabelecimento. 

- Tecnologias utilizadas:

![image](https://user-images.githubusercontent.com/48540484/84463495-5c09f280-ac48-11ea-9be7-e71a13a6e133.png)

- Requisitos funcionais:
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

- Requisitos não funcionais:
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



- Modelo Entidade Relacionamento:

![image](https://user-images.githubusercontent.com/48540484/84463536-78a62a80-ac48-11ea-9ec4-fd1d582993b3.png)
