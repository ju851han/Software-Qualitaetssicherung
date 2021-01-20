# Aufgabenblatt 5

**Übung 1**<br>
 Bitte ergänzen Sie den Lückentext.

```java
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
```
[1] new Display();<br>
[2] new TimeProvider(“t01”);<br>
[3] display.sayHello()<br>
[4] “Hello”<br>
[5] (timeProvider, times(1) ).findById(“t01”);<br>


**Übung2**<br>
a) Implementieren Sie einen JUnitTest als Maven Projekt, welcher den Positivfall überprüft (genügend Geld eingezahlt und ein volles Fach)<br>
https://github.com/ju851han/Software-Qualitaetssicherung/blob/master/ue05/src/test/java/VendingMachineImpl_JUnitTest.java

b) Implementieren Sie den Test mit Hilfe von Mockito neu. Mocken Sie hierzu geeignete Objekte.<br>
https://github.com/ju851han/Software-Qualitaetssicherung/blob/master/ue05/src/test/java/VendingMachineImpl_MockitoTest.java

**Übung3**<br>
Bisher haben wir uns die Mock-Objekte immer komplett von Mockito erzeugen lassen. Manchmal wollen wir jedoch nur bestimmte Methoden gesondert behandeln und für den Rest ein tatsächliches Objekt benutzen. Auch hierzu bietet uns Mockito ein entsprechendes Konstrukt an: Wir können mit Mockito.Spy einen „Spion“ auf ein existierendes Objekt erzeugen lassen. Dieser Spion dient als Wrapper und leitet, sofern nichts anderes konfiguriert wurde, alle Methodenaufrufe an ein echtes Objekt weiter. Nutzen Sie Mockito.Spy für Ihre Tests.<br>
https://github.com/ju851han/Software-Qualitaetssicherung/blob/master/ue05/src/test/java/VendingMachineImpl_Spy.java

**Übung4**<br>
Stellen Sie Vor- und Nachteile von JUnit im Vergleich zu Mockito dar.<br>

||JUnit | Mockit|
| --- | --- | --- |
|Beschreibung|ist ein Framework, das beim Schreiben und Ausführen der Komponententests hilft.|ist ein Framework, das speziell für das effiziente Schreiben bestimmter Arten von Tests verwendet wird.|
|Verwendung| Verwendung ohne Mocking-Framework ist möglich | Verwendung ohne JUnit-Framework ist möglich, aber es gibt nicht viele gute Gründe, warum man Mockito für etwas anderes als Unit-Tests verwenden sollte|
|Ermöglicht Trennen von Produktions- und Testcode	|+ ja |	+ ja|
|Test-Objekte selbst schreiben|	- ja	|+ nein, es wird das zu testende Objekt einfach gemockt|
|Unterstützt TDD|	+ ja	|+ ja, wenn ein Mock erstellt wird, kann Service-Tests geschrieben werden, bevor der Service erstellt wird. Dadurch können die Tests zur Automatisierungsumgebung im Entwicklungsprozess hinzugefügt werden.|
|Unterstützt Verwendung von Annotationen|	+ ja: @Before, @tearDown, @Test	|+ja: @Mock, @InjectMocks, @Test, @RunWith(MockitoJunitRunner.class)|
|Teams können parallel arbeiten|	- nein, solange die Produktivklasse bzw. dessen Interface nicht implementiert ist, können auch keine Tests erstellt werden. | 	+ ja, zusätzliche Vorteile sind:  keine Ausfallzeiten (da Teams nicht darauf warten muss, bis das andere Team fertig ist, weniger Kosten  Vorgehensweise: 1. Es wird ein Mock von einem Service, zu dem noch kein Code zu diesem Zeitpunkt existiert, erstellt 2. Gegen diesen Mock werden Tests geschrieben, Dadurch steht eine vollständige Test-Suite  zur Verfügung 3. Wenn Service ist bereit fürs Testen, werden Tests darauf ausgeführt| 
| Unterstützt Überprüfungsmethoden	| + ja:	assertTrue(…); assertEquals(…);	usw.	| + ja:	verify(..); Verifikation, ob Reihenfolge der Aufrufe eingehalten wurde und Verifikation, ob keine, genaue oder mindestens X Anzahl an Aufrufe stattgefunden haben; when(…).thenReturn(…); + Wenn Schnittstellen-Methodennamen umbenannt oder Parameter umgeordnet werden, da Mocks zur Laufzeit erstellt werden |
| Ermöglicht Tests für nicht zugängliche Ressourcen zu schreiben	| - Nein, es ist nicht möglich. |	+ Ja, z.B. Dienst liegt hinter der Firewall und Firewall kann aufgrund fehlender Berechtigung nicht geöffnet werden Dafür kann ein MockService verwendet werden, der am zugänglichen Ort (z.B. lokalen Computer) platziert wird. + Es kann an den Kunden ausgeliefert werden: Es gibt Gründe, warum der Zugriff auf Testsysteme für externe Quellen, wie Partner oder Kunden, nicht erlauben können. Diese Gründe können die Zugriffssicherheit, die Sensibilität der Informationen oder einfach die Tatsache sein, dass die Testumgebung nicht rund um die Uhr zugänglich sein kann. Eine einfache Lösung lautet daher, die Bereitstellung eines Mocks, entweder aus Ihrem Netzwerk oder aus dem Netzwerk Ihres Kunden.|
| Ermöglicht Isolierung der Systeme |	- Bedingt, weil die Test-Komponenten erst programmiert werden müssen 	|+ Ja. Manchmal möchten Sie einen Teil Ihres Systems testen, ohne dass andere Systemteile darauf Einfluss nehmen, z.B. anderen Systeme Rauschen zu den Testdaten hinzufügen. Mithilfe von Mocks können alle Abhängigkeiten entfernt werden, indem alle Systeme mit Ausnahme des einen Systems, das im Test genau bestimmt wird, mocken.| 
| bereits in IDE  integriert | 	+ ja	 | - nein, man muss in der pom.xml vom Maven Projekt die dependency für Mockito eintragen|
