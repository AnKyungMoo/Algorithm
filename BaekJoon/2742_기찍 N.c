#include <stdio.h>

int main(void)
{
	int i, num;

	scanf("%d", &num);

	for (i = num; i >= 1 ; --i)
	{
		printf("%d\n", i);
	}
	return 0;
}