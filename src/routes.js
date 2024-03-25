import MainPage from "./pages/MainPage/MainPage";

import Registraion from './pages/ClientRoute/Registration/Registraion';

import ServiceSelection from './pages/ClientRoute/ServiceSelection/ServiceSelection';

import { MAINPAGE_ROUTER, LOGIN_ROUTER, SERVICES_ROUTER } from "./utils/const";

export const authRoutes = [
    // {
    //     path: LOGIN_ROUTER,
    //     Component: Registraion
    // },
    
]

export const publicRoutes = [
    {
        path:MAINPAGE_ROUTER,
        Component: MainPage
    },
    {
        path: LOGIN_ROUTER,
        Component: Registraion
    },

    {
        path: SERVICES_ROUTER,
        Component: ServiceSelection
    },
    
]