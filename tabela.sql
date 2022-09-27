create table glo_glossario (
    glo_id bigint primary key auto_increment,
    glo_termo varchar(30) not null,
    glo_significado varchar(50) not null,
    glo_sigla varchar(5)
);

insert into glo_glossario (glo_termo, glo_significado, glo_sigla)
values ('prova', 'Avaliação', 'pv'), ('rodovia', 'Estrada', 'ed');