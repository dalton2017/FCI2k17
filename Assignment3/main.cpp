// FCI – Programming 1 – 2018 - Assignment 3
// Program Name: main.cpp (Assignment-3 Project-2)
// Last Modification Date: 03/27/2018
// Author1 and ID and Group: 20140334 G22
// Teaching Assistant: Dina Mohamed
// Purpose: Statistical Calculator

#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
#include <sstream>
#include <math.h>

using namespace std;

float** dataset;
int s;
int dimention;
int s1;
int dimention1;
double mean1,mean2,std1,std2,COV;
bool loaded = false;
int q1,q2,q3;
int Q1,Q2,Q3;

//Function to read data set from a file

void readDataset(string name){

    ifstream file;
    file.open(name);
    float word;
    file >> s;
    file >> dimention;
    dataset =  new float*[s];
    for(int i = 0; i < s; ++i){
            dataset[i] = new float[dimention];
    }

    for(int i = 0; i < s; i++){
        for(int j = 0; j < dimention; j++){
            file >> word;
            dataset[i][j] = word;
        }
    }
    file.close();
    loaded = true;
    q1=0.25*s;
    q2=0.5*s;
    q3=0.75*s;
    Q1 = (int)dataset[q1][0];
    Q2 = (int)dataset[q2][0];
    Q3 = (int)dataset[q3][0];
}

//Function to write datasets on a file ... also handles the over writing method

void WriteDataset(string name,int co,int di){

    ofstream file(name,ofstream::trunc);
    float word;
    s1 = co;
    dimention1 = di;
    file << s1 <<endl;
    for(int i = 0; i < s1; i++){
        for(int j = 0; j < dimention1; j++){
            if(dimention1!=1){
                if(j==0){
                    cout << "Enter the X value of point " << i+1 <<" : "<<endl;
                    cin >> word;
                    file << word;
                    file << " ";
                }else{
                    cout << "Enter the Y value of point " << i+1 <<" : "<<endl;
                    cin >> word;
                    file << word <<endl;
                }
            }else{
                cout << "Enter the value of the point " << i+1 <<" : "<<endl;
                cin >> word;
                file << word << endl;
            }

        }
    }
    file.close();
}

//Function Test to test the current data in the array dataset and test the read file functionality

void TEST(){
    if(dimention == 1){
        cout << left << setw(8);
        cout <<"X"<<endl;
    }else{
        cout << left << setw(8);
        cout <<"X";
        cout << left << setw(8);
        cout <<"Y"<<endl;
    }
    for(int i = 0; i < s; i++){
        for(int j = 0; j < dimention; j++){
            cout << left << setw(8) << dataset[i][j];
        }
        cout << endl;
    }
}

/// These are correlation coefficient`s functions

void calculateMean(){
    double sum1=0.0,sum2=0.0;
    for(int i=0;i<s;i++){
        for(int j=0;j<2;j++){
            if(j==0){
                sum1+=dataset[i][0];
            }else{
                sum2+=dataset[i][1];
            }
        }
    }
    mean1 = sum1/s;
    mean2 = sum2/s;
}

void calculateSTD(){
    double sum1 = 0.0,sum2=0.0;
    for(int i=0;i<s;i++){
        cout << "at itr : " << (i+1) <<endl;
        cout << "Mean1 : " << mean1 <<endl<< "Mean2 : " <<mean2<<endl;
        for(int j=0;j<2;j++){
            if(j==0){
                cout << "data of X : " <<dataset[i][0]<<endl;
                sum1+=pow(dataset[i][0]-mean1,2);
                cout << sum1 <<endl;
            }else{

                cout << "data of Y : " <<dataset[i][1]<<endl;
                sum2+=pow(dataset[i][1]-mean2,2);
                cout << sum2 <<endl;

            }
        }
    }
    double temp;
    temp = sum1/s;
    std1=sqrt(temp);
    temp = sum2/s;
    std2=sqrt(temp);
}

void calculateCOVariance(){
    double sum=0.0;
    for(int i=0;i<s;i++){
        for(int j=0;j<2;j++){
                sum+=(dataset[i][0]-mean1)*(dataset[i][1]-mean2);
        }
    }
    COV = sum/s;
}

double CorrelationCoefficent(){
    calculateMean();
    calculateSTD();
    calculateCOVariance();
    cout << "COV = " <<COV<<endl;
    cout << "std1 = " <<std2<<endl;
    cout << "std2 = " <<std1<<endl;
    double temp = std1*std2;
    return COV/temp/2;
}

int main()
{
    bool run = true;
    bool check1 = true;
    bool check2 = true;

    int choice1;


    while(run){

        check1 = check2 = true;

        while(check1){
            cout << "1) Enter a new data set" <<endl;
            cout << "2) Load a data set" <<endl;
            cout << "3) Display a data set" <<endl;
            cout << "4) Calculate the quartiles of the data set" <<endl;
            cout << "5) Calculate the Interquartile range" <<endl;
            cout << "6) Calculate the Correlation Coefficient of the data set" <<endl;
            cout << "7) EXIT" <<endl<<endl;
            cout << "Enter your choice : " <<endl;
            cin >> choice1;

            if(choice1<1 || choice1>7){
                cout << "INVAILID INPUT!!!" <<endl;
            }else{
                check1 = false;
            }
        }

        if(choice1 == 1){
            int co,di;
            string fname;
            cout << "1)Linear   2)Two-Dimensional" <<endl;
            cin >> di;
            cout << "Enter the data set size : " << endl;
            cin >> co;
            cout << "Enter the file name : " << endl;
            cin >> fname;
            WriteDataset(fname,co,di);
        }else if(choice1 == 2){
            cout << "Enter the data set name : " <<endl;
            string fname;
            cin >> fname;
            readDataset(fname);
            cout << "DONE!!!!" <<endl;
        }else if(choice1 == 3){
            cout << endl;
            TEST();
            cout << endl;
        }else if(choice1 == 4){
            if(loaded == true){
                cout << "Q1  = " << Q1 << endl << "Q2  = " << Q2 << endl << "Q3  = " << Q3 << endl;
            }else{
                cout << "YOU DIDN`T LOAD A DATA SET YET !!!"<<endl;
            }

        }else if(choice1 == 5){
            if(loaded == true){
                cout << "Q3 - Q1 = " << Q3-Q1 << endl;
            }else{
                cout << "YOU DIDN`T LOAD A DATA SET YET !!!"<<endl;
            }
        }else if(choice1 == 6){
            if(loaded==true){
                if(dimention == 2){
                    cout << "Correlation coefficient (r) = " <<CorrelationCoefficent()<<endl;
                }else{
                    cout << "Data set loaded is n`t 2 dimensional !!!" <<endl;
                }
            }else{
                cout << "YOU DIDN`T LOAD A DATA SET YET !!!"<<endl;
            }
        }else{
            run = false;
        }

    }
    return 0;
}
