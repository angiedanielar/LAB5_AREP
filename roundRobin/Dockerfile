FROM openjdk:8

WORKDIR /roundRobin/bin

ENV PORT 6001

COPY /target/classes /roundRobin/bin/classes
COPY /target/dependency /roundRobin/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","edu.escuelaing.arep.roundRobin.App"]
