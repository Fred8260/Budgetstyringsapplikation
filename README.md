# Budget Manager

Dette projekt er en simpel budgetstyringsapplikation skrevet i Java. Applikationen gør det muligt for brugere at registrere transaktioner, generere rapporter, samt eksportere data til CSV- og XML-filer. Formålet er at give en overskuelig måde at holde styr på økonomi ved at kategorisere og balancere indtægter og udgifter.

## Funktioner
- Tilføj transaktioner med beløb, kategori, dato og type (indtægt/udgift).
- Generer rapporter, der viser samlede indtægter, udgifter og balance.
- Eksporter transaktioner og balance til CSV- og XML-filer.

## Systemkrav
- Java 11 eller nyere.

## Installation
1. Klon dette repository eller download ZIP-filen.
2. Naviger til projektets rodmappe i din terminal eller kommandoprompt.
3. Kompiler projektet med:
   ```
   javac *.java
   ```
4. Kør applikationen med:
   ```
   java Main
   ```

## Brugerflade
Applikationen bruger en konsol-baseret menu med følgende muligheder:
1. Tilføj transaktion: Brugeren bliver bedt om at indtaste beløb, kategori og om det er en indtægt eller udgift.
2. Generer rapport: Viser de samlede indtægter, udgifter og den aktuelle balance.
3. Udskriv til CSV: Eksporterer transaktioner og balance til en angivet CSV-fil.
4. Udskriv til XML: Eksporterer transaktioner og balance til en angivet XML-fil.
0. Afslut: Lukker programmet.

## Eksempel
Ved valg af "Tilføj transaktion" skal brugeren indtaste følgende:
- Beløb: 500.0
- Kategori: Mad
- Er det indtægt? (true/false): false

Efter at have tilføjet transaktioner kan man generere en rapport eller eksportere data.

### Filformater
- **CSV-fil**: Indholdet organiseres med kolonnerne: `Amount, Category, Date, Income` samt en balance nederst.
- **XML-fil**: Indholdet præsenteres med en `<Budget>`-rod, hvor hver transaktion er et `<Transaction>`-element, og `<Balance>` viser den aktuelle balance.

## Eksempel på CSV-output
```
Amount,Category,Date,Income
500.0,Mad,2025-01-20,false
2000.0,Løn,2025-01-15,true

Balance: 1500.0
```

## Eksempel på XML-output
```xml
<Budget>
  <Transaction>
    <Amount>500.0</Amount>
    <Category>Mad</Category>
    <Date>2025-01-20</Date>
    <Income>false</Income>
  </Transaction>
  <Transaction>
    <Amount>2000.0</Amount>
    <Category>Løn</Category>
    <Date>2025-01-15</Date>
    <Income>true</Income>
  </Transaction>
  <Balance>1500.0</Balance>
</Budget>
```

## Kodeoversigt
Projektet består af følgende klasser:

- `Main`: Hovedklassen, der indeholder menuen og styrer brugerinput.
- `BudgetManager`: Håndterer transaktioner, rapportgenerering og eksport til filer.
- `Transaction`: Repræsenterer en individuel transaktion.
- `Category`: Kategoriserer transaktioner baseret på brugerinput.

## Udvidelsesmuligheder
- Implementering af filtreringsmuligheder for transaktioner baseret på dato eller kategori.
- Grafisk brugerflade (GUI) for bedre brugeroplevelse.
- Mulighed for at importere data fra CSV- eller XML-filer.

## Fejlhåndtering
- Hvis der opstår fejl ved eksport, vil fejlen vises i konsollen.


## Licens
Dette projekt er open source og under en passende licens (specificer gerne licensen her, fx MIT License).

