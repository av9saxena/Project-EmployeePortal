cd EmployeePortal
call gradlew clean build -x test
cd build/libs
java -jar EmployeePortal-1.0.jar