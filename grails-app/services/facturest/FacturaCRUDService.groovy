package facturest

import grails.transaction.Transactional

@Transactional
class FacturaCRUDService {

    def serviceMethod() {

    }

    def getItemsFactura(facturaId){
        def vCriteria = Item.createCriteria()
        def vItems = vCriteria.list{
            eq("factura.id", facturaId.toLong())
        }
        return vItems
    }

    def crearFactura(datos){
    	def factura  = new Factura()

    	//Verifica datos del cliente
    	def cliente
        if (datos.documento != null){
        	def criteriaCliente = Cliente.createCriteria();
        	def resultCliente = criteriaCliente.list{
        		eq("documento", datos.documento)
        	}
        	if (resultCliente != null && resultCliente.size() > 0){
        		cliente = resultCliente.first()
        	}else{
        		cliente = new Cliente(documento: datos.documento, nombre: datos.nombre)
        	}
        }

    	//Datos de la factura
        factura.properties = datos
        factura.cliente = cliente

    	factura.save(flush: true, failOnError: true)

    	return factura
    }


}
