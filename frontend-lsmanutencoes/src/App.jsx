import './App.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Layout from './components/Layout'
// Vamos criar estes componentes abaixo
import CustomerList from './pages/CustomerList'
import CreateCustomer from './pages/CreateCustomer'

function App() {
  return (
    <div className="min-h-screen">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout />}>
            <Route path="/clientes" index element={<CustomerList />} />
            {/* Novas rotas virão aqui depois */}
            <Route
              path="/clientes/cadastro"
              index
              element={<CreateCustomer />}
            />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App
