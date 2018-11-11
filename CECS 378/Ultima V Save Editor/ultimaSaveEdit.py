filePath = "Ultima_5/SAVED.GAM"

cOrder = {1: "PLAYER", 2: "SHAMINO", 3: "IOLO",
          4: "MARIAH", 5: "GEOFFREY", 6: "JAANA",
          7: "JULIA", 8: "DUPRE", 9: "KATRINA",
          10: "SENTRI", 11: "GWENNO",  12: "JOHNE",
          13: "GORN", 14: "MAXWELL", 15: "TOSHI",
          16: "SADUJ"}

cOffsets = {"PLAYER": int('0x02', 16), "SHAMINO": int('0x22', 16), "IOLO": int('0x42', 16),
            "MARIAH": int('0x62', 16), "GEOFFREY": int('0x82', 16), "JAANA": int('0xA2', 16),
            "JULIA": int('0xC2', 16), "DUPRE": int('0xE2', 16), "KATRINA": int('0x102', 16),
            "SENTRI": int('0x122', 16), "GWENNO": int('0x142', 16), "JOHNE": int('0x162', 16),
            "GORN": int('0x182', 16), "MAXWELL": int('0x1A2', 16), "TOSHI": int('0x1C2', 16),
            "SADUJ": int('0x1E2', 16)}

sOrder = {1: "STRENGTH", 2: "INTELLIGENCE", 3: "DEXTERITY",
          4: "HP", 5: "MAXHP", 6: "EXPERIENCE",
          7: "MAGIC"}

sOffsets = {"STRENGTH": int('0x0C', 16), "INTELLIGENCE": int('0x0E', 16), "DEXTERITY": int('0x0D', 16),
            "HP": int('0x10', 16), "MAXHP": int('0x12', 16), "EXPERIENCE": int('0x14', 16),
            "MAGIC": int('0x0F', 16)}

sMaxVal = {"STRENGTH": 255, "INTELLIGENCE": 255, "DEXTERITY": 255,
           "HP": 65535, "MAXHP": 65535, "EXPERIENCE": 65535,
           "MAGIC": 255}
iOrder = {1: "GOLD", 2: "KEYS", 3: "SKULL KEYS",
          4: "GEMS", 5: "BLACK BADGE", 6: "MAGIC CARPET",
          7: "MAGIC AXE"}

iOffsets = {"GOLD": int('0x204', 16), "KEYS": int('0x206', 16), "SKULL KEYS": int('0x20B', 16),
            "GEMS": int('0x207', 16), "BLACK BADGE": int('0x218', 16), "MAGIC CARPET": int('0x20A', 16),
            "MAGIC AXE": int('0x240', 16)}

iMaxVal = {"GOLD": 65535, "KEYS": 255, "SKULL KEYS": 255,
           "GEMS": 255, "BLACK BADGE": 255, "MAGIC CARPET": 255,
           "MAGIC AXE": 255}


def readData():
    with open(filePath, "rb") as save:
        dataBytes = list(bytearray(save.read()))
        save.close()
        return dataBytes


def statEdit(character, data):
    print("Which Stat Would You Like to Edit for {}?\n".format(
        cOrder[character]))
    print("1.  {}\n2.  {}\n3.  {}\n4.  {}\n5.  {}\n6.  {}\n7.  {}".format(sOrder[1], sOrder[2], sOrder.get(3), sOrder.get(4),
                                                                          sOrder[5], sOrder[6], sOrder[7]))
    while(True):
        try:
            choice = int(input())
        except ValueError:
            print("Please Select A Number 1 - 7 to Confirm Your Character Choice\n")
            continue
        if(choice < 1 or choice > 7):
            print("Please Select A Number 1 - 7 to Confirm Your Character Choice\n")
            continue
        else:
            break
    statName = sOrder[choice]
    index = sOffsets[statName] + cOffsets[cOrder[character]]
    maxVal = sMaxVal[statName]
    if(maxVal < 256):
        currVal = data[index]
    else:
        currVal = 0
    while(True):
        try:
            desired = int(input("Current Value For {} {} is {}. Please Enter a Value from 0 - {} to edit {} {}".format(
                cOrder[character], statName, data[index], maxVal, cOrder[character], statName)))
        except ValueError:
            print(
                "Please Select A Number 0 - {} to Confirm Your Character Choice\n".format(maxVal))
            continue
        if(desired < 0 or desired > maxVal):
            print(
                "Please Select A Number 0 - {} to Confirm Your Character Choice\n".format(maxVal))
            continue
        else:
            break
    counter = 0
    bArray = list(bytearray((desired).to_bytes(2, byteorder="little")))
    if(len(bArray) == 1):
        bArray.insert(0, 0)
    for n in bArray:
        data[index + counter] = n
        counter += 1
    print("{} {} Updated to {}".format(cOrder[character], statName, desired))
    choice = input(
        "Would you like to edit another stat? Enter Y for yes or N for No\n")
    while((choice.lower() != "y" and choice.lower() != "n")):
        choice = input(
            "Please Select Either Y for Yes or N for No to Confirm Your Choice\n")
    if(choice.lower() == "y"):
        statEdit(character, data)


def characterSelect(data):
    print("Which Character Would You Like to Edit?")
    print("1.  {}\n2.  {}\n3.  {}\n4.  {}\n5.  {}\n6.  {}\n7.  {}\n8.  {}".format(cOrder[1], cOrder[2], cOrder[3], cOrder[4],
                                                                                  cOrder[5], cOrder[6], cOrder[7], cOrder[8]))
    print("9.  {}\n10. {}\n11. {}\n12. {}\n13. {}\n14. {}\n15. {}\n16. {}".format(cOrder[9], cOrder[10], cOrder[11], cOrder[12],
                                                                                  cOrder[13], cOrder[14], cOrder[15], cOrder[16]))

    while(True):
        try:
            choice = int(input())
        except ValueError:
            print("Please Select A Number 1 - 16 to Confirm Your Character Choice\n")
            continue
        if(choice < 1 or choice > 16):
            print("Please Select A Number 1 - 16 to Confirm Your Character Choice\n")
            continue
        else:
            break
    statEdit(choice, data)
    choice = input(
        "Would you like to edit another character? Enter Y for yes or N for No\n")
    while((choice.lower() != "y" and choice.lower() != "n")):
        choice = input(
            "Please Select Either Y for Yes or N for No to Confirm Your Choice\n")
    if(choice.lower() == "y"):
        characterSelect(data)


def editCharacter(data):
    characterSelect(data)
    print("Returning to Main Menu\n")
    mainMenu(data)


def itemCountEdit(item, data):
    itemName = iOrder[item]
    index = iOffsets[itemName]
    maxVal = iMaxVal[itemName]
    if(maxVal > 255 and data[index] > 0):
        currVal = int(hex(data[index])[2:] + hex(data[index + 1])[2:], 16)
    elif(maxVal > 255 and data[index] == 0):
        currVal = data[index + 1]
    else:
        currVal = data[index]

    while(True):
        try:
            desired = int(input("Current Amount of {} in Inventory is {}. Please Enter a Value From 0 - {} to Edit Amount\n".format(
                itemName, currVal, maxVal)))
        except ValueError:
            print(
                "Please Select A Number 0 - {} to Confirm Your Amount\n".format(maxVal))
            continue
        if(desired < 0 or desired > maxVal):
            print(
                "Please Select A Number 0 - {} to Confirm Your Amount\n".format(maxVal))
            continue
        else:
            break
    counter = 0
    bArray = list(bytearray((desired).to_bytes(2, byteorder="little")))
    if(len(bArray) == 1):
        bArray.insert(0, 0)
    for n in bArray:
        data[index + counter] = n
        counter += 1
    print("Number of {} Updated to {}".format(itemName, desired))
    choice = input(
        "Would you like to Edit Another Amount? Enter Y for Yes or N for No\n")
    while((choice.lower() != "y" and choice.lower() != "n")):
        choice = input(
            "Please Select Either Y for Yes or N for No to Confirm Your Choice\n")
    if(choice.lower() == "y"):
        itemSelect(data)


def itemSelect(data):
    print("Which Inventory Item Would You Like to Edit?")
    print("1.  {}\n2.  {}\n3.  {}\n4.  {}\n5.  {}\n6.  {}\n7.  {}".format(iOrder[1], iOrder[2], iOrder[3], iOrder[4],
                                                                          iOrder[5], iOrder[6], iOrder[7]))
    while(True):
        try:
            choice = int(input())
        except ValueError:
            print("Please Select A Number 1 - 7 to Confirm Your Item Choice\n")
            continue
        if(choice < 1 or choice > 7):
            print("Please Select A Number 1 - 7 to Confirm Your Item Choice\n")
            continue
        else:
            break
    itemCountEdit(choice, data)


def editInventory(data):
    itemSelect(data)
    print("Returning to Main Menu\n")
    mainMenu(data)


def writeData(data):
    with open(filePath, "wb") as save:
        save.write(bytearray(data))
        save.close()


def mainMenu(data):
    print("Welcome to Ultima V Save Editor. What Would You Like to Edit?\n")
    print("1. Character Stats")
    print("2. Inventory (Gold, Keys, Axes, etc.)")
    print("3. Save and Exit")
    choice = input()
    while(choice != "1" and choice != "2" and choice != "3"):
        choice = input("Please Select Either 1 or 2 to Confirm Your Choice\n")
    if(choice == "1"):
        editCharacter(data)
    elif(choice == "2"):
        editInventory(data)
    else:
        print("Saving...")
        writeData(data)
        print("New Save File Created. Enjoy the Game!")


if __name__ == "__main__":
    mainMenu(readData())
