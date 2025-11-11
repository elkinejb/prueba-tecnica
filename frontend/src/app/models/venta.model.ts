import { Producto } from './producto.model';
import { Vendedor } from './vendedor.model';

export interface Venta {
  id: number;
  producto: Producto;
  vendedor: Vendedor;
  cantidad: number;
  total: number;
  fecha: string;
}
