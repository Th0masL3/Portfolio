package com.lecoingameover.belecoingameover.utils;

import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.Cart;
import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.CartItem;
import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.CartRepository;
import com.lecoingameover.belecoingameover.dataaccess.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    @Autowired
    ConsoleRepository consoleRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;


    @Override
    public void run(String... args) throws Exception {

            //cart for user


            List<User> sampleUsers = List.of(
                    // Admins
                    User.builder()
                            .userId("auth0|675f4a7b9a80612ce548e063")
                            .email("amelia.clark@lecoingameover.com")
                            .firstName("Amelia")
                            .lastName("Clark")
                            .roles(List.of("admin"))
                            .permissions(null)
                            .build(),
                    User.builder()
                            .userId("auth0|675f4aa9e184fd643a8ed8fe")
                            .email("liam.jones@lecoingameover.com")
                            .firstName("Liam")
                            .lastName("Jones")
                            .roles(List.of("admin"))
                            .permissions(null)
                            .build(),

                    // Customers
                    User.builder()
                            .userId("auth0|675f4b3c9a80612ce548e067")
                            .email("sophia.johnson@example.com")
                            .firstName("Sophia")
                            .lastName("Johnson")
                            .roles(List.of("customer"))
                            .permissions(null)
                            .build(),
                    User.builder()
                            .userId("auth0|675f4b619a80612ce548e068")
                            .email("james.williams@example.com")
                            .firstName("James")
                            .lastName("Williams")
                            .roles(List.of("customer"))
                            .permissions(null)
                            .build(),
                    User.builder()
                            .userId("auth0|675f4b7ae184fd643a8ed902")
                            .email("ava.davis@example.com")
                            .firstName("Ava")
                            .lastName("Davis")
                            .roles(List.of("customer"))
                            .permissions(null)
                            .build(),
                    User.builder()
                            .userId("auth0|675f4b9d9a80612ce548e069")
                            .email("mason.miller@example.com")
                            .firstName("Mason")
                            .lastName("Miller")
                            .roles(List.of("customer"))
                            .permissions(null)
                            .build(),
                    User.builder()
                            .userId("auth0|675f4bb4e184fd643a8ed903")
                            .email("mia.moore@example.com")
                            .firstName("Mia")
                            .lastName("Moore")
                            .roles(List.of("customer"))
                            .permissions(null)
                            .build()

            );
            if (userRepository.count() == 0) {
                    userRepository.saveAll(sampleUsers);
            }

            if (consoleRepository.count() == 0) {
                    List<Console> consoleList = new ArrayList<>();


                    Console NES = Console.builder()
                            .consoleName("NES")
                            .releaseDate(LocalDate.of(1983, 7, 15))
                            .price(199.99)
                            .quantityInStock(500)
                            .company("Nintendo")
                            .build();
                    consoleList.add(NES);

                    Console SNES = Console.builder()
                            .consoleName("SNES")
                            .releaseDate(LocalDate.of(1990, 11, 21))
                            .price(249.99)
                            .quantityInStock(450)
                            .company("Nintendo")
                            .build();
                    consoleList.add(SNES);

                    Console N64 = Console.builder()
                            .consoleName("N64")
                            .releaseDate(LocalDate.of(1996, 6, 23))
                            .price(299.99)
                            .quantityInStock(400)
                            .company("Nintendo")
                            .build();

                    consoleList.add(N64);

                    Console GameCube = Console.builder()
                            .consoleName("GameCube")
                            .releaseDate(LocalDate.of(2001, 9, 14))
                            .price(199.99)
                            .quantityInStock(350)
                            .company("Nintendo")
                            .build();
                    consoleList.add(GameCube);

                    Console Wii = Console.builder()
                            .consoleName("Wii")
                            .releaseDate(LocalDate.of(2006, 11, 19))
                            .price(249.99)
                            .quantityInStock(300)
                            .company("Nintendo")
                            .build();
                    consoleList.add(Wii);
                    Console WiiU = Console.builder()
                            .consoleName("WiiU")
                            .releaseDate(LocalDate.of(2012, 11, 18))
                            .price(299.99)
                            .quantityInStock(300)
                            .company("Nintendo")
                            .build();
                    consoleList.add(WiiU);

                    Console Switch = Console.builder()
                            .consoleName("Switch")
                            .releaseDate(LocalDate.of(2017, 3, 3))
                            .price(599.99)
                            .quantityInStock(300)
                            .company("Nintendo")
                            .build();
                    consoleList.add(Switch);
                    Console PS1 = Console.builder()
                            .consoleName("PS1")
                            .releaseDate(LocalDate.of(1994, 12, 3))
                            .price(299.99)
                            .quantityInStock(400)
                            .company("Sony")
                            .build();
                    consoleList.add(PS1);

                    Console PS2 = Console.builder()
                            .consoleName("PS2")
                            .releaseDate(LocalDate.of(2000, 3, 4))
                            .price(299.99)
                            .quantityInStock(400)
                            .company("Sony")
                            .build();
                    consoleList.add(PS2);
                    Console PS3 = Console.builder()
                            .consoleName("PS3")
                            .releaseDate(LocalDate.of(2006, 11, 11))
                            .price(399.99)
                            .quantityInStock(350)
                            .company("Sony")
                            .build();
                    consoleList.add(PS3);

                    Console PS5 = Console.builder()
                            .consoleName("PS5")
                            .releaseDate(LocalDate.of(2020, 11, 12))
                            .price(599.99)
                            .quantityInStock(300)
                            .company("Sony")
                            .build();
                    consoleList.add(PS5);
                    Console PS4 = Console.builder()
                            .consoleName("PS4")
                            .releaseDate(LocalDate.of(2013, 11, 15))
                            .price(399.99)
                            .quantityInStock(350)
                            .company("Sony")
                            .build();
                    consoleList.add(PS4);

                    Console PSP = Console.builder()
                            .consoleName("PSP")
                            .releaseDate(LocalDate.of(2004, 12, 12))
                            .price(249.99)
                            .quantityInStock(300)
                            .company("Sony")
                            .build();
                    consoleList.add(PSP);

                    Console PSVita = Console.builder()
                            .consoleName("PSVita")
                            .releaseDate(LocalDate.of(2011, 12, 17))
                            .price(249.99)
                            .quantityInStock(250)
                            .company("Sony")
                            .build();
                    consoleList.add(PSVita);

                    Console GameBoy = Console.builder()
                            .consoleName("GameBoy")
                            .releaseDate(LocalDate.of(1989, 4, 21))
                            .price(99.99)
                            .quantityInStock(500)
                            .company("Nintendo")
                            .build();
                    consoleList.add(GameBoy);

                    Console GameBoyColor = Console.builder()
                            .consoleName("GameBoyColor")
                            .releaseDate(LocalDate.of(1998, 10, 21))
                            .price(129.99)
                            .quantityInStock(400)
                            .company("Nintendo")
                            .build();
                    consoleList.add(GameBoyColor);

                    Console GameBoyAdvance = Console.builder()
                            .consoleName("GameBoyAdvance")
                            .releaseDate(LocalDate.of(2001, 3, 21))
                            .price(99.99)
                            .quantityInStock(350)
                            .company("Nintendo")
                            .build();
                    consoleList.add(GameBoyAdvance);

                    Console GameBoyAdvanceSP = Console.builder()
                            .consoleName("GameBoyAdvanceSP")
                            .releaseDate(LocalDate.of(2003, 2, 14))
                            .price(129.99)
                            .quantityInStock(300)
                            .company("Nintendo")
                            .build();
                    consoleList.add(GameBoyAdvanceSP);
                    Console DS = Console.builder()
                            .consoleName("DS")
                            .releaseDate(LocalDate.of(2004, 11, 21))
                            .price(149.99)
                            .quantityInStock(350)
                            .company("Nintendo")
                            .build();
                    consoleList.add(DS);
                    Console DSi = Console.builder()
                            .consoleName("DSi")
                            .releaseDate(LocalDate.of(2008, 11, 1))
                            .price(169.99)
                            .quantityInStock(300)
                            .company("Nintendo")
                            .build();
                    consoleList.add(DSi);

                    Console DS3D = Console.builder()
                            .consoleName("3DS")
                            .releaseDate(LocalDate.of(2011, 2, 26))
                            .price(249.99)
                            .quantityInStock(250)
                            .company("Nintendo")
                            .build();
                    consoleList.add(DS3D);

                    Console New3DS = Console.builder()
                            .consoleName("New3DS")
                            .releaseDate(LocalDate.of(2014, 10, 11))
                            .price(199.99)
                            .quantityInStock(200)
                            .company("Nintendo")
                            .build();
                    consoleList.add(New3DS);
                    Console Xbox = Console.builder()
                            .consoleName("Xbox")
                            .releaseDate(LocalDate.of(2001, 11, 15))
                            .price(299.99)
                            .quantityInStock(300)
                            .company("Microsoft")
                            .build();
                    consoleList.add(Xbox);

                    Console Xbox360 = Console.builder()
                            .consoleName("Xbox360")
                            .releaseDate(LocalDate.of(2005, 11, 22))
                            .price(399.99)
                            .quantityInStock(350)
                            .company("Microsoft")
                            .build();
                    consoleList.add(Xbox360);


                    Console XboxOne = Console.builder()
                            .consoleName("XboxOne")
                            .releaseDate(LocalDate.of(2013, 11, 22))
                            .price(499.99)
                            .quantityInStock(300)
                            .company("Microsoft")
                            .build();
                    consoleList.add(XboxOne);


                    Console XboxSeriesX = Console.builder()
                            .consoleName("XboxSeriesX")
                            .releaseDate(LocalDate.of(2020, 11, 10))
                            .price(599.99)
                            .quantityInStock(300)
                            .company("Microsoft")
                            .build();
                    consoleList.add(XboxSeriesX);


                    Console SegaMasterSystem = Console.builder()
                            .consoleName("Sega Master System")
                            .releaseDate(LocalDate.of(1985, 10, 20))
                            .price(199.99)
                            .quantityInStock(400)
                            .company("Sega")
                            .build();

                    consoleList.add(SegaMasterSystem);


                    Console SegaGenesis = Console.builder()
                            .consoleName("Sega Genesis")
                            .releaseDate(LocalDate.of(1988, 10, 29))
                            .price(249.99)
                            .quantityInStock(400)
                            .company("Sega")
                            .build();
                    consoleList.add(SegaGenesis);

                    Console SegaSaturn = Console.builder()
                            .consoleName("Sega Saturn")
                            .releaseDate(LocalDate.of(1994, 11, 22))
                            .price(299.99)
                            .quantityInStock(300)
                            .company("Sega")
                            .build();
                    consoleList.add(SegaSaturn);


                    Console SegaDreamcast = Console.builder()
                            .consoleName("Sega Dreamcast")
                            .releaseDate(LocalDate.of(1998, 11, 27))
                            .price(249.99)
                            .quantityInStock(250)
                            .company("Sega")
                            .build();
                    consoleList.add(SegaDreamcast);

                    consoleRepository.saveAll(consoleList);

                    List<Product> productList = new ArrayList<>();


                    //products

                    Product MarioBros = Product.builder()
                            .productName("Super Mario Bros.")
                            .productSalePrice(19.99)
                            .productDescription("Classic Platformer where you play as a plumber to save princess toadstool")
                            .genre("Platformer")
                            .productQuantity(4)
                            .console(NES)
                            .build();
                    productList.add(MarioBros);

                    Product Zelda = Product.builder()
                            .productName("The Legend of Zelda")
                            .productSalePrice(24.99)
                            .productDescription("Embark on an epic quest to rescue Princess Zelda and defeat Ganon.")
                            .genre("Action-Adventure")
                            .productQuantity(5)
                            .console(NES)
                            .build();
                    productList.add(Zelda);

                    Product Metroid = Product.builder()
                            .productName("Metroid")
                            .productSalePrice(19.99)
                            .productDescription("Explore the alien world of Zebes as Samus Aran in this sci-fi adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(NES)
                            .build();
                    productList.add(Metroid);

                    Product MegaMan = Product.builder()
                            .productName("Mega Man")
                            .productSalePrice(22.99)
                            .productDescription("Battle Dr. Wily's robot masters in this challenging platformer.")
                            .genre("Platformer")
                            .productQuantity(3)
                            .console(NES)
                            .build();
                    productList.add(MegaMan);

                    Product DuckHunt = Product.builder()
                            .productName("Duck Hunt")
                            .productSalePrice(14.99)
                            .productDescription("Use the NES Zapper to shoot ducks in this classic light-gun game.")
                            .genre("Shooter")
                            .productQuantity(8)
                            .console(NES)
                            .build();
                    productList.add(DuckHunt);

                    Product Castlevania = Product.builder()
                            .productName("Castlevania")
                            .productSalePrice(18.99)
                            .productDescription("Take on Dracula and his minions in this gothic platforming classic.")
                            .genre("Platformer")
                            .productQuantity(4)
                            .console(NES)
                            .build();
                    productList.add(Castlevania);

                    Product Contra = Product.builder()
                            .productName("Contra")
                            .productSalePrice(19.99)
                            .productDescription("Team up or go solo in this action-packed run-and-gun game.")
                            .genre("Shooter")
                            .productQuantity(7)
                            .console(NES)
                            .build();
                    productList.add(Contra);

                    Product FinalFantasy = Product.builder()
                            .productName("Final Fantasy")
                            .productSalePrice(29.99)
                            .productDescription("The RPG that started it all; embark on a journey to restore the crystals.")
                            .genre("RPG")
                            .productQuantity(5)
                            .console(NES)
                            .build();
                    productList.add(FinalFantasy);

                    Product PunchOut = Product.builder()
                            .productName("Punch-Out!!")
                            .productSalePrice(17.99)
                            .productDescription("Step into the ring as Little Mac and take on boxing's biggest stars.")
                            .genre("Sports")
                            .productQuantity(6)
                            .console(NES)
                            .build();
                    productList.add(PunchOut);

                    Product SuperMarioWorld = Product.builder()
                            .productName("Super Mario World")
                            .productSalePrice(29.99)
                            .productDescription("Explore Dinosaur Land with Mario and Yoshi in this iconic platformer.")
                            .genre("Platformer")
                            .productQuantity(5)
                            .console(SNES)
                            .build();
                    productList.add(SuperMarioWorld);

                    Product ZeldaLinkToThePast = Product.builder()
                            .productName("The Legend of Zelda: A Link to the Past")
                            .productSalePrice(34.99)
                            .productDescription("Travel between light and dark worlds in this legendary adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(SNES)
                            .build();
                    productList.add(ZeldaLinkToThePast);

                    Product SuperMetroid = Product.builder()
                            .productName("Super Metroid")
                            .productSalePrice(32.99)
                            .productDescription("Join Samus Aran in her quest to recover the stolen Metroid.")
                            .genre("Action-Adventure")
                            .productQuantity(4)
                            .console(SNES)
                            .build();
                    productList.add(SuperMetroid);

                    Product DonkeyKongCountry = Product.builder()
                            .productName("Donkey Kong Country")
                            .productSalePrice(28.99)
                            .productDescription("Swing through the jungle and recover your stolen bananas.")
                            .genre("Platformer")
                            .productQuantity(7)
                            .console(SNES)
                            .build();
                    productList.add(DonkeyKongCountry);

                    Product ChronoTrigger = Product.builder()
                            .productName("Chrono Trigger")
                            .productSalePrice(39.99)
                            .productDescription("Travel through time to prevent the apocalypse in this legendary RPG.")
                            .genre("RPG")
                            .productQuantity(3)
                            .console(SNES)
                            .build();
                    productList.add(ChronoTrigger);

                    Product StreetFighterII = Product.builder()
                            .productName("Street Fighter II")
                            .productSalePrice(24.99)
                            .productDescription("Fight your way to victory in this genre-defining fighting game.")
                            .genre("Fighting")
                            .productQuantity(8)
                            .console(SNES)
                            .build();
                    productList.add(StreetFighterII);

                    Product FinalFantasyVI = Product.builder()
                            .productName("Final Fantasy VI")
                            .productSalePrice(34.99)
                            .productDescription("Join Terra and her allies in this epic tale of magic and technology.")
                            .genre("RPG")
                            .productQuantity(5)
                            .console(SNES)
                            .build();
                    productList.add(FinalFantasyVI);

                    Product FZero = Product.builder()
                            .productName("F-Zero")
                            .productSalePrice(19.99)
                            .productDescription("Race at breakneck speeds in this futuristic racing game.")
                            .genre("Racing")
                            .productQuantity(6)
                            .console(SNES)
                            .build();
                    productList.add(FZero);

                    Product SuperMarioKart = Product.builder()
                            .productName("Super Mario Kart")
                            .productSalePrice(27.99)
                            .productDescription("Compete in crazy races with Mario and friends in this kart racing classic.")
                            .genre("Racing")
                            .productQuantity(7)
                            .console(SNES)
                            .build();
                    productList.add(SuperMarioKart);

                    Product SuperMario64 = Product.builder()
                            .productName("Super Mario 64")
                            .productSalePrice(39.99)
                            .productDescription("The iconic 3D platformer that redefined the genre.")
                            .genre("Platformer")
                            .productQuantity(5)
                            .console(N64)
                            .build();
                    productList.add(SuperMario64);

                    Product ZeldaOcarina = Product.builder()
                            .productName("The Legend of Zelda: Ocarina of Time")
                            .productSalePrice(44.99)
                            .productDescription("Embark on an epic journey to save Hyrule in this critically acclaimed adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(N64)
                            .build();
                    productList.add(ZeldaOcarina);

                    Product GoldenEye007 = Product.builder()
                            .productName("GoldenEye 007")
                            .productSalePrice(29.99)
                            .productDescription("Step into the shoes of James Bond in this legendary first-person shooter.")
                            .genre("Shooter")
                            .productQuantity(7)
                            .console(N64)
                            .build();
                    productList.add(GoldenEye007);

                    Product MarioKart64 = Product.builder()
                            .productName("Mario Kart 64")
                            .productSalePrice(34.99)
                            .productDescription("Race with Mario and friends in this multiplayer kart racing classic.")
                            .genre("Racing")
                            .productQuantity(8)
                            .console(N64)
                            .build();
                    productList.add(MarioKart64);

                    Product StarFox64 = Product.builder()
                            .productName("Star Fox 64")
                            .productSalePrice(24.99)
                            .productDescription("Take flight in the Arwing and save the galaxy from Andross.")
                            .genre("Shooter")
                            .productQuantity(5)
                            .console(N64)
                            .build();
                    productList.add(StarFox64);

                    Product DonkeyKong64 = Product.builder()
                            .productName("Donkey Kong 64")
                            .productSalePrice(32.99)
                            .productDescription("Join Donkey Kong and friends in this expansive 3D platforming adventure.")
                            .genre("Platformer")
                            .productQuantity(4)
                            .console(N64)
                            .build();
                    productList.add(DonkeyKong64);

                    Product BanjoKazooie = Product.builder()
                            .productName("Banjo-Kazooie")
                            .productSalePrice(31.99)
                            .productDescription("Help Banjo and Kazooie defeat Gruntilda in this charming platformer.")
                            .genre("Platformer")
                            .productQuantity(5)
                            .console(N64)
                            .build();
                    productList.add(BanjoKazooie);

                    Product SmashBros = Product.builder()
                            .productName("Super Smash Bros.")
                            .productSalePrice(29.99)
                            .productDescription("Battle it out with Nintendo's biggest stars in this groundbreaking fighting game.")
                            .genre("Fighting")
                            .productQuantity(6)
                            .console(N64)
                            .build();
                    productList.add(SmashBros);

                    Product PaperMario = Product.builder()
                            .productName("Paper Mario")
                            .productSalePrice(34.99)
                            .productDescription("Join Mario in a unique RPG adventure to save Princess Peach from Bowser.")
                            .genre("RPG")
                            .productQuantity(5)
                            .console(N64)
                            .build();
                    productList.add(PaperMario);

                    Product SuperMarioSunshine = Product.builder()
                            .productName("Super Mario Sunshine")
                            .productSalePrice(39.99)
                            .productDescription("Join Mario on a tropical adventure to clean up Isle Delfino.")
                            .genre("Platformer")
                            .productQuantity(5)
                            .console(GameCube)
                            .build();
                    productList.add(SuperMarioSunshine);

                    Product ZeldaWindWaker = Product.builder()
                            .productName("The Legend of Zelda: The Wind Waker")
                            .productSalePrice(44.99)
                            .productDescription("Set sail across the Great Sea to rescue your sister and defeat evil.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(GameCube)
                            .build();
                    productList.add(ZeldaWindWaker);

                    Product MetroidPrime = Product.builder()
                            .productName("Metroid Prime")
                            .productSalePrice(34.99)
                            .productDescription("Explore the mysterious planet Tallon IV in this first-person adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(4)
                            .console(GameCube)
                            .build();
                    productList.add(MetroidPrime);

                    Product SuperSmashBrosMelee = Product.builder()
                            .productName("Super Smash Bros. Melee")
                            .productSalePrice(39.99)
                            .productDescription("Fight with Nintendo's greatest heroes in this iconic multiplayer brawler.")
                            .genre("Fighting")
                            .productQuantity(8)
                            .console(GameCube)
                            .build();
                    productList.add(SuperSmashBrosMelee);

                    Product LuigiMansion = Product.builder()
                            .productName("Luigi's Mansion")
                            .productSalePrice(29.99)
                            .productDescription("Help Luigi explore a haunted mansion to rescue Mario.")
                            .genre("Action-Adventure")
                            .productQuantity(5)
                            .console(GameCube)
                            .build();
                    productList.add(LuigiMansion);

                    Product AnimalCrossing = Product.builder()
                            .productName("Animal Crossing")
                            .productSalePrice(24.99)
                            .productDescription("Build your dream village and make new friends in this life simulation game.")
                            .genre("Simulation")
                            .productQuantity(6)
                            .console(GameCube)
                            .build();
                    productList.add(AnimalCrossing);

                    Product MarioKartDoubleDash = Product.builder()
                            .productName("Mario Kart: Double Dash!!")
                            .productSalePrice(34.99)
                            .productDescription("Race in teams of two in this unique entry in the Mario Kart series.")
                            .genre("Racing")
                            .productQuantity(7)
                            .console(GameCube)
                            .build();
                    productList.add(MarioKartDoubleDash);

                    Product ResidentEvil4 = Product.builder()
                            .productName("Resident Evil 4")
                            .productSalePrice(44.99)
                            .productDescription("Join Leon Kennedy on a mission to rescue the president's daughter in this survival horror masterpiece.")
                            .genre("Survival Horror")
                            .productQuantity(5)
                            .console(GameCube)
                            .build();
                    productList.add(ResidentEvil4);

                    Product Pikmin = Product.builder()
                            .productName("Pikmin")
                            .productSalePrice(29.99)
                            .productDescription("Guide your Pikmin army to survive on a mysterious planet and repair your ship.")
                            .genre("Strategy")
                            .productQuantity(4)
                            .console(GameCube)
                            .build();
                    productList.add(Pikmin);

                    Product WiiSports = Product.builder()
                            .productName("Wii Sports")
                            .productSalePrice(19.99)
                            .productDescription("Experience motion-controlled sports like tennis, bowling, and boxing.")
                            .genre("Sports")
                            .productQuantity(10)
                            .console(Wii)
                            .build();
                    productList.add(WiiSports);

                    Product SuperMarioGalaxy = Product.builder()
                            .productName("Super Mario Galaxy")
                            .productSalePrice(39.99)
                            .productDescription("Join Mario in a space adventure to save Princess Peach and the galaxy.")
                            .genre("Platformer")
                            .productQuantity(8)
                            .console(Wii)
                            .build();
                    productList.add(SuperMarioGalaxy);

                    Product ZeldaTwilightPrincess = Product.builder()
                            .productName("The Legend of Zelda: Twilight Princess")
                            .productSalePrice(44.99)
                            .productDescription("Help Link save Hyrule and the Twilight Realm in this epic adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(Wii)
                            .build();
                    productList.add(ZeldaTwilightPrincess);

                    Product MarioKartWii = Product.builder()
                            .productName("Mario Kart Wii")
                            .productSalePrice(34.99)
                            .productDescription("Race with Mario and friends using motion controls for immersive gameplay.")
                            .genre("Racing")
                            .productQuantity(9)
                            .console(Wii)
                            .build();
                    productList.add(MarioKartWii);

                    Product WiiFit = Product.builder()
                            .productName("Wii Fit")
                            .productSalePrice(29.99)
                            .productDescription("Stay active and improve fitness with fun balance board exercises.")
                            .genre("Fitness")
                            .productQuantity(5)
                            .console(Wii)
                            .build();
                    productList.add(WiiFit);

                    Product SuperSmashBrosBrawl = Product.builder()
                            .productName("Super Smash Bros. Brawl")
                            .productSalePrice(39.99)
                            .productDescription("Battle it out with Nintendo's biggest stars in this action-packed brawler.")
                            .genre("Fighting")
                            .productQuantity(7)
                            .console(Wii)
                            .build();
                    productList.add(SuperSmashBrosBrawl);

                    Product DonkeyKongCountryReturns = Product.builder()
                            .productName("Donkey Kong Country Returns")
                            .productSalePrice(34.99)
                            .productDescription("Help Donkey Kong recover his stolen bananas in this thrilling platformer.")
                            .genre("Platformer")
                            .productQuantity(6)
                            .console(Wii)
                            .build();
                    productList.add(DonkeyKongCountryReturns);

                    Product NewSuperMarioBrosWii = Product.builder()
                            .productName("New Super Mario Bros. Wii")
                            .productSalePrice(29.99)
                            .productDescription("Play with friends in this multiplayer Mario platforming adventure.")
                            .genre("Platformer")
                            .productQuantity(10)
                            .console(Wii)
                            .build();
                    productList.add(NewSuperMarioBrosWii);

                    Product XenobladeChronicles = Product.builder()
                            .productName("Xenoblade Chronicles")
                            .productSalePrice(49.99)
                            .productDescription("Embark on a sprawling RPG adventure to uncover the secrets of the Monado.")
                            .genre("RPG")
                            .productQuantity(4)
                            .console(Wii)
                            .build();
                    productList.add(XenobladeChronicles);

                    Product SuperMario3DWorld = Product.builder()
                            .productName("Super Mario 3D World")
                            .productSalePrice(39.99)
                            .productDescription("Team up with friends in this cooperative 3D Mario platformer.")
                            .genre("Platformer")
                            .productQuantity(6)
                            .console(WiiU)
                            .build();
                    productList.add(SuperMario3DWorld);

                    Product ZeldaWindWakerHD = Product.builder()
                            .productName("The Legend of Zelda: The Wind Waker HD")
                            .productSalePrice(44.99)
                            .productDescription("Experience the classic seafaring adventure with enhanced HD visuals.")
                            .genre("Action-Adventure")
                            .productQuantity(5)
                            .console(WiiU)
                            .build();
                    productList.add(ZeldaWindWakerHD);

                    Product MarioKart8 = Product.builder()
                            .productName("Mario Kart 8")
                            .productSalePrice(39.99)
                            .productDescription("Race upside-down and defy gravity in this high-speed kart racing game.")
                            .genre("Racing")
                            .productQuantity(8)
                            .console(WiiU)
                            .build();
                    productList.add(MarioKart8);

                    Product SuperSmashBrosWiiU = Product.builder()
                            .productName("Super Smash Bros. for Wii U")
                            .productSalePrice(44.99)
                            .productDescription("Battle it out with Nintendo’s greatest characters in this multiplayer brawler.")
                            .genre("Fighting")
                            .productQuantity(7)
                            .console(WiiU)
                            .build();
                    productList.add(SuperSmashBrosWiiU);

                    Product Splatoon = Product.builder()
                            .productName("Splatoon")
                            .productSalePrice(34.99)
                            .productDescription("Compete in colorful turf wars in this unique third-person shooter.")
                            .genre("Shooter")
                            .productQuantity(6)
                            .console(WiiU)
                            .build();
                    productList.add(Splatoon);

                    Product DonkeyKongTropicalFreeze = Product.builder()
                            .productName("Donkey Kong Country: Tropical Freeze")
                            .productSalePrice(39.99)
                            .productDescription("Join Donkey Kong and friends in this challenging platforming adventure.")
                            .genre("Platformer")
                            .productQuantity(5)
                            .console(WiiU)
                            .build();
                    productList.add(DonkeyKongTropicalFreeze);

                    Product Pikmin3 = Product.builder()
                            .productName("Pikmin 3")
                            .productSalePrice(29.99)
                            .productDescription("Lead your Pikmin army to solve puzzles and survive on a mysterious planet.")
                            .genre("Strategy")
                            .productQuantity(4)
                            .console(WiiU)
                            .build();
                    productList.add(Pikmin3);

                    Product ZeldaTwilightPrincessHD = Product.builder()
                            .productName("The Legend of Zelda: Twilight Princess HD")
                            .productSalePrice(49.99)
                            .productDescription("Relive the classic adventure with enhanced HD visuals.")
                            .genre("Action-Adventure")
                            .productQuantity(4)
                            .console(WiiU)
                            .build();
                    productList.add(ZeldaTwilightPrincessHD);

                    Product NewSuperMarioBrosU = Product.builder()
                            .productName("New Super Mario Bros. U")
                            .productSalePrice(29.99)
                            .productDescription("Jump into classic side-scrolling Mario action with friends.")
                            .genre("Platformer")
                            .productQuantity(7)
                            .console(WiiU)
                            .build();
                    productList.add(NewSuperMarioBrosU);

                    Product BreathOfTheWild = Product.builder()
                            .productName("The Legend of Zelda: Breath of the Wild")
                            .productSalePrice(59.99)
                            .productDescription("Explore a vast open world and save Hyrule in this critically acclaimed adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(10)
                            .console(Switch)
                            .build();
                    productList.add(BreathOfTheWild);

                    Product MarioOdyssey = Product.builder()
                            .productName("Super Mario Odyssey")
                            .productSalePrice(49.99)
                            .productDescription("Join Mario on a globe-trotting adventure to rescue Princess Peach.")
                            .genre("Platformer")
                            .productQuantity(8)
                            .console(Switch)
                            .build();
                    productList.add(MarioOdyssey);

                    Product MarioKart8Deluxe = Product.builder()
                            .productName("Mario Kart 8 Deluxe")
                            .productSalePrice(59.99)
                            .productDescription("Race with your favorite characters and enjoy enhanced features in this definitive edition.")
                            .genre("Racing")
                            .productQuantity(12)
                            .console(Switch)
                            .build();
                    productList.add(MarioKart8Deluxe);

                    Product SmashUltimate = Product.builder()
                            .productName("Super Smash Bros. Ultimate")
                            .productSalePrice(59.99)
                            .productDescription("Battle it out with the largest roster of fighters in Smash Bros. history.")
                            .genre("Fighting")
                            .productQuantity(9)
                            .console(Switch)
                            .build();
                    productList.add(SmashUltimate);

                    Product AnimalCrossingNewHorizons = Product.builder()
                            .productName("Animal Crossing: New Horizons")
                            .productSalePrice(54.99)
                            .productDescription("Build your dream island life and make friends in this relaxing simulation game.")
                            .genre("Simulation")
                            .productQuantity(10)
                            .console(Switch)
                            .build();
                    productList.add(AnimalCrossingNewHorizons);

                    Product Splatoon3 = Product.builder()
                            .productName("Splatoon 3")
                            .productSalePrice(49.99)
                            .productDescription("Compete in new and exciting turf wars in this vibrant third-person shooter.")
                            .genre("Shooter")
                            .productQuantity(7)
                            .console(Switch)
                            .build();
                    productList.add(Splatoon3);

                    Product FireEmblemThreeHouses = Product.builder()
                            .productName("Fire Emblem: Three Houses")
                            .productSalePrice(59.99)
                            .productDescription("Lead your students in battles and uncover mysteries in this epic tactical RPG.")
                            .genre("RPG")
                            .productQuantity(6)
                            .console(Switch)
                            .build();
                    productList.add(FireEmblemThreeHouses);

                    Product XenobladeChronicles3 = Product.builder()
                            .productName("Xenoblade Chronicles 3")
                            .productSalePrice(59.99)
                            .productDescription("Embark on a massive RPG adventure with deep storytelling and combat.")
                            .genre("RPG")
                            .productQuantity(5)
                            .console(Switch)
                            .build();
                    productList.add(XenobladeChronicles3);

                    Product MetroidDread = Product.builder()
                            .productName("Metroid Dread")
                            .productSalePrice(49.99)
                            .productDescription("Join Samus Aran in this thrilling 2D Metroid adventure to uncover a dangerous mystery.")
                            .genre("Action-Adventure")
                            .productQuantity(8)
                            .console(Switch)
                            .build();
                    productList.add(MetroidDread);

                    Product FinalFantasyVII = Product.builder()
                            .productName("Final Fantasy VII")
                            .productSalePrice(39.99)
                            .productDescription("Join Cloud Strife and his allies in this groundbreaking RPG adventure.")
                            .genre("RPG")
                            .productQuantity(7)
                            .console(PS1)
                            .build();
                    productList.add(FinalFantasyVII);

                    Product MetalGearSolid = Product.builder()
                            .productName("Metal Gear Solid")
                            .productSalePrice(29.99)
                            .productDescription("Step into the shoes of Solid Snake in this stealth-action masterpiece.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(PS1)
                            .build();
                    productList.add(MetalGearSolid);

                    Product ResidentEvil2 = Product.builder()
                            .productName("Resident Evil 2")
                            .productSalePrice(34.99)
                            .productDescription("Survive the horrors of Raccoon City in this iconic survival horror game.")
                            .genre("Survival Horror")
                            .productQuantity(5)
                            .console(PS1)
                            .build();
                    productList.add(ResidentEvil2);

                    Product CrashBandicoot = Product.builder()
                            .productName("Crash Bandicoot")
                            .productSalePrice(24.99)
                            .productDescription("Help Crash defeat Dr. Cortex in this wacky platforming adventure.")
                            .genre("Platformer")
                            .productQuantity(8)
                            .console(PS1)
                            .build();
                    productList.add(CrashBandicoot);

                    Product SpyroTheDragon = Product.builder()
                            .productName("Spyro the Dragon")
                            .productSalePrice(29.99)
                            .productDescription("Guide Spyro through magical realms to save his friends from danger.")
                            .genre("Platformer")
                            .productQuantity(9)
                            .console(PS1)
                            .build();
                    productList.add(SpyroTheDragon);

                    Product GranTurismo = Product.builder()
                            .productName("Gran Turismo")
                            .productSalePrice(34.99)
                            .productDescription("Experience realistic driving mechanics in this classic racing simulation.")
                            .genre("Racing")
                            .productQuantity(6)
                            .console(PS1)
                            .build();
                    productList.add(GranTurismo);

                    Product TombRaider = Product.builder()
                            .productName("Tomb Raider")
                            .productSalePrice(29.99)
                            .productDescription("Join Lara Croft on her first adventure in this genre-defining action game.")
                            .genre("Action-Adventure")
                            .productQuantity(5)
                            .console(PS1)
                            .build();
                    productList.add(TombRaider);

                    Product Tekken3 = Product.builder()
                            .productName("Tekken 3")
                            .productSalePrice(24.99)
                            .productDescription("Fight your way to the top in this iconic 3D fighting game.")
                            .genre("Fighting")
                            .productQuantity(10)
                            .console(PS1)
                            .build();
                    productList.add(Tekken3);

                    Product CastlevaniaSymphony = Product.builder()
                            .productName("Castlevania: Symphony of the Night")
                            .productSalePrice(39.99)
                            .productDescription("Explore Dracula's castle in this critically acclaimed action-adventure game.")
                            .genre("Action-Adventure")
                            .productQuantity(4)
                            .console(PS1)
                            .build();
                    productList.add(CastlevaniaSymphony);

                    Product FinalFantasyX = Product.builder()
                            .productName("Final Fantasy X")
                            .productSalePrice(39.99)
                            .productDescription("Join Tidus and Yuna on an epic RPG journey to save Spira.")
                            .genre("RPG")
                            .productQuantity(7)
                            .console(PS2)
                            .build();
                    productList.add(FinalFantasyX);

                    Product MetalGearSolid2 = Product.builder()
                            .productName("Metal Gear Solid 2: Sons of Liberty")
                            .productSalePrice(34.99)
                            .productDescription("Experience tactical espionage action in this iconic sequel.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(PS2)
                            .build();
                    productList.add(MetalGearSolid2);

                    Product GrandTheftAutoSanAndreas = Product.builder()
                            .productName("Grand Theft Auto: San Andreas")
                            .productSalePrice(29.99)
                            .productDescription("Explore the open-world of San Andreas in this groundbreaking action game.")
                            .genre("Action-Adventure")
                            .productQuantity(8)
                            .console(PS2)
                            .build();
                    productList.add(GrandTheftAutoSanAndreas);

                    Product ShadowOfTheColossus = Product.builder()
                            .productName("Shadow of the Colossus")
                            .productSalePrice(39.99)
                            .productDescription("Take down massive colossi in this breathtaking adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(5)
                            .console(PS2)
                            .build();
                    productList.add(ShadowOfTheColossus);

                    Product GodOfWar = Product.builder()
                            .productName("God of War")
                            .productSalePrice(34.99)
                            .productDescription("Join Kratos on a quest for vengeance in this action-packed mythological adventure.")
                            .genre("Action")
                            .productQuantity(7)
                            .console(PS2)
                            .build();
                    productList.add(GodOfWar);

                    Product JakAndDaxter = Product.builder()
                            .productName("Jak and Daxter: The Precursor Legacy")
                            .productSalePrice(29.99)
                            .productDescription("Explore a vibrant world and uncover its secrets in this platforming adventure.")
                            .genre("Platformer")
                            .productQuantity(6)
                            .console(PS2)
                            .build();
                    productList.add(JakAndDaxter);

                    Product KingdomHearts = Product.builder()
                            .productName("Kingdom Hearts")
                            .productSalePrice(39.99)
                            .productDescription("Join Sora, Donald, and Goofy in a magical RPG adventure with Disney characters.")
                            .genre("RPG")
                            .productQuantity(9)
                            .console(PS2)
                            .build();
                    productList.add(KingdomHearts);

                    Product GranTurismo4 = Product.builder()
                            .productName("Gran Turismo 4")
                            .productSalePrice(29.99)
                            .productDescription("Race realistic cars across stunning tracks in this racing simulation.")
                            .genre("Racing")
                            .productQuantity(8)
                            .console(PS2)
                            .build();
                    productList.add(GranTurismo4);

                    Product DevilMayCry = Product.builder()
                            .productName("Devil May Cry")
                            .productSalePrice(34.99)
                            .productDescription("Battle demonic forces with Dante in this stylish action game.")
                            .genre("Action")
                            .productQuantity(7)
                            .console(PS2)
                            .build();
                    productList.add(DevilMayCry);

                    Product TheLastOfUs = Product.builder()
                            .productName("The Last of Us")
                            .productSalePrice(59.99)
                            .productDescription("Embark on an emotional journey of survival in a post-apocalyptic world.")
                            .genre("Action-Adventure")
                            .productQuantity(7)
                            .console(PS3)
                            .build();
                    productList.add(TheLastOfUs);

                    Product Uncharted2 = Product.builder()
                            .productName("Uncharted 2: Among Thieves")
                            .productSalePrice(49.99)
                            .productDescription("Join Nathan Drake on an action-packed treasure-hunting adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(8)
                            .console(PS3)
                            .build();
                    productList.add(Uncharted2);

                    Product GodOfWar3 = Product.builder()
                            .productName("God of War III")
                            .productSalePrice(39.99)
                            .productDescription("Lead Kratos on his vengeful quest against the gods of Olympus.")
                            .genre("Action")
                            .productQuantity(6)
                            .console(PS3)
                            .build();
                    productList.add(GodOfWar3);

                    Product RedDeadRedemption = Product.builder()
                            .productName("Red Dead Redemption")
                            .productSalePrice(49.99)
                            .productDescription("Explore the Wild West in this critically acclaimed open-world adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(9)
                            .console(PS3)
                            .build();
                    productList.add(RedDeadRedemption);

                    Product LittleBigPlanet = Product.builder()
                            .productName("LittleBigPlanet")
                            .productSalePrice(29.99)
                            .productDescription("Create, share, and explore unique platforming levels with Sackboy.")
                            .genre("Platformer")
                            .productQuantity(5)
                            .console(PS3)
                            .build();
                    productList.add(LittleBigPlanet);

                    Product GranTurismo5 = Product.builder()
                            .productName("Gran Turismo 5")
                            .productSalePrice(34.99)
                            .productDescription("Experience stunning realism in this racing simulation masterpiece.")
                            .genre("Racing")
                            .productQuantity(8)
                            .console(PS3)
                            .build();
                    productList.add(GranTurismo5);

                    Product MetalGearSolid4 = Product.builder()
                            .productName("Metal Gear Solid 4: Guns of the Patriots")
                            .productSalePrice(39.99)
                            .productDescription("Follow Solid Snake's final mission in this cinematic stealth action game.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(PS3)
                            .build();
                    productList.add(MetalGearSolid4);

                    Product HeavyRain = Product.builder()
                            .productName("Heavy Rain")
                            .productSalePrice(29.99)
                            .productDescription("Unravel a gripping mystery in this emotional interactive drama.")
                            .genre("Adventure")
                            .productQuantity(7)
                            .console(PS3)
                            .build();
                    productList.add(HeavyRain);

                    Product Journey = Product.builder()
                            .productName("Journey")
                            .productSalePrice(19.99)
                            .productDescription("Embark on a beautiful and emotional adventure through a vast desert.")
                            .genre("Adventure")
                            .productQuantity(5)
                            .console(PS3)
                            .build();
                    productList.add(Journey);

                    Product GodOfWar2018 = Product.builder()
                            .productName("God of War")
                            .productSalePrice(59.99)
                            .productDescription("Join Kratos and Atreus on a mythological journey in the Norse realm.")
                            .genre("Action-Adventure")
                            .productQuantity(8)
                            .console(PS4)
                            .build();
                    productList.add(GodOfWar2018);

                    Product TheLastOfUsPart2 = Product.builder()
                            .productName("The Last of Us Part II")
                            .productSalePrice(59.99)
                            .productDescription("Experience the emotional and harrowing sequel to the post-apocalyptic classic.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(PS4)
                            .build();
                    productList.add(TheLastOfUsPart2);

                    Product Uncharted4 = Product.builder()
                            .productName("Uncharted 4: A Thief's End")
                            .productSalePrice(49.99)
                            .productDescription("Join Nathan Drake in his final treasure-hunting adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(7)
                            .console(PS4)
                            .build();
                    productList.add(Uncharted4);

                    Product SpiderMan = Product.builder()
                            .productName("Marvel's Spider-Man")
                            .productSalePrice(59.99)
                            .productDescription("Swing through New York City as Spider-Man in this thrilling open-world adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(9)
                            .console(PS4)
                            .build();
                    productList.add(SpiderMan);

                    Product HorizonZeroDawn = Product.builder()
                            .productName("Horizon Zero Dawn")
                            .productSalePrice(49.99)
                            .productDescription("Explore a post-apocalyptic world dominated by robotic creatures.")
                            .genre("Action-RPG")
                            .productQuantity(8)
                            .console(PS4)
                            .build();
                    productList.add(HorizonZeroDawn);

                    Product Bloodborne = Product.builder()
                            .productName("Bloodborne")
                            .productSalePrice(39.99)
                            .productDescription("Enter the haunting world of Yharnam in this challenging action RPG.")
                            .genre("Action-RPG")
                            .productQuantity(5)
                            .console(PS4)
                            .build();
                    productList.add(Bloodborne);

                    Product GhostOfTsushima = Product.builder()
                            .productName("Ghost of Tsushima")
                            .productSalePrice(59.99)
                            .productDescription("Take on the role of a samurai and liberate Tsushima from Mongol invaders.")
                            .genre("Action-Adventure")
                            .productQuantity(7)
                            .console(PS4)
                            .build();
                    productList.add(GhostOfTsushima);

                    Product GranTurismoSport = Product.builder()
                            .productName("Gran Turismo Sport")
                            .productSalePrice(39.99)
                            .productDescription("Race in stunning realism with the latest entry in the Gran Turismo series.")
                            .genre("Racing")
                            .productQuantity(6)
                            .console(PS4)
                            .build();
                    productList.add(GranTurismoSport);

                    Product RatchetAndClank = Product.builder()
                            .productName("Ratchet & Clank")
                            .productSalePrice(29.99)
                            .productDescription("Join Ratchet and Clank on a hilarious and action-packed adventure.")
                            .genre("Platformer")
                            .productQuantity(7)
                            .console(PS4)
                            .build();
                    productList.add(RatchetAndClank);

                    Product DemonSouls = Product.builder()
                            .productName("Demon's Souls")
                            .productSalePrice(69.99)
                            .productDescription("Experience the stunning remake of the classic action RPG that started it all.")
                            .genre("Action-RPG")
                            .productQuantity(6)
                            .console(PS5)
                            .build();
                    productList.add(DemonSouls);

                    Product SpiderManMilesMorales = Product.builder()
                            .productName("Marvel's Spider-Man: Miles Morales")
                            .productSalePrice(49.99)
                            .productDescription("Swing through Harlem as Miles Morales in this thrilling Spider-Man adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(8)
                            .console(PS5)
                            .build();
                    productList.add(SpiderManMilesMorales);

                    Product RatchetAndClankRiftApart = Product.builder()
                            .productName("Ratchet & Clank: Rift Apart")
                            .productSalePrice(69.99)
                            .productDescription("Join Ratchet and Clank in their next dimension-hopping adventure.")
                            .genre("Platformer")
                            .productQuantity(7)
                            .console(PS5)
                            .build();
                    productList.add(RatchetAndClankRiftApart);

                    Product Returnal = Product.builder()
                            .productName("Returnal")
                            .productSalePrice(59.99)
                            .productDescription("Survive a mysterious alien world in this fast-paced roguelike shooter.")
                            .genre("Shooter")
                            .productQuantity(5)
                            .console(PS5)
                            .build();
                    productList.add(Returnal);

                    Product HorizonForbiddenWest = Product.builder()
                            .productName("Horizon Forbidden West")
                            .productSalePrice(69.99)
                            .productDescription("Explore a stunning open world and battle mechanical beasts in Aloy's latest adventure.")
                            .genre("Action-RPG")
                            .productQuantity(8)
                            .console(PS5)
                            .build();
                    productList.add(HorizonForbiddenWest);

                    Product GodOfWarRagnarok = Product.builder()
                            .productName("God of War: Ragnarok")
                            .productSalePrice(69.99)
                            .productDescription("Join Kratos and Atreus as they face the end of the Norse world in this epic saga.")
                            .genre("Action-Adventure")
                            .productQuantity(7)
                            .console(PS5)
                            .build();
                    productList.add(GodOfWarRagnarok);

                    Product GranTurismo7 = Product.builder()
                            .productName("Gran Turismo 7")
                            .productSalePrice(59.99)
                            .productDescription("Race with stunning realism in the latest entry of the Gran Turismo series.")
                            .genre("Racing")
                            .productQuantity(6)
                            .console(PS5)
                            .build();
                    productList.add(GranTurismo7);

                    Product EldenRing = Product.builder()
                            .productName("Elden Ring")
                            .productSalePrice(69.99)
                            .productDescription("Venture into the vast open world of the Lands Between in this critically acclaimed RPG.")
                            .genre("Action-RPG")
                            .productQuantity(9)
                            .console(PS5)
                            .build();
                    productList.add(EldenRing);

                    Product GhostwireTokyo = Product.builder()
                            .productName("Ghostwire: Tokyo")
                            .productSalePrice(59.99)
                            .productDescription("Explore a supernatural Tokyo and battle spirits in this unique action-adventure game.")
                            .genre("Action-Adventure")
                            .productQuantity(5)
                            .console(PS5)
                            .build();
                    productList.add(GhostwireTokyo);

                    Product CrisisCoreFinalFantasyVII = Product.builder()
                            .productName("Crisis Core: Final Fantasy VII")
                            .productSalePrice(29.99)
                            .productDescription("Follow Zack Fair's journey in this action-packed prequel to Final Fantasy VII.")
                            .genre("Action-RPG")
                            .productQuantity(6)
                            .console(PSP)
                            .build();
                    productList.add(CrisisCoreFinalFantasyVII);

                    Product GodOfWarChainsOfOlympus = Product.builder()
                            .productName("God of War: Chains of Olympus")
                            .productSalePrice(24.99)
                            .productDescription("Experience Kratos's brutal journey in this handheld God of War adventure.")
                            .genre("Action")
                            .productQuantity(7)
                            .console(PSP)
                            .build();
                    productList.add(GodOfWarChainsOfOlympus);

                    Product Daxter = Product.builder()
                            .productName("Daxter")
                            .productSalePrice(19.99)
                            .productDescription("Help Daxter in this standalone platforming adventure set in the Jak and Daxter universe.")
                            .genre("Platformer")
                            .productQuantity(5)
                            .console(PSP)
                            .build();
                    productList.add(Daxter);

                    Product MonsterHunterFreedomUnite = Product.builder()
                            .productName("Monster Hunter Freedom Unite")
                            .productSalePrice(29.99)
                            .productDescription("Hunt massive monsters and craft powerful gear in this epic action game.")
                            .genre("Action")
                            .productQuantity(8)
                            .console(PSP)
                            .build();
                    productList.add(MonsterHunterFreedomUnite);

                    Product MetalGearSolidPeaceWalker = Product.builder()
                            .productName("Metal Gear Solid: Peace Walker")
                            .productSalePrice(34.99)
                            .productDescription("Join Big Boss in this stealth-action masterpiece set in Central America.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(PSP)
                            .build();
                    productList.add(MetalGearSolidPeaceWalker);

                    Product Patapon = Product.builder()
                            .productName("Patapon")
                            .productSalePrice(14.99)
                            .productDescription("Lead your tribe to victory with rhythm-based strategy gameplay.")
                            .genre("Rhythm-Strategy")
                            .productQuantity(9)
                            .console(PSP)
                            .build();
                    productList.add(Patapon);

                    Product FinalFantasyTacticsWarOfTheLions = Product.builder()
                            .productName("Final Fantasy Tactics: The War of the Lions")
                            .productSalePrice(29.99)
                            .productDescription("Experience this enhanced tactical RPG classic with new content.")
                            .genre("Tactical RPG")
                            .productQuantity(5)
                            .console(PSP)
                            .build();
                    productList.add(FinalFantasyTacticsWarOfTheLions);

                    Product KingdomHeartsBirthBySleep = Product.builder()
                            .productName("Kingdom Hearts: Birth by Sleep")
                            .productSalePrice(34.99)
                            .productDescription("Uncover the origins of the Kingdom Hearts saga in this action-RPG prequel.")
                            .genre("Action-RPG")
                            .productQuantity(7)
                            .console(PSP)
                            .build();
                    productList.add(KingdomHeartsBirthBySleep);

                    Product Lumines = Product.builder()
                            .productName("Lumines")
                            .productSalePrice(19.99)
                            .productDescription("Enjoy this addictive puzzle game with a stylish soundtrack and visuals.")
                            .genre("Puzzle")
                            .productQuantity(8)
                            .console(PSP)
                            .build();
                    productList.add(Lumines);


                    Product UnchartedGoldenAbyss = Product.builder()
                            .productName("Uncharted: Golden Abyss")
                            .productSalePrice(39.99)
                            .productDescription("Join Nathan Drake on a portable treasure-hunting adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(PSVita)
                            .build();
                    productList.add(UnchartedGoldenAbyss);

                    Product GravityRush = Product.builder()
                            .productName("Gravity Rush")
                            .productSalePrice(29.99)
                            .productDescription("Manipulate gravity and explore a stunning world in this unique action-adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(7)
                            .console(PSVita)
                            .build();
                    productList.add(GravityRush);

                    Product Persona4Golden = Product.builder()
                            .productName("Persona 4 Golden")
                            .productSalePrice(49.99)
                            .productDescription("Dive into this enhanced RPG classic and uncover a supernatural mystery.")
                            .genre("RPG")
                            .productQuantity(5)
                            .console(PSVita)
                            .build();
                    productList.add(Persona4Golden);

                    Product KillzoneMercenary = Product.builder()
                            .productName("Killzone: Mercenary")
                            .productSalePrice(34.99)
                            .productDescription("Experience intense FPS action in the Killzone universe, optimized for handheld gaming.")
                            .genre("Shooter")
                            .productQuantity(8)
                            .console(PSVita)
                            .build();
                    productList.add(KillzoneMercenary);

                    Product Tearaway = Product.builder()
                            .productName("Tearaway")
                            .productSalePrice(24.99)
                            .productDescription("Explore a charming paper-crafted world in this creative platformer.")
                            .genre("Platformer")
                            .productQuantity(6)
                            .console(PSVita)
                            .build();
                    productList.add(Tearaway);

                    Product DanganronpaTriggerHappyHavoc = Product.builder()
                            .productName("Danganronpa: Trigger Happy Havoc")
                            .productSalePrice(29.99)
                            .productDescription("Unravel mysteries and survive in this gripping visual novel adventure.")
                            .genre("Adventure")
                            .productQuantity(7)
                            .console(PSVita)
                            .build();
                    productList.add(DanganronpaTriggerHappyHavoc);

                    Product RaymanLegends = Product.builder()
                            .productName("Rayman Legends")
                            .productSalePrice(34.99)
                            .productDescription("Join Rayman and friends in this colorful and thrilling platforming adventure.")
                            .genre("Platformer")
                            .productQuantity(5)
                            .console(PSVita)
                            .build();
                    productList.add(RaymanLegends);

                    Product LittleBigPlanetPSVita = Product.builder()
                            .productName("LittleBigPlanet PS Vita")
                            .productSalePrice(29.99)
                            .productDescription("Create and share imaginative platforming levels with Sackboy on the go.")
                            .genre("Platformer")
                            .productQuantity(8)
                            .console(PSVita)
                            .build();
                    productList.add(LittleBigPlanetPSVita);

                    Product MinecraftPSVita = Product.builder()
                            .productName("Minecraft: PS Vita Edition")
                            .productSalePrice(19.99)
                            .productDescription("Build, explore, and survive in the endless possibilities of Minecraft.")
                            .genre("Sandbox")
                            .productQuantity(9)
                            .console(PSVita)
                            .build();
                    productList.add(MinecraftPSVita);

                    Product PokemonRed = Product.builder()
                            .productName("Pokemon Red")
                            .productSalePrice(29.99)
                            .productDescription("Catch and train Pokemon to become the ultimate Pokemon Master.")
                            .genre("RPG")
                            .productQuantity(8)
                            .console(GameBoy)
                            .build();
                    productList.add(PokemonRed);

                    Product Tetris = Product.builder()
                            .productName("Tetris")
                            .productSalePrice(19.99)
                            .productDescription("The classic block-stacking puzzle game that defined a genre.")
                            .genre("Puzzle")
                            .productQuantity(10)
                            .console(GameBoy)
                            .build();
                    productList.add(Tetris);

                    Product SuperMarioLand = Product.builder()
                            .productName("Super Mario Land")
                            .productSalePrice(24.99)
                            .productDescription("Join Mario on a handheld platforming adventure to save Princess Daisy.")
                            .genre("Platformer")
                            .productQuantity(7)
                            .console(GameBoy)
                            .build();
                    productList.add(SuperMarioLand);

                    Product TheLegendOfZeldaLinksAwakening = Product.builder()
                            .productName("The Legend of Zelda: Link's Awakening")
                            .productSalePrice(29.99)
                            .productDescription("Embark on a mysterious journey to awaken the Wind Fish.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(GameBoy)
                            .build();
                    productList.add(TheLegendOfZeldaLinksAwakening);

                    Product MetroidII = Product.builder()
                            .productName("Metroid II: Return of Samus")
                            .productSalePrice(27.99)
                            .productDescription("Help Samus Aran eliminate the Metroid threat in this sci-fi adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(5)
                            .console(GameBoy)
                            .build();
                    productList.add(MetroidII);

                    Product KirbyDreamLand = Product.builder()
                            .productName("Kirby's Dream Land")
                            .productSalePrice(19.99)
                            .productDescription("Join Kirby on his first adventure to save Dream Land from King Dedede.")
                            .genre("Platformer")
                            .productQuantity(9)
                            .console(GameBoy)
                            .build();
                    productList.add(KirbyDreamLand);

                    Product DonkeyKong = Product.builder()
                            .productName("Donkey Kong")
                            .productSalePrice(22.99)
                            .productDescription("Help Mario rescue Pauline in this puzzle-platforming classic.")
                            .genre("Platformer")
                            .productQuantity(8)
                            .console(GameBoy)
                            .build();
                    productList.add(DonkeyKong);

                    Product DrMario = Product.builder()
                            .productName("Dr. Mario")
                            .productSalePrice(19.99)
                            .productDescription("Clear viruses with color-coded pills in this addictive puzzle game.")
                            .genre("Puzzle")
                            .productQuantity(7)
                            .console(GameBoy)
                            .build();
                    productList.add(DrMario);

                    Product FinalFantasyAdventure = Product.builder()
                            .productName("Final Fantasy Adventure")
                            .productSalePrice(29.99)
                            .productDescription("Embark on a quest to save the Mana Tree in this action-RPG classic.")
                            .genre("Action-RPG")
                            .productQuantity(6)
                            .console(GameBoy)
                            .build();
                    productList.add(FinalFantasyAdventure);

                    Product PokemonGold = Product.builder()
                            .productName("Pokemon Gold")
                            .productSalePrice(34.99)
                            .productDescription("Explore the Johto region and become the ultimate Pokemon Trainer.")
                            .genre("RPG")
                            .productQuantity(8)
                            .console(GameBoyColor)
                            .build();
                    productList.add(PokemonGold);

                    Product PokemonSilver = Product.builder()
                            .productName("Pokemon Silver")
                            .productSalePrice(34.99)
                            .productDescription("Discover the mysteries of the Johto region and catch legendary Pokemon.")
                            .genre("RPG")
                            .productQuantity(8)
                            .console(GameBoyColor)
                            .build();
                    productList.add(PokemonSilver);

                    Product TheLegendOfZeldaOracleOfSeasons = Product.builder()
                            .productName("The Legend of Zelda: Oracle of Seasons")
                            .productSalePrice(29.99)
                            .productDescription("Manipulate the seasons to solve puzzles and save the land of Holodrum.")
                            .genre("Action-Adventure")
                            .productQuantity(7)
                            .console(GameBoyColor)
                            .build();
                    productList.add(TheLegendOfZeldaOracleOfSeasons);

                    Product TheLegendOfZeldaOracleOfAges = Product.builder()
                            .productName("The Legend of Zelda: Oracle of Ages")
                            .productSalePrice(29.99)
                            .productDescription("Travel through time to save Labrynna in this thrilling adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(GameBoyColor)
                            .build();
                    productList.add(TheLegendOfZeldaOracleOfAges);

                    Product SuperMarioBrosDeluxe = Product.builder()
                            .productName("Super Mario Bros. Deluxe")
                            .productSalePrice(24.99)
                            .productDescription("Enjoy the classic platformer with added features on the GameBoy Color.")
                            .genre("Platformer")
                            .productQuantity(9)
                            .console(GameBoyColor)
                            .build();
                    productList.add(SuperMarioBrosDeluxe);

                    Product WarioLand3 = Product.builder()
                            .productName("Wario Land 3")
                            .productSalePrice(24.99)
                            .productDescription("Join Wario on his treasure-hunting adventure full of puzzles and enemies.")
                            .genre("Platformer")
                            .productQuantity(6)
                            .console(GameBoyColor)
                            .build();
                    productList.add(WarioLand3);

                    Product DonkeyKongCountryColor = Product.builder()
                            .productName("Donkey Kong Country")
                            .productSalePrice(29.99)
                            .productDescription("Help Donkey Kong recover his bananas in this handheld platforming classic.")
                            .genre("Platformer")
                            .productQuantity(5)
                            .console(GameBoyColor)
                            .build();
                    productList.add(DonkeyKongCountryColor);

                    Product KirbyTiltAndTumble = Product.builder()
                            .productName("Kirby Tilt 'n' Tumble")
                            .productSalePrice(19.99)
                            .productDescription("Use tilt controls to guide Kirby through fun and challenging levels.")
                            .genre("Puzzle-Platformer")
                            .productQuantity(7)
                            .console(GameBoyColor)
                            .build();
                    productList.add(KirbyTiltAndTumble);

                    Product DragonQuestIII = Product.builder()
                            .productName("Dragon Quest III")
                            .productSalePrice(29.99)
                            .productDescription("Embark on an epic RPG journey in this enhanced version of the classic game.")
                            .genre("RPG")
                            .productQuantity(5)
                            .console(GameBoyColor)
                            .build();
                    productList.add(DragonQuestIII);

                    Product PokemonRuby = Product.builder()
                            .productName("Pokemon Ruby")
                            .productSalePrice(39.99)
                            .productDescription("Explore the Hoenn region and battle Team Magma in this RPG adventure.")
                            .genre("RPG")
                            .productQuantity(8)
                            .console(GameBoyAdvance)
                            .build();
                    productList.add(PokemonRuby);

                    Product PokemonSapphire = Product.builder()
                            .productName("Pokemon Sapphire")
                            .productSalePrice(39.99)
                            .productDescription("Discover the mysteries of the Hoenn region and battle Team Aqua.")
                            .genre("RPG")
                            .productQuantity(7)
                            .console(GameBoyAdvance)
                            .build();
                    productList.add(PokemonSapphire);

                    Product TheLegendOfZeldaMinishCap = Product.builder()
                            .productName("The Legend of Zelda: The Minish Cap")
                            .productSalePrice(34.99)
                            .productDescription("Shrink to tiny sizes and save Hyrule in this unique Zelda adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(GameBoyAdvance)
                            .build();
                    productList.add(TheLegendOfZeldaMinishCap);

                    Product MarioKartSuperCircuit = Product.builder()
                            .productName("Mario Kart: Super Circuit")
                            .productSalePrice(29.99)
                            .productDescription("Race with your favorite characters in this handheld Mario Kart classic.")
                            .genre("Racing")
                            .productQuantity(9)
                            .console(GameBoyAdvance)
                            .build();
                    productList.add(MarioKartSuperCircuit);

                    Product MetroidFusion = Product.builder()
                            .productName("Metroid Fusion")
                            .productSalePrice(34.99)
                            .productDescription("Help Samus Aran uncover the mystery of the X Parasites in this sci-fi adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(5)
                            .console(GameBoyAdvance)
                            .build();
                    productList.add(MetroidFusion);

                    Product AdvanceWars = Product.builder()
                            .productName("Advance Wars")
                            .productSalePrice(29.99)
                            .productDescription("Lead your army to victory in this strategic turn-based warfare game.")
                            .genre("Strategy")
                            .productQuantity(7)
                            .console(GameBoyAdvance)
                            .build();
                    productList.add(AdvanceWars);

                    Product FireEmblem = Product.builder()
                            .productName("Fire Emblem")
                            .productSalePrice(34.99)
                            .productDescription("Command your units and experience a gripping tale in this tactical RPG.")
                            .genre("Tactical RPG")
                            .productQuantity(6)
                            .console(GameBoyAdvance)
                            .build();
                    productList.add(FireEmblem);

                    Product WarioWareInc = Product.builder()
                            .productName("WarioWare, Inc.: Mega Microgames!")
                            .productSalePrice(24.99)
                            .productDescription("Enjoy fast-paced, quirky microgames with Wario and friends.")
                            .genre("Party")
                            .productQuantity(8)
                            .console(GameBoyAdvance)
                            .build();
                    productList.add(WarioWareInc);

                    Product GoldenSun = Product.builder()
                            .productName("Golden Sun")
                            .productSalePrice(34.99)
                            .productDescription("Embark on a classic RPG adventure to save the world from alchemy’s power.")
                            .genre("RPG")
                            .productQuantity(5)
                            .console(GameBoyAdvance)
                            .build();
                    productList.add(GoldenSun);

                    Product PokemonFireRed = Product.builder()
                            .productName("Pokemon FireRed")
                            .productSalePrice(39.99)
                            .productDescription("Relive the classic Pokemon Red adventure with updated graphics and features.")
                            .genre("RPG")
                            .productQuantity(8)
                            .console(GameBoyAdvanceSP)
                            .build();
                    productList.add(PokemonFireRed);

                    Product PokemonLeafGreen = Product.builder()
                            .productName("Pokemon LeafGreen")
                            .productSalePrice(39.99)
                            .productDescription("Explore the Kanto region in this enhanced remake of Pokemon Green.")
                            .genre("RPG")
                            .productQuantity(7)
                            .console(GameBoyAdvanceSP)
                            .build();
                    productList.add(PokemonLeafGreen);

                    Product TheLegendOfZeldaFourSwords = Product.builder()
                            .productName("The Legend of Zelda: A Link to the Past & Four Swords")
                            .productSalePrice(34.99)
                            .productDescription("Experience the classic adventure and a new cooperative multiplayer mode.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(GameBoyAdvanceSP)
                            .build();
                    productList.add(TheLegendOfZeldaFourSwords);

                    Product SuperMarioAdvance4 = Product.builder()
                            .productName("Super Mario Advance 4: Super Mario Bros. 3")
                            .productSalePrice(29.99)
                            .productDescription("Enjoy one of the greatest platformers of all time on the GameBoy Advance SP.")
                            .genre("Platformer")
                            .productQuantity(9)
                            .console(GameBoyAdvanceSP)
                            .build();
                    productList.add(SuperMarioAdvance4);

                    Product MetroidZeroMission = Product.builder()
                            .productName("Metroid: Zero Mission")
                            .productSalePrice(34.99)
                            .productDescription("Revisit Samus Aran's first mission with enhanced graphics and gameplay.")
                            .genre("Action-Adventure")
                            .productQuantity(5)
                            .console(GameBoyAdvanceSP)
                            .build();
                    productList.add(MetroidZeroMission);

                    Product MarioVsDonkeyKong = Product.builder()
                            .productName("Mario vs. Donkey Kong")
                            .productSalePrice(24.99)
                            .productDescription("Help Mario retrieve stolen toys in this puzzle-platforming adventure.")
                            .genre("Puzzle-Platformer")
                            .productQuantity(7)
                            .console(GameBoyAdvanceSP)
                            .build();
                    productList.add(MarioVsDonkeyKong);

                    Product KirbyAndTheAmazingMirror = Product.builder()
                            .productName("Kirby & The Amazing Mirror")
                            .productSalePrice(29.99)
                            .productDescription("Explore a sprawling, interconnected world with Kirby and his clones.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(GameBoyAdvanceSP)
                            .build();
                    productList.add(KirbyAndTheAmazingMirror);

                    Product FinalFantasyVIAdvance = Product.builder()
                            .productName("Final Fantasy VI Advance")
                            .productSalePrice(34.99)
                            .productDescription("Rediscover the classic RPG with enhanced features and a new translation.")
                            .genre("RPG")
                            .productQuantity(5)
                            .console(GameBoyAdvanceSP)
                            .build();
                    productList.add(FinalFantasyVIAdvance);

                    Product CastlevaniaAriaOfSorrow = Product.builder()
                            .productName("Castlevania: Aria of Sorrow")
                            .productSalePrice(34.99)
                            .productDescription("Join Soma Cruz in this gothic action-adventure with RPG elements.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(GameBoyAdvanceSP)
                            .build();
                    productList.add(CastlevaniaAriaOfSorrow);

                    Product PokemonDiamond = Product.builder()
                            .productName("Pokemon Diamond")
                            .productSalePrice(39.99)
                            .productDescription("Explore the Sinnoh region and uncover the mystery of Dialga.")
                            .genre("RPG")
                            .productQuantity(8)
                            .console(DS)
                            .build();
                    productList.add(PokemonDiamond);

                    Product PokemonPearl = Product.builder()
                            .productName("Pokemon Pearl")
                            .productSalePrice(39.99)
                            .productDescription("Journey through the Sinnoh region and encounter the legendary Palkia.")
                            .genre("RPG")
                            .productQuantity(7)
                            .console(DS)
                            .build();
                    productList.add(PokemonPearl);

                    Product NewSuperMarioBros = Product.builder()
                            .productName("New Super Mario Bros.")
                            .productSalePrice(34.99)
                            .productDescription("Join Mario in this modern reimagining of classic platforming gameplay.")
                            .genre("Platformer")
                            .productQuantity(9)
                            .console(DS)
                            .build();
                    productList.add(NewSuperMarioBros);

                    Product TheLegendOfZeldaPhantomHourglass = Product.builder()
                            .productName("The Legend of Zelda: Phantom Hourglass")
                            .productSalePrice(39.99)
                            .productDescription("Set sail in this touch-controlled adventure and save Tetra.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(DS)
                            .build();
                    productList.add(TheLegendOfZeldaPhantomHourglass);

                    Product MarioKartDS = Product.builder()
                            .productName("Mario Kart DS")
                            .productSalePrice(34.99)
                            .productDescription("Race with your favorite characters and challenge friends wirelessly.")
                            .genre("Racing")
                            .productQuantity(8)
                            .console(DS)
                            .build();
                    productList.add(MarioKartDS);

                    Product AnimalCrossingWildWorld = Product.builder()
                            .productName("Animal Crossing: Wild World")
                            .productSalePrice(29.99)
                            .productDescription("Create your dream village and connect with friends in this life simulation game.")
                            .genre("Simulation")
                            .productQuantity(7)
                            .console(DS)
                            .build();
                    productList.add(AnimalCrossingWildWorld);

                    Product BrainAge = Product.builder()
                            .productName("Brain Age: Train Your Brain in Minutes a Day!")
                            .productSalePrice(19.99)
                            .productDescription("Sharpen your mind with puzzles, math, and memory games.")
                            .genre("Puzzle")
                            .productQuantity(10)
                            .console(DS)
                            .build();
                    productList.add(BrainAge);

                    Product ProfessorLaytonCuriousVillage = Product.builder()
                            .productName("Professor Layton and the Curious Village")
                            .productSalePrice(29.99)
                            .productDescription("Solve puzzles and uncover the secrets of a mysterious village.")
                            .genre("Puzzle-Adventure")
                            .productQuantity(6)
                            .console(DS)
                            .build();
                    productList.add(ProfessorLaytonCuriousVillage);

                    Product CastlevaniaDawnOfSorrow = Product.builder()
                            .productName("Castlevania: Dawn of Sorrow")
                            .productSalePrice(34.99)
                            .productDescription("Join Soma Cruz in this gothic action-adventure RPG sequel.")
                            .genre("Action-Adventure")
                            .productQuantity(5)
                            .console(DS)
                            .build();
                    productList.add(CastlevaniaDawnOfSorrow);

                    Product PokemonBlack = Product.builder()
                            .productName("Pokemon Black")
                            .productSalePrice(39.99)
                            .productDescription("Explore the Unova region and battle Team Plasma in this RPG adventure.")
                            .genre("RPG")
                            .productQuantity(8)
                            .console(DSi)
                            .build();
                    productList.add(PokemonBlack);

                    Product PokemonWhite = Product.builder()
                            .productName("Pokemon White")
                            .productSalePrice(39.99)
                            .productDescription("Embark on an epic journey in the Unova region and uncover the secrets of Reshiram.")
                            .genre("RPG")
                            .productQuantity(7)
                            .console(DSi)
                            .build();
                    productList.add(PokemonWhite);

                    Product TheLegendOfZeldaSpiritTracks = Product.builder()
                            .productName("The Legend of Zelda: Spirit Tracks")
                            .productSalePrice(34.99)
                            .productDescription("Drive a magical train and save Hyrule in this touch-controlled adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(DSi)
                            .build();
                    productList.add(TheLegendOfZeldaSpiritTracks);

                    Product MarioVsDonkeyKongMinisMarchAgain = Product.builder()
                            .productName("Mario vs. Donkey Kong: Minis March Again!")
                            .productSalePrice(19.99)
                            .productDescription("Guide Minis through challenging puzzles to stop Donkey Kong's mischief.")
                            .genre("Puzzle-Platformer")
                            .productQuantity(9)
                            .console(DSi)
                            .build();
                    productList.add(MarioVsDonkeyKongMinisMarchAgain);

                    Product FlipnoteStudio = Product.builder()
                            .productName("Flipnote Studio")
                            .productSalePrice(14.99)
                            .productDescription("Create your own animated flipnotes and share them with others.")
                            .genre("Creative")
                            .productQuantity(10)
                            .console(DSi)
                            .build();
                    productList.add(FlipnoteStudio);

                    Product WarioWareSnapped = Product.builder()
                            .productName("WarioWare: Snapped!")
                            .productSalePrice(14.99)
                            .productDescription("Use the DSi camera to interact with quirky microgames.")
                            .genre("Party")
                            .productQuantity(8)
                            .console(DSi)
                            .build();
                    productList.add(WarioWareSnapped);

                    Product BrainAge2 = Product.builder()
                            .productName("Brain Age 2: More Training in Minutes a Day!")
                            .productSalePrice(19.99)
                            .productDescription("Continue sharpening your mind with new puzzles and activities.")
                            .genre("Puzzle")
                            .productQuantity(10)
                            .console(DSi)
                            .build();
                    productList.add(BrainAge2);

                    Product ArtAcademy = Product.builder()
                            .productName("Art Academy")
                            .productSalePrice(24.99)
                            .productDescription("Learn to draw and paint with step-by-step lessons on your DSi.")
                            .genre("Creative")
                            .productQuantity(7)
                            .console(DSi)
                            .build();
                    productList.add(ArtAcademy);

                    Product PhotoDojo = Product.builder()
                            .productName("Photo Dojo")
                            .productSalePrice(9.99)
                            .productDescription("Create your own characters and battle in this fun, photo-based fighting game.")
                            .genre("Fighting")
                            .productQuantity(9)
                            .console(DSi)
                            .build();
                    productList.add(PhotoDojo);

                    Product PokemonX = Product.builder()
                            .productName("Pokemon X")
                            .productSalePrice(39.99)
                            .productDescription("Explore the Kalos region and uncover the secrets of Mega Evolution.")
                            .genre("RPG")
                            .productQuantity(8)
                            .console(DS3D)
                            .build();
                    productList.add(PokemonX);

                    Product PokemonY = Product.builder()
                            .productName("Pokemon Y")
                            .productSalePrice(39.99)
                            .productDescription("Discover the beauty of the Kalos region and battle to become Champion.")
                            .genre("RPG")
                            .productQuantity(7)
                            .console(DS3D)
                            .build();
                    productList.add(PokemonY);

                    Product TheLegendOfZeldaOcarinaOfTime3D = Product.builder()
                            .productName("The Legend of Zelda: Ocarina of Time 3D")
                            .productSalePrice(34.99)
                            .productDescription("Relive Link's legendary adventure with updated 3D graphics.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(DS3D)
                            .build();
                    productList.add(TheLegendOfZeldaOcarinaOfTime3D);

                    Product SuperMario3DLand = Product.builder()
                            .productName("Super Mario 3D Land")
                            .productSalePrice(34.99)
                            .productDescription("Join Mario in a 3D platforming adventure to rescue Princess Peach.")
                            .genre("Platformer")
                            .productQuantity(9)
                            .console(DS3D)
                            .build();
                    productList.add(SuperMario3DLand);

                    Product MarioKart7 = Product.builder()
                            .productName("Mario Kart 7")
                            .productSalePrice(34.99)
                            .productDescription("Race underwater, in the air, and across classic tracks with friends.")
                            .genre("Racing")
                            .productQuantity(8)
                            .console(DS3D)
                            .build();
                    productList.add(MarioKart7);

                    Product AnimalCrossingNewLeaf = Product.builder()
                            .productName("Animal Crossing: New Leaf")
                            .productSalePrice(29.99)
                            .productDescription("Build your dream village as the mayor in this charming life simulation game.")
                            .genre("Simulation")
                            .productQuantity(7)
                            .console(DS3D)
                            .build();
                    productList.add(AnimalCrossingNewLeaf);

                    Product FireEmblemAwakening = Product.builder()
                            .productName("Fire Emblem: Awakening")
                            .productSalePrice(39.99)
                            .productDescription("Lead Chrom and his army to save Ylisse in this tactical RPG masterpiece.")
                            .genre("Tactical RPG")
                            .productQuantity(6)
                            .console(DS3D)
                            .build();
                    productList.add(FireEmblemAwakening);

                    Product LuigiMansionDarkMoon = Product.builder()
                            .productName("Luigi's Mansion: Dark Moon")
                            .productSalePrice(34.99)
                            .productDescription("Help Luigi capture ghosts and solve puzzles in multiple haunted mansions.")
                            .genre("Action-Adventure")
                            .productQuantity(5)
                            .console(DS3D)
                            .build();
                    productList.add(LuigiMansionDarkMoon);

                    Product KirbyTripleDeluxe = Product.builder()
                            .productName("Kirby: Triple Deluxe")
                            .productSalePrice(29.99)
                            .productDescription("Guide Kirby through colorful worlds in this delightful platformer.")
                            .genre("Platformer")
                            .productQuantity(7)
                            .console(DS3D)
                            .build();
                    productList.add(KirbyTripleDeluxe);

                    Product XenobladeChronicles3D = Product.builder()
                            .productName("Xenoblade Chronicles 3D")
                            .productSalePrice(39.99)
                            .productDescription("Embark on a vast RPG adventure in this New3DS-exclusive port of the Wii classic.")
                            .genre("RPG")
                            .productQuantity(8)
                            .console(New3DS)
                            .build();
                    productList.add(XenobladeChronicles3D);

                    Product TheLegendOfZeldaMajorasMask3D = Product.builder()
                            .productName("The Legend of Zelda: Majora's Mask 3D")
                            .productSalePrice(34.99)
                            .productDescription("Relive Link's eerie adventure to save Termina from the falling moon.")
                            .genre("Action-Adventure")
                            .productQuantity(7)
                            .console(New3DS)
                            .build();
                    productList.add(TheLegendOfZeldaMajorasMask3D);

                    Product FireEmblemFates = Product.builder()
                            .productName("Fire Emblem Fates")
                            .productSalePrice(39.99)
                            .productDescription("Choose your path and lead your army in this epic tactical RPG.")
                            .genre("Tactical RPG")
                            .productQuantity(6)
                            .console(New3DS)
                            .build();
                    productList.add(FireEmblemFates);

                    Product SuperMarioMaker3DS = Product.builder()
                            .productName("Super Mario Maker for Nintendo 3DS")
                            .productSalePrice(34.99)
                            .productDescription("Create and play custom Mario levels on the go.")
                            .genre("Platformer")
                            .productQuantity(9)
                            .console(New3DS)
                            .build();
                    productList.add(SuperMarioMaker3DS);

                    Product PokemonSun = Product.builder()
                            .productName("Pokemon Sun")
                            .productSalePrice(39.99)
                            .productDescription("Explore the Alola region and uncover the mysteries of the legendary Solgaleo.")
                            .genre("RPG")
                            .productQuantity(8)
                            .console(New3DS)
                            .build();
                    productList.add(PokemonSun);

                    Product PokemonMoon = Product.builder()
                            .productName("Pokemon Moon")
                            .productSalePrice(39.99)
                            .productDescription("Embark on an island-hopping adventure in the Alola region with Lunala.")
                            .genre("RPG")
                            .productQuantity(7)
                            .console(New3DS)
                            .build();
                    productList.add(PokemonMoon);

                    Product MonsterHunterGenerations = Product.builder()
                            .productName("Monster Hunter Generations")
                            .productSalePrice(34.99)
                            .productDescription("Hunt massive monsters and craft powerful gear in this action-packed RPG.")
                            .genre("Action-RPG")
                            .productQuantity(6)
                            .console(New3DS)
                            .build();
                    productList.add(MonsterHunterGenerations);

                    Product MetroidSamusReturns = Product.builder()
                            .productName("Metroid: Samus Returns")
                            .productSalePrice(39.99)
                            .productDescription("Help Samus Aran take on the Metroid menace in this reimagined classic.")
                            .genre("Action-Adventure")
                            .productQuantity(5)
                            .console(New3DS)
                            .build();
                    productList.add(MetroidSamusReturns);

                    Product HyruleWarriorsLegends = Product.builder()
                            .productName("Hyrule Warriors: Legends")
                            .productSalePrice(34.99)
                            .productDescription("Battle hordes of enemies with Zelda characters in this action-packed spin-off.")
                            .genre("Action")
                            .productQuantity(7)
                            .console(New3DS)
                            .build();
                    productList.add(HyruleWarriorsLegends);

                    Product HaloCombatEvolved = Product.builder()
                            .productName("Halo: Combat Evolved")
                            .productSalePrice(29.99)
                            .productDescription("Step into the armor of Master Chief and save humanity from the Covenant.")
                            .genre("Shooter")
                            .productQuantity(8)
                            .console(Xbox)
                            .build();
                    productList.add(HaloCombatEvolved);

                    Product Fable = Product.builder()
                            .productName("Fable")
                            .productSalePrice(24.99)
                            .productDescription("Forge your own path in this action-RPG set in the world of Albion.")
                            .genre("Action-RPG")
                            .productQuantity(7)
                            .console(Xbox)
                            .build();
                    productList.add(Fable);

                    Product TheElderScrollsMorrowind = Product.builder()
                            .productName("The Elder Scrolls III: Morrowind")
                            .productSalePrice(34.99)
                            .productDescription("Explore the vast and immersive world of Morrowind in this RPG classic.")
                            .genre("RPG")
                            .productQuantity(6)
                            .console(Xbox)
                            .build();
                    productList.add(TheElderScrollsMorrowind);

                    Product StarWarsKnightsOfTheOldRepublic = Product.builder()
                            .productName("Star Wars: Knights of the Old Republic")
                            .productSalePrice(34.99)
                            .productDescription("Decide your destiny in this critically acclaimed Star Wars RPG.")
                            .genre("RPG")
                            .productQuantity(9)
                            .console(Xbox)
                            .build();
                    productList.add(StarWarsKnightsOfTheOldRepublic);

                    Product ForzaMotorsport = Product.builder()
                            .productName("Forza Motorsport")
                            .productSalePrice(29.99)
                            .productDescription("Experience high-speed thrills and realistic racing on the Xbox.")
                            .genre("Racing")
                            .productQuantity(8)
                            .console(Xbox)
                            .build();
                    productList.add(ForzaMotorsport);

                    Product NinjaGaidenBlack = Product.builder()
                            .productName("Ninja Gaiden Black")
                            .productSalePrice(34.99)
                            .productDescription("Master ninja skills in this challenging and action-packed adventure.")
                            .genre("Action")
                            .productQuantity(7)
                            .console(Xbox)
                            .build();
                    productList.add(NinjaGaidenBlack);

                    Product Doom3 = Product.builder()
                            .productName("Doom 3")
                            .productSalePrice(24.99)
                            .productDescription("Survive the horrors of a Martian research facility overrun by demons.")
                            .genre("Shooter")
                            .productQuantity(6)
                            .console(Xbox)
                            .build();
                    productList.add(Doom3);

                    Product JadeEmpire = Product.builder()
                            .productName("Jade Empire")
                            .productSalePrice(29.99)
                            .productDescription("Unleash martial arts skills in this action-RPG set in a mythical world.")
                            .genre("Action-RPG")
                            .productQuantity(8)
                            .console(Xbox)
                            .build();
                    productList.add(JadeEmpire);

                    Product Burnout3Takedown = Product.builder()
                            .productName("Burnout 3: Takedown")
                            .productSalePrice(24.99)
                            .productDescription("Crash, smash, and speed your way to victory in this arcade racing game.")
                            .genre("Racing")
                            .productQuantity(9)
                            .console(Xbox)
                            .build();
                    productList.add(Burnout3Takedown);

                    Product Halo3 = Product.builder()
                            .productName("Halo 3")
                            .productSalePrice(39.99)
                            .productDescription("Finish the fight and save humanity in this epic first-person shooter.")
                            .genre("Shooter")
                            .productQuantity(8)
                            .console(Xbox360)
                            .build();
                    productList.add(Halo3);

                    Product GearsOfWar = Product.builder()
                            .productName("Gears of War")
                            .productSalePrice(34.99)
                            .productDescription("Battle the Locust Horde in this groundbreaking third-person shooter.")
                            .genre("Shooter")
                            .productQuantity(7)
                            .console(Xbox360)
                            .build();
                    productList.add(GearsOfWar);

                    Product TheElderScrollsSkyrim = Product.builder()
                            .productName("The Elder Scrolls V: Skyrim")
                            .productSalePrice(39.99)
                            .productDescription("Embark on an epic RPG adventure in the open world of Tamriel.")
                            .genre("RPG")
                            .productQuantity(9)
                            .console(Xbox360)
                            .build();
                    productList.add(TheElderScrollsSkyrim);

                    Product GrandTheftAutoV = Product.builder()
                            .productName("Grand Theft Auto V")
                            .productSalePrice(49.99)
                            .productDescription("Explore Los Santos in this open-world action-adventure masterpiece.")
                            .genre("Action-Adventure")
                            .productQuantity(8)
                            .console(Xbox360)
                            .build();
                    productList.add(GrandTheftAutoV);

                    Product ForzaHorizon = Product.builder()
                            .productName("Forza Horizon")
                            .productSalePrice(34.99)
                            .productDescription("Experience open-road racing and festival vibes in this dynamic racer.")
                            .genre("Racing")
                            .productQuantity(7)
                            .console(Xbox360)
                            .build();
                    productList.add(ForzaHorizon);

                    Product BioShock = Product.builder()
                            .productName("BioShock")
                            .productSalePrice(29.99)
                            .productDescription("Uncover the secrets of the underwater city of Rapture in this iconic FPS.")
                            .genre("Shooter")
                            .productQuantity(6)
                            .console(Xbox360)
                            .build();
                    productList.add(BioShock);

                    Product RedDeadRedemption360 = Product.builder()
                            .productName("Red Dead Redemption")
                            .productSalePrice(39.99)
                            .productDescription("Explore the Wild West in this critically acclaimed open-world adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(8)
                            .console(Xbox360)
                            .build();
                    productList.add(RedDeadRedemption360);

                    Product MassEffect = Product.builder()
                            .productName("Mass Effect")
                            .productSalePrice(29.99)
                            .productDescription("Embark on an epic sci-fi journey to save the galaxy in this RPG classic.")
                            .genre("RPG")
                            .productQuantity(7)
                            .console(Xbox360)
                            .build();
                    productList.add(MassEffect);

                    Product AssassinCreedII = Product.builder()
                            .productName("Assassin's Creed II")
                            .productSalePrice(29.99)
                            .productDescription("Step into the shoes of Ezio Auditore and uncover a conspiracy in Renaissance Italy.")
                            .genre("Action-Adventure")
                            .productQuantity(8)
                            .console(Xbox360)
                            .build();
                    productList.add(AssassinCreedII);

                    Product Halo5Guardians = Product.builder()
                            .productName("Halo 5: Guardians")
                            .productSalePrice(49.99)
                            .productDescription("Lead Spartan Locke and Master Chief in a galaxy-spanning adventure.")
                            .genre("Shooter")
                            .productQuantity(8)
                            .console(XboxOne)
                            .build();
                    productList.add(Halo5Guardians);

                    Product GearsOfWar4 = Product.builder()
                            .productName("Gears of War 4")
                            .productSalePrice(39.99)
                            .productDescription("Battle a new enemy with JD Fenix and his crew in this action-packed sequel.")
                            .genre("Shooter")
                            .productQuantity(7)
                            .console(XboxOne)
                            .build();
                    productList.add(GearsOfWar4);

                    Product TheWitcher3WildHunt = Product.builder()
                            .productName("The Witcher 3: Wild Hunt")
                            .productSalePrice(39.99)
                            .productDescription("Join Geralt of Rivia in a sprawling RPG adventure to find Ciri and defeat the Wild Hunt.")
                            .genre("RPG")
                            .productQuantity(9)
                            .console(XboxOne)
                            .build();
                    productList.add(TheWitcher3WildHunt);

                    Product RedDeadRedemption2 = Product.builder()
                            .productName("Red Dead Redemption 2")
                            .productSalePrice(59.99)
                            .productDescription("Explore the sprawling Wild West in this critically acclaimed open-world masterpiece.")
                            .genre("Action-Adventure")
                            .productQuantity(8)
                            .console(XboxOne)
                            .build();
                    productList.add(RedDeadRedemption2);

                    Product ForzaHorizon4 = Product.builder()
                            .productName("Forza Horizon 4")
                            .productSalePrice(49.99)
                            .productDescription("Race across the seasons in a beautifully realized Britain.")
                            .genre("Racing")
                            .productQuantity(7)
                            .console(XboxOne)
                            .build();
                    productList.add(ForzaHorizon4);

                    Product SeaOfThieves = Product.builder()
                            .productName("Sea of Thieves")
                            .productSalePrice(39.99)
                            .productDescription("Sail the seas, hunt for treasure, and battle pirates in this multiplayer adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(XboxOne)
                            .build();
                    productList.add(SeaOfThieves);

                    Product Fallout4 = Product.builder()
                            .productName("Fallout 4")
                            .productSalePrice(34.99)
                            .productDescription("Rebuild the wasteland and uncover the secrets of the Commonwealth in this RPG.")
                            .genre("RPG")
                            .productQuantity(7)
                            .console(XboxOne)
                            .build();
                    productList.add(Fallout4);

                    Product AssassinCreedOrigins = Product.builder()
                            .productName("Assassin's Creed: Origins")
                            .productSalePrice(39.99)
                            .productDescription("Uncover the origins of the Brotherhood in ancient Egypt.")
                            .genre("Action-Adventure")
                            .productQuantity(8)
                            .console(XboxOne)
                            .build();
                    productList.add(AssassinCreedOrigins);

                    Product DoomEternal = Product.builder()
                            .productName("Doom Eternal")
                            .productSalePrice(49.99)
                            .productDescription("Rip and tear through hordes of demons in this action-packed FPS.")
                            .genre("Shooter")
                            .productQuantity(9)
                            .console(XboxOne)
                            .build();
                    productList.add(DoomEternal);

                    Product HaloInfinite = Product.builder()
                            .productName("Halo Infinite")
                            .productSalePrice(59.99)
                            .productDescription("Join Master Chief in a new adventure to save humanity in this epic FPS.")
                            .genre("Shooter")
                            .productQuantity(8)
                            .console(XboxSeriesX)
                            .build();
                    productList.add(HaloInfinite);

                    Product ForzaHorizon5 = Product.builder()
                            .productName("Forza Horizon 5")
                            .productSalePrice(69.99)
                            .productDescription("Race through stunning landscapes in Mexico in this ultimate racing experience.")
                            .genre("Racing")
                            .productQuantity(9)
                            .console(XboxSeriesX)
                            .build();
                    productList.add(ForzaHorizon5);

                    Product GearsTactics = Product.builder()
                            .productName("Gears Tactics")
                            .productSalePrice(49.99)
                            .productDescription("Lead your squad against the Locust Horde in this tactical turn-based strategy game.")
                            .genre("Strategy")
                            .productQuantity(7)
                            .console(XboxSeriesX)
                            .build();
                    productList.add(GearsTactics);

                    Product TheMedium = Product.builder()
                            .productName("The Medium")
                            .productSalePrice(39.99)
                            .productDescription("Explore a haunting dual-reality world in this psychological horror game.")
                            .genre("Horror")
                            .productQuantity(6)
                            .console(XboxSeriesX)
                            .build();
                    productList.add(TheMedium);

                    Product AssassinCreedValhalla = Product.builder()
                            .productName("Assassin's Creed: Valhalla")
                            .productSalePrice(59.99)
                            .productDescription("Lead Eivor in a Viking saga of conquest and exploration.")
                            .genre("Action-Adventure")
                            .productQuantity(8)
                            .console(XboxSeriesX)
                            .build();
                    productList.add(AssassinCreedValhalla);

                    Product MicrosoftFlightSimulator = Product.builder()
                            .productName("Microsoft Flight Simulator")
                            .productSalePrice(69.99)
                            .productDescription("Experience the entire world from above in this stunning flight simulator.")
                            .genre("Simulation")
                            .productQuantity(9)
                            .console(XboxSeriesX)
                            .build();
                    productList.add(MicrosoftFlightSimulator);

                    Product DoomEternalSEX = Product.builder()
                            .productName("Doom Eternal")
                            .productSalePrice(49.99)
                            .productDescription("Rip and tear through hordes of demons with next-gen enhancements.")
                            .genre("Shooter")
                            .productQuantity(7)
                            .console(XboxSeriesX)
                            .build();
                    productList.add(DoomEternalSEX);

                    Product Cyberpunk2077 = Product.builder()
                            .productName("Cyberpunk 2077")
                            .productSalePrice(59.99)
                            .productDescription("Explore the neon-lit streets of Night City in this ambitious open-world RPG.")
                            .genre("RPG")
                            .productQuantity(6)
                            .console(XboxSeriesX)
                            .build();
                    productList.add(Cyberpunk2077);

                    Product ResidentEvilVillage = Product.builder()
                            .productName("Resident Evil Village")
                            .productSalePrice(59.99)
                            .productDescription("Survive terrifying horrors in this chilling continuation of the Resident Evil saga.")
                            .genre("Horror")
                            .productQuantity(7)
                            .console(XboxSeriesX)
                            .build();
                    productList.add(ResidentEvilVillage);

                    Product SonicTheHedgehog = Product.builder()
                            .productName("Sonic the Hedgehog")
                            .productSalePrice(19.99)
                            .productDescription("Race through vibrant levels to stop Dr. Robotnik in this iconic platformer.")
                            .genre("Platformer")
                            .productQuantity(8)
                            .console(SegaMasterSystem)
                            .build();
                    productList.add(SonicTheHedgehog);

                    Product AlexKiddInMiracleWorld = Product.builder()
                            .productName("Alex Kidd in Miracle World")
                            .productSalePrice(14.99)
                            .productDescription("Join Alex Kidd on a quest to rescue his brother and defeat evil forces.")
                            .genre("Platformer")
                            .productQuantity(7)
                            .console(SegaMasterSystem)
                            .build();
                    productList.add(AlexKiddInMiracleWorld);

                    Product PhantasyStar = Product.builder()
                            .productName("Phantasy Star")
                            .productSalePrice(29.99)
                            .productDescription("Embark on an epic sci-fi RPG journey to save the Algol star system.")
                            .genre("RPG")
                            .productQuantity(6)
                            .console(SegaMasterSystem)
                            .build();
                    productList.add(PhantasyStar);

                    Product GoldenAxeWarrior = Product.builder()
                            .productName("Golden Axe Warrior")
                            .productSalePrice(24.99)
                            .productDescription("Explore a sprawling world and defeat Dark Guld in this action RPG.")
                            .genre("Action-RPG")
                            .productQuantity(7)
                            .console(SegaMasterSystem)
                            .build();
                    productList.add(GoldenAxeWarrior);

                    Product WonderBoy = Product.builder()
                            .productName("Wonder Boy")
                            .productSalePrice(19.99)
                            .productDescription("Help Wonder Boy rescue his girlfriend in this classic action-platformer.")
                            .genre("Platformer")
                            .productQuantity(8)
                            .console(SegaMasterSystem)
                            .build();
                    productList.add(WonderBoy);

                    Product Shinobi = Product.builder()
                            .productName("Shinobi")
                            .productSalePrice(24.99)
                            .productDescription("Battle as a ninja to defeat the evil Zeed organization.")
                            .genre("Action")
                            .productQuantity(6)
                            .console(SegaMasterSystem)
                            .build();
                    productList.add(Shinobi);

                    Product OutRun = Product.builder()
                            .productName("OutRun")
                            .productSalePrice(19.99)
                            .productDescription("Speed through scenic routes in this arcade racing classic.")
                            .genre("Racing")
                            .productQuantity(7)
                            .console(SegaMasterSystem)
                            .build();
                    productList.add(OutRun);

                    Product SpaceHarrier = Product.builder()
                            .productName("Space Harrier")
                            .productSalePrice(24.99)
                            .productDescription("Fly through surreal landscapes and battle enemies in this fast-paced shooter.")
                            .genre("Shooter")
                            .productQuantity(6)
                            .console(SegaMasterSystem)
                            .build();
                    productList.add(SpaceHarrier);

                    Product RType = Product.builder()
                            .productName("R-Type")
                            .productSalePrice(19.99)
                            .productDescription("Pilot your ship and defeat the Bydo Empire in this iconic shoot-'em-up.")
                            .genre("Shooter")
                            .productQuantity(8)
                            .console(SegaMasterSystem)
                            .build();
                    productList.add(RType);

                    Product SonicTheHedgehog2 = Product.builder()
                            .productName("Sonic the Hedgehog 2")
                            .productSalePrice(24.99)
                            .productDescription("Team up with Tails to stop Dr. Robotnik in this high-speed platformer.")
                            .genre("Platformer")
                            .productQuantity(8)
                            .console(SegaGenesis)
                            .build();
                    productList.add(SonicTheHedgehog2);

                    Product StreetsOfRage2 = Product.builder()
                            .productName("Streets of Rage 2")
                            .productSalePrice(29.99)
                            .productDescription("Battle thugs and save the city in this classic beat-'em-up.")
                            .genre("Action")
                            .productQuantity(7)
                            .console(SegaGenesis)
                            .build();
                    productList.add(StreetsOfRage2);

                    Product GoldenAxe = Product.builder()
                            .productName("Golden Axe")
                            .productSalePrice(19.99)
                            .productDescription("Wield swords and magic in this hack-and-slash fantasy adventure.")
                            .genre("Action")
                            .productQuantity(9)
                            .console(SegaGenesis)
                            .build();
                    productList.add(GoldenAxe);

                    Product AlteredBeast = Product.builder()
                            .productName("Altered Beast")
                            .productSalePrice(19.99)
                            .productDescription("Rise from your grave and battle mythological creatures in this arcade classic.")
                            .genre("Action")
                            .productQuantity(6)
                            .console(SegaGenesis)
                            .build();
                    productList.add(AlteredBeast);

                    Product PhantasyStarIV = Product.builder()
                            .productName("Phantasy Star IV")
                            .productSalePrice(34.99)
                            .productDescription("Save the Algol star system in this critically acclaimed RPG.")
                            .genre("RPG")
                            .productQuantity(7)
                            .console(SegaGenesis)
                            .build();
                    productList.add(PhantasyStarIV);

                    Product GunstarHeroes = Product.builder()
                            .productName("Gunstar Heroes")
                            .productSalePrice(29.99)
                            .productDescription("Blast through enemies in this fast-paced run-and-gun shooter.")
                            .genre("Shooter")
                            .productQuantity(8)
                            .console(SegaGenesis)
                            .build();
                    productList.add(GunstarHeroes);

                    Product EarthwormJim = Product.builder()
                            .productName("Earthworm Jim")
                            .productSalePrice(24.99)
                            .productDescription("Take control of a super-powered worm in this hilarious platformer.")
                            .genre("Platformer")
                            .productQuantity(7)
                            .console(SegaGenesis)
                            .build();
                    productList.add(EarthwormJim);

                    Product ShiningForce = Product.builder()
                            .productName("Shining Force")
                            .productSalePrice(29.99)
                            .productDescription("Lead your army in tactical battles to save the kingdom of Rune.")
                            .genre("Tactical RPG")
                            .productQuantity(6)
                            .console(SegaGenesis)
                            .build();
                    productList.add(ShiningForce);

                    Product MortalKombat = Product.builder()
                            .productName("Mortal Kombat")
                            .productSalePrice(19.99)
                            .productDescription("Enter the arena and test your skills in this legendary fighting game.")
                            .genre("Fighting")
                            .productQuantity(9)
                            .console(SegaGenesis)
                            .build();
                    productList.add(MortalKombat);

                    Product NightsIntoDreams = Product.builder()
                            .productName("Nights into Dreams")
                            .productSalePrice(29.99)
                            .productDescription("Fly through dreamscapes to stop nightmares in this beautiful action game.")
                            .genre("Action-Adventure")
                            .productQuantity(8)
                            .console(SegaSaturn)
                            .build();
                    productList.add(NightsIntoDreams);

                    Product VirtuaFighter2 = Product.builder()
                            .productName("Virtua Fighter 2")
                            .productSalePrice(24.99)
                            .productDescription("Master martial arts techniques in this groundbreaking 3D fighting game.")
                            .genre("Fighting")
                            .productQuantity(7)
                            .console(SegaSaturn)
                            .build();
                    productList.add(VirtuaFighter2);

                    Product PanzerDragoonSaga = Product.builder()
                            .productName("Panzer Dragoon Saga")
                            .productSalePrice(49.99)
                            .productDescription("Embark on an epic RPG adventure with your dragon in a mysterious world.")
                            .genre("RPG")
                            .productQuantity(6)
                            .console(SegaSaturn)
                            .build();
                    productList.add(PanzerDragoonSaga);

                    Product SegaRallyChampionship = Product.builder()
                            .productName("Sega Rally Championship")
                            .productSalePrice(19.99)
                            .productDescription("Race through diverse terrains in this arcade racing classic.")
                            .genre("Racing")
                            .productQuantity(8)
                            .console(SegaSaturn)
                            .build();
                    productList.add(SegaRallyChampionship);

                    Product ShiningForceIII = Product.builder()
                            .productName("Shining Force III")
                            .productSalePrice(39.99)
                            .productDescription("Lead your army in strategic battles in this critically acclaimed RPG.")
                            .genre("Tactical RPG")
                            .productQuantity(6)
                            .console(SegaSaturn)
                            .build();
                    productList.add(ShiningForceIII);

                    Product DaytonaUSA = Product.builder()
                            .productName("Daytona USA")
                            .productSalePrice(19.99)
                            .productDescription("Experience high-speed thrills in this legendary arcade racer.")
                            .genre("Racing")
                            .productQuantity(9)
                            .console(SegaSaturn)
                            .build();
                    productList.add(DaytonaUSA);

                    Product BurningRangers = Product.builder()
                            .productName("Burning Rangers")
                            .productSalePrice(34.99)
                            .productDescription("Save lives and battle fires in this futuristic action game.")
                            .genre("Action")
                            .productQuantity(7)
                            .console(SegaSaturn)
                            .build();
                    productList.add(BurningRangers);

                    Product GuardianHeroes = Product.builder()
                            .productName("Guardian Heroes")
                            .productSalePrice(29.99)
                            .productDescription("Battle through a branching storyline in this action-packed beat-'em-up.")
                            .genre("Action")
                            .productQuantity(8)
                            .console(SegaSaturn)
                            .build();
                    productList.add(GuardianHeroes);

                    Product VirtuaCop = Product.builder()
                            .productName("Virtua Cop")
                            .productSalePrice(24.99)
                            .productDescription("Take on criminals in this light-gun shooting classic.")
                            .genre("Shooter")
                            .productQuantity(7)
                            .console(SegaSaturn)
                            .build();
                    productList.add(VirtuaCop);

                    Product SonicAdventure = Product.builder()
                            .productName("Sonic Adventure")
                            .productSalePrice(29.99)
                            .productDescription("Join Sonic and friends to stop Dr. Robotnik in this fast-paced 3D adventure.")
                            .genre("Platformer")
                            .productQuantity(8)
                            .console(SegaDreamcast)
                            .build();
                    productList.add(SonicAdventure);

                    Product Shenmue = Product.builder()
                            .productName("Shenmue")
                            .productSalePrice(34.99)
                            .productDescription("Embark on a quest for revenge in this groundbreaking open-world adventure.")
                            .genre("Action-Adventure")
                            .productQuantity(6)
                            .console(SegaDreamcast)
                            .build();
                    productList.add(Shenmue);

                    Product CrazyTaxi = Product.builder()
                            .productName("Crazy Taxi")
                            .productSalePrice(19.99)
                            .productDescription("Race against time to deliver passengers in this chaotic arcade classic.")
                            .genre("Racing")
                            .productQuantity(9)
                            .console(SegaDreamcast)
                            .build();
                    productList.add(CrazyTaxi);

                    Product JetSetRadio = Product.builder()
                            .productName("Jet Set Radio")
                            .productSalePrice(24.99)
                            .productDescription("Skate, spray graffiti, and escape the cops in this vibrant action game.")
                            .genre("Action")
                            .productQuantity(7)
                            .console(SegaDreamcast)
                            .build();
                    productList.add(JetSetRadio);

                    Product SoulCalibur = Product.builder()
                            .productName("SoulCalibur")
                            .productSalePrice(29.99)
                            .productDescription("Fight in epic battles with a diverse roster of characters in this 3D fighter.")
                            .genre("Fighting")
                            .productQuantity(8)
                            .console(SegaDreamcast)
                            .build();
                    productList.add(SoulCalibur);

                    Product ResidentEvilCodeVeronica = Product.builder()
                            .productName("Resident Evil: Code Veronica")
                            .productSalePrice(34.99)
                            .productDescription("Survive the horrors of the Umbrella Corporation in this chilling survival horror.")
                            .genre("Survival Horror")
                            .productQuantity(6)
                            .console(SegaDreamcast)
                            .build();
                    productList.add(ResidentEvilCodeVeronica);

                    Product SkiesOfArcadia = Product.builder()
                            .productName("Skies of Arcadia")
                            .productSalePrice(39.99)
                            .productDescription("Sail the skies in an epic RPG filled with adventure and exploration.")
                            .genre("RPG")
                            .productQuantity(7)
                            .console(SegaDreamcast)
                            .build();
                    productList.add(SkiesOfArcadia);

                    Product MarvelVsCapcom2 = Product.builder()
                            .productName("Marvel vs. Capcom 2")
                            .productSalePrice(34.99)
                            .productDescription("Team up with iconic characters for action-packed 3-on-3 fighting battles.")
                            .genre("Fighting")
                            .productQuantity(9)
                            .console(SegaDreamcast)
                            .build();
                    productList.add(MarvelVsCapcom2);

                    Product PhantasyStarOnline = Product.builder()
                            .productName("Phantasy Star Online")
                            .productSalePrice(29.99)
                            .productDescription("Battle monsters and explore dungeons in this pioneering online RPG.")
                            .genre("RPG")
                            .productQuantity(7)
                            .console(SegaDreamcast)
                            .build();
                    productList.add(PhantasyStarOnline);

                    List<CartItem> cart = new ArrayList<>();
                    CartItem cartItem1 = CartItem.builder().cartItemId("12").name(PS3.getConsoleName()).description(PS3.getCompany()).price(PS3.getPrice()).build();
                    cart.add(cartItem1);
                    Cart cart1 =
                            Cart.builder().cartId("1")
                                    .items(new ArrayList<>())
                                    .total(0.0)
                                    .build();

                    cartRepository.save(cart1);


                    productRepository.saveAll(productList);
            }
    }
}