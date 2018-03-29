#include <iostream>

using namespace std;

string Roman (int a){
    string ry = "";
    while(a>=1000){
        ry+="M";
        a-=1000;
    }
    while(a>=900){
        ry+="CM";
        a-=900;
    }
    while(a>=500){
        ry+="D";
        a-=500;
    }
    while(a>=400){
        ry+="CD";
        a-=400;
    }
    while(a>=100){
        ry+="C";
        a-=100;
    }
    while(a>=90){
        ry+="XC";
        a-=90;
    }
    while(a>=50){
        ry+="L";
        a-=50;
    }
    while(a>=40){
        ry+="XL";
        a-=40;
    }
    while(a>=10){
        ry+="X";
        a-=10;
    }
    while(a>=9){
        ry+="IX";
        a-=9;
    }
    while(a>=5){
        ry+="V";
        a-=5;
    }
    while(a>=4){
        ry+="IV";
        a-=4;
    }
    while(a>=1){
        ry+="I";
        a-=1;
    }
    return ry;
}


int main()
{
    bool finish = false;
    bool check = false;
    int number;
    int choice;
    while(!finish){
        while(!check){
            cout << "1)Enter a year" << endl;
            cout << "2) Exit" << endl;
            cin >> choice;
            if(choice < 0 || choice > 2){
                cout << "INVALID INPUT!!!!" << endl;
            }else if(choice == 1){
                cout << "Enter a year (No less than 1000 and no more than 3000!!) : " << endl;
                cin >> number;
                cout << "The result is : " << Roman(number) << endl;
            }else{
                check = true;
                cout << "BYE!!" << endl;
            }
        }
        finish = true;
    }
    return 0;
}
