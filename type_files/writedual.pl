#!/usr/bin/perl
open(TYPE,"<./alltypes.txt") or die "couldn't open type";
open(DTYPE,"<./dual_types.txt") or die "couldn't open dual types";
open(POKE,"<./newpoke.txt") or die "couldn't open poke";
my @line = <TYPE>;
my @enil = <DTYPE>;
open(my $fh, '>', "dPoke.txt") or die "couldn't open new file";
while(<POKE>){
   ($h,$num,$name,$health,$attack,$defense,$SPattack,$SPdefense,$speed,$total,$avg)=split /:/;
   for (@enil) {
      if($_ =~ /$name/) {
         ($numb,$nameh,$type1,$type2)=split /:/;
         chomp $type2;
      }
   }
   print $fh "pokeMap.put(\"$name\", new Pokemon($num, \"$name\", $health, $attack, $defense, $SPattack, $SPdefense, $speed, Type.$type1, Type.$type2));\n";
}
close $fh;
