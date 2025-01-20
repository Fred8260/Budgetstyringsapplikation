# Budget Management Application

En simpel budgetstyringsapplikation, der giver brugeren mulighed for at tilføje transaktioner, generere rapporter, og eksportere data til både CSV- og XML-filer.

## Funktioner
- Tilføj indtægter og udgifter.
- Generer rapporter med total indtægt, udgifter og balance.
- Eksporter data til CSV- og XML-formater.

## Krav
- Java Development Kit (JDK) 8 eller nyere.

## Installation
1. Klon repository:
   ```bash
   git clone <repository-url>
   ```
2. Naviger til projektmappen.
3. Åbn projektet i din Java-IDE, eller brug kommandolinjen til at kompilere og køre det.

## Brug

1. Kør programmet.
2. Følg menuindstillingerne for at:
   - Tilføje nye transaktioner (indtast beløb, kategori og angiv om det er en indtægt).
   - Generere en rapport, der viser total indtægt, udgifter og balance.
   - Eksportere transaktioner til en CSV- eller XML-fil ved at angive et filnavn.

## Eksempel på menu
```plaintext
Menu:
1. Tilføj transaktion
2. Generer rapport
3. Udskriv til CSV
4. Udskriv til XML
0. Afslut
```

## Filformater
- **CSV**: Eksporterer transaktionsdata i kommasepareret format med kolonnerne `Amount`, `Category`, `Date`, `Income`, og `Balance`.
- **XML**: Eksporterer transaktionsdata i en XML-struktur med transaktionselementer, der inkluderer `Amount`, `Category`, `Date`, `Income`, og `Balance`.

## Eksempler
### CSV-eksempel
```
Amount,Category,Date,Income,Balance
500,Løn,2025-01-15,true,400
100,Mad,2025-01-16,false,300
```

### XML-eksempel
```xml
<Transactions>
   <Transaction>
      <Amount>500.0</Amount>
      <Category>Løn</Category>
      <Date>2025-01-15</Date>
      <Income>true</Income>
      <Balance>400.0</Balance>
   </Transaction>
</Transactions>
```

