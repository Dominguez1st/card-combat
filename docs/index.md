## Summary

_Project Card Combat_ is a turn based card game that pits the user against a Computer AI that can be 
played on your Android devices. _Project Card Combat_ lets the user create decks to beat the AI and 
allows the user to set conditions for the AI for the purpose of challenging other users. The game 
opens to a menu allowing the user to choose whether they wish to make a deck, play against the 
computer with their created decks, attempt the challenge quests, set conditions for AI for the user 
created challenge quests, and export their created decks and challenge quests via a generated QR 
code.

The purpose of this project originally was to act as a goal to facilitate the learning of Java and 
Android by the development team as all on the team had played and enjoyed card games before. As 
development continued the team had more potential than previously expected as an almost puzzle-like
game to challenge one's mind. What makes this card game unique among card games is the belief that 
the gameplay of _Project Card Combat_ is something hasn't been done many times before.

Two of the key functionalities of _Project Card Combat_ will be the persistent data and the 
camera functionality. Persistent data will be necessary as the user will be able to create new decks
and save them for future use. The camera of the Android device will be necessary to use the qr 
scanner portion of the app although if the then current user's device is lacking a camera then such
functionality will be missing though the rest of the application will still work.

## Intended users

* People who would like to pass some time with a quick simple game.

    > As someone who at times feels bored, I need an app that allows me to pass some time playing a 
    game, so that I'm not wasting my time doing absolutely nothing but instead keeping my brain 
    active.

* People who enjoy solving puzzles and thinking challenges.

    >  As someone who enjoys solving a good puzzle, I would like an app that lets me play pre-made 
    challenges that come with the app and after beating those the ability to play and create user 
    created challenges, so that my friends and I can continue having fun with each other.

## Current State of the Application
* Current State
    
    * Camera functionality has not been implemented yet.
    
    * Game logic has not been implemented yet.
    
    
* Possible Aesthetic/Cosmetic Enhancements

    * More art enhancements to the unit cards art.
    
    * A better color theme.

* Stretch Goals/Possible Enhancements 

    * PvP over bluetooth.
    
    * The ability to share decks with other users over bluetooth.

## Functionality

* Create custom-made decks.
	* The user chooses 3 units cards out of 7 and then chooses 5 attackType cards for each unit for 
	a total of a 15 card deck.
		* There 3 types of attackType cards that can be chosen for a unit, red cards, blue cards, 
		and green cards and one of each must be a chosen for a unit.
			* Red cards deal 1.5 times damage
			* Blue cards deal 1 times damage and build up the unit's magic gauge. 
			* Green cards deal 0.8 times damage and generate stars that increase the odds of a 
			critical hit for other cards during the next turn.
		* The unit cards have stats on them (i.e. _HP_, _ATK_, and _CRITICAL CHANCE_) and active 
		abilities on them (i.e. _Heal_) 
			* The user may also choose certain active abilities for the units though this may be 
			subject to change.
			* The units have a sort of Rock Paper Scissors style of effectiveness against each other.
		
* Play games against the computer with their created decks.
	* The game starts with the user's 3 unit cards placed on the field.
	* At the start of the user's turn, the user then draws 5 cards from their deck and any critical 
	stars are distributed to the attackType cards.
	* The user then can choose to either activate the unit cards' active abilities or enter the 
	attackType phase.
	* In the attackType phase the user chooses 3 cards of the 5 to attackType the computer with and 
	discards the other two.
		* (Note: Once the deck has been emptied, the played cards and the discarded cards are 
		shuffled together and form another deck to draw from again.)
	* The computer's turn then comes and plays similarly to the user's.
	* The user's turn then comes and this repeats until either the user or the computer wins.
	* **Please note that gameplay of _Project Card Combat_ is currently subject to change depending 
	on balance testing.**
	
* Play pre-made challenge quests or user created challenge quests.

* Set conditions for AI for the user created challenge quests.

* Create QR codes for custom-made decks or challenge quests.

* Scan QR codes to receive custom-made decks or challenge quests.

## Persistent data
* User created decks.

* User created AI Computer settings.

* Information about which challenges the user has completed.
    
## Build instructions

1. Go to the _[Card Combat Project Github](https://github.com/Dominguez1st/card-combat)_

2. With SSH selected, click on the green _Code_ button and then click on the clipboard icon to copy 
the link.

3. Turn on either _IntelliJ IDEA_ or _Android Studio_ and select new project from version control 
and then paste the copied link into URL field and click 
_Clone_.

5. Once the IDE has finished downloading everything, run the project by clicking the green hammer 
icon or clicking _Build Project_ in the _Build_ Menu.

6. Once the IDE has finished building the project, click the green arrow button or click the _'Run 
Card Combat.app'_ button in the _Run_ menu.

## User Instructions

* Upon starting the app the user will be brought to the _Login_ Screen at which point they will have 
to login in using a _Google Account_.  

* After logging in the user will automatically be taken to the _Main Menu Screen_ which will then 
allow the user to press one of four buttons to navigate the application.

* Should the user press the _LOGOUT_ Button then the user will be logged out of their _Google Account_
and be taken to the _Login_ Screen.

* If the user presses the _SCAN QR CODE_ then the user will be taken to qr code scanner screen.

    * From the qr code scanner screen the user will be able to use the current device's camera to 
    scan a qr code to receive a code that can be used to create a deck.
    
    * The user can press the _RETURN_ button to go back to the main menu screen.
    
* If the user presses the _EDIT/CREATE DECK_ then the user will be taken to the deck editor screen.

    * From the deck editor screen the user can edit their currently saved decks or create new decks 
    to play with.
    
    * The _SAVE DECK_ button will allow the user to save the currently selected deck.
    
    * The _GENERATE QR CODE_ button will allow the user to generate a qr code that will be saved 
    to the user's clipboard or allow them into a code to create a deck.
    
    * The user can press the _RETURN_ button to go back to the main menu screen.

* If the user presses the _PLAY_ then the user will be taken to the battle options screen.

    * On the battle options screen the user can choose which deck the user will be playing and which
    deck the computer will be playing.
    
    * The user can press the _RETURN_ button to go back to the main menu screen.
    
    * Pressing the _PLAY_ button will take the user to battle screen
    
        * Once the user has reached the battle screen the game will begin as described in the 
        functionality section.
        
        * Once the game has ended the user will be taken back to the battle options screen.
   
## [Technical Requirements and Dependencies](technical-requirements-dependencies.md)   
    
## [Wireframe](wireframe.md)

## [Entity-Relationship Diagram](erd.md)

## [Data Definition Language (DDL)](ddl.md)

## [Data Model Implementation](data-model-implementation.md)

## [External or Device-Based Services]()

## [Copyright & License Information](copyright.md)
