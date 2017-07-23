#include <stdio.h>
#define DAYNUM 12

int main(void)
{
	int month[DAYNUM] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	int mon, day, i;
	int total_day = 0;
	int sum_day = 0;
	int result;

	for (i = 0; i < DAYNUM; ++i)
	{
		total_day = month[i];
	}

	scanf("%d %d", &mon, &day);

	for (i = 0; i < mon-1; ++i)
	{
		sum_day += month[i];
	}

	sum_day += day;

	result = sum_day % 7;

	switch (result)
	{
	case 0:
		printf("SUN\n");
		break;
	case 1:
		printf("MON\n");
		break;
	case 2:
		printf("TUE\n");
		break;
	case 3:
		printf("WED\n");
		break;
	case 4:
		printf("THU\n");
		break;
	case 5:
		printf("FRI\n");
		break;
	case 6:
		printf("SAT\n");
		break;
	}

	return 0;
}