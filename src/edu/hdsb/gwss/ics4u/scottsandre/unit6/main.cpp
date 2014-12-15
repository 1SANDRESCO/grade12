
// function example
#include <iostream>
#include <stdio.h>  
using namespace std;

void displayMenu() {
    std::cout << "Enter your desired number \n\n";
    std::cout << "0: Exit\n";
    std::cout << "1: If statement program\n";
    std::cout << "2: Loop program\n";
    std::cout << "3: Method program\n";
    std::cout << "4: Array program\n";
    std::cout << "5: OOP task\n";
}

void ifProgram(){
    cout << "\nIF STATEMENT PROGRAM\n";
}

void loopProgram(){
    cout << "\nLOOP PROGRAM\n";
    cout << "Fibonacci Sequence\n";
    int a = 1;
    int b = 1;
    int c;
    
    // cout << a << ", " << b << ", ";
    int j=1, k=1, sum;
	
	for (int i=0; i<20; i++) 
	{
		cout << a << ", ";
		c=a+b;
		a=b;
		b=c;
	}
    cout << "\n";
}

int main() {
    int choice;
    bool exit = false;
    std::cout << "Scott and Alex Programming with C++\n";

    while (exit == false) {
        displayMenu();
        //cin >> choice;
        scanf("%i", &choice);
        cout << choice + "\n";
        switch (choice) {
            case 1:// If statement
                ifProgram();
                break;
            case 2:// loops
                loopProgram();
                break;
            case 3:// method
                break;
            case 4:// array
                break;

        }
    }


}

//int subtraction (int a, int b)
//{
//  int r;
//  r=a-b;
//  return r;
//}
//
//int main ()
//{
//  int x=5, y=3, z;
//  z = subtraction (7,2);
//  cout << "The first result is " << z << '\n';
//  cout << "The second result is " << subtraction (7,2) << '\n';
//  cout << "The third result is " << subtraction (x,y) << '\n';
//  z= 4 + subtraction (x,y);
//  cout << "The fourth result is " << z << '\n';
//}
//#include <iostream>
//#include <stdio.h>  
//int firstTask(){
//    printf("First Task Method did work");
//    return 0;
//};
//
//int main() {
//    
//    
//    int y;
//    scanf("%d", &y); // note the &x!
//    printf("Your number was %d\n", y);
//    int* array = new int [50];
//    for (int i = 0; i < 10; i++){
//        
//    }
//        int x = 1;
//    if (x == 1) {
//        printf("Did this work");
//
//    } else {
//        std::cout << "Test02";
//    }
//
//
//    for (int i = 0; i < 4; i++) {
//        std::cout << "Hello Worlds!\n";
//    }
//}

