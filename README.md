[TOC]

## Introduzione al Progetto

Di seguito verrà spiegato il funzionamento e la composizione del progetto d'esame denominato "OOP-Project-TwitterTimeline" svolto nel corso di "Programmazione ad Oggetti" A.A.2019/2020.
Il programma ha come obbiettivo l'analisi della Timeline di Twitter relativa ai post inerenti il terremoto, questa timeline è estrapolata da un URL, dal quale si prenderanno i dati più caratteristici di ogni tweet, sul quale poi l'utente tramite apposite richieste potrà effettuare filtri e statistiche.

(Spiegare come avviene il download PUNTO DI FORZA PERCHè DIVERSO)

### **Pre requisiti ed avvio del progetto**

Per il corretto funzionamento è necessario istallare l'IDE [Eclipse](https://www.eclipse.org/downloads/) con plugin "<u>Spring Tools</u>".

Successivamente, una volta aperto l'ambiente di sviluppo:

- Tasto destro nel Package Explorer, e cliccare "Import", poi "Project from GIT (with Smart Import)"

- Copiare nella finestra che si è appena aperta l'[URL del progetto](https://github.com/FedericaRipani/Progetto-Programmazione-ad-Oggetti)

- Una volta importato, basterà selezionare il progetto nel Package Explorer, tasto destro, opzione "Run As" e scegliere "Spring Boot App"

  Il progetto è dunque pronto, difatti apparirà in un console un messaggio "APPLICATION READY".

### **Funzionamento**

Tramite il Diagramma dei casi d'uso riportato di seguito viene spiegato quali sono le richieste  che il client può effettuare tramite API REST GET.

<img src="https://github.com/FedericaRipani/FedeECamiProve/blob/master/NewModel%20Use%20Case%20Diagram.jpg" style="zoom: 1%;" />

#### Come effettuare le richieste

(inserire tabella relativa alle richieste)



I filtri disponibili sono riportati nella seguente tabella:

....

Inoltre è possibile eseguire delle statistiche su un campo.

Il campo può riferirsi a tutta la Timeline di Tweet o ad una scala ridotta, quindi applicando prima un filtro.

(inserire tabella stats)













### 

