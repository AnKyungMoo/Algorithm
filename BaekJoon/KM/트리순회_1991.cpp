#include <iostream>

using namespace std;

char tree[27][2];

void preorder(char key)
{
	if (key == '.') return;

	printf("%c", key);
	preorder(tree[key - 'A'][0]);
	preorder(tree[key - 'A'][1]);
}

void inorder(char key)
{
	if (key == '.') return;

	inorder(tree[key - 'A'][0]);
	printf("%c", key);
	inorder(tree[key - 'A'][1]);
}

void postorder(char key)
{
	if (key == '.') return;

	postorder(tree[key - 'A'][0]);
	postorder(tree[key - 'A'][1]);
	printf("%c", key);
}

int main(void)
{
	int N;
	char key, left, right;

	fill_n(&tree[0][0], 27*2, '.');

	scanf("%d", &N);

	for (auto i = 0; i < N; ++i)
	{
		cin >> key >> left >> right;

		tree[key - 'A'][0] = left;
		tree[key - 'A'][1] = right;
	}

	preorder('A');
	printf("\n");
	inorder('A');
	printf("\n");
	postorder('A');
	printf("\n");

	return 0;
}