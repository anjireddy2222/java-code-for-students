import csv
from faker import Faker
import random

# Generate fake data
fake = Faker()

# Open a CSV file in write mode
with open('sample_sales_data_100000.csv', 'w', newline='') as csvfile:
    # Define CSV writer
    fieldnames = ['order_id', 'customer_id', 'date', 'product_id', 'quantity', 'price']
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)

    # Write header
    writer.writeheader()

    # Write 100,000 lines of data
    for i in range(1, 100001):
        order_id = i
        customer_id = fake.random_int(min=100, max=999)
        date = fake.date_between(start_date='-1y', end_date='today')
        product_id = fake.random_int(min=100, max=199)
        quantity = random.randint(1, 5)
        price = round(random.uniform(5.99, 4000), 2)

        # Write row to CSV file
        writer.writerow({'order_id': order_id, 'customer_id': customer_id, 'date': date,
                         'product_id': product_id, 'quantity': quantity, 'price': price})

print("CSV file with 100,000 lines generated successfully!")
