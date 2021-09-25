<h1>AdapterAPI</h1>

The Adapter API is a new project of mine that is publicly available to everyone

The API is intended to be integrated into other projects in order to create very simple events, or as they are called adapters here.This means that every user who uses the project can easily create a whole system for themselves

--

Die Adapter API ist ein neues Projekt von mir, das für jeden öffentlich zugänglich ist

Die API ist dafür gedacht, dass man sie in andere Projekte integriert um so ganz einfache Events, oder wie sie hier heißen Adapter, zu erstellen. Damit kann jeder Nutzer der dass Projekt benutzt und ihr selber extrem einfach ein ganzes System erstellen

<h2>Overview / Übersicht</h2>

- <a href="#documentation-english">Documentation English -> Work in progress, coming soon</a>
- <a href="#dokumentation-deutsch">Dokumentation Deutsch</a>

	- <a href="#kapitel-1-wie-sieht-ein-adapter-aus">Kapitel 1: Wie sieht ein Adapter aus?</a>
	- <a href="#kapitel-2-ein-listeneradapter">Kapitel 2: Ein ListenerAdapter</a>
	- <a href="#kapitel-3-in-arbeit">Kapitel 3: In Arbeit...</a>

<h2>Dokumentation (Deutsch)</h2>

<h3>Kapitel 1: Wie sieht ein Adapter aus?</h3>

```java
@AdapterHandler
public void onTest(TestAdapter adapter) {
  System.out.println("Test123");
}
```
Jeder Adapter ist eingeteilt in 3 Verschiedene Teile:

<h4>Teil 1: Die Annotation</h4>

Die Annotation ist eines der wichtigsten Elemente bei einem Adapter. Diese kann in einigen Fällen auch weggelassen werden, mehr dazu jedoch erst später.
Die Annotation markiert die Methode als einen Adapter, sodass die API direkt erkennt um was es sich handelt.

<h4>WICHTIG:</h4>
Wenn die Annotation fehlt, wird der Adapter nicht erkannt und kann nicht ausgeführt werden!

<h4>Teil 2: Die Methode</h4>

Hier könnt ihr eurem Adapter einen frei gewählten Namen geben, dass spielt keine Rolle.
Wichtig ist nun der Parameter der in der Methode übergeben wird. Dieser Parameter ist ein AdapterEvent und ist sozusagen der Auslöser deines Adapters. 
Wenn dieses AdapterEvent ausgeführt wird, werden alle Adapter mit diesem Parameter ausgeführt.

<h4>WICHTIG:</h4>
Ihr müsst eurem AdapterEvent immer einen Parameternamen zuordnen z.B adapter (wie im Beispiel gezeigt), sonst gibt es einen Fehler!

<h4>Teil 3: Der Code</h4>

Der Code ist nun einfach der Bereich in dem ihr definiert, was ausgeführt werden soll, wenn euer Adapter ausgeführt wird.

<h4>MERKE:</h4>

Wichtige Methoden sind hierbei:

```java
adapter.setCancelled(true);
adapter.setCancelled(false);
adapter.isCancelled()
```


Hiermit kannst du ein AdapterEvent steuern und es Abbrechen mit <code>adapter.setCancelled(true)</code> und auslesen ob es abgebrochen ist oder nicht
mit <code>adapter.isCancelled()</code> Diese Methode gibt einen Boolean zurück welcher den Status des AdapterEvents darstellt

<h3>Kapitel 2: Ein ListenerAdapter</h3>

```java
public class TestListener implements ListenerAdapter {

  @AdapterHandler
  public void onTest(TestAdapter a) {
    System.out.println("Test123");
  }
	
}
```

Im Grunde genommen ist der ListenerAdapter eine Klasse, in der sich ein oder mehrere Adapter befinden.
Diese Klasse muss immer einen ListenerAdapter Implementieren, damit die API versteht, dass diese Klasse
ein ListenerAdapter ist.

Jetzt musst du nurnoch der API sagen wo sich dieser ListenerAdapter befindet:

```java
public static void main(String[] args) {
  addListenerAdapter(new TestListener());
}
```

Dies solltest du immer am Anfang machen, also am besten in der <code>main</code>-Methode oder kurz nach dem Start des Programmes.
Die Klasse in der du deine ListenerAdapter registrierst, muss den AdapterManager Extenden mit <code>public class {Classname} extends AdapterManager</code>.
Du kannst einen ListenerAdapter auch wieder entfernen mit <code>removeListenerAdapter(ListenerAdapter)</code> oder direkt alle löschen
mit <code>clearListenerAdapters()</code>
  
<h4>WICHTIG:</h4>
Bitte beachte, dass die Klasse in der die ListenerAdapter registriert sind den AdapterManager Extenden muss! Wenn du dass jedoch nicht
kannst oder willst kannst du auch <code>AdapterManager.</code> vor jede der Methoden schreiben, um auf den Static-Weg die Methoden 
anzusprechen

<h2>Kapitel 3 in Arbeit...</h2>
