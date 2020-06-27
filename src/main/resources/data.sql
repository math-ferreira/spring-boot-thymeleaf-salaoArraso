
#TB_ENDERECO
INSERT INTO `tb_endereco`(`bairro`, `cep`, `cidade`, `estado`, `numero`, `rua`) VALUES ("Guararema","12443200","Campinas","SP","125","Rua Rio Speers do Sul")
INSERT INTO `tb_endereco`(`bairro`, `cep`, `cidade`, `estado`, `numero`, `rua`) VALUES ("Barra Funda","06754902","São Paulo","SP","16","Av Matarazzo")
INSERT INTO `tb_endereco`(`bairro`, `cep`, `cidade`, `estado`, `numero`, `rua`) VALUES ("Agua Branca","09982802","São Paulo","SP","55","Rua Jorge Sabugar")
INSERT INTO `tb_endereco`(`bairro`, `cep`, `cidade`, `estado`, `numero`, `rua`) VALUES ("Vila Mariana","01232888","São Paulo","SP","418","Galpão Santa Luzia")

#TB_CONTATO
INSERT INTO `tb_contato`(`email`) VALUES ('mat.s.ferreira@gmail.com')
INSERT INTO `tb_contato`(`email`) VALUES ('math.higiene@co.br')
INSERT INTO `tb_contato`(`email`) VALUES ('dia@mercadodia.com')
INSERT INTO `tb_contato`(`email`) VALUES ('maysaprado@gmail.com')

#TB_FORNECEDOR
INSERT INTO `tb_fornecedor`(`cnpj`, `nome`, `ramo`, `contato_fk`, `endereco_fk`) VALUES ("21398719313","Math Produtos Higiene Ltda","Produtos higiene","2","3")
INSERT INTO `tb_fornecedor`(`cnpj`, `nome`, `ramo`, `contato_fk`, `endereco_fk`) VALUES ("02382890343","Supermercado Dia","Alimentos","3","4")

#TB_PESSOA
INSERT INTO `tb_pessoa`(`nome`, `contato_fk`, `endereco_fk`) VALUES ("Matheus Ferreira","1","2")
INSERT INTO `tb_pessoa`(`nome`, `contato_fk`, `endereco_fk`) VALUES ("Maysa Prado","4","1")

#TB_PRODUTO
INSERT INTO `tb_produto`(`data`, `descricao_produto`, `quantidade`, `status_caixa`, `status_pagamento`, `valor`) VALUES ("2020-06-06 14:03:00","Alvejante","2","2","2","16.20")
INSERT INTO `tb_produto`(`data`, `descricao_produto`, `quantidade`, `status_caixa`, `status_pagamento`, `valor`) VALUES ("2020-06-06 14:10:00","Limpador de vidro","1","2","2","6.90")
INSERT INTO `tb_produto`(`data`, `descricao_produto`, `quantidade`, `status_caixa`, `status_pagamento`, `valor`) VALUES ("2020-06-12 09:00:00","Café","5","2","1","6.90")

#TB_PRODUTO_FORNECEDOR
#INSERT INTO `tb_produto_fornecedor`(`produto_fk`, `fornecedor_fk`) VALUES ("1","1")
#INSERT INTO `tb_produto_fornecedor`(`produto_fk`, `fornecedor_fk`) VALUES ("2","1")
#INSERT INTO `tb_produto_fornecedor`(`produto_fk`, `fornecedor_fk`) VALUES ("3","2")

#TB_TELEFONE
INSERT INTO `tb_telefone`(`numero_telefone`, `tipo_telefone`, `contato_fk`) VALUES ("1143008087","2","4")
INSERT INTO `tb_telefone`(`numero_telefone`, `tipo_telefone`, `contato_fk`) VALUES ("1134349883","2","3")
INSERT INTO `tb_telefone`(`numero_telefone`, `tipo_telefone`, `contato_fk`) VALUES ("11987654099","3","1")
#INSERT INTO `tb_telefone`(`numero_telefone`, `tipo_telefone`, `contato_fk`) VALUES ("14987627348","3","5")
INSERT INTO `tb_telefone`(`numero_telefone`, `tipo_telefone`, `contato_fk`) VALUES ("11449909922","2","2")

#TB_SERVICO
INSERT INTO `tb_servico`(`pessoa_fk`) VALUES ('2')
INSERT INTO `tb_servico`(`pessoa_fk`) VALUES ('1')

#TB_ATENDIMENTO
INSERT INTO `tb_atendimentos_marcados`(`atendimento_realizado`, `data_atendimento`, `modo_pagamento`, `status_pagamento`, `tipo_atendimento`, `valor_atendimento`, `servico_fk`) VALUES (false,'2020/06/26 14:40','1','4','1','132','1')
INSERT INTO `tb_atendimentos_marcados`(`atendimento_realizado`, `data_atendimento`, `modo_pagamento`, `status_pagamento`, `tipo_atendimento`, `valor_atendimento`, `servico_fk`) VALUES (false,'2020/06/30 07:00','4','1','2','40','1')
INSERT INTO `tb_atendimentos_marcados`(`atendimento_realizado`, `data_atendimento`, `modo_pagamento`, `status_pagamento`, `tipo_atendimento`, `valor_atendimento`, `servico_fk`) VALUES (false,'2020/06/27 11:30','2','2','3','25','1')
INSERT INTO `tb_atendimentos_marcados`(`atendimento_realizado`, `data_atendimento`, `modo_pagamento`, `status_pagamento`, `tipo_atendimento`, `valor_atendimento`, `servico_fk`) VALUES (false,'2020/06/22 19:10','2','1','4','70','1')
INSERT INTO `tb_atendimentos_marcados`(`atendimento_realizado`, `data_atendimento`, `modo_pagamento`, `status_pagamento`, `tipo_atendimento`, `valor_atendimento`, `servico_fk`) VALUES (false,'2020/07/13 09:50','3','3','3','55','1')
INSERT INTO `tb_atendimentos_marcados`(`atendimento_realizado`, `data_atendimento`, `modo_pagamento`, `status_pagamento`, `tipo_atendimento`, `valor_atendimento`, `servico_fk`) VALUES (false,'2020/06/29 17:00','1','3','1','99.90','2')
INSERT INTO `tb_atendimentos_marcados`(`atendimento_realizado`, `data_atendimento`, `modo_pagamento`, `status_pagamento`, `tipo_atendimento`, `valor_atendimento`, `servico_fk`) VALUES (false,'2020/06/27 21:30','1','3','2','100','2')