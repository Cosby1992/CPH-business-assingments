# Imports 
import pandas as pd
import numpy as np
from sklearn import linear_model
from sklearn.linear_model import LinearRegression
import sklearn.metrics as sm

import matplotlib.pyplot as plt
import seaborn as sns

import pickle


# Read the data
df = pd.read_csv('data/student_scores.csv')

# Check the data
print("Data shape: ", df.shape)
print(df.head())

# Get data labels
print(list(df))

# Get info about the datatypes in the data
print()
print(df.info())

# Print the basic statistical parameters for each column
# count, mean, std, min, 25%, 50%, 75%, max
print()
print(df.describe())

plt.ylabel('Scores')
plt.xlabel('age')
plt.scatter(df.Hours, df.Scores, color='green')
plt.savefig('demo.png')

sns.displot(df['Hours'], label='hours', norm_hist=True)
