#include <stdio.h>

int main(void)
{
	int i, num;

	do
	{
		scanf("%d", &num);
	} while (num < 1 || num > 9);

	for (i = 1; i <= 9; ++i)
	{
		printf("%d * %d = %d\n", num, i, num * i);
	}

	return 0;
}