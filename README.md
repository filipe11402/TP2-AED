## Trabalho Prático 1 
### Unidade Curricular de Algoritmia e Estrutura de Dados

---

### Abordagem ao problema

Análise inicial, de como poderia ser convertido o CSV dos dados, para um grafo
Foi detetado, 2 pontos chave:
- Era um grafo não orientado
- O peso das nossas ``Edge`` iria o nome das colunas

### Resolução do problema

#### Estrutura de dados usadas
Para resolver o problema, decidi, usar 2 estruturas de dados principais + algumas como forma de auxílio:
- HashMap
- HashSet
- ArrayList

#### Lógica
##### Transformar os dados do CSV em ``Node`` e ``Edge``
- Inicialmente, puxo todos os dados do CSV para o código
- Em seguida, objetivo era fazer com que, as edges tivessem 2 ``Node`` o ``from`` e o ``to``, pois a nossa ``Edge`` tem 2 nós, um de cada lado
- Para chegar a esse tipo de estrutura, o ``Node`` ``from``, seria sempre o nosso ``order_id``, pois uma ``Edge`` tem sempre uma order liga a mesma;
- De seguida, por cada filho que estava nos nós náo visitados, gerei os filhos uma camada para baixo, e se esse nó ainda não tinha sido visitado, então o mesmo era adicionado á lista de nós não visitados.
- No próximo passo, eu removia o o primeiro item da lista, de nós não visitados, com recurso ao método ``.poll()``, e adicionava o mesmo aos nós já visitados.
- Por fim, eu ia buscar o filho seguinte(ainda na primeira camada), calculava os seus limites, e gerava os seus filhos, seguindo a mesma logica para cada iteração;
- A iteração, irá acabar assim que a lista de nós estiver vazia, ou o nó atual for igual ao objetivo desejado;
Exemplo:
```{
class Edge{
    private Node _from; //Will be -> 30214

    private Node _to; //Will -> be36

    private String _weigth; //Column name will be -> order_value
}
}
```

##### Recomendação simples de produtos
- Initialmente era necessário iterar sobre a nossa lista de ``Edge``, e selecionar apenas aquelas a qual continham algum dos produtos que foram enviados;
- Em seguida, pegar na lista criada no passo anterior, e iterar sobre a mesma,
e criar um HashMap<produto, totalDeOcurrencias>, em que só seria contabilizado os produtos que não eram iguais aos enviados;
- Por fim, retornar o produto que teve mais ocorrências;

#### Recomendação com o filtro
- Usar a lógica da recomendação anterior;
- Iterar sobre o ``HashMap`` criado do método anterior;
- De seguida, iterar sobre cada edge que existe no ``Graph``, e retornar o produto em que simultaneamente, o ``to`` da ``Edge`` seja igual á key do HashMap, que neste caso é o nome do produto, e que exista uma ``Edge`` em que o seu ``from`` seja igual á edge que contenha o mesmo ``from`` relativo ao filtro enviado;

#### Query com contagem
- Fazer um GroupBy, usando o ``.stream().groupingBy()``, e agrupar pelo ``from``;
- Iterar sobre o Map criado, no passo anterior, e ter uma vari'avel de controlo para ter o total de ocorrências para com cada filtro;
- Iterar em simultâneo, sobre cada filtro que foi enviado, e se houver alguma occurência do filtro, dentro da nossa ``List<Edge>`` que está como value do nosso Map proviniente do ``.groupingBy()``, então incrementamos a nossa variável de controlo;
- Depois da iteração sobre os filtros, se a nossa variável de controlo for igual ao tamanho da lista de filtros, então, iremos contar como + 1 para a query com contagem;

### Conclusão
Este trabalho, permitiu conhecer um pouco mais sobre
1 - A linguagem Java e as capacidades do ``.stream()`` sobre as estruturas de dados
2 - Construir Grafos

### Resources
[Weighted Graphs](https://algorithms.tutorialhorizon.com/weighted-graph-implementation-java/)