
#TB_ENDERECO
INSERT INTO `tb_endereco`(`bairro`, `cep`, `cidade`, `estado`, `numero`, `rua`) VALUES ("Guararema","12443200","Campinas","SP","125","Rua Rio Speers do Sul")
INSERT INTO `tb_endereco`(`bairro`, `cep`, `cidade`, `estado`, `numero`, `rua`) VALUES ("Barra Funda","06754902","São Paulo","SP","16","Av Matarazzo")
INSERT INTO `tb_endereco`(`bairro`, `cep`, `cidade`, `estado`, `numero`, `rua`) VALUES ("Agua Branca","09982802","São Paulo","SP","55","Rua Jorge Sabugar")

#TB_CONTATO
INSERT INTO `tb_contato`(`email`) VALUES ('mat.s.ferreira@gmail.com')
INSERT INTO `tb_contato`(`email`) VALUES ('mar_vermelho@outlook.com.br')
INSERT INTO `tb_contato`(`email`) VALUES ('math.higiene@co.br')
INSERT INTO `tb_contato`(`email`) VALUES ('dia@mercadodia.com')
INSERT INTO `tb_contato`(`email`) VALUES ('maysaprado@gmail.com')

#TB_FORNECEDOR
INSERT INTO `tb_fornecedor`(`cnpj`, `nome`, `ramo`, `contato_id`, `endereco_id`) VALUES ("21398719313","Math Produtos Higiene Ltda","Produtos higiene","2","3")
INSERT INTO `tb_fornecedor`(`cnpj`, `nome`, `ramo`, `contato_id`, `endereco_id`) VALUES ("02382890343","Supermercado Dia","Alimentos","4","2")

#TB_PESSOA
INSERT INTO `tb_pessoa`(`nome`, `status_pessoa`, `contato_id`, `endereco_id`) VALUES ("Matheus Ferreira","4","1","2")
INSERT INTO `tb_pessoa`(`nome`, `status_pessoa`, `contato_id`, `endereco_id`) VALUES ("Maysa Prado","4","5","1")

#TB_PRODUTO
INSERT INTO `tb_produto`(`data`, `descricao_produto`, `quantidade`, `status_caixa`, `status_pagamento`, `valor`) VALUES ("2020-06-06 14:03:00","Alvejante","2","2","2","16.20")
INSERT INTO `tb_produto`(`data`, `descricao_produto`, `quantidade`, `status_caixa`, `status_pagamento`, `valor`) VALUES ("2020-06-06 14:10:00","Limpador de vidro","1","2","2","6.90")
INSERT INTO `tb_produto`(`data`, `descricao_produto`, `quantidade`, `status_caixa`, `status_pagamento`, `valor`) VALUES ("2020-06-12 09:00:00","Café","5","2","1","6.90")

#TB_PRODUTO_FORNECEDOR
INSERT INTO `tb_produto_fornecedor`(`produto_id`, `fornecedor_id`) VALUES ("1","1")
INSERT INTO `tb_produto_fornecedor`(`produto_id`, `fornecedor_id`) VALUES ("2","1")
INSERT INTO `tb_produto_fornecedor`(`produto_id`, `fornecedor_id`) VALUES ("3","2")

#TB_TELEFONE
INSERT INTO `tb_telefone`(`numero_telefone`, `tipo_telefone`, `contato_id`) VALUES ("1143008087","2","4")
INSERT INTO `tb_telefone`(`numero_telefone`, `tipo_telefone`, `contato_id`) VALUES ("1134349883","2","3")
INSERT INTO `tb_telefone`(`numero_telefone`, `tipo_telefone`, `contato_id`) VALUES ("11987654099","3","1")
INSERT INTO `tb_telefone`(`numero_telefone`, `tipo_telefone`, `contato_id`) VALUES ("14987627348","3","5")
INSERT INTO `tb_telefone`(`numero_telefone`, `tipo_telefone`, `contato_id`) VALUES ("11449909922","2","2")
