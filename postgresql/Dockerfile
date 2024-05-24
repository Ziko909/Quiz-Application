FROM  postgres:latest

MAINTAINER	Ziko909

LABEL	description="This image contains a postgres database populated with challenging quiz questions"

EXPOSE	5432

COPY ./tools/setupdb.sh /bin

COPY ./tools/populatedb.py /bin

COPY ./conf/.questions.json /

RUN  apt-get update \
     && apt-get install -y python3-psycopg2 python3-dotenv

RUN chmod +x /bin/setupdb.sh \
    && chmod +x /bin/populatedb.py \
    && chmod +r /.questions.json


ENTRYPOINT  setupdb.sh