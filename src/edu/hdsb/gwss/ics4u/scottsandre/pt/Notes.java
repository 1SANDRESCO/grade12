//Class vs Object
//
//	- More efficient
//	- One variable/reference (and can use it everywhere inside the object; pass  ONE thing)
//	- Pass the object which includes data and methods (behaviours of that object)
//	- (pass to stack or queue or linked list, not one data type by one)
//
//Class Definitions; Properties vs Methods
//	- Variables, age, height, canGraduate, primitive data types
//	- Data structures; 1..1; 1..n; (relations to other objects)
//	- Methods (getters, setters, constructors, calculateXX, displayXX)
//
//Static vs Non-static
//	- Static: all objects SHARE the same data (triangles all have 3 side, ex)
//	triangle.calculateArea(2, 6);
//	- Non-static: data that are unique to each individual object (own)
//	Triangle t = new triangle (4, 5);
//	t.calculateArea();
//	
//calculateArea() --> not static (get info from object)
//calculateArea(int base, int height) --> static (same calculation when it is passed data)
//
//Encapsulation:
//	- Data hiding
//	- Private / public / protected
//	- When to use
//	- Properties: private! (not constants, all other variables private)
//	- Public width;
//		Here is why: t.width = -23; // PUBLIC
//	- Private width
//		Force them to use t.setWidth(-23);
//	- Methods:
//		- Private int getPin(); //that way it can only be called from inside the class
//		
//	- Private (only class can use it) // public (anywhere) // protected (same package)
//
//Constructor (use them to set values)
//	- Special method which creates the object
//	- Called once at creation
//	- Can pass it different values 
//	- Triangle t = new Triangle();//to be determined (primarily user input)
//	- Triangle t = new Triangle (2,3,4);//lengths
//	- Triangle t = new Triangle (4, 5); //base and height
//	- Call other constructors (this.) // use default size final values DEFAULT_WIDTH
//	- Call other constructors so there is limited duplicate code (not repeated)
//	- Allows you to use setters/getters
//	
//Clients 
//	- Code that uses your object
//
//Inheritance:
//
//	Constructor ! (super()
//	- Having a super/parent class with sub/child classes
//	- There can be many child classes for one parent class
//	- Vehicle: BEFORE
//		- numberOfWheels
//		- numberOfDoors
//		- numberOfSeats
//		- Operational
//		- On
//		- poweredBy
//		- topSpeed
//		- speed
//		
//		----------------------
//		- Setters/getters for each
//		- turnOn
//		- turnOff
//		- Move
//		- speedUp
//		- slowDown
//		- Break
//		- fillUp
//		
//	- Vehicle: AFTER
//		- numberOfWheels
//		- numberOfDoors (move to Car sub-class)
//		- numberOfSeats
//		- Operational
//		- On (move to Car sub-class)
//		- poweredBy
//		- topSpeed
//		- Speed
//		- Gas (move to Car sub-class)
//		- Number cylinders (move to Car sub-class)
//		
//		----------------------
//		- Setters/getters for each
//		- turnOn (move to Car sub-class)
//		- turnOff(move to Car sub-class)
//		- Move
//		- speedUp
//		- slowDown
//		- Break
//		- fillUp (move to Car sub-class)
//		- fillAir
//
//	- Bike 
//		- Types
//		- hasFrontShocks
//		- getIn
//		- oilChain etc etc
//	
//Polymorphism: (specific behaviours for sub class)
//	Car: move (press gas pedal)
//	Bike: move (pedal or go down incline)
//	Push back up common behaviours to super class
//	Super! (call parent method with same name and then do each specific move function)
//	What if no common code? (or just say that Vehicle is too broad a term and cannot exist)
//	
//Abstract Classes
//	- Abstract objects/methods
//	- Abstract objects cannot exist (by itself)\abstract methods need to be implemented in sub-class
//
//Interface:
//	- Method signatures (ensures you have them all)
//	- Any class that implements an interface must have the methods in the interface implemented
//
//	
//	
//		
//		
//		
//		
//	
