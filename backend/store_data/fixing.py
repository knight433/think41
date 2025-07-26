import pandas as pd

df = pd.read_csv(r'C:\programs\CN lab\think41\think41\backend\order_items.csv')
df = df.iloc[:, :10]  # keep only first 10 columns
df.to_csv('order_items_fixed.csv', index=False)
