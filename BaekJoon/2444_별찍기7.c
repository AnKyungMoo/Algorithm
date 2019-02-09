#include <stdio.h>

int main(void)
{
	int i, j, k, l = 0, num;

	scanf("%d", &num);

	for (i = 0; i < num; ++i)
	{
		for (j = 0; j < num - i - 1; ++j)
		{
			printf(" ");
		}

		for (k = 0; k <= i + l; ++k)
		{
			printf("*");
		}
		l++;
		printf("\n");
	}

	l--;

	for (i = num - 1; i > 0; --i)
	{
		for (j = 0; j < num - i; ++j)
		{
			printf(" ");
		}

		l--;

		for (k = 0; k < i + l; ++k)
		{
			printf("*");
		}
		
		printf("\n");
	}

	return 0;
}