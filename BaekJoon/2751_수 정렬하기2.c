#include <stdio.h>
#include <stdlib.h>

int compare(const void *, const void *);

int main(void)
{
	int arr[1000000];
	int i, num;
	
	do
	scanf("%d", &num);
	while (num < 1);

	for (i = 0; i < num; ++i)
	{
		scanf("%d", &arr[i]);
	}

	qsort(arr, num, sizeof(int), compare);

	for (i = 0; i < num; ++i)
	{
		printf("%d\n", arr[i]);
	}

	return 0;
}

int compare(const void *arg1, const void *arg2)
{
	if (*(int *)arg1 > *(int *)arg2)
	{
		return 1;
	}
	else if (*(int *)arg1 < *(int *)arg2)
	{
		return -1;
	}
	else
		return 0;
}