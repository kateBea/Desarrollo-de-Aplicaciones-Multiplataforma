import React from 'react'
import { BrowserRouter, Routes, Route } from "react-router-dom";

import { Provider } from './context/Context.jsx';

import HomePage from "./pages/HomePage.jsx";
import CheckPage from "./pages/CheckPage.jsx";
import RegisterProductsPage from "./pages/RegisterProductsPage.jsx";

export default function App() {
    return (
        <Provider>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<HomePage />} />
                    <Route path="/registro" element={<RegisterProductsPage />} />
                    <Route path="/productos" element={<CheckPage />} />
                </Routes>
            </BrowserRouter>
        </Provider>
    );
}