import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext';
import CargarPage from './pages/CargarPage';
import HomePage from './pages/HomePage';
import Navbar from './components/Navbar'
import ProductosPage from './pages/ProductosPage';


function App() {
  return (
    <AuthProvider>
      <BrowserRouter>
        <main className='container mx-auto px-10'>
        <Navbar />
          <Routes>
            <Route path='/' element={<HomePage />} />
            <Route path='/registro' element={<CargarPage />} />
            <Route path='/productos' element={<ProductosPage />} />
          </Routes>
        </main>
      </BrowserRouter>
    </AuthProvider>
  );
};

export default App;