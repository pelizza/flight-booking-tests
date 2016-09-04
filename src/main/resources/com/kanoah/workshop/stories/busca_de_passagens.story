Meta:
@category smoke


Narrative:

Para encontrar passagens de avião para minhas viagens
Como um cliente
Eu quero procurar passagens pela cidade de origem e destino e datas de ida e volta


Scenario: Procurando passagens

Given Eu quero viajar de Florianópolis para Porto Alegre
And a data de ida é 30/10/2016
And a data de volta é 31/10/2016
And o número de passageiros é 1
When procuro por passagens
Then devo encontrar uma passagem custando R$200