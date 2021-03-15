FROM openjdk:8

WORKDIR /logService/bin

ENV PORT 6001

COPY /target/classes /logService/bin/classes
COPY /target/dependency /logService/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","edu.escuelaing.arep.logServiceApp.controllers.App"]