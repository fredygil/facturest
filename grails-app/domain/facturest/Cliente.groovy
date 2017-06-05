package facturest


class Cliente {
	String documento
	String nombre
	String direccion
	String telefono
	String email
	Date   dateCreated
	Date   lastUpdated

	static constraints = {
		direccion nullable: true
		telefono nullable: true
		email nullable: true
	}

}