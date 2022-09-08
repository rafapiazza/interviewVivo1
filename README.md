# interviewVivo1

Esse projeto se trata de uma entrevista, no intervalo de 05/09 - 08/09 foi desenvolvido 3 projetos Java spring boot para 3 exercícios testes.

Esse projeto é referente a seguinte questão:

1. Uma imagem bitmap pode ser representada como uma matriz de dimensões M x
N, em que cada posição da matriz pode assumir um valor inteiro dentro de um
intervalo. Construa um algoritmo que receba como entrada um Vetor A[N] em
que An ∈ { 0, 1, 2,..., 15 }. A saída do seu algoritmo deve ser uma String
indicando a quantidade de vezes que cada An foi encontrado na matriz de
bitmap. No caso em que algum elemento não tenha sido encontrado, o
algoritmo deve retornar que a quantidade é zero para aquele elemento. O
formato da String é livre.

Para sua utilização, clone e importe o repositório, então execute os seguintes comandos:

mvn clean package
mvn clean install -DskipTests 

Esse projeto foi desenvolvido após a questão de número dois, pois ao ler este exercício, naturalmente escrevi uma API Rest para exposição do enpoint.
Portanto, eu removi grande parte de sua estrutura, os testes unitários e a exposição do swagger.

Portanto sua execução se da através do console, onde ao executar a InterviewEx1Application ele solicitará a inserção do vetor, calculará e 
terminará sua execução.

![image](https://user-images.githubusercontent.com/29410618/189127946-6f7923c8-cd8b-4a6a-9b65-00f75bc6fd41.png)

Assim como na questão 2, haverá validações para não conformidades na entrada, como fora do intervalo ou de natureza errada, como:
![image](https://user-images.githubusercontent.com/29410618/189128453-b8758941-1346-4c89-a8d2-becb2710ea12.png)
