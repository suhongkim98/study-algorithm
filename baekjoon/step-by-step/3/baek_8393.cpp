#include <iostream>
using namespace std;
 //https://www.acmicpc.net/problem/8393
 
int main(void)
{
    int size, sum = 0;
    
    cin >> size;
    for(int i = 1 ; i <= size ; i++) {
        sum += i;
    }
    cout << sum;
    return 0;
}
