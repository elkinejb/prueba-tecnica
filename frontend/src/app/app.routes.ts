import { Routes } from '@angular/router';
import { VendedoresComponent } from './components/vendedores/vendedores.component';
import { VentasComponent } from './components/ventas/ventas.component';
import { ProductosComponent } from './components/productos/productos.component';
import { RegistradosComponent } from './components/registrados/registrados.component';

export const routes: Routes = [
  { path: '', redirectTo: '/productos', pathMatch: 'full' },
  { path: 'vendedores', component: VendedoresComponent },
  { path: 'ventas', component: VentasComponent },
  { path: 'productos', component: ProductosComponent },
  { path: 'registrados', component: RegistradosComponent },
];
