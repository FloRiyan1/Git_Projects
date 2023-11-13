# Aufgabe 2 | Überprüfung der Bestellung

def berechne_gesamtpreis(anzahl_schraube, anzahl_mutter, anzahl_unterlegscheibe):
    gesamtpreis = int(anzahl_schraube) * 5
    gesamtpreis += int(anzahl_mutter) * 3
    gesamtpreis += int(anzahl_unterlegscheibe)
    return gesamtpreis


def check_eingabe(anzahl_schraube, anzahl_mutter, anzahl_unterlegscheiben):
    if anzahl_schraube > anzahl_mutter:
        print("Kontrollieren Sie Ihre Bestellung!")
        # get_user_input()  # Wenn automatisch der User nochmal zur neueingabe aufgefordert werden soll, kann diese
        # funktion hier aufgerufen werden
    else:
        print("Die Bestellung ist okay. \n")
    print("Der gesamtbetrag beträgt: " +
          str(berechne_gesamtpreis(anzahl_schraube, anzahl_mutter, anzahl_unterlegscheiben)))


def get_user_input():
    input_anzahl_schrauben = input("Wie viele Schrauben möchten Sie kaufen? ")
    input_anzahl_mutter = input("Wie viele Muttern möchten Sie kaufen? ")
    input_anzahl_unterlegscheiben = input("Wie viele Unterlegscheiben möchten Sie kaufen? ")
    check_eingabe(input_anzahl_schrauben, input_anzahl_mutter, input_anzahl_unterlegscheiben)


print("Hallo und herzlich willkommen in unseren Online Shop")
get_user_input()
