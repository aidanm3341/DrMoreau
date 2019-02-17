# DrMoreau

When starting this project in your IDE it won't work at first
What you'll need to do it set up the project configuration, which will be different depending on your IDE.
You need to find where you add dependancies for the project, and add 3 jars as deoendancies, which are in the projects lwjgl folder.
Then you need to find where you can add VM options for running main, and add   -Djava.library.path=libs/
Then it should work.
