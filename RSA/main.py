def extended_euclidean_algorithm(e, phi):
    # Basisfall: Wenn phi = 0 ist, dann ist der größte gemeinsame Teiler e und der Koeffizient x = 1 und y = 0.
    if phi == 0:
        return e, 1, 0

    # Rekursiver Aufruf des erweiterten euklidischen Algorithmus
    gcd, x1, y1 = extended_euclidean_algorithm(phi, e % phi)

    # Berechnung der Koeffizienten x und y
    x = y1
    y = x1 - (e // phi) * y1

    return gcd, x, y


def calculate_d(e, phi):
    # Berechnung des inversen Moduls d mithilfe des erweiterten euklidischen Algorithmus
    gcd, x, _ = extended_euclidean_algorithm(e, phi)

    # Überprüfung, ob e und phi teilerfremd sind (größter gemeinsamer Teiler = 1)
    if gcd != 1:
        raise ValueError("e and 𝜑(𝑁) are not coprime.")

    d = x % phi

    return d


def verschluesseln(T, e, N):
    # Funktion zum Verschlüsseln einer Nachricht T
    G = []
    if isinstance(T, str):
        # Wenn die Nachricht T ein String ist, wird jeder Buchstabe einzeln verschlüsselt
        for t in T:
            t_zahl = ord(t)
            if len(str(t_zahl)) > 1:
                # Wenn die Zahl größer als einstellig ist, wird sie in einzelne Ziffern aufgeteilt und verschlüsselt
                g = []
                for tt in str(t_zahl):
                    g.append(int(tt) ** e % N)
                G.append(g)
            else:
                # Ansonsten wird die Zahl direkt verschlüsselt
                g = t_zahl ** e % N
                G.append(g)
    else:
        # Wenn die Nachricht T keine Zeichenkette ist, wird sie als Zahl behandelt und verschlüsselt
        g = T ** e % N
        G.append(g)
    return G


def entschluesseln(G, d, N):
    # Funktion zum Entschlüsseln einer verschlüsselten Nachricht G
    T = []
    for g in G:
        if isinstance(g, int):
            # Wenn das verschlüsselte Zeichen eine Zahl ist, wird sie entschlüsselt und in den ursprünglichen Buchstaben umgewandelt
            t = g ** d % N
            T.append(chr(t))
        else:
            # Wenn das verschlüsselte Zeichen eine mehrstellige Zahl ist, wird sie in einzelne Ziffern aufgeteilt und entschlüsselt
            t = ''
            for gg in g:
                t += str(gg ** d % N)
            T.append(chr(int(t)))
    return T


def start():
    T = 'Niklas Görke'
    p = 7
    q = 11
    # Berechnen von N
    N = p * q
    # Sicherstellen, dass N Richtig berechnet wurde, ist bei größeren Zahlen wichtig,
    # weil die maximale Variablengröße überschreitet werden kann
    if N != 77:
        print('fehler')
    # Sicherstellen, dass phi Richtig berechnet wurde, ist bei größeren Zahlen wichtig
    phi = (p - 1) * (q - 1)
    if phi != 60:
        print('fehler')

    e = 47
    # Berechnen von d mittels Euklidischen Algorithmus
    d = calculate_d(e, phi)
    # Sicherstellen, dass d Richtig ist, ist bei größeren Zahlen wichtig
    if d != 23:
        print('fehler')
    # Verschlüsseln und entschlüsseln und Consolenausgabe
    encrypted = verschluesseln(T, e, N)
    print('\n verschlüsselt')
    print(encrypted)
    print('\n entschlüsselt')
    decrypted = entschluesseln(encrypted, d, N)
    print(decrypted)
    # Umwandeln der Liste in einen String
    T = ''
    for t in decrypted:
        T += t
    print(T)

if __name__ == '__main__':
    start()
