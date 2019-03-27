# DrMoreau

When starting this project in your IDE it won't work at first
What you'll need to do it set up the project configuration, which will be different depending on your IDE.
Go to Project Structure under the File Tab and then choose the modules tab on the left.
You need to find where you add dependancies for the project, and add 3 jars as deoendancies, which are in the projects lwjgl folder press apply an okay.
Then run the main class. At the top bar click the drop down arrow by Main and click Edit configurations.
Type -Djava.library.path=libs/windows in VM options
Then you need to find where you can add VM options for running main, and add   -Djava.library.path=libs/windows
Then it should work.
