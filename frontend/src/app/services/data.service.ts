import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private productos: any[] = [];

  agregarProducto(producto: any) {
    this.productos.push(producto);
  }

  obtenerProductos() {
    return this.productos;
  }
}
