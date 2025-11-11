import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent {
  productoForm: FormGroup;
  productosRegistrados: any[] = [];
  productoEditandoIndex: number | null = null; // Para saber si estamos editando

  constructor() {
    this.productoForm = new FormGroup({
      nombre: new FormControl('', Validators.required),
      precio: new FormControl('', [Validators.required, Validators.min(1)]),
      stock: new FormControl('', [Validators.required, Validators.min(0)])
    });
  }

  registrar() {
    if (this.productoForm.valid) {
      if (this.productoEditandoIndex !== null) {
        // Editar producto existente
        this.productosRegistrados[this.productoEditandoIndex] = this.productoForm.value;
        this.productoEditandoIndex = null;
      } else {
        // Agregar nuevo producto
        this.productosRegistrados.push(this.productoForm.value);
      }
      this.productoForm.reset();
    }
  }

  editarProducto(index: number) {
    const producto = this.productosRegistrados[index];
    this.productoForm.setValue({
      nombre: producto.nombre,
      precio: producto.precio,
      stock: producto.stock
    });
    this.productoEditandoIndex = index;
  }

  eliminarProducto(index: number) {
    this.productosRegistrados.splice(index, 1);
    if (this.productoEditandoIndex === index) {
      this.productoForm.reset();
      this.productoEditandoIndex = null;
    }
  }
}
