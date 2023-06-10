import threading
from datetime import datetime
import os
import Sort


num_threads = 64


def is_prime(number):
    if number < 2:
        return False
    for i in range(2, int(number ** 0.5) + 1):
        if number % i == 0:
            return False
    return True


def count_numbers(start, end, sufix, file):
    with open(file, "a") as output_file:
        for i in range(start, end):
            if is_prime(i):
                output_file.write(str(i) + '\n')


def thread_sachen(iterations_per_thread, done_iterations):
    threads = []
    end = 0

    for i in range(num_threads):
        start = i * iterations_per_thread + 1 + done_iterations
        end = start + iterations_per_thread
        thread = threading.Thread(target=count_numbers, args=(start, end, i, f"output_{i}.txt"))
        threads.append(thread)
        thread.start()

    for thread in threads:
        thread.join()

    return end


def copy_file(source_file, target_file):
    with open(source_file, 'r') as source, open(target_file, 'a') as target:
        content = source.read()
        target.write(content)


def copy_to_one_file_and_delete_other():
    for i in range(num_threads):
        file_name = f'output_{i}.txt'
        copy_file(file_name, 'output_100.txt')
        os.remove(file_name)


def zeit_info():
    zeit_list.append(datetime.now())
    dauer = []

    for i in range(1, len(zeit_list)):
        now = zeit_list[i]
        previous = zeit_list[i-1]
        duration = (now - previous).total_seconds()
        dauer.append(duration)

    return sum(dauer) / len(dauer)


def sek_umrechnen(total_sekunden):
    sekunden_pro_tag = 86400
    total_sekunden_int = int(total_sekunden)
    if total_sekunden_int > 1:
        vergangene_sekunden = total_sekunden_int % sekunden_pro_tag

        stunden = vergangene_sekunden // 3600
        minuten = (vergangene_sekunden % 3600) // 60
        sekunden = (vergangene_sekunden % 3600) % 60

        uhrzeit = f"{stunden:02d}:{minuten:02d}:{sekunden:02d}"

        return "Uhrzeit:", uhrzeit
    return total_sekunden


print(datetime.now(), 'start')
zeit_list = [datetime.now()]
iterations_per_thread = 100_000
done_iterations = 230400017



Sort.sortieren()

print(datetime.now())
