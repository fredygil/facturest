package facturest


class Factura {
	String	numero
	Date    fecha
	Cliente cliente
	Long    valor
	Date    dateCreated
	Date    lastUpdated

	static hasMany = [items: Item]

	static transients = ['valor']

	def getValor(){
		return items?.sum{  it.cantidad * it.valor }
	}

}