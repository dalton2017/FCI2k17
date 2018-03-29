#include <iostream>
#include <fstream>
#include <string>
#include <sstream>

using namespace std;

string** baconianCipher;

void intializerBaconianCipher(){
    baconianCipher =  new string*[52];
    for(int i = 0; i < 52; ++i){
            baconianCipher[i] = new string[2];
    }
    ifstream file;
    file.open("BacCip.txt");
    string word;
    for(int i = 0; i < 52; i++){
        for(int j = 0; j < 2; j++){
            file >> word;
            baconianCipher[i][j] = word;
        }
    }
    file.close();
}

void TEST(){
    for(int i = 0; i < 52; i++){
        for(int j = 0; j < 2; j++){
            cout << baconianCipher[i][j]+" ";
        }
        cout << endl;
    }
}

string cipher(string word){
    string converted="";
    for(int i = 0;i < word.length();i++){
        for(int j = 0;j < 52;j++){
            if(string(1,word[i]) == " "){
                converted+="0";
                converted+=" ";
                //cout << "???";
                break;
            }
            else if(string(1,word[i])==baconianCipher[j][0]){
                converted+=baconianCipher[j][1];
                converted+=" ";
                break;
            }
        }
    }
    return converted;
}

string decipher(string word){
    string converted="";
    stringstream iss(word);
    while(iss.good())
    {
        string s;
        getline(iss,s,' ');
        for(int j = 0;j < 52;j++){
            if(s == "0"){
                converted+=" ";
                break;
            }
            else if(s==baconianCipher[j][1]){
                converted+=baconianCipher[j][0];
                break;
            }
        }
    }
    if(converted == ""){
        return "Invalid code";
    }else{
        return converted;
    }

}

int main()
{
    intializerBaconianCipher();
    //TEST();
    cout << "Welcome To Baconian Cipher" << endl;
    bool run = true;
    bool check1 = true;
    bool check2 = true;
    int choice;
    int choice2;
    string word;
    string word2;
    string convertedTemp;
    while(run){
        check1 = true;
        check2 = true;
        cout << "1) Cipher a word." << endl;
        cout << "2) Decipher a word." << endl;
        cout << "3) EXIT." << endl;
        while(check1){
            cout << "Enter the choice : ";
            cin >> choice;
            if(choice<1 || choice>3){
                cout << "WRONG INPUT PLEASE ENTER A VALID INPUT!!!" <<endl;
            }else{
                check1 = false;
            }
        }
        if(choice == 1){
            cout << "Enter the phrase : ";
            getline(cin,word);
            getline(cin,word);
            convertedTemp = cipher(word);
            cout << "Cipher Result is : " + convertedTemp << endl;
        }else if(choice == 2){
            cout << "1) Decipher the last word ciphered." << endl;
            cout << "2) Decipher another word." << endl;
            while(check2){
                cout << "Enter the choice : ";
                cin >> choice2;
                if(choice2<1 || choice2>2){
                    cout << "WRONG INPUT PLEASE ENTER A VALID INPUT!!!"<<endl;
                }else{
                    check2 = false;
                }
            }

            if(choice2 == 1){
                cout << "Decipher Result is : " + decipher(convertedTemp)<<endl;
            }else if(choice2 == 2){
                cout << "Enter the code : ";
                getline(cin,word2);
                getline(cin,word2);
                //getline(cin,word2);
                cout << "Decipher Result is : " + decipher(word2)<<endl;
            }
        }else{
            cout << "BYE!!!" << endl;
            run = false;
        }
    }
    return 0;
}
