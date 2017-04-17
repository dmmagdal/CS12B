// sieve.c

#ifndef _SIEVE
#define _SIEVE
#include "Bv.h"

void sieve(bitV *){
	oneVec(v);	// Assume all are prime
	clrBit(v, 0);	// 0 is zero
	clrBit(v, 1);	// 1 is unity
	setBit(v, 2); 	// 2 is prime
	for (uint32_t i = 2; i <= sqrtl(lenVec(v)); i += 1){
		if (valBit(v, i)){
			for (uint32_t k = 0; (k+i)*i <= lenVec(v); k += 1){
				clrBit(v, (k+i)*i);	// it's multiples are composite
			}
		}
	}
}

#endif