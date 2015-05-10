# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table alternativa (
  id                        bigint auto_increment not null,
  indice                    bigint,
  titulo                    varchar(255),
  questao_id                bigint,
  constraint pk_alternativa primary key (id))
;

create table prova (
  id                        bigint auto_increment not null,
  titulo                    varchar(255),
  criacao                   datetime,
  author_email              varchar(255),
  constraint pk_prova primary key (id))
;

create table questao (
  id                        bigint auto_increment not null,
  titulo                    TEXT,
  resposta_aberta           varchar(255),
  correta_index             bigint,
  prova_id                  bigint,
  tipo                      varchar(7),
  constraint ck_questao_tipo check (tipo in ('aberta','fechada')),
  constraint pk_questao primary key (id))
;

create table resposta (
  id                        bigint auto_increment not null,
  resposta                  varchar(255),
  resposta_prova_id         bigint,
  constraint pk_resposta primary key (id))
;

create table resposta_prova (
  id                        bigint auto_increment not null,
  prova_id                  bigint,
  constraint pk_resposta_prova primary key (id))
;

create table user (
  email                     varchar(255) not null,
  password                  varchar(255),
  hash                      varchar(255),
  constraint pk_user primary key (email))
;


create table prova_user (
  prova_id                       bigint not null,
  user_email                     varchar(255) not null,
  constraint pk_prova_user primary key (prova_id, user_email))
;
alter table alternativa add constraint fk_alternativa_questao_1 foreign key (questao_id) references questao (id) on delete restrict on update restrict;
create index ix_alternativa_questao_1 on alternativa (questao_id);
alter table prova add constraint fk_prova_author_2 foreign key (author_email) references user (email) on delete restrict on update restrict;
create index ix_prova_author_2 on prova (author_email);
alter table questao add constraint fk_questao_prova_3 foreign key (prova_id) references prova (id) on delete restrict on update restrict;
create index ix_questao_prova_3 on questao (prova_id);
alter table resposta add constraint fk_resposta_respostaProva_4 foreign key (resposta_prova_id) references resposta_prova (id) on delete restrict on update restrict;
create index ix_resposta_respostaProva_4 on resposta (resposta_prova_id);
alter table resposta_prova add constraint fk_resposta_prova_prova_5 foreign key (prova_id) references prova (id) on delete restrict on update restrict;
create index ix_resposta_prova_prova_5 on resposta_prova (prova_id);



alter table prova_user add constraint fk_prova_user_prova_01 foreign key (prova_id) references prova (id) on delete restrict on update restrict;

alter table prova_user add constraint fk_prova_user_user_02 foreign key (user_email) references user (email) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table alternativa;

drop table prova;

drop table prova_user;

drop table questao;

drop table resposta;

drop table resposta_prova;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

