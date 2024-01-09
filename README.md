# Alpha

Nesta nova fase do projeto, ela está focada em implementar o banco de dados com o Room no projeto.<br/>

Além disso, implementamos uma tela que mostra mais detalhes da Marca, tela de cadastro da marca e mais outras features.<br/>

### Banco de Dados

Para haver uma persistência de dados do aplicativo, foi inserido o banco de dados através do Room Database.<br/>

Foi criado uma classe nova só para abrigar as Entidades do DB, que sao a MarcaEntity e a BolaEntity.<br/>

Em caso de atualização de objetos, temos o POJO para fazer isto, com a MarcaPOJO e BolaPOJO.<br/>

Em caso de exclusão de uma Marca, e ela estiver contida em uma bola, o valor da MarcaId na entidade Bola se tornará nulo(onDelete = ForeignKey.SET_NULL).<br/>


### Atualização da tela de lista de Bolas

Além de mostrar a lista de bolas cadastradas como na fase anterior, foi acrescentadas várias Features, dentre elas:
- Barra de pesquisa que visa encontrar a bola desejada através do nome do objeto
- Icone que podemos ordenar a lista de bolas por:
    - Nome Ascendente
    - Nome Descendente
    - Preço Ascendente
    - Preço Descendente
    - Mais Antigo (pela data de criação)
    - Mais Novo (pela data de criação)
- Navigation Drawer que mostra a lista de marcas, onde podemos ir para 2 telas, a tela de Cadastro de Marcas e Tela de Detalhes da Marca

### Tela de Cadastro de Marcas

Ela é bem semelhante a tela de cadastro de Bolas, onde podemos inserir a Url da imagem e o nome da marca.<br/>

Ela conta com uma verificação para ver se estamos cadastrando uma Marca nova ou atualizando. Dependendo do caso, no cadastro faremos o Insert dos dados, e em caso de atualização, faremos o Update com o POJO.<br/>

### Tela de detalhes da Marca

É a tela que mostra mais detalhes da Marca, como Imagem (que pode ser expandida no clique, que vai apresentar um dialog com a imagem aumentada), nome, data de criação e data da última alteração (se tiver).<br/>

Temos também na parte de baixo a lista de bolas que pertencem a esta marca. Lista no qual só aparece se apertarmos o botão de extender a lista (e podemos também fechar após abrir, apertando o mesmo botão).<br/>

### Tela de detalhes e Cadastro de Bolas

Não houve grandes alterações em ambas as telas, apenas uma adaptação para receber o banco de dados no lugar das listas, e pequenas refatorações.

### Testes

Houve muitas melhorias nos testes, dentre eles:
 - Rodamos um Banco de Dados em memória separado apenas para testes de UI, com ajuda do Hilt e Room.<br/>
 - Utilização do Leak Canary para detectar possíveis vazamentos de memórias
 - Reformulação dos testes de Integração, com uso aprimorado do Mockk
 - Os testes de UI com o Junit rodando de forma correta e aprimorados.

# Plugin utilizados

 - Hilt
 - Navigation
 - Jetpack Compose
 - Room
 - Material 3
 - Coil Compose
 - Junit 4
 - Kluent
 - Mockk
 - Ui Automator
 - Hilt Android Testing
 - Espresso
 - Leakcanary
