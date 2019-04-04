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

### ¿Quin factor de compresió aconseguiu? 
    Independentment de la longitud de les seqüéncies entrades al executar Huffman ens trovem que el ratio de compressió sempre es el mateix, siguin 10.000 o 100 caràcters. Aquest factor de compressió començarà a mostrar variacions quan assignem probabilitats diferents als símbols d'entrada previs a la creació de l'arbre de Huffman.
    
### ¿Quina relació té aquest amb l'entropía calculada teóricament per al conjunt de símbols de l'apartat a)?
    Tot i que l'entropía ens diu que les dades es poden codificar utilitzant com a mínim 2,40 bits per símbol, el resultat final utilitzant Huffman es que son necessaris 2,45 bits per símbol, ja que l'entropía indica el mínim teóric, es a dir una compressió perfecta.
