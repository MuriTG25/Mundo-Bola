# Mundo-Bola
![](https://pandao.github.io/editor.md/examples/images/4.jpg)

É um projeto que simulo um sistema de cadastro de produtos e genrenciamento de estoque de uma loja de bolas<br />
Ele foi desenvolvido no sistema Android em Kotlin e conta com o sistema do Jetpack Compose para implementação de telas<br />
O aplicativo roda em aparelhos android a partir da versão 7.0 (SDK 24) até a versão mais atual (até o momento), a 14 (SDK 34)<br />
Ele usa principios de arquitetura android e utiliza o modelo MVVM <br />
Além do aplicativo, farei um modelo físico do banco de dados, e também farei um banco de dados no MySQL para simular o funcionamento do mesmo. <br />
O projeto está dividido em 4 fases<br />

# Fase atual
### Pré Alpha

Nesta fase farei uma implementação mais simples, onde vou apenas fazer um sistema de cadastro de bolas.<br />
Ele se constiste em 3 telas diferentes:<br />
 - Tela de produtos: é a tela principal, onde serão mostrados todos os modelos de bolas. Nesta tela será possivel ir para o cadastro de bola e a descrição da bola
 - Tela de cadastro e edição: tela onde será feita o cadastro de produtos e edição dos produtos já existentes. Mas para ser salvos, terão que passar por uma série de validações
 - Tela de detalhes do produto: tela onde veremos mais detalhes do produto, e onde poderemos editar e deletar o produto.

Ele conta com sistema de navegação entre telas com o navigation, sistema de gerenciamento de estados com View Model e Ui State, injeção de dependências com o Hilt.<br />
O sistema de armazenamento ainda vai ser em lista, na próxima fase será implementada. E os testes automatizados, por falta de tempo, serão feitos posteriormente (talvez no final desta versão ou inicial da seguinte)<br />

Plugin utilizados:
 - Hilt
 - Navigation
 - Jetpack Compose
 - Material 3
 - Coil Compose

# Fases futuras
### Alpha

Nesta fase haverá um foco em implementar o banco de dados no projeto, com o Room. Além disso, pretendo implementar outras features, como:
 - Busca de produtos pelo nome do produto e da marca
 - Tela de bolas por marca
 - Aba lateral que mostra a aba de marcas
 - Cadastro e alteração das marcas
 - Opções de ordenamento dos produtos

Plugin utilizados:
 - Hilt
 - Navigation
 - Jetpack Compose
 - Material 3
 - Coil Compose
 - Room
 - Junit
 - Mockk
 - Navigation Test

### Beta

Nesta fase faremos a implementação do sistema de estoque, acrescentando o gerenciamento de quantidade de produtos em estoque para cada bola.<br />
Além disso, teremos uma tela mais focado em gerenciamento de estoque e outro para cadastro de produto.<br />
Haverá um sistema de login de usuários, com sistema de limitação de acesso para algumas features apenas para aqueles que tem permissão de adm.<br />
As imagens não serão mais salvas em url e sim num sistema de armazenamento interno do app, com possiblidade de buscar imagens dentro do aparelho android.<br />
Terá um uma redesign maior na parte de UX/UI do aplicativo.<br />

Plugin utilizados:
 - Hilt
 - Navigation
 - Jetpack Compose
 - Material 3
 - Coil Compose
 - Room
 - DataStore
 - Documentfile
 - Junit
 - Mockk
 - Navigation Test

### Lançamento (1.0)
Na fase final focaremos em aplicar um sistema online-first para o aplicativo, tendo um sistema de conversa com o servidor através de requisições Json com o Ktor (pode ser o Retrofit). <br />
Pode ser que criemos ou não um servidor local bem simples para armazenar o banco de dados em um sistema bem simples de back-end. <br />
Se houver futuras atualizações, serão apenas correções de bug e/ou pequenas implementações.

Plugin utilizados (aplicativo):
 - Hilt
 - Navigation
 - Jetpack Compose
 - Material 3
 - Coil Compose
 - Room
 - DataStore
 - Ktor (pode ser Retrofit)
 - Junit
 - Mockk
 - Navigation Test


Plugin utilizados(servidor em Kotlin):
 - Spring boot
 - Retrofit
 - Não defini o resto
