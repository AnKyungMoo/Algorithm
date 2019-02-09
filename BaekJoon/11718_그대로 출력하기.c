#include <stdio.h>

int main(void)
{
	char s[111];

	while (scanf("%[^\n]\n", s) == 1)
	{
		printf("%s\n", s);
	}

	return 0;
}