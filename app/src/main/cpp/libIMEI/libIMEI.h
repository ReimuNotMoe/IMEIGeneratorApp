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

#ifndef Reimu_libIMEI_OwO
#define Reimu_libIMEI_OwO

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <inttypes.h>

#include <sys/types.h>
#include <sys/stat.h>

extern int IMEI_Verify(uint64_t IMEI);
extern uint64_t IMEI_Generate_Random();

#endif /* Reimu_libIMEI_OwO */
