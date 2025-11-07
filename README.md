# Gara di Cavalli  
Una simulazione di una **gara di cavalli multithread** in Java, dove ogni cavallo corre con una velocità diversa e uno viene azzoppato casualmente durante la gara.

---

## Descrizione  
Questo progetto dimostra l’uso dei **thread in Java** per simulare processi concorrenti.  
Ogni cavallo rappresenta un thread separato che “corre” in parallelo agli altri.  
Durante la gara, uno dei cavalli viene scelto casualmente e **azzoppato**, interrompendo il suo thread.  

L’obiettivo è mostrare:
- la gestione di thread multipli;
- l’uso di `ArrayList` per memorizzare oggetti;
- la scrittura concorrente su file (`FileWriter`);
- la gestione di interruzioni con `Thread.interrupt()`.

Tutto il resoconto della gara viene salvato nel file `gara_cavalli.txt`.

---

## Utilizzo  

1. Il programma chiede all’utente di inserire:
   - il **nome** di ciascun cavallo;
   - la sua **lentezza** (un numero intero, dove un valore più alto significa più lento).

2. Dopo l’inserimento dei dati:
   - Tutti i cavalli iniziano a correre contemporaneamente.
   - Uno viene scelto casualmente per essere **azzoppato**.
   - Alla fine, viene indicato il **cavallo vincitore**.

3. Tutto il log della gara viene scritto nel file:
   ```
   gara_cavalli.txt
   ```

**Esempio di output (nel file)**:
```
Cavallo Thunder comincia il suo galoppo
Cavallo Flash comincia il suo galoppo
Il cavallo Flash è stato azzoppato!
Cavallo Thunder cavalca - passo: 10
Il primo cavallo: Thunder
```

---

## Licenza  
Questo progetto è distribuito sotto licenza **MIT**.  


---

## Autore  
Creato da Christian Baglioni  

