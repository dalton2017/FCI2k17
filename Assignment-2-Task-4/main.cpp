#include <iostream>

using namespace std;

double BMR_MALE(double weight,double height,int age){
    double bmr = 655 + (4.3 * weight)+(4.7 * height)-(4.7 * age);
    return bmr;
}

double BMR_FEMALE(double weight,double height,int age){
    double bmr =  66 + (6.3 * weight)+(12.9 * height)-(6.8 * age);
    return bmr;
}

double NumberOfChocolateBars(double bmr){
    double numogchoc = bmr/230;
    return numogchoc;
}

int main()
{
    double weight;
    double height;
    int age;
    string gender;
    bool check = false;
    cout << "Enter your weight in bounds : " << endl;
    cin >> weight;
    cout << "Enter your height in inches : " << endl;
    cin >> height;
    cout << "Enter your age in years : " << endl;
    cin >> age;
    while(!check){
        cout << "Enter your gender (M for male and F for female) : " << endl;
        cin >> gender;
        if(gender=="M"){
            cout << "Number of chocolate bars that should be consumed to maintain weight = " << NumberOfChocolateBars(BMR_MALE(weight,height,age)) << "Bar" << endl;
            check = true;
        }else if(gender == "F"){
            cout << "Number of chocolate bars that should be consumed to maintain weight = " << NumberOfChocolateBars(BMR_FEMALE(weight,height,age)) << "Bar" << endl;
            check = true;
        }else{
            cout << "INVALID INPUT PLEASE TRY AGAIN!!!" << endl;
        }
    }

    return 0;
}
