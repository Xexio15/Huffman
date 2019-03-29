Huffman
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

### ¿Qué relación tiene éste con la entropía calculada teóricamente para el conjunto de símbolos del apartado a)?