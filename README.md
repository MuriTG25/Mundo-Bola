# Mundo-Bola
![](https://raw.githubusercontent.com/MuriTG25/Mundo-Bola/main/mundo-bola-logo.jpeg)

É um projeto que simula um sistema de cadastro de produtos e genrenciamento de estoque de uma loja de bolas<br />
Ele foi desenvolvido no sistema Android em Kotlin e conta com o sistema do Jetpack Compose para implementação de telas<br />
O aplicativo roda em aparelhos android a partir da versão 7.0 (SDK 24) até a versão mais atual (até o momento), a 14 (SDK 34)<br />
Ele usa principios de arquitetura android e utiliza o modelo MVVM <br />
Além do aplicativo, farei um modelo físico do banco de dados, e também farei um banco de dados no MySQL para simular o funcionamento do mesmo. <br />
O projeto está dividido em 4 fases<br />

# Fase atual

### Alpha

Nesta fase haverá um foco em implementar o banco de dados no projeto, com o Room. Além disso, temos o acréscimo de outras features, como:
 - Barra de pesquisa para encontrar a bola pelo nome
 - Icones que ordenam a lista por nome, preco ou data de criação
 - Tela de detalhes da marca
 - Navigation Drawer que mostra as marcas 
 - Tela de Cadastro e alteração das marcas

Plugin utilizados:
 - Hilt
 - Navigation
 - Jetpack Compose
 - Material 3
 - Coil Compose
 - Room
 - Junit
 - Kluent
 - Mockk
 - Ui Automator
 - Hilt Android Testing
 - Espresso
 - Leakcanary

# Fases futuras

### Beta

Nesta fase faremos um sistema de login de usuários, com sistema de limitação de acesso para algumas features apenas para aqueles que tem permissão de adm.<br />
Com o acréscimo do sistema de usuários, teremos o acrescimo de migrations para a persistência de dados, mesmo com alterações em sua estrutura.<br />
As imagens não serão mais salvas apenas em url, mas como também num sistema de armazenamento interno do app, com possiblidade de buscar imagens dentro do aparelho android.<br />
Dentro da classe bola, haverá outra subclasse que adiciona mais detalhes da bola.</br>
Terá um uma redesign maior na parte de UX/UI do aplicativo.<br />
Faremos um reformulações nas transições de telas do Navigation.<br />
Substituição do toast pelo Snackbar para mostrar avisos.<br />

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
 - Kluent
 - Mockk
 - Ui Automator
 - Hilt Android Testing
 - Espresso
  - Leakcanary
 

### Lançamento (1.0)
Na fase final focaremos em aplicar um sistema online-first para o aplicativo, tendo um sistema de conversa com o servidor através de requisições Json com o Ktor (pode ser o Retrofit). <br />
Pode ser que criemos ou não um servidor local bem simples para armazenar o banco de dados em um sistema bem simples de back-end. <br />
Se houver futuras atualizações neste aplicativo, serão apenas correções de bug e/ou pequenas implementações.

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
 - Kluent
 - Mockk
 - Navigation Test
 - Ui Automator
 - Hilt Android Testing
 - Espresso


Plugin utilizados(servidor em Kotlin):
 - Spring boot
 - Retrofit
 - Não defini o resto</br></br>

 ### Mundo Bola Armazém

 Anteriormente na fase beta, percebi que essa implementação seria mais complexa e teria que crescer muito o projeto de uma maneira abrupta.</br>
 A implementação em questão era do sistema de estoque, onde criariamos um sistema de gerenciamento de quantidade de produtos em estoque para cada bola.</br>
Decidi então criar um aplicativo novo, separando em 2. Um deles, é o que já foi implementado, o Mundo Bola cadastro, focado em cadastro de bolas e marcas.</br>
E esse novo aplicativo, o Mundo Bola Armazem, que será um aplicativo focado em gerenciamento de quantidade de itens de uma loja.</br></br>
Nesta fase  teremos 2 módulos no mesmo projeto. Ou seja, teremos um projeto multimodular, onde teremos reaproveitamento de implemetações do primeiro aplicativo no outro.</br>
E além disso, alteramentos a versão do build.gradle para a versão Catalog, que é melhor para projetos multimodulares.

# Fases anteriores

### Pré Alpha

Nesta fase farei uma implementação mais simples, onde vou apenas fazer um sistema de cadastro de bolas.<br />
Ele se constiste em 3 telas diferentes:<br />
 - Tela de produtos: é a tela principal, onde serão mostrados todos os modelos de bolas. Nesta tela será possivel ir para o cadastro de bola e a descrição da bola
 - Tela de cadastro e edição: tela onde será feita o cadastro de produtos e edição dos produtos já existentes. Mas para ser salvos, terão que passar por uma série de validações
 - Tela de detalhes do produto: tela onde veremos mais detalhes do produto, e onde poderemos editar e deletar o produto.

Ele conta com sistema de navegação entre telas com o navigation, sistema de gerenciamento de estados com View Model e Ui State, injeção de dependências com o Hilt.<br />
Serão feitos testes de unidade, testes de Mock e testes de UI.<br />
O sistema de armazenamento ainda vai ser em lista, na próxima fase será implementada o banco de dados.<br />

Plugin utilizados:
 - Hilt
 - Navigation
 - Jetpack Compose
 - Material 3
 - Coil Compose
 - Junit
 - Kluent
 - Navigation Test
 - Mockk
 - Ui Automator
 - Hilt Android Testing
 - Espresso



