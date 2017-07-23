#include <stdio.h>

int main(void)
{
	int i, j, k, l, num;

	scanf("%d", &num);

	for (i = 0; i < num; ++i)
	{
		for (j = 0; j <= i; ++j)
		{
			printf("*");
		}

		for (k = 0; k < (num - i - 1) * 2; ++k)
		{
			printf(" ");
		}

		for (l = 0; l <= i; ++l)
		{
			printf("*");
		}
		printf("\n");
	}

	for (i = num - 1; i > 0; --i)
	{
		for (j = 0; j < i; ++j)
		{
			printf("*");
		}

		for (k = 0; k < (num - i) * 2; ++k)
		{
			printf(" ");
		}

		for (l = 0; l < i; ++l)
		{
			printf("*");
		}
		printf("\n");
	}
	return 0;
}