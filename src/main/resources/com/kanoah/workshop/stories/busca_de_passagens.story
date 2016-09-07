Narrative:

Como Cliente
quero procurar passagens pela origem e destino, além de datas de ida e volta e quantidade de passageiros
para encontrar passagens de avião para minhas viagens e saber seu custo


Scenario: São encontradas duas passagens (ida e volta) ao realizar uma busca válida

Given eu estou na página de busca de passagens
When eu quero viajar de Florianópolis para Porto Alegre
And a data de ida é <ida>
And a data de volta é <volta>
And o número de passageiros é <passageiros>
And procuro por passagens
Then devo encontrar passagens de ida e volta custando <custo_ida> e <custo_volta>


Examples:
|ida		|volta		|passageiros|custo_ida	|custo_volta	|notas                                      |
|10/09/2016	|10/09/2016	|1			|R$200		|R$200		    |preço normal                               |
|10/09/2016	|10/09/2016	|2			|R$392		|R$392		    |ambas com 2% de desconto                   |
|01/12/2016	|09/12/2016	|1			|R$200		|R$180		    |ida preço normal; volta 10% de desconto    |
|01/12/2016	|09/12/2016	|2			|R$392		|R$352		    |ida 2% de desconto; volta 12% de desconto  |
|01/03/2017	|09/03/2017	|1			|R$180		|R$160		    |ida 10% de desconto; volta 20% de desconto |
|01/03/2017	|09/03/2017	|2			|R$352		|R$312		    |ida 12% de desconto; volta 22% de desconto |


Scenario: São exibidos erros para cada campo vazio na busca

Given eu estou na página de busca de passagens
When procuro por passagens
Then devo encontrar erro no campo De
And devo encontrar erro no campo Para
And devo encontrar erro no campo Ida
And devo encontrar erro no campo Volta