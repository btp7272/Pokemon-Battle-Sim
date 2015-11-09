package SpeciesBattleSim.models;

import java.util.*;
import SpeciesBattleSim.types.Species;
import SpeciesBattleSim.types.Type;

public class SpeciesMap
{
	public static Map < String, Species > speciesMap = new HashMap<>();
	static
	{
		speciesMap.put("Bulbasaur", new Species(1, "Bulbasaur", 45, 49, 49, 65, 65, 45, Type.GRASS, Type.POISON
		speciesMap.put("Ivysaur", new Species(2, "Ivysaur", 60, 62, 63, 80, 80, 60, Type.GRASS, Type.POISON
		speciesMap.put("Venusaur", new Species(3, "Venusaur", 80, 82, 83, 100, 100, 80, Type.GRASS, Type.POISON
		speciesMap.put("Mega Venusaur", new Species(-3, "Mega Venusaur", 80, 100, 123, 122, 120, 80, Type.GRASS, Type.POISON
		speciesMap.put("Charmander", new Species(4, "Charmander", 39, 52, 43, 60, 50, 65, Type.FIRE
		speciesMap.put("Charmeleon", new Species(5, "Charmeleon", 58, 64, 58, 80, 65, 80, Type.FIRE
		speciesMap.put("Charizard", new Species(6, "Charizard", 78, 84, 78, 109, 85, 100, Type.FIRE, Type.FLYING
		speciesMap.put("Mega Charizard X", new Species(-6.1, "Mega Charizard X", 78, 130, 111, 130, 85, 100, Type.FIRE, Type.DRAGON
		speciesMap.put("Mega Charizard Y", new Species(-6.2, "Mega Charizard Y", 78, 104, 78, 159, 115, 100, Type.FIRE, Type.FLYING
		speciesMap.put("Squirtle", new Species(7, "Squirtle", 44, 48, 65, 50, 64, 43, Type.WATER
		speciesMap.put("Wartortle", new Species(8, "Wartortle", 59, 63, 80, 65, 80, 58, Type.WATER
		speciesMap.put("Blastoise", new Species(9, "Blastoise", 79, 83, 100, 85, 105, 78, Type.WATER
		speciesMap.put("Mega Blastoise", new Species(-9, "Mega Blastoise", 79, 103, 120, 135, 115, 78, Type.WATER
		speciesMap.put("Caterpie", new Species(10, "Caterpie", 45, 30, 35, 20, 20, 45, Type.BUG
		speciesMap.put("Metapod", new Species(11, "Metapod", 50, 20, 55, 25, 25, 30, Type.BUG
		speciesMap.put("Butterfree", new Species(12, "Butterfree", 60, 45, 50, 90, 80, 70, Type.BUG, Type.FLYING
		speciesMap.put("Weedle", new Species(13, "Weedle", 40, 35, 30, 20, 20, 50, Type.BUG, Type.POISON
		speciesMap.put("Kakuna", new Species(14, "Kakuna", 45, 25, 50, 25, 25, 35, Type.BUG, Type.POISON
		speciesMap.put("Beedrill", new Species(15, "Beedrill", 65, 90, 40, 45, 80, 75, Type.BUG, Type.POISON
		speciesMap.put("Mega Beedrill", new Species(-15, "Mega Beedrill", 65, 150, 40, 15, 80, 145, Type.BUG, Type.POISON
		speciesMap.put("Pidgey", new Species(16, "Pidgey", 40, 45, 40, 35, 35, 56, Type.NORMAL, Type.FLYING
		speciesMap.put("Pidgeotto", new Species(17, "Pidgeotto", 63, 60, 55, 50, 50, 71, Type.NORMAL, Type.FLYING
		speciesMap.put("Pidgeot", new Species(18, "Pidgeot", 83, 80, 75, 70, 70, 101, Type.NORMAL, Type.FLYING
		speciesMap.put("Mega Pidgeot", new Species(-18, "Mega Pidgeot", 83, 80, 80, 135, 80, 121, Type.NORMAL, Type.FLYING
		speciesMap.put("Rattata", new Species(19, "Rattata", 30, 56, 35, 25, 35, 72, Type.NORMAL
		speciesMap.put("Raticate", new Species(20, "Raticate", 55, 81, 60, 50, 70, 97, Type.NORMAL
		speciesMap.put("Spearow", new Species(21, "Spearow", 40, 60, 30, 31, 31, 70, Type.NORMAL
		speciesMap.put("Fearow", new Species(22, "Fearow", 65, 90, 65, 61, 61, 100, Type.NORMAL
		speciesMap.put("Ekans", new Species(23, "Ekans", 35, 60, 44, 40, 54, 55, Type.POISON
		speciesMap.put("Arbok", new Species(24, "Arbok", 60, 85, 69, 65, 79, 80, Type.POISON
		speciesMap.put("Pikachu", new Species(25, "Pikachu", 35, 55, 40, 50, 50, 90, Type.ELECTRIC
		speciesMap.put("Raichu", new Species(26, "Raichu", 60, 90, 55, 90, 80, 110, Type.ELECTRIC
		speciesMap.put("Sandshrew", new Species(27, "Sandshrew", 50, 75, 85, 20, 30, 40, Type.GROUND
		speciesMap.put("Sandslash", new Species(28, "Sandslash", 75, 100, 110, 45, 55, 65, Type.GROUND
		speciesMap.put("Nidorana", new Species(29, "Nidoran♀", 55, 47, 52, 40, 40, 41, Type.GROUND
		speciesMap.put("Nidorina", new Species(30, "Nidorina", 70, 62, 67, 55, 55, 56, Type.POISON
		speciesMap.put("Nidoqueen", new Species(31, "Nidoqueen", 90, 92, 87, 75, 85, 76, Type.GROUND, Type.POISON
		speciesMap.put("Nidorana", new Species(32, "Nidoran♂", 46, 57, 40, 40, 40, 50, Type.POISON
		speciesMap.put("Nidorino", new Species(33, "Nidorino", 61, 72, 57, 55, 55, 65, Type.POISON
		speciesMap.put("Nidoking", new Species(34, "Nidoking", 81, 102, 77, 85, 75, 85, Type.GROUND, Type.POISON
		speciesMap.put("Clefairy", new Species(35, "Clefairy", 70, 45, 48, 60, 65, 35, Type.FAIRY
		speciesMap.put("Clefable", new Species(36, "Clefable", 95, 70, 73, 95, 90, 60, Type.FAIRY
		speciesMap.put("Vulpix", new Species(37, "Vulpix", 38, 41, 40, 50, 65, 65, Type.FIRE
		speciesMap.put("Ninetales", new Species(38, "Ninetales", 73, 76, 75, 81, 100, 100, Type.FIRE
		speciesMap.put("Jigglypuff", new Species(39, "Jigglypuff", 115, 45, 20, 45, 25, 20, Type.NORMAL, Type.FAIRY
		speciesMap.put("Wigglytuff", new Species(40, "Wigglytuff", 140, 70, 45, 85, 50, 45, Type.NORMAL, Type.FAIRY
		speciesMap.put("Zubat", new Species(41, "Zubat", 40, 45, 35, 30, 40, 55, Type.POISON, Type.FLYING
		speciesMap.put("Golbat", new Species(42, "Golbat", 75, 80, 70, 65, 75, 90, Type.POISON, Type.FLYING
		speciesMap.put("Oddish", new Species(43, "Oddish", 45, 50, 55, 75, 65, 30, Type.GRASS, Type.POISON
		speciesMap.put("Gloom", new Species(44, "Gloom", 60, 65, 70, 85, 75, 40, Type.GRASS, Type.POISON
		speciesMap.put("Vileplume", new Species(45, "Vileplume", 75, 80, 85, 110, 90, 50, Type.GRASS, Type.POISON
		speciesMap.put("Paras", new Species(46, "Paras", 35, 70, 55, 45, 55, 25, Type.BUG, Type.GRASS
		speciesMap.put("Parasect", new Species(47, "Parasect", 60, 95, 80, 60, 80, 30, Type.BUG, Type.GRASS
		speciesMap.put("Venonat", new Species(48, "Venonat", 60, 55, 50, 40, 55, 45, Type.BUG, Type.POISON
		speciesMap.put("Venomoth", new Species(49, "Venomoth", 70, 65, 60, 90, 75, 90, Type.BUG, Type.POISON
		speciesMap.put("Diglett", new Species(50, "Diglett", 10, 55, 25, 35, 45, 95, Type.GROUND
		speciesMap.put("Dugtrio", new Species(51, "Dugtrio", 35, 80, 50, 50, 70, 120, Type.GROUND
		speciesMap.put("Meowth", new Species(52, "Meowth", 40, 45, 35, 40, 40, 90, Type.NORMAL
		speciesMap.put("Persian", new Species(53, "Persian", 65, 70, 60, 65, 65, 115, Type.NORMAL
		speciesMap.put("Psyduck", new Species(54, "Psyduck", 50, 52, 48, 65, 50, 55, Type.WATER
		speciesMap.put("Golduck", new Species(55, "Golduck", 80, 82, 78, 95, 80, 85, Type.WATER
		speciesMap.put("Mankey", new Species(56, "Mankey", 40, 80, 35, 35, 45, 70, Type.FIGHTING
		speciesMap.put("Primeape", new Species(57, "Primeape", 65, 105, 60, 60, 70, 95, Type.FIGHTING
		speciesMap.put("Growlithe", new Species(58, "Growlithe", 55, 70, 45, 70, 50, 60, Type.FIRE
		speciesMap.put("Arcanine", new Species(59, "Arcanine", 90, 110, 80, 100, 80, 95, Type.FIRE
		speciesMap.put("Poliwag", new Species(60, "Poliwag", 40, 50, 40, 40, 40, 90, Type.WATER
		speciesMap.put("Poliwhirl", new Species(61, "Poliwhirl", 65, 65, 65, 50, 50, 90, Type.WATER
		speciesMap.put("Poliwrath", new Species(62, "Poliwrath", 90, 95, 95, 70, 90, 70, Type.WATER, Type.FIGHTING
		speciesMap.put("Abra", new Species(63, "Abra", 25, 20, 15, 105, 55, 90, Type.PSYCHIC
		speciesMap.put("Kadabra", new Species(64, "Kadabra", 40, 35, 30, 120, 70, 105, Type.PSYCHIC
		speciesMap.put("Alakazam", new Species(65, "Alakazam", 55, 50, 45, 135, 95, 120, Type.PSYCHIC
		speciesMap.put("Mega Alakazam", new Species(-65, "Mega Alakazam", 55, 50, 65, 175, 95, 150, Type.PSYCHIC
		speciesMap.put("Machop", new Species(66, "Machop", 70, 80, 50, 35, 35, 35, Type.FIGHTING
		speciesMap.put("Machoke", new Species(67, "Machoke", 80, 100, 70, 50, 60, 45, Type.FIGHTING
		speciesMap.put("Machamp", new Species(68, "Machamp", 90, 130, 80, 65, 85, 55, Type.FIGHTING
		speciesMap.put("Bellsprout", new Species(69, "Bellsprout", 50, 75, 35, 70, 30, 40, Type.GRASS, Type.POISON
		speciesMap.put("Weepinbell", new Species(70, "Weepinbell", 65, 90, 50, 85, 45, 55, Type.GRASS, Type.POISON
		speciesMap.put("Victreebel", new Species(71, "Victreebel", 80, 105, 65, 100, 70, 70, Type.GRASS, Type.POISON
		speciesMap.put("Tentacool", new Species(72, "Tentacool", 40, 40, 35, 50, 100, 70, Type.WATER, Type.POISON
		speciesMap.put("Tentacruel", new Species(73, "Tentacruel", 80, 70, 65, 80, 120, 100, Type.WATER, Type.POISON
		speciesMap.put("Geodude", new Species(74, "Geodude", 40, 80, 100, 30, 30, 20, Type.ROCK, Type.GROUND
		speciesMap.put("Graveler", new Species(75, "Graveler", 55, 95, 115, 45, 45, 35, Type.ROCK, Type.GROUND
		speciesMap.put("Golem", new Species(76, "Golem", 80, 120, 130, 55, 65, 45, Type.ROCK, Type.GROUND
		speciesMap.put("Ponyta", new Species(77, "Ponyta", 50, 85, 55, 65, 65, 90, Type.FIRE
		speciesMap.put("Rapidash", new Species(78, "Rapidash", 65, 100, 70, 80, 80, 105, Type.FIRE
		speciesMap.put("Slowpoke", new Species(79, "Slowpoke", 90, 65, 65, 40, 40, 15, Type.WATER, Type.PSYCHIC
		speciesMap.put("Slowbro", new Species(80, "Slowbro", 95, 75, 110, 100, 80, 30, Type.WATER, Type.PSYCHIC
		speciesMap.put("Mega Slowbro", new Species(-80, "Mega Slowbro", 95, 75, 180, 130, 80, 30, Type.WATER, Type.PSYCHIC
		speciesMap.put("Magnemite", new Species(81, "Magnemite", 25, 35, 70, 95, 55, 45, Type.ELECTRIC, Type.STEEL
		speciesMap.put("Magneton", new Species(82, "Magneton", 50, 60, 95, 120, 70, 70, Type.ELECTRIC, Type.STEEL
		speciesMap.put("Farfetch'd", new Species(83, "Farfetch'd", 52, 65, 55, 58, 62, 60, Type.NORMAL, Type.FLYING
		speciesMap.put("Doduo", new Species(84, "Doduo", 35, 85, 45, 35, 35, 75, Type.NORMAL, Type.FLYING
		speciesMap.put("Dodrio", new Species(85, "Dodrio", 60, 110, 70, 60, 60, 100, Type.NORMAL, Type.FLYING
		speciesMap.put("Seel", new Species(86, "Seel", 65, 45, 55, 45, 70, 45, Type.WATER
		speciesMap.put("Dewgong", new Species(87, "Dewgong", 90, 70, 80, 70, 95, 70, Type.WATER, Type.ICE
		speciesMap.put("Grimer", new Species(88, "Grimer", 80, 80, 50, 40, 50, 25, Type.POISON
		speciesMap.put("Muk", new Species(89, "Muk", 105, 105, 75, 65, 100, 50, Type.POISON
		speciesMap.put("Shellder", new Species(90, "Shellder", 30, 65, 100, 45, 25, 40, Type.WATER
		speciesMap.put("Cloyster", new Species(91, "Cloyster", 50, 95, 180, 85, 45, 70, Type.WATER
		speciesMap.put("Gastly", new Species(92, "Gastly", 30, 35, 30, 100, 35, 80, Type.GHOST, Type.POISON
		speciesMap.put("Haunter", new Species(93, "Haunter", 45, 50, 45, 115, 55, 95, Type.GHOST, Type.POISON
		speciesMap.put("Gengar", new Species(94, "Gengar", 60, 65, 60, 130, 75, 110, Type.GHOST, Type.POISON
		speciesMap.put("Mega Gengar", new Species(-94, "Mega Gengar", 60, 65, 80, 170, 95, 130, Type.GHOST, Type.POISON
		speciesMap.put("Onix", new Species(95, "Onix", 35, 45, 160, 30, 45, 70, Type.ROCK, Type.GROUND
		speciesMap.put("Drowzee", new Species(96, "Drowzee", 60, 48, 45, 43, 90, 42, Type.PSYCHIC
		speciesMap.put("Hypno", new Species(97, "Hypno", 85, 73, 70, 73, 115, 67, Type.PSYCHIC
		speciesMap.put("Krabby", new Species(98, "Krabby", 30, 105, 90, 25, 25, 50, Type.WATER
		speciesMap.put("Kingler", new Species(99, "Kingler", 55, 130, 115, 50, 50, 75, Type.WATER
		speciesMap.put("Voltorb", new Species(100, "Voltorb", 40, 30, 50, 55, 55, 100, Type.ELECTRIC
		speciesMap.put("Electrode", new Species(101, "Electrode", 60, 50, 70, 80, 80, 140, Type.ELECTRIC
		speciesMap.put("Exeggcute", new Species(102, "Exeggcute", 60, 40, 80, 60, 45, 40, Type.GRASS, Type.PSYCHIC
		speciesMap.put("Exeggutor", new Species(103, "Exeggutor", 95, 95, 85, 125, 65, 55, Type.GRASS, Type.PSYCHIC
		speciesMap.put("Cubone", new Species(104, "Cubone", 50, 50, 95, 40, 50, 35, Type.GROUND
		speciesMap.put("Marowak", new Species(105, "Marowak", 60, 80, 110, 50, 80, 45, Type.GROUND
		speciesMap.put("Hitmonlee", new Species(106, "Hitmonlee", 50, 120, 53, 35, 110, 87, Type.FIGHTING
		speciesMap.put("Hitmonchan", new Species(107, "Hitmonchan", 50, 105, 79, 35, 110, 76, Type.FIGHTING
		speciesMap.put("Lickitung", new Species(108, "Lickitung", 90, 55, 75, 60, 75, 30, Type.NORMAL
		speciesMap.put("Koffing", new Species(109, "Koffing", 40, 65, 95, 60, 45, 35, Type.POISON
		speciesMap.put("Weezing", new Species(110, "Weezing", 65, 90, 120, 85, 70, 60, Type.POISON
		speciesMap.put("Rhyhorn", new Species(111, "Rhyhorn", 80, 85, 95, 30, 30, 25, Type.GROUND, Type.ROCK
		speciesMap.put("Rhydon", new Species(112, "Rhydon", 105, 130, 120, 45, 45, 40, Type.GROUND, Type.ROCK
		speciesMap.put("Chansey", new Species(113, "Chansey", 250, 5, 5, 35, 105, 50, Type.NORMAL
		speciesMap.put("Tangela", new Species(114, "Tangela", 65, 55, 115, 100, 40, 60, Type.GRASS
		speciesMap.put("Kangaskhan", new Species(115, "Kangaskhan", 105, 95, 80, 40, 80, 90, Type.NORMAL
		speciesMap.put("Mega Kangaskhan", new Species(-115, "Mega Kangaskhan", 105, 125, 100, 60, 100, 100, Type.NORMAL
		speciesMap.put("Horsea", new Species(116, "Horsea", 30, 40, 70, 70, 25, 60, Type.WATER
		speciesMap.put("Seadra", new Species(117, "Seadra", 55, 65, 95, 95, 45, 85, Type.WATER
		speciesMap.put("Goldeen", new Species(118, "Goldeen", 45, 67, 60, 35, 50, 63, Type.WATER
		speciesMap.put("Seaking", new Species(119, "Seaking", 80, 92, 65, 65, 80, 68, Type.WATER
		speciesMap.put("Staryu", new Species(120, "Staryu", 30, 45, 55, 70, 55, 85, Type.WATER
		speciesMap.put("Starmie", new Species(121, "Starmie", 60, 75, 85, 100, 85, 115, Type.WATER, Type.PSYCHIC
		speciesMap.put("Mr. Mime", new Species(122, "Mr. Mime", 40, 45, 65, 100, 120, 90, Type.PSYCHIC, Type.FAIRY
		speciesMap.put("Scyther", new Species(123, "Scyther", 70, 110, 80, 55, 80, 105, Type.BUG, Type.FLYING
		speciesMap.put("Jynx", new Species(124, "Jynx", 65, 50, 35, 115, 95, 95, Type.ICE, Type.PSYCHIC
		speciesMap.put("Electabuzz", new Species(125, "Electabuzz", 65, 83, 57, 95, 85, 105, Type.ELECTRIC
		speciesMap.put("Magmar", new Species(126, "Magmar", 65, 95, 57, 100, 85, 93, Type.FIRE
		speciesMap.put("Pinsir", new Species(127, "Pinsir", 65, 125, 100, 55, 70, 85, Type.BUG
		speciesMap.put("Mega Pinsir", new Species(-127, "Mega Pinsir", 65, 155, 120, 65, 90, 105, Type.BUG, Type.FLYING
		speciesMap.put("Tauros", new Species(128, "Tauros", 75, 100, 95, 40, 70, 110, Type.NORMAL
		speciesMap.put("Magikarp", new Species(129, "Magikarp", 20, 10, 55, 15, 20, 80, Type.WATER
		speciesMap.put("Gyarados", new Species(130, "Gyarados", 95, 125, 79, 60, 100, 81, Type.WATER, Type.FLYING
		speciesMap.put("Mega Gyarados", new Species(-130, "Mega Gyarados", 95, 155, 109, 70, 130, 81, Type.WATER, Type.DARK
		speciesMap.put("Lapras", new Species(131, "Lapras", 130, 85, 80, 85, 95, 60, Type.WATER, Type.ICE
		speciesMap.put("Ditto", new Species(132, "Ditto", 48, 48, 48, 48, 48, 48, Type.NORMAL
		speciesMap.put("Eevee", new Species(133, "Eevee", 55, 55, 50, 45, 65, 55, Type.NORMAL
		speciesMap.put("Vaporeon", new Species(134, "Vaporeon", 130, 65, 60, 110, 95, 65, Type.WATER
		speciesMap.put("Jolteon", new Species(135, "Jolteon", 65, 65, 60, 110, 95, 130, Type.ELECTRIC
		speciesMap.put("Flareon", new Species(136, "Flareon", 65, 130, 60, 95, 110, 65, Type.FIRE
		speciesMap.put("Porygon", new Species(137, "Porygon", 65, 60, 70, 85, 75, 40, Type.NORMAL
		speciesMap.put("Omanyte", new Species(138, "Omanyte", 35, 40, 100, 90, 55, 35, Type.ROCK, Type.WATER
		speciesMap.put("Omastar", new Species(139, "Omastar", 70, 60, 125, 115, 70, 55, Type.ROCK, Type.WATER
		speciesMap.put("Kabuto", new Species(140, "Kabuto", 30, 80, 90, 55, 45, 55, Type.ROCK, Type.WATER
		speciesMap.put("Kabutops", new Species(141, "Kabutops", 60, 115, 105, 65, 70, 80, Type.ROCK, Type.WATER
		speciesMap.put("Aerodactyl", new Species(142, "Aerodactyl", 80, 105, 65, 60, 75, 130, Type.ROCK, Type.FLYING
		speciesMap.put("Mega Aerodactyl", new Species(-142, "Mega Aerodactyl", 80, 135, 85, 70, 95, 150, Type.ROCK, Type.FLYING
		speciesMap.put("Snorlax", new Species(143, "Snorlax", 160, 110, 65, 65, 110, 30, Type.ROCK, Type.FLYING
		speciesMap.put("Articuno", new Species(144, "Articuno", 90, 85, 100, 95, 125, 85, Type.ICE, Type.FLYING
		speciesMap.put("Zapdos", new Species(145, "Zapdos", 90, 90, 85, 125, 90, 100, Type.ELECTRIC, Type.FLYING
		speciesMap.put("Moltres", new Species(146, "Moltres", 90, 100, 90, 125, 85, 90, Type.FIRE, Type.FLYING
		speciesMap.put("Dratini", new Species(147, "Dratini", 41, 64, 45, 50, 50, 50, Type.DRAGON
		speciesMap.put("Dragonair", new Species(148, "Dragonair", 61, 84, 65, 70, 70, 70, Type.DRAGON
		speciesMap.put("Dragonite", new Species(149, "Dragonite", 91, 134, 95, 100, 100, 80, Type.DRAGON, Type.FLYING
		speciesMap.put("Mewtwo", new Species(150, "Mewtwo", 106, 110, 90, 154, 90, 130, Type.PSYCHIC
		speciesMap.put("Mega Mewtwo X", new Species(-150.1, "Mega Mewtwo X", 106, 190, 100, 154, 100, 130, Type.PSYCHIC, Type.FIGHTING
		speciesMap.put("Mega Mewtwo Y", new Species(-150.2, "Mega Mewtwo Y", 106, 150, 70, 194, 120, 140, Type.PSYCHIC
		speciesMap.put("Mew", new Species(151, "Mew", 100, 100, 100, 100, 100, 100, Type.PSYCHIC
		speciesMap.put("Chikorita", new Species(152, "Chikorita", 45, 49, 65, 49, 65, 45, Type.GRASS
		speciesMap.put("Bayleef", new Species(153, "Bayleef", 60, 62, 80, 63, 80, 60, Type.GRASS
		speciesMap.put("Meganium", new Species(154, "Meganium", 80, 82, 100, 83, 100, 80, Type.GRASS
		speciesMap.put("Cyndaquil", new Species(155, "Cyndaquil", 39, 52, 43, 60, 50, 65, Type.FIRE
		speciesMap.put("Quilava", new Species(156, "Quilava", 58, 64, 58, 80, 65, 80, Type.FIRE
		speciesMap.put("Typhlosion", new Species(157, "Typhlosion", 78, 84, 78, 109, 85, 100, Type.FIRE
		speciesMap.put("Totodile", new Species(158, "Totodile", 50, 65, 64, 44, 48, 43, Type.WATER
		speciesMap.put("Croconaw", new Species(159, "Croconaw", 65, 80, 80, 59, 63, 58, Type.WATER
		speciesMap.put("Feraligatr", new Species(160, "Feraligatr", 85, 105, 100, 79, 83, 78, Type.WATER
		speciesMap.put("Sentret", new Species(161, "Sentret", 35, 46, 34, 35, 45, 20, Type.NORMAL
		speciesMap.put("Furret", new Species(162, "Furret", 85, 76, 64, 45, 55, 90, Type.NORMAL
		speciesMap.put("Hoothoot", new Species(163, "Hoothoot", 60, 30, 30, 36, 56, 50, Type.NORMAL, Type.FLYING
		speciesMap.put("Noctowl", new Species(164, "Noctowl", 100, 50, 50, 76, 96, 70, Type.NORMAL, Type.FLYING
		speciesMap.put("Ledyba", new Species(165, "Ledyba", 40, 20, 30, 40, 80, 55, Type.BUG, Type.FLYING
		speciesMap.put("Ledian", new Species(166, "Ledian", 55, 35, 50, 55, 110, 85, Type.BUG, Type.FLYING
		speciesMap.put("Spinarak", new Species(167, "Spinarak", 40, 60, 40, 40, 40, 30, Type.BUG, Type.POISON
		speciesMap.put("Ariados", new Species(168, "Ariados", 70, 90, 70, 60, 60, 40, Type.BUG, Type.POISON
		speciesMap.put("Crobat", new Species(169, "Crobat", 85, 90, 80, 70, 80, 130, Type.POISON, Type.FLYING
		speciesMap.put("Chinchou", new Species(170, "Chinchou", 75, 38, 38, 56, 56, 67, Type.WATER, Type.ELECTRIC
		speciesMap.put("Lanturn", new Species(171, "Lanturn", 125, 58, 58, 76, 76, 67, Type.WATER, Type.ELECTRIC
		speciesMap.put("Pichu", new Species(172, "Pichu", 20, 40, 15, 35, 35, 60, Type.ELECTRIC
		speciesMap.put("Cleffa", new Species(173, "Cleffa", 50, 25, 28, 45, 55, 15, Type.FAIRY
		speciesMap.put("Igglybuff", new Species(174, "Igglybuff", 90, 30, 15, 40, 20, 15, Type.NORMAL, Type.FAIRY
		speciesMap.put("Togepi", new Species(175, "Togepi", 35, 20, 65, 40, 65, 20, Type.FAIRY
		speciesMap.put("Togetic", new Species(176, "Togetic", 55, 40, 85, 80, 105, 40, Type.FAIRY, Type.FLYING
		speciesMap.put("Natu", new Species(177, "Natu", 40, 50, 45, 70, 45, 70, Type.PSYCHIC, Type.FLYING
		speciesMap.put("Xatu", new Species(178, "Xatu", 65, 75, 70, 95, 70, 95, Type.PSYCHIC, Type.FLYING
		speciesMap.put("Mareep", new Species(179, "Mareep", 55, 40, 40, 65, 45, 35, Type.ELECTRIC
		speciesMap.put("Flaaffy", new Species(180, "Flaaffy", 70, 55, 55, 80, 60, 45, Type.ELECTRIC
		speciesMap.put("Ampharos", new Species(181, "Ampharos", 90, 75, 85, 115, 90, 55, Type.ELECTRIC, Type.DRAGON
		speciesMap.put("Mega Ampharos", new Species(-181, "Mega Ampharos", 90, 95, 105, 165, 110, 45, Type.ELECTRIC, Type.DRAGON
		speciesMap.put("Bellossom", new Species(182, "Bellossom", 75, 80, 95, 90, 100, 50, Type.GRASS
		speciesMap.put("Marill", new Species(183, "Marill", 70, 20, 50, 20, 50, 40, Type.WATER, Type.FAIRY
		speciesMap.put("Azumarill", new Species(184, "Azumarill", 100, 50, 80, 60, 80, 50, Type.WATER, Type.FAIRY
		speciesMap.put("Sudowoodo", new Species(185, "Sudowoodo", 70, 100, 115, 30, 65, 30, Type.ROCK
		speciesMap.put("Politoed", new Species(186, "Politoed", 90, 75, 75, 90, 100, 70, Type.WATER
		speciesMap.put("Hoppip", new Species(187, "Hoppip", 35, 35, 40, 35, 55, 50, Type.GRASS, Type.FLYING
		speciesMap.put("Skiploom", new Species(188, "Skiploom", 55, 45, 50, 45, 65, 80, Type.GRASS, Type.FLYING
		speciesMap.put("Jumpluff", new Species(189, "Jumpluff", 75, 55, 70, 55, 95, 110, Type.GRASS, Type.FLYING
		speciesMap.put("Aipom", new Species(190, "Aipom", 55, 70, 55, 40, 55, 85, Type.NORMAL
		speciesMap.put("Sunkern", new Species(191, "Sunkern", 30, 30, 30, 30, 30, 30, Type.GRASS
		speciesMap.put("Sunflora", new Species(192, "Sunflora", 75, 75, 55, 105, 85, 30, Type.GRASS
		speciesMap.put("Yanma", new Species(193, "Yanma", 65, 65, 45, 75, 45, 95, Type.BUG, Type.FLYING
		speciesMap.put("Wooper", new Species(194, "Wooper", 55, 45, 45, 25, 25, 15, Type.WATER, Type.GROUND
		speciesMap.put("Quagsire", new Species(195, "Quagsire", 95, 85, 85, 65, 65, 35, Type.WATER, Type.GROUND
		speciesMap.put("Espeon", new Species(196, "Espeon", 65, 65, 60, 130, 95, 110, Type.PSYCHIC
		speciesMap.put("Umbreon", new Species(197, "Umbreon", 95, 65, 110, 60, 130, 65, Type.DARK
		speciesMap.put("Murkrow", new Species(198, "Murkrow", 60, 85, 42, 85, 42, 91, Type.DARK, Type.FLYING
		speciesMap.put("Slowking", new Species(199, "Slowking", 95, 75, 80, 100, 110, 30, Type.WATER, Type.PSYCHIC
		speciesMap.put("Misdreavus", new Species(200, "Misdreavus", 60, 60, 60, 85, 85, 85, Type.GHOST
		speciesMap.put("Unown", new Species(201, "Unown", 48, 72, 48, 72, 48, 48, Type.PSYCHIC
		speciesMap.put("Wobbuffet", new Species(202, "Wobbuffet", 190, 33, 58, 33, 58, 33, Type.PSYCHIC
		speciesMap.put("Girafarig", new Species(203, "Girafarig", 70, 80, 65, 90, 65, 85, Type.NORMAL, Type.PSYCHIC
		speciesMap.put("Pineco", new Species(204, "Pineco", 50, 65, 90, 35, 35, 15, Type.BUG
		speciesMap.put("Forretress", new Species(205, "Forretress", 75, 90, 140, 60, 60, 40, Type.BUG, Type.STEEL
		speciesMap.put("Dunsparce", new Species(206, "Dunsparce", 100, 70, 70, 65, 65, 45, Type.NORMAL
		speciesMap.put("Gligar", new Species(207, "Gligar", 65, 75, 105, 35, 65, 85, Type.GROUND, Type.FLYING
		speciesMap.put("Steelix", new Species(208, "Steelix", 75, 85, 200, 55, 65, 30, Type.STEEL, Type.GROUND
		speciesMap.put("Mega Steelix", new Species(-208, "Mega Steelix", 75, 125, 230, 55, 95, 30, Type.STEEL, Type.GROUND
		speciesMap.put("Snubbull", new Species(209, "Snubbull", 60, 80, 50, 40, 40, 30, Type.FAIRY
		speciesMap.put("Granbull", new Species(210, "Granbull", 90, 120, 75, 60, 60, 45, Type.FAIRY
		speciesMap.put("Qwilfish", new Species(211, "Qwilfish", 65, 95, 75, 55, 55, 85, Type.WATER, Type.POISON
		speciesMap.put("Scizor", new Species(212, "Scizor", 70, 130, 100, 55, 80, 65, Type.FAIRY
		speciesMap.put("Scizor", new Species(212, "Scizor", 70, 130, 100, 55, 80, 65, Type.BUG, Type.STEEL
		speciesMap.put("Mega Scizor", new Species(-212, "Mega Scizor", 70, 150, 140, 65, 100, 75, Type.BUG, Type.STEEL
		speciesMap.put("Shuckle", new Species(213, "Shuckle", 20, 10, 230, 10, 230, 5, Type.BUG, Type.ROCK
		speciesMap.put("Heracross", new Species(214, "Heracross", 80, 125, 75, 40, 95, 85, Type.BUG, Type.FIGHTING
		speciesMap.put("Mega Heracross", new Species(-214, "Mega Heracross", 80, 185, 115, 40, 105, 75, Type.BUG, Type.FIGHTING
		speciesMap.put("Sneasel", new Species(215, "Sneasel", 55, 95, 55, 35, 75, 115, Type.DARK, Type.ICE
		speciesMap.put("Teddiursa", new Species(216, "Teddiursa", 60, 80, 50, 50, 50, 40, Type.NORMAL
		speciesMap.put("Ursaring", new Species(217, "Ursaring", 90, 130, 75, 75, 75, 55, Type.NORMAL
		speciesMap.put("Slugma", new Species(218, "Slugma", 40, 40, 40, 70, 40, 20, Type.FIRE
		speciesMap.put("Magcargo", new Species(219, "Magcargo", 50, 50, 120, 80, 80, 30, Type.FIRE, Type.ROCK
		speciesMap.put("Swinub", new Species(220, "Swinub", 50, 50, 40, 30, 30, 50, Type.ICE, Type.GROUND
		speciesMap.put("Piloswine", new Species(221, "Piloswine", 100, 100, 80, 60, 60, 50, Type.ICE, Type.GROUND
		speciesMap.put("Corsola", new Species(222, "Corsola", 55, 55, 85, 65, 85, 35, Type.WATER, Type.ROCK
		speciesMap.put("Remoraid", new Species(223, "Remoraid", 35, 65, 35, 65, 35, 65, Type.WATER
		speciesMap.put("Octillery", new Species(224, "Octillery", 75, 105, 75, 105, 75, 45, Type.WATER
		speciesMap.put("Delibird", new Species(225, "Delibird", 45, 55, 45, 65, 45, 75, Type.ICE, Type.FLYING
		speciesMap.put("Mantine", new Species(226, "Mantine", 65, 40, 70, 80, 140, 70, Type.WATER, Type.FLYING
		speciesMap.put("Skarmory", new Species(227, "Skarmory", 65, 80, 140, 40, 70, 70, Type.STEEL, Type.FLYING
		speciesMap.put("Houndour", new Species(228, "Houndour", 45, 60, 30, 80, 50, 65, Type.DARK, Type.FIRE
		speciesMap.put("Houndoom", new Species(229, "Houndoom", 75, 90, 50, 110, 80, 95, Type.DARK, Type.FIRE
		speciesMap.put("Mega Houndoom", new Species(-229, "Mega Houndoom", 75, 90, 90, 140, 90, 115, Type.DARK, Type.FIRE
		speciesMap.put("Kingdra", new Species(230, "Kingdra", 75, 95, 95, 95, 95, 85, Type.WATER, Type.DRAGON
		speciesMap.put("Phanpy", new Species(231, "Phanpy", 90, 60, 60, 40, 40, 40, Type.GROUND
		speciesMap.put("Donphan", new Species(232, "Donphan", 90, 120, 120, 60, 60, 50, Type.GROUND
		speciesMap.put("Porygon2", new Species(233, "Porygon2", 85, 80, 90, 105, 95, 60, Type.NORMAL
		speciesMap.put("Stantler", new Species(234, "Stantler", 73, 95, 62, 85, 65, 85, Type.NORMAL
		speciesMap.put("Smeargle", new Species(235, "Smeargle", 55, 20, 35, 20, 45, 75, Type.NORMAL
		speciesMap.put("Tyrogue", new Species(236, "Tyrogue", 35, 35, 35, 35, 35, 35, Type.FIGHTING
		speciesMap.put("Hitmontop", new Species(237, "Hitmontop", 50, 95, 95, 35, 110, 70, Type.FIGHTING
		speciesMap.put("Smoochum", new Species(238, "Smoochum", 45, 30, 15, 85, 65, 65, Type.ICE, Type.PSYCHIC
		speciesMap.put("Elekid", new Species(239, "Elekid", 45, 63, 37, 65, 55, 95, Type.ELECTRIC
		speciesMap.put("Magby", new Species(240, "Magby", 45, 75, 37, 70, 55, 83, Type.FIRE
		speciesMap.put("Miltank", new Species(241, "Miltank", 95, 80, 105, 40, 70, 100, Type.NORMAL
		speciesMap.put("Blissey", new Species(242, "Blissey", 255, 10, 10, 75, 135, 55, Type.NORMAL
		speciesMap.put("Raikou", new Species(243, "Raikou", 90, 85, 75, 115, 100, 115, Type.ELECTRIC
		speciesMap.put("Entei", new Species(244, "Entei", 115, 115, 85, 90, 75, 100, Type.FIRE
		speciesMap.put("Suicune", new Species(245, "Suicune", 100, 75, 115, 90, 115, 85, Type.WATER
		speciesMap.put("Larvitar", new Species(246, "Larvitar", 50, 64, 50, 45, 50, 41, Type.ROCK, Type.GROUND
		speciesMap.put("Pupitar", new Species(247, "Pupitar", 70, 84, 70, 65, 70, 51, Type.ROCK, Type.GROUND
		speciesMap.put("Tyranitar", new Species(248, "Tyranitar", 100, 134, 110, 95, 100, 61, Type.ROCK, Type.DARK
		speciesMap.put("Mega Tyranitar", new Species(-248, "Mega Tyranitar", 100, 164, 150, 95, 120, 71, Type.ROCK, Type.DARK
		speciesMap.put("Lugia", new Species(249, "Lugia", 106, 90, 130, 90, 154, 110, Type.PSYCHIC, Type.FLYING
		speciesMap.put("Ho-Oh", new Species(250, "Ho-Oh", 106, 130, 90, 110, 154, 90, Type.FIRE, Type.FLYING
		speciesMap.put("Celebi", new Species(251, "Celebi", 100, 100, 100, 100, 100, 100, Type.PSYCHIC, Type.GRASS
		speciesMap.put("Treecko", new Species(252, "Treecko", 40, 45, 35, 65, 55, 70, Type.GRASS
		speciesMap.put("Grovyle", new Species(253, "Grovyle", 50, 65, 45, 85, 65, 95, Type.GRASS
		speciesMap.put("Sceptile", new Species(254, "Sceptile", 70, 85, 65, 105, 85, 120, Type.GRASS
		speciesMap.put("Mega Sceptile", new Species(-254, "Mega Sceptile", 70, 110, 75, 145, 85, 145, Type.GRASS, Type.DRAGON
		speciesMap.put("Torchic", new Species(255, "Torchic", 45, 60, 40, 70, 50, 45, Type.FIRE
		speciesMap.put("Combusken", new Species(256, "Combusken", 60, 85, 60, 85, 60, 55, Type.FIRE, Type.FIGHTING
		speciesMap.put("Blaziken", new Species(257, "Blaziken", 80, 120, 70, 110, 70, 80, Type.FIRE, Type.FIGHTING
		speciesMap.put("Mega Blaziken", new Species(-257, "Mega Blaziken", 80, 160, 80, 130, 80, 100, Type.FIRE, Type.FIGHTING
		speciesMap.put("Mudkip", new Species(258, "Mudkip", 50, 70, 50, 50, 50, 40, Type.WATER
		speciesMap.put("Marshtomp", new Species(259, "Marshtomp", 70, 85, 70, 60, 70, 50, Type.WATER, Type.GROUND
		speciesMap.put("Swampert", new Species(260, "Swampert", 100, 110, 90, 85, 90, 60, Type.WATER, Type.GROUND
		speciesMap.put("Mega Swampert", new Species(-260, "Mega Swampert", 100, 150, 110, 95, 110, 70, Type.WATER, Type.GROUND
		speciesMap.put("Poochyena", new Species(261, "Poochyena", 35, 55, 35, 30, 30, 35, Type.DARK
		speciesMap.put("Mightyena", new Species(262, "Mightyena", 70, 90, 70, 60, 60, 70, Type.DARK
		speciesMap.put("Zigzagoon", new Species(263, "Zigzagoon", 38, 30, 41, 30, 41, 60, Type.NORMAL
		speciesMap.put("Linoone", new Species(264, "Linoone", 78, 70, 61, 50, 61, 100, Type.NORMAL
		speciesMap.put("Wurmple", new Species(265, "Wurmple", 45, 45, 35, 20, 30, 20, Type.BUG
		speciesMap.put("Silcoon", new Species(266, "Silcoon", 50, 35, 55, 25, 25, 15, Type.BUG
		speciesMap.put("Beautifly", new Species(267, "Beautifly", 60, 70, 50, 100, 50, 65, Type.BUG, Type.FLYING
		speciesMap.put("Cascoon", new Species(268, "Cascoon", 50, 35, 55, 25, 25, 15, Type.BUG
		speciesMap.put("Dustox", new Species(269, "Dustox", 60, 50, 70, 50, 90, 65, Type.BUG, Type.POISON
		speciesMap.put("Lotad", new Species(270, "Lotad", 40, 30, 30, 40, 50, 30, Type.WATER, Type.GRASS
		speciesMap.put("Lombre", new Species(271, "Lombre", 60, 50, 50, 60, 70, 50, Type.WATER, Type.GRASS
		speciesMap.put("Ludicolo", new Species(272, "Ludicolo", 80, 70, 70, 90, 100, 70, Type.WATER, Type.GRASS
		speciesMap.put("Seedot", new Species(273, "Seedot", 40, 40, 50, 30, 30, 30, Type.GRASS
		speciesMap.put("Nuzleaf", new Species(274, "Nuzleaf", 70, 70, 40, 60, 40, 60, Type.GRASS, Type.DARK
		speciesMap.put("Shiftry", new Species(275, "Shiftry", 90, 100, 60, 90, 60, 80, Type.GRASS, Type.DARK
		speciesMap.put("Taillow", new Species(276, "Taillow", 40, 55, 30, 30, 30, 85, Type.NORMAL, Type.FLYING
		speciesMap.put("Swellow", new Species(277, "Swellow", 60, 85, 60, 50, 50, 125, Type.NORMAL, Type.FLYING
		speciesMap.put("Wingull", new Species(278, "Wingull", 40, 30, 30, 55, 30, 85, Type.WATER, Type.FLYING
		speciesMap.put("Pelipper", new Species(279, "Pelipper", 60, 50, 100, 85, 70, 65, Type.WATER, Type.FLYING
		speciesMap.put("Ralts", new Species(280, "Ralts", 28, 25, 25, 45, 35, 40, Type.PSYCHIC, Type.FAIRY
		speciesMap.put("Kirlia", new Species(281, "Kirlia", 38, 35, 35, 65, 55, 50, Type.PSYCHIC, Type.FAIRY
		speciesMap.put("Gardevoir", new Species(282, "Gardevoir", 68, 65, 65, 125, 115, 80, Type.PSYCHIC, Type.FAIRY
		speciesMap.put("Mega Gardevoir", new Species(-282, "Mega Gardevoir", 68, 85, 65, 165, 135, 100, Type.PSYCHIC, Type.FAIRY
		speciesMap.put("Surskit", new Species(283, "Surskit", 40, 30, 32, 50, 52, 65, Type.BUG, Type.WATER
		speciesMap.put("Masquerain", new Species(284, "Masquerain", 70, 60, 62, 80, 82, 60, Type.BUG, Type.FLYING
		speciesMap.put("Shroomish", new Species(285, "Shroomish", 60, 40, 60, 40, 60, 35, Type.GRASS
		speciesMap.put("Breloom", new Species(286, "Breloom", 60, 130, 80, 60, 60, 70, Type.GRASS, Type.FIGHTING
		speciesMap.put("Slakoth", new Species(287, "Slakoth", 60, 60, 60, 35, 35, 30, Type.NORMAL
		speciesMap.put("Vigoroth", new Species(288, "Vigoroth", 80, 80, 80, 55, 55, 90, Type.NORMAL
		speciesMap.put("Slaking", new Species(289, "Slaking", 150, 160, 100, 95, 65, 100, Type.NORMAL
		speciesMap.put("Nincada", new Species(290, "Nincada", 31, 45, 90, 30, 30, 40, Type.BUG, Type.GROUND
		speciesMap.put("Ninjask", new Species(291, "Ninjask", 61, 90, 45, 50, 50, 160, Type.BUG, Type.FLYING
		speciesMap.put("Shedinja", new Species(292, "Shedinja", 1, 90, 45, 30, 30, 40, Type.BUG, Type.GHOST
		speciesMap.put("Whismur", new Species(293, "Whismur", 64, 51, 23, 51, 23, 28, Type.NORMAL
		speciesMap.put("Loudred", new Species(294, "Loudred", 84, 71, 43, 71, 43, 48, Type.NORMAL
		speciesMap.put("Exploud", new Species(295, "Exploud", 104, 91, 63, 91, 73, 68, Type.NORMAL
		speciesMap.put("Makuhita", new Species(296, "Makuhita", 72, 60, 30, 20, 30, 25, Type.FIGHTING
		speciesMap.put("Hariyama", new Species(297, "Hariyama", 144, 120, 60, 40, 60, 50, Type.FIGHTING
		speciesMap.put("Azurill", new Species(298, "Azurill", 50, 20, 40, 20, 40, 20, Type.NORMAL, Type.FAIRY
		speciesMap.put("Nosepass", new Species(299, "Nosepass", 30, 45, 135, 45, 90, 30, Type.ROCK
		speciesMap.put("Skitty", new Species(300, "Skitty", 50, 45, 45, 35, 35, 50, Type.NORMAL
		speciesMap.put("Delcatty", new Species(301, "Delcatty", 70, 65, 65, 55, 55, 70, Type.NORMAL
		speciesMap.put("Sableye", new Species(302, "Sableye", 50, 75, 75, 65, 65, 50, Type.DARK, Type.GHOST
		speciesMap.put("Mega Sableye", new Species(-302, "Mega Sableye", 50, 85, 125, 85, 115, 20, Type.DARK, Type.GHOST
		speciesMap.put("Mawile", new Species(303, "Mawile", 50, 85, 85, 55, 55, 50, Type.STEEL, Type.FAIRY
		speciesMap.put("Mega Mawile", new Species(-303, "Mega Mawile", 50, 105, 125, 55, 95, 50, Type.STEEL, Type.FAIRY
		speciesMap.put("Aron", new Species(304, "Aron", 50, 70, 100, 40, 40, 30, Type.STEEL, Type.ROCK
		speciesMap.put("Lairon", new Species(305, "Lairon", 60, 90, 140, 50, 50, 40, Type.STEEL, Type.ROCK
		speciesMap.put("Aggron", new Species(306, "Aggron", 70, 110, 180, 60, 60, 50, Type.STEEL, Type.ROCK
		speciesMap.put("Mega Aggron", new Species(-306, "Mega Aggron", 70, 140, 230, 60, 80, 50, Type.STEEL
		speciesMap.put("Meditite", new Species(307, "Meditite", 30, 40, 55, 40, 55, 60, Type.FIGHTING, Type.PSYCHIC
		speciesMap.put("Medicham", new Species(308, "Medicham", 60, 60, 75, 60, 75, 80, Type.FIGHTING, Type.PSYCHIC
		speciesMap.put("Mega Medicham", new Species(-308, "Mega Medicham", 60, 100, 85, 80, 85, 100, Type.FIGHTING, Type.PSYCHIC
		speciesMap.put("Electrike", new Species(309, "Electrike", 40, 45, 40, 65, 40, 65, Type.ELECTRIC
		speciesMap.put("Manectric", new Species(310, "Manectric", 70, 75, 60, 105, 60, 105, Type.ELECTRIC
		speciesMap.put("Mega Manectric", new Species(-310, "Mega Manectric", 70, 75, 80, 135, 80, 135, Type.ELECTRIC
		speciesMap.put("Plusle", new Species(311, "Plusle", 60, 50, 40, 85, 75, 95, Type.ELECTRIC
		speciesMap.put("Minun", new Species(312, "Minun", 60, 40, 50, 75, 85, 95, Type.ELECTRIC
		speciesMap.put("Volbeat", new Species(313, "Volbeat", 65, 73, 55, 47, 75, 85, Type.BUG
		speciesMap.put("Illumise", new Species(314, "Illumise", 65, 47, 55, 73, 75, 85, Type.BUG
		speciesMap.put("Roselia", new Species(315, "Roselia", 50, 60, 45, 100, 80, 65, Type.GRASS, Type.POISON
		speciesMap.put("Gulpin", new Species(316, "Gulpin", 70, 43, 53, 43, 53, 40, Type.POISON
		speciesMap.put("Swalot", new Species(317, "Swalot", 100, 73, 83, 73, 83, 55, Type.POISON
		speciesMap.put("Carvanha", new Species(318, "Carvanha", 45, 90, 20, 65, 20, 65, Type.WATER, Type.DARK
		speciesMap.put("Sharpedo", new Species(319, "Sharpedo", 70, 120, 40, 95, 40, 95, Type.WATER, Type.DARK
		speciesMap.put("Mega Sharpedo", new Species(-319, "Mega Sharpedo", 70, 140, 70, 110, 65, 105, Type.WATER, Type.DARK
		speciesMap.put("Wailmer", new Species(320, "Wailmer", 130, 70, 35, 70, 35, 60, Type.WATER
		speciesMap.put("Wailord", new Species(321, "Wailord", 170, 90, 45, 90, 45, 60, Type.WATER
		speciesMap.put("Numel", new Species(322, "Numel", 60, 60, 40, 65, 45, 35, Type.FIRE, Type.GROUND
		speciesMap.put("Camerupt", new Species(323, "Camerupt", 70, 100, 70, 105, 75, 40, Type.FIRE, Type.GROUND
		speciesMap.put("Mega Camerupt", new Species(-323, "Mega Camerupt", 70, 120, 100, 145, 105, 20, Type.FIRE, Type.GROUND
		speciesMap.put("Torkoal", new Species(324, "Torkoal", 70, 85, 140, 85, 70, 20, Type.FIRE
		speciesMap.put("Spoink", new Species(325, "Spoink", 60, 25, 35, 70, 80, 60, Type.PSYCHIC
		speciesMap.put("Grumpig", new Species(326, "Grumpig", 80, 45, 65, 90, 110, 80, Type.PSYCHIC
		speciesMap.put("Spinda", new Species(327, "Spinda", 60, 60, 60, 60, 60, 60, Type.NORMAL
		speciesMap.put("Trapinch", new Species(328, "Trapinch", 45, 100, 45, 45, 45, 10, Type.GROUND
		speciesMap.put("Vibrava", new Species(329, "Vibrava", 50, 70, 50, 50, 50, 70, Type.GROUND, Type.DRAGON
		speciesMap.put("Flygon", new Species(330, "Flygon", 80, 100, 80, 80, 80, 100, Type.GROUND, Type.DRAGON
		speciesMap.put("Cacnea", new Species(331, "Cacnea", 50, 85, 40, 85, 40, 35, Type.GRASS
		speciesMap.put("Cacturne", new Species(332, "Cacturne", 70, 115, 60, 115, 60, 55, Type.GRASS, Type.DARK
		speciesMap.put("Swablu", new Species(333, "Swablu", 45, 40, 60, 40, 75, 50, Type.NORMAL, Type.FLYING
		speciesMap.put("Altaria", new Species(334, "Altaria", 75, 70, 90, 70, 105, 80, Type.DRAGON, Type.FLYING
		speciesMap.put("Mega Altaria", new Species(-334, "Mega Altaria", 75, 110, 110, 110, 105, 80, Type.DRAGON, Type.FAIRY
		speciesMap.put("Zangoose", new Species(335, "Zangoose", 73, 115, 60, 60, 60, 90, Type.NORMAL
		speciesMap.put("Seviper", new Species(336, "Seviper", 73, 100, 60, 100, 60, 65, Type.POISON
		speciesMap.put("Lunatone", new Species(337, "Lunatone", 70, 55, 65, 95, 85, 70, Type.ROCK, Type.PSYCHIC
		speciesMap.put("Solrock", new Species(338, "Solrock", 70, 95, 85, 55, 65, 70, Type.ROCK, Type.PSYCHIC
		speciesMap.put("Barboach", new Species(339, "Barboach", 50, 48, 43, 46, 41, 60, Type.WATER, Type.GROUND
		speciesMap.put("Whiscash", new Species(340, "Whiscash", 110, 78, 73, 76, 71, 60, Type.WATER, Type.GROUND
		speciesMap.put("Corphish", new Species(341, "Corphish", 43, 80, 65, 50, 35, 35, Type.WATER
		speciesMap.put("Crawdaunt", new Species(342, "Crawdaunt", 63, 120, 85, 90, 55, 55, Type.WATER, Type.DARK
		speciesMap.put("Baltoy", new Species(343, "Baltoy", 40, 40, 55, 40, 70, 55, Type.GROUND, Type.PSYCHIC
		speciesMap.put("Claydol", new Species(344, "Claydol", 60, 70, 105, 70, 120, 75, Type.GROUND, Type.PSYCHIC
		speciesMap.put("Lileep", new Species(345, "Lileep", 66, 41, 77, 61, 87, 23, Type.ROCK, Type.GRASS
		speciesMap.put("Cradily", new Species(346, "Cradily", 86, 81, 97, 81, 107, 43, Type.ROCK, Type.GRASS
		speciesMap.put("Anorith", new Species(347, "Anorith", 45, 95, 50, 40, 50, 75, Type.ROCK, Type.BUG
		speciesMap.put("Armaldo", new Species(348, "Armaldo", 75, 125, 100, 70, 80, 45, Type.ROCK, Type.BUG
		speciesMap.put("Feebas", new Species(349, "Feebas", 20, 15, 20, 10, 55, 80, Type.WATER
		speciesMap.put("Milotic", new Species(350, "Milotic", 95, 60, 79, 100, 125, 81, Type.WATER
		speciesMap.put("Castform", new Species(351.0, "Castform", 70, 70, 70, 70, 70, 70, Type.NORMAL
		speciesMap.put("Sunny Castform", new Species(351.1, "Sunny Castform", 70, 70, 70, 70, 70, 70, Type.FIRE
		speciesMap.put("Rainy Castform", new Species(351.2, "Rainy Castform", 70, 70, 70, 70, 70, 70, Type.WATER
		speciesMap.put("Snowy Castform", new Species(351.3, "Snowy Castform", 70, 70, 70, 70, 70, 70, Type.ICE
		speciesMap.put("Kecleon", new Species(352, "Kecleon", 60, 90, 70, 60, 120, 40, Type.NORMAL
		speciesMap.put("Shuppet", new Species(353, "Shuppet", 44, 75, 35, 63, 33, 45, Type.GHOST
		speciesMap.put("Banette", new Species(354, "Banette", 64, 115, 65, 83, 63, 65, Type.GHOST
		speciesMap.put("Mega Banette", new Species(-354, "Mega Banette", 64, 165, 75, 93, 83, 75, Type.GHOST
		speciesMap.put("Duskull", new Species(355, "Duskull", 20, 40, 90, 30, 90, 25, Type.GHOST
		speciesMap.put("Dusclops", new Species(356, "Dusclops", 40, 70, 130, 60, 130, 25, Type.GHOST
		speciesMap.put("Tropius", new Species(357, "Tropius", 99, 68, 83, 72, 87, 51, Type.GRASS, Type.FLYING
		speciesMap.put("Chimecho", new Species(358, "Chimecho", 65, 50, 70, 95, 80, 65, Type.PSYCHIC
		speciesMap.put("Absol", new Species(359, "Absol", 65, 130, 60, 75, 60, 75, Type.DARK
		speciesMap.put("Mega Absol", new Species(-359, "Mega Absol", 65, 150, 60, 115, 60, 115, Type.DARK
		speciesMap.put("Wynaut", new Species(360, "Wynaut", 95, 23, 48, 23, 48, 23, Type.PSYCHIC
		speciesMap.put("Snorunt", new Species(361, "Snorunt", 50, 50, 50, 50, 50, 50, Type.ICE
		speciesMap.put("Glalie", new Species(362, "Glalie", 80, 80, 80, 80, 80, 80, Type.ICE
		speciesMap.put("Mega Glalie", new Species(-362, "Mega Glalie", 80, 120, 80, 120, 80, 100, Type.ICE
		speciesMap.put("Spheal", new Species(363, "Spheal", 70, 40, 50, 55, 50, 25, Type.ICE, Type.WATER
		speciesMap.put("Sealeo", new Species(364, "Sealeo", 90, 60, 70, 75, 70, 45, Type.ICE, Type.WATER
		speciesMap.put("Walrein", new Species(365, "Walrein", 110, 80, 90, 95, 90, 65, Type.ICE, Type.WATER
		speciesMap.put("Clamperl", new Species(366, "Clamperl", 35, 64, 85, 74, 55, 32, Type.WATER
		speciesMap.put("Huntail", new Species(367, "Huntail", 55, 104, 105, 94, 75, 52, Type.WATER
		speciesMap.put("Gorebyss", new Species(368, "Gorebyss", 55, 84, 105, 114, 75, 52, Type.WATER
		speciesMap.put("Relicanth", new Species(369, "Relicanth", 100, 90, 130, 45, 65, 55, Type.WATER, Type.ROCK
		speciesMap.put("Luvdisc", new Species(370, "Luvdisc", 43, 30, 55, 40, 65, 97, Type.WATER
		speciesMap.put("Bagon", new Species(371, "Bagon", 45, 75, 60, 40, 30, 50, Type.DRAGON
		speciesMap.put("Shelgon", new Species(372, "Shelgon", 65, 95, 100, 60, 50, 50, Type.DRAGON
		speciesMap.put("Salamence", new Species(373, "Salamence", 95, 135, 80, 110, 80, 100, Type.DRAGON, Type.FLYING
		speciesMap.put("Mega Salamence", new Species(-373, "Mega Salamence", 95, 145, 130, 120, 90, 120, Type.DRAGON, Type.FLYING
		speciesMap.put("Beldum", new Species(374, "Beldum", 40, 55, 80, 35, 60, 30, Type.STEEL, Type.PSYCHIC
		speciesMap.put("Metang", new Species(375, "Metang", 60, 75, 100, 55, 80, 50, Type.STEEL, Type.PSYCHIC
		speciesMap.put("Metagross", new Species(376, "Metagross", 80, 135, 130, 95, 90, 70, Type.STEEL, Type.PSYCHIC
		speciesMap.put("Mega Metagross", new Species(-376, "Mega Metagross", 80, 145, 150, 105, 110, 110, Type.STEEL, Type.PSYCHIC
		speciesMap.put("Regirock", new Species(377, "Regirock", 80, 100, 200, 50, 100, 50, Type.ROCK
		speciesMap.put("Regice", new Species(378, "Regice", 80, 50, 100, 100, 200, 50, Type.ICE
		speciesMap.put("Registeel", new Species(379, "Registeel", 80, 75, 150, 75, 150, 50, Type.STEEL
		speciesMap.put("Latias", new Species(380, "Latias", 80, 80, 90, 110, 130, 110, Type.DRAGON, Type.PSYCHIC
		speciesMap.put("Mega Latias", new Species(-380, "Mega Latias", 80, 100, 120, 140, 150, 110, Type.DRAGON, Type.PSYCHIC
		speciesMap.put("Latios", new Species(381, "Latios", 80, 90, 80, 130, 110, 110, Type.DRAGON, Type.PSYCHIC
		speciesMap.put("Mega Latios", new Species(-381, "Mega Latios", 80, 130, 100, 160, 120, 110, Type.DRAGON, Type.PSYCHIC
		speciesMap.put("Kyogre", new Species(382, "Kyogre", 100, 100, 90, 150, 140, 90, Type.WATER
		speciesMap.put("Primal Kyogre", new Species(-382, "Primal Kyogre", 100, 150, 90, 180, 160, 90, Type.WATER
		speciesMap.put("Groudon", new Species(383, "Groudon", 100, 150, 140, 100, 90, 90, Type.GROUND
		speciesMap.put("Primal Groudon", new Species(-383, "Primal Groudon", 100, 180, 160, 150, 90, 90, Type.GROUND, Type.FIRE
		speciesMap.put("Rayquaza", new Species(384, "Rayquaza", 105, 150, 90, 150, 90, 95, Type.DRAGON, Type.FLYING
		speciesMap.put("Mega Rayquaza", new Species(-384, "Mega Rayquaza", 105, 180, 100, 180, 100, 115, Type.DRAGON, Type.FLYING
		speciesMap.put("Jirachi", new Species(385, "Jirachi", 100, 100, 100, 100, 100, 100, Type.STEEL, Type.PSYCHIC
		speciesMap.put("Deoxys", new Species(386.0, "Deoxys", 50, 150, 50, 150, 50, 150, Type.GROUND
		speciesMap.put("Deoxys Attack Form", new Species(386.1, "Deoxys Attack Form", 50, 180, 20, 180, 20, 150, Type.GROUND
		speciesMap.put("Deoxys Defense Form", new Species(386.2, "Deoxys Defense Form", 50, 70, 160, 70, 160, 90, Type.GROUND
		speciesMap.put("Deoxys Speed Form", new Species(386.3, "Deoxys Speed Form", 50, 95, 90, 95, 90, 180, Type.GROUND
		speciesMap.put("Turtwig", new Species(387, "Turtwig", 55, 68, 64, 45, 55, 31, Type.GRASS
		speciesMap.put("Grotle", new Species(388, "Grotle", 75, 89, 85, 55, 65, 36, Type.GRASS
		speciesMap.put("Torterra", new Species(389, "Torterra", 95, 109, 105, 75, 85, 56, Type.GRASS, Type.GROUND
		speciesMap.put("Chimchar", new Species(390, "Chimchar", 44, 58, 44, 58, 44, 61, Type.FIRE
		speciesMap.put("Monferno", new Species(391, "Monferno", 64, 78, 52, 78, 52, 81, Type.FIRE, Type.FIGHTING
		speciesMap.put("Infernape", new Species(392, "Infernape", 76, 104, 71, 104, 71, 108, Type.FIRE, Type.FIGHTING
		speciesMap.put("Piplup", new Species(393, "Piplup", 53, 51, 53, 61, 56, 40, Type.WATER
		speciesMap.put("Prinplup", new Species(394, "Prinplup", 64, 66, 68, 81, 76, 50, Type.WATER
		speciesMap.put("Empoleon", new Species(395, "Empoleon", 84, 86, 88, 111, 101, 60, Type.WATER, Type.STEEL
		speciesMap.put("Starly", new Species(396, "Starly", 40, 55, 30, 30, 30, 60, Type.NORMAL, Type.FLYING
		speciesMap.put("Staravia", new Species(397, "Staravia", 55, 75, 50, 40, 40, 80, Type.NORMAL, Type.FLYING
		speciesMap.put("Staraptor", new Species(398, "Staraptor", 85, 120, 70, 50, 60, 100, Type.NORMAL, Type.FLYING
		speciesMap.put("Bidoof", new Species(399, "Bidoof", 59, 45, 40, 35, 40, 31, Type.NORMAL
		speciesMap.put("Bibarel", new Species(400, "Bibarel", 79, 85, 60, 55, 60, 71, Type.NORMAL, Type.WATER
		speciesMap.put("Kricketot", new Species(401, "Kricketot", 37, 25, 41, 25, 41, 25, Type.BUG
		speciesMap.put("Kricketune", new Species(402, "Kricketune", 77, 85, 51, 55, 51, 65, Type.BUG
		speciesMap.put("Shinx", new Species(403, "Shinx", 45, 65, 34, 40, 34, 45, Type.ELECTRIC
		speciesMap.put("Luxio", new Species(404, "Luxio", 60, 85, 49, 60, 49, 60, Type.ELECTRIC
		speciesMap.put("Luxray", new Species(405, "Luxray", 80, 120, 79, 95, 79, 70, Type.ELECTRIC
		speciesMap.put("Budew", new Species(406, "Budew", 40, 30, 35, 50, 70, 55, Type.GRASS, Type.POISON
		speciesMap.put("Roserade", new Species(407, "Roserade", 60, 70, 65, 125, 105, 90, Type.GRASS, Type.POISON
		speciesMap.put("Cranidos", new Species(408, "Cranidos", 67, 125, 40, 30, 30, 58, Type.ROCK
		speciesMap.put("Rampardos", new Species(409, "Rampardos", 97, 165, 60, 65, 50, 58, Type.ROCK
		speciesMap.put("Shieldon", new Species(410, "Shieldon", 30, 42, 118, 42, 88, 30, Type.ROCK, Type.STEEL
		speciesMap.put("Bastiodon", new Species(411, "Bastiodon", 60, 52, 168, 47, 138, 30, Type.ROCK, Type.STEEL
		speciesMap.put("Burmy", new Species(412, "Burmy", 40, 29, 45, 29, 45, 36, Type.BUG
		speciesMap.put("Wormadam Plant Cloak", new Species(413.1, "Wormadam Plant Cloak", 60, 59, 85, 79, 105, 36, Type.BUG, Type.GRASS
		speciesMap.put("Wormadam Sandy Cloak", new Species(413.2, "Wormadam Sandy Cloak", 60, 79, 105, 59, 85, 36, Type.BUG, Type.GROUND
		speciesMap.put("Wormadam Trash Cloak", new Species(413.3, "Wormadam Trash Cloak", 60, 69, 95, 69, 95, 36, Type.BUG, Type.STEEL
		speciesMap.put("Mothim", new Species(414, "Mothim", 70, 94, 50, 94, 50, 66, Type.BUG, Type.FLYING
		speciesMap.put("Combee", new Species(415, "Combee", 30, 30, 42, 30, 42, 70, Type.BUG, Type.FLYING
		speciesMap.put("Vespiquen", new Species(416, "Vespiquen", 70, 80, 102, 80, 102, 40, Type.BUG, Type.FLYING
		speciesMap.put("Pachirisu", new Species(417, "Pachirisu", 60, 45, 70, 45, 90, 95, Type.ELECTRIC
		speciesMap.put("Buizel", new Species(418, "Buizel", 55, 65, 35, 60, 30, 85, Type.WATER
		speciesMap.put("Floatzel", new Species(419, "Floatzel", 85, 105, 55, 85, 50, 115, Type.WATER
		speciesMap.put("Cherubi", new Species(420, "Cherubi", 45, 35, 45, 62, 53, 35, Type.GRASS
		speciesMap.put("Cherrim", new Species(421, "Cherrim", 70, 60, 70, 87, 78, 85, Type.GRASS
		speciesMap.put("Shellos", new Species(422, "Shellos", 76, 48, 48, 57, 62, 34, Type.WATER
		speciesMap.put("Gastrodon", new Species(423, "Gastrodon", 111, 83, 68, 92, 82, 39, Type.WATER, Type.GROUND
		speciesMap.put("Ambipom", new Species(424, "Ambipom", 75, 100, 66, 60, 66, 115, Type.NORMAL
		speciesMap.put("Drifloon", new Species(425, "Drifloon", 90, 50, 34, 60, 44, 70, Type.GHOST, Type.FLYING
		speciesMap.put("Drifblim", new Species(426, "Drifblim", 150, 80, 44, 90, 54, 80, Type.GHOST, Type.FLYING
		speciesMap.put("Buneary", new Species(427, "Buneary", 55, 66, 44, 44, 56, 85, Type.NORMAL
		speciesMap.put("Lopunny", new Species(428, "Lopunny", 65, 76, 84, 54, 96, 105, Type.NORMAL
		speciesMap.put("Mega Lopunny", new Species(-428, "Mega Lopunny", 65, 136, 94, 54, 96, 135, Type.NORMAL, Type.FIGHTING
		speciesMap.put("Mismagius", new Species(429, "Mismagius", 60, 60, 60, 105, 105, 105, Type.GHOST
		speciesMap.put("Honchkrow", new Species(430, "Honchkrow", 100, 125, 52, 105, 52, 71, Type.DARK, Type.FLYING
		speciesMap.put("Glameow", new Species(431, "Glameow", 49, 55, 42, 42, 37, 85, Type.NORMAL
		speciesMap.put("Purugly", new Species(432, "Purugly", 71, 82, 64, 64, 59, 112, Type.NORMAL
		speciesMap.put("Chingling", new Species(433, "Chingling", 45, 30, 50, 65, 50, 45, Type.PSYCHIC
		speciesMap.put("Stunky", new Species(434, "Stunky", 63, 63, 47, 41, 41, 74, Type.POISON, Type.DARK
		speciesMap.put("Skuntank", new Species(435, "Skuntank", 103, 93, 67, 71, 61, 84, Type.POISON, Type.DARK
		speciesMap.put("Bronzor", new Species(436, "Bronzor", 57, 24, 86, 24, 86, 23, Type.STEEL, Type.PSYCHIC
		speciesMap.put("Bronzong", new Species(437, "Bronzong", 67, 89, 116, 79, 116, 33, Type.STEEL, Type.PSYCHIC
		speciesMap.put("Bonsly", new Species(438, "Bonsly", 50, 80, 95, 10, 45, 10, Type.ROCK
		speciesMap.put("Mime Jr.", new Species(439, "Mime Jr.", 20, 25, 45, 70, 90, 60, Type.PSYCHIC, Type.FAIRY
		speciesMap.put("Happiny", new Species(440, "Happiny", 100, 5, 5, 15, 65, 30, Type.NORMAL
		speciesMap.put("Chatot", new Species(441, "Chatot", 76, 65, 45, 92, 42, 91, Type.NORMAL, Type.FLYING
		speciesMap.put("Spiritomb", new Species(442, "Spiritomb", 50, 92, 108, 92, 108, 35, Type.GHOST, Type.DARK
		speciesMap.put("Gible", new Species(443, "Gible", 58, 70, 45, 40, 45, 42, Type.DRAGON, Type.GROUND
		speciesMap.put("Gabite", new Species(444, "Gabite", 68, 90, 65, 50, 55, 82, Type.DRAGON, Type.GROUND
		speciesMap.put("Garchomp", new Species(445, "Garchomp", 108, 130, 95, 80, 85, 102, Type.DRAGON, Type.GROUND
		speciesMap.put("Mega Garchomp", new Species(-445, "Mega Garchomp", 108, 170, 115, 120, 95, 92, Type.DRAGON, Type.GROUND
		speciesMap.put("Munchlax", new Species(446, "Munchlax", 135, 85, 40, 40, 85, 5, Type.NORMAL
		speciesMap.put("Riolu", new Species(447, "Riolu", 40, 70, 40, 35, 40, 60, Type.FIGHTING
		speciesMap.put("Lucario", new Species(448, "Lucario", 70, 110, 70, 115, 70, 90, Type.FIGHTING, Type.STEEL
		speciesMap.put("Mega Lucario", new Species(-448, "Mega Lucario", 70, 145, 88, 140, 70, 112, Type.FIGHTING, Type.STEEL
		speciesMap.put("Hippopotas", new Species(449, "Hippopotas", 68, 72, 78, 38, 42, 32, Type.GROUND
		speciesMap.put("Hippowdon", new Species(450, "Hippowdon", 108, 112, 118, 68, 72, 47, Type.GROUND
		speciesMap.put("Skorupi", new Species(451, "Skorupi", 40, 50, 90, 30, 55, 65, Type.POISON, Type.BUG
		speciesMap.put("Drapion", new Species(452, "Drapion", 70, 90, 110, 60, 75, 95, Type.POISON, Type.DARK
		speciesMap.put("Croagunk", new Species(453, "Croagunk", 48, 61, 40, 61, 40, 50, Type.POISON, Type.FIGHTING
		speciesMap.put("Toxicroak", new Species(454, "Toxicroak", 83, 106, 65, 86, 65, 85, Type.POISON, Type.FIGHTING
		speciesMap.put("Carnivine", new Species(455, "Carnivine", 74, 100, 72, 90, 72, 46, Type.GRASS
		speciesMap.put("Finneon", new Species(456, "Finneon", 49, 49, 56, 49, 61, 66, Type.WATER
		speciesMap.put("Lumineon", new Species(457, "Lumineon", 69, 69, 76, 69, 86, 91, Type.WATER
		speciesMap.put("Mantyke", new Species(458, "Mantyke", 45, 20, 50, 60, 120, 50, Type.WATER, Type.FLYING
		speciesMap.put("Snover", new Species(459, "Snover", 60, 62, 50, 62, 60, 40, Type.GRASS, Type.ICE
		speciesMap.put("Abomasnow", new Species(460, "Abomasnow", 90, 92, 75, 92, 85, 60, Type.GRASS, Type.ICE
		speciesMap.put("Mega Abomasnow", new Species(-460, "Mega Abomasnow", 90, 132, 105, 132, 105, 30, Type.GRASS, Type.ICE
		speciesMap.put("Weavile", new Species(461, "Weavile", 70, 120, 65, 45, 85, 125, Type.DARK, Type.ICE
		speciesMap.put("Magnezone", new Species(462, "Magnezone", 70, 70, 115, 130, 90, 60, Type.ELECTRIC, Type.STEEL
		speciesMap.put("Lickilicky", new Species(463, "Lickilicky", 110, 85, 95, 80, 95, 50, Type.NORMAL
		speciesMap.put("Rhyperior", new Species(464, "Rhyperior", 115, 140, 130, 55, 55, 40, Type.GROUND, Type.ROCK
		speciesMap.put("Tangrowth", new Species(465, "Tangrowth", 100, 100, 125, 110, 50, 50, Type.GRASS
		speciesMap.put("Electivire", new Species(466, "Electivire", 75, 123, 67, 95, 85, 95, Type.ELECTRIC
		speciesMap.put("Magmortar", new Species(467, "Magmortar", 75, 95, 67, 125, 95, 83, Type.FIRE
		speciesMap.put("Togekiss", new Species(468, "Togekiss", 85, 50, 95, 120, 115, 80, Type.FAIRY, Type.FLYING
		speciesMap.put("Yanmega", new Species(469, "Yanmega", 86, 76, 86, 116, 56, 95, Type.BUG, Type.FLYING
		speciesMap.put("Leafeon", new Species(470, "Leafeon", 65, 110, 130, 60, 65, 95, Type.GRASS
		speciesMap.put("Glaceon", new Species(471, "Glaceon", 65, 60, 110, 130, 95, 65, Type.ICE
		speciesMap.put("Gliscor", new Species(472, "Gliscor", 75, 95, 125, 45, 75, 95, Type.GROUND, Type.FLYING
		speciesMap.put("Mamoswine", new Species(473, "Mamoswine", 110, 130, 80, 70, 60, 80, Type.ICE, Type.GROUND
		speciesMap.put("Porygon-Z", new Species(474, "Porygon-Z", 85, 80, 70, 135, 75, 90, Type.NORMAL
		speciesMap.put("Gallade", new Species(475, "Gallade", 68, 125, 65, 65, 115, 80, Type.PSYCHIC, Type.FIGHTING
		speciesMap.put("Mega Gallade", new Species(-475, "Mega Gallade", 68, 165, 95, 65, 115, 110, Type.PSYCHIC, Type.FIGHTING
		speciesMap.put("Probopass", new Species(476, "Probopass", 60, 55, 145, 75, 150, 40, Type.ROCK, Type.STEEL
		speciesMap.put("Dusknoir", new Species(477, "Dusknoir", 45, 100, 135, 65, 135, 45, Type.GHOST
		speciesMap.put("Froslass", new Species(478, "Froslass", 70, 80, 70, 80, 70, 110, Type.ICE, Type.GHOST
		speciesMap.put("Rotom", new Species(479.0, "Rotom", 50, 50, 77, 95, 77, 91, Type.ELECTRIC, Type.GHOST
		speciesMap.put("Rotom Heat", new Species(479.1, "Rotom Heat", 50, 65, 107, 105, 107, 86, Type.ELECTRIC, Type.FIRE
		speciesMap.put("Rotom Wash", new Species(479.2, "Rotom Wash", 50, 65, 107, 105, 107, 86, Type.ELECTRIC, Type.WATER
		speciesMap.put("Rotom Frost", new Species(479.3, "Rotom Frost", 50, 65, 107, 105, 107, 86, Type.ELECTRIC, Type.ICE
		speciesMap.put("Rotom Fan", new Species(479.4, "Rotom Fan", 50, 65, 107, 105, 107, 86, Type.ELECTRIC, Type.FLYING
		speciesMap.put("Rotom Mow", new Species(479.5, "Rotom Mow", 50, 65, 107, 105, 107, 86, Type.ELECTRIC, Type.GRASS
		speciesMap.put("Uxie", new Species(480, "Uxie", 75, 75, 130, 75, 130, 95, Type.PSYCHIC
		speciesMap.put("Mesprit", new Species(481, "Mesprit", 80, 105, 105, 105, 105, 80, Type.PSYCHIC
		speciesMap.put("Azelf", new Species(482, "Azelf", 75, 125, 70, 125, 70, 115, Type.PSYCHIC
		speciesMap.put("Dialga", new Species(483, "Dialga", 100, 120, 120, 150, 100, 90, Type.STEEL, Type.DRAGON
		speciesMap.put("Palkia", new Species(484, "Palkia", 90, 120, 100, 150, 120, 100, Type.WATER, Type.DRAGON
		speciesMap.put("Heatran", new Species(485, "Heatran", 91, 90, 106, 130, 106, 77, Type.FIRE, Type.STEEL
		speciesMap.put("Regigigas", new Species(486, "Regigigas", 110, 160, 110, 80, 110, 100, Type.NORMAL
		speciesMap.put("Giratina Altered Form", new Species(487.0, "Giratina Altered Form", 150, 100, 120, 100, 120, 90, Type.GHOST, Type.DRAGON
		speciesMap.put("Giratina Origin Form", new Species(487.1, "Giratina Origin Form", 150, 120, 100, 120, 100, 90, Type.GHOST, Type.DRAGON
		speciesMap.put("Cresselia", new Species(488, "Cresselia", 120, 70, 120, 75, 130, 85, Type.PSYCHIC
		speciesMap.put("Phione", new Species(489, "Phione", 80, 80, 80, 80, 80, 80, Type.WATER
		speciesMap.put("Manaphy", new Species(490, "Manaphy", 100, 100, 100, 100, 100, 100, Type.WATER
		speciesMap.put("Darkrai", new Species(491, "Darkrai", 70, 90, 90, 135, 90, 125, Type.DARK
		speciesMap.put("Shaymin Land Form", new Species(492.0, "Shaymin Land Form", 100, 100, 100, 100, 100, 100, Type.GRASS
		speciesMap.put("Shaymin Sky Form", new Species(492.1, "Shaymin Sky Form", 100, 103, 75, 120, 75, 127, Type.GRASS, Type.FLYING
		speciesMap.put("Arceus", new Species(493, "Arceus", 120, 120, 120, 120, 120, 120, Type.NORMAL
		speciesMap.put("Victini", new Species(494, "Victini", 100, 100, 100, 100, 100, 100, Type.PSYCHIC, Type.FIRE
		speciesMap.put("Snivy", new Species(495, "Snivy", 45, 45, 55, 45, 55, 63, Type.GRASS
		speciesMap.put("Servine", new Species(496, "Servine", 60, 60, 75, 60, 75, 83, Type.GRASS
		speciesMap.put("Serperior", new Species(497, "Serperior", 75, 75, 95, 75, 95, 113, Type.GRASS
		speciesMap.put("Tepig", new Species(498, "Tepig", 65, 63, 45, 45, 45, 45, Type.FIRE
		speciesMap.put("Pignite", new Species(499, "Pignite", 90, 93, 55, 70, 55, 55, Type.FIRE, Type.FIGHTING
		speciesMap.put("Emboar", new Species(500, "Emboar", 110, 123, 65, 100, 65, 65, Type.FIRE, Type.FIGHTING
		speciesMap.put("Oshawott", new Species(501, "Oshawott", 55, 55, 45, 63, 45, 45, Type.WATER
		speciesMap.put("Dewott", new Species(502, "Dewott", 75, 75, 60, 83, 60, 60, Type.WATER
		speciesMap.put("Samurott", new Species(503, "Samurott", 95, 100, 85, 108, 70, 70, Type.WATER
		speciesMap.put("Patrat", new Species(504, "Patrat", 45, 55, 39, 35, 39, 42, Type.NORMAL
		speciesMap.put("Watchog", new Species(505, "Watchog", 60, 85, 69, 60, 69, 77, Type.NORMAL
		speciesMap.put("Lillipup", new Species(506, "Lillipup", 45, 60, 45, 25, 45, 55, Type.NORMAL
		speciesMap.put("Herdier", new Species(507, "Herdier", 65, 80, 65, 35, 65, 60, Type.NORMAL
		speciesMap.put("Stoutland", new Species(508, "Stoutland", 85, 110, 90, 45, 90, 80, Type.NORMAL
		speciesMap.put("Purrloin", new Species(509, "Purrloin", 41, 50, 37, 50, 37, 66, Type.DARK
		speciesMap.put("Liepard", new Species(510, "Liepard", 64, 88, 50, 88, 50, 106, Type.DARK
		speciesMap.put("Pansage", new Species(511, "Pansage", 50, 53, 48, 53, 48, 64, Type.GRASS
		speciesMap.put("Simisage", new Species(512, "Simisage", 75, 98, 63, 98, 63, 101, Type.GRASS
		speciesMap.put("Pansear", new Species(513, "Pansear", 50, 53, 48, 53, 48, 64, Type.FIRE
		speciesMap.put("Simisear", new Species(514, "Simisear", 75, 98, 63, 98, 63, 101, Type.FIRE
		speciesMap.put("Panpour", new Species(515, "Panpour", 50, 53, 48, 53, 48, 64, Type.WATER
		speciesMap.put("Simipour", new Species(516, "Simipour", 75, 98, 63, 98, 63, 101, Type.WATER
		speciesMap.put("Munna", new Species(517, "Munna", 76, 25, 45, 67, 55, 24, Type.PSYCHIC
		speciesMap.put("Musharna", new Species(518, "Musharna", 116, 55, 85, 107, 95, 29, Type.PSYCHIC
		speciesMap.put("Pidove", new Species(519, "Pidove", 50, 55, 50, 36, 30, 43, Type.NORMAL, Type.FLYING
		speciesMap.put("Tranquill", new Species(520, "Tranquill", 62, 77, 62, 50, 42, 65, Type.NORMAL, Type.FLYING
		speciesMap.put("Unfezant", new Species(521, "Unfezant", 80, 115, 80, 65, 55, 93, Type.NORMAL, Type.FLYING
		speciesMap.put("Blitzle", new Species(522, "Blitzle", 45, 60, 32, 50, 32, 76, Type.ELECTRIC
		speciesMap.put("Zebstrika", new Species(523, "Zebstrika", 75, 100, 63, 80, 63, 116, Type.ELECTRIC
		speciesMap.put("Roggenrola", new Species(524, "Roggenrola", 55, 75, 85, 25, 25, 15, Type.ROCK
		speciesMap.put("Boldore", new Species(525, "Boldore", 70, 105, 105, 50, 40, 20, Type.ROCK
		speciesMap.put("Gigalith", new Species(526, "Gigalith", 85, 135, 130, 60, 80, 25, Type.ROCK
		speciesMap.put("Woobat", new Species(527, "Woobat", 55, 45, 43, 55, 43, 72, Type.PSYCHIC, Type.FLYING
		speciesMap.put("Swoobat", new Species(528, "Swoobat", 67, 57, 55, 77, 55, 114, Type.PSYCHIC, Type.FLYING
		speciesMap.put("Drilbur", new Species(529, "Drilbur", 60, 85, 40, 30, 45, 68, Type.GROUND
		speciesMap.put("Excadrill", new Species(530, "Excadrill", 110, 135, 60, 50, 65, 88, Type.GROUND, Type.STEEL
		speciesMap.put("Audino", new Species(531, "Audino", 103, 60, 86, 60, 86, 50, Type.NORMAL
		speciesMap.put("Mega Audino", new Species(-531, "Mega Audino", 103, 60, 126, 80, 126, 50, Type.NORMAL, Type.FAIRY
		speciesMap.put("Timburr", new Species(532, "Timburr", 75, 80, 55, 25, 35, 35, Type.FIGHTING
		speciesMap.put("Gurdurr", new Species(533, "Gurdurr", 85, 105, 85, 40, 50, 40, Type.FIGHTING
		speciesMap.put("Conkeldurr", new Species(534, "Conkeldurr", 105, 140, 95, 55, 65, 45, Type.FIGHTING
		speciesMap.put("Tympole", new Species(535, "Tympole", 50, 50, 40, 50, 40, 64, Type.WATER
		speciesMap.put("Palpitoad", new Species(536, "Palpitoad", 75, 65, 55, 65, 55, 69, Type.WATER, Type.GROUND
		speciesMap.put("Seismitoad", new Species(537, "Seismitoad", 105, 95, 75, 85, 75, 74, Type.WATER, Type.GROUND
		speciesMap.put("Throh", new Species(538, "Throh", 120, 100, 85, 30, 85, 45, Type.FIGHTING
		speciesMap.put("Sawk", new Species(539, "Sawk", 75, 125, 75, 30, 75, 85, Type.FIGHTING
		speciesMap.put("Sewaddle", new Species(540, "Sewaddle", 45, 53, 70, 40, 60, 42, Type.BUG, Type.GRASS
		speciesMap.put("Swadloon", new Species(541, "Swadloon", 55, 63, 90, 50, 80, 42, Type.BUG, Type.GRASS
		speciesMap.put("Leavanny", new Species(542, "Leavanny", 75, 103, 80, 70, 80, 92, Type.BUG, Type.GRASS
		speciesMap.put("Venipede", new Species(543, "Venipede", 30, 45, 59, 30, 39, 57, Type.BUG, Type.POISON
		speciesMap.put("Whirlipede", new Species(544, "Whirlipede", 40, 55, 99, 40, 79, 47, Type.BUG, Type.POISON
		speciesMap.put("Scolipede", new Species(545, "Scolipede", 60, 100, 89, 55, 69, 112, Type.BUG, Type.POISON
		speciesMap.put("Cottonee", new Species(546, "Cottonee", 40, 27, 60, 37, 50, 66, Type.GRASS, Type.FAIRY
		speciesMap.put("Whimsicott", new Species(547, "Whimsicott", 60, 67, 85, 77, 75, 116, Type.GRASS, Type.FAIRY
		speciesMap.put("Petilil", new Species(548, "Petilil", 45, 35, 50, 70, 50, 30, Type.GRASS
		speciesMap.put("Lilligant", new Species(549, "Lilligant", 70, 60, 75, 110, 75, 90, Type.GRASS
		speciesMap.put("Basculin", new Species(550, "Basculin", 70, 92, 65, 80, 55, 98, Type.WATER
		speciesMap.put("Sandile", new Species(551, "Sandile", 50, 72, 35, 35, 35, 65, Type.GROUND, Type.DARK
		speciesMap.put("Krokorok", new Species(552, "Krokorok", 60, 82, 45, 45, 45, 74, Type.GROUND, Type.DARK
		speciesMap.put("Krookodile", new Species(553, "Krookodile", 95, 117, 80, 65, 70, 92, Type.GROUND, Type.DARK
		speciesMap.put("Darumaka", new Species(554, "Darumaka", 70, 90, 45, 15, 45, 50, Type.FIRE
		speciesMap.put("Darmanitan", new Species(555.0, "Darmanitan", 105, 140, 55, 30, 55, 95, Type.FIRE
		speciesMap.put("Darmanitan Zen", new Species(555.1, "Darmanitan Zen", 105, 30, 105, 140, 105, 55, Type.FIRE, Type.PSYCHIC
		speciesMap.put("Maractus", new Species(556, "Maractus", 75, 86, 67, 106, 67, 60, Type.GRASS
		speciesMap.put("Dwebble", new Species(557, "Dwebble", 50, 65, 85, 35, 35, 55, Type.BUG, Type.ROCK
		speciesMap.put("Crustle", new Species(558, "Crustle", 70, 95, 125, 65, 75, 45, Type.BUG, Type.ROCK
		speciesMap.put("Scraggy", new Species(559, "Scraggy", 50, 75, 70, 35, 70, 48, Type.DARK, Type.FIGHTING
		speciesMap.put("Scrafty", new Species(560, "Scrafty", 65, 90, 115, 45, 115, 58, Type.DARK, Type.FIGHTING
		speciesMap.put("Sigilyph", new Species(561, "Sigilyph", 72, 58, 80, 103, 80, 97, Type.PSYCHIC, Type.FLYING
		speciesMap.put("Yamask", new Species(562, "Yamask", 38, 30, 85, 55, 65, 30, Type.GHOST
		speciesMap.put("Cofagrigus", new Species(563, "Cofagrigus", 58, 50, 145, 95, 105, 30, Type.GHOST
		speciesMap.put("Tirtouga", new Species(564, "Tirtouga", 54, 78, 103, 53, 45, 22, Type.WATER, Type.ROCK
		speciesMap.put("Carracosta", new Species(565, "Carracosta", 74, 108, 133, 83, 65, 32, Type.WATER, Type.ROCK
		speciesMap.put("Archen", new Species(566, "Archen", 55, 112, 45, 74, 45, 70, Type.ROCK, Type.FLYING
		speciesMap.put("Archeops", new Species(567, "Archeops", 75, 140, 65, 112, 65, 110, Type.ROCK, Type.FLYING
		speciesMap.put("Trubbish", new Species(568, "Trubbish", 50, 50, 62, 40, 62, 65, Type.POISON
		speciesMap.put("Garbodor", new Species(569, "Garbodor", 80, 95, 82, 60, 82, 75, Type.POISON
		speciesMap.put("Zorua", new Species(570, "Zorua", 40, 65, 40, 80, 40, 65, Type.DARK
		speciesMap.put("Zoroark", new Species(571, "Zoroark", 60, 105, 60, 120, 60, 105, Type.DARK
		speciesMap.put("Minccino", new Species(572, "Minccino", 55, 50, 40, 40, 40, 75, Type.NORMAL
		speciesMap.put("Cinccino", new Species(573, "Cinccino", 75, 95, 60, 65, 60, 115, Type.NORMAL
		speciesMap.put("Gothita", new Species(574, "Gothita", 45, 30, 50, 55, 65, 45, Type.PSYCHIC
		speciesMap.put("Gothorita", new Species(575, "Gothorita", 60, 45, 70, 75, 85, 55, Type.PSYCHIC
		speciesMap.put("Gothitelle", new Species(576, "Gothitelle", 70, 55, 95, 95, 110, 65, Type.PSYCHIC
		speciesMap.put("Solosis", new Species(577, "Solosis", 45, 30, 40, 105, 50, 20, Type.PSYCHIC
		speciesMap.put("Duosion", new Species(578, "Duosion", 65, 40, 50, 125, 60, 30, Type.PSYCHIC
		speciesMap.put("Reuniclus", new Species(579, "Reuniclus", 110, 65, 75, 125, 85, 30, Type.PSYCHIC
		speciesMap.put("Ducklett", new Species(580, "Ducklett", 62, 44, 50, 44, 50, 55, Type.WATER, Type.FLYING
		speciesMap.put("Swanna", new Species(581, "Swanna", 75, 87, 63, 87, 63, 98, Type.WATER, Type.FLYING
		speciesMap.put("Vanillite", new Species(582, "Vanillite", 36, 50, 50, 65, 60, 44, Type.ICE
		speciesMap.put("Vanillish", new Species(583, "Vanillish", 51, 65, 65, 80, 75, 59, Type.ICE
		speciesMap.put("Vanilluxe", new Species(584, "Vanilluxe", 71, 95, 85, 110, 95, 79, Type.ICE
		speciesMap.put("Deerling", new Species(585, "Deerling", 60, 60, 50, 40, 50, 75, Type.NORMAL, Type.GRASS
		speciesMap.put("Sawsbuck", new Species(586, "Sawsbuck", 80, 100, 70, 60, 70, 95, Type.NORMAL, Type.GRASS
		speciesMap.put("Emolga", new Species(587, "Emolga", 55, 75, 60, 75, 60, 103, Type.ICE
		speciesMap.put("Karrablast", new Species(588, "Karrablast", 50, 75, 45, 40, 45, 60, Type.BUG
		speciesMap.put("Escavalier", new Species(589, "Escavalier", 70, 135, 105, 60, 105, 20, Type.BUG, Type.STEEL
		speciesMap.put("Foongus", new Species(590, "Foongus", 69, 55, 45, 55, 55, 15, Type.GRASS, Type.POISON
		speciesMap.put("Amoonguss", new Species(591, "Amoonguss", 114, 85, 70, 85, 80, 30, Type.GRASS, Type.POISON
		speciesMap.put("Frillish", new Species(592, "Frillish", 55, 40, 50, 65, 85, 40, Type.WATER, Type.GHOST
		speciesMap.put("Jellicent", new Species(593, "Jellicent", 100, 60, 70, 85, 105, 60, Type.WATER, Type.GHOST
		speciesMap.put("Alomomola", new Species(594, "Alomomola", 165, 75, 80, 40, 45, 65, Type.WATER
		speciesMap.put("Joltik", new Species(595, "Joltik", 50, 47, 50, 57, 50, 65, Type.BUG, Type.ELECTRIC
		speciesMap.put("Galvantula", new Species(596, "Galvantula", 70, 77, 60, 97, 60, 108, Type.BUG, Type.ELECTRIC
		speciesMap.put("Ferroseed", new Species(597, "Ferroseed", 44, 50, 91, 24, 86, 10, Type.GRASS, Type.STEEL
		speciesMap.put("Ferrothorn", new Species(598, "Ferrothorn", 74, 94, 131, 54, 116, 20, Type.GRASS, Type.STEEL
		speciesMap.put("Klink", new Species(599, "Klink", 40, 55, 70, 45, 60, 30, Type.STEEL
		speciesMap.put("Klang", new Species(600, "Klang", 60, 80, 95, 70, 85, 50, Type.STEEL
		speciesMap.put("Klinklang", new Species(601, "Klinklang", 60, 100, 115, 70, 85, 90, Type.STEEL
		speciesMap.put("Tynamo", new Species(602, "Tynamo", 35, 55, 40, 45, 40, 60, Type.ELECTRIC
		speciesMap.put("Eelektrik", new Species(603, "Eelektrik", 65, 85, 70, 75, 70, 40, Type.ELECTRIC
		speciesMap.put("Eelektross", new Species(604, "Eelektross", 85, 115, 80, 105, 80, 50, Type.ELECTRIC
		speciesMap.put("Elgyem", new Species(605, "Elgyem", 55, 55, 55, 85, 55, 30, Type.PSYCHIC
		speciesMap.put("Beheeyem", new Species(606, "Beheeyem", 75, 75, 75, 125, 95, 40, Type.PSYCHIC
		speciesMap.put("Litwick", new Species(607, "Litwick", 50, 30, 55, 65, 55, 20, Type.GHOST, Type.FIRE
		speciesMap.put("Lampent", new Species(608, "Lampent", 60, 40, 60, 95, 60, 55, Type.GHOST, Type.FIRE
		speciesMap.put("Chandelure", new Species(609, "Chandelure", 60, 55, 90, 145, 90, 80, Type.GHOST, Type.FIRE
		speciesMap.put("Axew", new Species(610, "Axew", 46, 87, 60, 30, 40, 57, Type.DRAGON
		speciesMap.put("Fraxure", new Species(611, "Fraxure", 66, 117, 70, 40, 50, 67, Type.DRAGON
		speciesMap.put("Haxorus", new Species(612, "Haxorus", 76, 147, 90, 60, 70, 97, Type.DRAGON
		speciesMap.put("Cubchoo", new Species(613, "Cubchoo", 55, 70, 40, 60, 40, 40, Type.ICE
		speciesMap.put("Beartic", new Species(614, "Beartic", 95, 110, 80, 70, 80, 50, Type.ICE
		speciesMap.put("Cryogonal", new Species(615, "Cryogonal", 70, 50, 30, 95, 135, 105, Type.ICE
		speciesMap.put("Shelmet", new Species(616, "Shelmet", 50, 40, 85, 40, 65, 25, Type.BUG
		speciesMap.put("Accelgor", new Species(617, "Accelgor", 80, 70, 40, 100, 60, 145, Type.BUG
		speciesMap.put("Stunfisk", new Species(618, "Stunfisk", 109, 66, 84, 81, 99, 32, Type.GROUND, Type.ELECTRIC
		speciesMap.put("Mienfoo", new Species(619, "Mienfoo", 45, 85, 50, 55, 50, 65, Type.FIGHTING
		speciesMap.put("Mienshao", new Species(620, "Mienshao", 65, 125, 60, 95, 60, 105, Type.FIGHTING
		speciesMap.put("Druddigon", new Species(621, "Druddigon", 77, 120, 90, 60, 90, 48, Type.DRAGON
		speciesMap.put("Golett", new Species(622, "Golett", 59, 74, 50, 35, 50, 35, Type.GROUND, Type.GHOST
		speciesMap.put("Golurk", new Species(623, "Golurk", 89, 124, 80, 55, 80, 55, Type.GROUND, Type.GHOST
		speciesMap.put("Pawniard", new Species(624, "Pawniard", 45, 85, 70, 40, 40, 60, Type.DARK, Type.STEEL
		speciesMap.put("Bisharp", new Species(625, "Bisharp", 65, 125, 100, 60, 70, 70, Type.DARK, Type.STEEL
		speciesMap.put("Bouffalant", new Species(626, "Bouffalant", 95, 110, 95, 40, 95, 55, Type.NORMAL
		speciesMap.put("Rufflet", new Species(627, "Rufflet", 70, 83, 50, 37, 50, 60, Type.NORMAL, Type.FLYING
		speciesMap.put("Braviary", new Species(628, "Braviary", 100, 123, 75, 57, 75, 80, Type.NORMAL, Type.FLYING
		speciesMap.put("Vullaby", new Species(629, "Vullaby", 70, 55, 75, 45, 65, 60, Type.DARK, Type.FLYING
		speciesMap.put("Mandibuzz", new Species(630, "Mandibuzz", 110, 65, 105, 55, 95, 80, Type.DARK, Type.FLYING
		speciesMap.put("Heatmor", new Species(631, "Heatmor", 85, 97, 66, 105, 66, 65, Type.FIRE
		speciesMap.put("Durant", new Species(632, "Durant", 58, 109, 112, 48, 48, 109, Type.BUG, Type.STEEL
		speciesMap.put("Deino", new Species(633, "Deino", 52, 65, 50, 45, 50, 38, Type.DARK, Type.DRAGON
		speciesMap.put("Zweilous", new Species(634, "Zweilous", 72, 85, 70, 65, 70, 58, Type.DARK, Type.DRAGON
		speciesMap.put("Hydreigon", new Species(635, "Hydreigon", 92, 105, 90, 125, 90, 98, Type.DARK, Type.DRAGON
		speciesMap.put("Larvesta", new Species(636, "Larvesta", 55, 85, 55, 50, 55, 60, Type.BUG, Type.FIRE
		speciesMap.put("Volcarona", new Species(637, "Volcarona", 85, 60, 65, 135, 105, 100, Type.BUG, Type.FIRE
		speciesMap.put("Cobalion", new Species(638, "Cobalion", 91, 90, 129, 90, 72, 108, Type.STEEL, Type.FIGHTING
		speciesMap.put("Terrakion", new Species(639, "Terrakion", 91, 129, 90, 72, 90, 108, Type.ROCK, Type.FIGHTING
		speciesMap.put("Virizion", new Species(640, "Virizion", 91, 90, 72, 90, 129, 108, Type.GRASS, Type.FIGHTING
		speciesMap.put("Tornadus Incarnate", new Species(641.0, "Tornadus Incarnate", 79, 115, 70, 125, 80, 111, Type.FLYING
		speciesMap.put("Tornadus Therian", new Species(641.1, "Tornadus Therian", 79, 100, 80, 110, 90, 121, Type.FLYING
		speciesMap.put("Thundurus Incarnate", new Species(642.0, "Thundurus", 79, 115, 70, 125, 80, 111, Type.ELECTRIC, Type.FLYING
		speciesMap.put("Thundurus Therian", new Species(642.1, "Thundurus Therian", 79, 105, 70, 145, 80, 101, Type.ELECTRIC, Type.FLYING
		speciesMap.put("Reshiram", new Species(643, "Reshiram", 100, 120, 100, 150, 120, 90, Type.DRAGON, Type.FIRE
		speciesMap.put("Zekrom", new Species(644, "Zekrom", 100, 150, 120, 120, 100, 90, Type.DRAGON, Type.ELECTRIC
		speciesMap.put("Landorus Incarnate", new Species(645.0, "Landorus Incarnate", 89, 125, 90, 115, 80, 101, Type.GROUND, Type.FLYING
		speciesMap.put("Landorus Therian", new Species(645.1, "Landorus Therian", 89, 145, 90, 105, 80, 91, Type.GROUND, Type.FLYING
		speciesMap.put("Kyurem Normal", new Species(646.0, "Kyurem Normal", 125, 130, 90, 130, 90, 95, Type.DRAGON, Type.ICE
		speciesMap.put("Kyurem Black", new Species(646.1, "Kyurem Black", 125, 170, 100, 120, 90, 95, Type.DRAGON, Type.ICE
		speciesMap.put("Kyurem White", new Species(646.2, "Kyurem White", 125, 120, 90, 170, 100, 95, Type.DRAGON, Type.ICE
		speciesMap.put("Keldeo", new Species(647, "Keldeo", 91, 72, 90, 129, 90, 108, Type.WATER, Type.FIGHTING
		speciesMap.put("Meloetta Aria", new Species(648.0, "Meloetta Aria", 100, 77, 77, 128, 128, 90, Type.NORMAL, Type.PSYCHIC
		speciesMap.put("Meloetta Pirouette", new Species(648.1, "Meloetta Pirouette", 100, 128, 90, 77, 77, 128, Type.NORMAL, Type.FIGHTING
		speciesMap.put("Genesect", new Species(649, "Genesect", 71, 120, 95, 120, 95, 99, Type.BUG, Type.STEEL
		speciesMap.put("Chespin", new Species(650, "Chespin", 56, 61, 65, 48, 45, 38, Type.GRASS
		speciesMap.put("Quilladin", new Species(651, "Quilladin", 61, 78, 95, 56, 58, 57, Type.GRASS
		speciesMap.put("Chesnaught", new Species(652, "Chesnaught", 88, 107, 122, 74, 75, 64, Type.GRASS, Type.FIGHTING
		speciesMap.put("Fennekin", new Species(653, "Fennekin", 40, 45, 40, 62, 60, 60, Type.FIRE
		speciesMap.put("Braixen", new Species(654, "Braixen", 59, 59, 58, 90, 70, 73, Type.FIRE
		speciesMap.put("Delphox", new Species(655, "Delphox", 75, 69, 72, 114, 100, 104, Type.FIRE, Type.PSYCHIC
		speciesMap.put("Froakie", new Species(656, "Froakie", 41, 56, 40, 62, 44, 71, Type.WATER
		speciesMap.put("Frogadier", new Species(657, "Frogadier", 54, 63, 52, 83, 56, 97, Type.WATER
		speciesMap.put("Greninja", new Species(658, "Greninja", 72, 95, 67, 103, 71, 122, Type.WATER, Type.DARK
		speciesMap.put("Bunnelby", new Species(659, "Bunnelby", 38, 36, 38, 32, 36, 57, Type.NORMAL
		speciesMap.put("Diggersby", new Species(660, "Diggersby", 85, 56, 77, 50, 77, 78, Type.NORMAL, Type.GROUND
		speciesMap.put("Fletchling", new Species(661, "Fletchling", 45, 50, 43, 40, 38, 62, Type.FLYING, Type.NORMAL
		speciesMap.put("Fletchinder", new Species(662, "Fletchinder", 62, 73, 55, 56, 52, 84, Type.FIRE, Type.FLYING
		speciesMap.put("Talonflame", new Species(663, "Talonflame", 78, 81, 71, 74, 69, 126, Type.FIRE, Type.FLYING
		speciesMap.put("Scatterbug", new Species(664, "Scatterbug", 38, 35, 40, 27, 25, 35, Type.BUG
		speciesMap.put("Spewpa", new Species(665, "Spewpa", 45, 22, 60, 27, 30, 29, Type.BUG
		speciesMap.put("Vivillon", new Species(666, "Vivillon", 80, 52, 50, 90, 50, 89, Type.BUG, Type.FLYING
		speciesMap.put("Litleo", new Species(667, "Litleo", 62, 50, 58, 73, 54, 72, Type.FIRE, Type.NORMAL
		speciesMap.put("Pyroar", new Species(668, "Pyroar", 86, 68, 72, 109, 66, 106, Type.FIRE, Type.NORMAL
		speciesMap.put("Flabebe", new Species(669, "Flabebe", 44, 38, 39, 61, 79, 42, Type.FAIRY
		speciesMap.put("Floette", new Species(670, "Floette", 54, 45, 47, 75, 98, 52, Type.FAIRY
		speciesMap.put("Florges", new Species(671, "Florges", 78, 65, 68, 112, 154, 75, Type.FAIRY
		speciesMap.put("Skiddo", new Species(672, "Skiddo", 66, 65, 48, 62, 57, 52, Type.GRASS
		speciesMap.put("Gogoat", new Species(673, "Gogoat", 123, 100, 62, 97, 81, 68, Type.GRASS
		speciesMap.put("Pancham", new Species(674, "Pancham", 67, 82, 62, 46, 48, 43, Type.FIGHTING
		speciesMap.put("Pangoro", new Species(675, "Pangoro", 95, 124, 78, 69, 71, 58, Type.FIGHTING, Type.DARK
		speciesMap.put("Furfrou", new Species(676, "Furfrou", 75, 80, 60, 65, 90, 102, Type.NORMAL
		speciesMap.put("Espurr", new Species(677, "Espurr", 62, 48, 54, 63, 60, 68, Type.PSYCHIC
		speciesMap.put("Meowstic", new Species(678, "Meowstic", 74, 48, 76, 83, 81, 104, Type.PSYCHIC
		speciesMap.put("Honedge", new Species(679, "Honedge", 45, 80, 100, 35, 37, 28, Type.STEEL, Type.GHOST
		speciesMap.put("Doublade", new Species(680, "Doublade", 59, 110, 150, 45, 49, 35, Type.STEEL, Type.GHOST
		speciesMap.put("Aegislash Shield", new Species(681.0, "Aegislash Shield Form", 60, 50, 150, 50, 150, 60, Type.STEEL, Type.GHOST
		speciesMap.put("Aegislash Blade", new Species(681.1, "Aegislash Blade Form", 60, 150, 50, 150, 50, 60, Type.STEEL, Type.GHOST
		speciesMap.put("Spritzee", new Species(682, "Spritzee", 78, 52, 60, 63, 65, 23, Type.FAIRY
		speciesMap.put("Aromatisse", new Species(683, "Aromatisse", 101, 72, 72, 99, 89, 29, Type.FAIRY
		speciesMap.put("Swirlix", new Species(684, "Swirlix", 62, 48, 66, 59, 57, 49, Type.FAIRY
		speciesMap.put("Slurpuff", new Species(685, "Slurpuff", 82, 80, 86, 85, 75, 72, Type.FAIRY
		speciesMap.put("Inkay", new Species(686, "Inkay", 53, 54, 53, 37, 46, 45, Type.DARK, Type.PSYCHIC
		speciesMap.put("Malamar", new Species(687, "Malamar", 86, 92, 88, 68, 75, 73, Type.DARK, Type.PSYCHIC
		speciesMap.put("Binacle", new Species(688, "Binacle", 42, 52, 67, 39, 56, 50, Type.ROCK, Type.WATER
		speciesMap.put("Barbaracle", new Species(689, "Barbaracle", 72, 105, 115, 54, 86, 68, Type.ROCK, Type.WATER
		speciesMap.put("Skrelp", new Species(690, "Skrelp", 50, 60, 60, 60, 60, 30, Type.POISON, Type.WATER
		speciesMap.put("Dragalge", new Species(691, "Dragalge", 65, 75, 90, 97, 123, 44, Type.POISON, Type.DRAGON
		speciesMap.put("Clauncher", new Species(692, "Clauncher", 50, 53, 62, 58, 63, 44, Type.WATER
		speciesMap.put("Clawitzer", new Species(693, "Clawitzer", 71, 73, 88, 120, 89, 59, Type.WATER
		speciesMap.put("Helioptile", new Species(694, "Helioptile", 44, 38, 33, 61, 43, 70, Type.ELECTRIC, Type.NORMAL
		speciesMap.put("Heliolisk", new Species(695, "Heliolisk", 62, 55, 52, 109, 94, 109, Type.ELECTRIC, Type.NORMAL
		speciesMap.put("Tyrunt", new Species(696, "Tyrunt", 58, 89, 77, 45, 45, 48, Type.ROCK, Type.DRAGON
		speciesMap.put("Tyrantrum", new Species(697, "Tyrantrum", 82, 121, 119, 69, 59, 71, Type.ROCK, Type.DRAGON
		speciesMap.put("Amaura", new Species(698, "Amaura", 77, 59, 50, 67, 63, 46, Type.ROCK, Type.ICE
		speciesMap.put("Aurorus", new Species(699, "Aurorus", 123, 77, 72, 99, 92, 58, Type.ROCK, Type.ICE
		speciesMap.put("Sylveon", new Species(700, "Sylveon", 95, 65, 65, 110, 130, 60, Type.FAIRY
		speciesMap.put("Hawlucha", new Species(701, "Hawlucha", 78, 92, 75, 74, 63, 118, Type.FIGHTING, Type.FLYING
		speciesMap.put("Dedenne", new Species(702, "Dedenne", 67, 58, 57, 81, 67, 101, Type.ELECTRIC, Type.FAIRY
		speciesMap.put("Carbink", new Species(703, "Carbink", 50, 50, 150, 50, 150, 50, Type.ROCK, Type.FAIRY
		speciesMap.put("Goomy", new Species(704, "Goomy", 45, 50, 35, 55, 75, 40, Type.DRAGON
		speciesMap.put("Sliggoo", new Species(705, "Sliggoo", 68, 75, 53, 83, 113, 60, Type.DRAGON
		speciesMap.put("Goodra", new Species(706, "Goodra", 90, 100, 70, 110, 150, 80, Type.DRAGON
		speciesMap.put("Klefki", new Species(707, "Klefki", 57, 80, 91, 80, 87, 75, Type.STEEL, Type.FAIRY
		speciesMap.put("Phantump", new Species(708, "Phantump", 43, 70, 48, 50, 60, 38, Type.GHOST, Type.GRASS
		speciesMap.put("Trevenant", new Species(709, "Trevenant", 85, 110, 76, 65, 82, 56, Type.GHOST, Type.GRASS
		speciesMap.put("Pumpkaboo", new Species(710, "Pumpkaboo", 49, 66, 70, 44, 55, 51, Type.GHOST, Type.GRASS
		speciesMap.put("Gourgeist", new Species(711, "Gourgeist", 65, 90, 122, 58, 75, 84, Type.GHOST, Type.GRASS
		speciesMap.put("Bergmite", new Species(712, "Bergmite", 55, 69, 85, 32, 35, 28, Type.ICE
		speciesMap.put("Avalugg", new Species(713, "Avalugg", 95, 117, 184, 44, 46, 28, Type.ICE
		speciesMap.put("Noibat", new Species(714, "Noibat", 40, 30, 35, 45, 40, 55, Type.FLYING, Type.DRAGON
		speciesMap.put("Noivern", new Species(715, "Noivern", 85, 70, 80, 97, 80, 123, Type.FLYING, Type.DRAGON
		speciesMap.put("Xerneas", new Species(716, "Xerneas", 126, 131, 95, 131, 98, 99, Type.FAIRY
		speciesMap.put("Yveltal", new Species(717, "Yveltal", 126, 131, 95, 131, 98, 99, Type.DARK, Type.FLYING
		speciesMap.put("Zygarde", new Species(718, "Zygarde", 108, 100, 121, 81, 95, 95, Type.DRAGON, Type.GROUND
		speciesMap.put("Diancie", new Species(719, "Diancie", 50, 100, 150, 100, 150, 50, Type.ROCK, Type.FAIRY
		speciesMap.put("Mega Diancie", new Species(-719, "Mega Diancie", 50, 160, 110, 160, 110, 110, Type.ROCK, Type.FAIRY
		speciesMap.put("Hoopa Confined", new Species(720.0, "Hoopa Confined", 80, 110, 60, 150, 130, 70, Type.PSYCHIC, Type.GHOST
		speciesMap.put("Hoopa Unbound", new Species(720.1, "Hoopa Unbound", 80, 160, 60, 170, 130, 80, Type.PSYCHIC, Type.DARK
		speciesMap.put("Volcanion", new Species(721, "Volcanion", 80, 110, 120, 130, 90, 70, Type.FIRE, Type.WATER
	}
}
