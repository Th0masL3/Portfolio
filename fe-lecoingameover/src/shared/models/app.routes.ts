import UpdateGame from "../../pages/UpdateGame";


export enum AppRoutes {

    ConsoleList = '/consoles',
    EditConsole = '/consoles/edit',
    AddConsole = '/consoles/add',
    Products = '/consoles/:consoleId/products',
    AddGame = '/add-game/:consoleId',
    UpdateGame = '/update-game/:productId'
}