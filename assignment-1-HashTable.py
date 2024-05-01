def linearProbing(table, size, key):
    collisions = 0 #counter
    pos = key % size
    if(table[pos] == -1):
        table[pos] = key
        print("LP: ",key, " is added at position ", pos, "\n")
    else:
        while(table[pos] != -1):
            if (pos < size):
                collisions += 1
                pos = (pos + 1) % size #linear probing
            else:            
                print("Table is full!")
                break
        table[pos] = key
        print("Collision Occured:", collisions, end = " ")
        print("LP: ",key, " is added at position ", pos, "\n")
    return collisions

#----------------------------------------------------#

def quadraticProbing(table, size, key):
    collisions = 0 #counter
    pos = key % size
    i = 1
    if(table[pos] == -1):
        table[pos] = key
        print("QP: ", key, " is added at position ", pos, "\n")
    else:
        while(table[pos] != -1):
            collisions += 1
            if (pos < size):
                pos = (pos + (i ** 2)) % size #Quadratic Probing
                i += 1
            else:
                print("Table is full!")
                break
        table[pos] = key
        print("Collision Occured:", collisions, end = " ")
        print("QP: ",key, " is added at position ", pos, "\n")
    return collisions

#----------------------------------------------------#

def compareProbing(count1, count2):
    if(count1 < count2):
        print("Better collision resolution technique is one with least collisions.")
        print("Here, that is Linear Probing.")
    else:
        print("Better collision resolution technique is one with least collisions.")
        print("Here, that is Quadratic Probing.")

#----------------------------------------------------#

#MAIN PROGRAM
linearCollisions = 0
quadraticCollisions = 0
size = int(input("Enter size of the table: "))

linearHashTable= []
quadraticHashTable = []
for i in range(size): #create
    linearHashTable.append(-1)
    quadraticHashTable.append(-1)

for i in range(size): #input
    print(i+1, ".", end="")
    telNo = int(input("Enter telephone number: "))
    linearCollisions += linearProbing(linearHashTable, size, telNo)
    quadraticCollisions += quadraticProbing(quadraticHashTable, size, telNo)

print("\nHash Table with Linear Probing: ", linearHashTable)
print("Hash Table with Quadratic Probing: ", quadraticHashTable)

print("\nNumber of collisions for Linear Probing: ", linearCollisions)
print("Number of collisions for Quadratic Probing: ", quadraticCollisions)

compareProbing(linearCollisions, quadraticCollisions)