create table `resposta`(
`id` int(11) not null auto_increment,
`aluno` int(11) not null,
`questao` int(11) not null,
`codfonte` longblob,
primary key (`id`),
CONSTRAINT `fk_resposta_aluno` FOREIGN KEY (`aluno`) REFERENCES `usuario` (`id`),
CONSTRAINT `fk_resposta_questao` FOREIGN KEY (`questao`) REFERENCES `questao` (`id`)
)