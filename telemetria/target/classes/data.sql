INSERT into CLIENTE(nome_Cliente,endereco,numero,bairro,cidade,uf,cep) values('Cliente1','Rua1','1','Bairro1','Cidade1','UM','11111111');
INSERT into EQUIPAMENTO(nome_Equipamento,quantidade_Sensores,numero_Serie_Equipamento,fabricante) values('equip1','10','64556','gasBR');
INSERT into INSTALACAO(codigo_cliente,codigo_equipamento,data_instalacao,status) values(1,1,'2019-05-05 18:00:00','REALIZADA');

INSERT into CLIENTE(nome_Cliente,endereco,numero,bairro,cidade,uf,cep) values('Cliente2','Rua2','2','Bairro2','Cidade2','TO','22222222');
INSERT into EQUIPAMENTO(nome_Equipamento,quantidade_Sensores,numero_Serie_Equipamento,fabricante) values('equip2','20','68526','gasSP');
INSERT into INSTALACAO(codigo_cliente,codigo_equipamento,data_instalacao,status) values(2,2,'2019-05-05 18:00:00','EM_ANDAMENTO');

INSERT into CLIENTE(nome_Cliente,endereco,numero,bairro,cidade,uf,cep) values('Cliente3','Rua3','3','Bairro3','Cidade3','TR','33333333');
INSERT into EQUIPAMENTO(nome_Equipamento,quantidade_Sensores,numero_Serie_Equipamento,fabricante) values('equip3','30','66666','gasRJ');
INSERT into INSTALACAO(codigo_cliente,codigo_equipamento,data_instalacao,status) values(3,3,'2019-05-05 18:00:00','AGUARDANDO_CONFIRMAÇÃO');