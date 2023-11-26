import { BrowserRouter, Routes, Route } from "react-router-dom";

import RegisterPage from "./pages/RegisterPage.jsx";
import LoginPage from "./pages/LoginPage.jsx";

import TaskPage from "./pages/TaskPage.jsx";
import TaskFormPage from "./pages/TaskFormPage.jsx";
import ProfilePage from "./pages/ProfilePage.jsx";

import { AuthProvider } from "./context/AuthContext.jsx";

export default function App() {
    return (
        <AuthProvider>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={ <h1 className="text-4xl font-bold">Home Page</h1> } />
                    <Route path="/login" element={ <LoginPage/> } />
                    <Route path="/register" element={ <RegisterPage/> } />

                    <Route path="/tasks" element={ <TaskPage/> } />
                    <Route path="/add-task" element={ <TaskFormPage/> } />
                    <Route path="/tasks/:id" element={ <TaskFormPage/> } />
                    <Route path="/miPerfil" element={ <ProfilePage/> } />
                </Routes>
            </BrowserRouter>
        </AuthProvider>
    );
}