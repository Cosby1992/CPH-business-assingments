# Calculate a neuron path

import math

# The two inputs 
X1 = 2.0
X2 = 1.5

# The two weights
w1 = 1.45
w2 = -0.66

# The bias
b = 0

# Calculating the "input" for the activation function
# This is called the transfer function
xa = X1*w1 + X2*w2 + b

# Use the activation function
y = 1 / (1 + math.exp(-xa))

print(y)