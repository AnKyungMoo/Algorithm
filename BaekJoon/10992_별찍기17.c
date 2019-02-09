#include <stdio.h>

int main(void)
{
	int i, j, k, num;

	scanf("%d", &num);

	for (i = 0; i < num; ++i)
	{
		for (j = 0; j < num - i - 1; ++j)
		{
			printf(" ");
		}

		if (i == num - 1)
		{
			for (k = 0; k <= i * 2; ++k)
			{
					printf("*");
			}
		}
		else
		{
			for (k = 0; k <= i * 2; ++k)
			{
				if (k == 0 || k == i * 2)
					printf("*");
				else
					printf(" ");
			}
		}
		printf("\n");
	}

	return 0;
}