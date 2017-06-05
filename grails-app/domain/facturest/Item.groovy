package facturest


class Item {
	String 	item
	Integer cantidad
	Long    valor
	Date    dateCreated
	Date    lastUpdated

	static belongsTo = [factura: Factura]
}