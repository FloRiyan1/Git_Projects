#########################################################################
# Beginn des Datenimports
#########################################################################
# Der folgende Programmabschnitte importiert  Bestellwerte aus einer Datei
# in das ARRAY bestellwerte. Jeder Datensatz für sich genommen ist eine Liste,
# die an das ARRAY bestellwerte angehängt wird.
# Wir verarbeiten damit Listen in Listen oder nested Lists

bestellwerte = []
# Wir versuchen die Datei bestellwerte.csv zu öffnen.
# Wenn das nicht geht wird der Vorgang abgebrochen -> except
try:
    # Name der Datei
    file = 'bestellwerte.csv'
    # Daten in der Datei verarbeiten, Zeichen als utf-8 interpretieren
    with open(file, 'r', encoding='utf-8') as f:
        # jede Zeile einzeln verarbeiten
        # Die erste Zeile überspringen, weil dort nur Spaltenbezeichner stehen


        f.readline()
        # Jede einzelne line der Datei f enthält einen Datensatz.
        # Eine line wird gelesen
        for line in f:
            # und der name und die orderid extrahiert            
            # und anschließend als Liste an die Liste bestellwerte angehängt
            # Die Methode split(";") teilt den Datensatz jeweils am Semikolon auf.
            # Das Ergebnis ist eine Liste, die pro Datensatz die (Felder) Attribute
            # customername, orderid enthält.
            
            # Ergänzen Sie die folgenden Zeilen Code ...
            customername = line.split(";")[0]
            orderid = line.split(";")[1]
            orderdetailid = line.split(";")[2]
            quantity = line.split(";")[3]
            price = line.split(";")[4]
            bestellwerte.append([customername, int(orderid), int(orderdetailid), int(quantity), float(price)])
        # Datei schließen
    f.close()

# Datei konnte nicht geöffnet werden, weil diese nicht existiert
except:
    print("Datei konte nicht geöffnet werden")

#########################################################################
# Ende des Datenimports
#########################################################################


#########################################################################
# Hier beginnt der für Sie relevante Teil des Programms
#########################################################################

#print(bestellwerte)
#input()

# Ausgabe einiger Demowerte aus der Liste betsellwerte
#for i in range(10):
#    print(bestellwerte[i])




# Aufgabe 1:
# Verändern Sie den Code ab Zeile 32, so dass auch die 
# Felder orderdetailid, quantity und price importiert werden.
# siehe Code ab Zeile 32

# Aufgabe 2: 
# Berechnen Sie das Produkt aus quantity und price pro Datensatz und fügen Sie dies
# dem jeweiligen Datensatz hinzu.
# Siehe Zeile 37

for i in range(len(bestellwerte)):
    #print(bestellwerte[i][3]*bestellwerte[i][4])
    betrag = bestellwerte[i][3]*bestellwerte[i][4]



# Aufgabe 3: 
# Lassen nur Datensätze mit der selben orderid anzeigen. 
# Die orderid geben Sie vor, z. B. per input()
orderid = input("Geben Sie die OrderID ein: [00000]")
for set in bestellwerte:
    if set[1] == int(orderid) :
        print(set)




# Aufgabe 4: 
# Berechnen Sie den Wert einer bestimmten Bestellung, z. B. der orderid 10248,
# indem Sie die Summen bilden.

# Aufgabe 5: 
# Überprüfen Sie Ihr Ergebnis, ABER: ordnen Sie erst die Datensätze der Liste bestellwerte
# zufällig neu an. Dazu wird random importiert und die Methode shuffle() aufgerufen
import random
random.shuffle(bestellwerte)
#print(bestellwerte)

# Aufgabe 6: 
# Überprüfen Sie, wie viele Bestellungen pro Kunde vorliegen und 
# lassen den customername und die Anzahl der Bestellungen anzeigen
# Hinweis: Eine neue Liste oder ein Dictionary könnten hilfreich sein.
# Dictionary: 
import random
random.shuffle(bestellwerte)
#print(bestellwerte)


# Aufgabe 7: 
# Es ist wichtig, die Kunden zu kennen, die in der Summe am meisten bestellen (Key Accounts).
# Lassen Sie die Top 3 oder Top 5 oder Top 10 anzeigen!

