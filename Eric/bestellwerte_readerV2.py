import datetime

#########################################################################
# Beginn des Datenimports
#########################################################################
# Der folgende Programmabschnitte importiert  Bestellwerte aus einer Datei
# in das ARRAY bestellwerte. Jeder Datensatz für sich genommen ist eine Liste,
# die an das ARRAY bestellwerte angehängt wird.
# Wir verarbeiten damit Listen in Listen oder nested Lists

bestellwerte = []
rechnungsnummer: int = 10000


def loadData():
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

#for i in range(len(bestellwerte)):
    #print(bestellwerte[i][3]*bestellwerte[i][4])
    #betrag = bestellwerte[i][3]*bestellwerte[i][4]



# Aufgabe 3:
# Lassen nur Datensätze mit der selben orderid anzeigen.
# Die orderid geben Sie vor, z. B. per input()
#orderid = input("Geben Sie die OrderID ein: [00000]")
#for set in bestellwerte:
    #if set[1] == int(orderid) :
        #print(set)




# Aufgabe 4:
# Berechnen Sie den Wert einer bestimmten Bestellung, z. B. der orderid 10248,
# indem Sie die Summen bilden.

# Aufgabe 5:
# Überprüfen Sie Ihr Ergebnis, ABER: ordnen Sie erst die Datensätze der Liste bestellwerte
# zufällig neu an. Dazu wird random importiert und die Methode shuffle() aufgerufen
#import random
#random.shuffle(bestellwerte)
#print(bestellwerte)

# Aufgabe 6:
# Überprüfen Sie, wie viele Bestellungen pro Kunde vorliegen und
# lassen den customername und die Anzahl der Bestellungen anzeigen
# Hinweis: Eine neue Liste oder ein Dictionary könnten hilfreich sein.
# Dictionary:
#import random
#random.shuffle(bestellwerte)
#print(bestellwerte)


# Aufgabe 7:
# Es ist wichtig, die Kunden zu kennen, die in der Summe am meisten bestellen (Key Accounts).
# Lassen Sie die Top 3 oder Top 5 oder Top 10 anzeigen!

#########################################################################
# Hier beginnt die Aufgabe zur Erstellung der Rechnung
#########################################################################

def suche(suchbegriff, position=None, volltextsuche=False, listensuche=False):
    # Liste zur Speicherung der übereinstimmenden Werte
    ergebnis = []
    # Set zum Verfolgen der bereits hinzugefügten Werte
    gesehene_werte = set()
    # Überprüfe, ob eine Volltextsuche oder Positionsabhängige Suche durchgeführt werden soll
    if volltextsuche:
        # Iteriere über jeden Wert in der 'bestellwerte'-Liste
        for wert in bestellwerte:
            # Iteriere über jeden Inhalt im aktuellen Wert
            for inhalt in wert:
                # Überprüfe, ob der Suchbegriff im Inhalt (als Zeichenkette konvertiert) enthalten ist
                if str(suchbegriff) in str(inhalt):
                    # Überprüfe, ob der Wert bereits hinzugefügt wurde, wenn nicht fügt er diese hinzu
                    if tuple(wert) not in gesehene_werte:
                        ergebnis.append(wert)
                        gesehene_werte.add(tuple(wert))
    elif listensuche:
        for wert in bestellwerte:
            # Überprüfe, ob der Suchbegriff im Inhalt an der angegebenen Position (als Zeichenkette konvertiert) enthalten ist
            if str(suchbegriff) in str(wert[int(position)]):
                if tuple(wert) not in gesehene_werte:
                    ergebnis.append(wert)
                    gesehene_werte.add(tuple(wert))
    else:
        for wert in bestellwerte:
            # Überprüfe, ob der suchbegriff eine Liste ist und extrahiere das erste Element
            if isinstance(suchbegriff, list):
                suchbegriff = suchbegriff[0]
            # Überprüfe, ob der Wert an der bestimmten Position mit dem Suchbegriff übereinstimmt
            if str(suchbegriff) == str(wert[int(2)]):
                # Überprüfe, ob der Wert bereits hinzugefügt wurde
                if tuple(wert) not in gesehene_werte:
                    # Füge den Wert zur Ergebnisliste hinzu und markiere ihn als hinzugefügt
                    ergebnis.append(wert)
                    gesehene_werte.add(tuple(wert))
    return ergebnis


def suchekriterien(suchbegriff, suchkriterium):
    # Wandle das Suchkriterium in Kleinbuchstaben um
    suchkriterium = suchkriterium.lower()
    # Mapping der Suchkriterien zu den entsprechenden Positionen und Suchmodi
    suchkriterien_mapping = {
        "name": (0, False, True),
        "orderid": (1, False, True),
        "orderdetailsid": (2, False, True),
        "quantity": (3, False, True),
        "price": (4, False, True)
    }
    # Überprüfe, ob das Suchkriterium im Mapping enthalten ist
    if suchkriterium in suchkriterien_mapping:
        position, volltextsuche, listensuche = suchkriterien_mapping[suchkriterium]
        return suche(suchbegriff, position, volltextsuche, listensuche)
    else:
        # Für unbekannte Suchkriterien rufe die Suche-Funktion mit Position 5 und Positionsabhängiger Suche auf
        return suche(suchbegriff, 5, True, False)


def ueberpruefeNachkommalaengeUndKuerze(string):
    index = string.find('.')  # Finde den Index des Punkts im String
    if index != -1:  # Wenn ein Punkt gefunden wurde
        restlicher_string = string[index + 1:]  # Extrahiere den Teil des Strings nach dem Punkt
        if len(restlicher_string) >= 2:  # Überprüfe, ob mindestens 2 Zeichen nach dem Punkt folgen
            bereinigter_string = string[:index + 1] + restlicher_string[:2]  # Entferne alle weiteren Zeichen nach dem Punkt
            return bereinigter_string
    return string  # Gib den ursprünglichen String zurück, falls die Bedingungen nicht erfüllt sind


def erstelleRechnungsKopf(name):
    total_width = 60  # Gesamtbreite für die Formatierung der Zeilen festlegen
    zeile1_0 = str(name)  # Zeile 1, erster Teil: Name des Rechnungsempfängers
    zeile1_1 = "\tRechnungsnummer:\t" + str(rechnungsnummer)  # Zeile 1, zweiter Teil: Rechnungsnummer
    zeile1 = "{:<{width}}{:>{width}}".format(zeile1_0, zeile1_1, width=total_width // 2)  # Zeile 1 formatieren und ausrichten

    total_width = 67  # Gesamtbreite für die Formatierung der Zeilen festlegen
    zeile2_0 = "Straße"  # Zeile 2, erster Teil: Beschreibung des Adressfelds
    zeile2_1 = "\tRechnungsdatum:\t" + str(datetime.date.today().strftime("%d-%m-%Y"))  # Zeile 2, zweiter Teil: Rechnungsdatum (im Format "TT-MM-JJJJ")
    zeile2 = "{:<{width}}{:>{width}}".format(zeile2_0, zeile2_1, width=total_width // 2)  # Zeile 2 formatieren und ausrichten

    zeile3_0 = "PLZ Ort"  # Zeile 3, erster Teil: Beschreibung des Adressfelds
    zeile3_1 = "\tFälligkeitsdatum:\t" + str(datetime.date.today() + datetime.timedelta(weeks=2))  # Zeile 3, zweiter Teil: Fälligkeitsdatum (heutiges Datum plus 2 Wochen)
    zeile3 = "{:<{width}}{:>{width}}".format(zeile3_0, zeile3_1, width=total_width // 2)  # Zeile 3 formatieren und ausrichten

    kopf = "RECHNUNG\n\n\nRechnung an: \n\n" + zeile1 + "\n" + zeile2 + "\n" + zeile3 + "\n\n\n"
    # Erstellung der Kopfzeile der Rechnung mit zusätzlichen Leerzeilen und Zeilenumbrüchen
    # Der Kopf enthält die Bezeichnung "RECHNUNG" sowie den Rechnungsempfänger,
    # das Rechnungsdatum und das Fälligkeitsdatum
    return kopf  # Rückgabe des erstellten Rechnungskopfs


def erstelleRechnungsInhalt(rechnungsnummer):
    total_width_left_right = 20
    # Zeile 1 - Überschriften
    zeile1_0 = "Anzahl"
    zeile1_1 = "\tOrderId"
    zeile1_2 = "{:<{width}}{:>{width}}".format(zeile1_0, zeile1_1, width=total_width_left_right // 2)
    zeile1_3 = "\tPreis"
    zeile1_4 = "\tGesamtbetrag"
    zeile1_5 = "{:<{width}}{:>{width}}".format(zeile1_3, zeile1_4, width=total_width_left_right // 2)
    total_width = 65
    # Zeile 1 Gesamtbetrag mit Trennlinie
    zeile1 = "{:<{width}}{:>{width}}".format(zeile1_2, zeile1_5, width=total_width // 2) + "\n" + "_" * 72
    zeilen = [zeile1]
    # Iteriere über jede Rechnungsnummer
    for nummer in rechnungsnummer:
        # Suche Daten basierend auf der Rechnungsnummer
        data_list = suche(nummer, 2, False, False)
        # Iteriere über die gefundenen Daten
        for data in data_list:
            anzahl = str(data[3])
            beschreibung = "\t" + str(data[1])
            anzahl_beschreibung = "{:<{width}}{:>{width}}".format(anzahl, beschreibung, width=total_width_left_right // 2)
            preis = "\t" + str(data[4])
            betrag = data[3] * data[4]
            # Überprüfe den Betrag und formatiere den Gesamtbetrag entsprechend
            gesamtbetrag = "\t\t" if betrag > 1000 else "\t"
            gesamtbetrag += str(betrag) + "\n"
            preis_gesamtbetrag = "{:<{width}}{:>{width}}".format(preis, gesamtbetrag, width=total_width_left_right // 2)
            zeile = "{:<{width}}{:>{width}}".format(anzahl_beschreibung, preis_gesamtbetrag, width=total_width // 2)
            zeilen.append(zeile)
    return zeilen


def erstelleFuss(gewaehlteRechnungen):
    gesammtPreis = 0
    # Prüfen, ob mehrere Rechnungen ausgewählt wurden
    if ";" in gewaehlteRechnungen:
        # Iteriere über jede ausgewählte Orderdetails-ID
        for orderdetailsid in gewaehlteRechnungen:
            fullObjekt = suche(orderdetailsid, 2, False, False)
            preis = fullObjekt[0][4]
            anzahl = fullObjekt[0][3]
            gesammtPreis += (int(preis) * int(anzahl))
    else:
        # Nur eine Rechnung ausgewählt
        fullObjekt = suche(gewaehlteRechnungen, 2, False, False)
        preis = fullObjekt[0][4]
        anzahl = fullObjekt[0][3]
        gesammtPreis += (int(preis) * int(anzahl))
    abstand = " " * 44
    fussZeile = "_" * 72 + "\n"
    # Gesamtpreis-Zeile
    fussZeile += abstand + "{:<{width}}{:>{width}}".format("Gesamt Preis:", "\t" + ueberpruefeNachkommalaengeUndKuerze(str(gesammtPreis)) + "\n", width=20 // 2)
    # Mwst-Zeile
    fussZeile += abstand + "{:<{width}}{:>{width}}".format("Mwst:", "\t\t19%\n", width=20 // 2)
    # Endpreis-Zeile
    fussZeile += abstand + "{:<{width}}{:>{width}}".format("End Preis:", "\t\t" + ueberpruefeNachkommalaengeUndKuerze(str(gesammtPreis * 1.19)) + "\n", width=20 // 2)
    # Trenner
    fussZeile += "_" * 72 + "\n"
    # Skonto hinweis
    fussZeile += "Wenn sie innerhalb von 14 Tagen zahlen gewähren wir ihnen 3% Skonto\n"
    # Skonto Betrag
    fussZeile += abstand + "{:<{width}}{:>{width}}".format("Skonto:", "\t\t" + ueberpruefeNachkommalaengeUndKuerze(str((gesammtPreis * 1.19) * 0.97)) + "\n", width=20 // 2)
    #Trenner
    fussZeile += "_" * 72 + "\n"
    # Gruß Formel
    fussZeile += "\nMit freundlichen Grüßen\nEric Schikowski"
    # Iban
    fussZeile += "\n" * 2 + "IBAN: DE02 1001 0010 0006 8201 01"
    return fussZeile


def ausgabeOrderdetailsId(auswahl):
    orderdetailids = ""
    anzeigen = input("Möchten Sie sich nur die orderdetailsid anzeigen lassen? (Ja/Nein)").lower() == "ja".lower()
    if anzeigen:
        # Orderdetail-IDs mit Hilfe der join-Methode und einer Generator-Expression zu einem String zusammenfügen
        orderdetailids = ";".join(str(a[2]) for a in auswahl)
        print(orderdetailids)
    # Überprüfen, ob Rechnungen für alle angezeigten Orderdetail-IDs erstellt werden sollen
    rechnung_erstellen = anzeigen and input("Möchten Sie für alle angezeigten Orderdetail-IDs eine Rechnung erstellen? (Ja/Nein)").lower() == "ja".lower()
    # Rückgabe der Orderdetail-IDs, falls Rechnungen erstellt werden sollen, ansonsten Leerstring
    return orderdetailids if rechnung_erstellen else ""


def createFile(name, kopf, content, fuss):
    # Öffne die Datei im Anhangsmodus
    with open("Rechnung_" + str(name) + "_" + str(rechnungsnummer) + ".txt", "a") as f:
        # Füge den Rechnungskopf zur Datei hinzu
        f.write(str(kopf) +"\n")
        # Füge den Rechnungsinhalt zur Datei hinzu
        for c in content:
            f.write(str(c) + "\n")
        # Füge den Fußbereich zur Datei hinzu
        f.write(str(fuss) + "\n")
    # Schließe die Datei, um die Ressourcen freizugeben
    f.close()


def suchEingabeUser():
    # Fordere den Benutzer auf, ein Suchwort einzugeben
    suchwort = input("Suchwort: ")
    # Fordere den Benutzer auf, ein optionales Suchkriterium einzugeben
    auswahl = suchekriterien(suchwort, input("Optionales Suchkriterium: "))
    # Gib die Spaltenüberschriften aus
    print("name;Orderid;orderdetailid;quantity;price")
    # Gib die Ergebnisse aus
    for a in auswahl:
        print(a)
    # Gib die ausgewählten Ergebnisse zurück
    return auswahl


def auswahlDerInDerRechnungAuszugebenenOrderIds(gewaehlteRechnungen):
    valide = True
    name = ""
    # Überprüfen, ob mehrere Orderdetail-IDs ausgewählt wurden
    if ";" in gewaehlteRechnungen:
        name = suche(gewaehlteRechnungen.split(";")[0], 2, False, False)[0][0]
        orderdetailsids = gewaehlteRechnungen.split(";")
        # Entfernen von leeren Strings in der Liste der Orderdetail-IDs
        orderdetailsids = [orderdetailid for orderdetailid in orderdetailsids if orderdetailid != '']
        # Überprüfen, ob alle Orderdetail-IDs den gleichen Namen haben
        for orderdetailsid in orderdetailsids:
            if suche(orderdetailsid, 2, False, False)[0][0] != name:
                # Wenn unterschiedliche Namen gefunden werden, wird die Rechnung als ungültig markiert und die Schleife abgebrochen
                print("Rechnung fehlerhaft, es wurden mehrere Personen ausgewählt" + str(suche(orderdetailsid, 2, False, False)) + "   " + name)
                valide = False
                break
    # Überprüfen, ob die Rechnung als valide markiert ist
    if valide:
        # Rechnung mit mehreren Orderdetail-IDs erstellen
        createFile(name, erstelleRechnungsKopf(name), erstelleRechnungsInhalt(gewaehlteRechnungen.split(";")), erstelleFuss(gewaehlteRechnungen.split(";")))
    else:
        # Rechnung mit einer einzelnen Orderdetail-ID erstellen
        name = suche(gewaehlteRechnungen, 2, False, False)[0][0]
        createFile(name, erstelleRechnungsKopf(name), erstelleRechnungsInhalt(gewaehlteRechnungen), erstelleFuss(gewaehlteRechnungen))


# Eine Schleife, die das Programm fortsetzt, solange der Benutzer "Ja" eingibt
while input("Programm Fortfahren (Ja/Nein) ").lower() == "ja":
    # Funktion zum Laden von Daten aufrufen
    loadData()
    # Funktion zur Eingabe der Suche durch den Benutzer aufrufen
    auswahl = suchEingabeUser()
    orderdetailsid = ""
    # Überprüfen, ob der Benutzer die Suche eingrenzen möchte
    if input("Möchten Sie die Suche eingrenzen? (Ja/Nein)").lower() == "ja":
        # Funktion zur Ausgabe der Orderdetails-ID aufrufen, basierend auf der Suche des Benutzers
        orderdetailsid = ausgabeOrderdetailsId(suchEingabeUser())
    else:
        # Funktion zur Ausgabe der Orderdetails-ID aufrufen, basierend auf der vorherigen Auswahl des Benutzers
        orderdetailsid = ausgabeOrderdetailsId(auswahl)
    if orderdetailsid != "":
        # Funktion zur Auswahl der in der Rechnung auszugebenden Order-IDs aufrufen, basierend auf der Orderdetails-ID
        auswahlDerInDerRechnungAuszugebenenOrderIds(orderdetailsid)
    else:
        # Funktion zur Auswahl der in der Rechnung auszugebenden Order-IDs aufrufen, basierend auf Benutzereingabe
        auswahlDerInDerRechnungAuszugebenenOrderIds(input("Geben Sie eine der OrderDetailIds an (können auch mehrere sein, welche dann durch ';' getrennt werden müssen): "))
    # Inkrementieren der Rechnungsnummer
    rechnungsnummer += 1

#########################################################################
# Hier endet die Aufgabe zur Erstellung der Rechnung
#########################################################################