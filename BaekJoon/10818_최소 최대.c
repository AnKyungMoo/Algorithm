#include <stdio.h>

int main(void)
{
	int i, num, ist, max = -1000000, min = 1000000;

	scanf("%d", &num);

	for (i = 0; i < num; ++i)
	{
		scanf("%d", &ist);
		if (ist > max)
			max = ist;
		if (ist < min)
			min = ist;
	}

	printf("%d %d\n", min, max);
	return 0;
}