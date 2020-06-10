cr

## Introduzione al Progetto

Di seguito verrà spiegato il funzionamento e la composizione del progetto d'esame denominato "OOP-Project-TwitterTimeline" svolto nel corso di "Programmazione ad Oggetti" A.A.2019/2020.
Il programma ha come obiettivo l'analisi della Timeline di Twitter relativa ai post inerenti il terremoto. Questa timeline è estrapolata da un URL e sono stati presi in considerazione solo i dati più caratteristici di ogni tweet. L'utente, tramite apposite richieste, potrà effettuare filtri e statistiche, le statistiche possono essere effettuate sia sull'intera collezione di dati che su una sua parte applicando prima un filtraggio.

### **Pre requisiti ed avvio del progetto**

Per il corretto funzionamento è necessario istallare l'IDE [Eclipse](https://www.eclipse.org/downloads/) con plugin "<u>Spring Tools</u>".

Successivamente, una volta aperto l'ambiente di sviluppo, bisognerà effetttuare i seguenti passaggi:

- Tasto destro nel Package Explorer, e cliccare "Import", poi "Project from GIT (with Smart Import)"

- Copiare nella finestra che si è appena aperta l'[URL del progetto](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti)

- Una volta importato, basterà selezionare il progetto nel Package Explorer, tasto destro, opzione "Run As" e scegliere "Spring Boot App"

  Il progetto è dunque pronto, difatti apparirà in un console un messaggio "APPLICATION READY".
  
  
### **Download**

Nel momento in cui si clicca su "Run as" -> "Spring Boot Application", automaticamente si effettua il download dei Tweet ed i relativi dati. Si creerà un JSONArray formo da tutti i Tweet ed i suoi campi all'interno.


### **Funzionamento**

Tramite il Diagramma dei casi d'uso riportato di seguito viene spiegato quali sono le richieste  che il client può effettuare tramite API REST GET.

<img src="https://github.com/FedericaRipani/FedeECamiProve/blob/master/NewModel%20Use%20Case%20Diagram.svg" style="zoom: 5%;" style="align: middle;"/>


#### Come effettuare le richieste

E' possibile effettuare le seguenti chiamate sia installando un API Testing (ad esempio Postman) che tramite richiesta all' URL http://localhost:8080/.

| DESTINAZIONI                                                 | DESCRIZIONE                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| `/getTweets`                                                 | Visualizza tutti i Tweet (rappresentati dai parametri piu importanti) presenti nel Dataset |
| `/getMeta`                                                   | Visualizza tutti gli alias utilizzati per la descrizione del tweet |
| `/filtering?filter={"type":"nome_filtro","fields":"campo_esaminato","parametro":valore}` | Visualizza la collezione di Tweet filtrata in base a parametri formato JSON |
| `/stats?field=campo&<br/>filter{"type":"nome_filtro","fields":"campo_esaminato","parametro":valore}` | Visualizza le statistiche su un campo dei Tweet. Il dataset  di provenienza può essere intero o parziale, applicando prima un filtro |

---
## Filtri 
I filtri disponibili sono riportati nella seguente tabella:
(bisogna invertire UpperBound e LowerBound e specificare che per il testo si considera la sua lunghezza)

|        Filtro        |                         Descrizione                          |      Field applicabili       |              Esempio del filtro in formato JSON              |
| :------------------: | :----------------------------------------------------------: | :--------------------------: | :----------------------------------------------------------: |
|      UpperBound      | Cerca i valori del campo scelto (**field**) maggiori della soglia **lower**. |      TextPost e numPost      |     {"type":"UpperBound","field":"TextPost","lower":20}      |
| UpperBound and equal | DescrizioneDescrizioneCerca i valori del campo scelto (**field**) maggiori o uguali della soglia **lower**. |      TextPost e numPost      |     {"type":"UpperBoundE","field":"TextPost","lower":20}     |
|      LowerBound      | Cerca i valori del campo scelto inferiori della soglia **upper** nel campo **field**. |      TextPost e numPost      |     {"type":"LowerBound","field":"TextPost","upper":100}     |
| LowerBound and equal | Cerca i valori del campo scelto (**field**) inferiori o uguali della soglia **upper**. |      TextPost e numPost      |    {"type":"LowerBoundE","field":"TextPost","upper":100}     |
|       Included       | Cerca i valori del campo scelto (**fields**)nei valori compresi tra la soglia **lower** e **upper**. |      TextPost e numPost      | {"type":"Included","fields":"TextPost","upper":100,"lower":20} |
|  Included and equal  | Cerca i valori del campo scelto (**fields**) nei valori compresi o uguali tra la soglia **lower** e **upper**. |      TextPost e numPost      | {"type":"IncludedE","fields":"supwater","upper":100,"lower":20} |
|        Search        | Cerca le stringhe del campo scelto (**fields**) uguali ad una determinata parola (**value**) | TextPost, NameUser e Hashtag | {"type":"Search", "fields": "Hashtag","value"= "terremoto"}  |

---


 ## Statistiche

E' possibile eseguire delle statistiche su un campo.

Il campo può riferirsi a tutta la Timeline di Tweet o ad una scala ridotta, quindi applicando prima un filtro.

|        Statistica         |                         Descrizione                          |            Field applicabili             |
| :-----------------------: | :----------------------------------------------------------: | :--------------------------------------: |
|       Minimo (Min)        | Dato il campo (**field**), calcola il minimo valore in quel campo |         idPost, idUser e numPost         |
|       Massimo (Max)       | Dato il campo (**field**), calcola il massimo valore in quel campo |         idPost, idUser e numPost         |
|        Media (Avg)        | Dato il campo (**field**), calcola la media dei valori di quel campo |         idPost, idUser e numPost         |
|        Somma (Sum)        | Dato il campo (**field**), calcola la somma di tutti i valori di quel campo |         idPost, idUser e numPost         |
| Deviazione Standard (Std) |                         Da vedere!!!                         |         idPost, idUser e numPost         |
| Occorrrenze (Occurrence)  |      Dato il campo (**field**),  calcola le occorrenze       | data, textPost, nameUser e  languagePost |

##### ! TUTTI I DATI RESTITUITI SONO IN FORMATO JSON !
##### Esempio di risposta alla chiamata  http://localhost:8080/stats?field=numPost&filter={"type":"UpperBound","fields":"TextPost","lower":100}.
```
{

  "m": {

​    "Deviazione standard": 69.40997754134797,

​    "Field": "numPost",

​    "Massimo": 499.0,

​    "Media": 26.90909090909091,

​    "Minimo": 0.0,

​    "Sommatoria": 2072.0

  }

}
```

##### Esempio di risposta parziale alla chiamata   http://localhost:8080/getMeta
```
{

 {
        "name": "data",
        "sourceField": "Data di creazione del twitt",
        "type": "String"
    },
    {
        "name": "idPost",
        "sourceField": "Descrive in modo univoco il post",
        "type": "Integer"
    },

}
```
#### HTTP-response

Al fine di rendere il progetto di maggior comprensione all'utente finale,  non sono state create eccezioni personalizzate, se non oltre a quelle già definite nelle apposite librerie bensì sono stati utilizzati dei codici HTTP- response.

Il client invia la richiesta al server, quindi attende la risposta (response). L'obiettivo del server è quindi di interpretare la richiesta del client e restituire una risposta correlata da un codice ben visibile sull' applicazione di testing [Postman](https://www.postman.com/).

I codici attribuibili nell'applicazione sono i seguenti:
|   Codice Riposta    |           Chiamate possibili            |                         Significato                          |
| :-----------------: | :-------------------------------------: | :----------------------------------------------------------: |
|     `200 - OK`      | `getMeta, getTweets,  filtering, stats` | L'operazione è andata a buon fine, il risultato prodotto è quello aspettato. |
| `400 - BAD REQUEST` |           `filtering, stats`            | Il filtro o il field immesso non è stato implementato oppure è incorretto. |
| `204 - NO CONTENT`  |               `filtering                | L'operazione è andata a buon fine ma non ha prodotto risultato, la selezione è vuota. |
|  `404 - NOT FOUND`  |                  stats                  | Dopo aver richiesto le statistiche è stato immesso un filtro o un field incorretto. |




### **Struttura**

Il progetto è strutturato con vari package rispettando il pattern architetturale MVC come di seguito dimostrato:



### Autori

[**Federica Ripani**](https://twitter.com/RipaniFederica) - S1086993

[**Camilla D'Andrea**](https://twitter.com/CamillaDAndrea2) - S1087888

Studentesse del 2° anno di Ing. Informatica e dell'Automazione presso l'UNIVPM.

Il link rimanda al profilo Twitter creato in occasione dello sviluppo del progetto.












### 

