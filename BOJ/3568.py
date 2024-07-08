# https://www.acmicpc.net/problem/3568

splitLst = input().split()
first = splitLst[0]
var_name, var_type = [], []
for i in range(1, len(splitLst)):
    string = splitLst[i].replace("[]", "][")
    idx = 0
    for j in range(len(splitLst[i])):
        if not splitLst[i][j].isalpha():
            idx = j
            break
    var_name.append(string[0:idx])
    var_type.append(string[-2:idx-1:-1])

for i in range(len(var_name)):
    print(first+var_type[i]+" "+var_name[i]+";")