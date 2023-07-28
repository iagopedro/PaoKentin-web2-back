create table fornada(
    id int not null auto_increment,
    horarioInicial date not null,
    pao_id int not null,

    primary key (id),
    CONSTRAINT fk_fornadapao FOREIGN KEY (pao_id) REFERENCES pao(id)
);