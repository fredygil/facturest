package facturest


import grails.rest.*
import grails.converters.*

class FacturaController extends RestfulController {
    static responseFormats = ['json']
    def FacturaCRUDService


    FacturaController() {
        super(Factura)
    }

    def show(){
    	println "Ingresa a Show"
    	def vFactura = Factura.get(params.id)
    	respond vFactura
    }

    def save(){
    	def vFactura = FacturaCRUDService.crearFactura(params)
    	respond vFactura
    }
}
