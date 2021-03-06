#!/usr/bin/perl
open(TYPE,"<./alltypes.txt") or die "couldn't open type";
open(DTYPE,"<./dual_types.txt") or die "couldn't open dual types";
open(POKE,"<./newpoke.txt") or die "couldn't open poke";
my @line = <TYPE>;
my @enil = <DTYPE>;
open(my $fh, '>', "Poke.txt") or die "couldn't open new file";
print $fh "static Map < String, Pokemon > pokeMap;\n";
while(<POKE>){
   ($h,$num,$name,$health,$attack,$defense,$SPattack,$SPdefense,$speed,$total,$avg)=split /:/;
   for (@line) {
      if($_ =~ /$name/) {
         ($numb,$nameh,$type)=split /:/;
         chomp $type;
      }
   }
   print $fh "pokeMap.put(\"$name\", new Pokemon($num, \"$name\", $health, $attack, $defense, $SPattack, $SPdefense, $speed, Type.$type));\n";
}
close $fh;
