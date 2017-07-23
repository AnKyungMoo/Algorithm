#include <stdio.h>

int main(void)
{
	char str[111];

	while (gets(str))
	{
		printf("%s\n", str);
	}

	return 0;
}