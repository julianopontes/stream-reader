# stream-reader

[![Circle CI](https://circleci.com/gh/julianopontes/stream-reader/tree/master.svg?style=shield&circle-token=ce9d42c73d4a5600802390ae4c2f475de194f970)](https://circleci.com/gh/julianopontes/stream-reader/tree/master)
[![Coverage Status](https://coveralls.io/repos/julianopontes/stream-reader/badge.svg?branch=master&service=github)](https://coveralls.io/github/julianopontes/stream-reader?branch=master)

## Descrição
Serviço de validação e busca de _Stream_ de caracteres
- Disponível serviço para busca do primeiro caractere não repetido de um determinado _Stream_ (String), chamado _"firstChar"_.

## Estrutura do projeto
A classe utilitária de caractere é chamada [FirstNotRepeatedChar](https://github.com/julianopontes/stream-reader/blob/master/src/main/java/com/jop/stream/FirstNotRepeatedChar.java), ela expõe o método de busca do primeiro caractere não repetido de um determinado _Stream_.

A interface [Stream](https://github.com/julianopontes/stream-reader/blob/master/src/main/java/com/jop/stream/Stream.java) serve para manipulação de uma determinada ordem de caracteres (texto).

Com isso, dada uma ordem de caracteres (texto), é possível pesquisar o primeiro caractere não repetido no "texto" informado.
