#include <bits/stdc++.h>
using namespace std;
vector<int> used(10101);
vector<int> cycle;
int finded = -1;
vector<int> g[10101];
void FindCycle(int u, int p) {

	if (used[u] == 1) {
		finded = u;
		cycle.push_back(u);
		return;
	}

	used[u] = 1;
	for (auto i : g[u]) {
		if (i == p) 
			continue;
		FindCycle(i, u);

		if (finded == -2) 
			return;
		
		if (finded == u) {
			finded = -2;
			return;
		}
		
		if (finded >= 0) {
			cycle.push_back(u);
			return;
		}
	}

}

bool solve() {
	for (int i = 0; i < 10101; ++i)
		g[i].clear();
	cycle.clear(); used.clear();
	finded = -1;
	int n; scanf("%d", &n);
	for (int i = 0; i < n; ++i) {
		int a, b; scanf("%d %d", &a, &b);
		g[a].push_back(b);
		g[b].push_back(a);
	}
	FindCycle(1, 1);
	printf("%d\n", cycle.size());
	sort(cycle.begin(), cycle.end());
	for (auto i : cycle)
		printf("%d ", i);
	return 1;
}

int main() {
	solve();
}