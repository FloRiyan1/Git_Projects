# Aufgabe 1 | Discountpreise

# Die Funktion nimmt einen Artikelpreis als Parameter entgegen (Parameter stehen in der Klammer)
# und gibt den rabattierenPreis des Artikels zurück
def berechne_rabatt(artikel_preis):
    if artikel_preis > 1000:
        artikel_preis *= 0.9
    return artikel_preis
