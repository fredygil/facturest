package facturest


import grails.rest.*
import grails.converters.*

class ItemController extends RestfulController {
    static responseFormats = ['json', 'xml']
    def FacturaCRUDService
    ItemController() {
        super(Item)
    }

    def itemsFactura(){
		respond FacturaCRUDService.getItemsFactura(params.facturaId)
    }

}
