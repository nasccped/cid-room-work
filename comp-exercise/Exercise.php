<?php
/*
Exercício de Fixação

Escolha entre
- Os 20 melhores livros da história
- As 20 melhores músicas da história
- As 20 melhores músicas da década de 1980
- As 20 melhores séries de 2023
- Os 20 melhores filmes do século XX
- 20 outras coisas no mesmo estilo

Escreva os vinte itens originais e como eles seriam ordenados,
em cada passo, utilizando cada um dos algoritmos de ordenação
apresentados aqui, até a ordenação final. Eles podem ser
ordenados de diversas formas, como lexicograficamente pelo
nome do autor/intérprete/diretor, pelo ano ou algo semelhante.

Item escolhido >>>
    Linguagens de Programação ->
        - Nome
        - Ano de lançamento
        - Criador Majoritário (preservar a regra de apenas um nome por atributo)
    .
.

algoritmos de ordenação
apresentados >>>

    - Selection Sort
    - Insertion Sort
    - Bubble Sort
    - Quick Sort
.

*/

// definindo a class para futuramente instanciarmos as linguagens
class Language{

    // 'settando' as variáveis do nosso objeto
    public $name  ; // nome
    public $author; // autor
    public $year  ; // ano de lançamento

    // função que servirá como 'instanciador'
    public function __construct($languageName, $languageAuthor, $releaseYear){
        
        $this -> name   = $languageName  ;
        $this -> author = $languageAuthor;
        $this -> year   = $releaseYear   ;
    }
}

// função que tem como objetivo limpar a tela
function screenClear(){

    // caso o sistema operacional seja windows
    if(stristr(PHP_OS, "WIN")){

        // limpe o terminal usando o comando:
        pclose(popen("cls", "w"));
    }

    // caso contrário
    else{

        // limpe o terminal usando o comando:
        pclose(popen("clear", "w"));
    }
}

// função que cria os nossos objetos
// decidi deixá-la aqui para armazenar as variáveis em um bloco
function creatObjects(){

    // tornando as variáveis globais
    global $JavaScript, $Python, $Java, $CSharp, $CPlusPlus,
    $Ruby, $Swift, $Kotlin, $TypeScript, $PHP, $Go, $Rust, $R,
    $Matlab, $Objective_C, $Bash, $SQL, $Dart, $Scala, $Pearl;

    // criando as linguagens como objetos
    $JavaScript  = new Language("JavaScript" , "Brendan Eich"         , 1995); // 01
    $Python      = new Language("Python"     , "Guido van Rossum"     , 1991); // 02
    $Java        = new Language("Java"       , "James Gosling"        , 1995); // 03
    $CSharp      = new Language("C#"         , "Microsoft Corporation", 2000); // 04
    $CPlusPlus   = new Language("C++"        , "Bjarne Stroustrup"    , 1985); // 05
    $Ruby        = new Language("Ruby"       , "Yukihiro Matsumoto"   , 1995); // 06
    $Swift       = new Language("Swift"      , "Chris Lattner"        , 2014); // 07
    $Kotlin      = new Language("Kotlin"     , "JetBrains"            , 2011); // 08
    $TypeScript  = new Language("TypeScript" , "Microsoft Corporation", 2012); // 09
    $PHP         = new Language("PHP"        , "Rasmus Lerdorf"       , 1994); // 10
    $Go          = new Language("Go"         , "Robert Griesemer"     , 2009); // 11
    $Rust        = new Language("Rust"       , "Graydon Hoare"        , 2010); // 12
    $R           = new Language("R"          , "Ross Ihaka"           , 1993); // 13
    $Matlab      = new Language("Matlab"     , "MathWorks"            , 1984); // 14
    $Objective_C = new Language("Objective-C", "Brad Cox"             , 1984); // 15
    $Bash        = new Language("Bash"       , "Brian Fox"            , 1989); // 16
    $SQL         = new Language("SQL"        , "Donald D. Chamberlin" , 1974); // 17
    $Dart        = new Language("Dart"       , "Google"               , 2011); // 18
    $Scala       = new Language("Scala"      , "Martin Odersky"       , 2003); // 19
    $Pearl       = new Language("Pearl"      , "Larry Wall"           , 1987); // 20
}

// função que retorna um array de valores baseado no que você está buscando do objeto especificamente
function getFromArray($target, $objectsArray){

    // atribuindo variáveis arrays que serão retornadas
    $names   = array();
    $authors = array();
    $years   = array();

    // para cada objeto dentro do array
    foreach($objectsArray as $obj){

        // adicione aos arrays os seguintes atributos:
        $names[]   = $obj -> name  ; // nome
        $authors[] = $obj -> author; // author
        $years[]   = $obj -> year  ; // ano de lançamento
    }

    // se o usuário quiser os nomes
    if($target == "names"){

        // retorne o array de nomes
        return $names;
    }

    // se o usuário quiser os autores
    else if($target == "authors"){

        // retorne o array de autores
        return $authors;
    }

    // caso contrário
    else{

        // retorne o array de anos de lançamentos
        return $years;
    }
}

// função que exibe o array de forma padrão (horizontal, assim como em python)
function arrayVisualyzer($targetArray){

    // obtendo o tamanho do array
    $arrayLength = count($targetArray) - 1;

    // texto introdutório
    echo "Atual condição da nossa lista: \n";

    // chame o começo do colchete
    echo "[";

    // para i = 0 (primeiro índice) até i = ultimo índice
    for($i = 0; $i <= $arrayLength; $i++){

        // mostre o valor do array
        echo $targetArray[$i];

        // mostre uma vírgula (ou não) para separar os valores
        echo ($i == $arrayLength ? "" : ", ");
    }

    // chame o final do colchete
    echo "]\n";
}

// algorítmo selection sort
function selectionSort($array){

    // obtendo o tamanho do array inserido
    $length = count($array);

    // percorrendo o array
    for($i = 0; $i < $length - 1; $i++){

        echo "\n";
        arrayVisualyzer($array);

        // obtendo o índice do menor elemento -> como elemento atual
        $minIndex = $i;
        
        // percorrendo os seguintes elementos
        for($j = $i + 1; $j < $length; $j++){
        
            // se houver diferença entre as palavras
            if (strcmp($array[$j], $array[$minIndex]) < 0) {
        
                // modifique o índice do menor elemento para o atual
                $minIndex = $j;
            }
        }

        // troca o menor elemento com o primeiro não ordenado
        $temp             = $array[$minIndex];
        $array[$minIndex] = $array[$i]       ;
        $array[$i]        = $temp            ;

    }

    // retornando o array ordenado
    return $array;
}

// algorítmo insertion sort
function insertionSort($arr){

    // Obtaining the size of our array
    $n = count($arr);

    // Looping through the array starting from the second element (index = 1)
    for($i = 1; $i < $n; $i++){

        // Assigning the key element
        $key = $arr[$i];

        // Setting the value of the index before the key element
        $j = $i - 1;

        // While loop where: while count is greater than or equal to 0 and greater than our key element, continue with the loop
        while($j >= 0 && strcmp($arr[$j], $key) > 0){
            $arr[$j + 1] = $arr[$j];
            $j--;
        }

        // Otherwise
        $arr[$j + 1] = $key;

        // Displaying the changes in our array
        arrayVisualyzer($arr);
        
        echo "\n";
    }

    // Return the array
    return $arr;
}

// algorítmo bubble sort
function bubbleSort($arr){

    // obtendo o tamanho do array
    $n = count($arr);

    // Loop principal para percorrer todo o array
    for($i = 0; $i < $n - 1; $i++){

        // Últimos $i elementos já estão no lugar
        for($j = 0; $j < $n - $i - 1; $j++){

            // Troca se o elemento atual for maior que o próximo
            if(strcmp($arr[$j], $arr[$j + 1]) > 0){

                // Troca os elementos
                $temp        = $arr[$j]    ;
                $arr[$j]     = $arr[$j + 1];
                $arr[$j + 1] = $temp       ;
            }
        }

        // Exibir os passos intermediários do array
        arrayVisualyzer($arr);
        echo "\n";
    }
    
    // retornando array
    return $arr;
}

// algorítmo quickSort
function quickSort($arr, $left = 0, $right = null){

    if($right === null){

        $right = count($arr) - 1;
    }

    $i     = $left                     ;
    $j     = $right                    ;
    $pivot = $arr[($left + $right) / 2];

    // divide o array em duas metades
    while($i <= $j){

        // encontra o elemento que precisa ser movido
        while(strcmp($arr[$i], $pivot) < 0){

            $i++;
        }

        while(strcmp($arr[$j], $pivot) > 0){

            $j--;
        }

        // troca os elementos se encontrados
        if($i <= $j){

            $temp    = $arr[$i];
            $arr[$i] = $arr[$j];
            $arr[$j] = $temp   ;
            $i++;
            $j--;

            // exibir os passos intermediários do array após cada partição
            arrayVisualyzer($arr);
            echo "\n";
        }
    }

    // recursivamente ordena as duas metades
    if($left < $j){

        $arr = quickSort($arr, $left, $j);
    }

    if($i < $right){

        $arr = quickSort($arr, $i, $right);
    }

    // retornando o array
    return $arr;
}


// início da execução do código ------------------------------

// chamando a função para criar os objetos
creatObjects();

// criando opções com o vetor associativo
$algorithmsMap = array(
    "1"                    => "Selection Sort"   ,
    "2"                    => "Insertion Sort"   ,
    "3"                    => "Bubble Sort"      ,
    "4"                    => "Quick Sort"       ,
    "Qualquer outra coisa" => "Encerrar Programa"
);

// criando escolhas com o vetor associativo
$modesMap = array(
    "1"                    => "Nome da Linguagem",
    "2"                    => "Nome do Autor"    ,
    "3"                    => "Ano de lançamento",
    "Qualquer outra coisa" => "Encerrar Programa"
);

// fazendo um loop infinito que futuramente será quebrado
while(true){

    // limpando a tela
    screenClear();

    // criando um array inordenado
    $unorderedList = array(
        $JavaScript, $Python, $Java, $CSharp, $CPlusPlus,
        $Ruby, $Swift, $Kotlin, $TypeScript, $PHP, $Go,
        $Rust, $R, $Matlab, $Objective_C, $Bash, $SQL,
        $Dart, $Scala, $Pearl
    );

    // exibindo texto
    echo "No momento, temos a seguinte \033[1;33mlista desordenada\033[0m:\n\n";

    // criando index para enumerar os objetos
    $index = 1;

    // para cada objeto dentro do nosso array
    foreach($unorderedList as $item){

        // modificando o valor (em string) do index a partir do seu valor atual
        $index = ($index < 10) ? " " . (string) $index : (string) $index; 

        // exibindo index estilizado
        echo "\033[1;33m" . $index . ".\033[0m ";

        // exibindo nome estilizado
        echo "\033[1;34m" . $item -> name . "\033[0m";
        echo str_repeat(" ", 20 - strlen($item -> name));

        // exibindo ano de lançamento estilizado
        echo "lançado(a) no ano de: " . "\033[1;34m" . $item -> year . "\033[0m";
        echo str_repeat(" ", 5);

        // exibindo autor estilizado
        echo "e desenvolvido(a) por: " . "\033[1;34m" . $item -> author . "\033[0m\n";

        // incrementando index
        $index = (int) $index;
        $index++;
    }

    echo "\n";

    // fazendo pergunta
    echo "Escolha um \033[1;31malgoritmo de ordenação\033[0m para a lista que foi apresentada:\n\n";

    // fazendo um loop no vetor associativo
    foreach($algorithmsMap as $key => $value){

        echo "\033[1;31m" . $key . ".\033[0m " . $value . "\n";
    }

    // pegando resposta do usuário
    echo ">>> ";
    $algorithm = trim(fgets(STDIN));

    // atribuindo um novo valor a partir da resposta fornecida >>
    if($algorithm == "1"){

        $algorithm = 'selectionSort';
    }

    else if($algorithm == "2"){

        $algorithm = 'insertionSort';
    }

    else if($algorithm == "3"){

        $algorithm = 'bubbleSort';
    }

    else if($algorithm == "4"){

        $algorithm = 'quickSort';
    }

    // encerrando programa caso resposta não esteja na lista esperada
    else{

        break;
    }

    // limpando tela
    screenClear();

    // fazendo a segunda pergunta
    echo "Escolha \033[1;31mo que\033[0m será ordenado:\n\n";

    // fazendo loop no outro vetor associativo
    foreach($modesMap as $key => $value){

        echo "\033[1;31m" . $key . ".\033[0m " . $value . "\n";
    }

    // obtendo resposta do usuário
    echo ">>> ";
    $target = trim(fgets(STDIN));

    // atribuindo novo valor a partir da resposta obtida >>>
    if($target == "1"){

        $target = "names";
    }

    else if($target == "2"){

        $target = "authors";
    }

    else if($target == "3"){

        $target = "years";
    }

    // encerrando programa...
    else{

        break;
    }

    // limpando a tela
    screenClear();

    // atribuindo >>>
    $currentArray = getFromArray($target, $unorderedList); // lista desordenada a partir das responses do usuário
    $finalArray   = $algorithm($currentArray)            ; // ordenando a lista por meio de uma função 'settada' pelo usuário
    $arrayLen     = count($finalArray) - 1               ; // obtendo o range da array

    // texto para resultado final
    echo "\n";
    echo "O resultado final da nossa lista ficou da seguinte forma: \n";

    // printando array
    echo "\033[1;37m[";

    // loop pelos elementos
    for($i = 0; $i <= $arrayLen; $i++){

        echo "\033[1;33m" . $finalArray[$i] . "\033[1;37m";

        echo ($i == $arrayLen ? "" : ", ");
    }

    echo "]\033[0m\n\n";

    // esperando resposta do usuário
    echo "\033[3;30m" . "Enter para prosseguir" . "\033[0m";
    fgets(STDIN);
}

// limpando terminal
screenClear();

// texto final
echo "\033[1;33m" . "O programa foi finalizado..." . "\033[0m";

// fechando programa
exit;

?>