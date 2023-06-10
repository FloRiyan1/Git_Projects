def read_numbers_from_file(filename):
    numbers = []
    with open(filename, "r") as file:
        for line in file:
            number = int(line.strip())
            numbers.append(number)
    return numbers


def write_numbers_to_file(numbers, filename):
    with open(filename, "w") as file:
        for number in numbers:
            file.write(str(number) + "\n")


def sort_numbers(numbers):
    sorted_numbers = sorted(numbers)
    return sorted_numbers


input_filename = "output_100.txt"
output_filename = "output_100_sort.txt"


def sortieren():
    # Zahlen aus der Eingabedatei einlesen
    numbers = read_numbers_from_file(input_filename)

    # Zahlen sortieren
    sorted_numbers = sort_numbers(numbers)

    # Sortierte Zahlen in die Ausgabedatei schreiben
    write_numbers_to_file(sorted_numbers, output_filename)

    print("Sortierung abgeschlossen.")