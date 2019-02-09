#include <stdio.h>

int main(void)
{
	int i, num, ist, sum = 0;

	scanf("%d", &num);

	for (i = 0; i < num; ++i)
	{
		scanf("%1d", &ist);
		sum += ist;
	}

	printf("%d\n", sum);

	return 0;
}