import psycopg2
import json
import os

from dotenv import load_dotenv

load_dotenv()

dbname = os.getenv('POSTGRES_DB', default="")
dbuser = os.getenv('POSTGRES_USER', default="")
dbpassword = os.getenv('POSTGRES_PASSWORD', default="")
dbhost = "localhost"

# Table details
table_name = "question"
table_schema = """
CREATE TABLE IF NOT EXISTS {table_name} (
      id SERIAL PRIMARY KEY,
      question TEXT,
      option1 TEXT,
      option2 TEXT,
      option3 TEXT,
      right_answer TEXT,
      difficulty_level TEXT
);
""".format(table_name=table_name)

json_file_path = "/.questions.json"

conn = psycopg2.connect(dbname=dbname, user=dbuser, password=dbpassword, host=dbhost)

def create_table():
    try:
        cur = conn.cursor()
        cur.execute(table_schema)
        conn.commit()
        print("Table created successfully.")
    except (Exception, psycopg2.Error) as error:
        print(f"Error creating table: {error}")


def populate_table(data):
    try:
        cur = conn.cursor()

        insert_query = f"""INSERT INTO question (question, option1, option2, option3, right_answer, difficulty_level)
                 VALUES (%s, %s, %s, %s, %s, %s)"""

        for item in data:
            question = item.get("question")
            option1 = item.get("option1")
            option2 = item.get("option2")
            option3 = item.get("option3")
            right_answer = item.get("right_answer")
            difficulty_level = item.get("difficulty_level")

            cur.execute(insert_query, (question, option1, option2, option3, right_answer, difficulty_level))
            conn.commit()
            print(f"Data inserted into table '{table_name}' successfully.")

    except (Exception, psycopg2.Error) as error:
        print(f"Error inserting data: {error}")
    finally:
        if conn:
            conn.close()


with open(json_file_path, "r") as f:
    data = json.load(f)

create_table()

populate_table(data)

print("The Database has been populated.")
