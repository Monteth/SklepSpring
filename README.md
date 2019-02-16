# POSklep 
aplikacja backendowa sklepu internetowego.

## Założenia
Serwis ma udostępniać oprogramowanie dostosowane do wieku i dojżałości dziecka. W tym celu opiekun może ustalić konkretne ograniczenia dla konta dziecka opierające się na standardzie PEGI.

### Zastosowanie 
Aplikacja backendowa udostępnia interfejs RESTowy zwracający odpowiednie pliki JSON.

#### Wyszukiwanie oprogramowania
Oprogramowanie zawierające w nazwie "battle", limit wyszukiwania 2

Zapytanie:
```
GET /api/software?name=battle&limit=2
```
Odpowiedź:
```
[
    {
        "idSoftware": 3,
        "name": "Battlefield V",
        "description": "Weź udział w największym konflikcie w historii w Battlefield™ V – seria wraca do swoich korzeni dzięki zupełnie nowemu spojrzeniu na II wojnę światową.",
        "pegi": {
            "idPegi": 4,
            "value": "PEGI 18"
        }
    },
    {
        "idSoftware": 6,
        "name": "Battlefield 1942",
        "description": "gra komputerowa z gatunku first-person shooter osadzona w realiach II wojny światowej, stworzona przez szwedzkie studio Digital Illusions CE",
        "pegi": {
            "idPegi": 3,
            "value": "PEGI 16"
        }
    }
]
```
#### Pobranie danych dziecka
Pobierz dane dziecka o indeksie 2

Zapytanie:
```
GET /api/pupils/2
```
Odpowiedź:
```
{
       "idPupil": 2,
       "email": "email2@gmail.com",
       "firstName": "Esther",
       "lastName": "Cruz",
       "pegi": 1,
       "patron": 2,
       "limitations": [
           {
               "idLimit": 1,
               "value": "Seks"
           },
           {
               "idLimit": 2,
               "value": "Dyskryminacja"
           }
       ]
}
```


## Technologie
Aplikacja została napisana przy pomocy Spring Boot i Hibernate w języku Java i Kotlin. Baza danych to PostgreSQL.

## Frontend
Kilka kroków za aplikacją backendową powstają dwie aplikacje frontendowe. Linki do kodów źródłowych podaję niżej:

[Angular](https://bitbucket.org/Monteth/posklepangular/src/master/)

[React](https://bitbucket.org/Monteth/posklepreact/src/master/)

##Autor
###Konrad Bosak

email: konradbosak@protonmail.com

Facebook: [fb.com/konrad.bosak](fb.com/konrad.bosak)

