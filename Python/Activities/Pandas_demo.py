"""An Example of working pandas"""

import pandas as pd

data = {
        "A": [1, 2, 3, 4, 5],
        "B": [5, 7, 9, 3, 1],
        "C": [2, 4, 6, 8, 10],
        
}

table = pd.DataFrame(data)
print(table)