package facturest

class BootStrap {

    def init = { servletContext ->
    	//Se crean 3 facturas iniciales
    	new Factura(numero: "00001", fecha: new Date(), 
    		        cliente: new Cliente(documento: "10203040", nombre: "Pedro Paramox"))
    	            .addToItems(new Item(item: "Disco SSD Samsung 512 GB", cantidad: 2, valor: 600000))
    	            .addToItems(new Item(item: "Memoria DDR4 2600 Mhz x16GB", cantidad: 4, valor: 400000)).save()

    	def vCliente = new Cliente(documento: "900293512", nombre: "Soluciones de Informacion SAS", telefono: "3134956", direccion: "Cll 8 No 19-12 Of. E2",
    		email: "soporte@solinfo.com.co")

    	new Factura(numero: "00002", fecha: new Date(), cliente: vCliente)
    	            .addToItems(new Item(item: "Cable Red 15 mts", cantidad: 1, valor: 35000)).save()
    		
    	def vFactura = new Factura()
    	vFactura.numero = "00003"
    	vFactura.setFecha(new Date())
    	vFactura.setCliente(vCliente)
    	def vItem = new Item()
    	vItem.setItem("Cable HDMI x5mts")
    	vItem.setCantidad(2)
    	vItem.setValor(15000)
    	vFactura.addToItems(vItem)

    	vItem = new Item()
    	vItem.setItem("Procesador Intel Core i7 67000HQ")
    	vItem.setCantidad(1)
    	vItem.setValor(990000)
    	vFactura.addToItems(vItem)
    	vFactura.save()

    }
    def destroy = {
    }
}
