#include <stdio.h>

int main(void)
{
	int i, j, k, num;

	scanf("%d", &num);

	for (i = 0; i < num; ++i)
	{
		for (j = num-1; j > i; --j)
		{
			printf(" ");
		}
		for (k = 0; k <= j; ++k)
		{
			printf("*");
		}
		printf("\n");
	}

	return 0;
}