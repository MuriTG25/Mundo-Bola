# Mundo-Bola
É um projeto que simulo um sistema de cadastro de produtos e genrenciamento de estoque de uma loja de bolas<br />
Ele foi desenvolvido em Kotlin no sistema Android e conta com o sistema do Jetpack Compose para implementação de telas<br />
O aplicativo roda em aparelhos android a partir da versão 7.0 (SDK 24) até a versão mais atual (até o momento), a 14 (SDK 34)<br />
Ele usa principios de arquitetura android e utiliza o modelo MVVM <br />
O projeto está dividido em 4 fases<br />

#Fase atual
# Pré Alpha

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

#Fase atual
# Pré Alpha
