import Header from './Header'
import { Outlet } from 'react-router-dom'

function Layout() {
  return (
    <>
      <Header />
      <main style={{ padding: '1rem' }}>
        <Outlet />
        <h1>Bem vindo(a) à </h1>
        <h2 className="py-4 text-4xl text-red-900">
          <span className="text-4xl font-bold py-4 text-blue-950">L.S</span>
          manutenções
        </h2>
      </main>
    </>
  )
}

export default Layout
