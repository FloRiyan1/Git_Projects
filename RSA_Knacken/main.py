import RSA
from datetime import datetime

prime_set = []


def generate_prime_numbers(n):
    primes = [True] * (n+1)
    primes[0] = primes[1] = False

    p = 2
    while p * p <= n:
        if primes[p]:
            for i in range(p * p, n+1, p):
                primes[i] = False
        p += 1

    prime_numbers = [i for i, is_prime in enumerate(primes) if is_prime]
    return prime_numbers


def get_prime_set():
    prime_set = []
    with open('D:\\Git_Projects\\Primzahlen_Multithreading\\output_100.txt', 'r', encoding='utf-8') as file:
        for line in file:
            prime = line.strip()
            prime_set.append(int(prime))
    return prime_set


def contains_only_words(string, word_set):
    words = string.split()
    for word in words:
        if word.lower() not in word_set:
            return False
    return True


def is_prime(number):
    if number < 2:
        return False
    for i in range(2, int(number ** 0.5) + 1):
        if number % i == 0:
            return False
    return True


def get_schluessel_combie(N):
    kombies = []
    print('test')
    for number in prime_set:
        if N % number == 0:  # Überprüfe, ob number ein Teiler von N ist
            other_number = N // number  # Berechne den anderen Teiler
            if is_prime(other_number):  # Überprüfe, ob der andere Teiler eine Primzahl ist
                new_kombie = [number, other_number]
                #checken ob schon drin ist
                kombies.append(new_kombie)

    return kombies


def get_moegliche_schluessel(combies, e):
    schlussel = []
    for combie in combies:
        p = combie[0]
        q = combie[1]
        phi = ((p-1) * (q-1))
        d = RSA.calculate_d(e, phi)
        schlussel.append([d, p * q])
    return schlussel

#aufrufen um weitere Primzahlen zu generieren
def save_primes():
    with open("primes.txt", 'a', encoding='utf-8') as file:
        for number in range(1198465057, 999999999999999):
            if is_prime(number):
                print(number)
                file.write(str(number) + '\n')

#10stellig = 20sek
if __name__ == '__main__':
    print(datetime.now())
    print('getPrimes')
    prime_set = get_prime_set()
    while True:
        rsa_daten = RSA.start(input('geben Sie ein Wort zum Verschlüsseln ein: '))
        print(rsa_daten[1])
        print(datetime.now())
        p_q = get_schluessel_combie(rsa_daten[1])
        print(p_q)
        schluessel = get_moegliche_schluessel(p_q, rsa_daten[4])
        print(schluessel, 'schlüssel', rsa_daten[5])
        for s in schluessel:
            print(RSA.entschluesseln(rsa_daten[0], s[0], s[1]))
        if input('weiter? ').lower() == 'ja':
            break


