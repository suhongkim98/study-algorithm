#include <iostream>
#include <vector>
using namespace std;
 //https://www.acmicpc.net/problem/10950
 
int solve(int a, int b) {
    return a+b;
}
int main(void)
{
    int size;
    vector<pair<int, int>> point;
    
    cin >> size;
    for(int i = 0 ; i < size ; i++) {
        int a,b;
        cin >> a >> b;
        point.push_back(make_pair(a,b));
    }
    for(int i = 0 ; i < size ; i++){
        cout << solve(point[i].first, point[i].second) << endl;
    }
    return 0;
}
