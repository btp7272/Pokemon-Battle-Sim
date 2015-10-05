#!/usr/bin/perl
open(POKE,"<./newtypes/newbug.txt") or die "couldn't open type";
open(my $fh, '>>', "alltypes.txt") or die "couldn't open new file";
while(<POKE>){
   ($num,$h,$name)=split /:/;
   print $fh "$num:$name:BUG"; 
}
close $fh;
