#!/usr/bin/perl
open(FILE, "<./duel_type.txt") or die "file not found";
my @lines = <FILE>;
close(FILE);

my @newlines;
foreach(@lines) {
   $_ =~ s/\t/:/g;
   $_ =~ s/" "/:/g;
   push(@newlines,$_);
}

open(NEW, ">./newtypes/newduel_type.txt") or die "File not found";
print NEW @newlines;
close(NEW);
