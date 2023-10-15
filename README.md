# Pré Alpha

Ela será a fase inicial do projeto. Como ainda estou fazendo os cursos da alura, ela terá uma implementação super simples, sem focar muito na parte de design, ux/ui, deixando os testes automáticos parea um futuro próximo, focando mais na parte de arquitetura e implementar as bases para facilitar a escalabilidade do projeto.<br /><br />
Nesta fase farei uma implementação mais simples, onde vou apenas fazer um sistema de cadastro de bolas.<br />
Ele se constiste em 3 telas diferentes:<br />

### Tela de produtos
É a tela principal, onde serão mostrados todos os modelos de bolas. <br />
Utilizamos o sistema de Lazy Grid para repetir os designs e mostrar a lista toda <br />
Nesta tela será possivel ir para o cadastro de bola clicando no Fab que está abaixo. <br />
E também poderemos ir para a tela de detalhes de bolas ao clicar no produto. <br />

### Tela de cadastro e edição
É a tela onde será feita o cadastro de produtos e edição dos produtos já existentes. <br />
Nela utilizaremos um dialog para inserir o link da imagem.<br />
Também haverá os Outlines Text Field para preencher os dados. <br />
Além do Exposed Dropdown Menu Box para listar todas as marcas disponíveis e mandar o id da marca selecionada. <br />
Apenas o campo preço e nome serão obrigatórios. <br />
Caso clique em salvar sem preencher preço e/ou nome, aparecerá um aviso em cima do campo de texto avisando que são campos obrigatórios. <br />
Caso haja um preenchimento inválido de preço, haverá um dialog mostrando uma mensagem de erro. <br />
Se tudo estiver certo, ao clicar no botão salvar, a bola será salva. <br />
Ele conta com 1 Top App Bar Icon, que é o botão de volta para a tela anterior
Ps: Ainda será feita a edição do produto. <br />

### Tela de detalhes do produto
É a tela onde veremos mais detalhes do produto
Nela será mostrado a imagem da bola, com a possibilidade de expandir a visualização com o dialog <br />
Haverá 3 Top App Bar Icon
 - Botão de volta para a tela anterior
 - Botão de edição que vai para a tela de edição de bola
 - Botão de exclusão, onde será excluído o produto

# Features

Ele conta com sistema de navegação entre telas através do navigation.<br />
O gerenciamento de estados das telas serão feitas com o com View Model e Ui State.<br />
A injeção de dependências será feita com o Hilt.<br />
O sistema que carrega as imagens será feita pelo Coil Compose, através de url da imagem. <br />
O sistema de armazenamento ainda vai ser em lista com o DAO, na próxima fase será implementada o banco de dados.<br />
Uso do Repositório para comunicação entre o DAO e o View Model. <br />
Foram feitos testes de unidade e testes de de UI \(ainda não foram feitos testes com Mock por não ter o que mockar) <br />

# Plugin utilizados

 - Hilt
 - Navigation
 - Jetpack Compose
 - Material 3
 - Coil Compose
 - Junit 4
 - Kluent
 - Navigation Tests

