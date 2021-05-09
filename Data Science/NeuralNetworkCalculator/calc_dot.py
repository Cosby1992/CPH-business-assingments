# Calculate a neuron path using the dot product in the tranfer function
import math
import numpy

# Defining the input values and weights
X = numpy.array([2.0, 1.5])
W = numpy.array([1.45,-0.66])
# bias
b = 0

def sig(X, W, b):
    # Calculating the DOT-product
    xa = X @ W + b
    # Pass through the activation function
    return 1 / (1 + math.exp(-xa))

print(sig(X,W,b))



def mse(expected, predicted):
    return math.pow(predicted-expected, 2)

predicted = sig(X,W,b)
expected = b
mse = mse(expected, predicted)
deriviate = 2*mse

print("Expected:\t", expected)
print("Predicted:\t", predicted)
print("MSE:\t\t", mse)
print("Derivate:\t", deriviate)

print("\n--- Correction ---")
W[1] = W[1] - deriviate
predicted = sig(X, W, b)
expected = b
mse = mse(expected, predicted)

print("Expected:\t", expected)
print("Predicted:\t", predicted)
print("MSE:\t\t", mse)


