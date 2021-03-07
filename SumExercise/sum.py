

def sumExercise(n):
    res = 0
    for k in range(1, (n//2)+1):
        res += 2 * k
        print(res, 2*k)
    
    return res

sum100 = sumExercise(100)
sum1000 = sumExercise(1000)
sum1000000 = sumExercise(1000000)

print(sum100, sum1000, sum1000000)

