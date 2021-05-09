import numpy as np 

# neu/nn means neural network

X = np.array([2.0, 1.5])
w = np.array([1.45, -0.66]) # Weight
b = 0 # Absolute error / bias


def lin(w, x, b):
    return (w*x) + b

# Sigmoid Function
def sig(x):
    return 1/(1 + np.exp(-x))

# Neural Network Calculation
def neu(X, w, b):
    x = lin(X[0],w[0],b) + lin(X[1],w[1], b)
    y = sig(x)
    return y

# # Neural Network Calculation but easy
def nn(X,w,b):
  return sig(X@w+b)

# If the returned value is above 0.5 on , it's TRUE, and below it's FALSE
# Error = |predicted - expected|
# diff is differentiate
# f = X^2 = diff^2
# f' = df/d = 2x^1 = 2x
# f' = df/ddiff = 2diff^1 = 2diff

#derivate = 2(diff)
#derivate = 2*0.7586
#
def diff(predicted, expected):
    return predicted - expected

def meansquareError(predicted, expected):
    sqError = (nn(X, w, b) - expected )**2
    return sqError


predicted = neu(X, w, b)
expected = b
mse = meansquareError(predicted, expected)
derivate = 2*mse

print("Expected:\t", expected)
print("Predicted:\t", predicted)
print("MSE:\t\t", mse)
print("Derivate:\t", derivate)


print("\n--- Correction ---")
derivate = 2*mse
w = w - derivate
predicted = neu(X, w, b)
expected = b
mse = meansquareError(predicted, expected)

print("Expected:\t", expected)
print("Predicted:\t", predicted)
print("MSE:\t\t", mse)