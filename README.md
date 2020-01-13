Projeto RDS-SCHOOL-ADMIN: Command

# Objetivo

Desenvolver um sistema para gerenciar as matrículas nas turmas de uma escola. 

# Contexto de Negócio

- Uma turma é formada por vários alunos e várias disciplinas, possui um ano e período letivo e um número limitado de vagas. 
- Uma disciplina é ministrada por um professor em uma turma e possui uma carga horária. 
- Um aluno, faz a matrícula em uma turma e possui uma forma de ingresso (ENADE, vestibular).
- Um professor possui titulação (mestre, doutor, PHD).

# Orientações

- Você pode pesquisar em outros códigos de outros projetos do repositório. Tente identificar os padrões e estruturas utilizadas pelos outros desenvolvedores. 
- Não se esqueça dos testes unitários e de integração! Ele é essencial ao seu código.
- Utilize o padrão de arquitetura CQRS, onde temos um serviço para os comandos e um outro serviço para consultas. 

# Front-end

- Criar uma tela para o processo de abertura de turma, no qual é adicionada as informações básicas, adicionado às disciplinas e adicionado os alunos (Um Wizard). 
- Caso um professor ainda não exista, permitir criá-lo no meio do processo de abertura de turma. 
- Caso uma disciplina não exista, permitir criar e relacionar a um professor no meio do processo de abertura de turma. 
- Caso um aluno ainda não exista, permitir criá-lo no meio do processo de abertura de turma. 
