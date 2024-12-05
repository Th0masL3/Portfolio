package com.lecoingameover.belecoingameover.utils;

import com.lecoingameover.belecoingameover.dataaccess.Console;
import com.lecoingameover.belecoingameover.dataaccess.ConsoleRepository;
import com.lecoingameover.belecoingameover.dataaccess.Product;
import com.lecoingameover.belecoingameover.dataaccess.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    @Autowired
    ConsoleRepository consoleRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        List <Console> consoleList = new ArrayList<>();

        Console NES = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("NES")
                .releaseDate(LocalDate.of(1983, 7, 15))
                .price(199.99)
                .quantityInStock(500)
                .company("Nintendo")
                .build();
        consoleList.add(NES);

        Console SNES = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("SNES")
                .releaseDate(LocalDate.of(1990, 11, 21))
                .price(249.99)
                .quantityInStock(450)
                .company("Nintendo")
                .build();
        consoleList.add(SNES);

        Console N64 = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("N64")
                .releaseDate(LocalDate.of(1996, 6, 23))
                .price(299.99)
                .quantityInStock(400)
                .company("Nintendo")
                .build();

        consoleList.add(N64);

        Console GameCube = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("GameCube")
                .releaseDate(LocalDate.of(2001, 9, 14))
                .price(199.99)
                .quantityInStock(350)
                .company("Nintendo")
                .build();
        consoleList.add(GameCube);

        Console Wii = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("Wii")
                .releaseDate(LocalDate.of(2006, 11, 19))
                .price(249.99)
                .quantityInStock(300)
                .company("Nintendo")
                .build();
        consoleList.add(Wii);
        Console WiiU = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("WiiU")
                .releaseDate(LocalDate.of(2012, 11, 18))
                .price(299.99)
                .quantityInStock(300)
                .company("Nintendo")
                .build();
        consoleList.add(WiiU);

        Console Switch = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("Switch")
                .releaseDate(LocalDate.of(2017, 3, 3))
                .price(599.99)
                .quantityInStock(300)
                .company("Nintendo")
                .build();
        consoleList.add(Switch);
        Console PS1 = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("PS1")
                .releaseDate(LocalDate.of(1994, 12, 3))
                .price(299.99)
                .quantityInStock(400)
                .company("Sony")
                .build();
        consoleList.add(PS1);

        Console PS2 = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("PS2")
                .releaseDate(LocalDate.of(2000, 3, 4))
                .price(299.99)
                .quantityInStock(400)
                .company("Sony")
                .build();
        consoleList.add(PS2);
        Console PS3 = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("PS3")
                .releaseDate(LocalDate.of(2006, 11, 11))
                .price(399.99)
                .quantityInStock(350)
                .company("Sony")
                .build();
        consoleList.add(PS3);

        Console PS5 = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("PS5")
                .releaseDate(LocalDate.of(2020, 11, 12))
                .price(599.99)
                .quantityInStock(300)
                .company("Sony")
                .build();
        consoleList.add(PS5);
        Console PS4 = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("PS4")
                .releaseDate(LocalDate.of(2013, 11, 15))
                .price(399.99)
                .quantityInStock(350)
                .company("Sony")
                .build();
        consoleList.add(PS4);

        Console PSP = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("PSP")
                .releaseDate(LocalDate.of(2004, 12, 12))
                .price(249.99)
                .quantityInStock(300)
                .company("Sony")
                .build();
        consoleList.add(PSP);

        Console PSVita = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("PSVita")
                .releaseDate(LocalDate.of(2011, 12, 17))
                .price(249.99)
                .quantityInStock(250)
                .company("Sony")
                .build();
        consoleList.add(PSVita);

        Console GameBoy = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("GameBoy")
                .releaseDate(LocalDate.of(1989, 4, 21))
                .price(99.99)
                .quantityInStock(500)
                .company("Nintendo")
                .build();
        consoleList.add(GameBoy);

        Console GameBoyColor = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("GameBoyColor")
                .releaseDate(LocalDate.of(1998, 10, 21))
                .price(129.99)
                .quantityInStock(400)
                .company("Nintendo")
                .build();
        consoleList.add(GameBoyColor);

        Console GameBoyAdvance = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("GameBoyAdvance")
                .releaseDate(LocalDate.of(2001, 3, 21))
                .price(99.99)
                .quantityInStock(350)
                .company("Nintendo")
                .build();
        consoleList.add(GameBoyAdvance);

        Console GameBoyAdvanceSP = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("GameBoyAdvanceSP")
                .releaseDate(LocalDate.of(2003, 2, 14))
                .price(129.99)
                .quantityInStock(300)
                .company("Nintendo")
                .build();
        consoleList.add(GameBoyAdvanceSP);
        Console DS = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("DS")
                .releaseDate(LocalDate.of(2004, 11, 21))
                .price(149.99)
                .quantityInStock(350)
                .company("Nintendo")
                .build();
        consoleList.add(DS);
        Console DSi = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("DSi")
                .releaseDate(LocalDate.of(2008, 11, 1))
                .price(169.99)
                .quantityInStock(300)
                .company("Nintendo")
                .build();
        consoleList.add(DSi);

        Console DS3D = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("3DS")
                .releaseDate(LocalDate.of(2011, 2, 26))
                .price(249.99)
                .quantityInStock(250)
                .company("Nintendo")
                .build();
        consoleList.add(DS3D);

        Console New3DS = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("New3DS")
                .releaseDate(LocalDate.of(2014, 10, 11))
                .price(199.99)
                .quantityInStock(200)
                .company("Nintendo")
                .build();
        consoleList.add(New3DS);
        Console Xbox = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("Xbox")
                .releaseDate(LocalDate.of(2001, 11, 15))
                .price(299.99)
                .quantityInStock(300)
                .company("Microsoft")
                .build();
        consoleList.add(Xbox);

        Console Xbox360 = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("Xbox360")
                .releaseDate(LocalDate.of(2005, 11, 22))
                .price(399.99)
                .quantityInStock(350)
                .company("Microsoft")
                .build();
        consoleList.add(Xbox360);



        Console XboxOne = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("XboxOne")
                .releaseDate(LocalDate.of(2013, 11, 22))
                .price(499.99)
                .quantityInStock(300)
                .company("Microsoft")
                .build();
        consoleList.add(XboxOne);


        Console XboxSeriesX = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("XboxSeriesX")
                .releaseDate(LocalDate.of(2020, 11, 10))
                .price(599.99)
                .quantityInStock(300)
                .company("Microsoft")
                .build();
        consoleList.add(XboxSeriesX);


        Console SegaMasterSystem = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("Sega Master System")
                .releaseDate(LocalDate.of(1985, 10, 20))
                .price(199.99)
                .quantityInStock(400)
                .company("Sega")
                .build();

        consoleList.add(SegaMasterSystem);


        Console SegaGenesis = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("Sega Genesis")
                .releaseDate(LocalDate.of(1988, 10, 29))
                .price(249.99)
                .quantityInStock(400)
                .company("Sega")
                .build();
        consoleList.add(SegaGenesis);

        Console SegaSaturn = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("Sega Saturn")
                .releaseDate(LocalDate.of(1994, 11, 22))
                .price(299.99)
                .quantityInStock(300)
                .company("Sega")
                .build();
        consoleList.add(SegaSaturn);


        Console SegaDreamcast = Console.builder()
                .consoleId(UUID.randomUUID().toString())
                .consoleName("Sega Dreamcast")
                .releaseDate(LocalDate.of(1998, 11, 27))
                .price(249.99)
                .quantityInStock(250)
                .company("Sega")
                .build();
        consoleList.add(SegaDreamcast);

        consoleRepository.saveAll(consoleList);

        //products
        Product PunchOut = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Punch-Out!!")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(NES)
                .build();

        Product DuckHunt = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Duck Hunt")
                .productSalePrice(29.99)
                .productQuantity(60)
                .console(NES)
                .build();

        Product Castlevania = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Castlevania")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(NES)
                .build();

        Product Excitebike = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Excitebike")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(NES)
                .build();

        Product DoubleDragon = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Double Dragon")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(NES)
                .build();

        Product KidIcarus = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kid Icarus")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(NES)
                .build();

        Product NinjaGaiden = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Ninja Gaiden")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(NES)
                .build();

        Product BubbleBobble = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Bubble Bobble")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(NES)
                .build();

        Product KirbyAdventure = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kirby's Adventure")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(NES)
                .build();

        Product DragonWarrior = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Dragon Warrior")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(NES)
                .build();

        Product ZeldaII = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Zelda II: The Adventure of Link")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(NES)
                .build();

        Product BalloonFight = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Balloon Fight")
                .productSalePrice(29.99)
                .productQuantity(20)
                .console(NES)
                .build();

        Product IceClimber = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Ice Climber")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(NES)
                .build();

        Product RCProAm = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("RC Pro-Am")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(NES)
                .build();

        Product AdventureIsland = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Adventure Island")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(NES)
                .build();

        Product Tetris = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Tetris")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(NES)
                .build();

        Product FinalFantasy = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Final Fantasy")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(NES)
                .build();

        Product MarioBros = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario Bros.")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(NES)
                .build();

        Product Paperboy = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Paperboy")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(NES)
                .build();

        Product DonkeyKong = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Donkey Kong")
                .productSalePrice(29.99)
                .productQuantity(20)
                .console(NES)
                .build();

        Product SMW = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Mario World")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(SNES)
                .build();

        Product ALttP = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: A Link to the Past")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(SNES)
                .build();

        Product SuperMetroid = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Metroid")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(SNES)
                .build();

        Product StreetFighterII = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Street Fighter II")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SNES)
                .build();

        Product DKC = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Donkey Kong Country")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(SNES)
                .build();

        Product ChronoTrigger = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Chrono Trigger")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SNES)
                .build();

        Product FFVI = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Final Fantasy VI")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SNES)
                .build();

        Product EarthBound = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("EarthBound")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SNES)
                .build();

        Product SecretOfMana = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Secret of Mana")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SNES)
                .build();

        Product MegaManX = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mega Man X")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SNES)
                .build();

        Product FZero = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("F-Zero")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(SNES)
                .build();

        Product KirbySuperStar = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kirby Super Star")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(SNES)
                .build();

        Product SMRPG = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Mario RPG: Legend of the Seven Stars")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SNES)
                .build();

        Product YoshiIsland = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Yoshi's Island")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SNES)
                .build();

        Product StarFox = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Star Fox")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SNES)
                .build();

        Product CastlevaniaIV = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Castlevania IV")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SNES)
                .build();

        Product MKII = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mortal Kombat II")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SNES)
                .build();

        Product ContraIII = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Contra III: The Alien Wars")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(SNES)
                .build();

        Product IllusionOfGaia = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Illusion of Gaia")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SNES)
                .build();

        Product ActRaiser = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("ActRaiser")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SNES)
                .build();

        Product SM64 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Mario 64")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(N64)
                .build();

        Product OOT = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: Ocarina of Time")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(N64)
                .build();

        Product MarioKart64 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario Kart 64")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(N64)
                .build();

        Product GoldenEye = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("GoldenEye 007")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(N64)
                .build();

        Product BanjoKazooie = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Banjo-Kazooie")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(N64)
                .build();

        Product StarFox64 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Star Fox 64")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(N64)
                .build();

        Product MajoraMask = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: Majora's Mask")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(N64)
                .build();

        Product DK64 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Donkey Kong 64")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(N64)
                .build();

        Product PaperMario = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Paper Mario")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(N64)
                .build();

        Product PerfectDark = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Perfect Dark")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(N64)
                .build();

        Product SmashBros = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Smash Bros.")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(N64)
                .build();

        Product FZeroX = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("F-Zero X")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(N64)
                .build();

        Product Conker = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Conker's Bad Fur Day")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(N64)
                .build();

        Product WaveRace = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Wave Race 64")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(N64)
                .build();

        Product Pilotwings64 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pilotwings 64")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(N64)
                .build();

        Product DiddyKong = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Diddy Kong Racing")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(N64)
                .build();

        Product YoshiStory = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Yoshi's Story")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(N64)
                .build();

        Product StarWars = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Star Wars: Rogue Squadron")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(N64)
                .build();

        Product Kirby64 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kirby 64: The Crystal Shards")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(N64)
                .build();

        Product PokemonSnap = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Snap")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(N64)
                .build();

        Product SSBM = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Smash Bros. Melee")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(GameCube)
                .build();

        Product LMansion = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Luigi's Mansion")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(GameCube)
                .build();

        Product WindWaker = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: The Wind Waker")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(GameCube)
                .build();

        Product MKDoubleDash = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario Kart: Double Dash!!")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameCube)
                .build();

        Product MetroidPrime = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Metroid Prime")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(GameCube)
                .build();

        Product Pikmin = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pikmin")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameCube)
                .build();

        Product Sunshine = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Mario Sunshine")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameCube)
                .build();

        Product FireEmblem = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Fire Emblem: Path of Radiance")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameCube)
                .build();

        Product AnimalCrossing = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Animal Crossing")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameCube)
                .build();

        Product PaperMarioTTYD = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Paper Mario: The Thousand-Year Door")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameCube)
                .build();

        Product StarFoxAdventures = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Star Fox Adventures")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(GameCube)
                .build();

        Product ViewtifulJoe = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Viewtiful Joe")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(GameCube)
                .build();

        Product SoulCaliburII = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("SoulCalibur II")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameCube)
                .build();

        Product ResidentEvil4 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Resident Evil 4")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameCube)
                .build();

        Product KirbyAirRide = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kirby Air Ride")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameCube)
                .build();

        Product FZeroGX = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("F-Zero GX")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameCube)
                .build();

        Product BattalionWars = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Battalion Wars")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameCube)
                .build();

        Product SonicAdventure2Battle = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Sonic Adventure 2: Battle")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(GameCube)
                .build();

        Product TalesOfSymphonia = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Tales of Symphonia")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameCube)
                .build();

        Product EternalDarkness = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Eternal Darkness: Sanity's Requiem")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameCube)
                .build();

        Product WiiSports = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Wii Sports")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(Wii)
                .build();

        Product SMGalaxy = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Mario Galaxy")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(Wii)
                .build();

        Product SMGalaxy2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Mario Galaxy 2")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(Wii)
                .build();

        Product MKWii = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario Kart Wii")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(Wii)
                .build();

        Product TwilightPrincess = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: Twilight Princess")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(Wii)
                .build();

        Product SkywardSword = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: Skyward Sword")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(Wii)
                .build();

        Product WiiPlay = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Wii Play")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(Wii)
                .build();

        Product WiiFit = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Wii Fit")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(Wii)
                .build();

        Product DonkeyKongReturns = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Donkey Kong Country Returns")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(Wii)
                .build();

        Product NSMBWii = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("New Super Mario Bros. Wii")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(Wii)
                .build();

        Product XenobladeChronicles = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Xenoblade Chronicles")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(Wii)
                .build();

        Product MetroidPrime3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Metroid Prime 3: Corruption")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(Wii)
                .build();

        Product KirbyEpicYarn = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kirby's Epic Yarn")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(Wii)
                .build();

        Product PunchOutWii = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Punch-Out!!")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(Wii)
                .build();

        Product FireEmblemRadiantDawn = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Fire Emblem: Radiant Dawn")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(Wii)
                .build();

        Product AnimalCrossingCityFolk = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Animal Crossing: City Folk")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(Wii)
                .build();

        Product TheLastStory = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Last Story")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(Wii)
                .build();

        Product SonicColors = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Sonic Colors")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(Wii)
                .build();

        Product MonsterHunterTri = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Monster Hunter Tri")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(Wii)
                .build();

        Product EpicMickey = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Epic Mickey")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(Wii)
                .build();

        Product SM3DWorld = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Mario 3D World")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(WiiU)
                .build();

        Product MK8 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario Kart 8")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(WiiU)
                .build();

        Product BOTW = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: Breath of the Wild")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(WiiU)
                .build();

        Product NSMBU = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("New Super Mario Bros. U")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(WiiU)
                .build();

        Product Splatoon = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Splatoon")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(WiiU)
                .build();

        Product SMashBrosWiiU = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Smash Bros. for WiiU")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(WiiU)
                .build();

        Product XenobladeChroniclesX = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Xenoblade Chronicles X")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(WiiU)
                .build();

        Product Pikmin3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pikmin 3")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(WiiU)
                .build();

        Product DonkeyKongTropicalFreeze = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Donkey Kong Country: Tropical Freeze")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(WiiU)
                .build();

        Product CaptainToad = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Captain Toad: Treasure Tracker")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(WiiU)
                .build();

        Product HyruleWarriors = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Hyrule Warriors")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(WiiU)
                .build();

        Product StarFoxZero = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Star Fox Zero")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(WiiU)
                .build();

        Product Bayonetta2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Bayonetta 2")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(WiiU)
                .build();

        Product TheWonderful101 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Wonderful 101")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(WiiU)
                .build();

        Product PaperMarioColorSplash = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Paper Mario: Color Splash")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(WiiU)
                .build();

        Product YoshiWoollyWorld = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Yoshi's Woolly World")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(WiiU)
                .build();

        Product LegoCityUndercover = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Lego City Undercover")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(WiiU)
                .build();

        Product TokyoMirageSessions = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Tokyo Mirage Sessions #FE")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(WiiU)
                .build();

        Product NintendoLand = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Nintendo Land")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(WiiU)
                .build();

        Product MarioParty10 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario Party 10")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(WiiU)
                .build();


        Product BOTWSwitch = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: Breath of the Wild")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product MK8Deluxe = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario Kart 8 Deluxe")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product SMO = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Mario Odyssey")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product AnimalCrossingNH = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Animal Crossing: New Horizons")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product Splatoon3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Splatoon 3")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product PokemonSword = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Sword")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product PokemonShield = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Shield")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product SmashUltimate = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Smash Bros. Ultimate")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product XenobladeChronicles3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Xenoblade Chronicles 3")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product LuigiMansion3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Luigi's Mansion 3")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product MetroidDread = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Metroid Dread")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product ZeldaTOTK = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: Tears of the Kingdom")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product FireEmblemEngage = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Fire Emblem Engage")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product MarioPartySuperstars = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario Party Superstars")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product HyruleWarriorsAoC = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Hyrule Warriors: Age of Calamity")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product KirbyForgottenLand = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kirby and the Forgotten Land")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product NSMBUDeluxe = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("New Super Mario Bros. U Deluxe")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product PokemonLegendsArceus = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Legends: Arceus")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product Bayonetta3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Bayonetta 3")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();

        Product Pikmin4 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pikmin 4")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(Switch)
                .build();


        Product FFVII = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Final Fantasy VII")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(PS1)
                .build();

        Product MGS = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Metal Gear Solid")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(PS1)
                .build();

        Product ResidentEvil = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Resident Evil")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(PS1)
                .build();

        Product CrashBandicoot = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Crash Bandicoot")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PS1)
                .build();

        Product SpyroTheDragon = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Spyro the Dragon")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(PS1)
                .build();

        Product Tekken3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Tekken 3")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PS1)
                .build();

        Product GranTurismo = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Gran Turismo")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PS1)
                .build();

        Product TombRaider = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Tomb Raider")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PS1)
                .build();

        Product SilentHill = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Silent Hill")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PS1)
                .build();

        Product CastlevaniaSOTN = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Castlevania: Symphony of the Night")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PS1)
                .build();

        Product THPS = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Tony Hawk's Pro Skater")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(PS1)
                .build();

        Product DinoCrisis = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Dino Crisis")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(PS1)
                .build();

        Product VagrantStory = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Vagrant Story")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PS1)
                .build();

        Product ParasiteEve = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Parasite Eve")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PS1)
                .build();

        Product ChronoCross = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Chrono Cross")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PS1)
                .build();

        Product RidgeRacer = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Ridge Racer")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PS1)
                .build();

        Product OddworldAbe = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Oddworld: Abe's Oddysee")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PS1)
                .build();

        Product LegacyOfKain = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Legacy of Kain: Soul Reaver")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(PS1)
                .build();

        Product Driver = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Driver")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PS1)
                .build();

        Product ApeEscape = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Ape Escape")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PS1)
                .build();


        Product PokemonRed = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Red")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(GameBoy)
                .build();

        Product PokemonBlue = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Blue")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(GameBoy)
                .build();

        Product TetrisGB = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Tetris")
                .productSalePrice(29.99)
                .productQuantity(60)
                .console(GameBoy)
                .build();

        Product SuperMarioLand = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Mario Land")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(GameBoy)
                .build();

        Product ZeldaLA = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: Link's Awakening")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(GameBoy)
                .build();

        Product KirbyDreamLand = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kirby's Dream Land")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameBoy)
                .build();

        Product DonkeyKongGB = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Donkey Kong")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(GameBoy)
                .build();

        Product MetroidII = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Metroid II: Return of Samus")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoy)
                .build();

        Product WarioLand = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Wario Land: Super Mario Land 3")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(GameBoy)
                .build();

        Product MegaManDrWily = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mega Man: Dr. Wily's Revenge")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameBoy)
                .build();

        Product FinalFantasyAdventure = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Final Fantasy Adventure")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoy)
                .build();

        Product DuckTalesGB = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("DuckTales")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameBoy)
                .build();

        Product BalloonKid = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Balloon Kid")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoy)
                .build();

        Product DrMarioGB = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Dr. Mario")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(GameBoy)
                .build();

        Product GargoyleQuest = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Gargoyle's Quest")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoy)
                .build();

        Product WaveRaceGB = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Wave Race")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameBoy)
                .build();

        Product CastlevaniaAdventure = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Castlevania: The Adventure")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoy)
                .build();

        Product MarioPicross = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario's Picross")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameBoy)
                .build();

        Product AdventureIslandGB = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Adventure Island")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoy)
                .build();

        Product StarWarsGB = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Star Wars")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameBoy)
                .build();

        Product PokemonGold = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Gold")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(GameBoyColor)
                .build();

        Product PokemonSilver = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Silver")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(GameBoyColor)
                .build();

        Product ZeldaOracleSeasons = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: Oracle of Seasons")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(GameBoyColor)
                .build();

        Product ZeldaOracleAges = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: Oracle of Ages")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameBoyColor)
                .build();

        Product SuperMarioBrosDeluxe = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Mario Bros. Deluxe")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(GameBoyColor)
                .build();

        Product TetrisDX = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Tetris DX")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(GameBoyColor)
                .build();

        Product WarioLandII = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Wario Land II")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameBoyColor)
                .build();

        Product DonkeyKongCountry = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Donkey Kong Country")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoyColor)
                .build();

        Product PokemonCrystal = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Crystal")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoyColor)
                .build();

        Product HarvestMoonGBC = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Harvest Moon GBC")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameBoyColor)
                .build();

        Product DragonQuestIII = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Dragon Quest III")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(GameBoyColor)
                .build();

        Product KirbyTiltTumble = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kirby Tilt 'n' Tumble")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoyColor)
                .build();

        Product MetalGearSolidGBC = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Metal Gear Solid")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameBoyColor)
                .build();

        Product MarioGolf = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario Golf")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameBoyColor)
                .build();

        Product MarioTennis = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario Tennis")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameBoyColor)
                .build();

        Product Shantae = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Shantae")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoyColor)
                .build();

        Product MegaManXtreme = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mega Man Xtreme")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoyColor)
                .build();

        Product RaymanGBC = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Rayman")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameBoyColor)
                .build();

        Product BombermanMax = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Bomberman Max")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoyColor)
                .build();

        Product RTypeDX = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("R-Type DX")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameBoyColor)
                .build();


        Product PokemonRuby = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Ruby")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(GameBoyAdvance)
                .build();

        Product PokemonSapphire = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Sapphire")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(GameBoyAdvance)
                .build();

        Product ZeldaMinishCap = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: The Minish Cap")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(GameBoyAdvance)
                .build();

        Product MetroidFusion = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Metroid Fusion")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameBoyAdvance)
                .build();

        Product MetroidZeroMission = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Metroid: Zero Mission")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(GameBoyAdvance)
                .build();

        Product MarioKartSuperCircuit = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario Kart: Super Circuit")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(GameBoyAdvance)
                .build();

        Product SuperMarioAdvance = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Mario Advance")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameBoyAdvance)
                .build();

        Product GoldenSun = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Golden Sun")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoyAdvance)
                .build();

        Product AdvanceWars = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Advance Wars")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoyAdvance)
                .build();

        Product FireEmblemGBA = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Fire Emblem")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameBoyAdvance)
                .build();

        Product CastlevaniaAria = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Castlevania: Aria of Sorrow")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(GameBoyAdvance)
                .build();

        Product CastlevaniaHarmony = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Castlevania: Harmony of Dissonance")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoyAdvance)
                .build();

        Product WarioWare = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("WarioWare, Inc.: Mega Microgame$")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameBoyAdvance)
                .build();

        Product FinalFantasyTacticsAdvance = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Final Fantasy Tactics Advance")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameBoyAdvance)
                .build();

        Product SonicAdvance = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Sonic Advance")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameBoyAdvance)
                .build();

        Product MegaManBattleNetwork = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mega Man Battle Network")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoyAdvance)
                .build();

        Product KirbyNightmare = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kirby: Nightmare in Dream Land")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoyAdvance)
                .build();

        Product DonkeyKongKingSwing = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Donkey Kong: King of Swing")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameBoyAdvance)
                .build();

        Product PokemonFireRed = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon FireRed")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoyAdvance)
                .build();

        Product PokemonLeafGreen = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon LeafGreen")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameBoyAdvance)
                .build();


        Product PokemonEmerald = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Emerald")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(GameBoyAdvanceSP)
                .build();

        Product MarioLuigiSuperstarSaga = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario & Luigi: Superstar Saga")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(GameBoyAdvanceSP)
                .build();

        Product ZeldaFourSwords = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: A Link to the Past & Four Swords")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(GameBoyAdvanceSP)
                .build();

        Product MetroidZeroMissionSP = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Metroid: Zero Mission")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameBoyAdvanceSP)
                .build();

        Product GoldenSunTheLostAge = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Golden Sun: The Lost Age")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(GameBoyAdvanceSP)
                .build();

        Product FinalFantasyIVAdvance = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Final Fantasy IV Advance")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(GameBoyAdvanceSP)
                .build();

        Product SonicAdvance2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Sonic Advance 2")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameBoyAdvanceSP)
                .build();

        Product WarioLand4 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Wario Land 4")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoyAdvanceSP)
                .build();

        Product FireEmblemSacredStones = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Fire Emblem: The Sacred Stones")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoyAdvanceSP)
                .build();

        Product PokemonMysteryDungeon = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Mystery Dungeon: Red Rescue Team")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameBoyAdvanceSP)
                .build();

        Product CastlevaniaCircleMoon = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Castlevania: Circle of the Moon")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(GameBoyAdvanceSP)
                .build();

        Product AdvanceWars2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Advance Wars 2: Black Hole Rising")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoyAdvanceSP)
                .build();

        Product MegaManBattleNetwork2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mega Man Battle Network 2")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameBoyAdvanceSP)
                .build();

        Product KingdomHeartsCoM = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kingdom Hearts: Chain of Memories")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameBoyAdvanceSP)
                .build();

        Product HarvestMoonFriendsMineralTown = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Harvest Moon: Friends of Mineral Town")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameBoyAdvanceSP)
                .build();

        Product KirbyAmazingMirror = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kirby & The Amazing Mirror")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoyAdvanceSP)
                .build();

        Product DonkeyKongCountrySP = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Donkey Kong Country")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoyAdvanceSP)
                .build();

        Product PokemonPinballRS = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Pinball: Ruby & Sapphire")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(GameBoyAdvanceSP)
                .build();

        Product MarioPartyAdvance = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario Party Advance")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(GameBoyAdvanceSP)
                .build();

        Product YuGiOhEternalDuelist = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Yu-Gi-Oh! The Eternal Duelist Soul")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(GameBoyAdvanceSP)
                .build();


        Product PokemonDiamond = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Diamond")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(DS)
                .build();

        Product PokemonPearl = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Pearl")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(DS)
                .build();

        Product NewSuperMarioBros = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("New Super Mario Bros.")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(DS)
                .build();

        Product MarioKartDS = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario Kart DS")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(DS)
                .build();

        Product ZeldaPH = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: Phantom Hourglass")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(DS)
                .build();

        Product ZeldaST = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: Spirit Tracks")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(DS)
                .build();

        Product AnimalCrossingWW = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Animal Crossing: Wild World")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(DS)
                .build();

        Product ProfessorLaytonCuriousVillage = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Professor Layton and the Curious Village")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(DS)
                .build();

        Product KirbySqueakSquad = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kirby: Squeak Squad")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(DS)
                .build();

        Product MetroidPrimeHunters = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Metroid Prime: Hunters")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(DS)
                .build();

        Product FireEmblemShadowDragon = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Fire Emblem: Shadow Dragon")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(DS)
                .build();

        Product ChronoTriggerDS = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Chrono Trigger DS")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(DS)
                .build();

        Product CastlevaniaDawnOfSorrow = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Castlevania: Dawn of Sorrow")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(DS)
                .build();

        Product AdvanceWarsDualStrike = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Advance Wars: Dual Strike")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(DS)
                .build();

        Product FinalFantasyIVDS = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Final Fantasy IV DS")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(DS)
                .build();

        Product DragonQuestIX = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Dragon Quest IX: Sentinels of the Starry Skies")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(DS)
                .build();

        Product Nintendogs = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Nintendogs")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(DS)
                .build();

        Product PokemonMysteryDungeonBlue = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Mystery Dungeon: Blue Rescue Team")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(DS)
                .build();

        Product MarioLuigiPartnersInTime = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario & Luigi: Partners in Time")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(DS)
                .build();

        Product PhoenixWrightAceAttorney = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Phoenix Wright: Ace Attorney")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(DS)
                .build();


        Product PokemonBlack = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Black")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(DSi)
                .build();

        Product PokemonWhite = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon White")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(DSi)
                .build();

        Product NewSuperMarioBrosDSi = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("New Super Mario Bros.")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(DSi)
                .build();

        Product MarioPartyDS = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario Party DS")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(DSi)
                .build();

        Product ZeldaSpiritTracksDSi = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: Spirit Tracks")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(DSi)
                .build();

        Product AnimalCrossingWildWorldDSi = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Animal Crossing: Wild World")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(DSi)
                .build();

        Product ProfessorLaytonPandorasBox = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Professor Layton and the Pandora's Box")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(DSi)
                .build();

        Product KirbyMassAttack = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kirby Mass Attack")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(DSi)
                .build();

        Product PokemonMysteryDungeonExplorersSky = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Mystery Dungeon: Explorers of Sky")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(DSi)
                .build();

        Product MetroidPrimeHuntersDSi = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Metroid Prime: Hunters")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(DSi)
                .build();

        Product FireEmblemShadowDragonDSi = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Fire Emblem: Shadow Dragon")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(DSi)
                .build();

        Product CastlevaniaOrderOfEcclesia = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Castlevania: Order of Ecclesia")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(DSi)
                .build();

        Product AdvanceWarsDaysOfRuin = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Advance Wars: Days of Ruin")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(DSi)
                .build();

        Product DragonQuestVI = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Dragon Quest VI: Realms of Revelation")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(DSi)
                .build();

        Product FinalFantasyTacticsA2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Final Fantasy Tactics A2: Grimoire of the Rift")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(DSi)
                .build();

        Product ChronoTriggerDSi = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Chrono Trigger")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(DSi)
                .build();

        Product NintendogsDSi = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Nintendogs")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(DSi)
                .build();

        Product PhoenixWrightJusticeForAll = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Phoenix Wright: Ace Attorney - Justice for All")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(DSi)
                .build();

        Product MarioLuigiBowserInsideStory = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario & Luigi: Bowser's Inside Story")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(DSi)
                .build();

        Product PokemonRangerShadowsAlmia = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Ranger: Shadows of Almia")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(DSi)
                .build();


        Product PokemonX = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon X")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(DS3D)
                .build();

        Product PokemonY = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Y")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(DS3D)
                .build();

        Product ZeldaOOT3D = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: Ocarina of Time 3D")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(DS3D)
                .build();

        Product Mario3DLand = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Mario 3D Land")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(DS3D)
                .build();

        Product MarioKart7 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario Kart 7")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(DS3D)
                .build();

        Product FireEmblemAwakening = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Fire Emblem Awakening")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(DS3D)
                .build();

        Product AnimalCrossingNewLeaf = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Animal Crossing: New Leaf")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(DS3D)
                .build();

        Product ZeldaALBW = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: A Link Between Worlds")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(DS3D)
                .build();

        Product PokemonSun = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Sun")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(DS3D)
                .build();

        Product PokemonMoon = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Moon")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(DS3D)
                .build();

        Product SmashBros3DS = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Smash Bros. for Nintendo 3DS")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(DS3D)
                .build();

        Product KirbyPlanetRobobot = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kirby: Planet Robobot")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(DS3D)
                .build();

        Product MetroidSamusReturns = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Metroid: Samus Returns")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(DS3D)
                .build();

        Product XenobladeChronicles3D = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Xenoblade Chronicles 3D")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(DS3D)
                .build();

        Product LuigiMansionDarkMoon = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Luigi's Mansion: Dark Moon")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(DS3D)
                .build();

        Product ZeldaTriForceHeroes = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: Tri Force Heroes")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(DS3D)
                .build();

        Product MonsterHunter4Ultimate = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Monster Hunter 4 Ultimate")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(DS3D)
                .build();

        Product BravelyDefault = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Bravely Default")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(DS3D)
                .build();

        Product DragonQuestVIII = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Dragon Quest VIII: Journey of the Cursed King")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(DS3D)
                .build();

        Product PokemonOmegaRuby = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Omega Ruby")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(DS3D)
                .build();


        Product XenobladeChroniclesNEW3D = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Xenoblade Chronicles 3D")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(New3DS)
                .build();

        Product PokemonUltraSun = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Ultra Sun")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(New3DS)
                .build();

        Product PokemonUltraMoon = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Ultra Moon")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(New3DS)
                .build();

        Product FireEmblemFatesBirthright = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Fire Emblem Fates: Birthright")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(New3DS)
                .build();

        Product FireEmblemFatesConquest = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Fire Emblem Fates: Conquest")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(New3DS)
                .build();

        Product MajoraMask3D = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Legend of Zelda: Majora's Mask 3D")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(New3DS)
                .build();

        Product SuperMarioMaker3DS = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Mario Maker for Nintendo 3DS")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(New3DS)
                .build();

        Product PokemonSunNew3DS = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Sun")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(New3DS)
                .build();

        Product PokemonMoonNew3DS = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Pokémon Moon")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(New3DS)
                .build();

        Product KirbyPlanetRobobotNew3DS = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kirby: Planet Robobot")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(New3DS)
                .build();

        Product HyruleWarriorsLegends = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Hyrule Warriors: Legends")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(New3DS)
                .build();

        Product SmashBrosNew3DS = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Super Smash Bros. for Nintendo 3DS")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(New3DS)
                .build();

        Product DragonQuestVII = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Dragon Quest VII: Fragments of the Forgotten Past")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(New3DS)
                .build();

        Product MetroidSamusReturnsNew3DS = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Metroid: Samus Returns")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(New3DS)
                .build();

        Product MarioLuigiPaperJam = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mario & Luigi: Paper Jam")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(New3DS)
                .build();

        Product LuigiMansionNew3DS = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Luigi's Mansion")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(New3DS)
                .build();

        Product BravelySecondEndLayer = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Bravely Second: End Layer")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(New3DS)
                .build();

        Product DetectivePikachu = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Detective Pikachu")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(New3DS)
                .build();

        Product EverOasis = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Ever Oasis")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(New3DS)
                .build();

        Product YoKaiWatch3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Yo-Kai Watch 3")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(New3DS)
                .build();


        Product GTA3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Grand Theft Auto III")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(PS2)
                .build();

        Product GTAViceCity = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Grand Theft Auto: Vice City")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(PS2)
                .build();

        Product GTASanAndreas = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Grand Theft Auto: San Andreas")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(PS2)
                .build();

        Product FF10 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Final Fantasy X")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PS2)
                .build();

        Product FF12 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Final Fantasy XII")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(PS2)
                .build();

        Product MGS2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Metal Gear Solid 2: Sons of Liberty")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(PS2)
                .build();

        Product MGS3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Metal Gear Solid 3: Snake Eater")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PS2)
                .build();

        Product GodOfWar = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("God of War")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PS2)
                .build();

        Product GodOfWar2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("God of War II")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PS2)
                .build();

        Product ShadowOfColossus = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Shadow of the Colossus")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PS2)
                .build();

        Product KingdomHearts = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kingdom Hearts")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(PS2)
                .build();

        Product KingdomHearts2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kingdom Hearts II")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PS2)
                .build();

        Product DevilMayCry = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Devil May Cry")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PS2)
                .build();

        Product DevilMayCry3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Devil May Cry 3: Dante's Awakening")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PS2)
                .build();

        Product JakAndDaxter = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Jak and Daxter: The Precursor Legacy")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PS2)
                .build();

        Product RatchetAndClank = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Ratchet & Clank")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PS2)
                .build();

        Product SilentHill2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Silent Hill 2")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PS2)
                .build();

        Product SilentHill3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Silent Hill 3")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PS2)
                .build();

        Product GranTurismo4 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Gran Turismo 4")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PS2)
                .build();

        Product Bully = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Bully")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PS2)
                .build();


        Product Uncharted1 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Uncharted: Drake's Fortune")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(PS3)
                .build();

        Product Uncharted2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Uncharted 2: Among Thieves")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(PS3)
                .build();

        Product Uncharted3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Uncharted 3: Drake's Deception")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(PS3)
                .build();

        Product TheLastOfUs = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Last of Us")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PS3)
                .build();

        Product GTA5 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Grand Theft Auto V")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(PS3)
                .build();

        Product RedDeadRedemption = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Red Dead Redemption")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(PS3)
                .build();

        Product GodOfWar3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("God of War III")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PS3)
                .build();

        Product HeavyRain = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Heavy Rain")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PS3)
                .build();

        Product LittleBigPlanet = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("LittleBigPlanet")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PS3)
                .build();

        Product LittleBigPlanet2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("LittleBigPlanet 2")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PS3)
                .build();

        Product Bioshock = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("BioShock")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(PS3)
                .build();

        Product BioshockInfinite = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("BioShock Infinite")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PS3)
                .build();

        Product Infamous = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("inFAMOUS")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PS3)
                .build();

        Product Infamous2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("inFAMOUS 2")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PS3)
                .build();

        Product Killzone2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Killzone 2")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PS3)
                .build();

        Product Killzone3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Killzone 3")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PS3)
                .build();

        Product MetalGearSolid4 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Metal Gear Solid 4: Guns of the Patriots")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PS3)
                .build();

        Product ResistanceFallOfMan = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Resistance: Fall of Man")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PS3)
                .build();

        Product Resistance3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Resistance 3")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PS3)
                .build();

        Product Skyrim = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Elder Scrolls V: Skyrim")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PS3)
                .build();


        Product GodOfWarPS4 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("God of War")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product SpiderManPS4 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Marvel's Spider-Man")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product TheLastOfUsPartII = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Last of Us Part II")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product HorizonZeroDawn = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Horizon Zero Dawn")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product Bloodborne = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Bloodborne")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product GhostOfTsushima = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Ghost of Tsushima")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product Uncharted4 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Uncharted 4: A Thief's End")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product RatchetClankPS4 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Ratchet & Clank")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product DeathStranding = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Death Stranding")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product DaysGone = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Days Gone")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product Persona5 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Persona 5")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product FinalFantasyXV = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Final Fantasy XV")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product ResidentEvil2Remake = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Resident Evil 2 Remake")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product Sekiro = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Sekiro: Shadows Die Twice")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product RedDeadRedemption2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Red Dead Redemption 2")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product Cyberpunk2077 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Cyberpunk 2077")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product Nioh = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Nioh")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product ShadowOfTheColossusPS4 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Shadow of the Colossus")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product DarkSouls3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Dark Souls III")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();

        Product MonsterHunterWorld = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Monster Hunter: World")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(PS4)
                .build();


        Product DemonsSoulsPS5 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Demon's Souls")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product SpiderManMilesMorales = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Spider-Man: Miles Morales")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product Returnal = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Returnal")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product RatchetClankRiftApart = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Ratchet & Clank: Rift Apart")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product HorizonForbiddenWest = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Horizon Forbidden West")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product GodOfWarRagnarok = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("God of War: Ragnarök")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product EldenRing = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Elden Ring")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product FinalFantasyXVI = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Final Fantasy XVI")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product GhostwireTokyo = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Ghostwire: Tokyo")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product ResidentEvilVillage = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Resident Evil Village")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product Deathloop = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Deathloop")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product Cyberpunk2077PS5 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Cyberpunk 2077")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product HogwartsLegacy = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Hogwarts Legacy")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product CallOfDutyMWII = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Call of Duty: Modern Warfare II")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product NBA2K24 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("NBA 2K24")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product FIFA23 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("FIFA 23")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product GranTurismo7 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Gran Turismo 7")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product AssassinCreedValhalla = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Assassin's Creed Valhalla")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product DiabloIV = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Diablo IV")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();

        Product StreetFighter6 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Street Fighter 6")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(PS5)
                .build();


        Product GodOfWarChainsOfOlympus = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("God of War: Chains of Olympus")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(PSP)
                .build();

        Product GodOfWarGhostOfSparta = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("God of War: Ghost of Sparta")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(PSP)
                .build();

        Product CrisisCoreFF7 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Crisis Core: Final Fantasy VII")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(PSP)
                .build();

        Product MetalGearSolidPeaceWalker = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Metal Gear Solid: Peace Walker")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PSP)
                .build();

        Product MonsterHunterFreedom = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Monster Hunter Freedom")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(PSP)
                .build();

        Product MonsterHunterFreedomUnite = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Monster Hunter Freedom Unite")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(PSP)
                .build();

        Product KingdomHeartsBirthBySleep = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Kingdom Hearts: Birth by Sleep")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PSP)
                .build();

        Product Daxter = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Daxter")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PSP)
                .build();

        Product GTAChinatownWars = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Grand Theft Auto: Chinatown Wars")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PSP)
                .build();

        Product GTAViceCityStories = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Grand Theft Auto: Vice City Stories")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PSP)
                .build();

        Product Patapon = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Patapon")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(PSP)
                .build();

        Product Patapon2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Patapon 2")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PSP)
                .build();

        Product ResistanceRetribution = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Resistance: Retribution")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PSP)
                .build();

        Product LocoRoco = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("LocoRoco")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PSP)
                .build();

        Product LocoRoco2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("LocoRoco 2")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PSP)
                .build();

        Product FinalFantasyTacticsWarOfLions = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Final Fantasy Tactics: The War of the Lions")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PSP)
                .build();

        Product JeanneDArc = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Jeanne d'Arc")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PSP)
                .build();

        Product SoulCaliburBrokenDestiny = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("SoulCalibur: Broken Destiny")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PSP)
                .build();

        Product TekkenDarkResurrection = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Tekken: Dark Resurrection")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PSP)
                .build();

        Product Persona3Portable = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Persona 3 Portable")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PSP)
                .build();


        Product UnchartedGoldenAbyss = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Uncharted: Golden Abyss")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(PSVita)
                .build();

        Product Persona4Golden = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Persona 4 Golden")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(PSVita)
                .build();

        Product GravityRush = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Gravity Rush")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(PSVita)
                .build();

        Product KillzoneMercenary = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Killzone: Mercenary")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PSVita)
                .build();

        Product Tearaway = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Tearaway")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(PSVita)
                .build();

        Product LittleBigPlanetPSVita = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("LittleBigPlanet PS Vita")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(PSVita)
                .build();

        Product FreedomWars = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Freedom Wars")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PSVita)
                .build();

        Product SoulSacrifice = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Soul Sacrifice")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PSVita)
                .build();

        Product SoulSacrificeDelta = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Soul Sacrifice Delta")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PSVita)
                .build();

        Product Wipeout2048 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Wipeout 2048")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PSVita)
                .build();

        Product DanganronpaTriggerHappyHavoc = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Danganronpa: Trigger Happy Havoc")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(PSVita)
                .build();

        Product Danganronpa2GoodbyeDespair = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Danganronpa 2: Goodbye Despair")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PSVita)
                .build();

        Product TokyoXanadu = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Tokyo Xanadu")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PSVita)
                .build();

        Product FinalFantasyXHDRemaster = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Final Fantasy X HD Remaster")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PSVita)
                .build();

        Product FinalFantasyX2HDRemaster = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Final Fantasy X-2 HD Remaster")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PSVita)
                .build();

        Product RaymanLegends = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Rayman Legends")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PSVita)
                .build();

        Product OdinSphereLeifthrasir = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Odin Sphere Leifthrasir")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PSVita)
                .build();

        Product YsMemoriesOfCelceta = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Ys: Memories of Celceta")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(PSVita)
                .build();

        Product DragonQuestBuilders = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Dragon Quest Builders")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(PSVita)
                .build();

        Product MinecraftPSVita = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Minecraft: PlayStation Vita Edition")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(PSVita)
                .build();


        Product HaloCE = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Halo: Combat Evolved")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(Xbox)
                .build();

        Product Halo2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Halo 2")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(Xbox)
                .build();

        Product Fable = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Fable")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(Xbox)
                .build();

        Product StarWarsKOTOR = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Star Wars: Knights of the Old Republic")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(Xbox)
                .build();

        Product StarWarsKOTOR2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Star Wars: Knights of the Old Republic II")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(Xbox)
                .build();

        Product ForzaMotorsport = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Forza Motorsport")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(Xbox)
                .build();

        Product NinjaGaidenBlack = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Ninja Gaiden Black")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(Xbox)
                .build();

        Product JadeEmpire = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Jade Empire")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(Xbox)
                .build();

        Product SplinterCell = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Tom Clancy's Splinter Cell")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(Xbox)
                .build();

        Product SplinterCellChaosTheory = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Tom Clancy's Splinter Cell: Chaos Theory")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(Xbox)
                .build();

        Product Burnout3Takedown = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Burnout 3: Takedown")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(Xbox)
                .build();

        Product CrimsonSkies = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Crimson Skies: High Road to Revenge")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(Xbox)
                .build();

        Product TheElderScrollsMorrowind = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Elder Scrolls III: Morrowind")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(Xbox)
                .build();

        Product Doom3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Doom 3")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(Xbox)
                .build();

        Product HalfLife2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Half-Life 2")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(Xbox)
                .build();

        Product DeadOrAlive3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Dead or Alive 3")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(Xbox)
                .build();

        Product ProjectGothamRacing2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Project Gotham Racing 2")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(Xbox)
                .build();

        Product TimeSplitters2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("TimeSplitters 2")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(Xbox)
                .build();

        Product PrinceOfPersiaSandsOfTime = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Prince of Persia: The Sands of Time")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(Xbox)
                .build();

        Product Black = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Black")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(Xbox)
                .build();


        Product Halo3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Halo 3")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(Xbox360)
                .build();

        Product HaloReach = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Halo: Reach")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(Xbox360)
                .build();

        Product GearsOfWar = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Gears of War")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(Xbox360)
                .build();

        Product GearsOfWar2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Gears of War 2")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(Xbox360)
                .build();

        Product RedDeadRedemption360 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Red Dead Redemption")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(Xbox360)
                .build();

        Product GTA5Xbox360 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Grand Theft Auto V")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(Xbox360)
                .build();

        Product CallOfDuty4 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Call of Duty 4: Modern Warfare")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(Xbox360)
                .build();

        Product CallOfDutyMW2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Call of Duty: Modern Warfare 2")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(Xbox360)
                .build();

        Product SkyrimXbox360 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Elder Scrolls V: Skyrim")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(Xbox360)
                .build();

        Product Fallout3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Fallout 3")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(Xbox360)
                .build();

        Product FalloutNewVegas = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Fallout: New Vegas")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(Xbox360)
                .build();

        Product MassEffect = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mass Effect")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(Xbox360)
                .build();

        Product MassEffect2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mass Effect 2")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(Xbox360)
                .build();

        Product BioshockXbox360 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("BioShock")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(Xbox360)
                .build();

        Product BioshockInfinite360 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("BioShock Infinite")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(Xbox360)
                .build();

        Product ForzaHorizon = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Forza Horizon")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(Xbox360)
                .build();

        Product ForzaMotorsport4 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Forza Motorsport 4")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(Xbox360)
                .build();

        Product BatmanArkhamAsylum = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Batman: Arkham Asylum")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(Xbox360)
                .build();

        Product BatmanArkhamCity = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Batman: Arkham City")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(Xbox360)
                .build();

        Product AssassinCreed2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Assassin's Creed II")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(Xbox360)
                .build();

        Product Halo5Guardians = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Halo 5: Guardians")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product HaloMasterChiefCollection = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Halo: The Master Chief Collection")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product ForzaHorizon4 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Forza Horizon 4")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product ForzaMotorsport7 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Forza Motorsport 7")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product GearsOfWar4 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Gears of War 4")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product Gears5 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Gears 5")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product SeaOfThieves = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Sea of Thieves")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product OriBlindForest = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Ori and the Blind Forest")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product OriWillWisps = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Ori and the Will of the Wisps")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product SunsetOverdrive = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Sunset Overdrive")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product QuantumBreak = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Quantum Break")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product RiseOfTheTombRaider = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Rise of the Tomb Raider")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product TheWitcher3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Witcher 3: Wild Hunt")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product RedDeadRedemption2XOne = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Red Dead Redemption 2")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product GTA5XOne = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Grand Theft Auto V")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product Cyberpunk2077XOne = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Cyberpunk 2077")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product AssassinCreedValhallaXOne = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Assassin's Creed Valhalla")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product FIFA23XOne = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("FIFA 23")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product CallOfDutyWarzone = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Call of Duty: Warzone")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product DoomEternalXOne = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Doom Eternal")
                .productSalePrice(29.99)
                .productQuantity(100)
                .console(XboxOne)
                .build();

        Product HaloInfinite = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Halo Infinite")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product ForzaHorizon5 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Forza Horizon 5")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product MicrosoftFlightSimulator = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Microsoft Flight Simulator")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product Gears5SeriesX = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Gears 5")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product FableReboot = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Fable (Reboot)")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product Starfield = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Starfield")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product Redfall = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Redfall")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product TheMedium = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Medium")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product Psychonauts2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Psychonauts 2")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product Hellblade2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Hellblade II: Senua's Saga")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product AssassinCreedMirageSeriesX = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Assassin's Creed Mirage")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product CallOfDutyMWIII = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Call of Duty: Modern Warfare III")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product Cyberpunk2077PhantomLiberty = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Cyberpunk 2077: Phantom Liberty")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product ResidentEvil4Remake = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Resident Evil 4 Remake")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product EldenRingSeriesX = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Elden Ring")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product HogwartsLegacySeriesX = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Hogwarts Legacy")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product DiabloIVSeriesX = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Diablo IV")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product StreetFighter6SeriesX = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Street Fighter 6")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product NBA2K24SeriesX = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("NBA 2K24")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product ForzaMotorsport2023 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Forza Motorsport 2023")
                .productSalePrice(79.99)
                .productQuantity(100)
                .console(XboxSeriesX)
                .build();

        Product SonicTheHedgehogMasterSystem = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Sonic the Hedgehog")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(SegaMasterSystem)
                .build();

        Product AlexKiddInMiracleWorld = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Alex Kidd in Miracle World")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(SegaMasterSystem)
                .build();

        Product WonderBoyIII = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Wonder Boy III: The Dragon's Trap")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(SegaMasterSystem)
                .build();

        Product PhantasyStar = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Phantasy Star")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SegaMasterSystem)
                .build();

        Product GoldenAxeWarrior = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Golden Axe Warrior")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(SegaMasterSystem)
                .build();

        Product Shinobi = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Shinobi")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(SegaMasterSystem)
                .build();

        Product CastleOfIllusion = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Castle of Illusion Starring Mickey Mouse")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SegaMasterSystem)
                .build();

        Product OutRun = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("OutRun")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaMasterSystem)
                .build();

        Product AlteredBeast = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Altered Beast")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaMasterSystem)
                .build();

        Product SpaceHarrier = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Space Harrier")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SegaMasterSystem)
                .build();

        Product TheNinja = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The Ninja")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(SegaMasterSystem)
                .build();

        Product FantasyZone = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Fantasy Zone")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaMasterSystem)
                .build();

        Product BlackBelt = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Black Belt")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SegaMasterSystem)
                .build();

        Product WonderBoy = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Wonder Boy")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SegaMasterSystem)
                .build();

        Product Zillion = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Zillion")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SegaMasterSystem)
                .build();


        Product RType = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("R-Type")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaMasterSystem)
                .build();

        Product Choplifter = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Choplifter")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SegaMasterSystem)
                .build();

        Product PenguinLand = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Penguin Land")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaMasterSystem)
                .build();

        Product GhoulsNGhosts = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Ghouls 'n Ghosts")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SegaMasterSystem)
                .build();

        Product SonicTheHedgehogGenesis = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Sonic the Hedgehog")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(SegaGenesis)
                .build();

        Product SonicTheHedgehog2Genesis = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Sonic the Hedgehog 2")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(SegaGenesis)
                .build();

        Product StreetsOfRageGenesis = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Streets of Rage")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(SegaGenesis)
                .build();

        Product StreetsOfRage2Genesis = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Streets of Rage 2")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SegaGenesis)
                .build();

        Product GoldenAxeGenesis = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Golden Axe")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(SegaGenesis)
                .build();

        Product AlteredBeastGenesis = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Altered Beast")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(SegaGenesis)
                .build();

        Product Shinobi3Genesis = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Shinobi III: Return of the Ninja Master")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SegaGenesis)
                .build();

        Product GunstarHeroesGenesis = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Gunstar Heroes")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaGenesis)
                .build();

        Product PhantasyStarIVGenesis = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Phantasy Star IV")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaGenesis)
                .build();

        Product CastlevaniaBloodlines = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Castlevania: Bloodlines")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SegaGenesis)
                .build();

        Product EarthwormJimGenesis = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Earthworm Jim")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(SegaGenesis)
                .build();

        Product ComixZone = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Comix Zone")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaGenesis)
                .build();

        Product ToeJamAndEarl = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("ToeJam & Earl")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SegaGenesis)
                .build();

        Product ContraHardCorps = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Contra: Hard Corps")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SegaGenesis)
                .build();

        Product Ristar = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Ristar")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SegaGenesis)
                .build();

        Product AladdinGenesis = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Disney's Aladdin")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaGenesis)
                .build();

        Product MortalKombatGenesis = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Mortal Kombat")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaGenesis)
                .build();

        Product ThunderForceIV = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Thunder Force IV")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SegaGenesis)
                .build();

        Product ShadowDancerGenesis = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Shadow Dancer: The Secret of Shinobi")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaGenesis)
                .build();

        Product SonicAndKnuckles = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Sonic & Knuckles")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SegaGenesis)
                .build();

        Product NightsIntoDreams = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("NiGHTS into Dreams")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(SegaSaturn)
                .build();

        Product PanzerDragoon = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Panzer Dragoon")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(SegaSaturn)
                .build();

        Product PanzerDragoonSaga = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Panzer Dragoon Saga")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaSaturn)
                .build();

        Product VirtuaFighter2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Virtua Fighter 2")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(SegaSaturn)
                .build();

        Product SegaRallyChampionship = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Sega Rally Championship")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SegaSaturn)
                .build();

        Product DaytonaUSA = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Daytona USA")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(SegaSaturn)
                .build();

        Product ShiningForceIII = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Shining Force III")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaSaturn)
                .build();

        Product BurningRangers = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Burning Rangers")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SegaSaturn)
                .build();

        Product SonicJam = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Sonic Jam")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SegaSaturn)
                .build();

        Product GuardianHeroes = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Guardian Heroes")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SegaSaturn)
                .build();

        Product DragonForce = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Dragon Force")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaSaturn)
                .build();

        Product FightersMegamix = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Fighters Megamix")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SegaSaturn)
                .build();

        Product ResidentEvilSaturn = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Resident Evil")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(SegaSaturn)
                .build();

        Product TombRaiderSaturn = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Tomb Raider")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SegaSaturn)
                .build();

        Product SonicR = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Sonic R")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaSaturn)
                .build();

        Product VirtuaCop2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Virtua Cop 2")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaSaturn)
                .build();

        Product RadiantSilvergun = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Radiant Silvergun")
                .productSalePrice(29.99)
                .productQuantity(20)
                .console(SegaSaturn)
                .build();

        Product StreetFighterAlpha3 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Street Fighter Alpha 3")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SegaSaturn)
                .build();

        Product TheHouseOfTheDead = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The House of the Dead")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SegaSaturn)
                .build();

        Product MarvelSuperHeroes = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Marvel Super Heroes")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaSaturn)
                .build();

        Product SonicAdventure = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Sonic Adventure")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(SegaDreamcast)
                .build();

        Product SonicAdventure2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Sonic Adventure 2")
                .productSalePrice(29.99)
                .productQuantity(45)
                .console(SegaDreamcast)
                .build();

        Product Shenmue = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Shenmue")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(SegaDreamcast)
                .build();

        Product Shenmue2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Shenmue II")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SegaDreamcast)
                .build();

        Product JetSetRadio = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Jet Set Radio")
                .productSalePrice(29.99)
                .productQuantity(50)
                .console(SegaDreamcast)
                .build();

        Product CrazyTaxi = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Crazy Taxi")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(SegaDreamcast)
                .build();

        Product SkiesOfArcadia = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Skies of Arcadia")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SegaDreamcast)
                .build();

        Product PowerStone = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Power Stone")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaDreamcast)
                .build();

        Product PowerStone2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Power Stone 2")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaDreamcast)
                .build();

        Product SoulCalibur = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("SoulCalibur")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SegaDreamcast)
                .build();

        Product MarvelVsCapcom2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Marvel vs. Capcom 2")
                .productSalePrice(29.99)
                .productQuantity(40)
                .console(SegaDreamcast)
                .build();

        Product ResidentEvilCodeVeronica = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Resident Evil Code: Veronica")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaDreamcast)
                .build();

        Product TheHouseOfTheDead2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("The House of the Dead 2")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SegaDreamcast)
                .build();

        Product VirtuaTennis = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Virtua Tennis")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SegaDreamcast)
                .build();

        Product SegaRally2 = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Sega Rally 2")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SegaDreamcast)
                .build();

        Product DaytonaUSADreamcast = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Daytona USA")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaDreamcast)
                .build();

        Product GrandiaII = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Grandia II")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaDreamcast)
                .build();

        Product Ikaruga = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Ikaruga")
                .productSalePrice(29.99)
                .productQuantity(35)
                .console(SegaDreamcast)
                .build();

        Product VirtuaFighter3tb = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Virtua Fighter 3tb")
                .productSalePrice(29.99)
                .productQuantity(30)
                .console(SegaDreamcast)
                .build();

        Product Quake3Arena = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName("Quake III Arena")
                .productSalePrice(29.99)
                .productQuantity(25)
                .console(SegaDreamcast)
                .build();


    }

}