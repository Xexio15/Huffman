Huffman
---
<p>Sergio Plans</p>
<p>Arnau Martinez</p>

---

Si generem un text curt podem veure que la compressió i descompressió funciona correctament:
##### Excercici de clase:
    Text: DQDKJJQKDJKD10QKQ910DD
    Encoded Text: 1000100111111100011011101101101000100110011011010
    Decoded Text: DQDKJJQKDJKD10QKQ910DD

##### Exercici diapositiva 12:
    Text: ADBBBCCADAFEBAHBGA
    Encoded Text: 101110101011101101011110000100000110001001001110
    Decoded Text: ADBBBCCADAFEBAHBGA


### ¿Qué factor de compresión alcanzáis?

Si generem una cadena de caràcters gran (2000 en aquest cas) podem veure quin es el ratio de compressió, per al cas
de l'apartat a ens resulta el següent:

    Average used bits: 2.450000062584877 bits
    Enthropy (Theoric minimum): 2.408694990971382 bits
    Needed bits without compression: 3
    Compression Ratio: 1.2244897646389628

Podem comprovar que aixo coincideix amb l'exercici resolt a clase.

### ¿Qué factor de compresión alcanzáis? 
    Independientemente de la longitud de las sequencias entradas al ejecutar Huffman nos encontramos que el ratio 
    compresion siempre es el mismo independientemente de la longitud de la cadena, ya sean 10.000 o 100 caracteres. 
    Este factor de compresion empezara a mostrar variaciones cuando asignemos probabilidades diferentes a los 
    diferentes simbolos de entrada previos a crear el arbol de Huffman. 

### ¿Qué relación tiene éste con la entropía calculada teóricamente para el conjunto de símbolos del apartado a)?

    Fíjate que aunque la entropía nos dice que los datos se pueden codificar usando 2,40
    bits por símbolo, el resultado final usando Huffman es que han sido necesarios 2,45 bits
    por símbolo, ya que la entropía indica una cota inferior de los bits por símbolo
    necesarios.
