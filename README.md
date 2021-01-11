# Software-Qualitaetssicherung

Aufgabenblatt 1

Übung 1
Lückentext: Bitte ergänzen Sie die Lücken.

import org.junit.Test;
import static org.mockito.Mockito.*;
public class MorningCheckTest {
@Test
public void testSayHello(){
Display display = [1]
TimeProvider timeProvider = [2]
when ( [3]).thenReturn ([4]);
MorningCheck morning Check = new morningCheck.sayHello();
verify [5]
}

[1] new Display();
[2] new TimeProvider(“t01”);
[3] display.sayHello()
[4] “Hello”
[5] (timeProvider, times(1) ).findById(“t01”);


Übung2
a) Implementieren Sie einen JUnitTest als Maven Projekt, welcher den Positivfall überprüft (genügend Geld eingezahlt und ein volles Fach)


b) Implementieren Sie den Test mit Hilfe von Mockito neu. Mocken Sie hierzu geeignete Objekte.

Übung3
Bisher haben wir uns die Mock-Objekte immer komplett von Mockito erzeugen lassen. Manchmal wollen wir jedoch nur bestimmte Methoden gesondert behandeln und für den Rest ein tatsächliches Objekt benutzen. Auch hierzu bietet uns Mockito ein entsprechendes Konstrukt an: Wir können mit Mockito.Spy einen „Spion“ auf ein existierendes Objekt erzeugen lassen. Dieser Spion dient als Wrapper und leitet, sofern nichts anderes konfiguriert wurde, alle Methodenaufrufe an ein echtes Objekt weiter. Nutzen Sie Mockito.Spy für Ihre Tests.

Übung4
Stellen Sie Vor- und Nachteile von JUnit im Vergleich zu Mockito dar.

