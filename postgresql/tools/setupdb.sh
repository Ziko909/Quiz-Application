#!/bin/bash

export PGPASSWORD=$POSTGRES_PASSWORD

docker-entrypoint.sh postgres &

function test_connection() {
  psql -h "$DBHOST" -U "$POSTGRES_USER" -d "$POSTGRES_DB" -c "SELECT 1" 2>&1 >  /dev/null
  return $?
}

while ! test_connection; do
  echo "Waiting for PostgreSQL..."
  sleep 2
done

python3 /bin/populatedb.py

wait