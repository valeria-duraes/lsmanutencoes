function CreateCustomer() {
  return (
    <div className="max-w-xl mx-auto mt-10 md:mt-40 bg-white p-4 md:p-8 rounded-lg shadow-md">
      <h2 className="text-2xl md:text-5xl mb-6">Cadastrar Cliente</h2>
      <form className="w-full p-4 space-y-4 ">
        <div>
          <label className="text-2xl lg:text-base text-left block mb-1 font-semibold">
            Nome:
          </label>
          <input
            type="text"
            className="w-full border rounded px-3 py-2"
            placeholder="Nome do cliente"
          />
        </div>

        <div>
          <label className="text-2xl lg:text-base text-left block mb-1 font-semibold">
            Telefone:
          </label>
          <input
            type="text"
            className="w-full border rounded px-3 py-2"
            placeholder="Ex:. (11)99999-3333"
          />
        </div>

        <div>
          <label className="text-2xl lg:text-base text-left block mb-1 font-semibold">
            E-mail:
          </label>
          <input
            type="text"
            className="w-full border rounded px-3 py-2"
            placeholder="Ex:. teste@email.com"
          />
        </div>

        <div>
          <label className="text-2xl lg:text-base text-left block mb-1 font-semibold">
            CPF:
          </label>
          <input
            type="text"
            className="w-full border rounded px-3 py-2"
            placeholder="Ex:. 111.222.333-44"
          />
        </div>

        <button
          type="submit"
          className="w-full bg-blue-950 border text-white py-2 rounded hover:bg-blue-900 font-semibold"
        >
          Cadastrar
        </button>
      </form>
    </div>
  )
}

export default CreateCustomer
