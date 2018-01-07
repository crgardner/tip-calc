# Tip-Calc

This is an experiment combining several things:

* Brian P. Hogan's [Exercises for Programmers](https://pragprog.com/book/bhwb/exercises-for-programmers)
(Tip Calculation Exercise)
* [The Clean Architecture](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html)
* Java 9 Modules
* Gradle [chainsaw](https://github.com/zyxist/chainsaw) plugin

# Running

At the root project directory (tip-calc) execute the following:

     ./gradlew run    # Linux (you may need to change the permissions)

     gradlew run      # Windows

Once the application is running, open a REST client and provide the following:

* URL: http://localhost:4567/tip
* Action: GET

If all works, a calculated tip amount (14.40) should appear in the response.

There is also an angular 5 application in the ui project. It is not part of the gradle build.  It can be run per the
README.md in that project.  Note you may have to install a CORS related plugin to your browser.  The server doesn't deal
with CORS at the moment.

