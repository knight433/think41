import psycopg2
import os

# Replace with your actual PostgreSQL credentials
DB_CONFIG = {
    'dbname': 'ecomdb',
    'user': 'postgres',
    'password': 'dhruva2003',
    'host': 'localhost',
    'port': 5432
}
def load_csv_to_table(cursor, csv_path, table_name):
    with open(csv_path, 'r', encoding='utf-8') as f:
        next(f)  # Skip header row
        cursor.copy_from(f, table_name, sep=',', null='')
    print(f"oaded data from {csv_path} into table '{table_name}'.")

def main():
    csv_file = r"C:\programs\CN lab\think41\think41\backend\order_items_fixed.csv"
    name ="order_items"

    if not os.path.exists(csv_file):
        print(f" File '{csv_file}' does not exist.")
        return

    try:
        conn = psycopg2.connect(**DB_CONFIG)
        cur = conn.cursor()

        # Optional: ensure schema is used
        cur.execute("SET search_path TO dev;")

        load_csv_to_table(cur, csv_file, name)
        conn.commit()

        cur.close()
        conn.close()

    except Exception as e:
        print(" Error occurred:", e)

if __name__ == '__main__':
    main()
