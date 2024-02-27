### Assignment 3

Link to github: https://github.com/Peyton-McKee/cs4520-assg3-starter-code

No other information needed to run the application

I used a navigation graph to link the home fragment to the mvp fragment and mvvm fragment. I also created one calculator view that both my mvvm fragment and mvp fragment use in order to reduce duplicate code

I Implemented a model view presenter by using an abstraction of my view functions and invoking them from inside the presenter that handles all the logic . 

View model uses the standard view model interface to maintain live data through orientation changes. It also handles all the logic and updating the result text view 