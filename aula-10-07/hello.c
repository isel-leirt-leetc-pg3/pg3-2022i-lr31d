#include <stdio.h>

int main(int argc, char *argv[]) {
	
	printf("Hello, World!\n");
	
	for(int i=0; i < argc; ++i) {
		printf("arg[%d]='%s'\n", i, argv[i] );
	}
	return 0;
}