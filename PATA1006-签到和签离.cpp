/**
1006 Sign In and Sign Out (25)（25 分）提问
At the beginning of every day, the first person who signs in the computer room will unlock the door, and the last one who signs out will lock the door. Given the records of signing in's and out's, you are supposed to find the ones who have unlocked and locked the door on that day.

Input Specification:

Each input file contains one test case. Each case contains the records for one day. The case starts with a positive integer M, which is the total number of records, followed by M lines, each in the format:

ID_number Sign_in_time Sign_out_time
where times are given in the format HH:MM:SS, and ID number is a string with no more than 15 characters.

Output Specification:

For each test case, output in one line the ID numbers of the persons who have unlocked and locked the door on that day. The two ID numbers must be separated by one space.

Note: It is guaranteed that the records are consistent. That is, the sign in time must be earlier than the sign out time for each person, and there are no two persons sign in or out at the same moment.

Sample Input:

3
CS301111 15:30:28 17:00:10
SC3021234 08:00:00 11:25:25
CS301133 21:45:00 21:58:40
Sample Output:
//找出最早来的和最晚走的
SC3021234 CS301133
**/
#include<stdio.h>
#include<iostream>
using namespace std;
struct person{
    int hour,minute,second;
    string name;
}input,earlier,later;

//a大于b返回true a小于等于b返回false
bool compare(person a,person b){
    if(a.hour!=b.hour){
        return a.hour>b.hour;
    }else if(a.minute!=b.minute){
        return a.minute>b.minute;
    }else{
        return a.second>b.second;
    }
}

void init(){
    earlier.hour = 23;
    earlier.minute = 59;
    earlier.second = 59;
    later.hour = 0;
    later.minute = 0;
    later.second = 0;
}

int main(){
    int N;
    cin>>N;
    init();
    while(N--){
        cin>>input.name;
        scanf("%d:%d:%d",&input.hour,&input.minute,&input.second);
        if(compare(input,earlier)==false){
            //input<=earlier
            earlier = input;
        }

        scanf("%d:%d:%d",&input.hour,&input.minute,&input.second);
        if(compare(input,later)==true){
            //input>later
            later = input;
        }
    }
    cout<<earlier.name<<" "<<later.name<<endl;
    return 0;
}
