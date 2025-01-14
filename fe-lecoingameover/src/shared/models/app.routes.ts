import UpdateGame from "../../pages/UpdateGame";
import Users from "../../pages/Users";
import Cart from "../../pages/Cart";

export enum AppRoutes {

    ConsoleList = '/consoles',
    EditConsole = '/consoles/edit',
    AddConsole = '/consoles/add',
    Products = '/consoles/:consoleId/products',
    AddGame = '/add-game/:consoleId',
    Homepage = '/',
    UpdateGame = '/update-game/:productId',
    SingleGame = '/products/:productId',
    Users = '/users',

    Cart = '/cart',

    UserProfile = '/users/:userId'

}