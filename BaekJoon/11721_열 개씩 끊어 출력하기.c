#include <stdio.h>
#include <string.h>

int main(void)
{
	int i = 0;
	char str[111];

	scanf("%s", str);

	while (i < strlen(str))
	{
		printf("%c", str[i++]);
		if (i % 10 == 0)
			printf("\n");
	}

	return 0;
}