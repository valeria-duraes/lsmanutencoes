import { useEffect, useState } from 'react'
import axios from 'axios'

function CustomerList() {
  const [customers, setCustomers] = useState([])

  useEffect(() => {
    axios
      .get('http://localhost:8080/customers')
      .then((response) => {
        setCustomers(response.data)
      })
      .catch((error) => {
        console.error('Erro ao buscar clientes:', error)
      })
  }, [])

  return (
    <div className="overflow-x-auto p-4">
      <h2 className="text-3xl pt-32 pb-8">Clientes</h2>
      {/* <ul>
        {customers.map((customer) => (
          <li key={customer.id}>
            {customer.name} - {customer.email} - {customer.cpf}
          </li>
        ))}
      </ul> */}
      <table className="min-w-full shadow overflow-hidden rounded-lg">
        <thead className="bg-gray-800 text-white">
          <tr>
            <th className="hidden lg:table-cell text-left py-2 px-4">
              Código do cliente
            </th>
            <th className="text-left py-2 px-4 text-2xl lg:text-base">Nome</th>
            <th className="text-left py-2 px-4 text-2xl lg:text-base">
              Telefone
            </th>
            <th className="hidden lg:table-cell text-left py-2 px-4">E-mail</th>
            <th className="hidden lg:table-cell text-left py-2 px-4">CPF</th>
          </tr>
        </thead>
        <tbody>
          {customers.map((customer) => (
            <tr key={customer.id} className="hover:bg-gray-100 font-bold">
              <td className="hidden lg:table-cell text-left py-2 px-4">
                {customer.customer_code}
              </td>
              <td className="text-left py-2 px-4 text-2xl lg:text-base">
                {customer.name}
              </td>
              <td className="text-left py-2 px-4 text-2xl lg:text-base">
                {customer.phone}
              </td>
              <td className="hidden lg:table-cell text-left py-2 px-4">
                {customer.email}
              </td>
              <td className="hidden lg:table-cell text-left py-2 px-4">
                {customer.cpf}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}

export default CustomerList
