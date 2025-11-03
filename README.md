# Gara di Cavalli

## Introduzione
Questo progetto simula una **gara di cavalli** usando **thread in Java**.  
Ogni cavallo corre a una velocità definita, e uno di essi viene azzoppato casualmente durante la gara, quindi non potrà vincere.

Tutto l'output della gara viene salvato in un file testuale `gara_cavalli.txt`.

## Funzionalità principali
- Gestione di più cavalli tramite `ArrayList`.
- Un cavallo viene **azzoppato casualmente** durante la gara.
- Identificazione del cavallo **primo arrivato**.
- Scrittura dell’intero output della gara in un file testuale.
- Thread-safe: ogni cavallo corre nel proprio thread.

## Istruzioni di utilizzo

### Compilazione
```bash
javac Main.java Cavallo.java
