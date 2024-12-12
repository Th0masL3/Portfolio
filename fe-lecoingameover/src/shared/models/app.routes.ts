import AddGame from "../../pages/addGame";

export enum AppRoutes {

    ConsoleList = '/consoles',
    EditConsole = '/consoles/edit',
    AddConsole = '/consoles/add',
    Products = '/consoles/:consoleId/products',
    AddGame = '/add-game/:consoleId'
}