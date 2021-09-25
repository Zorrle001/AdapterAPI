<h1>AdapterAPI</h1>

The Adapter API is a new project of mine that is publicly available to everyone

The API is intended to be integrated into other projects in order to create very simple events, or as they are called adapters here.This means that every user who uses the project can easily create a whole system for themselves

--

Die Adapter API ist ein neues Projekt von mir, das für jeden öffentlich zugänglich ist

Die API ist dafür gedacht, dass man sie in andere Projekte integriert um so ganz einfache Events, oder wie sie hier heißen Adapter, zu erstellen. Damit kann jeder Nutzer der dass Projekt benutzt und ihr selber extrem einfach ein ganzes System erstellen

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

</h4>MERKE:</h4>
Wichtige Methoden sind hierbei:

```java
adapter.setCancelled(true);
adapter.setCancelled(false);
adapter.isCancelled();
```

Hiermit kannst du ein AdapterEvent steuern und es Abbrechen mit <code>adapter.setCancelled(true)</code> und auslesen ob es abgebrochen ist oder nicht
mit <code>adapter.isCancelled()</code> Diese Methode gibt einen Boolean zurück welcher den Status des AdapterEvents darstellt
