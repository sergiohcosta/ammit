#include <stdio.h>
//corrige se A+B=C
void main(void){
	int a, b, c;
	scanf("%d %d %d", &a, &b, &c);
	if(a+b==c)
		printf("%d", 0);
	else
		printf("%d", 1);
	return;
}