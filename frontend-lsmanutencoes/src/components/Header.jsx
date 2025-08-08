import { Link } from 'react-router-dom'
import { X, User } from 'lucide-react'
import { useState } from 'react'
// import CustomMenuIcon from './CustomMenuIcon'

function Header() {
  const [menuOpen, setMenuOpen] = useState(false)
  const userName = 'Lucas'
  const CustomMenuIcon = () => (
    <svg width="70" height="70" viewBox="0 0 24 24" fill="none">
      <rect x="3" y="5" width="18" height="1" rx="1" fill="black" />
      <rect x="3" y="10" width="14" height="1" rx="1" fill="black" />
      <rect x="3" y="15" width="10" height="1" rx="1" fill="black" />
    </svg>
  )

  return (
    <>
      {/* Header fixo */}
      <header className="fixed top-0 left-0 right-0 z-50 shadow p-4 bg-gray-200 flex items-center justify-between text-gray-950 rounded-lg max-w-7xl mx-auto">
        {/* Menu */}
        <button onClick={() => setMenuOpen(!menuOpen)}>
          <CustomMenuIcon className="h-6 w-10 text-gray-700"></CustomMenuIcon>
        </button>

        {/* Logo + título */}
        <div className="flex items-center justify-between gap-4">
          <img
            src="../src/assets/logoSemFundo.png"
            alt="Logo"
            className="h-24 w-auto"
          />
          <h2 className="py-4 text-4xl text-red-900">
            <span className="text-4xl font-bold py-4 text-blue-950">L.S</span>
            manutenções
          </h2>
        </div>

        {/* Direita: Usuário */}
        <div className="flex items-center gap-0.5">
          <User size={40}></User>
          <span className="hidden md:inline font-medium">Olá, {userName}</span>
        </div>

        {/* Overlay escuro */}
        {menuOpen && (
          <div
            className="fixed inset-0 bg-black opacity-40 z-40"
            onClick={() => setMenuOpen(false)}
          ></div>
        )}

        {/* Menu lateral (abre com o botão) */}
        <nav
          className={`fixed top-0 left-0 h-full w-74 bg-white shadow-lg z-50 transform transition-transform duration-300 ${
            menuOpen ? 'translate-x-0' : '-translate-x-full'
          }`}
        >
          <button
            className={`absolute top-4 right-4 text-gray-700 hover:text-red-700 transition-transform duration-300 ${
              menuOpen ? 'rotate-360' : ''
            }`}
            onClick={() => setMenuOpen(false)}
          >
            <X size={52} />
          </button>
          <div className="p-4 space-y-6 mt-20 text-lg font-semibold">
            <Link
              className="block hover:text-red-700 text-left"
              to="/clientes"
              onClick={() => setMenuOpen(false)}
            >
              Clientes
            </Link>
            <Link
              className="block hover:text-red-700 text-left"
              to="/orders"
              onClick={() => setMenuOpen(false)}
            >
              Ordens de Serviço
            </Link>
            <Link
              className="block hover:text-red-700 text-left"
              to="/users"
              onClick={() => setMenuOpen(false)}
            >
              Usuários
            </Link>
          </div>
        </nav>
      </header>
    </>
  )
}

export default Header
