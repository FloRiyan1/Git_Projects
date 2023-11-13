# This is a sample Python script.

artikel1 = ["Test1", 10.00, 5.00]
artikel2 = ["Test2", 15.00, 8.00]
artikel3 = ["Test3", 15.80, 9.00]
artikel4 = ["Test4", 20.00, 18.00]

wws = []
wws.append(artikel1)
wws.append(artikel2)
wws.append(artikel3)
wws.append(artikel4)

l = len(wws)
z = 0

while z < l+1:
    print(wws[z])
    print("=" + wws[0][0] + "/" + str(wws[0][1]))
    z += 1

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
