create table turma (
    id             varchar(36)     not null,
    data           Jsonb           not null,
    primary key (id)
);

create table pessoa (
    id             varchar(36)     not null,
    data           Jsonb           not null,
    primary key (id)
);

create table professor (
    id             varchar(36)     not null,
    data           Jsonb           not null,
    primary key (id)
);

create table aluno (
    id             varchar(36)     not null,
    data           Jsonb           not null,
    primary key (id)
);

create table disciplina (
    id             varchar(36)     not null,
    data           Jsonb           not null,
    primary key (id)
);
