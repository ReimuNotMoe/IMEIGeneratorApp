/*
    libIMEI - Tiny IMEI generation and verification library

    This file is part of libIMEI.
    Copyright (C) 2016-2018  ReimuNotMoe <reimuhatesfdt@gmail.com>

    libIMEI is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    libIMEI is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with libIMEI.  If not, see <http://www.gnu.org/licenses/>.
*/

#include "libIMEI.h"

int main(int argc, char **argv) {
	if (argc < 2) {
		printf("Usage: imei_verify <IMEI number>\n");
		exit(2);
	}

	uint64_t imei = strtoull(argv[1], NULL, 10);

	int rc = IMEI_Verify(imei);
	printf("%015"PRIu64": %s\n", imei, rc ? "correct" : "wrong");

	return rc;
}