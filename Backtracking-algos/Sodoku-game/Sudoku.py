N = 9
def is_validInput(arr,r,c):
    for i in range(N):
        if i==c:
            continue
        elif arr[r][i]==arr[r][c] :
            return False
    
    for i in range(N):
        if i==r:
            continue
        elif arr[i][c]==arr[r][c] :
            return False
    x = r-(r%3)
    y = c-(c%3)
    for i in range(3):
        for j in range(3):
             if r== i+x and c== j+y:
                 continue
             if arr[i+x][j+y] == arr[r][c]:
                return False
    return True

def is_suduko(arr,r,c):

    if(r>=N-1 and c>=N):
        return True
    if(c==N):
        r=r+1
        c=0
    if(arr[r][c]!=0):
        return is_suduko(arr,r,c+1)
    for i in reversed(range(1,10)):
        arr[r][c]=i
        if is_validInput(arr,r,c):
            if is_suduko(arr,r,c+1):
                return True
        arr[r][c]=0
    return False

def print_suduko(arr):
    for i in range(9):
        for j in range(9):
            print(str(arr[i][j]),end=" "),
        print()


def main_method():
    arr = [ [ 5, 3, 0, 0, 7, 0, 0, 0, 0 ], 
            [ 6, 0, 0, 1, 9, 5, 0, 0, 0 ], 
            [ 0, 9, 8, 0, 0, 0, 0, 6, 0 ], 
            [ 8, 0, 0, 0, 0, 0, 0, 0, 3 ], 
            [ 4, 0, 0, 0, 0, 0, 0, 0, 1 ], 
            [ 7, 0, 0, 0, 0, 0, 0, 0, 6 ], 
            [ 0, 6, 0, 0, 0, 0, 2, 8, 0 ], 
            [ 0, 0, 0, 4, 1, 9, 0, 0, 5 ], 
            [ 0, 0, 0, 0, 8, 0, 0, 7, 9 ]]
    if(is_suduko(arr,0,0)):
        print_suduko(arr)
    else:
        print("invalid input.. can't build the sudukoo with this !!!")
    

main_method()