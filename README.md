cr

## Introduzione al Progetto

Di seguito verrà spiegato il funzionamento e la composizione del progetto d'esame denominato "OOP-Project-TwitterTimeline" svolto nel corso di "Programmazione ad Oggetti" A.A.2019/2020.
Il programma ha come obiettivo l'analisi della Timeline di Twitter relativa ai post inerenti il terremoto. Questa timeline è estrapolata da un URL e sono stati presi in considerazione solo i dati più caratteristici di ogni tweet. L'utente, tramite apposite richieste, potrà effettuare filtri e statistiche, le statistiche possono essere effettuate sia sull'intera collezione di dati che su una sua parte applicando prima un filtraggio.

(Spiegare come avviene il download PUNTO DI FORZA PERCHè DIVERSO)

### **Pre requisiti ed avvio del progetto**

Per il corretto funzionamento è necessario istallare l'IDE [Eclipse](https://www.eclipse.org/downloads/) con plugin "<u>Spring Tools</u>".

Successivamente, una volta aperto l'ambiente di sviluppo, bisognerà effetttuare i seguenti passaggi:

- Tasto destro nel Package Explorer, e cliccare "Import", poi "Project from GIT (with Smart Import)"

- Copiare nella finestra che si è appena aperta l'[URL del progetto](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti)

- Una volta importato, basterà selezionare il progetto nel Package Explorer, tasto destro, opzione "Run As" e scegliere "Spring Boot App"

  Il progetto è dunque pronto, difatti apparirà in un console un messaggio "APPLICATION READY".

### **Funzionamento**

Tramite il Diagramma dei casi d'uso riportato di seguito viene spiegato quali sono le richieste  che il client può effettuare tramite API REST GET.

<img src="https://github.com/FedericaRipani/FedeECamiProve/blob/master/NewModel%20Use%20Case%20Diagram.jpg" style="zoom: 1%;" />


#### Come effettuare le richieste

E' possibile effettuare le seguenti chiamate sia installando un API Testing (ad esempio Postman) che tramite richiesta all' [URL] (http://localhost:8080/) http://localhost:8080/.

| DESTINAZIONI                                                 | DESCRIZIONE                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| `/getTweets`                                                 | Visualizza tutti i Tweet (rappresentati dai parametri piu importanti) presenti nel Dataset |
| `/getMeta`                                                   | Visualizza tutti gli alias utilizzati per la descrizione del tweet |
| `/filtering?filter={"type":"nome_filtro","fields":"campo_esaminato","parametro":valore}` | Visualizza la collezione di Tweet filtrata in base a parametri formato JSON |
| `/stats?field=campo&<br/>filter{"type":"nome_filtro","fields":"campo_esaminato","parametro":valore}` | Visualizza le statistiche su un campo dei Tweet. Il dataset  di provenienza può essere intero o parziale, applicando prima un filtro |

I filtri disponibili sono riportati nella seguente tabella:


I filtri disponibili sono riportati nella seguente tabella:

....

Inoltre è possibile eseguire delle statistiche su un campo.

Il campo può riferirsi a tutta la Timeline di Tweet o ad una scala ridotta, quindi applicando prima un filtro.

(inserire tabella stats)


Mettere qualche esempio di choiamata.
Parlare di http response con relativi codici

Mettere solo package con all'interno le classi.

e dire che si rimanda alla cartella uml per diagrammi piu specifici.

Mettere gli autori con link profilo twitter












### 

