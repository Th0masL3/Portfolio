import UpdateGame from "../../pages/UpdateGame";


export enum AppRoutes {

    ConsoleList = '/consoles',
    EditConsole = '/consoles/edit',
    AddConsole = '/consoles/add',
    Products = '/consoles/:consoleId/products',
    AddGame = '/add-game/:consoleId',
    Homepage = '/',
    UpdateGame = '/update-game/:productId'
}