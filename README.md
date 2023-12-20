## For testing Java 21 Platform vs Virtual Threads. (SpringBoot 3.2)

This is just a playground project, the purpose of which was to try springboot with the virtual threads introduced in
3.2 (Java 21)

### Requirements

> Run External services:
> - java -jar externalservices/external-services.jar --server.port=7070

#### Before running the trip-advisor application, we can set whether we want to run the application using a platform or virtual threads:

    application.properties:
        spring.threads.virtual.enabled=true/false # true = virtual; false = platform

Let's test the application to see if it starts correctly with the attached postman collection.
We should receive a 200 response to both requests.

I have attached the jmeter jmx files and the results of a couple of tests I ran to the Jmeter tests.

> Before running the jmeter tests, it is worth warming up (from jmeter GUI):
> - Number of Threads: 60
> - Ramp-up period: 60
> - Duration: 60
>
> After that, run Jmeter with arbitrary values, e.g. 300-300-360, with the following command:
<strong> jmeter -n -t trip-plan.jmx -l virtual-trip-reserve.jtl</strong>

Ref: https://www.udemy.com/course/java-virtual-thread/
