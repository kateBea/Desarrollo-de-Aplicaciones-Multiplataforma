import { BrowserRouter, Routes, Route } from "react-router-dom";

import RegisterPage from "./pages/RegisterPage.jsx";
import LoginPage from "./pages/LoginPage.jsx";

export default function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={ <h1>Home Page</h1> } />
                <Route path="/login" element={ <LoginPage/> } />
                <Route path="/register" element={ <RegisterPage/> } />
            </Routes>
        </BrowserRouter>
    );
}